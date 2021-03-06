package agent.app.service.impl;

import agent.app.converter.PriceListConverter;
import agent.app.dto.ad.ReversePricelistDTO;
import agent.app.dto.pricelist.PriceListCreateDTO;
import agent.app.exception.ExistsException;
import agent.app.exception.NotFoundException;
import agent.app.model.Ad;
import agent.app.model.PriceList;
import agent.app.model.PublisherUser;
import agent.app.repository.PriceListRepository;
import agent.app.service.intf.AdService;
import agent.app.service.intf.AgentService;
import agent.app.service.intf.PriceListService;
import agent.app.service.intf.PublisherUserService;
import agent.app.ws.client.AdClient;
import agent.app.ws.client.PadClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class PriceListServiceImpl implements PriceListService {

    @Autowired
    private PriceListRepository priceListRepository;

    @Autowired
    private PublisherUserService publisherUserService;

    @Autowired
    private AdService adService;

    @Autowired
    private PadClient padClient;

    @Autowired
    private AgentService agentService;

    @Autowired
    private AdClient adClient;

    @Override
    public PriceList findById(Long id) {
        return priceListRepository.findById(id).orElseThrow(() -> new NotFoundException("Cenovnik ne postoji."));
    }

    @Override
    public List<PriceList> findAll() {
        return priceListRepository.findAll();
    }

    @Override
    public List<PriceList> findAllByPublisherUser(String email) {
        return priceListRepository.findAllByPublisherUser(email);
    }

    @Override
    public List<PriceListCreateDTO> findAllListDTO() {
        return PriceListConverter.fromEntityList(this.findAll(), PriceListConverter::toCreatePriceListCreateDTOFromPriceList);
    }

    @Override
    public List<PriceListCreateDTO> findAllListDTOFromPublisher(String publisherUsername) {
        List<PriceList> priceLists = publisherUserService.findPriceListsFromPublishUser(publisherUsername);
        if (priceLists.isEmpty()) {
            return null;
        }
        List<PriceListCreateDTO> ret = priceLists.stream().map(PriceListConverter::toCreatePriceListCreateDTOFromPriceList).collect(Collectors.toList());
        return ret;
    }

    @Override
    public PriceList save(PriceList priceList) {
        if (priceList.getId() != null) {
            if (priceListRepository.existsById(priceList.getId())) {
                throw new ExistsException(String.format("Cenovnik vec postoji."));
            }
        }

        return priceListRepository.save(priceList);
    }

    @Override
    public PriceList savePriceList(PriceList priceList) {
        return priceListRepository.save(priceList);
    }

    @Override
    public void delete(PriceList priceList) {
        priceListRepository.delete(priceList);
    }

    @Override
    public PriceList createPriceList(PriceListCreateDTO priceListCreateDTO) {
        PriceList priceList = PriceListConverter.toCreatePriceListFromRequest(priceListCreateDTO);
        PublisherUser publisherUser = publisherUserService.findByEmail(priceListCreateDTO.getPublisherUsername());
        priceList.setPublisherUser(publisherUser);
        //soap

        String identifier = this.findPriceListPublisherUserIdentifier(priceListCreateDTO.getPublisherUsername());
        Long response = padClient.addPriceListRequest(priceListCreateDTO.getPublisherUsername(),
                identifier, priceList.getCreationDate(), priceList.getPricePerDay(),
                priceList.getPricePerKm(), priceList.getPricePerKmCDW());
        priceList.setMainId(response);
        System.out.println("main id: " + response);

        priceList = this.priceListRepository.save(priceList);
        return priceList;
    }

    @Override
    public Integer editPriceList(PriceList priceList) {
        PriceList priceList1 = this.findById(priceList.getId());
        Long mainId = priceList1.getMainId();
        priceList1.setPricePerDay(priceList.getPricePerDay());
        priceList1.setPricePerKm(priceList.getPricePerKm());
        priceList1.setPricePerKmCDW(priceList.getPricePerKmCDW());
        priceList1 = priceListRepository.save(priceList1);
        //soap
        String identifier = this.findPriceListPublisherUserIdentifier(priceList1.getPublisherUser().getEmail());
        Long response = padClient.editPriceListRequest(priceList1.getPublisherUser().getEmail(),
                identifier, priceList1.getPricePerDay(),
                priceList1.getPricePerKm(), priceList1.getPricePerKmCDW(), priceList1.getMainId());
        System.out.println("main id: " + response);

        return 1;
    }

    @Override
    public Integer deleteById(Long id, String publisher) {
        PriceList priceList = this.findById(id);
        List<Long> usedPricelists = this.findPricelistsFromAds(publisher);
        if (!usedPricelists.contains(id)) {
            System.out.println("ne sadrzi cenovnik mozes obrisati.");
            //soap
            String identifier = this.findPriceListPublisherUserIdentifier(priceList.getPublisherUser().getEmail());
            Long response = padClient.deletePriceListRequest(priceList.getPublisherUser().getEmail(),
                    identifier, priceList.getMainId());
            System.out.println("main id: " + response);

            this.delete(priceList);
            return 1;
        }
        System.out.println("sadrzi cenovnik ne  mozes obrisati.");
        return 2;
    }

    @Override
    public List<Long> findPricelistsFromAds(String publisher) {
        List<Long> pricelists = new ArrayList<>();
        List<Ad> ads = adService.findAllFromPublisher(publisher);
        for (Ad ad : ads) {
            if (!pricelists.contains(ad.getPriceList())) {
                pricelists.add(ad.getPriceList().getId());
                System.out.println("cenovnik:   " + ad.getPriceList().getId());
            }
        }
        return pricelists;
    }

    @Override
    public Integer reversePricelist(ReversePricelistDTO reversePricelistDTO) {
        Ad ad = adService.findById(reversePricelistDTO.getAdId());
        PriceList priceList = this.findById(reversePricelistDTO.getPricelistId());
        ad.setPriceList(priceList);
        ad = adService.edit(ad);

        //soap
        String identifier = this.findPriceListPublisherUserIdentifier(ad.getPublisherUser().getEmail());
        String response = adClient.reversePricelist(ad.getPublisherUser().getEmail(), identifier, ad.getMainId(), priceList.getMainId());

        return 1;
    }

    @Override
    public String findPriceListPublisherUserIdentifier(String email) {
        return agentService.findByEmail(email).getIdentifier();
    }


}
