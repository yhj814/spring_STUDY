package com.app.threetier.domain.market;

import lombok.*;
import org.springframework.stereotype.Component;


@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class MarketVO {
    @EqualsAndHashCode.Include
    private Long id;
    private String marketName;
    private String productName;
    private String productNumber;

    public MarketDTO toDTO(){
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setId(id);
        marketDTO.setMarketName(marketName);
        marketDTO.setProductName(productName);
        marketDTO.setProductNumber(productNumber);
        return marketDTO;

    }
}