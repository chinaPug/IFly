package com.iflytek.IFly12.controller;

import com.iflytek.IFly12.bean.ResponseVo;
import com.iflytek.IFly12.entity.Dialogue;
import com.iflytek.IFly12.entity.Session;
import com.iflytek.IFly12.service.SessionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/session")
@Api(tags = "会话控制器")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @ApiOperation(value = "根据用户id获取会话Id列表")
    @GetMapping()
    public ResponseVo<List<Integer>> getSessionList(HttpServletRequest request) {
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        return ResponseVo.success(sessionService.getSessionIdByUserId(userId));
    }

    @ApiOperation(value = "根据会话id获取历史对话")
    @GetMapping("/dialogues")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "sessionId", value = "会话Id", dataTypeClass = Integer.class),
    })
    public ResponseVo<List<Dialogue>> getHistoryDialoguesBySessionId(@RequestParam(value = "sessionId") Integer sessionId) {
        return ResponseVo.success(sessionService.getDialoguesBySessionId(sessionId));
    }
}
