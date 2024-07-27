package com.iflytek.IFly12.controller;


import com.iflytek.IFly12.bean.CodeMsg;
import com.iflytek.IFly12.service.UserService;
import com.iflytek.IFly12.util.TokenUtils;
import com.iflytek.IFly12.bean.ResponseVo;
import com.iflytek.IFly12.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/index")
@Api(tags = "主页控制器")
public class IndexController{
    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录")
    @GetMapping()
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名",dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码",dataTypeClass = String.class),
    })
    public ResponseVo<String> login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
        User user=userService.getUserByUsername(userName);
        if(Objects.isNull(user)){
            return ResponseVo.errorByMsg(CodeMsg.USER_NOT_FOUND);
        }
        else if(!password.equals(user.getPassword())){
            return ResponseVo.errorByMsg(CodeMsg.PASSWORD_ERROR);
        }
        String token= TokenUtils.sign(user);
        return ResponseVo.success(token);
    }

    @ApiOperation(value = "注册")
    @PostMapping()
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名", dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码", dataTypeClass = String.class),
            @ApiImplicitParam(name = "repeatPassword", value = "重复密码", dataTypeClass = String.class)
    })
    public ResponseVo<String> register(@RequestParam(value = "userName") String userName, @RequestParam(value = "password")String password, @RequestParam(value = "repeatPassword") String repeatPassword) {
        if (!password.equals(repeatPassword)) {
            return ResponseVo.errorByMsg(CodeMsg.PASSWORD_REPEAT_ERROR);
        }
        else if(!Objects.isNull(userService.getUserByUsername(userName))){
            return ResponseVo.errorByMsg(CodeMsg.USER_NAME_REPEAT);
        }
        Integer userid=userService.register(userName, password);
        String token= TokenUtils.sign(new User(userid,userName,password));
        return ResponseVo.success(token);
    }
}
