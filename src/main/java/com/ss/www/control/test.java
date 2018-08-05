package com.ss.www.control;

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

@Controller
@CrossOrigin(origins= {"http://localhost:8080","http://localhost:63342"})
public class test {
 
	 @ResponseBody
	 @RequestMapping(value="hello",method=RequestMethod.POST)
	public JSONObject hello(@RequestBody JSONObject json) {
	  //User user=login.findById("admin");
		 User user=new User();
	  Message m=new Message();
	  m.setCode(Message.SUCCESS);
	  m.setInfo(Message.SUCCESS_INFO);
	  m.setObject(user);
	  System.out.println(json.getString("username"));
	  System.out.println((JSONObject) JSON.toJSON(m));
	  return (JSONObject) JSON.toJSON(m);
  }
}
