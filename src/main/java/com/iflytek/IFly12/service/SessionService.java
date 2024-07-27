package com.iflytek.IFly12.service;

import com.iflytek.IFly12.entity.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SessionService {
    public List<Session> getSessionListByUserId(Integer  UserId);
}
