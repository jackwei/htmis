<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" id="paymentform" action="<%=baseUrl%>/passure/payment" class="pageForm required-validate" onsubmit="return navTabSearch(this)">
    <div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" target="navTab" rel="pbLiv" href="<%=baseUrl %>/passure/dbcplist?navTabId=pbLiv" title="担保手续费呈批"><span>担保手续费呈批</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>  
</form>

<div class="pageContent"> 
	<table class="table" width="100%" layoutH="75">
		<thead>
				<tr>
					<th></th>
					<th>反担保人</th>
					<th>担保编号</th>
					<th>状态</th>
					<th>出具时间</th>
					<th>担保币种</th>
					<th>担保金额</th>
					<th>到账币种</th>
					<th>到账手续费</th>
					<th>到账时间</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${piflist}" varStatus="s">
					<tr target="passureid" rel="${a.passureid}">
						<td>${s.index + 1}</td>
						<td>${a.rewarrantersn}</td>
						<td>${a.assurenum}</td>
						<td>
				   <c:forEach var="status" items="${assurestatue}">
						<c:if test="${status.code eq a.feestatuse }">${status.desc}</c:if>
					</c:forEach>
				</td>
						<td><fmt:formatDate value="${a.issuedate}" pattern="yyyy-MM-dd" /></td>
						<td>${a.currency}</td>
						<td>${a.assurefee}</td>
						<td>${a.acccurrency}</td>
						<td>${a.accamount}</td>
						<td><fmt:formatDate value="${a.arrdate}" pattern="yyyy-MM-dd" /></td>
					</tr>
				</c:forEach>
			</tbody>
	</table>

	<c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>

<script type="text/javascript" >
function pdsubmit(){
var a = "<%=baseUrl %>/passure/createpaymentlist?navTabId=paymentLiv&callbackType=closeCurrent";
$("#paymentform").attr("action", a);
$('#paymentform').submit();
}

</script>
