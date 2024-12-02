package com.app.threetier.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

//오류난거 해결은 여기서 모두 하기 팀플할떄는 basePackages 사용 x
@ControllerAdvice(basePackages = "com.app.threetier.controller.member")
@Slf4j
public class GlobalExceptionHandler {
//    사용할때 오류이름 바꾸고 메소드 바꿔서 사용
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView handleLoginFailException(LoginFailException e) {
        log.error(e.getMessage());
        return new RedirectView("/member/login?status=false");
    }
}
