<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<form id="pagerForm" method="post" action="<%=baseUrl %>/management/case/cfirst" onsubmit="return divSearch(this,'${divflag}')">
<div class="pageHeader">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
	<input type="hidden" name="supflag" value="${supflag}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value="${param.casenumber}"/></td>
				<td>船名 ：<input type="text" name="shipname" value="${param.shipname}"/></td>
				<td>扩展案号 ：<input type="text" name="excasenumber" value="${param.excasenumber}"/></td>
				<td>委托人：<input type="text" name="consignorsn" value="${param.consignorsn}"/></td>
				<td>
					<!-- <select class="combox required" name="billstatus">
						<option value="">请选择</option>
						<option value="2">已发账案件</option>
						<option value="0">待发账案件</option>
					</select> -->
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

	<table class="table" width="99%" layoutH="150">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>船名</th>
				<th>币种</th>
				<th>服务费</th>
				<th>费用</th>
				<th>担保手续费</th>
				<th>第三方总金额</th>
				<th>其它费用</th>
				<th>赔款汇差</th>
				<th>总金额</th>
				<!-- <th>发账时间</th>
				<th>到账时间</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caselistone}" varStatus="s">
			<tr id="billId" target="billId" style="cursor: pointer;" rel="${item.billId }" onclick="navTab.openTab('caseEditNav','<%=baseUrl %>/management/case/edit/${item.caseid}',{title:'案件信息',fresh:false})">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}${item.excasenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.assurefee}</td>
				<td>${item.thirdpart}</td>
				<td>${item.otherfee}</td>
				<td>${item.compensationsub}</td>
				<td>${item.feeamount}</td>
<%-- 			<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
 --%>		</tr>
		</c:forEach>
		</tbody>
	</table>

<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>显示</span>
		<select name="pageSize" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value},rel:'${divflag}'})">
			<c:forEach begin="0" end="20" step="10" varStatus="s">
				<option value="${s.index}" ${vo.pageSize eq s.index ? 'selected="selected"' : ''}>${s.index}</option>
			</c:forEach>
		</select>

		<span>总数: ${total1}</span>
	</div>
	<div class="pagination" rel="${divflag}"  totalCount="${total1}" numPerPage="${vo.pageSize}" pageNumShown="10" currentPage="${vo.pageNum}"></div>
</div>

