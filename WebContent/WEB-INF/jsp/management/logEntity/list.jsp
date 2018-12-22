<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post"  rel="pagerForm" action="<%=baseUrl %>/management/logEntity" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label style="width: 100px;">登录名称：</label>
					<input type="text" name="username" value="${logEntity.username }"/>
				</li>	
				<li>
					<label style="width: 100px;">登录IP：</label>
					<input type="text" name="ipAddress" value="${logEntity.ipAddress }"/>
				</li>
				<li>
					<label style="width: 100px;">日志等级：</label>
					<select name="logLevel" class="combox">
						<option value="">所有</option>
						<c:forEach var="logLevel" items="${logLevels }"> 
							<option value="${logLevel}" ${logEntity.logLevel == logLevel ? 'selected="selected"':'' }>${logLevel}</option>
						</c:forEach>
					</select>
				</li>																
			</ul>
			<%-- <ul class="searchContent">	
				<li>
					<label style="width: 100px;">日志开始时间：</label>
					<input type="text" name="startDate" class="date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${startDate}" pattern="yyyy-MM-dd"/>"/>
					<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
				</li>			
				<li>
					<label style="width: 100px;">日志结束时间：</label>
					<input type="text" name="endDate" class="date" readonly="readonly" style="float:left;" value="<fmt:formatDate value="${endDate}" pattern="yyyy-MM-dd"/>"/>
					<a class="inputDateButton" href="javascript:;" style="float:left;">选择</a>
				</li>							
			</ul> --%>			
			<div class="subBar">
				<ul>						
					<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="delete" target="selectedTodo" rel="ids" href="<%=baseUrl %>/management/logEntity/delete" title="确认要删除?"><span>删除日志</span></a></li>
		</ul>
	</div>
	
	<table class="table" layoutH="162" width="100%">
		<thead>
			<tr>
				<th width="22"><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th width="100">登录名称</th>
				<th width="100">登录IP</th>
				<th width="100" orderField="logLevel" class="${page.orderField eq 'logLevel' ? page.orderDirection : ''}">日志等级</th>
				<th >日志内容</th>
				<th width="130" orderField="createTime" class="${page.orderField eq 'createTime' ? page.orderDirection : ''}">创建时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${logEntityList}">
			<tr target="slt_uid" rel="${item.id}">
				<td><input name="ids" value="${item.id}" type="checkbox"></td>
				<td>${item.username}</td>
				<td>${item.ipAddress}</td>
				<td>${item.logLevel}</td>
				<td>${item.message}</td>
				<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../../layout/pager/panelBar.jsp"></c:import>
<%-- 	<c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>