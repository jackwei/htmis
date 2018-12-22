<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

	<div class="panel" >
		<h1>担保明细<a>${startdate} - ${enddate}</a></h1>
		<form method="post" rel="pagerForm" action="<%=baseUrl%>/searchcount/searchcondition?searchflag=passureinfosdetail" onsubmit="return navTabSearch(this)">
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

		<!--<input type="hidden" name="orgcode" value="${orgcode}"> !-->
		
		</form>
	</div>	
<div class="pageContent">		
	<table class="table" width="100%" layoutH="80">
		<thead>
			<tr>
				<th width="5%"></th>
				<th width="10%">项目</th>
				<th width="20%">分组项</th>			
				<th width="5%">币种</th>
				<th width="10%">担保金额</th>
				<th width="10%">RMB金额</th>
				<th width="10%">USD金额</th>
				<th width="10%">手续费</th>
				<th width="5%">数量</th>
				<th width="5%">明细</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${passuredetailList}" varStatus="s">
			<tr>
				<td>${s.index + 1}</td>
				<td>${item.billstatuse}</td>
				<td>${item.groupname}</td>
				<td>${item.currency}</td>
				<td><fmt:formatNumber value="${item.assurefee}" type="number" pattern="#,##0.00" /></td>
				<td><fmt:formatNumber value="${item.rmbfee}" type="number" pattern="#,##0.00" /></td>
				<td><fmt:formatNumber value="${item.usdfee}" type="number" pattern="#,##0.00" /></td>
				<td><fmt:formatNumber value="${item.servicefee}" type="number" pattern="#,##0.00" /></td>
				<td>${item.count}</td>
				<td><a class="button" target="navTab" rel="passurecountNav" href="<%=baseUrl %>/searchcount/searchcondition?searchflag=passureinfos
				&startdate=${startdate}&enddate=${enddate}&timetype=${timetype}&casetypename=${casetypename}&accstart=${accstart}&accend=${accend}&sort=${sort}&names=${names}
				&sp=${sp}&accidentport=${accidentport}&zorg=${zorg}&zuser=${zuser}&xorg=${xorg}&xuser=${xuser}&third=${third}&rewarranter=${rewarranter}&billstatus=${billstatus}
				&propertyname=${propertyname}&currency=${item.currency}&country=${country}&receiver=${receiver}&sender=${sender}&trackingNumber=${trackingNumber}&radio=${radio}&groupid=${item.groupid} " 
				title="担保详细信息"><span>查看</span></a></td>
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