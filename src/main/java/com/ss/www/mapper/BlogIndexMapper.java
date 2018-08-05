package com.ss.www.mapper;

import java.util.List;

import com.ss.www.entity.CommentResultMap;
import com.ss.www.entity.EssayResultMap;
import com.ss.www.entity.Label;
import com.ss.www.entity.Pages;
import com.ss.www.entity.User;

public interface BlogIndexMapper {
	public User findUserInfoByIndex();
	
	public List<Label> findLabelInfoByIndex();
	
	public List<EssayResultMap> findBlogInfoByIndex();
	
	public int findBlogCountByIndex();
	
	public List<EssayResultMap> findNextPages(Pages pages); 
	
	public EssayResultMap findBlogInfo(int blog_Id);
	
	public List<CommentResultMap> findCommentInfo(int blog_Id);
	
	public List<EssayResultMap> findLabelInfo(int label_Id);
}
