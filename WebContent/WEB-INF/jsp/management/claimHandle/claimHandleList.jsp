<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<%
	String flag = request.getParameter("flag");
%>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/claimHandle?flag=${flag}" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value=""/></td>
				<td>船名 ：<input type="text" name="shipname" value=""/></td>
				<td>收款人 ：<input type="text" name="clientname" value=""/></td>
				<td>
					<label>业务类型 ：</label>
					<select class="combox required" name="recordtype">
						<option value="">请选择</option>
						<option value="A">代收代付</option>
						<option value="B">垫付费用</option>
						<option value="D">余款退回</option>
					</select>
				</td>
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
	<input type="hidden" target="caseId" rel="${caseId}" />
	<div class="panelBar">
		<ul class="toolBar">
			<c:if test="${flag eq 'nolock' }">
	 			<li><a class="edit" target="navTab" rel="claimHandleNav" href="<%=baseUrl %>/management/claimHandle/edit/{claimId}" title="赔款确认"><span>处理</span></a></li>
			</c:if>
			<c:if test="${flag eq 'lock' }">
				<li><a iconClass="magnifier" target="navTab" rel="caseNav" href="<%=baseUrl %>/management/claimHandle/view/{claimId}?flag=lock" title="查看"><span>查看</span></a></li>
			</c:if>
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->
		</ul>
	</div>
	<table class="table" width="99%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>船名</th>
				<th>收款人</th>
				<th>申请币种</th>
				<th>申请金额</th>
				<th>划付币种</th>
				<th>划付金额</th>
				<th>业务类型</th>
				<c:if test="${flag eq 'lock' }">
					<th>划付时间</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${claimHandleList}" varStatus="s">
			<tr target="claimId" rel="${item.claimId }">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.clientname}</td>
				<td>${item.recordcurrency}</td>
				<td>${item.recordmount}</td>
				<td>${item.currency}</td>
				<td>${item.realamount}</td>
				<td>
					<c:forEach var="ct" items="${recordtype}">
						<c:if test="${ct['dictid'] eq item.recordtype}">
							${fn:trim(ct['dictname']) }
						</c:if>
			    	</c:forEach>
				</td>
				<c:if test="${flag eq 'lock' }">
					<td><fmt:formatDate value="${item.treatdate}" pattern="yyyy-MM-dd"/>
				</c:if>
				<%-- <td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%> 
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<c:import url="../_frag/pager/panelBar.jsp"></c:import>
</div>