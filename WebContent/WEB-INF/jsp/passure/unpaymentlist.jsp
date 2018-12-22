<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include
	file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>


<form method="post" rel="pagerForm" action="<%=baseUrl%>/passure/unpayment/" onsubmit="return navTabSearch(this)">
</form>


<div class="pageContent">
<div class="panelBar">
		<ul class="toolBar">
			<li><a class="edit" target="navTab" id="bk" rel="unpaysubNav" href="<%=baseUrl %>/passure/unpaysubmit/{payid}" title="担保划付详细信息"><span>进入划付确认</span></a></li>
			<li class="line">line</li>
		</ul>
	</div> 
	<table class="table" width="100%" layoutH="75">
		<thead>
			<tr>
				<th width="5%"></th>
				<th width="10%">机构</th>
				<th width="10%">姓名</th>
				<th width="20%">收款明细</th>
				<th width="10%">生成时间</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${pylist}" varStatus="s">
				<tr target="payid" rel="${a.passurepayid}" ondblclick="blick();">
					<td>${s.index + 1}</td>
					<td>${a.orgname}</td>
					<td>${a.username}</td>
					<td>${a.receivedetail}</td>
					<td>${a.createdate}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>

<script type="text/javascript" >
function blick(){
	var btn = document.getElementById("bk");
	btn.click();
	//$('#editCase').click();
}
</script>