package services.app.pricelistanddiscountservice.service.intf;


import services.app.pricelistanddiscountservice.dto.discount.DiscountListCreateDTO;
import services.app.pricelistanddiscountservice.dto.discount.DiscountListDTO;
import services.app.pricelistanddiscountservice.model.DiscountList;

import java.util.List;

public interface DiscountListService {

    DiscountList findById(Long id);
    List<DiscountListDTO> findAll();
    List<DiscountList> findAllByAgent();
    List<DiscountListDTO> findAllByAgentDTO();
    DiscountList save(DiscountList discountList);
    void delete(DiscountList discountList);
    Integer deleteById(Long id);
    Integer edit(DiscountList discountList);
    Long syncDiscountList(String msg);
    Integer createDiscount(DiscountListCreateDTO discountListCreateDTO);
    Integer addDiscountToAd(Long discountId, Long adId);
    Integer deleteDiscountFromAd(Long discountId, Long adId);
}
