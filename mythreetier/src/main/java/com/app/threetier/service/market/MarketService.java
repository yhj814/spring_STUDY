package com.app.threetier.service.market;

import com.app.threetier.domain.market.MarketVO;

import java.util.Optional;

public interface MarketService {
    public void register(MarketVO marketVO);
    public Optional<MarketVO> found(MarketVO marketVO);
    public Optional<MarketVO> getMarket(Long id);
    public void update(MarketVO marketVO);
    public void delete(Long id);
}
