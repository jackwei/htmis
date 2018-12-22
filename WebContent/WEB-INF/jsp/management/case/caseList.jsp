<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<%
String casestatus = request.getParameter("casestatus");
%>
<%-- <form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${vo.pageSize}" />
	<input type="hidden" name="orderField" value="${vo.orderField}" />
	<input type="hidden" name="orderDirection" value="${vo.orderDirection}" />
</form> --%>

<script type="text/javascript">
	function editClick(status){
		if(status == '9'){
			var btn = document.getElementById("viewCase");
		}else if(status == '0'){
			var btn = document.getElementById("editCase");
		}else{
			var btn = document.getElementById("viewCase");
		}
		btn.click();
		//$('#editCase').click();
	}
	
	function payCase(v){
		if(v==1){
			var url = "<%=baseUrl %>/management/case/search?casestatus=<%=casestatus %>";
			$("#caseSearch").attr("action", url);
		}
		
		$('#caseSearch').submit();
	}
</script>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form id="caseSearch" method="post" rel="pagerForm" action="<%=baseUrl %>/management/case?casestatus=<%=casestatus %>" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value="${param.casenumber}"/></td>
				<td>船名 ：<input type="text" name="shipname" value="${param.shipname}"/></td>
				<td>扩展案号 ：<input type="text" name="excasenumber" value="${param.excasenumber}"/></td>
				<td>委托人：<input type="text" name="consignorsn" value="${param.consignorsn}"/></td>
				<td>
					<select class="combox required" name="billstatus">
						<option value="">请选择</option>
						<option value="2">已发账案件</option>
						<option value="0">待发账案件</option>
					</select>
				</td>
				
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
<%-- 				<c:if test="${casestatus eq '0'}">
					<li><a class="button"  href="javascript:payCase(1);"  ><span>待划付案件</span></a></li>
				</c:if> --%>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">

<%--  			<li><a class="icon"  href="<%=baseUrl %>/management/case/dwzExport" target="dwzExport" targetType="navTab" title="确实要导出这些记录吗?"><span>导出EXCEL</span></a></li>
 --%> 			
 			<c:choose>
				<c:when test="${casestatus eq '0'}">
					<c:if test="${orgType ne 'C' }" >
						<li><a class="add" target="navTab" rel="addCaseNav" href="<%=baseUrl %>/management/case/add" title="添加案件"><span>添加</span></a></li>
					</c:if>
					
					<li><a id="editCase" class="edit" target="navTab" rel="caseEditNav" href="<%=baseUrl %>/management/case/edit/{caseId}" title="案件信息"><span>编辑</span></a></li>
					<%-- <li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/management/case/delete/{caseId}" title="你确定要删除吗?"><span>删除</span></a></li> --%>
				</c:when>
				<c:otherwise>
					<li><a id="viewCase" iconClass="magnifier" target="navTab" rel="viewCaseNav" href="<%=baseUrl %>/management/case/edit/{caseId}?flag=view" title="案件信息"><span>查看</span></a></li>
				</c:otherwise>
			</c:choose>
			<li class="line">line</li>
 			<%-- <li><a class="icon"  href="<%=baseUrl %>/management/case/dwzExport" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li> --%>
			</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="200">案号</th>
				<th>船名</th>
				<th>事发口岸</th>
				<th>委托人</th>
				<th width="250">案件描述</th>
				<th>主办人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseList}" varStatus="s">
			<tr target="caseId" rel="${item.Case_Id }" ondblclick="editClick('${casestatus}');" style="cursor: pointer;">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}${item.excasenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.accidentport}</td>
				<td>${item.consignorsn}</td>
				<td>${item.casedes}</td>
				<td>${item.username}</td>
				<%-- <td><input id="caseId" type="hidden" value="${item.caseId }"> </td> --%>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value})">
               	<c:forEach begin="20" end="20" step="10" varStatus="s">
  					<option value="${s.index}" ${vo.pageSize eq s.index?'selected="selected"':''}>${s.index}</option>
  				</c:forEach>
            </select>
            <span>条，共${vo.totalCount}条</span>
        </div>
        <div class="pagination" targetType="navTab" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="5" currentPage="${vo.pageNum}">
        </div>
    </div>	

</div>