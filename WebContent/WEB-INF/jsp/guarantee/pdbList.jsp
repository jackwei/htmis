<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>


<form method="post" rel="pagerForm" action="<%=baseUrl %>/guarantee/searchPassure?caseId=${caseId}" onsubmit="return iframeCallback(this,navTabAjaxDone);">
</form>
<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" rel="caseNav" width="800" height="500" href="<%=baseUrl %>/guarantee/add/{caseId}" warn="请新建案件!" title="添加中再担保"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" rel="caseNav" width="800" height="500" href="<%=baseUrl %>/guarantee/pedit/{seqId}" title="编辑"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/guarantee/pdelete/{seqId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="160">
		<thead>
			<tr>
				<th width="50"></th>
				<th>反担保人</th>
				<th>担保编号</th>
				<th>币种</th>
				<th>担保金额</th>
				<th>出具时间</th>
				<th>担保手续费</th>
				<th>发账时间</th>
				<th>到账时间</th>
				<th>划付时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${passurelist}" varStatus="s">
			<tr target="seqId" rel="${item.passureid}">
				<td>${s.index + 1}</td>
				<td>${item.rewarranter}</td>
				<td>${item.assurenum}</td>
				<td>${item.currency}</td>
				<td>${item.assurefee}</td>
				<td><fmt:formatDate value="${item.issuedate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.servicefee}</td>
				<td>${item.accdate}</td>
				<td>${item.arrdate}</td>
				<td>${item.paydate}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>