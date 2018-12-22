<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>

<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>

<script type="text/javascript">

function aa(ss){
	alert(ss);
}

function editBill(status){
	if(status == 9){
		var btn = document.getElementById("viewBill");
		btn.click();
	}else{
		var btn = document.getElementById("editBill");
		btn.click();
	}
	//$('#editCase').click();
}
</script>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

 <div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseInfoImpl.getCaseId() }" />
	<div class="panelBar" >
		<ul class="toolBar">
			<c:if test="${caseInfoImpl.casestatus eq 9 }">
				<li><a id="viewBill" iconClass="magnifier" target="navTab" rel="billEditNav" href="<%=baseUrl %>/management/caseBill/edit/{billId}?flag=view" title="账单信息"><span>查看</span></a></li>
			</c:if>
			<c:if test="${caseInfoImpl.casestatus ne 9 }">
				<li><a class="add" target="navTab" rel="billEditNav" href="<%=baseUrl %>/management/caseBill/add/{caseId}" warn="请新建案件!" title="添加账单" ><span>添加</span></a></li>
				<li><a id="editBill" class="edit" target="navTab" rel="billEditNav" href="<%=baseUrl %>/management/caseBill/edit/{billId}?flag=view" title="账单信息"><span>编辑</span></a></li>
			</c:if>
			<%-- <li><a class="delete" target="ajaxTodo" rel="caseEditNav" href="<%=baseUrl %>/management/caseBill/delete/{billId}"  title="你确定要删除吗?"><span>删除</span></a></li> --%>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="160" >
		<thead>
			<tr>
				<th width="50"></th>
				<th>账单编号</th>
				<th>币种</th>
				<th>服务费</th>
				<th>费用</th>
				<th>担保手续费</th>
				<th>第三方总金额</th>
				<th>其它费用</th>
				<th>垫付费用</th>
				<th>赔款汇差</th>
				<th>总金额</th>
				<th>未到账金额</th>
				<th>账单状态</th>
				<th>发账时间</th>
				<th>到账时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseBillList}" varStatus="s">
			<tr id="billId" target="billId" rel="${item.billId }" ondblclick="editBill('${caseInfoImpl.casestatus}');" style="cursor: pointer;">
				<td>${s.index + 1}</td>
				<td>${item.feenumber}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.assurefee}</td>
				<td>${item.thirdpart}</td>
				<td>${item.otherfee}</td>
				<td>${item.advancefee}</td>
				<td>${item.compensationsub}</td>
				<td>${item.feeamount}</td>
				<td>${item.replaceamount}</td>
				<td>
					<c:forEach var="status" items="${accstatus}">
						<c:if test="${status.code eq item.feestatuse }">${status.desc}</c:if>
					</c:forEach>
				</td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<%-- <c:import url="../../layout/pager/panelBar.jsp"></c:import> --%>
	<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
 </div>