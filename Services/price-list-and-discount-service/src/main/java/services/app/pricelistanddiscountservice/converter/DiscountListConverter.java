package services.app.pricelistanddiscountservice.converter;

import services.app.pricelistanddiscountservice.dto.sync.DiscountListSyncDTO;
import services.app.pricelistanddiscountservice.model.DiscountList;

public class DiscountListConverter extends AbstractConverter {

    public static DiscountList toDiscountListFromDiscountListSyncDTO(DiscountListSyncDTO discountListSyncDTO) {
        return DiscountList.builder()
                .discount(discountListSyncDTO.getDiscount())
                .dayNum(discountListSyncDTO.getDayNum())
                .build();
    }
}
