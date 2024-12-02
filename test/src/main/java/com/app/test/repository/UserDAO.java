package com.app.test.repository;

import com.app.test.domain.UserVO;
import com.app.test.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserDAO {
    private final UserMapper userMapper;

//    회원가입
    public void save(UserVO userVO) {userMapper.insert(userVO);}
}
