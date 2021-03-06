package services.app.authenticationservice.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import services.app.authenticationservice.config.LocalRabbitMQConfiguration;
import services.app.authenticationservice.converter.AgentConverter;
import services.app.authenticationservice.dto.AgentFirmIdentificationDTO;
import services.app.authenticationservice.dto.EmailDTO;
import services.app.authenticationservice.dto.agent.AgentDTO;
import services.app.authenticationservice.dto.agent.AgentPageDTO;
import services.app.authenticationservice.dto.agent.AgentRegDTO;
import services.app.authenticationservice.dto.agent.AuthSyncDTO;
import services.app.authenticationservice.exception.ExistsException;
import services.app.authenticationservice.exception.NotFoundException;
import services.app.authenticationservice.model.Agent;
import services.app.authenticationservice.model.Authority;
import services.app.authenticationservice.repository.AgentRepository;
import services.app.authenticationservice.service.intf.AgentService;
import services.app.authenticationservice.service.intf.AuthorityService;
import services.app.authenticationservice.service.intf.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class AgentServiceImpl implements AgentService {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    @Qualifier(value = "cloudRabbitTemplate")
    private RabbitTemplate cloudRabbitTemplate;

    @Autowired
    @Qualifier(value = "localRabbitTemplate")
    private RabbitTemplate localRabbitTemplate;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Agent findById(Long id) {
        return agentRepository.findById(id).orElseThrow(() -> new NotFoundException("Agent sa zadatim id- em ne postoji."));
    }

    @Override
    public AgentPageDTO findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("email").ascending());
        Page<Agent> agentPage = agentRepository.findAll(pageable);
        List<AgentDTO> agentDTOList = AgentConverter.fromEntityList(new ArrayList<>(agentPage.getContent()), AgentConverter::fromAgentToAgentDTO);
        AgentPageDTO agentPageDTO = AgentPageDTO.builder()
                .agents(agentDTOList)
                .totalPageCnt(agentPage.getTotalPages())
                .build();
        return agentPageDTO;
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Override
    public Integer registerAgent(AgentRegDTO agentRegDTO) {
        if (userService.existsByEmail(agentRegDTO.getEmail())) {
            throw new ExistsException("Agent sa zadatim email-om vec postoji");
        }
        int leftLimit = 48;
        int rightLimit = 122;
        int targetStringLength = 35;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
        while (agentRepository.existsByIdentifier(generatedString)) {
            generatedString = random.ints(leftLimit, rightLimit + 1)
                    .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();
        }
        List<Authority> auths = authorityService.findByName("ROLE_AGENT");
        Agent agent = Agent.agentBuilder()
                .firstName(agentRegDTO.getFirstName())
                .lastName(agentRegDTO.getLastName())
                .deleted(false)
                .email(agentRegDTO.getEmail())
                .identifier(generatedString)
                .local(false)
                .authorities(auths)
                .password(generatedString)
                .build();
        agent = this.save(agent);
        EmailDTO emailDTO = EmailDTO.builder()
                .email(agentRegDTO.getEmail())
                .subject("Registracija na RENT-A-CAR")
                .message("Postovani,\n\n" +
                        "Registrovani ste na rent-a-car sistem!\n" +
                        "Vas jedinstveni kod za verifikaciju i pristup je (pod navodnicima):\n\n" +
                        "\"" + generatedString + "\"" + "\n\n" +
                        "Admin tim")
                .build();
        try {
            String msg = objectMapper.writeValueAsString(emailDTO);
            cloudRabbitTemplate.convertAndSend("emails", msg);
            return 1;
        } catch (JsonProcessingException exception) {
            return 2;
        }
    }

    @Override
    public Integer editAgent() {
        return null;
    }

    @Override
    public Integer logicDeleteOrRevertById(Long id, Boolean status) {
        Agent agent = this.findById(id);
        if (status) {
            agent.setDeleted(status);
            this.save(agent);
            localRabbitTemplate.convertAndSend(LocalRabbitMQConfiguration.DELETE_AD_QUEUE_NAME, agent.getId());
            localRabbitTemplate.convertAndSend(LocalRabbitMQConfiguration.DELETE_AD_SEARCH_QUEUE_NAME, agent.getId());
            return 1;
        } else {
            agent.setDeleted(status);
            this.save(agent);
            localRabbitTemplate.convertAndSend(LocalRabbitMQConfiguration.REVERT_AD_QUEUE_NAME, agent.getId());
            localRabbitTemplate.convertAndSend(LocalRabbitMQConfiguration.REVERT_AD_SEARCH_QUEUE_NAME, agent.getId());
            return 2;
        }
    }

    @Override
    public Integer deleteById(Long id) {
        Agent agent = this.findById(id);
        this.delete(agent);
        return 1;
    }

    @Override
    public void delete(Agent agent) {
        this.agentRepository.delete(agent);
    }

    @Override
    public Agent save(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    @RabbitListener(queues = LocalRabbitMQConfiguration.AUTH_SYNC_QUEUE_NAME)
    public Integer verifyAgent(String msg) {
        try {
            AuthSyncDTO authSyncDTO = objectMapper.readValue(msg, AuthSyncDTO.class);
            Agent agent = agentRepository.findByEmail(authSyncDTO.getEmail());
            if (agent == null) {
                return 2;
            }
            if (agent.getIdentifier().equals(authSyncDTO.getIdentifier())) {
                return 1;
            } else {
                return 3;
            }

        } catch (JsonProcessingException exception) {
            return 4;
        }
    }

    @Override
    @RabbitListener(queues = LocalRabbitMQConfiguration.AGENT_ID_BY_EMAIL_ID_QUEUE_NAME)
    public Long authAgent(String msg) {
        try {
            AgentFirmIdentificationDTO agentFirmIdentificationDTO = objectMapper.readValue(msg, AgentFirmIdentificationDTO.class);
            Agent agent = agentRepository.findByEmail(agentFirmIdentificationDTO.getEmail());
            if (agent == null) {
                return null;
            }
            if (agent.getIdentifier().equals(agentFirmIdentificationDTO.getIdentifier())) {
                return agent.getId();
            } else {
                return null;
            }
        } catch (JsonProcessingException exception) {
            return null;
        }
    }
}
