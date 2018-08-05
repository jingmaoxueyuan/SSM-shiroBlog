package com.ss.www.entity;

import java.io.Serializable;

public class Role_User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8838567026211394865L;
	private int id;
	private int role_id;
	private int user_id;
	private String create_Date;

	public Role_User() {
		super();
	}

	public Role_User(int id, int role_id, int user_id, String create_Date) {
		super();
		this.id = id;
		this.role_id = role_id;
		this.user_id = user_id;
		this.create_Date = create_Date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

}
