package com.app.threetier.mapper;

import com.app.threetier.domain.market.MarketDTO;
import com.app.threetier.domain.market.MarketVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class MarketMapperTests {
    @Autowired
    private MarketMapper marketMapper;

    @Test
    public void testInsert() {
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setMarketName("정육점");
        marketDTO.setProductName("소고기");
        marketDTO.setProductNumber("1234");

        marketMapper.insert(marketDTO.toVO());
    }
    @Test
    public void testSelect() {
        MarketDTO marketDTO = new MarketDTO();
        marketDTO.setMarketName("소고기");
        marketDTO.setProductNumber("1234");

        Optional<MarketVO> foundMarket=
                marketMapper.selectByProductNameAndProductNumber(marketDTO.toVO());

        foundMarket.map(MarketVO::toString).ifPresent(log::info);
    }
}
