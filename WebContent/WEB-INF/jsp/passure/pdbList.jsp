<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageHeader">
<form id="pagerForm" method="post" action="<%=baseUrl %>/passure/searchPassure" onsubmit="return divSearch(this,'passure')">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>
</div>

<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<table class="table" width="99%" layoutH="160">
		<thead>
			<tr>
				<th width="50"></th>
				<th>反担保人</th>
				<th>担保编号</th>
				<th>状态</th>
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
				<td>${item.rewarrantersn}</td>
				<td>${item.assurenum}</td>
				<td>
				   <c:forEach var="status" items="${assurestatue}">
						<c:if test="${status.code eq item.feestatuse }">${status.desc}</c:if>
					</c:forEach>
				</td>
				<td>${item.currency}</td>
				<td>${item.assurefee}</td>
				<td><fmt:formatDate value="${item.issuedate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.servicefee}</td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.paydate}" pattern="yyyy-MM-dd"/></td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>显示</span>
		<select name="pageSize" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value},rel:'passure'})">
			<c:forEach begin="0" end="20" step="10" varStatus="s">
				<option value="${s.index}" ${vo.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>

		<span>总数: ${vo2.totalCount}</span>
	</div>
	<div class="pagination" rel="passure" totalCount="${vo2.totalCount}" numPerPage="${vo2.pageSize}" pageNumShown="10" currentPage="${vo2.pageNum}"></div>
</div>

</div>