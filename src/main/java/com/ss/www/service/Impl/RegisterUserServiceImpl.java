package com.ss.www.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.User;
import com.ss.www.mapper.RegisterMapper;
import com.ss.www.service.RegisterUserService;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
	@Autowired
	RegisterMapper registerMapper;

	public boolean newly_IncreasedUser(User user) {
		// TODO Auto-generated method stub
		return registerMapper.newly_IncreasedUser(user);
	}

}
