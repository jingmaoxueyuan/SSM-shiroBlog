package com.ss.www.service;

import java.util.List;

import com.ss.www.entity.Role_User;
import com.ss.www.entity.User;
import com.ss.www.entity.UserRoleResultMap;

public interface UserService {
	public List<UserRoleResultMap> findUserRoleTable();

	public List<UserRoleResultMap> findUserRoleSelect();

	public boolean updateUsersRole(UserRoleResultMap userRoleResultMap);

	public Role_User findUserNameRole(String userName);

	public boolean insertUserNameRole(UserRoleResultMap userRoleResultMap);

	public boolean deleteUserNameRole(int id);
	
	public boolean resettingPassWord(User user);
}
