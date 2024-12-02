package com.app.threetier.exception;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class LoginFailException extends RuntimeException {

    public LoginFailException(String message) {
        super(message);
    }
}
