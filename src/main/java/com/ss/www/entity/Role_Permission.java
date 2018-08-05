package com.ss.www.entity;

import java.io.Serializable;

public class Role_Permission implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3436855539208128588L;

	private int p_id;
	private int permission_id;
	private int role_id;

	public Role_Permission() {
		super();
	}

	public Role_Permission(int p_id, int permission_id, int role_id) {
		super();
		this.p_id = p_id;
		this.permission_id = permission_id;
		this.role_id = role_id;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public int getPermission_id() {
		return permission_id;
	}

	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}

	public int getRole_id() {
		return role_id;
	}

	public void setRole_id(int role_id) {
		this.role_id = role_id;
	}

	@Override
	public String toString() {
		return "Role_Permission [p_id=" + p_id + ", permission_id=" + permission_id + ", role_id=" + role_id + "]";
	}

}
