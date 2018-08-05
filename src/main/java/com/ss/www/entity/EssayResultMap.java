package com.ss.www.entity;

import java.io.Serializable;

public class EssayResultMap implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5878015646948618243L;
	private int blogId;
	private String userName;
	private String label;
	private String title;
	private String something;
	private String status;
	private String content;
	private String create_Date;
	private String comment;

	public EssayResultMap() {
		super();
	}

	public EssayResultMap(int blogId, String userName, String label, String title, String something, String status,
			String content, String create_Date, String comment) {
		super();
		this.blogId = blogId;
		this.userName = userName;
		this.label = label;
		this.title = title;
		this.something = something;
		this.status = status;
		this.content = content;
		this.create_Date = create_Date;
		this.comment = comment;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSomething() {
		return something;
	}

	public void setSomething(String something) {
		this.something = something;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "EssayResultMap [blogId=" + blogId + ", userName=" + userName + ", label=" + label + ", title=" + title
				+ ", something=" + something + ", status=" + status + ", content=" + content + ", create_Date="
				+ create_Date + ", comment=" + comment + "]";
	}

}
