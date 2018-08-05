package com.ss.www.control.Api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ss.www.entity.BlogIndexContent;
import com.ss.www.entity.BlogInfo;
import com.ss.www.entity.CommentResultMap;
import com.ss.www.entity.EssayResultMap;
import com.ss.www.entity.EssayRows;
import com.ss.www.entity.Pages;
import com.ss.www.entity.User;
import com.ss.www.entity.POJO.LoginMessage;
import com.ss.www.entity.POJO.Message;
import com.ss.www.service.BlogIndexService;

@Controller
@RequestMapping(value = "api")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiLoginControl {
	@Autowired
	BlogIndexService blogIndexService;

	/**
	 * @param json
	 * @param req
	 * @return json info 登陆
	 */
	@ResponseBody
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public JSONObject login(@RequestBody JSONObject json, HttpServletRequest req) {
		String userName = json.getString("username");
		String passWord = json.getString("password");
		User user = new User();
		user.setUserName(userName);
		Message m = new Message();
		try {
			Subject currentUser = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(userName, passWord);
			token.setRememberMe(false);
			currentUser.login(token);
			if (currentUser.isAuthenticated()) {
				req.getSession().setAttribute("user", userName);
				currentUser.getSession().setAttribute("user1", userName);
				m.setCode(Message.SUCCESS);
				m.setInfo(Message.SUCCESS_INFO);
				m.setObject(user);
				return (JSONObject) JSON.toJSON(m);
			} else {
				m.setCode(LoginMessage.USER_PASS_ERROR);
				m.setInfo(LoginMessage.USER_PASS_ERROR_INFO);
				return (JSONObject) JSON.toJSON(m);
			}
		} catch (AuthenticationException e) {
			m.setCode(LoginMessage.USER_NOT);
			m.setInfo(LoginMessage.USER_NOT_INFO);
			return (JSONObject) JSON.toJSON(m);
		}
	}

	/**
	 * @param req
	 * @return json info 读取信息
	 */
	@ResponseBody
	@RequestMapping(value = "doGetData")
	public JSONObject doGetDate(HttpServletRequest req) {
		BlogIndexContent m = new BlogIndexContent();
		String user = (String) req.getSession().getAttribute("user");
		if (user != null) {
			m.setCode(1);
			m.setInfo("SUCCESS");
			m.setObject(user);
		}
		m.setUserInfo(blogIndexService.findUserInfoByIndex());
		m.setLabelInfo(blogIndexService.findLabelInfoByIndex());
		m.setBlogInfo(blogIndexService.findBlogInfoByIndex());
		return (JSONObject) JSON.toJSON(m);
	}

	/**
	 * @param req
	 * @return json info 退出
	 */
	@ResponseBody
	@RequestMapping(value = "outLogin", method = RequestMethod.POST)
	public JSONObject outLogin(HttpServletRequest req) {
		Message m = new Message();
		Subject sub = SecurityUtils.getSubject();
		if (sub.isAuthenticated()) {
			sub.logout();
			m.setCode(1);
			m.setInfo("SUCCESS");
		}
		return (JSONObject) JSON.toJSON(m);
	}

	@ResponseBody
	@RequestMapping(value = "dividePage", method = RequestMethod.GET)
	public JSONObject dividePage(HttpServletRequest req) {
		EssayRows essayRows = new EssayRows();
		Pages page = new Pages();
		int pages = 0;
		int count = 0;
		int totalpages = 0;
		int limit = 4;
		String strPage = req.getParameter("page");
		try {
			count = blogIndexService.findBlogCountByIndex();
			totalpages = (int) Math.ceil(count / (limit * 1.0));
			if (strPage == null) {
				pages = 1;
			} else {
				try {
					pages = java.lang.Integer.parseInt(strPage);
				} catch (Exception e) {
					pages = 1;
				}
				if (pages < 1) {
					pages = 1;
				}
				if (pages > totalpages) {
					pages = totalpages;
				}
			}
			if (Integer.parseInt(strPage) == totalpages) {
				essayRows.setPage(205);
			}

			page.setPages((pages - 1) * limit);
			page.setLimit(limit);
			List<EssayResultMap> list = blogIndexService.findNextPages(page);
			essayRows.setRows(list);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(essayRows);
	}

	@ResponseBody
	@RequestMapping(value = "findBlogInfo",method=RequestMethod.GET)
	public JSONObject findBlogInfo(HttpServletRequest req) {
		String blogId = req.getParameter("blogId");
		BlogInfo<CommentResultMap> blogInfo = new BlogInfo<CommentResultMap>();
		try {
			EssayResultMap essayResultMap = blogIndexService.findBlogInfo(Integer.parseInt(blogId));
			List<CommentResultMap> list=blogIndexService.findCommentInfo(Integer.parseInt(blogId));
			blogInfo.setObject(essayResultMap);
			blogInfo.setComment(list);
		} catch (JSONException e) {
			// TODO: handle exception
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return (JSONObject) JSON.toJSON(blogInfo);

	}
	@ResponseBody
	@RequestMapping(value="findLabelByBlog")
	public JSONObject findLabelByBlog(HttpServletRequest req) {
		String label_Id=req.getParameter("label_Id");
		BlogIndexContent blog=new BlogIndexContent();
		List<EssayResultMap> list=blogIndexService.findLabelInfo(Integer.parseInt(label_Id));
		blog.setBlogInfo(list);
		return (JSONObject) JSON.toJSON(blog);
	}
}
