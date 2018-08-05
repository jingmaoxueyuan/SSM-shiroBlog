package com.ss.www.entity.POJO;

import java.io.Serializable;
 

public class Message implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4926321373858322911L;
	public static final int SUCCESS = 100;
	public static final String SUCCESS_INFO = "³É¹¦";
	public static final int ERROR = 200;
	public static final String ERROR_INFO = "´íÎó";
	public static final int ERROR_AUTHORIZATION = 202;

	private int code;
	private String info;
	private Object object;

	public Message() {
		super();
	}

	public Message(int code, String info, Object object) {
		super();
		this.code = code;
		this.info = info;
		this.object = object;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "Message [code=" + code + ", info=" + info + ", object=" + object + "]";
	}

}
