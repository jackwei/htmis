<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

    <div class="panel" >
		<form method="post" rel="pagerForm" action="<%=baseUrl%>/searchcount/standardcondition?standardflag=caseincomreport" onsubmit="return navTabSearch(this)">
		<input type="hidden" name="startdate" value="${startdate}">
		<input type="hidden" name="enddate" value="${enddate}">
		<input type="hidden" name="passurereport" value="${passurereport}">
		<input type="hidden" name="orgcd" value="${orgcd}">
		<input type="hidden" name="user" value="${user}">		
		</form>
	</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="53">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案件性质</th>
				<th>币种</th>
				<th>本期数</th>
				<th>上期数</th>
				<th>同比</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${sreportList}" varStatus="s">
			<tr >
				<td>${s.index + 1}</td>
				<td>${item.casetypename}</td>
				<td>${item.currency}</td>
				<td>${item.incom}</td>
				<td>${item.incom}</td>
				<td>${item.bl}</td>
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
               	<c:forEach begin="0" end="20" varStatus="s">
  					<option value="${s.index}" ${vo.pageSize eq s.index?'selected="selected"':''}>${s.index}</option>
  				</c:forEach>
            </select>
            <span>条，共${vo.totalCount}条</span>
        </div>
        <div class="pagination" targetType="navTab" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="5" currentPage="${vo.pageNum}">
        </div>
    </div>	

</div>


