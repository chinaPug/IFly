package com.iflytek.IFly12.service;

import com.iflytek.IFly12.entity.User;

public interface UserService {
    public User getUserByUsername(String username);
    public boolean login(String username, String password);
    public Integer register(String username, String password);
}
