package com.app.jpa.service;

import com.app.jpa.domain.dto.MemberDTO;
import com.app.jpa.domain.entity.Member;
import com.app.jpa.domain.type.MemberType;

import java.util.Optional;

public interface MemberService {
//    회원가입
    public void join(MemberDTO memberDTO);

//    로그인
    public Optional<Member> login(MemberDTO memberDTO);

    public default Member toEntity(MemberDTO memberDTO){
        return Member.builder()
                .memberEmail(memberDTO.getMemberEmail())
                .memberPassword(memberDTO.getMemberPassword())
                .memberAge(memberDTO.getMemberAge())
                .memberName(memberDTO.getMemberName())
                .memberType(MemberType.MEMBER)
                .build();
    }
}
