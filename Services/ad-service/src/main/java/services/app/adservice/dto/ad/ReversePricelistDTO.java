package services.app.adservice.dto.ad;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class ReversePricelistDTO {
    private Long adId;
    private Long pricelistId;
}
