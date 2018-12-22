<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/compensation" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value=""/></td>
				<td>付款人 ：<input type="text" name="payer" value=""/></td>
				<td>赔款到账 ：<input class="date" onblur="checkdate(this)" type="text" name="receivedate" value=""/></td>
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<div class="panelBar">
		<ul class="toolBar">
			<c:if test="${flag eq '0' }">
				<li><a class="add" target="navTab" rel="compensationAddNav" width="800" height="223" href="<%=baseUrl %>/management/compensation/add" warn="请新建案件!" title="添加赔款"><span>添加</span></a></li>
				<li><a class="edit" target="navTab" rel="compensationEditNav" width="800" height="223" href="<%=baseUrl %>/management/compensation/edit/{inComeId}" title="编辑"><span>编辑</span></a></li>
				<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/compensation/delete/{inComeId}" title="你确定要删除吗?"><span>删除</span></a></li>
			</c:if>
			<c:if test="${flag eq '1' }">
				<li><a class="edit" target="navTab" rel="compensationEditNav" width="800" height="223" href="<%=baseUrl %>/management/compensation/process/{inComeId}" title="处理"><span>处理</span></a></li>
			</c:if>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
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
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>