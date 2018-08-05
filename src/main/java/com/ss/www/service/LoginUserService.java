package com.ss.www.service;

import com.ss.www.entity.User;

public interface LoginUserService {
	public User findByUserId(String username);
}
