package com.ss.www.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.User;
import com.ss.www.mapper.LoginMapper;
import com.ss.www.service.LoginUserService;
@Service
public class LoginUserServiceImpl implements LoginUserService{
@Autowired
LoginMapper loginMapper;
	public User findByUserId(String username) {
		// TODO Auto-generated method stub
		return loginMapper.findByUserId(username);
	}

}
