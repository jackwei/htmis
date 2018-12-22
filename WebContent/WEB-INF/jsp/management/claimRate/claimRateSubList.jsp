<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/claimRate/search" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value=""/></td>
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
<%-- 	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="caseNav" width="800" height="223" href="<%=baseUrl %>/management/claim/add/{caseId}" warn="请新建案件!" title="添加赔款"><span>添加</span></a></li>

 			<li><a class="edit" target="navTab" rel="caseNav" href="<%=baseUrl %>/management/claimHandle/edit/{claimId}" title="处理"><span>处理</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/claim/delete/{claimId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div> --%>
	
		<table class="table" width="99%" height="30%" >
			<thead>
				<tr>
					<th width="50"></th>
					<th>案件号</th>
					<th>收款人</th>
					<th>付款人</th>
					<!-- <th>账单号</th> -->
					<th>币种</th>
					<th>汇差</th>
					<th>发账汇率</th>
					<th>发账金额 </th>
					<!-- <th>发账时间</th> -->
					<th>到账时间</th>
					<th>计算时间</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${claimRateSubImplList}" varStatus="s">
				<tr target="claimId" rel="${item.rateId }">
					<td>${s.index + 1}</td>
					<td>${item.casenumber}</td>
					<td>${item.clientname}</td>
					<td>${item.payer}</td>
					<%-- <td>${item.billId}</td> --%>
					<td>${item.currency}</td>
					<td>${item.cratesub}</td>
					<td>${item.accrate}</td>
					<td>${item.accamount}</td>
					<%-- <td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd"/></td> --%>
					<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd"/></td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>