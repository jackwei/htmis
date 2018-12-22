<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import="com.git.db.beans.BillIncomeImpl" %>
<%
	BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getAttribute("billIncomeImpl");
	request.setAttribute("billIncomeImpl",billIncomeImpl);
%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<script type="text/javascript">

function printFeelist(checkId){
	open("<%=baseUrl %>/management/billCheck/printBillNote?checkId="+checkId,"账单", 'width:800,height:600,menubar=yes, resizable=yes,scrollbars=yes');
}

</script>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/billCheck/search" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>账单编号 ：<input type="text" name="feenum" value="${param.feenum }"/></td>
				<td>发账金额 ：<input type="text" name="feeamount_start" value="${param.feeamount_start }"/> ~ <input type="text" name="feeamount_end" value="${param.feeamount_end }"/></td>
				<td>付款人 ：<input type="text" name="payername" value="${param.payername }"/></td>
				<td>
					<select class="combox required" name="printBill">
						<option value="" ${ '' eq param.printBill? 'selected="selected"' : ''}>请选择</option>
						<option value="1" ${ 1 eq param.printBill? 'selected="selected"' : ''} >未打印</option>
						<option value="2" ${ 2 eq param.printBill? 'selected="selected"' : ''} >已打印 </option>
						
					</select>
				</td>
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				<%-- <li><div class="buttonActive"><a title="确实要吗?" target="selectedTodo" rel="checkIds" href="<%=baseUrl %>/management/billCheck/process"><span>确认对账</span></a></div></li> --%>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent" >
	<div class="panelBar">
		<ul class="toolBar">
			<!-- <li><a class="edit" onclick="printFeelist({checkId});" href="javascript:printFeelist({checkId});" title="打印"><span>打印</span></a></li>
 			<li class="line">line</li> -->
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
		<thead> 
			<tr>
				<!-- <th width="20"><input type="checkbox" group="checkIds" class="checkboxCtrl"></th> -->
				<th width="50"></th>
				<th>账单编号</th>
				<th>所属部门</th>
				<th>货币类型</th>
				<th>收入</th>
				<!-- <th>付款人</th> -->
				<th>第三方金额</th>
				<th>担保金额</th>
				<th>发账日期</th>
				<th>发账金额</th>
				<th>对账余额</th>
				<th>打印时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${billCheckList}" varStatus="s">
			<tr id="checkId" target="checkId" rel="${item.checkId }">	
				<%-- <td><input name="checkIds" value="${item.checkId }" type="checkbox"></td> --%>
				<td>${s.index + 1}</td>
				<td>${item.feenum}</td>
				<td>${item.orgname}</td>
				<td>${item.currency}</td>
				<td>${item.extend2}</td>
				<%-- <td>${item.payername}</td> --%>
				<td>${item.payamount}</td>
				<td>${item.extend1}</td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.feeamount}</td>
				<td>${item.differamount}</td>
				<td><fmt:formatDate value="${item.printdate}" pattern="yyyy-MM-dd"/></td>
				<td><input type="button" onclick="printFeelist('${item.checkId }')" value="打印"> </td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>