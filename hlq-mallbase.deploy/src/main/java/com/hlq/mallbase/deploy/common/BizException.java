package com.hlq.mallbase.deploy.common;
/**
 * @时间:2017年10月23日
 * @作者: hukc
 * @Mail:hu1932@163.com
 * @说明:自定义业务异常
 */
public class BizException extends RuntimeException {
	private static final long serialVersionUID = -8335809651793415329L;
	ResponseCode accessResponseCode;
	public BizException(ResponseCode accessResponseCode){
		super(accessResponseCode.getMsg());
		this.accessResponseCode = accessResponseCode;
	}
	public BizException(ResponseCode accessResponseCode, String msg) {
		super(msg);
		this.accessResponseCode = accessResponseCode;
	}
	public BizException(ResponseCode accessResponseCode, String msg, Throwable cause) {
		super(msg, cause);
		accessResponseCode = this.accessResponseCode;
	}
	public BizException(String msg) {
		super(msg);
	}
	public ResponseCode getAccessResponseCode() {
		return accessResponseCode;
	}
	public void setAccessResponseCode(ResponseCode accessResponseCode) {
		this.accessResponseCode = accessResponseCode;
	}
	
}
