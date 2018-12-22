<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<div class="pageContent sortDrag" selector="h1" layoutH="10">
	<form method="post"  rel="pagerForm" action="<%=baseUrl %>/voucher/searchFinDataResult" onsubmit="return navTabSearch(this)">
		<div class="panel collapse">
		<h1>凭证基础信息</h1>
			<div class="pageFormContent">
				<p>
					<label>业务种类 ：</label>
					<input name="casenumber" readonly="readonly" type="text" size="30" value="${finData.bussId }" />
				</p>
				<p>
					<label>摘要：</label>
					<input name="casenumber" readonly="readonly" type="text" size="30" value="${finData.bussKeyNo }" />
				</p>
				<p>
					<label>币种：</label>
					<input name="casenumber" readonly="readonly" type="text" size="30" value="${finData.currency }" />
				</p>
				<p>
					<label>金额：</label>
					<input name="casenumber" readonly="readonly" type="text" size="30" value="${finData.money }" />
				</p>
				<p>
					<label>日记账名称：</label>
					<input name="casenumber" readonly="readonly" type="text" size="30" value="${finData.finName }" />
				</p>
				<p>
					<label>生成日期：</label>
					<input name="casenumber" readonly="readonly" type="text" size="30" value="<fmt:formatDate value="${finData.finDate }" pattern="yyyy-MM-dd"/>" />
				</p>
				<!-- <div class="subBar">
					<ul>						
						<li><div class="button"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
					</ul>
				</div> -->
			</div>
		</div>
	</form>
	
	
	<div class="panel collapse">
		<h1>凭证科目信息</h1>
		<div class="panelBar">
			<ul class="toolBar">
				<%-- <li><a class="delete" target="selectedTodo" rel="ids" href="<%=baseUrl %>/management/logEntity/delete" title="查看"><span>查看</span></a></li> --%>
				<li class="line">line</li>
			</ul>
		</div>
		<table class="table" layoutH="162" width="100%">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="100">科目类型</th>
				<th width="120">摘要</th>
				<th >科目编号</th>
				<th >科目名称 </th>
				<th >借贷标志</th>
				<th >原币金额</th>
				<th >币种</th>
				<th >日期</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="item" items="${FinDataResultList}" varStatus="s">
			<tr target="slt_uid" rel="${item.seqId}">
				<td>${s.index + 1}</td>
				<td>
					<c:forEach var="item1" items="${bussType}">
						<c:if test="${item1.Buss_Id eq item.bussId}">${item1.Buss_Name }</c:if>
					</c:forEach>
				</td>
				<td>${item.bussKeyNo}</td>
				<td>${item.itemId}</td>
				<td>${item.itemName}</td>
				<td>${item.itemType}</td>
				<td>${item.money}</td>
				<td>${item.currency}</td>
				<td><fmt:formatDate value="${item.finDate}" pattern="yyyy-MM-dd"/></td>
			</tr>			
			</c:forEach>
		</tbody>
	</table>
	</div>
	<c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>
