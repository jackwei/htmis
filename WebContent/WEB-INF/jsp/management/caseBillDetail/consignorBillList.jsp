<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseBillImpl" %>

<c:import url="../_frag/pager/pagerForm.jsp"></c:import>

<%
	CaseBillImpl caseBillImpl = (CaseBillImpl)request.getAttribute("caseBillImpl");
%>

<div class="pageContent">
 	<input type="hidden" id="billId" target="billId" value="${caseBillImpl.billId }" />
	<input type="hidden" id="doctype" name="doctype" value="thirdparty">
	<div class="panelBar">
		<ul class="toolBar">
			<c:choose>
				<c:when test="${casestatus eq 9 }">
					<li><a iconClass="magnifier" target="dialog" mask="true" rel="consignorBillEditNav" width="800" height="280" href="<%=baseUrl %>/management/caseBillDetail/editConsignor/{detailId}?flag=view" title="查看"><span>查看</span></a></li>
				</c:when>
				<c:otherwise>
					<c:if test="${caseBillImpl.feestatuse eq 0 }">
					<li><a class="add" target="dialog" mask="true" rel="consignorBillAddNav" href="<%=baseUrl %>/management/caseBillDetail/addConsignor/{billId}" warn="请保存账单信息" width="800" height="260" title="添加账单"><span>添加</span></a></li>
					<li><a class="edit" target="dialog" mask="true" rel="consignorBillEditNav" width="800" height="280" href="<%=baseUrl %>/management/caseBillDetail/editConsignor/{detailId}" title="编辑"><span>编辑</span></a></li>				
	 				<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/caseBillDetail/thirddelete/{detailId}" title="你确定要删除吗?"><span>删除</span></a></li>
	                <li><a class="edit"  target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{detailId},{doctype}" title="附件上传" ><span>上传/查看附件</span></a></li>
					</c:if>
					<c:if test="${caseBillImpl.feestatuse eq 1 || caseBillImpl.feestatuse eq 2}">
						<li><a iconClass="magnifier" target="dialog" mask="true" rel="consignorBillEditNav" width="800" height="280" href="<%=baseUrl %>/management/caseBillDetail/editConsignor/{detailId}?flag=view" title="查看"><span>查看</span></a></li>
					</c:if>
				</c:otherwise>
			</c:choose>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->	
		</ul>
	</div>
 	<table class="table" width="100%" layoutH="400" >
		<thead>
			<tr>
				<th width="50"></th>
				<th>单位名称</th>
				<th>货币类型</th>
				<th>服务费</th>
				<th>费用</th>
				<th>代垫款</th>
				<!-- <th>总金额</th> -->
				<th>记账金额</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${consignorBillList}" varStatus="s">
			<tr id="detailId" target="detailId" rel="${item.detailId }">
				<td>${s.index + 1}</td>
				<td>${item.consignorname}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.replacefee}</td>
				<%-- <td>${item.feeamount}</td> --%>
				<td>${item.accamount}</td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<%-- <c:import url="../../layout/pager/panelBar.jsp"></c:import> --%>
</div>