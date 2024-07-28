package com.iflytek.IFly12.service.impl;

import com.iflytek.IFly12.dao.UserMapper;
import com.iflytek.IFly12.entity.User;
import com.iflytek.IFly12.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User getUserByUsername(String username) {
        return userMapper.getUserByUserName(username);
    }

    @Override
    public Integer register(String username, String password) {
        return userMapper.addUser(new User(username,password));
    }
}
