<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${vo.pageSize}" />
	<input type="hidden" name="orderField" value="${vo.orderField}" />
	<input type="hidden" name="orderDirection" value="${vo.orderDirection}" />
</form>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/guarantee" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>
						<label><input type="checkbox" name="c1" value="1" />未发账</label>
						<label><input type="checkbox" name="c1" value="2" />已发账</label>
				</td>
				<td>船名/编号 ：<input type="text" name="keywords" value=""/></td>
				<td>扩展案号 ：<input type="text" name="keywords" value=""/></td>
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

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" target="navTab" rel="guacaseNav" href="<%=baseUrl %>/guarantee/edit/{slt_objId}" title="编辑"><span>编辑</span></a></li>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>船名</th>
				<th>事发口岸</th>
				<th>委托人</th>
				<th>案件描述</th>
				<th>主办人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseList}" varStatus="s">
			<tr target="slt_objId" rel="${item.caseId }">
				<td>${s.index + 1}</td>
				<td>${item.caseId}</td>
				<td>${item.casenumber}</td>
				<td>${item.accidentport}</td>
				<td>${item.shipname}</td>
				<td>${item.casedes}</td>
				<td>${item.username}</td>
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