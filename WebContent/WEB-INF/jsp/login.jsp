<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>华泰保险经纪-海事业务系统</title>

<script type="text/javascript">
function checkLogin(){
	var usercode = document.getElementById("usercode").value;
	var password = document.getElementById("password").value;
	
	if(usercode.length == 0){
		alert("请输入用户名!");
		document.getElementById("usercode").focus();
		return false;
	}
	if(password.length == 0){
		alert("请输入密码!");
		document.getElementById("password").focus();
		return false;
	}
	return true;
}
</script>
</head>
<body bgcolor="#FFFFFF" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
<table id="" align="center" border="0" cellpadding="0" cellspacing="0">
	<tr>
		<td colspan="5">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_01.png" width="1003" height="85" alt="" /></td>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/fgf.png" width="1" alt="" /></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_02.png" width="103"  alt=""/></td>
		<td rowspan="2">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_03.png" width="399" alt=""/></td>
		<td colspan="2">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_04.png" width="397" alt=""/></td>
		<td rowspan="4">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_05.png" width="104" alt=""/></td>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/fgf.png" width="1" alt=""/></td>
	</tr>
	<tr>
		<td rowspan="3">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_06.png" width="1"  alt=""/></td>
		<td style="background-image:url('<%= baseUrl %>/styles/dwz/themes/default/image_login/login_07.png');">
			<form method="post" action="<%=baseUrl%>/passport/login" name="loginForm" onsubmit="return checkLogin();">
			<input type="hidden" name="backToUrl" value="${param.backToUrl}"/>
			<c:if test="${!empty message}"><p style="color: red">${message}</p></c:if>
			<table style="width: 100%;height: 100%;"  border="0" cellpadding="0" cellspacing="0">
				<tr>
					<td align="center">
						<input type="text" id="usercode" alt="用户名"  name="usercode" style="padding: 8px 2px 8px 20px;margin: 0px 0px 10px 0px;width: 200px;border: solid 1px #9D9D9D;background-image:url('<%= baseUrl %>/styles/dwz/themes/default/image_login/login_acc.png');background-repeat:no-repeat;background-position:3px;"/>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="password" id="password" alt="密码" name="password" style="padding: 8px 2px 8px 20px;margin: 10px 0px 0px 0px;width: 200px;border: solid 1px #9D9D9D;background-image:url('<%= baseUrl %>/styles/dwz/themes/default/image_login/login_pass.png');background-repeat:no-repeat;background-position:2px;"/>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input  style="margin: 10px 0px;" type="image" src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_btn.png" onclick="document.form.submit();"/>
					</td>
				</tr>
				<tr><td>&nbsp;</td></tr>
				<tr><td>&nbsp;</td></tr>
			</table>
			</form>
		</td>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/fgf.png" width="1" height="242" alt=""/></td>
	</tr>
	<tr>
		<td rowspan="2">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_08.png" width="399" alt=""/></td>
		<td rowspan="2">
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_09.png" width="396" alt=""/></td>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/fgf.png" width="1" alt=""/></td>
	</tr>
	<tr>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/login_10.png" width="103" alt=""/></td>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/fgf.png" width="1" alt=""/></td>
	</tr>
	<tr>
		<td colspan="5" style="background-image:url('<%= baseUrl %>/styles/dwz/themes/default/image_login/login_11.png');" height="98" valign="top">
		<table border="0" cellpadding="0" cellspacing="0" width="100%">
			<tr><td>&nbsp;</td></tr>
			<tr><td align="center" style="font-size: 12px;">Copyright &copy; 2013 华泰保险经纪海事业务系统</td></tr>
		</table>
		</td>
		<td>
			<img src="<%= baseUrl %>/styles/dwz/themes/default/image_login/fgf.png" width="1" alt=""/></td>
	</tr>
</table>
</body>
</html>