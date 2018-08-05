package com.ss.www.entity;

import java.io.Serializable;

public class CommentResultMap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3552909326642646245L;
	private int blog_Id;
	private String comment;
	private String create_Date;
	private String userName;

	public CommentResultMap() {
		super();
	}

	public CommentResultMap(int blog_Id, String comment, String create_Date, String userName) {
		super();
		this.blog_Id = blog_Id;
		this.comment = comment;
		this.create_Date = create_Date;
		this.userName = userName;
	}

	public int getBlog_Id() {
		return blog_Id;
	}

	public void setBlog_Id(int blog_Id) {
		this.blog_Id = blog_Id;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "CommentResultMap [blog_Id=" + blog_Id + ", comment=" + comment + ", create_Date=" + create_Date
				+ ", userName=" + userName + "]";
	}

}
