package com.ss.www.mapper;

import com.ss.www.entity.User;

public interface LoginMapper {
public User findByUserId(String username);
}
