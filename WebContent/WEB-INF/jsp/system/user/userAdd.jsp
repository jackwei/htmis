<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
	
	<form method="post" action="<%=baseUrl %>/system/user/insert?navTabId=userList&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<div class="pageFormContent" layoutH="58">
			<p>
				<label>系统登录名: </label>
				<input type="text" id="userCode" name="userCode" class="required" onchange="checkUserCode(this.value)" />
			</p>
			<p>
				<label>用户姓名: </label>
				<input type="text" name="name" class="required"/>
			</p>
			<p>
				<label>英文名: </label>
				<input type="text" name="enName" class="required"/>
			</p>
			<p>
				<label>姓名简称: </label>
				<input type="text" name="sName" />
			</p>
			<p>
				<label>邮箱: </label>
				<input type="text" name="email" class="email"/>
			</p>
			<p>
				<label>联系电话: </label>
				<input type="text" name="phone" class="phone"/>
			</p>
			<p>
				<label>性别：</label>
				<select name="gender" >
					<option value="">--请选择--</option>
					<c:forEach var="item" items="${genderList}">
						<option value="${item}">${item.desc}</option>
					</c:forEach>
				</select>
			</p>
			<p class="a">
				<label>用户所属部门：</label>
				<input type="hidden" name="orgLookup.id" value="" />
				<input type="hidden" name="orgLookup.extend1" value="" />
				<input type="hidden" name="orgLookup.orgCode" value="" />
				<input class="required textInput valid" readonly="readonly" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.orgName" autocomplete="off" /></input>
					<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=C" lookupgroup="orgLookup" height="500">选择用户所属部门</a>			
			</p>
			<p class="a">
				<label>用户角色：</label>
				<input type="hidden" name="roleLookup.id" value="" />
				<input class="required textInput valid" readonly="readonly" size="40" type="text" id ="roleName" lookupgroup="roleLookup" name="roleLookup.name" autocomplete="off" /></input>
					<a class="btnLook" id="looks1"  href="<%=baseUrl %>/system/role/roleSearch" lookupgroup="roleLookup" height="500">选择用户角色</a>			
			</p>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
			</ul>
		</div>
	</form>
	
</div>
<script type="text/javascript">
/**
 * 校验系统登录名，不允许重复
 */
function checkUserCode(userCode){
    
    $.post('<%=baseUrl %>/system/user/checkUserCode',
            {'userCode':userCode,'userId':'0'},
       function(data){
           if(data==false){
               alertMsg.error("已存在相同的用户登录名，请重新录入登录名！");
               $("#userCode").val("");
           }
      } ,'json');
    
} 

</script>
