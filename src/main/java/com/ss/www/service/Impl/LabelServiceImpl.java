package com.ss.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.Label;
import com.ss.www.mapper.LabelMapper;
import com.ss.www.service.LabelService;

@Service
public class LabelServiceImpl implements LabelService {
	@Autowired
	LabelMapper labelMapper;

	public List<Label> findLabel() {
		// TODO Auto-generated method stub
		return labelMapper.findLabel();
	}

	public boolean insertLabelInfo(Label label) {
		// TODO Auto-generated method stub
		return labelMapper.insertLabelInfo(label);
	}

	public Label findUpdateLabel(int label_Id) {
		// TODO Auto-generated method stub
		return labelMapper.findUpdateLabel(label_Id);
	}

	public boolean updateLabel(Label label) {
		// TODO Auto-generated method stub
		return labelMapper.updateLabel(label);
	}

	public boolean deleteLabel(int label_Id) {
		// TODO Auto-generated method stub
		return labelMapper.deleteLabel(label_Id);
	}

}
