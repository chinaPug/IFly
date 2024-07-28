package com.iflytek.IFly12.service;

import com.iflytek.IFly12.entity.Dialogue;
import com.iflytek.IFly12.entity.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SessionService {
    public List<Dialogue> getDialoguesBySessionId(Integer sessionId);
    public List<Integer> getSessionIdByUserId(Integer  userId);
    public Boolean insertSession(Session session);
}
