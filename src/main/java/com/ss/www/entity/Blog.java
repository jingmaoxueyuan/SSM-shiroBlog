package com.ss.www.entity;

import java.io.Serializable;

public class Blog implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6783116651230455508L;
	private int blogId;
	private String user_Id;
	private String label_Id;
	private String title;
	private String something;
	private String content;
	private String pic;
	private String create_Date;
	private String status;

	public Blog() {
		super();
	}

	public Blog(int blogId, String user_Id, String label_Id, String title, String something, String content, String pic,
			String create_Date, String status) {
		super();
		this.blogId = blogId;
		this.user_Id = user_Id;
		this.label_Id = label_Id;
		this.title = title;
		this.something = something;
		this.content = content;
		this.pic = pic;
		this.create_Date = create_Date;
		this.status = status;
	}

	public int getBlogId() {
		return blogId;
	}

	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}

	public String getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(String user_Id) {
		this.user_Id = user_Id;
	}

	public String getLabel_Id() {
		return label_Id;
	}

	public void setLabel_Id(String label_Id) {
		this.label_Id = label_Id;
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Blog [blogId=" + blogId + ", user_Id=" + user_Id + ", label_Id=" + label_Id + ", title=" + title
				+ ", something=" + something + ", content=" + content + ", pic=" + pic + ", create_Date=" + create_Date
				+ ", status=" + status + "]";
	}

}
