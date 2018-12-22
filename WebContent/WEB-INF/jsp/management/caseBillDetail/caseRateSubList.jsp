<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

 <%
	 String billId = "0";
	 if(request.getSession().getAttribute("billId") != null){
		 billId = request.getSession().getAttribute("billId").toString();
	 }
 %>
 
<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="400">
		<thead>
			<tr>
				<th width="30">No.</th>
				<th>收款人</th>
				<th>付款人</th>
				<th>赔款汇差</th>
				<th>赔款汇率</th>
				<th>赔款币种</th>
				<th>计算日期</th>
				<th>发账日期</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${claimRateSubList}" varStatus="s">
			<tr target="claimId" rel="${item.rateId }">
				<td>${s.index + 1}</td>
				<td>${item.clientname}</td>
				<td>${item.payer}</td>
				<td>${item.cratesub}</td>
				<td>${item.accrate}</td>
				<td>${item.currency}</td>
				<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd"/></td>
				<td>
					<c:if test="${billId eq item.billId}">
						<a class="button" target="ajaxTodo" rel="caseRateSubNav" href="<%=baseUrl %>/management/caseBillDetail/insertRateSub?navTabId=billEditNav&rateId=${item.rateId}&flag=del" title="撤销汇差?"><span>撤销</span></a>
					</c:if>
					<c:if test="${billId ne item.billId}">
						<a class="button" target="ajaxTodo" rel="caseRateSubNav" href="<%=baseUrl %>/management/caseBillDetail/insertRateSub?navTabId=billEditNav&rateId=${item.rateId}&flag=add" title="添加汇差"><span>添加</span></a>
					</c:if>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>
