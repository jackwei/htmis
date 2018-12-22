<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<script type="text/javascript">
	function balanceBack(){
		
	}
</script>

<form method="post" rel="pagerForm" action="/management/compensation/searchBalance" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value=""/></td>
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
			<%-- <li><a class="add" target="dialog" mask="true" rel="balanceBackNav" width="800" height="260" href="<%=baseUrl %>/management/compensation/balanceBack/{inComeId}?flag=add"  title="余额处理"><span>余额处理</span></a></li>
			<li><a class="delete" target="ajaxTodo" rel="balanceBackNav" href="<%=baseUrl %>/management/compensation/del/{inComeId}"  title="你确定要删除余额退回吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>收款人</th>
		        <th>划付币种</th>
		        <th>划付金额</th>
		        <th>划付汇率</th>
		        <th>核销金额</th>
		   	    <th>付款人</th>
		   	    <th>到账币种</th>
		        <th>到账金额</th>
		        <th>到账余额</th>
		        <th>到账时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${claimBalanceList}" varStatus="s">
			<tr target="inComeId" rel="${item.Income_Id }">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}</td>
				<td>${item.clientname}</td>
				<td>${item.currency}</td>
				<td>${item.realamount}</td>
				<td>${item.usdrate}</td>
				<td>${item.checkamount}</td>
				<td>${item.payer}</td>
				<td>${item.bizhong}</td>
				<td>${item.totalamount}</td>
				<td>${item.differamount}</td>
				<td><fmt:formatDate value="${item.receivedate}" pattern="yyyy-MM-dd"/></td>
	       </tr>
	      </c:forEach>
	      </tbody>
	</table>
	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>