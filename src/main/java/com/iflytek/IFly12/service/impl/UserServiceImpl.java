package com.iflytek.IFly12.service.impl;

import com.iflytek.IFly12.entity.User;
import com.iflytek.IFly12.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserByUsername(String username) {
        return null;
    }

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public Integer register(String username, String password) {
        return 0;
    }
}
