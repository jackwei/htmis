<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseBillImpl" %>
<%
	CaseBillImpl caseBillImpl = (CaseBillImpl)request.getAttribute("caseBillImpl");
%>
<div class="pageContent" >
	 	<input type="hidden" id="billId" target="billId" rel="<%=caseBillImpl.getBillId()==null ? "":caseBillImpl.getBillId() %>" value="<%=caseBillImpl.getBillId()==null ? "":caseBillImpl.getBillId()  %>" />
	<div class="panelBar">	
		<ul class="toolBar">
			<c:choose>
				<c:when test="${casestatus eq 9}">
					<li><a iconClass="magnifier" target="dialog" mask="true" rel="bookNav" width="800" height="190" href="<%=baseUrl %>/management/caseBillDetail/editOther/{dtid}?flag=view" title="查看"><span>查看</span></a></li>
				</c:when>
				<c:otherwise>
					<c:if test="${caseBillImpl.feestatuse eq 0 }">
						<li><a class="add" target="dialog" mask="true" rel="bookNav" width="800" height="190" href="<%=baseUrl %>/management/caseBillDetail/addOther/{billId}" warn="请保存账单信息" title="添加账单"><span>添加</span></a></li>
						<li><a class="edit" target="dialog" mask="true" rel="bookNav" width="800" height="190" href="<%=baseUrl %>/management/caseBillDetail/editOther/{dtid}" title="编辑"><span>编辑</span></a></li>
						<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/caseBillDetail/otherdelete/{dtid}?flag=2" title="你确定要删除吗?"><span>删除</span></a></li>
					</c:if>
					<c:if test="${caseBillImpl.feestatuse eq 1 || caseBillImpl.feestatuse eq 2}">
						<li><a iconClass="magnifier" target="dialog" mask="true" rel="bookNav" width="800" height="190" href="<%=baseUrl %>/management/caseBillDetail/editOther/{dtid}?flag=view" title="查看"><span>查看</span></a></li>
					</c:if>
				</c:otherwise>
			</c:choose>
			
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="100%" layoutH="400" >
		<thead>
			<tr>
				<th width="50"></th>
				<th>时间</th>
				<th>项目</th>
				<th>币种</th>
				<th>金额</th>
				<th>折算汇率</th>
				<th>记账金额</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${otherBillList}" varStatus="s">
			<tr target="dtid" rel="${item.detailId }">
				<td>${s.index + 1}</td>
				<td><fmt:formatDate value="${item.happendate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.remark}</td>
				<td>${item.currency}</td>
				<td>${item.feeamount}</td>
				<td>${item.changerate}</td>
				<td>${item.accamount}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<%-- <c:import url="../../layout/pager/panelBar.jsp"></c:import> --%>
	<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>