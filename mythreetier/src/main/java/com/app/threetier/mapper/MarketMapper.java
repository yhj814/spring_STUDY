package com.app.threetier.mapper;

import com.app.threetier.domain.market.MarketVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface MarketMapper {
    public void insert(MarketVO marketVO);

    public Optional<MarketVO> selectByProductNameAndProductNumber(MarketVO marketVO);

    public Optional<MarketVO> selectById(Long id);

    public void update(MarketVO marketVO);

    public void delete(Long id);
}
