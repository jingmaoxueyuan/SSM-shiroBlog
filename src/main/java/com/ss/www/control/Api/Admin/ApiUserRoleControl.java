package com.ss.www.control.Api.Admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import com.ss.www.entity.Role_User;
import com.ss.www.entity.Rows;
import com.ss.www.entity.User;
import com.ss.www.entity.UserRoleResultMap;
import com.ss.www.entity.POJO.Message;
import com.ss.www.service.UserService;
import com.ss.www.utils.Md5Tools;

@Controller
@RequestMapping(value = "admin")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiUserRoleControl {
	@Autowired
	UserService userService;

	@ResponseBody
	@RequestMapping(value = "findUserRoleTable", method = RequestMethod.GET)
	@RequiresPermissions("role:view")
	public JSONObject findUserRoleTable() {
		// Message m=new Message();
		Rows<UserRoleResultMap> rows = new Rows<UserRoleResultMap>();
		try {
			List<UserRoleResultMap> userRoleResultMap = userService.findUserRoleTable();
			rows.setRows(userRoleResultMap);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(rows);

	}

	@ResponseBody
	@RequestMapping(value = "findUserRole")
	@RequiresPermissions(value="role:findRoleView")
	public JSONObject findUserRole() {
		Rows<UserRoleResultMap> rows = new Rows<UserRoleResultMap>();
		try {
			List<UserRoleResultMap> userRoleResultMap = userService.findUserRoleSelect();
			if (userRoleResultMap != null) {
				rows.setRows(userRoleResultMap);
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSONObject.toJSON(rows);
	}

	@ResponseBody
	@RequestMapping(value = "updateUserRole", method = RequestMethod.POST)
	@RequiresPermissions("role:update")
	public JSONObject updateUserRole(@RequestBody JSONObject json) {
		String userName = json.getString("userName");
		String role = json.getString("role");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		UserRoleResultMap userRoleResultMap = new UserRoleResultMap();
		userRoleResultMap.setUserName(userName);
		userRoleResultMap.setRole(role);
		userRoleResultMap.setCreate_Date(date);
		Message m = new Message();
		try {
			Role_User role_User = userService.findUserNameRole(userName);
			if (role_User != null) {
				if (userService.updateUsersRole(userRoleResultMap)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("更新成功");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo("更新失败");
				}
			} else {
				if (userService.insertUserNameRole(userRoleResultMap)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("更新成功");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo("更新失败");
				}
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "deleteUserRole", method = RequestMethod.POST)
	@RequiresPermissions("role:delete")
	public JSONObject deleteUserRole(@RequestBody JSONObject json) {
		String id = json.getString("id");
		Message m = new Message();
		try {
			if (userService.deleteUserNameRole(Integer.parseInt(id))) {
				m.setCode(Message.SUCCESS);
				m.setInfo("删除成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("删除失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数异常");
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "resettingPassWord",method=RequestMethod.POST)
	@RequiresPermissions("role:passwordresetting")
	public JSONObject resettingPassWord(@RequestBody JSONObject json) {
		String userName = json.getString("userName");
		final String passWord = "123456zxc";
		Message m = new Message();
		User user = new User();
		user.setPassWord(Md5Tools.Md5(passWord, userName, 3));
		user.setUserName(userName);
		try {
			if (userService.resettingPassWord(user)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("重置成功");
			}else {
				m.setCode(Message.ERROR);
				m.setInfo("重置失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数错误");
		}
		return (JSONObject) JSON.toJSON(m);

	}
}
