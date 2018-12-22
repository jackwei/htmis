<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<script type="text/javascript">
	
$(function(){
	//alert($("#usdrate").val());
});
	
</script>


<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<c:if test="${flag ne 'lock' }">
				<%-- <li><a class="edit" target="ajaxTodo"  href="<%=baseUrl %>/management/claimHandle/process/{inComeId},{usdrate},{isSubRate},{realamount},{currency}?navTabId=claimHandleList&callbackType=closeCurrent" title="确认划付"><span>确认划付</span></a></li> --%>
				<li><a class="edit" target="ajaxTodo"  href="<%=baseUrl %>/management/claimHandle/verification/{inComeId},{claimId}?navTabId=claimHandleList&callbackType=closeCurrent" title="确认划付"><span>确认划付</span></a></li>
			</c:if>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="350">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
		   	    <th>付款人</th>
		        <th>币种</th>
		        <th>到账金额</th>
		        <th>银行手续费</th>
		        <th>合计金额</th>
		        <th>对账余额</th>
		        <th>到账时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${claimIncomeList}" varStatus="s">
			<tr target="inComeId" rel="${item.incomeId }">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}</td>
				<td>${item.payer}</td>
				<td>${item.currency}</td>
				<td>${item.receiveamount}</td>
				<td>${item.bankfee}</td>
				<td>${item.totalamount}</td>
				<td>${item.differamount}</td>
				<td><fmt:formatDate value="${item.receivedate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>