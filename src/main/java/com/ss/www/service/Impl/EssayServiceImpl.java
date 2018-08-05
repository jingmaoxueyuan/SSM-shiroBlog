package com.ss.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.Blog;
import com.ss.www.entity.EssayResultMap;
import com.ss.www.entity.Label;
import com.ss.www.mapper.EssayMapper;
import com.ss.www.service.EssayService;

@Service
public class EssayServiceImpl implements EssayService {
	@Autowired
	EssayMapper essayMapper;

	public List<EssayResultMap> findEssayByUserName(String userName) {
		// TODO Auto-generated method stub
		return essayMapper.findEssayByUserName(userName);
	}

	public int findEssayCount(String userName) {
		// TODO Auto-generated method stub
		return essayMapper.findEssayCount(userName);
	}

	public String findEssayStatusByBlogId(int blogId) {
		// TODO Auto-generated method stub
		return essayMapper.findEssayStatusByBlogId(blogId);
	}

	public boolean updateEssayStatus(Blog blog) {
		// TODO Auto-generated method stub
		return essayMapper.updateEssayStatus(blog);
	}

	public boolean deleteEssayByEssayId(int blogId) {
		// TODO Auto-generated method stub
		return essayMapper.deleteEssayByEssayId(blogId);
	}

	public List<Label> findLabel() {
		// TODO Auto-generated method stub
		return essayMapper.findLabel();
	}

	public boolean insertEssay(EssayResultMap essayResultMap) {
		// TODO Auto-generated method stub
		return essayMapper.insertEssay(essayResultMap);
	}

	public EssayResultMap findEssayByBlogId(int blogId) {
		// TODO Auto-generated method stub
		return essayMapper.findEssayByBlogId(blogId);
	}

	public boolean updateEssayByBlogId(EssayResultMap essayResultMap) {
		// TODO Auto-generated method stub
		return essayMapper.updateEssayByBlogId(essayResultMap);
	}

	public List<EssayResultMap> searchTitle(String title) {
		// TODO Auto-generated method stub
		return essayMapper.searchTitle(title);
	}

}
