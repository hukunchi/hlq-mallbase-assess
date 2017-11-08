package com.hlq.mallbase.deploy.common;
/**
 * 
 * @时间:2017年10月23日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:响应编码对应枚举类
 */
public enum ResponseCode {
	OK(200, "系统正常"),
	NO_PERMISSION_ERROR(405, "用户没有该请求操作权限"),
	NO_MENU_TREE_PERMISSION_ERROR(406, "该用户没有菜单。"),
	NO_LOGIN_ERROR(407, "用户未登录"),
	ERROR(500, "服务错误");
	private int code;
	private String msg;
	ResponseCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
