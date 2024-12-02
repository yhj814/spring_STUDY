package com.app.test.controller;

import com.app.test.domain.UserDTO;
import com.app.test.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/user/*")
@RequiredArgsConstructor
@Slf4j
public class UserController {
    private final UserService userService;
    private final UserDTO userDTO;

    //    회원가입페이지로 이동
    @GetMapping("join")
    public void goTOJoinForm(UserDTO userDTO, HttpSession session) {;}

//    회원가입완료
    @PostMapping("join")
    public RedirectView join(UserDTO userDTO) {
        userService.join(userDTO.toVO());
        return new RedirectView("/user/login");
    }
}
