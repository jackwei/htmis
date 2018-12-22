<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/inCome?bill=${bill}" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>进账单编号 ：<input type="text" name="statementnumber" value=""/></td>
				<td>付款人 ：<input type="text" name="payername" value=""/></td>
				<td>案件编号 ：<input type="text" name="feenumber" value=""/></td>
				<td>到账时间：<input class="date" onblur="checkdate(this)" type="text" name="tradedate" value=""/></td>
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
	<div class="panelBar">
		<ul class="toolBar">
			<c:if test="${bill eq 'hand' }">
				<li><a iconClass="magnifier" target="navTab" rel="inComeEditNav" href="<%=baseUrl %>/management/inCome/edit/{inComeId}" title="查看"><span>查看</span></a></li>
			</c:if>
			<c:if test="${bill eq 'take' }">
				<li><a class="add" target="navTab" rel="inComeAddNav" href="<%=baseUrl %>/management/inCome/add" title="添加对账单"><span>添加</span></a></li>
				<li><a class="edit" target="navTab" rel="inComeEditNav" href="<%=baseUrl %>/management/inCome/edit/{inComeId}" title="编辑"><span>编辑</span></a></li>
				<%-- <li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/inCome/delete/{inComeId}" title="你确定要删除吗?"><span>删除</span></a></li> --%>
			</c:if>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>进账单编号</th>
				<th>案件编号</th>
				<th>付款人</th>
				<th>货币类型</th>
				<th>对账金额</th>
				<th>对账余额</th>
				<th>到账时间</th>
				<th>录入人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${billIncomeList}" varStatus="s">
			<tr target="inComeId" rel="${item.incomeId }">	
				<td>${s.index + 1}</td>
				<td>${item.statementnumber}</td>
				<td>${item.feenumber}</td>
				<td>${item.payername}</td>
				<td>${item.currency}</td>
				<td>${item.changeamount}</td>
				<td>${item.differamount}</td>
				<td><fmt:formatDate value="${item.tradedate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.entrypeople}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>