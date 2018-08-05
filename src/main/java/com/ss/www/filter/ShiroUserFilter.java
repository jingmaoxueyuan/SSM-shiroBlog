package com.ss.www.filter;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.web.filter.authc.UserFilter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.ss.www.entity.POJO.Message;

public class ShiroUserFilter extends UserFilter {
	/**
	 * �ڷ��ʹ�����ʱ�����Ƿ�ΪOPTIONS��������Ǿ�ֱ�ӷ���true
	 */
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletResponse httpResponse = (HttpServletResponse) response;
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (httpRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
			setHeader(httpRequest, httpResponse);
			return true;
		}
		return super.preHandle(request, response);
	}

	/**
	 * �÷���������֤ʧ�ܺ���ã�����������ǰ��˷��룬��̨������ҳ����ת �����д�ĳɴ���JSON����
	 */
	@Override
	protected void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
		saveRequest(request);
		setHeader((HttpServletRequest) request, (HttpServletResponse) response);
		Message m = new Message();
		m.setCode(403);
		m.setInfo("Ȩ�޲���");
		response.getWriter().write(JSON.toJSON(m).toString());
		response.getWriter().flush();
		response.getWriter().close();
	}

	/**
	 * Ϊresponse����header��ʵ�ֿ���
	 */
	private void setHeader(HttpServletRequest request, HttpServletResponse response) {
		// �����header����
		response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
		response.setHeader("Access-Control-Allow-Methods", request.getMethod());
		response.setHeader("Access-Control-Allow-Credentials", "true");
		response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));
		// ��ֹ���룬�����ڴ���JSON����
		response.setHeader("Content-Type", "application/json;charset=UTF-8");
		response.setStatus(HttpStatus.OK.value());
	}
}
