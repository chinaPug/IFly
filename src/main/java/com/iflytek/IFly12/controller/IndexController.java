package com.iflytek.IFly12.controller;


import com.iflytek.IFly12.util.TokenUtils;
import com.iflytek.IFly12.bean.ResponseVo;
import com.iflytek.IFly12.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/index")
public class IndexController{

    @ApiOperation(value = "登录")
    @GetMapping()
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userName", value = "用户名",dataTypeClass = String.class),
            @ApiImplicitParam(name = "password", value = "密码",dataTypeClass = String.class),
    })
    public ResponseVo<String> login(@RequestParam(value = "userName") String userName, @RequestParam(value = "password") String password) {
        /**
         *
         */
        User user = new User(1,userName,password);
        String token= TokenUtils.sign(user);
        System.out.println("token:"+token);
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
        /**
         *
         */
        User user = new User(1,userName,password);
        String token= TokenUtils.sign(user);
        System.out.println("token:"+token);
        return ResponseVo.success(token);
    }
}
