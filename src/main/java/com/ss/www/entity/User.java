package com.ss.www.entity;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -185193640988925122L;

	private int user_Id;
	private String userName;
	private String passWord;
	private String sex;
	private Date create_Date;
	private String nick;
	private String remarks;
	private String pic;

	public User() {
		super();
	}

	public User(int user_Id, String userName, String passWord, String sex, Date create_Date, String nick,
			String remarks, String pic) {
		super();
		this.user_Id = user_Id;
		this.userName = userName;
		this.passWord = passWord;
		this.sex = sex;
		this.create_Date = create_Date;
		this.nick = nick;
		this.remarks = remarks;
		this.pic = pic;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Date getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(Date create_Date) {
		this.create_Date = create_Date;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	@Override
	public String toString() {
		return "User [user_Id=" + user_Id + ", userName=" + userName + ", passWord=" + passWord + ", sex=" + sex
				+ ", create_Date=" + create_Date + ", nick=" + nick + ", remarks=" + remarks + ", pic=" + pic + "]";
	}

}
