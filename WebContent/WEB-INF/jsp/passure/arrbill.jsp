<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/arrbillsearch" onsubmit="return divSearch(this,'arrbill')">
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
						   <c:choose>
			       <c:when test="${flag eq 'view'}">
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			       </c:when>
			       <c:otherwise>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
<!-- 				<li><div class="buttonActive"><a title="确实要吗?" target="selectedTodo" rel="aids" onclick="pdsubmit()"><span>退回担保账单</span></a></div></li>
 -->		   	<li><div class="buttonActive"><a title="确实要吗?" class="button" onclick="pdsubmit()"><span>退回担保账单</span></a></div></li>
			       </c:otherwise>
			   </c:choose>							
            </ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent" >
<table id="passuretable" class="table" width="99%" layoutH="160">
			<thead>
				<tr>
					<!-- <th width="50"><input type="checkbox" group="aids" class="checkboxCtrl"></th> -->
					<th></th>
					<th width="35"></th>
					<th>反担保人</th>
					<th>出具时间</th>
					<th>担保币种</th>
					<th>担保金额</th>
					<th>USD金额</th>
					<th>担保手续费</th>
					<th>折算汇率</th>
					<th>记帐金额</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="item" items="${passurelist}" varStatus="s">
					<tr target="pid" rel="${item.passureid}">
						<td><input name="aids" id="cdbox" value="${item.passureid}" type="checkbox"  /></td>
						<td>${s.index + 1}</td>
						<td>${item.rewarrantersn}</td>
						<td><fmt:formatDate value="${item.issuedate}" pattern="yyyy-MM-dd" /></td>
						<td>${item.currency}</td>
						<td>${item.assurefee}</td>
						<td>${item.usdfee}</td>
						<td id="servicea">${item.servicefee}</td>
						<td>${item.accrate}</td>
						<td>${item.accamount}</td>
						<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>总数: ${vo1.totalCount}</span>
	</div>
</div>
		
</div>


	
<script type="text/javascript" >
function pdsubmit(){
	var  pid = new Array();
$('input[name="aids"]:checked').each(function(){
	pid.push($(this).val());
});
var a = $('#cdbox').val();
var b = "<%=baseUrl%>/passure/billcut?navTabId=assurebilleditNav&callbackType=forward";
var c = b+"&pid="+pid;
$("#assureform").attr("action", c);
$('#assureform').submit();
}

</script>			