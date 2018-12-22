<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<c:import url="../../layout/pager/pagerForm.jsp"></c:import>
	<form method="post" rel="pagerForm" action="<%=baseUrl %>/system/role" onsubmit="return navTabSearch(this)">
			
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
					<label>角色关键词：</label>
					<input type="text" name="keywords" value="${param.keywords}"/>
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
			<li><a class="add" target="navTab" rel="roleAddNav" href="<%=baseUrl %>/system/role/add" title="新增角色"><span>添加角色</span></a></li>
			<li class="line">line</li>	
			<li><a class="edit" target="navTab" rel="roleEditNav" href="<%=baseUrl %>/system/role/edit/{slt_objId}" title="编辑角色"><span>编辑角色</span></a></li>
			<li class="line">line</li>			
		</ul>
	</div>
	<table class="table" width="99%" layoutH="138" >
		<thead>
			<tr>
				<th width="50"></th>				
				<th>角色名称</th>
				<th>角色状态</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${roleList}" varStatus="s">
			<tr target="slt_objId" rel="${item.id }">
				<td>${s.index + 1}</td>
				<td>${item.roleName}</td>				
				<td>${item.roleStatus.desc}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>	
	<c:import url="../../layout/pager/panelBar.jsp"></c:import>
</div>