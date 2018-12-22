<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/unarrbillsearch" onsubmit="return divSearch(this,'unarrbill')">
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
			       <!-- 		<li><div class="buttonActive"><a target="selectedTodo" rel="checkIds" onclick="unpsubmit()"><span>生成担保账单</span></a></div></li>
 -->			                <li><div class="buttonActive"><a class="button" onclick="unpsubmit()"><span>生成担保账单</span></a></div></li>
			       </c:otherwise>
			   </c:choose>						

           </ul>
		</div>
	</div>
</div>
</form>

<div class="pageContent" >
<table id="unpassuretable" class="table" width="99%" layoutH="160">
			<thead>
				<tr>
<!-- 					<th width="50"><input type="checkbox" group="checkIds" class="checkboxCtrl"></th>
 -->				<th></th>
                    <th width="35"></th>
					<th>反担保人</th> 
					<th>担保编号</th>
					<th>出具时间</th>
					<th>担保币种</th>
					<th>担保金额</th>
					<th>USD金额</th>
					<th>担保手续费</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="unpassure" items="${unpassurelist}" varStatus="s">
					<tr target="upid" rel="${unpassure.passureid}">
						<td><input name="checkIds" id="cbox" value="${unpassure.passureid}" type="checkbox"  /></td>
						<td>${s.index + 1}</td>
						<td>${unpassure.rewarrantersn}</td>
						<td>${unpassure.assurenum}</td>
						<td><fmt:formatDate value="${unpassure.issuedate}" pattern="yyyy-MM-dd" /></td>
						<td>${unpassure.currency}</td>
						<td>${unpassure.assurefee}</td>
						<td>${unpassure.usdfee}</td>
						<td id="service">${unpassure.servicefee}</td>
						<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
<c:set var="targetType" value="${empty param.targetType ? 'navTab' : param.targetType}"/>
<div class="panelBar">
	<div class="pages">
		<span>总数: ${vo2.totalCount}</span>
	</div>
  </div>		
</div>
	
<script type="text/javascript" >
function unpsubmit(){
	var  pid = new Array();
$('input[name="checkIds"]:checked').each(function(){
	pid.push($(this).val());
});

var a = "<%=baseUrl%>/passure/billinsert?navTabId=assurebilleditNav&callbackType=forward";
var b = a+"&passureid="+pid;
$("#assureform").attr("action", b);
$('#assureform').submit();
}

</script>	