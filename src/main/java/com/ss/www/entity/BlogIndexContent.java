package com.ss.www.entity;

import java.io.Serializable;
import java.util.List;

public class BlogIndexContent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7133594507875258771L;
	private int code;
	private String info;
	private Object object;
	private Object userInfo;
	private List<Label> labelInfo;
	private List<EssayResultMap> blogInfo;

	public BlogIndexContent() {
		super();
	}

	public BlogIndexContent(int code, String info, Object object, Object userInfo, List<Label> labelInfo,
			List<EssayResultMap> blogInfo) {
		super();
		this.code = code;
		this.info = info;
		this.object = object;
		this.userInfo = userInfo;
		this.labelInfo = labelInfo;
		this.blogInfo = blogInfo;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public Object getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(Object userInfo) {
		this.userInfo = userInfo;
	}

	public List<Label> getLabelInfo() {
		return labelInfo;
	}

	public void setLabelInfo(List<Label> labelInfo) {
		this.labelInfo = labelInfo;
	}

	public List<EssayResultMap> getBlogInfo() {
		return blogInfo;
	}

	public void setBlogInfo(List<EssayResultMap> blogInfo) {
		this.blogInfo = blogInfo;
	}

	@Override
	public String toString() {
		return "BlogIndexContent [code=" + code + ", info=" + info + ", object=" + object + ", userInfo=" + userInfo
				+ ", labelInfo=" + labelInfo + ", blogInfo=" + blogInfo + "]";
	}

}
