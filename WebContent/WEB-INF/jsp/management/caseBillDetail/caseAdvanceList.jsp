<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseBillImpl" %>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
 
<%
	CaseBillImpl caseBillImpl = (CaseBillImpl)request.getAttribute("caseBillImpl");
%>

<div class="pageContent">
 	<input type="hidden" id="billId" value="${caseBillImpl.billId }" />
	<div class="panelBar">
		<ul class="toolBar">
			<%-- <li><a class="edit" target="selectedTodo" rel="checkIds" href="<%=baseUrl %>/management/caseBillDetail/insertAdvance?navTabId=billEditNav"  title="添加到账单"><span>添加到账单</span></a></li> --%>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="400">
		<thead>
			<tr>
				<!-- <th width="20"><input type="checkbox" group="checkIds" class="checkboxCtrl"></th> -->
				<th width="30">No.</th>
				<th>收款人</th>
				<th>申请类型</th>
				<th>划付币种</th>
				<th>划付金额</th>
				<th>划付时间</th>
				<th>汇率</th>
				<th>记账金额</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseClaimList}" varStatus="s">
			<tr target="claimId" rel="${item.claimId }">
				<%-- <td><input name="checkIds" value="${item.claimId}" <c:if test="${billId eq item.billId}"> checked="checked" </c:if>  type="checkbox"></td> --%>
				<td>${s.index + 1}</td>
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
				<td>${item.usdrate}</td>
				<td>${item.usdamount}</td>
				<c:if test="${caseBillImpl.feestatuse eq 0 }">
					<td>
						<c:if test="${caseBillImpl.billId eq item.billId}">
							<a class="button" target="ajaxTodo" rel="caseRateSubNav" href="<%=baseUrl %>/management/caseBillDetail/insertAdvance?navTabId=billEditNav&claimId=${item.claimId}&flag=del" title="撤销费用?"><span>撤销</span></a>
						</c:if>
						<c:if test="${caseBillImpl.billId ne item.billId}">
							<a id="addAdvance" target="dialog" class="button"  mask="true" width="800" height="220" rel="caseRateSubNav" href="<%=baseUrl %>/management/caseBillDetail/editAdvance?navTabId=billEditNav&claimId=${item.claimId}&flag=add" title="添加费用"><span>添加</span></a>
						</c:if>
					</td>
				</c:if>
				<c:if test="${caseBillImpl.feestatuse ne 0 }">
					<td>请保存账单信息</td>
				</c:if>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>
