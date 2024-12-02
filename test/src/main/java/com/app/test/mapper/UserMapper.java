package com.app.test.mapper;

import com.app.test.domain.UserVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
//    회원가입
    public void insert(UserVO userVO);
}
