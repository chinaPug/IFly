package com.iflytek.IFly12.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("用户")
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @ApiModelProperty("用户id")
    private Integer userId;
    @ApiModelProperty("用户名")
    private String userName;
    @ApiModelProperty("用户密码")
    private String password;

    public User(String password, String userName) {
        this.password = password;
        this.userName = userName;
    }
}
