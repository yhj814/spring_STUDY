package com.app.test.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
public class UserDTO {
    @EqualsAndHashCode.Include
    private Long id;
    private String userEmail;
    private String userName;
    private String userNickName;
    private String userPhone;
    private String userPassword;

    public UserVO toVO(){
        return new UserVO(id, userEmail, userName, userNickName, userPhone, userPassword);
    }
}
