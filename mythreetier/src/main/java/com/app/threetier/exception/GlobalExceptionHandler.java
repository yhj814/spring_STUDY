package com.app.threetier.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.view.RedirectView;

//@ControllerAdvice 만 사용하고 @ExceptionHandler 안에 내용 넣기
@ControllerAdvice(basePackages = "com.app.threetier.controller.member")
@Slf4j
public class GlobalExceptionHandler {
//    사용할때 exception 이름 바꾸고 경로 바꾸면 사용가능
    @ExceptionHandler(LoginFailException.class)
    protected RedirectView handleLoginFailException(LoginFailException e) {
        log.info(e.getMessage());
        return new RedirectView("member/login");
    }
}
