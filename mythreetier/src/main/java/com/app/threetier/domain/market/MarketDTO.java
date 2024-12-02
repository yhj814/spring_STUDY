package com.app.threetier.domain.market;

import lombok.*;
import org.springframework.stereotype.Component;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MarketDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String marketName;
    private String productName;
    private String productNumber;

    public MarketVO toVO() {
        return new MarketVO(id, marketName, productName, productNumber);
    }
}