package com.ss.www.control.Api.Admin;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.ss.www.entity.Permission;
import com.ss.www.entity.Role;
import com.ss.www.entity.Role_Permission;
import com.ss.www.entity.Rows;
import com.ss.www.entity.POJO.Message;
import com.ss.www.service.RolePermissionService;

@Controller
@RequestMapping(value = "admin")
@CrossOrigin(origins = { "http://localhost:8080", "http://localhost:63342" })
public class ApiPermissionRoleControl {
	@Autowired
	RolePermissionService rolePermissionService;

	@ResponseBody
	@RequestMapping(value = "findPermissionTable", method = RequestMethod.GET)
	@RequiresPermissions("permission:view")
	public JSONObject findPermissionTable() {
		Rows<Role> rows = new Rows<Role>();
		try {
			List<Role> list = rolePermissionService.permissionTable();
			rows.setRows(list);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(rows);

	}

	@ResponseBody
	@RequestMapping(value = "insertPermission", method = RequestMethod.POST)
	@RequiresPermissions("permission:insert")
	public JSONObject insertPermission(@RequestBody JSONObject json) {
		String role = json.getString("role");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String date = df.format(new Date());
		Role roleInfo = new Role();
		roleInfo.setRole(role);
		roleInfo.setCreate_Date(date);
		Message m = new Message();
		try {
			Role findRoleInfo = rolePermissionService.findPermissionRole(role);
			if (findRoleInfo == null) {
				if (rolePermissionService.insertPermission(roleInfo)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("新增成功");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo("新增失败");
				}
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("数据已存在");
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "updatePermission", method = RequestMethod.POST)
	@RequiresPermissions("permission:update")
	public JSONObject updatePermission(@RequestBody JSONObject json) {
		String role_Id = json.getString("role_Id");
		String role = json.getString("role");
		Message m = new Message();
		Role roleInfo = new Role();
		roleInfo.setRole_Id(Integer.parseInt(role_Id));
		roleInfo.setRole(role);
		try {
			if (rolePermissionService.updatePermission(roleInfo)) {
				m.setCode(Message.SUCCESS);
				m.setInfo("更新成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("更新失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "deletePermission", method = RequestMethod.POST)
	@RequiresPermissions("permission:delete")
	public JSONObject deletePermission(@RequestBody JSONObject json) {
		String role_Id = json.getString("role_Id");
		Message m = new Message();
		try {
			if (rolePermissionService.deletePermission(Integer.parseInt(role_Id))) {
				m.setCode(Message.SUCCESS);
				m.setInfo("删除成功");
			} else {
				m.setCode(Message.ERROR);
				m.setInfo("删除失败");
			}
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(m);

	}

	@ResponseBody
	@RequestMapping(value = "selectPermission", method = RequestMethod.GET)
	@RequiresPermissions("permission:permissionview")
	public JSONObject selectPermission() {
		Rows<Permission> rows = new Rows<Permission>();
		try {
			List<Permission> list = rolePermissionService.permissionAllot();
			rows.setRows(list);
		} catch (JSONException e) {
			// TODO: handle exception
		}
		return (JSONObject) JSON.toJSON(rows);

	}

	@ResponseBody
	@RequestMapping(value = "permissionAllot")
	@RequiresPermissions("permission:permissionallot")
	public JSONObject permissionAllot(@RequestBody JSONObject json) throws com.mysql.jdbc.exceptions.MySQLSyntaxErrorException {
		String role = json.getString("role");
		String permission = new String(json.getString("permission"));
		String[] array;
		Message m = new Message();
		array = permission.trim().split("\\[|\\]|,| ");
		List<Role_Permission> list = new ArrayList<Role_Permission>();
		Role roleInfo = rolePermissionService.findPermissionRole(role);
		for (int i = 0; i < array.length; i++) {
			Role_Permission role_Permission = new Role_Permission();
			String data = array[i];
			if (!data.equals("")) {
				role_Permission.setRole_id(roleInfo.getRole_Id());
				role_Permission.setPermission_id(Integer.parseInt(data));
				list.add(role_Permission);
			}

		}
		try {
			if (rolePermissionService.deletePermissionAllot(String.valueOf(roleInfo.getRole_Id()))) {
				if (rolePermissionService.insertPermissionAllot(list)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("修改成功");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo("修改失败");
				}
			} else {
				if (rolePermissionService.insertPermissionAllot(list)) {
					m.setCode(Message.SUCCESS);
					m.setInfo("修改成功");
				} else {
					m.setCode(Message.ERROR);
					m.setInfo("修改失败");
				}
			}
		} catch (JSONException e) {
			// TODO: handle exception
			m.setCode(Message.ERROR_AUTHORIZATION);
			m.setInfo("参数异常");
		} catch (Exception e) {
			// TODO: handle exception
			m.setCode(Message.ERROR);
			m.setInfo("数据库错误");
		}
		return (JSONObject) JSON.toJSON(m);

	}
}
