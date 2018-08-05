package com.ss.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.Permission;
import com.ss.www.entity.Role;
import com.ss.www.entity.Role_Permission;
import com.ss.www.mapper.RolePermissionMapper;
import com.ss.www.service.RolePermissionService;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	@Autowired
	RolePermissionMapper rolePermissionMapper;

	public List<Role> permissionTable() {
		// TODO Auto-generated method stub
		return rolePermissionMapper.permissionTable();
	}

	public boolean insertPermission(Role role) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.insertPermission(role);
	}

	public Role findPermissionRole(String role) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.findPermissionRole(role);
	}

	public boolean updatePermission(Role role) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.updatePermission(role);
	}

	public boolean deletePermission(int role_Id) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.deletePermission(role_Id);
	}

	public List<Permission> permissionAllot() {
		// TODO Auto-generated method stub
		return rolePermissionMapper.permissionAllot();
	}

	public boolean insertPermissionAllot(List<Role_Permission> role_permission) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.insertPermissionAllot(role_permission);
	}

	public boolean deletePermissionAllot(String role) {
		// TODO Auto-generated method stub
		return rolePermissionMapper.deletePermissionAllot(role);
	}
}
