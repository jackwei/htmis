<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../layout/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<%=baseUrl %>/auditApply/adjustmentList?flag=${flag}" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>主题/&nbsp;编号关键字：</label>
				<input type="text" name="numname_s" value="${numname_s}"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
<div class="pageContent">
     <input type="hidden"  id="flag" value="${flag}">
     <div class="panelBar">
		<ul class="toolBar">
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead align="center">
			<tr>
				<th width="50">No.</th>
				<th>操作</th>
        		<th>呈批类型</th>
				<th>审批状态</th>
				<th>当前审批节点</th>
				<th>主题</th>
				<th>申请日期</th>
				<th>呈批件编号</th>
			</tr>
		</thead> 
		<tbody align="center">
		<c:forEach var="item" items="${list}" varStatus="s">
			<tr id="applyId" target="applyId" rel="${item.oid}">
				<td>${s.index+1}</td>
        		<td>
					<a class="button" target="navTab" href="<%=baseUrl %>/auditApply/searchApplyInfos?backNav=applyListNav&applyId=${item.oid}&flag=${flag}&status=${item.status}" title="查看呈批件"><span>查看</span></a>
				    <a class="button" target="dialog" rel="applyListNav" mask="true" width="800" height="200" href="<%=baseUrl %>/auditApply/toadjustmentProcess?applyId=${item.oid}" title="流程调整"><span>流程调整</span></a>
				</td>
				<td>${item.applytype}</td>
				<td>${item.applystatus}</td>
				<td>${item.activityName}</td>
				<td>${item.name}</td>
				<td>${item.applyDate}</td>
				<td>${item.sqnumber}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 <c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>