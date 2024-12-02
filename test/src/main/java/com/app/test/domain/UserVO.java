package com.app.test.domain;

import lombok.*;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
@Getter @ToString @EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {
    @EqualsAndHashCode.Include
    private Long id;
    private String userEmail;
    private String userName;
    private String userNickName;
    private String userPhone;
    private String userPassword;

    public UserDTO toDTO() {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setUserEmail(userEmail);
        userDTO.setUserName(userName);
        userDTO.setUserNickName(userNickName);
        userDTO.setUserPhone(userPhone);
        userDTO.setUserPassword(userPassword);
        return userDTO;
    }
}
