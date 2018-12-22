<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageHeader" style="border:1px #B8D0D6 solid">
	<form id="pagerForm" onsubmit="return divSearch(this, 'jbsxBox3');" action="demo/pagination/list3.html" method="post">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="numPerPage" value="${model.numPerPage}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
	<div class="searchBar">
		已到账
	</div>
	</form>
</div>

<div class="pageContent" style="border-left:1px #B8D0D6 solid;border-right:1px #B8D0D6 solid">
<div class="panelBar">
	</div>
	<table class="table" width="99%" >
		<thead>
			<tr>
				<th width="80">序号</th>
				<th>姓名</th>
				<th>性别</th>
			</tr>
		</thead>
		<tbody>
			<tr target="sid_obj" rel="1">
				<td>1</td>
				<td>张三</td>
				<td>男</td>
			</tr>
			<tr target="sid_obj" rel="2">
				<td>2</td>
				<td>李四</td>
				<td>女</td>
			</tr>
		</tbody>
	</table>
	<div class="panelBar">
		<div class="pages">
			<span>显示</span>
			<select class="combox" name="numPerPage" onchange="navTabPageBreak({numPerPage:this.value}, 'jbsxBox3')">
				<option value="20">20</option>
				<option value="50">50</option>
				<option value="100">100</option>
				<option value="200">200</option>
			</select>
			<span>条，共2条</span>
		</div>
		
		<div class="pagination" rel="jbsxBox3" totalCount="200" numPerPage="20" pageNumShown="5" currentPage="1"></div>

	</div>
</div>