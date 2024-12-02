package com.app.app.service.member;

import com.app.app.domain.member.MemberVO;

import java.util.Optional;

public interface MemberService {
    public void join(MemberVO memberVO);
    public Optional<MemberVO> login(MemberVO memberVO);
    public Optional<MemberVO> getMember(Long id);
    public void update(MemberVO memberVO);
    public void delete(Long id);
}
