package agent.app.service.impl;

import agent.app.converter.CarCalendarTermConverter;
import agent.app.dto.car.CarCalendarTermCreateDTO;
import agent.app.dto.car.CarCalendarTermDTO;
import agent.app.dto.cct.CarCalendarTermSynchronizeDTO;
import agent.app.exception.ExistsException;
import agent.app.exception.NotFoundException;
import agent.app.model.Ad;
import agent.app.model.CarCalendarTerm;
import agent.app.repository.CarCalendarTermRepository;
import agent.app.service.intf.AdService;
import agent.app.service.intf.CarCalendarTermService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.joda.time.DateTime;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class CarCalendarTermServiceImpl implements CarCalendarTermService {

    @Autowired
    private CarCalendarTermRepository carCalendarTermRepository;

    @Autowired
    private AdService adService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public CarCalendarTerm findById(Long id) {
        return carCalendarTermRepository.findById(id).orElseThrow(() -> new NotFoundException("Termin u kalendaru ne postoji."));
    }

    @Override
    public List<CarCalendarTerm> findAll() {
        return carCalendarTermRepository.findAll();
    }

    @Override
    public CarCalendarTerm save(CarCalendarTerm carCalendarTerm) {
        if (carCalendarTerm.getId() != null) {
            if (carCalendarTermRepository.existsById(carCalendarTerm.getId())) {
                throw new ExistsException(String.format("Termin u kalendaru vec postoji."));
            }
        }
        return carCalendarTermRepository.save(carCalendarTerm);
    }

    @Override
    public void delete(CarCalendarTerm carCalendarTerm) {
        carCalendarTermRepository.delete(carCalendarTerm);
    }

    @Override
    public CarCalendarTerm edit(CarCalendarTerm carCalendarTerm) {
        this.findById(carCalendarTerm.getId());
        return carCalendarTermRepository.save(carCalendarTerm);
    }

    @Override
    public Integer deleteById(Long id) {
        CarCalendarTerm carCalendarTerm = this.findById(id);
        this.delete(carCalendarTerm);
        return 1;
    }

    @Override
    public CarCalendarTerm createCarCalendarTerm(CarCalendarTermCreateDTO carCalendarTermCreateDTO) {
        CarCalendarTerm carCalendarTerm = CarCalendarTermConverter.toCreateCarCalendarTermFromRequest(carCalendarTermCreateDTO);
        carCalendarTerm = this.save(carCalendarTerm);
        return carCalendarTerm;
    }

    @Override
    public Integer addCarCalendarTerm(CarCalendarTermDTO carCalendarTermDTO) {
        CarCalendarTerm carCalendarTerm = CarCalendarTermConverter.toCarCalendarTermFromRequest(carCalendarTermDTO);

        if (carCalendarTerm != null) {
            Ad ad = adService.findById(carCalendarTermDTO.getAdId());
            if (ad != null) {
                carCalendarTerm.setAd(ad);
                carCalendarTerm = this.save(carCalendarTerm);

                ad.getCarCalendarTerms().add(carCalendarTerm);
                ad = adService.edit(ad);
                System.out.println("usloo u if");
//                System.out.println(ad);
//                carCalendarTerm.setAd(ad);
                return 1;
            }
        }
        return 2;
    }

    @Override
    public CarCalendarTerm editCarCalendarTerm(CarCalendarTerm carCalendarTerm) {
        this.findById(carCalendarTerm.getId());
        CarCalendarTerm carCalendarTerm1 = carCalendarTermRepository.save(carCalendarTerm);
        return carCalendarTerm1;
    }

    @Override
    public List<CarCalendarTermCreateDTO> findByAdId(Long id) {
        List<CarCalendarTermCreateDTO> list = new ArrayList<>();
        Ad ad = adService.findById(id);
        if (ad != null) {
            System.out.println("naziv oglasa: " + ad.getName());
            Set<CarCalendarTerm> carCalendarTerms = ad.getCarCalendarTerms();
            for (CarCalendarTerm carCalendarTerm : carCalendarTerms) {
                CarCalendarTermCreateDTO dto = new CarCalendarTermCreateDTO();
                dto.setEndDate(carCalendarTerm.getEndDate().toString());
                dto.setStartDate(carCalendarTerm.getStartDate().toString());
                list.add(dto);
                System.out.println("termin: " + carCalendarTerm.getStartDate() + carCalendarTerm.getEndDate());
            }
        }

        return list;
    }

    @Override
    public CarCalendarTerm findByAdAndDate(Long adId, DateTime startDate, DateTime endDate) {
        return carCalendarTermRepository.findByAdAndDate(adId, startDate, endDate);
    }

    @Override
    @RabbitListener(queues = "#{autoDeleteQueueCarCalendarTerm.name}")
    public void carCalendarTermSync(String msg) {
        try {
            List<CarCalendarTermSynchronizeDTO> carCalendarTermSynchronizeDTOS = Arrays.asList(objectMapper.readValue(msg, CarCalendarTermSynchronizeDTO[].class));
            List<CarCalendarTerm> carCalendarTerms = new ArrayList<>();
            Long adMainId = null;
            for (CarCalendarTermSynchronizeDTO carCalendarTermSynchronizeDTO : carCalendarTermSynchronizeDTOS) {
                CarCalendarTerm carCalendarTerm = CarCalendarTermConverter.toCarCalendarTermFromSyncDTO(carCalendarTermSynchronizeDTO);
                Ad ad = adService.findByMainId(carCalendarTermSynchronizeDTO.getAdId());
                carCalendarTerm.setAd(ad);
                carCalendarTerms.add(carCalendarTerm);
                if (adMainId == null) {
                    adMainId = carCalendarTermSynchronizeDTO.getAdId();
                    List<CarCalendarTerm> carCalendarTerms1 = carCalendarTermRepository.findAllByAd_MainId(adMainId);
                    carCalendarTermRepository.deleteAll(carCalendarTerms1);
                }
            }
            carCalendarTermRepository.saveAll(carCalendarTerms);
            return;
        } catch (JsonProcessingException exception) {
            return;
        }
    }

    @Override
    public Boolean splitCarCalendarTerm(Long adId, DateTime startDate, DateTime endDate) {
        CarCalendarTerm carCalendarTerm = carCalendarTermRepository.findByAdAndDate(adId, startDate, endDate);
        if (carCalendarTerm == null) {
            return false;
        } else {
            CarCalendarTerm newCarCalendarTerm = CarCalendarTerm.builder()
                    .startDate(endDate)
                    .endDate(carCalendarTerm.getEndDate())
                    .ad(carCalendarTerm.getAd())
                    .build();
            carCalendarTerm.setEndDate(startDate);
            this.edit(carCalendarTerm);
            this.save(newCarCalendarTerm);
            return true;
        }
    }

    @Override
    public Boolean canSplitCarCalendarTerm(Long adId, DateTime startDate, DateTime endDate) {
        CarCalendarTerm carCalendarTerm = carCalendarTermRepository.findByAdAndDate(adId, startDate, endDate);
        if (carCalendarTerm == null) {
            return false;
        } else {
            return true;
        }
    }

}
