<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/consignorPay/searchUnBind"  onsubmit="return divSearch(this, 'unbind');">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>账单号 ：<input type="text" name="feenumber" value=""/></td>
				<td><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div>	</td>
			</tr>
		</table>
		
		<!-- <div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div> -->
	</div>
</div>
</form>

<div class="pageContent">
	<input type="hidden" id="forwardUrl" name="forwardUrl" value="<%=baseUrl %>/management/consignorPay/apply?payId={payId}"/>
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" target="selectedTodo" rel="detailIds" href="<%=baseUrl %>/management/consignorPay/checkPay?forwardUrl=<%=baseUrl %>/management/consignorPay/apply?payId={payId}&flag=bind&navTabId=applyNav&callbackType=forward" title="确认支付"><span>确认支付</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="99%" layoutH="200" >
		<thead>
			<tr>
				<th width="20"><input type="checkbox" group="detailIds" class="checkboxCtrl"></th>
				<th>单位名称</th>
				<th>账单号</th>
				<th>货币类型</th>
				<th>服务费</th>
				<th>费用</th>
				<th>代垫款</th>
				<th>总金额</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${unbindBillDetailList}" varStatus="s">
			<tr target="detailId" rel="${item.Detail_Id }">
				<td><input name="detailIds" value="${item.Detail_Id }" type="checkbox"></td>
				<td>${item.consignorname}</td>
				<td>${item.feenumber}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.replacefee}</td>
				<td>${item.accamount}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>