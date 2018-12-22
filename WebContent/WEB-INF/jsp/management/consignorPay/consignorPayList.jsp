<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>
<%
	String paystatus = request.getParameter("paystatus");
%>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/consignorPay?paystatus=${paystatus}" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>收款人 ：<input type="text" name="payeename" value=""/></td>
				<td>支付金额 ：<input type="text" name="payamount" value=""/></td>
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
	<input type="hidden" target="caseId" rel="${caseId}" />
	<div class="panelBar">
		<ul class="toolBar">
			<c:choose>
				<c:when test="${paystatus eq 0 }">
					<li><a class="add" target="navTab" rel="caseNav"  href="<%=baseUrl %>/management/consignorPay/add" warn="请新建案件!" title="添加第三方划付"><span>添加</span></a></li>
					<li><a class="edit" target="navTab" rel="caseNav"  href="<%=baseUrl %>/management/consignorPay/edit/{payId}" title="编辑"><span>编辑</span></a></li>
					<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/consignorPay/delete/{payId}" title="你确定要删除吗?"><span>删除</span></a></li>
				</c:when>
				<c:when test="${paystatus eq 1 }">
					<li><a class="edit" target="navTab" rel="caseNav"  href="<%=baseUrl %>/management/consignorPay/editPay/{payId}" title="申请划付"><span>划付操作</span></a></li>
				</c:when>
				<c:otherwise>
					<li><a iconClass="magnifier" target="navTab" rel="caseNav"  href="<%=baseUrl %>/management/consignorPay/editPay/{payId}" title="查看"><span>查看</span></a></li>
				</c:otherwise>
			</c:choose>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>收款人名称</th>
		        <th>币种</th>
		        <th>支付金额</th>
		        <th>支付时间</th>
		        <th>机构</th>
		        <th>银行流水号</th>
		        <th>备注</th>
		       <!--  <th>确认时间</th> -->
		        <c:choose>
					<c:when test="${paystatus eq 0 }">
						<th>操作</th>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
		        
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${consignorPayList}" varStatus="s">
			<tr id="payId" target="payId" rel="${item.payId }">
				<td>${s.index + 1}</td>
				<td>${item.payeename}</td>
				<td>${item.paycurrency}</td>
				<td>${item.payamount}</td>
				<td><fmt:formatDate value="${item.paydate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.orgnameb}</td>
				<td>${item.banknum}</td>
				<td>${item.remark}</td>
				<%-- <td><fmt:formatDate value="${item.checkdate}" pattern="yyyy-MM-dd"/></td> --%>
				<c:choose>
					<c:when test="${paystatus eq 0 }">
						<td>
							<a class="button" title="划付审核" target="navTab" href="<%=baseUrl %>/management/consignorPay/apply?payId=${item.payId}" rel="applyNav" ><span>划付审核</span></a>
							<a class="button" title="请确认是否审核完成？" target="ajaxTodo" href="<%=baseUrl %>/management/consignorPay/applyEnd?payId=${item.payId}&navTabId=consignorPayList" rel="applyNav" ><span>审核完毕</span></a>
							
						</td>
					</c:when>
					<c:otherwise>
					</c:otherwise>
				</c:choose>
			<%--<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
		<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>