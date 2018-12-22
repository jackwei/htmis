<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

 <c:import url="../_frag/pager/pagerForm.jsp"></c:import>
 <div class="pageHeader">
	<form rel="pagerForm" method="post" action="demo/database/dwzOrgLookup2.html" onsubmit="return dwzSearch(this, 'dialog');">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>部门名称:</label>
				<input class="textInput" name="orgName" value="" type="text">
			</li>	  
		</ul>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">查询</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" multLookup="claimId" warn="请选择部门">选择带回</button></div></div></li>
			</ul>
		</div>
	</div>
	</form>
</div>
 
<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<table class="table" width="100%" layoutH="110">
		<thead>
			<tr>
				<th width="30"><input type="checkbox" class="checkboxCtrl" group="claimId" /></th>
				<th>ID</th>
				<th>收款人</th>
				<th>申请类型</th>
				<th>划付币种</th>
				<th>划付金额</th>
				<th>划付时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseClaimList}" varStatus="s">
			<tr target="claimId" rel="${item.claimId }">
				<td><input type="checkbox" name="claimId" value="{claimId:'${item.claimId}',realamount:'${item.realamount}'}"/></td>
				<td>${item.claimId}</td>
				<td>${item.clientname}</td>
				<td>
					<c:forEach var="ct" items="${recordtype}">
						<c:if test="${ct['dictid'] eq item.recordtype}">
							${fn:trim(ct['dictname']) }
						</c:if>
			    	</c:forEach>
				</td>
				<td>${item.currency}</td>
				<td>${item.realamount}</td>
				<td><fmt:formatDate value="${item.treatdate}" pattern="yyyy-MM-dd"/></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>
