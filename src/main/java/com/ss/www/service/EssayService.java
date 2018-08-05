package com.ss.www.service;

import java.util.List;

import com.ss.www.entity.Blog;
import com.ss.www.entity.EssayResultMap;
import com.ss.www.entity.Label;

public interface EssayService {
	public List<EssayResultMap> findEssayByUserName(String userName);

	public int findEssayCount(String userName);

	public String findEssayStatusByBlogId(int blogId);

	public boolean updateEssayStatus(Blog blog);

	public boolean deleteEssayByEssayId(int blogId);

	public List<Label> findLabel();

	public boolean insertEssay(EssayResultMap essayResultMap);

	public EssayResultMap findEssayByBlogId(int blogId);

	public boolean updateEssayByBlogId(EssayResultMap essayResultMap);

	public List<EssayResultMap> searchTitle(String title);

}
