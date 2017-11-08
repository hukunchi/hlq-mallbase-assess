package com.hlq.mallbase.access.controller;

import java.io.Serializable;

/**
 * Created by jeremy on 2017/8/4.
 */
public class HttpResponse<T> implements Serializable{

    /**
	 * 
	 */
	private static final long serialVersionUID = -478752254355010277L;
	
	private T data;
	private int code = 200;
    private String msg;

    
    public HttpResponse() {
		super();
	}

	public HttpResponse(T data) {
		super();
		this.data = data;
	}
	
	public HttpResponse(T data, int code, String msg) {
		super();
		this.data = data;
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
