package com.app.threetier.repository.market;

import com.app.threetier.domain.market.MarketVO;
import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.mapper.MarketMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MarketDAO {
    private final MarketMapper marketMapper;

    //    제품등록
    public void register(MarketVO marketVO) {
        marketMapper.insert(marketVO);
    }

    //    제품등록여부
    public Optional<MarketVO> findByProduct(MarketVO marketVO) {
        return marketMapper.selectByProductNameAndProductNumber(marketVO);
    }

    //    제품 정보 조회
    public Optional<MarketVO> findById(Long id){
        return marketMapper.selectById(id);
    }

    //    제품 정보 수정
    public void setMember(MarketVO marketVO){
        marketMapper.update(marketVO);
    }

    //회원 탈퇴
    public void delete(Long id){
        marketMapper.delete(id);
    }
}
