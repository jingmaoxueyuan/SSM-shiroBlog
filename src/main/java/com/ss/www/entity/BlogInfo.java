package com.ss.www.entity;

import java.io.Serializable;
import java.util.List;

public class BlogInfo<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8202583114988397050L;
	private Object object;
	private List<T> comment;

	public BlogInfo() {
		super();
	}

	public BlogInfo(Object object, List<T> comment) {
		super();
		this.object = object;
		this.comment = comment;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}

	public List<T> getComment() {
		return comment;
	}

	public void setComment(List<T> comment) {
		this.comment = comment;
	}

}
