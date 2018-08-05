package com.ss.www.entity;

import java.io.Serializable;

public class UserRoleResultMap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3141241250037577086L;
	private int id;
	private int role_Id;
	private String userName;
	private String role;
	private String create_Date;
	private String passWord;

	public UserRoleResultMap() {
		super();
	}

	public UserRoleResultMap(int id, int role_Id, String userName, String role, String create_Date, String passWord) {
		super();
		this.id = id;
		this.role_Id = role_Id;
		this.userName = userName;
		this.role = role;
		this.create_Date = create_Date;
		this.passWord = passWord;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	@Override
	public String toString() {
		return "UserRoleResultMap [id=" + id + ", role_Id=" + role_Id + ", userName=" + userName + ", role=" + role
				+ ", create_Date=" + create_Date + ", passWord=" + passWord + "]";
	}

}
