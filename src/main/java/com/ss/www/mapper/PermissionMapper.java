package com.ss.www.mapper;

import java.util.List;

import com.ss.www.entity.PermissionResultMap;

public interface PermissionMapper {
	public List<PermissionResultMap> findUserPermission(int user_id);
}
