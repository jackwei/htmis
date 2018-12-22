<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>
<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>
<%-- <c:import url="../../layout/pager/pagerForm.jsp"></c:import> --%>
<form id="pagerForm" method="post" action="<%=baseUrl %>/management/handle/searchHandle">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>

<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<div class="panelBar">
		<ul class="toolBar">
			<c:choose>
				<c:when test="${caseInfoImpl.casestatus eq 9 }">
				</c:when>
				<c:otherwise>
					<li><a class="add" target="dialog" mask="true" rel="handleAddNav" width="800" height="125" href="<%=baseUrl %>/management/handle/add/{caseId}" warn="请新建案件!" title="添加赔款"><span>添加</span></a></li>
					<li><a class="edit" target="dialog" mask="true" rel="handleEditNav" width="800" height="125" href="<%=baseUrl %>/management/handle/edit/{seqId},{caseId}" title="编辑"><span>编辑</span></a></li>
					<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/handle/delete/{seqId}"  title="你确定要删除吗?"><span>删除</span></a></li>
				</c:otherwise>
			</c:choose>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="160">
		<thead>
			<tr>
				<th width="50"></th>
				<th>协办机构</th>
				<th>协办人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseHandleList}" varStatus="s">
			<tr target="seqId" rel="${item.seqId }">
				<td>${s.index + 1}</td>
				<td>${item.orgname}</td>
				<td>${item.username}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>