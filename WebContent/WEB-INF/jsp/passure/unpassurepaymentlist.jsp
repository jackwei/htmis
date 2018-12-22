<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/unapplysearch" onsubmit="return divSearch(this,'unpptlist')">
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
<!-- 				<li><div class="buttonActive"><a title="确实要吗?" target="selectedTodo" rel="checkIds" onclick="unapplysubmit()"><span>申请划付</span></a></div></li>
 -->		<c:if test="${tp.reportflag eq 'new'}">  
                    <li><div class="buttonActive"><a title="确实要吗?"  onclick="unapplysubmit()"><span>申请呈批</span></a></div></li>
			</c:if>
			<c:if test="${tp.reportflag eq 'save'}">  
                    <li><div class="buttonActive"><a title="确实要吗?"  onclick="unapplysubmit()"><span>申请呈批</span></a></div></li>
			</c:if>
			</ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent" >
<table id="unpassuretable" class="table" width="99%" layoutH="160">
			<thead>
				<tr>
					<!-- <th><input type="checkbox" group="checkIds" class="checkboxCtrl"></th> -->
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
			<c:forEach var="a" items="${plist}" varStatus="s">
					<tr target="passureid" rel="${a.passureid}">
					    <td><input name="checkIds" value="${a.passureid}" type="checkbox"  /></td>
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
		</table>
		
<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>总数: ${vo1.totalCount}</span>
	</div>
 </div>
</div>
	
<script type="text/javascript" >
function unapplysubmit(){
	var  pid = new Array();
$('input[name="checkIds"]:checked').each(function(){
	pid.push($(this).val());
});

var a = "<%=baseUrl%>/passure/sendapply?navTabId=ppdNav&callbackType=forward";
var b = a+"&pid="+pid;
$("#payment").attr("action", b);
$('#payment').submit();
}

</script>		