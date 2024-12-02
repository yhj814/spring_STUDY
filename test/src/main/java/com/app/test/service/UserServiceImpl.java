package com.app.test.service;

import com.app.test.domain.UserVO;
import com.app.test.repository.UserDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Primary
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    @Override
    public void join(UserVO userVO) {
        userDAO.save(userVO);
    }
}
