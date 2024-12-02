package com.app.jpa.controller;

import com.app.jpa.domain.dto.MemberDTO;
import com.app.jpa.domain.entity.Member;
import com.app.jpa.service.MemberService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/member/*")
@RequiredArgsConstructor
public class MemberController {
    @Autowired
    private final HttpSession session;

    @Autowired
    private final MemberService memberService;

    @GetMapping("join")
    public void goToJoinForm(MemberDTO memberDTO){;}

    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO);
        return new RedirectView("/member/login");
    }

    @GetMapping("login")
    public void goToLoginForm(MemberDTO memberDTO){;}

    @PostMapping("login")
    public RedirectView login(MemberDTO memberDTO){
        Member member = memberService.login(memberDTO).orElseThrow(() -> {
            throw new RuntimeException();
        });
        session.setAttribute("member", member);
        return new RedirectView("/");
    }

    @GetMapping("logout")
    public RedirectView logout(){
        session.invalidate();
        return new RedirectView("/member/login");
    }

}
