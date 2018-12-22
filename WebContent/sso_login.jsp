<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@page import="com.git.web.PassportController"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海事系统</title>
<script src="<%=baseUrl%>/styles/dwz/js/speedup.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="<%=baseUrl%>/styles/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

</head>
<%
PassportController pc = new PassportController();
boolean ss = pc.loginByMaxEJO(request,"huatai");
if(ss){
	String n = request.getParameter("n");
	out.println("<script>window.location.href='main?n="+n+"';</script>");
}else{
	out.println("<script> alert('对不起，您的用户名或密码不正确！');window.location.href='login';</script>");
}

%>
