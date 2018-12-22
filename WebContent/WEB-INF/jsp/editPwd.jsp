<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/passport/uptpwd?navTabId=main&callbackType=closeCurrent" class="required-validate pageForm" onsubmit="return validateCallback(this, dialogAjaxDone);">
	<div class="pageFormContent" layouth="57">
		<p>
			<label>
				请输入当前密码：
			</label><input type="password" id="password" name="password" class="required" onchange="checkPwd(this.value)" />
		</p>
		<p>
			<label>
				请输入新密码：
			</label><input type="password" name="newPassword" id="newPassword" class="required"/>
		</p>
		<p>
			<label>
				请再次输入新密码：
			</label><input type="password" name="rPassword" class="required" equalTo="#newPassword"/>
		</p>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close" >关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
<script type="text/javascript">
/**
 * 校验用户当前密码，如果不正确则不允许修改
 */
function checkPwd(password){
    
    $.post('<%=baseUrl %>/passport/checkPwd',
            {'password':password},
       function(data){
           if(data==false){
               alertMsg.error("当前密码输入错误，请重新输入！");
               $("#password").val("");
           }
      } ,'json');
    
} 

</script>