package com.ss.www.service;

import java.util.List;

import com.ss.www.entity.Label;

public interface LabelService {

	public List<Label> findLabel();

	// public boolean searchTitle(Label label);

	public boolean insertLabelInfo(Label label);

	public Label findUpdateLabel(int label_Id);
	
	public boolean updateLabel(Label label);
	
	public boolean deleteLabel(int label_Id);
}
