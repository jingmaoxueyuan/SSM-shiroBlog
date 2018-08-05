package com.ss.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.CommentResultMap;
import com.ss.www.entity.EssayResultMap;
import com.ss.www.entity.Label;
import com.ss.www.entity.Pages;
import com.ss.www.entity.User;
import com.ss.www.mapper.BlogIndexMapper;
import com.ss.www.service.BlogIndexService;

@Service
public class BlogIndexServiceImpl implements BlogIndexService {
	@Autowired
	BlogIndexMapper blogIndexMapper;

	public User findUserInfoByIndex() {
		// TODO Auto-generated method stub
		return blogIndexMapper.findUserInfoByIndex();
	}

	public List<Label> findLabelInfoByIndex() {
		// TODO Auto-generated method stub
		return blogIndexMapper.findLabelInfoByIndex();
	}

	public List<EssayResultMap> findBlogInfoByIndex() {
		// TODO Auto-generated method stub
		return blogIndexMapper.findBlogInfoByIndex();
	}

	public int findBlogCountByIndex() {
		// TODO Auto-generated method stub
		return blogIndexMapper.findBlogCountByIndex();
	}

	public List<EssayResultMap> findNextPages(Pages pages) {
		// TODO Auto-generated method stub
		return blogIndexMapper.findNextPages(pages);
	}

	public EssayResultMap findBlogInfo(int blog_Id) {
		// TODO Auto-generated method stub
		return blogIndexMapper.findBlogInfo(blog_Id);
	}

	public List<CommentResultMap> findCommentInfo(int blog_Id) {
		// TODO Auto-generated method stub
		return blogIndexMapper.findCommentInfo(blog_Id);
	}

	public List<EssayResultMap> findLabelInfo(int label_Id) {
		// TODO Auto-generated method stub
		return blogIndexMapper.findLabelInfo(label_Id);
	}
}
