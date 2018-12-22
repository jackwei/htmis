<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl%>/passure/pay" onsubmit="return navTabSearch(this)">
</form>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li><a iconClass="magnifier" id="ek" target="navTab" rel="passurepayNav" href="<%=baseUrl%>/passure/paysearch/{payid}" title="担保划付详细信息"><span>查看详细信息</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="75">
		<thead>
			<tr>
				<th width="5%"></th>
				<th width="10%">机构</th>
				<th width="10%">姓名</th>
				<th width="20%">划付明细</th>
				<th width="10%">划付时间</th>
				<th width="10%">生成时间</th>
				<th width="20%">状态</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${plist}" varStatus="s">
				<tr target="payid" rel="${a.passurepayid}" ondblclick="elick();" >
					<td>${s.index + 1}</td>
					<td>${a.orgname}</td>
					<td>${a.username}</td>
					<td>${a.paydetail}</td>
					<td>${a.paydate}</td>
					<td>${a.createdate}</td>
					<td>
					<c:choose>
					<c:when test="${a.reportflag =='new'}">
					 		<a><span>已申请待呈批</span></a>
				    </c:when>
				    <c:when test="${a.reportflag =='save'}">
					 		<a><span>已保存呈批件待提交审批</span></a>
				    </c:when>
				    <c:when test="${a.reportflag =='submit'}">
				            <a><span>已提交审批</span></a>
				    </c:when>
				    <c:when test="${a.reportflag =='pass'}">
				            <a><span>待划付</span></a>
				    </c:when>
				    <c:otherwise>
					 		<a><span>已划付</span></a>
				    </c:otherwise>
				</c:choose>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>

<script type="text/javascript" >
function elick(){
	var btn = document.getElementById("ek");
	btn.click();
	//$('#editCase').click();
}
</script>