<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<table class="table" width="99%" layoutH="135">
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

	<c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>