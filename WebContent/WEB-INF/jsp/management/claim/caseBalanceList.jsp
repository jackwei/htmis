<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>

<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>
<script type="text/javascript">
	function balanceBack(){
		
	}
</script>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<c:choose>
				<c:when test="${caseInfoImpl.casestatus eq 9 }">
				</c:when>
				<c:otherwise>
					<li><a class="add" target="dialog" mask="true" rel="balanceBackNav" width="800" height="260" href="<%=baseUrl %>/management/compensation/balanceBack/{inComeId}?flag=add"  title="余额处理"><span>余额处理</span></a></li>
					<li><a class="delete" target="ajaxTodo" rel="balanceBackNav" href="<%=baseUrl %>/management/compensation/del/{inComeId}?casenumber=${caseInfoImpl.casenumber}"  title="你确定要删除余额退回吗?"><span>删除</span></a></li>
				</c:otherwise>
			</c:choose>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="99%" layoutH="170">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
		   	    <th>付款人</th>
		        <th>币种</th>
		        <th>到账金额</th>
		        <th>银行手续费</th>
		        <th>合计金额</th>
		        <th>到账余额</th>
		        <th>到账时间</th>
		        <th>处理状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${claimIncomeList}" varStatus="s">
			<tr target="inComeId" rel="${item.Income_Id }">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}</td>
				<td>${item.payer}</td>
				<td>${item.currency}</td>
				<td>${item.receiveamount}</td>
				<td>${item.bankfee}</td>
				<td>${item.totalamount}</td>
				<td>${item.differamount}</td>
				<td><fmt:formatDate value="${item.receivedate}" pattern="yyyy-MM-dd"/></td>
				<c:choose>
					<c:when test="${item.status =='0'}">
          				<td>
							已到账
						</td>
						<td>
							<a class='button' target="dialog" mask="true" rel="downNav" width="600" height="300"  href='<%=baseUrl %>/FileDown/openFile?oId=${item.Income_Id}&docType=claimdoc'><span>查看附件</span></a>
						</td>
          			</c:when>
					<c:when test="${item.status =='1'}">
          				<td>
							待提交审批
						</td>
						<td>
							<a type="button" class="button" target="navTab" rel="transferNav" href="<%=baseUrl %>/auditApply/claimApplyInfoDetail?backNav=caseEditNav&incomeId=${item.Income_Id }&flag=apply" title="申请呈批"><span>申请呈批</span></a>
						</td>
          			</c:when>
          			<c:when test="${item.status =='2'}">
          				<td>
							审批中
						</td>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&incomeId=${item.Income_Id}&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
						</td>
          			</c:when>
          			<c:when test="${item.status =='3'}">
          				<td>
							审批完成（待处理）
						</td>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&incomeId=${item.Income_Id}&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
						</td>
          			</c:when>
          			<c:when test="${item.status =='4'}">
          				<td>
							处理完毕
						</td>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&incomeId=${item.Income_Id}&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
						</td>
          			</c:when>
          			<c:when test="${item.status =='5'}">
          				<td>
							赔款核销完毕
						</td>
						<td>
							<%-- <a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&incomeId=${item.incomeId }&flag=view' title="呈批件预览"><span>呈批件预览</span></a> --%>
							<a class='button' target="dialog" mask="true" rel="downNav" width="600" height="300"  href='<%=baseUrl %>/FileDown/openFile?oId=${item.Income_Id}&docType=claimdoc'><span>查看附件</span></a>
						</td>
          			</c:when>
          			<c:otherwise>
          				<td>
							处理完毕
						</td>
          				<td>
							<%-- <a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&incomeId=${item.incomeId }&flag=view' title="呈批件预览"><span>呈批件预览</span></a> --%>
							<a class='button' target="dialog" mask="true" rel="downNav" width="600" height="300"  href='<%=baseUrl %>/FileDown/openFile?oId=${item.Income_Id}&docType=claimdoc'><span>查看附件</span></a>
						</td>
          			</c:otherwise>
          		</c:choose>
			</tr>
		</c:forEach>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
		</tbody>
	</table>
		<%-- <c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>