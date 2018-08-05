package com.ss.www.entity;

import java.io.Serializable;

public class Label implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1630723320522742619L;
	private int label_Id;
	private String label;
	private String create_Date;

	public Label() {
		super();
	}

	public Label(int label_Id, String label, String create_Date) {
		super();
		this.label_Id = label_Id;
		this.label = label;
		this.create_Date = create_Date;
	}

	public int getLabel_Id() {
		return label_Id;
	}

	public void setLabel_Id(int label_Id) {
		this.label_Id = label_Id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getCreate_Date() {
		return create_Date;
	}

	public void setCreate_Date(String create_Date) {
		this.create_Date = create_Date;
	}

	@Override
	public String toString() {
		return "Label [label_Id=" + label_Id + ", label=" + label + ", create_Date=" + create_Date + "]";
	}

}
