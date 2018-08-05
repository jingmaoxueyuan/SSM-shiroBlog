package com.ss.www.shiro;

import java.util.List;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.ss.www.entity.PermissionResultMap;
import com.ss.www.entity.User;
import com.ss.www.mapper.LoginMapper;
import com.ss.www.mapper.PermissionMapper;

public class MyRealm extends AuthorizingRealm {
	@Autowired
	LoginMapper loginMapper;
	@Autowired
	PermissionMapper permissionMapper;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		// 获取登录时输入的用户名
		User loginName = (User) principals.fromRealm(getName()).iterator().next();
		// String loginName = (String) principals.getPrimaryPrincipal();
		User user = loginMapper.findByUserId(loginName.getUserName());
		if (user != null) {
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			List<PermissionResultMap> permissionMap = permissionMapper.findUserPermission(user.getUser_Id());
			for (PermissionResultMap p : permissionMap) {
				info.addStringPermission(p.getResourse());
			}
			return info;
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		// UsernamePasswordToken对象用来存放提交的登录信息
		UsernamePasswordToken token1 = (UsernamePasswordToken) token;
		// 查出是否有此用户
		User user = new User();
		user = loginMapper.findByUserId(token1.getUsername());
		if (user != null) {
			return new SimpleAuthenticationInfo(user, user.getPassWord(), ByteSource.Util.bytes(user.getUserName()),
					getName());
		}
		return null;

	}

}
