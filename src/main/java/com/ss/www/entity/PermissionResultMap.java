package com.ss.www.entity;

import java.io.Serializable;

public class PermissionResultMap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2332763123724347160L;
	private int user_Id;
	private int role_Id;
	private int permission_Id;
	private String role;
	private String resourse;

	public PermissionResultMap() {
		super();
	}

	public PermissionResultMap(int user_Id, int role_Id, int permission_Id, String role, String resourse) {
		super();
		this.user_Id = user_Id;
		this.role_Id = role_Id;
		this.permission_Id = permission_Id;
		this.role = role;
		this.resourse = resourse;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public int getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}

	public int getPermission_Id() {
		return permission_Id;
	}

	public void setPermission_Id(int permission_Id) {
		this.permission_Id = permission_Id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getResourse() {
		return resourse;
	}

	public void setResourse(String resource) {
		this.resourse = resource;
	}

	@Override
	public String toString() {
		return "PermissionMap [user_Id=" + user_Id + ", role_Id=" + role_Id + ", permission_Id=" + permission_Id
				+ ", role=" + role + ", resource=" + resourse + "]";
	}

}
