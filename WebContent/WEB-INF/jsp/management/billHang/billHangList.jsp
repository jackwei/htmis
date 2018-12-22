<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@ page import="com.git.business.sys.User" %>
<%@ page import="com.git.db.beans.SysUser" %>

<%
User user = (User)request.getSession().getAttribute("SESSION_AUTHENTICATION");
request.setAttribute("orgCode",user.getOrgCode());
%>
<c:import url="../../layout/pager/pagerForm.jsp"></c:import>
<script type="text/javascript">
function viewHang(){
	var orgType = $("#orgType").val();
	if(orgType == 'C'){
		var btn = document.getElementById("edit");
	}else{
		var btn = document.getElementById("view");
	}
	btn.click();
}
</script>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/billHang" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>汇款人 ：<input type="text" name="remitter" value=""/></td>
				<td>汇款金额 ：<input type="text" name="remitmoney" value=""/></td>
				<td>汇款时间：<input class="date" onblur="checkdate(this)" type="text" name="remittancedate" value=""/></td>
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
	<input type="hidden" id="doctype" name="doctype" value="bangdoc">
	<input type="hidden" id="orgType" name="orgType" value="${orgType}">
	<div class="panelBar">
		<ul class="toolBar">
			<c:choose>
				<c:when test="${orgType eq 'C' }">
					<li><a class="add" target="navTab" rel="billHangAddNav"  href="<%=baseUrl %>/management/billHang/add" title="添加挂账单"><span>添加</span></a></li>
					<li><a id="edit" class="edit" target="navTab" rel="billHangEditNav"  href="<%=baseUrl %>/management/billHang/edit/{id}" title="编辑挂账单"><span>编辑</span></a></li>
					<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/billHang/finish/{id}" title="请确定是否确认该挂账单?"><span>确认</span></a></li>
					<%-- <li><a class="edit"  target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{id},{doctype}" title="附件上传" ><span>上传附件</span></a></li> --%>
				</c:when>
				<c:otherwise>
					<li><a id="view" iconClass="magnifier" target="navTab" rel="billHangEditNav" href="<%=baseUrl %>/management/billHang/edit/{id}?flag=select" title="查看挂账单"><span>查看</span></a></li>
				</c:otherwise>
			</c:choose>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>汇款人</th>
				<!-- <th>汇款客户</th> -->
				<th>汇款币种</th>
				<th>汇款金额</th>
				<th>汇款时间</th>
				<!-- <th>录入人</th> -->
				<th>备注</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${billHangList}" varStatus="s">
			<tr target="id" rel="${item.id }" ondblclick="viewHang();" style="cursor: pointer;">	
				<td>${s.index + 1}</td>
				<td>${item.remitter}</td>
				<%-- <td>${item.remittancecustomers}</td> --%>
				<td>${item.currency}</td>
				<td>${item.remitmoney}</td>
				<td><fmt:formatDate value="${item.remittancedate}" pattern="yyyy-MM-dd"/></td>
				<%-- <td>${item.entrypeople}</td> --%>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
				<td>${item.remark}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>