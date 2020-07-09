package agent.app.service.intf;

import agent.app.dto.ad.ReversePricelistDTO;
import agent.app.dto.pricelist.PriceListCreateDTO;
import agent.app.model.PriceList;

import java.util.List;


public interface PriceListService {

    PriceList findById(Long id);

    List<PriceList> findAll();

    List<PriceList> findAllByPublisherUser(String email);

    List<PriceListCreateDTO> findAllListDTO();

    List<PriceListCreateDTO> findAllListDTOFromPublisher(String publisherUsername);

    PriceList save(PriceList priceList);

    void delete(PriceList priceList);

    PriceList createPriceList(PriceListCreateDTO priceListCreateDTO);

    Integer editPriceList(PriceList priceList);

    Integer deleteById(Long id, String publisher);

    List<Long> findPricelistsFromAds(String publisher);

    Integer reversePricelist(ReversePricelistDTO reversePricelistDTO);

}
