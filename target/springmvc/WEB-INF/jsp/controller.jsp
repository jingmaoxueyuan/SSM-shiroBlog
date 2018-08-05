<%@ page language="java" contentType="text/html; charset=UTF-8"
	import="com.baidu.ueditor.ActionEnter" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setHeader("Content-Type", "text/html");

	response.setHeader("Access-control-Allow-Origin", request.getHeader("Origin"));
	response.setHeader("Access-Control-Allow-Methods", request.getMethod());
	response.setHeader("Access-Control-Allow-Credentials", "true");
	response.setHeader("Access-Control-Allow-Headers", request.getHeader("Access-Control-Request-Headers"));

	String rootPath = application.getRealPath("/");

	out.write(new ActionEnter(request, rootPath).exec());
	
%>