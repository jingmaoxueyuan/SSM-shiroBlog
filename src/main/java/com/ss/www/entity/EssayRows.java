package com.ss.www.entity;

import java.io.Serializable;
import java.util.List;

public class EssayRows implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 301061944012680555L;
	private Integer page;
	private Integer total;
	private List<EssayResultMap> rows;

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

	public List<EssayResultMap> getRows() {
		return rows;
	}

	public void setRows(List<EssayResultMap> blogContent) {
		this.rows = blogContent;
	}

	@Override
	public String toString() {
		return "EssayRows [page=" + page + ", total=" + total + ", rows=" + rows + "]";
	}

}
