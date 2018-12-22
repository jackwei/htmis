<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/system/org" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>部门状态：</label>
				<select name="orgStatus" class="combox">
					<option value="">所有</option>
					<c:forEach var="item" items="${orgStatusList}">
					<option value="${item.code}" ${item.code eq param.orgStatus ? 'selected="selected"' : ''}>${item.desc}</option>
					</c:forEach>
				</select>
			</li>
			<li>
				<label>关键词：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
		</ul>
		<div class="subBar">
			<%-- <span style="margin-left: 5px; line-height: 25px; float: left">总数: <strong>${totalCount}</strong></span> --%>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<%-- <li><a class="add" target="navTab" rel="orgAddNav" href="<%=baseUrl %>/system/org/add" title="新增组织"><span>添加</span></a></li> --%>
			<li><a class="edit" target="navTab" rel="orgEditNav" href="<%=baseUrl %>/system/org/edit/{slt_objId}" title="编辑组织"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/system/org/delete/{slt_objId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<!-- <th>组织类型</th>
				<th>组织层级</th> -->
				<th>组织编码</th>
				<th>组织简称</th>
				<th>组织全称</th>
				<th>英文名称</th>
				<th>地址</th>
				<th>电话</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${orgList}" varStatus="s">
			<tr target="slt_objId" rel="${item.Org_Id }">
				<td>${s.index + 1}</td>
				<%-- <td>${item.orgType.name}</td>
				<td>${item.orgLevel.desc}</td>	 --%>
				<td>${item.Org_Id}</td>
				<td>${item.Org_Sname}</td>
				<td>${item.Org_Name}</td>				
				<td>${item.Org_EName}</td>
				<td>${item.Link_Address}</td>
				<td>${item.Link_Phone}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../../layout/pager/panelBar.jsp"></c:import>
</div>