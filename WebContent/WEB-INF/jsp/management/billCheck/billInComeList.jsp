<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<%
	String flag = request.getParameter("flag");
%>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/billCheck?flag=${flag}" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>进账单编号 ：<input type="text" name="statementnumber" value=""/></td>
				<td>对账金额 : <input type="text" name="changeamount" value=""/></td>
				<td>付款人 ：<input type="text" name="payername" value=""/></td>
				<td>账单编号 ：<input type="text" name="feenumber" value=""/></td>
			</tr>
			<tr>
				<td> &nbsp;&nbsp;&nbsp;到账时间 ：<input class="date" onblur="checkdate(this)" type="text" name="tradedate" value=""/></td>
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
			<c:if test="${flag eq '0'}">
	 			<li><a class="edit" target="navTab" rel="caseNav" href="<%=baseUrl %>/management/billCheck/check/{inComeId}" title="对账"><span>对账</span></a></li>
			</c:if>
			<c:if test="${flag eq '1'}">
				<li><a iconClass="magnifier" target="navTab" rel="caseNav" href="<%=baseUrl %>/management/billCheck/checked/{inComeId}" title="查看"><span>查看</span></a></li>
			</c:if>
 			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="99%" layoutH="158">
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
				<th>操作</th>
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
				<td><a class='button' target="dialog" mask="true" rel="downNav" width="600" height="300"  href='<%=baseUrl %>/FileDown/openFile?oId=${item.incomeId}&docType=inComedoc'><span>查看附件</span></a></td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>