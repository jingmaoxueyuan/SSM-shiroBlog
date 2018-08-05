package com.ss.www.control.Api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.www.entity.POJO.Message;

@Controller
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
@RequestMapping(value = "api")
public class ApiErrorControl {
	/**
	 * @return json info
	 * 没有权限直接调用接口
	 */
	@ResponseBody
	@RequestMapping(value = "error", method = RequestMethod.GET)
	public JSONObject powerError() {
		Message m = new Message();
		m.setCode(403);
		m.setInfo("不要调皮哦");
		return (JSONObject) JSON.toJSON(m);
	}
}
