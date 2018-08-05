package com.ss.www.entity;

import java.io.Serializable;
import java.util.List;

public class Rows<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7284469277446565307L;
	private Integer page;
	private Integer total;
	private List<T> rows;

	public Rows() {
		super();
	}

	public Rows(Integer page, Integer total, List<T> rows) {
		super();
		this.page = page;
		this.total = total;
		this.rows = rows;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<T> getRows() {
		return rows;
	}

	public void setRows(List<T> rows) {
		this.rows = rows;
	}

}
