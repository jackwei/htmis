<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

    <div class="panel" >
		<h1>担保详细信息<a>${startdate} - ${enddate}</a></h1>
		<form method="post" rel="pagerForm" action="<%=baseUrl%>/searchcount/searchcondition?searchflag=passureinfos" onsubmit="return navTabSearch(this)">
		<input type="hidden" name="startdate" value="${startdate}">
		<input type="hidden" name="enddate" value="${enddate}">
		<input type="hidden" name="timetype" value="${timetype}">
		<input type="hidden" name="casetypename" value="${casetypename}">
		<input type="hidden" name="accstart" value="${accstart}">
		<input type="hidden" name="accend" value="${accend}">
		<input type="hidden" name="sort" value="${sort}">
		<input type="hidden" name="names" value="${names}">
		<input type="hidden" name="sp" value="${sp}">
		<input type="hidden" name="accidentport" value="${accidentport}">
		<input type="hidden" name="zorg" value="${zorg}">
		<input type="hidden" name="zuser" value="${zuser}">
		<input type="hidden" name="xorg" value="${xorg}">
		<input type="hidden" name="xuser" value="${xuser}">
		<input type="hidden" name="third" value="${third}">
		<input type="hidden" name="rewarranter" value="${rewarranter}">
		<input type="hidden" name="billstatus" value="${billstatus}">
		<input type="hidden" name="propertyname" value="${propertyname}">
		<input type="hidden" name="currency" value="${currency}">
		<input type="hidden" name="country" value="${country}">
		<input type="hidden" name="receiver" value="${receiver}">
		<input type="hidden" name="sender" value="${sender}">
		<input type="hidden" name="trackingNumber" value="${trackingNumber}">
		<input type="hidden" name="radio" value="${radio}">
		<input type="hidden" name="groupid" value="${groupid}">
		<input type="hidden" name="feestatuse" value="${feestatuse}">

		<a id="passured" rel="passureNav" class="edit" target="navTab" href="<%=baseUrl %>/management/case/edit/{caseId}" title="案件信息"></a>		
		</form>
	</div>
<div class="pageContent">
	<table class="table" width="100%" layoutH="80">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>船名</th>
				<th>反担保人</th>
				<th>担保编号</th>
				<th>币种</th>
				<th>担保金额</th>
				<th>RMB金额</th>
				<th>USD金额</th>
				<th>手续费</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${passureList}" varStatus="s">
			<tr target="caseId" rel="${item.caseid }" ondblclick="pclick()">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}${item.excasenumber}</td>
				<td>${item.ship}</td>
				<td>${item.rewar}</td>
				<td>${item.assurenum}</td>
				<td>${item.currency}</td>
				<td><fmt:formatNumber value="${item.assurefee}" type="number" pattern="#,##0.00" /></td>
				<td><fmt:formatNumber value="${item.rmbfee}" type="number" pattern="#,##0.00" /></td>
				<td><fmt:formatNumber value="${item.usdfee}" type="number" pattern="#,##0.00" /></td>
				<td><fmt:formatNumber value="${item.servicefee}" type="number" pattern="#,##0.00" /></td>
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

<script type="text/javascript">
	function pclick(){
		$('#passured').click();
	}
</script>
