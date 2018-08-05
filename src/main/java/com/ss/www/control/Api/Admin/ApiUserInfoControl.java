package com.ss.www.control.Api.Admin;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.ss.www.entity.User;
import com.ss.www.entity.POJO.Message;
import com.ss.www.mapper.LoginMapper;
import com.ss.www.mapper.PermissionMapper;
import com.ss.www.service.UserInfoService;

@Controller
@RequestMapping(value = "admin")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiUserInfoControl {
	@Autowired
	PermissionMapper permissionMapper;
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	UserInfoService userInfoService;

	/**
	 * @param json
	 * @return json info 更新个人信息
	 */
	@ResponseBody
	@RequestMapping(value = "updateUserInfo", method = RequestMethod.POST)
	@RequiresPermissions("user:upload")
	public JSONObject updateUserInfo(@RequestBody JSONObject json) {
		String userName = json.getString("userName");
		String pic = json.getString("pic");
		String nick = json.getString("nick");
		String remarks = json.getString("remarks");
		Message m = new Message();
		User user = new User();
		user.setUserName(userName);
		user.setPic(pic);
		user.setNick(nick);
		user.setRemarks(remarks);
		try {
			if (userInfoService.uploadUserInfo(user)) {
				m.setCode(Message.SUCCESS);
				m.setInfo(Message.SUCCESS_INFO);
				return (JSONObject) JSON.toJSON(m);
			} else {
				m.setCode(Message.ERROR);
				m.setInfo(Message.ERROR_INFO);
				return (JSONObject) JSON.toJSON(m);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
			return (JSONObject) JSON.toJSON(m);
		}
	}

	/**
	 * @param req
	 * @param res
	 * @param file
	 * @return jsoninfo 上传图片
	 */
	@ResponseBody
	@RequestMapping(value = "updatePic")
	@RequiresPermissions("user:upload")
	public JSONObject updatePic(HttpServletRequest req, HttpServletResponse res,
			@RequestParam(value = "file", required = false) MultipartFile file) {
		Message m = new Message();
		if (file != null) {
			Date date = new Date();
			String newName = date.getTime() + ".jpg";
			String filePath = req.getSession().getServletContext().getRealPath("/") + "image/" + newName;
			try {
				file.transferTo(new File(filePath));
				m.setCode(Message.SUCCESS);
				m.setInfo("上传成功");
				m.setObject("/" + newName);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.setCode(Message.ERROR);
				return (JSONObject) JSON.toJSON(m);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				m.setCode(Message.ERROR);
				return (JSONObject) JSON.toJSON(m);
			}
			return (JSONObject) JSON.toJSON(m);
		} else {
			m.setCode(Message.ERROR);
			m.setInfo("无文件上传");
			return (JSONObject) JSON.toJSON(m);
		}
	}

	/**
	 * @return jsoninfo 读取信息
	 */
	@ResponseBody
	@RequestMapping(value = "userInfoView", method = RequestMethod.POST)
	@RequiresPermissions("user:view")
	public JSONObject userInfoView() {
		Subject subject = SecurityUtils.getSubject();
		String userName = (String) subject.getSession().getAttribute("user1");
		Message m = new Message();
		try {
			User user = loginMapper.findByUserId(userName);
			if (user != null) {
				m.setCode(Message.SUCCESS);
				m.setInfo(Message.SUCCESS_INFO);
				m.setObject(user);
				return (JSONObject) JSON.toJSON(m);
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR);
			m.setInfo("参数错误");
			return (JSONObject) JSON.toJSON(m);
		}

		return null;
	}
}
