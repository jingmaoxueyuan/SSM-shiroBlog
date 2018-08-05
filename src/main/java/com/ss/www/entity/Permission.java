package com.ss.www.entity;

import java.io.Serializable;

public class Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4749299012813372961L;
	private int permission_Id;
	private String resourse;
	private String permission_info;

	public Permission() {
		super();
	}

	public Permission(int permission_Id, String resourse, String permission_info) {
		super();
		this.permission_Id = permission_Id;
		this.resourse = resourse;
		this.permission_info = permission_info;
	}

	public int getPermission_Id() {
		return permission_Id;
	}

	public void setPermission_Id(int permission_Id) {
		this.permission_Id = permission_Id;
	}

	public String getResourse() {
		return resourse;
	}

	public void setResourse(String resourse) {
		this.resourse = resourse;
	}

	public String getPermission_info() {
		return permission_info;
	}

	public void setPermission_info(String permission_info) {
		this.permission_info = permission_info;
	}

}
