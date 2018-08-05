package com.ss.www.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ss.www.entity.User;
import com.ss.www.mapper.UserInfoMapper;
import com.ss.www.service.UserInfoService;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	@Autowired
	UserInfoMapper userInfoMapper;

	public Boolean uploadUserInfo(User user) {
		// TODO Auto-generated method stub
		return userInfoMapper.uploadUserInfo(user);
	}

}
