<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<form id="pagerForm" method="post" action="<%=baseUrl %>/management/case/list2" onsubmit="return divSearch(this,'list2')">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
	</form>
	
    <table class="table" width="99%" layoutH="139">
		<thead>
			<tr>
				<th width="50"></th>
				<!-- <th>案号</th> -->
				<th>账单号</th>
				<th>船名</th>
				<th>币种</th>
				<th>服务费</th>
				<th>费用</th>
				<th>担保手续费</th>
				<th>第三方总金额</th>
				<th>发账金额</th>
				<th>发账时间</th>
				<th>办案人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caselistfive}" varStatus="s">
			<tr id="billId" target="billId" rel="${item.billId }" >
				<td>${s.index + 1}</td>
				<%-- <td>${item.casenumber}${item.excasenumber}</td> --%>
				<td>${item.feenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.assurefee}</td>
				<td>${item.thirdpart}</td>
				<td>${item.feeamount}</td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<%-- 			<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
 --%>           <td>${item.username}</td>										
             </tr>
		</c:forEach>
		</tbody>
	</table>

<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>显示</span>
		<select name="pageSize" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value},rel:'list2'})">
			<c:forEach begin="0" end="20" step="10" varStatus="s">
				<option value="${s.index}" ${vo.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>

		<span>总数: ${total5}</span>
	</div>
	<div class="pagination" rel="list2"  totalCount="${total5}" numPerPage="${vo.pageSize}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
</div>	

