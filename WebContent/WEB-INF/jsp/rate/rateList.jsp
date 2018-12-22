<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<%=baseUrl %>/rate" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>查询日期 ：<input type="text" class="date required" name="searchDate" value=""/></td>
				<td>币种简写：<input type="text" name="shortname" /></td>    
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询汇率</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">
		<table class="table" width="99%" layoutH="113">
			<thead>
				<tr>
					<th width="50"></th>
					<th>币种</th>
					<th>币种简写</th>
					<th>中间价</th>
					<th>现汇买入价</th>
					<th>现钞买入价</th>
					<th>卖出价 </th>
					<th>查询日期</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${rateList}" varStatus="s">
				<tr target="claimId">
					<td>${s.index + 1}</td>
					<td>${item.currency}</td>
					<td>${item.shortname}</td>
					<td>${item.rate1}</td>
					<td>${item.rate2}</td>
					<td>${item.rate3}</td>
					<td>${item.rate4}</td>
					<td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd"/></td>
					<%--<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		<c:import url="../layout/pager/panelBar.jsp"></c:import>
	 	 
</div>