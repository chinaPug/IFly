package com.iflytek.IFly12.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@ApiModel("对话")
@AllArgsConstructor
@NoArgsConstructor
public class Dialogue {
    @ApiModelProperty("问题")
    private String question;
    @ApiModelProperty("回答")
    private String ask;
}
