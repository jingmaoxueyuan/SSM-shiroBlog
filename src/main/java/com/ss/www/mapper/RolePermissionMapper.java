package com.ss.www.mapper;

import java.util.List;

import com.ss.www.entity.Permission;
import com.ss.www.entity.Role;
import com.ss.www.entity.Role_Permission;

public interface RolePermissionMapper {
	public List<Role> permissionTable();

	public boolean insertPermission(Role role);

	public Role findPermissionRole(String role);

	public boolean updatePermission(Role role);

	public boolean deletePermission(int role_Id);

	public List<Permission> permissionAllot();
	
	public boolean insertPermissionAllot(List<Role_Permission> role_permission);
	
	public boolean deletePermissionAllot(String role);

}
