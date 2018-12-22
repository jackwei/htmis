<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/applysearch" onsubmit="return divSearch(this,'pptlist')">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			   	<td>反担保人 ：<input type="text" name="rewarranter" /></td>
				<td>担保编号 ：<input type="text" name="assurenum" /></td>
				<td>担保币种 ：<input type="text" name="currency" /></td>
				<td>担保金额 ：<input type="text" name="assurefee1" />---<input type="text" name="assurefee2" /></td>
			</tr>
			
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
<!-- 				<li><div class="buttonActive"><a title="确实要吗?" target="selectedTodo" rel="aids" onclick="applysubmit()" ><span>退回申请</span></a></div></li>
 -->		<c:if test="${tp.reportflag eq 'new'}">
 				<li><div class="buttonActive"><a title="确实要吗?" onclick="applysubmit()" ><span>退回呈批</span></a></div></li>
			</c:if>
			<c:if test="${tp.reportflag eq 'save'}">
 				<li><div class="buttonActive"><a title="确实要吗?" onclick="applysubmit()" ><span>退回呈批</span></a></div></li>
			</c:if>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent" >
<table id="passuretable" class="table" width="99%" layoutH="160">
			<thead>
				<tr>
					<!-- <th><input type="checkbox" group="aids" class="checkboxCtrl"></th> -->
					<th></th>
					<th></th>
					<th>反担保人</th>
					<th>担保编号</th>
					<th>出具时间</th>
					<th>担保币种</th>
					<th>担保金额</th>
					<th>到账币种</th>
					<th>到账手续费</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${piflist}" varStatus="s">
					<tr target="passureid" rel="${a.passureid}">
						<td><input name="aids" value="${a.passureid}" type="checkbox"  /></td>
						<td>${s.index + 1}</td>
						<td>${a.rewarrantersn}</td>
						<td>${a.assurenum}</td>
						<td><fmt:formatDate value="${a.issuedate}" pattern="yyyy-MM-dd" /></td>
						<td>${a.currency}</td>
						<td>${a.assurefee}</td>
						<td>${a.acccurrency}</td>
						<td>${a.accamount}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>总数: ${total}</span>
	</div>
</div>
</div>


	
<script type="text/javascript" >
function applysubmit(){
	var  pid = new Array();
$('input[name="aids"]:checked').each(function(){
	pid.push($(this).val());
});

var b = "<%=baseUrl%>/passure/backapply?navTabId=ppdNav&callbackType=forward";
var c = b+"&payid="+pid;
$("#payment").attr("action", c);
$('#payment').submit();
}

</script>				