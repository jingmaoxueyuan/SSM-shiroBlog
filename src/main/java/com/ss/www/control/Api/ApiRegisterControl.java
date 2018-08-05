package com.ss.www.control.Api;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.www.entity.User;
import com.ss.www.entity.POJO.Message;
import com.ss.www.entity.POJO.RegisterMessage;
import com.ss.www.service.LoginUserService;
import com.ss.www.service.RegisterUserService;
import com.ss.www.utils.Md5Tools;

@Controller
@RequestMapping(value = "api")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiRegisterControl {
	@Autowired
	RegisterUserService registerUserService;

	@Autowired
	LoginUserService loginUserService;

	/**
	 * @param json
	 * @return json info ÍË³ö
	 */
	@ResponseBody
	@RequestMapping(value = "register", method = RequestMethod.POST)
	public JSONObject register(@RequestBody JSONObject json) {
		User user = new User();
		Message m = new Message();
		Date date = new Date();
		try {
			if (!json.containsKey("username") && !json.containsKey("password")) {
				String userName = json.getString("userName");
				String passWord = json.getString("passWord");
				String sex = json.getString("sex");
				// Md5Hash md5 = new Md5Hash(passWord, userName, 3);
				Date create_date = date;
				user.setUserName(userName);
				user.setPassWord(Md5Tools.Md5(passWord, userName, 3));
				user.setSex(sex);
				user.setCreate_Date(create_date);
				if (loginUserService.findByUserId(userName) == null) {
					if (registerUserService.newly_IncreasedUser(user)) {
						m.setCode(RegisterMessage.SUCCESS);
						m.setInfo(RegisterMessage.SUCCESS_INFO);
					} else {
						m.setCode(RegisterMessage.ERROR);
						m.setInfo(RegisterMessage.ERROR_INFO);
					}
				} else {
					m.setCode(RegisterMessage.ERROR_USER);
					m.setInfo(RegisterMessage.ERROR_USER_INFO);
				}
			} else {
				m.setCode(RegisterMessage.ERROR_NOT);
				m.setInfo(RegisterMessage.ERROR_NOT_INFO);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			m.setInfo("²ÎÊý´íÎó");
		}

		return (JSONObject) JSON.toJSON(m);
	}

}
