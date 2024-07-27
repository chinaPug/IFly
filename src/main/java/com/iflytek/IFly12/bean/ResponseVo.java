package com.iflytek.IFly12.bean;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
@ApiModel("请求封装类")
@Getter
public class ResponseVo<T> {
    @ApiModelProperty("信息码")
    private Integer code;
    @ApiModelProperty("信息")
    private String msg;

    private ResponseVo() {
    }

    private T data;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    private ResponseVo(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private ResponseVo(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ResponseVo(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<>(CodeMsg.SUCCESS.getCode(), data);
    }

    public static <T> ResponseVo<T> successByMsg(T data,String msg) {
        return new ResponseVo<>(CodeMsg.SUCCESS.getCode(), msg, data);
    }

    public static <T> ResponseVo<T> errorByMsg(CodeMsg codeMsg) {
        return new ResponseVo<>(codeMsg.getCode(),codeMsg.getMsg());
    }

}

