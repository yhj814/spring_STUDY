package com.app.threetier.service.market;

import com.app.threetier.domain.market.MarketVO;
import com.app.threetier.repository.market.MarketDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class MarketServiceImpl implements MarketService {
    private final MarketDAO marketDAO;

    @Override
    public void register(MarketVO marketVO) {
        marketDAO.register(marketVO);
    }

    @Override
    public Optional<MarketVO> found(MarketVO marketVO) {
        return marketDAO.findByProduct(marketVO);
    }

    @Override
    public Optional<MarketVO> getMarket(Long id) {
        return marketDAO.findById(id);
    }

    @Override
    public void update(MarketVO marketVO) {
        marketDAO.setMember(marketVO);
    }

    @Override
    public void delete(Long id) {marketDAO.delete(id);}
}
