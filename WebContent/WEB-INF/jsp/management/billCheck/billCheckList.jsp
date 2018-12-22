<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import="com.git.db.beans.BillIncomeImpl" %>
<%
	BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getAttribute("billIncomeImpl");
	request.setAttribute("billIncomeImpl",billIncomeImpl);
%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/billCheck/searchCheck" onsubmit="return divSearch(this,'billCheck')">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>编号 ：<input type="text" name="feenum" value=""/></td>
				<td>发账金额 ：<input type="text" name="feeamount_start" value=""/> ~ <input type="text" name="feeamount_end" value=""/></td>
				<td>付款人 ：<input type="text" name="payername" value=""/></td>
				<td><button type="submit">搜索</button></td>
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<!-- <li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li> -->
				<li><div class="buttonActive"><a title="确定要对账核销吗?" target="selectedTodo" rel="checkIds" href="<%=baseUrl %>/management/billCheck/process?navTabId=billCheckNav&callbackType=closeCurrent"><span>确认对账</span></a></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent" >
	<table class="table" width="100%" layoutH="270">
		<thead>
			<tr>
				<th width="20"><input type="checkbox" group="checkIds" class="checkboxCtrl"></th>
				<th>账单编号</th>
				<th>付款人</th>
				<th>所属部门</th>
				<th>货币类型</th>
				<th>费用</th>
				<th>收入</th>
				<th>代收款</th>
				<th>发账金额</th>
				<th>对账余额</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${billCheckList}" varStatus="s">
			<tr>	
				<td><input name="checkIds" value="${item.checkId }" type="checkbox"></td>
				<td>${item.feenum}</td>
				<td>${item.payername}</td>
				<td>${item.orgname}</td>
				<td>${item.currency}</td>
				<td>${item.expends}</td>
				<td>${item.income}</td>
				<td>${item.replaceamount}</td>
				<td>${item.feeamount}</td>
				<td>${item.differamount}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
		<div class="pages">
			<span>Per Page</span>
			<select name="pageSize" onchange="navTabPageBreak({targetType:'navTab',data:{numPerPage:this.value}})">
				<c:forEach begin="20" end="20" step="10" varStatus="s">
					<option value="${s.index}" ${vo.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
				</c:forEach>
			</select>
	
			<span>Total: ${vo.totalCount}</span>
		</div>
		
		<div class="pagination" targetType="${targetType}" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
	</div>
</div>