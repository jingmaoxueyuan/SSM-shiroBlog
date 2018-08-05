package com.ss.www.control.Api.Admin;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.www.entity.POJO.Message;

@Controller
@RequestMapping(value = "admin")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiAdminLoginControl {
	/**
	 * @return jsoninfo
	 * 登陆信息二次验证
	 */
	@ResponseBody
	@RequestMapping(value = "adminLoginProving",method=RequestMethod.POST)
	public JSONObject adminLoginProving() {
		Subject subject = SecurityUtils.getSubject();
		Message m = new Message();
		if (subject.isAuthenticated()) {
			m.setCode(200);
			m.setObject(subject.getSession().getAttribute("user1"));
		}else {
			m.setCode(403);
			//m.setObject(subject.getSession().getAttribute("user1"));
		}
		return (JSONObject) JSON.toJSON(m);
	}
}
