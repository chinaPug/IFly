package com.iflytek.IFly12.service;

import com.iflytek.IFly12.entity.User;
import org.springframework.stereotype.Service;

public interface UserService {
    public User getUserByUsername(String username);

    public Integer register(String username, String password);
}
