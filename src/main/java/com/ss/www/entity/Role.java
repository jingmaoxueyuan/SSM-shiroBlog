package com.ss.www.entity;

import java.io.Serializable;

public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3466086830030193363L;
	private int role_Id;
	private String role;
	private String create_Date;

	public Role() {
		super();
	}

	public Role(int role_Id, String role, String create_Date) {
		super();
		this.role_Id = role_Id;
		this.role = role;
		this.create_Date = create_Date;
	}

	public int getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	@Override
	public String toString() {
		return "Role [role_Id=" + role_Id + ", role=" + role + ", create_Date=" + create_Date + "]";
	}

}
