package com.iflytek.IFly12.service.impl;

import com.iflytek.IFly12.dao.SessionMapper;
import com.iflytek.IFly12.entity.Dialogue;
import com.iflytek.IFly12.entity.Session;
import com.iflytek.IFly12.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SessionServiceImpl implements SessionService {
    @Autowired
    private SessionMapper sessionMapper;

    /**
     * public List<Integer> getSessionIdByUserId(Integer userId);
     * public String getContentBySessionId(Integer sessionId);
     * public Boolean insertSession(Session session);
     * @param sessionId
     * @return
     */
    @Override
    public List<Dialogue> getDialoguesBySessionId(Integer sessionId) {
        String dialoguesJson=sessionMapper.getContentBySessionId(sessionId);
        return Session.jsonToList(dialoguesJson);
    }

    /**
     * 根据用户id返回sessionId列表
     * @param userId
     * @return
     */

    @Override
    public List<Integer> getSessionIdByUserId(Integer userId) {
        return sessionMapper.getSessionIdByUserId(userId);
    }
    @Override
    public Boolean insertSession(Session session){
        return sessionMapper.insertSession(session);
    }
}
