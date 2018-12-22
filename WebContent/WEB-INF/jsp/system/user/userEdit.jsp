<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="<%=baseUrl %>/management/book/edit/${org.id}">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/system/user/update?navTabId=userList&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" id="id" name="id" value="${user.id}"/>
	<input type="hidden" name="orgId" value="${user.orgId}"/>
	<%-- <input type="hidden" name="orgCode" value="${user.orgCode}"/>
	<input type="hidden" name="orgName" value="${user.orgName}"/> --%>
	<input type="hidden" name="userPwd" value="${user.userPwd}"/>
	<input type="hidden" name="createTime" value="<fmt:formatDate value="${user.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></input>
	<input type="hidden" name="operatorId" value="${user.operatorId}" />	
	
	<div class="pageFormContent" layoutH="56">
		<p>
			<label>系统登录名: </label>
			<input type="text" id="userCode" name="userCode" value="${user.userCode}" class="required" onchange="checkUserCode(this.value)" />
		</p>
		<p>
			<label>用户姓名: </label>
			<input type="text" name="name" value="${user.name}" class="required"/>
		</p>
		<p>
			<label>英文名: </label>
			<input type="text" name="enName" value="${user.enName}" class="required"/>
		</p>
		<p>
			<label>姓名简称: </label>
			<input type="text" name="sName" value="${user.sName}" />
		</p>
		<p>
			<label>邮箱: </label>
			<input type="text" name="email" value="${user.email}" class="email"/>
		</p>
		<p>
			<label>联系电话: </label>
			<input type="text" name="phone" value="${user.phone}" class="phone"/>
		</p>
		<p>
			<label>性别：</label>
			<select name="gender" >
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${genderList}">
					<option value="${item}" ${item eq user.gender ? 'selected="selected"' : ''}>${item.desc}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>用户状态：</label>
			<select name="userStatus" >				
				<c:forEach var="item" items="${userStatusList}">
					<option value="${item.code}" ${item.code eq user.userStatus ? 'selected="selected"' : ''}>${item.desc}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>机构代码: </label>
			<input type="text" name="orgCode" value="${user.orgCode}" />
		</p>
		<p>
			<label>机构名称: </label>
			<input type="text" name="orgName" value="${user.orgName}" />
		</p>
		<%-- <p class="a">
			<label>用户所属部门：</label>
			<input type="hidden" name="orgLookup.id" value="${user.orgId}" />
			<input type="hidden" name="orgLookup.extend1" value="${user.orgName}" />
			<input class="required textInput valid" readonly="readonly" value="${user.orgName}" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch" lookupgroup="orgLookup" height="500">选择用户所属部门</a>			
		</p> --%>
		<dl class="nowrap">
				<input type="hidden" name="roleLookup.id" value="${user.extend1}" />
				<dt>用户角色：</dt>
				<dd><input class="required textInput valid" readonly="readonly" size="40" type="text" id ="roleName" lookupgroup="roleLookup" name="roleLookup.name" autocomplete="off" value="${user.extend2}" /></input>
				<a class="btnLook" id="looks1"  href="<%=baseUrl %>/system/role/roleSearch" lookupgroup="roleLookup" height="500">选择用户角色</a></dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
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
            {'userCode':userCode,'userId':$("#id").attr('value')},
       function(data){
           if(data==false){
               alertMsg.error("已存在相同的用户登录名，请重新录入登录名！");
               $("#userCode").val("");
           }
      } ,'json');
    
} 

</script>