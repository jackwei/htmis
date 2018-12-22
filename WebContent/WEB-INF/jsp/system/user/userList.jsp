<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<c:import url="../../layout/pager/pagerForm.jsp"></c:import>
	<form method="post" rel="pagerForm" action="<%=baseUrl %>/system/user" onsubmit="return navTabSearch(this)">
			
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<label>用户关键词：</label>
					<input type="text" name="keywords" value="${param.keywords}"/>
				</td>
				<td>
					<label>用户状态：</label>
					<select name="userStatus" class="combox">
						<option value="">所有</option>
						<c:forEach var="item" items="${userStatusList}">
						<option value="${item.code}" ${item.code eq param.userStatus? 'selected="selected"' : ''}>${item.desc}</option>
						</c:forEach>
					</select>	
				</td>
				<td>
					<label>部门：</label>
					<select name="userGroup" class="combox">
						<option value="">所有</option>
						<c:forEach var="item" items="${groupList}">
						<option value="${item.Org_Id}" ${item.Org_Id eq param.userGroup ? 'selected="selected"' : ''}>${item.Org_Name}</option>
						</c:forEach>
					</select>	
					
				</td>				
			</tr>
		</table>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>

<div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
<div class="panelBar">
		<ul class="toolBar">
			<%-- <li><a class="add" target="navTab" rel="userAddNav" href="<%=baseUrl %>/system/user/add" title="新增用户"><span>添加用户</span></a></li> --%>
			<li><a class="edit" target="navTab" rel="userEditNav" href="<%=baseUrl %>/system/user/edit/{slt_objId}" title="编辑用户"><span>编辑用户</span></a></li>
			<%-- <li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/system/user/delete/{slt_objId}" title="你确定要删除吗?"><span>删除用户</span></a></li> --%>
			<li class="line">line</li>
			<li><a class="icon" target="ajaxTodo" href="<%=baseUrl %>/system/user/inactive/{slt_objId}" title="你确定要冻结该用户吗?"><span>冻结用户</span></a></li>
			<li><a class="icon" target="ajaxTodo" href="<%=baseUrl %>/system/user/normal/{slt_objId}" title="你确定要解冻该用户吗?"><span>恢复正常</span></a></li>
		</ul>
	</div>
	<table class="table" width="99%" layoutH="138" >
		<thead>
			<tr>
				<th width="50"></th>				
				<th>用户名</th>
				<th>用户简称</th>
				<th>用户姓名</th>
				<th>用户英文名</th>
				<th>用户邮箱</th>
				<th>联系电话</th>
				<!-- <th>所属部门</th> -->
				<th>用户角色</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${userList}" varStatus="s">
			<tr target="slt_objId" rel="${item.User_Id }">
				<td>${s.index + 1}</td>
				<td>${item.User_Code}</td>
				<td>${item.S_Name}</td>	
				<td>${item.Name}</td>
				<td>${item.En_Name}</td>
				<td>${item.Email}</td>
				<td>${item.Phone}</td>
				<%-- <td>${item.orgName}</td> --%>
				<td>${item.Extend2}</td>						
			</tr>
		</c:forEach>
		</tbody>
	</table>	
	<c:import url="../../layout/pager/panelBar.jsp"></c:import>
</div>