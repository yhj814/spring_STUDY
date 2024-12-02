package com.app.jpa.service;

import com.app.jpa.domain.dto.MemberDTO;
import com.app.jpa.domain.entity.Member;
import com.app.jpa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(rollbackFor = Exception.class)
public class MemberServiceImpl implements MemberService {
    @Autowired
    private final MemberRepository memberRepository;

    @Override
    public void join(MemberDTO memberDTO) {
        memberRepository.save(toEntity(memberDTO));
    }

    @Override
    public Optional<Member> login(MemberDTO memberDTO) {
        return memberRepository.findByMemberEmailAndMemberPassword(memberDTO.getMemberEmail(), memberDTO.getMemberPassword());
    }
}
