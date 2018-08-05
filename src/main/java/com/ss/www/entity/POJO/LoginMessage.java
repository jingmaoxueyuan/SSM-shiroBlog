package com.ss.www.entity.POJO;

import java.io.Serializable;

public class LoginMessage implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1689871469326770858L;
	public static final int SUCCESS=1;
	public static final int USER_NOT=2;
	public static final String USER_NOT_INFO="用户不存在";
	public static final int USER_PASS_ERROR=3;
	public static final String USER_PASS_ERROR_INFO="用户名或密码错误";
}
