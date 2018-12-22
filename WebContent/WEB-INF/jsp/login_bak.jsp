<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>海事系统</title>
<link href="<%=baseUrl%>/styles/dwz/themes/css/login.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
function checkLogin(){
	with(document.loginForm){
		if(usercode.value==""){
			alert("请输入用户名!");
			usercode.focus();
			return false;
		}
		if(password.value==""){
			alert("请输入密码!");
			password.focus();
			return false;
		}
	}
	return true;
}
</script>
</head>
<body>
	<div id="login">
		<div id="login_header">
			<h1 class="login_logo"><img src="<%=baseUrl%>/styles/dwz/themes/default/images/logo.png" width="590" />
			</h1>
			<div class="login_headerContent">
				<div class="navList">
					<ul>
						<li><a href="#">设为首页</a></li>
					</ul>
				</div>
				<h2 class="login_title"></h2>
			</div>
		</div>
		<div id="login_content">
			<div class="loginForm">
				<form method="post" action="<%=baseUrl%>/passport/login" name="loginForm" onsubmit="return checkLogin();">
					<input type="hidden" name="backToUrl" value="${param.backToUrl}"/>
					<c:if test="${!empty message}"><p style="color: red">${message}</p></c:if>
					<p>
						<label>用户名：</label>
						<input type="text" name="usercode" size="20" class="required login_input" style="width:130px;" />
					</p>
					<p>
						<label>密　码：</label>
						<input type="password" name="password" size="20" class="required login_input" style="width:130px;" />
					</p>
					
					<div class="login_bar">
						<input class="sub" type="submit" value=" " />
					</div>
				</form>
			</div>
			<div class="login_main"></div>
		</div>
		<div id="login_footer">
			Copyright &copy; 2013 <a href="#" target="dialog">华泰保险经纪海事业务系统</a>
		</div>
	</div>

</body>
</html>