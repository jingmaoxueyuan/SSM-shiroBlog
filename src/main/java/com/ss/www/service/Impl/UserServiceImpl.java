package com.ss.www.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.Role_User;
import com.ss.www.entity.User;
import com.ss.www.entity.UserRoleResultMap;
import com.ss.www.mapper.UserMapper;
import com.ss.www.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserMapper userMapper;

	public List<UserRoleResultMap> findUserRoleTable() {
		// TODO Auto-generated method stub
		return userMapper.findUserRoleTable();
	}

	public List<UserRoleResultMap> findUserRoleSelect() {
		// TODO Auto-generated method stub
		return userMapper.findUserRoleSelect();
	}

	public boolean updateUsersRole(UserRoleResultMap userRoleResultMap) {
		// TODO Auto-generated method stub
		return userMapper.updateUsersRole(userRoleResultMap);
	}

	public Role_User findUserNameRole(String userName) {
		// TODO Auto-generated method stub
		return userMapper.findUserNameRole(userName);
	}

	public boolean insertUserNameRole(UserRoleResultMap userRoleResultMap) {
		// TODO Auto-generated method stub
		return userMapper.insertUserNameRole(userRoleResultMap);
	}

	public boolean deleteUserNameRole(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserNameRole(id);
	}

	public boolean resettingPassWord(User user) {
		// TODO Auto-generated method stub
		return userMapper.resettingPassWord(user);
	}
}
