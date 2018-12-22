<%@ page contentType="text/html;charset=UTF-8" %>
 
<%@page import="cn.com.maxtech.sso.client.SSOClient"%>
<%
if(SSOClient.loginByMaxEJO(request,"huatai")){
	 String n = request.getParameter("n");
	 if(n ==null){
		 out.println("<script>window.location.href='../manager/main_new.jsp?alias=home';</script>");
	 }else if(n.equals("2")){
		 out.println("<script>window.location.href='../manager/main_new.jsp?alias=finance&n=finance_duwhf';</script>");
	 }else if(n.equals("3")){
		 out.println("<script>window.location.href='../manager/main_new.jsp?alias=finance&n=finance_fzjgdz';</script>");
	 }else if(n.equals("4")){
		 out.println("<script>window.location.href='../manager/main_new.jsp?alias=finance&n=finance_fpgl';</script>");
	 }else if(n.equals("5")){
		 out.println("<script>window.location.href='../manager/main_new.jsp?alias=voucher';</script>");
	 }else if(n.equals("6")){
		 out.println("<script>window.location.href='../manager/main_new.jsp?alias=sys_menu';</script>");
	 }
}else{
	out.println("<script>alert('对不起，您的用户名或密码不正确！');window.location.href='login.jsp';</script>");
}
%>
