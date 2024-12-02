package com.app.test.mapper;

import com.app.test.domain.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserMapperTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsert() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserEmail("luj@gmail.com");
        userDTO.setUserName("이유진");
        userDTO.setUserNickName("용인남");
        userDTO.setUserPhone("01023327811");
        userDTO.setUserPassword("6666");
        userMapper.insert(userDTO.toVO());
    }
}
