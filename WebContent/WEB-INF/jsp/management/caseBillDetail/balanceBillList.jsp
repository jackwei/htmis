<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<%-- <li><a class="add" target="dialog" mask="true" rel="balanceBackNav" width="800" height="260" href="<%=baseUrl %>/management/compensation/balanceBack/{inComeId}?flag=add"  title="余额处理"><span>余额处理</span></a></li>
			<li><a class="delete" target="ajaxTodo" rel="balanceBackNav" href="<%=baseUrl %>/management/compensation/del/{inComeId}"  title="你确定要删除余额退回吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="99%" layoutH="400">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
		   	    <th>付款人</th>
		        <th>币种</th>
		        <th>到账金额</th>
		        <th>银行手续费</th>
		        <th>合计金额</th>
		        <th>到账余额</th>
		        <th>到账时间</th>
		        <th>处理状态</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${balanceBillList}" varStatus="s">
			<tr target="inComeId" rel="${item.Income_Id }">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}</td>
				<td>${item.payer}</td>
				<td>${item.currency}</td>
				<td>${item.receiveamount}</td>
				<td>${item.bankfee}</td>
				<td>${item.totalamount}</td>
				<td>${item.differamount}</td>
				<td><fmt:formatDate value="${item.receivedate}" pattern="yyyy-MM-dd"/></td>
				<c:if test="${caseBillImpl.feestatuse eq 0 }">
					<td>
						<c:if test="${caseBillImpl.billId eq item.bill_id}">
							<a class="button" target="ajaxTodo" rel="caseRateSubNav" href="<%=baseUrl %>/management/caseBillDetail/insertBalance?navTabId=billEditNav&inComeId=${item.Income_Id}&flag=del" title="撤销余额?"><span>撤销</span></a>
						</c:if>
						<c:if test="${caseBillImpl.billId ne item.bill_id}">
							<a class="button" target="ajaxTodo" rel="caseRateSubNav" href="<%=baseUrl %>/management/caseBillDetail/insertBalance?navTabId=billEditNav&inComeId=${item.Income_Id}&flag=add" title="添加余额?"><span>添加</span></a>
						</c:if>
					</td>
				</c:if>
				<c:if test="${caseBillImpl.feestatuse ne 0 }">
					<c:choose>
						<c:when test="${caseBillImpl.billId eq item.bill_id}">
							<td>已添加</td>
						</c:when>
						<c:when test="${item.bill_id eq 0}">
							<td>待添加</td>
						</c:when>
						<c:otherwise>
							<td>请保存账单信息</td>
						</c:otherwise>
					</c:choose>
					
				</c:if>
			</tr>
		</c:forEach>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
		</tbody>
	</table>
		<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>