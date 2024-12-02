package com.app.threetier.repository.member;

import com.app.threetier.domain.member.MemberVO;
import com.app.threetier.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberDAO {
    private final MemberMapper memberMapper;

//    회원가입
    public void save(MemberVO memberVO){
        memberMapper.insert(memberVO);
    }

//    로그인
    public Optional<MemberVO> findByMemberEmailAndMemberPassword(MemberVO memberVO){
        return memberMapper.selectByMemberEmailAndMemberPassword(memberVO);
    }

//    회원 정보 조회
    public Optional<MemberVO> findById(Long id){
        return memberMapper.selectById(id);
    }

//    회원 정보 수정
    public void setMember(MemberVO memberVO){
        memberMapper.update(memberVO);
    }

    public void delete(Long id){
        memberMapper.delete(id);
    }
}
