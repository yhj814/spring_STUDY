package com.app.kakao.controller;

import com.app.kakao.domain.MemberDTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/member/*")
public class MemberController {
    @GetMapping("login")
    public void goToLoginForm(MemberDTO memberDTO){;}

    @GetMapping("my-page")
    public void goToMyPage(MemberDTO memberDTO){;}
}














