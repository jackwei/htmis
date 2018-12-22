<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post"  rel="pagerForm" action="<%=baseUrl %>/voucher/searchFinData" onsubmit="return navTabSearch(this)">
	<div class="pageHeader">
		<div class="searchBar">
			<ul class="searchContent">
				<li>
					<label style="width: 100px;">凭证ID：</label>
					<input type="text" name="bussId" value=""/>
				</li>	
				<li>
					<label style="width: 100px;">摘要：</label>
					<input type="text" name="bussKeyNo" value=""/>
				</li>
				<li>
					<label style="width: 100px;">生成日期 ：</label>
					<input class="date" onblur="checkdate(this)" type="text" name="makeTime" value=""/>
				</li>
			</ul>
			 <div class="subBar">
				<ul>						
					<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
				</ul>
			</div>
		</div>
	</div>
</form>

<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a iconClass="magnifier" target="navTab" href="<%=baseUrl %>/voucher/searchFinDataResult/{slt_uid}" title="凭证信息"><span>查看凭证</span></a></li>
		    <li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/voucher/delete/{slt_uid}" title="你确定要删除吗?"><span>删除</span></a></li>
		</ul>
	</div>
	
	<table class="table" layoutH="138" width="100%">
		<thead>
			<tr>
				<th width="50"></th>
				<th>凭证类型</th>
				<th>摘要</th>
				<th>总金额</th>
				<th>状态</th>
				<th>生成日期</th>
				<th>导出日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${FinDataList}" varStatus="s" >
			<tr target="slt_uid" rel="${item.batchNo}">
				<td>${s.index + 1}</td>
				<td>
					<c:forEach var="item1" items="${bussType}">
						<c:if test="${item1.Buss_Id eq item.bussId}">${item1.Buss_Name }</c:if>
					</c:forEach>
				</td>
				<td>${item.bussKeyNo}</td>
				<td>${item.money}</td>
				<td>
					<c:forEach var="status" items="${voucherStatus}">
						<c:if test="${status.code eq item.dealFlag }">${status.desc}</c:if>
					</c:forEach>
				</td>
				<td><fmt:formatDate value="${item.makeTime}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.makeTime}" pattern="yyyy-MM-dd"/></td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
	<c:import url="../layout/pager/panelBar.jsp"></c:import>
<%-- 	<c:import url="../_frag/pager/panelBar.jsp"></c:import> --%>
</div>