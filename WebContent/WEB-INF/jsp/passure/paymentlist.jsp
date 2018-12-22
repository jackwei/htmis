<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" id="paymentform"  class="pageForm required-validate" onsubmit="return navTabSearch(this)">
    <!-- <div class="panelBar" style="display: none" > -->
    <div class="panelBar">
		<ul class="toolBar">
<%-- 		    <li><a class="add" target="navTab" rel="paymentLiv" href="<%=baseUrl %>/passure/createpaymentlist?navTabId=paymentLiv&callbackType=closeCurrent" title="生成划付列表"><span>生成划付列表</span></a></li>
 --%>			<li><a iconClass="magnifier" id="ck" target="navTab" rel="ppdNav" href="<%=baseUrl %>/passure/passuresubmit/{payid}" title="申请呈批"><span>申请呈批</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>  
</form>

<div class="pageContent"> 
	<table class="table" width="100%" layoutH="75">
		<thead>
			<tr>
				<th width="5%"></th>
				<th width="10%">机构</th>
				<th width="10%">姓名</th>
				<th width="20%">收款明细</th>
				<th width="10%">担保份数</th>
				<th width="10%">生成时间</th>
				<th width="20%">状态</th>
				<!-- <th>操作</th> -->
			</tr>
		</thead>
		<tbody>
			<c:forEach var="a" items="${pylist}" varStatus="s">
				<tr target="payid" rel="${a.passurepayid}" ondblclick="alick();">
					<td>${s.index + 1}</td>
					<td>${a.orgname}</td>
					<td>${a.username}</td>
					<td>${a.receivedetail}</td>
					<td>${a.total}</td>
					<td><fmt:formatDate value="${a.createdate}" pattern="yyyy-MM-dd" /></td>
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
				<%-- 	</td>
 						<td>
						<c:choose>
					<c:when test="${a.reportflag =='new'}">
					 		<a class="button"  target="ajaxTodo"  rel="pbLiv" href="<%=baseUrl %>/passure/saveApplyInfos?navTabId=pbLiv&payId=${a.passurepayid}" ><span>保存呈批件</span></a>
				    </c:when>
				    <c:when test="${a.reportflag =='save'}">
					 		<a class="button"  target="navTab"  rel="pbLiv" href="<%=baseUrl %>/auditApply/modifyApplyInfos?payid=${a.passurepayid}&flag=apply" ><span>修改呈批件</span></a>
				    </c:when>
				    <c:otherwise>
					 		<a class="button"  target="navTab"  rel="pbLiv" href="<%=baseUrl %>/auditApply/modifyApplyInfos?payid=${a.passurepayid}&flag=view" ><span>查看呈批件</span></a>
				    </c:otherwise>
				</c:choose>
				 <a class="button"  target="navTab" rel="ppdNav" href="<%=baseUrl %>/passure/passuresubmit/{payid}" title="查看呈批件"><span>查看呈批件</span></a>
						</td>  --%>
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

function alick(){
	var btn = document.getElementById("ck");
	btn.click();
	//$('#editCase').click();
}

</script>
