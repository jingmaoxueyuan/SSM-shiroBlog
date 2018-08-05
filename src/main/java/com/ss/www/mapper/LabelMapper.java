package com.ss.www.mapper;

import java.util.List;

import com.ss.www.entity.Label;

public interface LabelMapper {
	public List<Label> findLabel();
	
	public boolean searchTitle(Label label);
	
	public boolean insertLabelInfo(Label label);
	
	public Label findUpdateLabel(int label_Id);
	
	public boolean updateLabel(Label label);
	
	public boolean deleteLabel(int label_Id);
}
