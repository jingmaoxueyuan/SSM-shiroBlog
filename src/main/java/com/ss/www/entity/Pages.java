package com.ss.www.entity;

import java.io.Serializable;

public class Pages implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1274164536816294033L;
	private int pages;
	private int limit;

	public Pages() {
		super();
	}

	public Pages(int pages, int limit) {
		super();
		this.pages = pages;
		this.limit = limit;
	}

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
