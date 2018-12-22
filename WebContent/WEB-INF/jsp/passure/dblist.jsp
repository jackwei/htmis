<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageHeader">
<form id="pagerForm" method="post" action="<%=baseUrl %>/passure/searchPassure" onsubmit="return divSearch(this,'passure')">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />

	<div class="searchBar">
		<table class="searchContent">
			<tr>
			   <td>担保编号：<input type="text" name="assurenum" /></td>
			   <td>币种：<input type="text" name="currency" /></td>    
			   <td>发账时间：<input type="text" name="accdate1" class="date" onblur="checkdate(this)" /><a class="hidden" href="javascript:;"></a>---<input type="text" name="accdate2" class="date" onblur="checkdate(this)" /><a class="hidden" href="javascript:;"></a></td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</form>
</div>

<div class="pageContent" >
	<div class="panelBar" >
		<ul class="toolBar">
			<li><a class="add" target="navTab" rel="paddNav" mask="true" href="<%=baseUrl %>/passure/passureadd" warn="请新建案件!" title="添加中再担保"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="peditNav" mask="true" href="<%=baseUrl %>/passure/pedit/{seqId}" title="编辑"><span>编辑</span></a></li>
			<!--  <li><a class="delete" target="ajaxTodo" rel="passure" href="<%=baseUrl %>/passure/pdelete/{seqId}" title="你确定要删除吗?"><span>删除</span></a></li> -->
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div> 
	<table class="table" width="99%" layoutH="160">
		<thead>
			<tr>
				<th width="50"></th>
				<th>反担保人</th>
				<th>担保编号</th>
				<th>状态</th>
				<th>币种</th>
				<th>担保金额</th>
				<th>出具时间</th>
				<th>担保手续费</th>
				<th>发账时间</th>
				<th>到账时间</th>
				<th>划付时间</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${passurelist}" varStatus="s">
			<tr target="seqId" rel="${item.passureid}">
				<td>${s.index + 1}</td>
				<td>${item.rewarrantersn}</td>
				<td>${item.assurenum}</td>
				<%-- <td>${item.feestatuse}</td> --%>
				<td>
				   <c:forEach var="status" items="${assurestatue}">
						<c:if test="${status.code eq item.feestatuse }">${status.desc}</c:if>
					</c:forEach>
				</td>
				<td>${item.currency}</td>
				<td>${item.assurefee}</td>
				<td><fmt:formatDate value="${item.issuedate}" pattern="yyyy-MM-dd"/></td>
				<td>${item.servicefee}</td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.paydate}" pattern="yyyy-MM-dd"/></td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>显示</span>
		<select name="pageSize" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value},rel:'passure'})">
			<c:forEach begin="0" end="20" step="10" varStatus="s">
				<option value="${s.index}" ${vo.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>

		<span>总数: ${vo.totalCount}</span>
	</div>
	<div class="pagination" rel="passure" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
</div>

</div>