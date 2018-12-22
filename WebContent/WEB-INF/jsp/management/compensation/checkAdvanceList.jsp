<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" target="selectedTodo" rel="checkIds" width="800" height="800" href="<%=baseUrl %>/management/claimHandle/process?navTabId=claimHandleNav" title="确认划付"><span>确认划付</span></a></li>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="400">
		<thead>
			<tr>
				<th width="20"><input type="checkbox" group="checkIds" class="checkboxCtrl"></th>
				<th>案号</th>
				<th>船名</th>
				<th>收款人</th>
				<th>划付币种</th>
				<th>划付金额</th>
				<th>业务类型</th>
				<th>划付时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseClaimList}" varStatus="s">
			<tr target="claimId" rel="${item.claimId }">
				<td><input name="checkIds" value="${item.claimId }" type="checkbox"></td>
				<td>${item.casenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.clientname}</td>
				<td>${item.currency}</td>
				<td>${item.realamount}</td>
				<td>
					<c:forEach var="ct" items="${recordtype}">
						<c:if test="${ct['dictid'] eq item.recordtype}">
							${fn:trim(ct['dictname']) }
						</c:if>
			    	</c:forEach>
				</td>
				<td><fmt:formatDate value="${item.treatdate}" pattern="yyyy-MM-dd"/>
				<%-- <td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%> 
			</tr>
		</c:forEach>
		</tbody>
	</table>
		<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>