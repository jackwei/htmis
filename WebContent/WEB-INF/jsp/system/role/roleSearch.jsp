<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/system/role/roleSearch"  onsubmit="return dwzSearch(this, 'dialog');">

<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>角色关键词：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" multLookup="orgId" warn="请选择部门">选择带回</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">	
	 <table class="table" width="100%"  layoutH="140">
		<thead align="center">
			<tr>
			    <th width="20%"><input type="checkbox" class="checkboxCtrl" group="orgId" /></th>
			    <th width="20%" >序号</th>
				<th width="60%" >角色名称</th>				
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="item" items="${roleList}" varStatus="s">
			<tr>
			    <td><input type="checkbox" name="orgId" value="{id:'${item.id}',name:'${item.roleName}'}"/></td>
				<td>${s.index + 1}</td>
				<td>${item.roleName}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 <c:import url="../../layout/pager/panelBar.jsp"></c:import>

</div>


