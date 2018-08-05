package com.ss.www.entity;

import java.io.Serializable;
import java.util.List;

public class LabelList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 68064875870799326L;
	private int labelListId;
	private List<Label> object;

	public LabelList() {
		super();
	}
 

	public int getLabelListId() {
		return labelListId;
	}

	public void setLabelListId(int labelListId) {
		this.labelListId = labelListId;
	}

	public List<Label> getObject() {
		return object;
	}

	public void setObject(List<Label> list) {
		this.object = list;
	}

	@Override
	public String toString() {
		return "LabelList [labelListId=" + labelListId + ", object=" + object + "]";
	}

}
