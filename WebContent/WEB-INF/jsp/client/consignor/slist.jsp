<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
String st = request.getParameter("st");
%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/client/consignor/search?st=<%=st %>"  onsubmit="return dwzSearch(this, 'dialog');">

<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>委托人：</label>
				<input type="text" name="keywords" />
			</li>
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				<li><div class="buttonActive"><div class="buttonContent"><button onclick="$.bringBack({oid:'',names:'',name:''});">清空</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li class="line">line</li>
		</ul>
	</div>
	 <table class="table" width="100%"  layoutH="140">
		<thead align="center">
			<tr>
			    <th width="10%"></th>
				<th width="10%" >委托人简称</th>
				<th width="70%" >委托人全称</th>
				<!-- <th width="10%">查找带回</th> -->
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="item" items="${menuList}" varStatus="s">
			<tr onclick="$.bringBack({oid:'${item.oid}',names:'${item.names}',name:'${item.name}'});" >
			    <td>${s.index + 1}</td>
			    <td>${item.names}</td>
				<td>${item.name}</td>
<%-- 				<td>
				<div>
					<a class="btnSelect" title="查找带回" href="javascript:$.bringBack({oid:'${item.oid}',names:'${item.names}',name:'${item.name}'})">选择
 				 	</a>
 				 </div>
				</td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select name="numPerPage" onchange="dwzPageBreak({targetType:'dialog',numPerPage:this.value})">
               	<c:forEach begin="0" end="20" varStatus="s">
  					<option value="${s.index}" ${vo.pageSize eq s.index?'selected="selected"':''}>${s.index}</option>
  				</c:forEach>
            </select>
            <span>条，共${vo.totalCount}条</span>
        </div>
        <div class="pagination" targetType="dialog" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="5" currentPage="${vo.pageNum}">
        </div>
    </div>	

</div>


