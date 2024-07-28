package com.iflytek.IFly12.bean;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("状态码")
public class CodeMsg {
	@ApiModelProperty("信息码")
	private Integer code;
	@ApiModelProperty("信息")
	private String msg;

	private CodeMsg(Integer code,String msg){
		this.code = code;
		this.msg = msg;
	}
	
	public CodeMsg () {
		
	}
	
	public Integer getCode() {
		return code;
	}



	public void setCode(Integer code) {
		this.code = code;
	}



	public String getMsg() {
		return msg;
	}



	public void setMsg(String msg) {
		this.msg = msg;
	}

	public static CodeMsg SUCCESS = new CodeMsg(0, "success");

	//常用操作错误
	public static CodeMsg DATA_ERROR = new CodeMsg(-1, "非法数据！");
	public static CodeMsg VALIDATE_ENTITY_ERROR = new CodeMsg(-2, "");
	public static CodeMsg CPACHA_EMPTY = new CodeMsg(-3, "验证码不能为空!");
	public static CodeMsg SESSION_EXPIRED = new CodeMsg(-4, "会话已失效，请刷新页面重试！");
	public static CodeMsg CPACHA_ERROR = new CodeMsg(-5, "验证码错误！");
	public static CodeMsg USER_SESSION_EXPIRED = new CodeMsg(-6, "还未登录或会话失效，请重新登录！");
	public static CodeMsg UPLOAD_PHOTO_SUFFIX_ERROR = new CodeMsg(-7, "图片格式不正确！");
	public static CodeMsg UPLOAD_PHOTO_ERROR = new CodeMsg(-8, "图片上传失败！");
	public static CodeMsg UPLOAD_ATTACHMENT_ERROR = new CodeMsg(-9, "附件上传失败！");
	public static CodeMsg DOWNLOAD_FILE_ERROR = new CodeMsg(-10, "文件下载失败！");
	public static CodeMsg CPACHA_EXPIRE = new CodeMsg(-11, "验证码已过期，请刷新验证码！");
	public static CodeMsg SYSTEM_ERROR = new CodeMsg(-12, "系统出现了错误，请联系管理员！");
	
	//用户操作错误
	public static CodeMsg USER_NOT_FOUND = new CodeMsg(-1000, "·！");
	public static CodeMsg PASSWORD_ERROR = new CodeMsg(-1001, "密码错误！");
	public static CodeMsg USER_NAME_REPEAT = new CodeMsg(-1002, "用户名已被占用！");
	public static CodeMsg PASSWORD_REPEAT_ERROR = new CodeMsg(-1003, "密码重复输入错误！");
	//JWT操作错误
	public static CodeMsg  INVALID_SIGNATURE= new CodeMsg(-2000, "无效签名！");
	public static CodeMsg  TOKEN_EXPIRES= new CodeMsg(-2001, "token过期！");
	public static CodeMsg  INCONSISTENT_ALGORITHMS= new CodeMsg(-2002, "token算法不一致！");
	public static CodeMsg  INVALID_TOKEN= new CodeMsg(-2003, "token无效！");

	//星火模型api
	public static CodeMsg PIC_ERROR=new CodeMsg(-3000,"图片生成失败");
}
