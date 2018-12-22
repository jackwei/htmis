<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../layout/pager/pagerForm.jsp"></c:import>
<form method="post" rel="pagerForm" action="<%=baseUrl %>/auditApply/list?flag=${flag}" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>主题/&nbsp;编号关键字：</label>
				<input type="text" name="numname_s" value="${numname_s}"/>
			</li>
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
<div class="pageContent">
     <input type="hidden"  id="flag" value="${flag}">
	<table class="table" width="100%" layoutH="108">
		<thead align="center">
			<tr>
				<th width="50">No.</th>
				<c:choose>
					<c:when test="${flag =='audit'}">
          				<th>操作</th>
          				<th>呈批类型</th>
						<th>主题</th>
						<th>申请日期</th>
						<th>申请人</th>
						<th>申请机构</th>
						<th>呈批件编号</th>
          			</c:when>
          			<c:when test="${flag =='audited'}">          				
						<th>操作</th>
          				<th>呈批类型</th>
						<th>审批状态</th>
						<th>当前审批节点</th>
						<th>主题</th>
						<th>申请日期</th>
						<th>申请人</th>
						<th>申请机构</th>
						<th>呈批件编号</th>
          			</c:when>
          			<c:when test="${flag =='all'}">          				
						<th>操作</th>
          				<th>呈批类型</th>
						<th>审批状态</th>
						<th>当前审批节点</th>
						<th>主题</th>
						<th>申请日期</th>
						<th>申请人</th>
						<th>申请机构</th>
          			</c:when>
          			<c:otherwise>          				
						<th>操作</th>
          				<th>呈批类型</th>
						<th>审批状态</th>
						<th>当前审批节点</th>
						<th>主题</th>
						<th>申请日期</th>
						<th>呈批件编号</th>
          			</c:otherwise>
          		</c:choose>				
			</tr>
		</thead> 
		<tbody align="center">
		<c:forEach var="item" items="${list}" varStatus="s">
			<tr target="applyId" rel="${item.oid}">
				<td>${s.index+1}</td>
				<c:choose>
					<c:when test="${flag =='audit'}">
          				<td>
							<a type="button" class="button" target="navTab" href="<%=baseUrl %>/auditApply/searchApplyInfos?backNav=auditListNav&applyId=${item.oid}&flag=${flag}" title="审批呈批件"><span>审批</span></a>
							<!-- a type="button" class="button" onclick="openAudit(${item.oid});" href="#" title="审批呈批件"><span>弹出窗口</span></a-->
						</td>
						<td>${item.applytype}</td>
						<td>${item.name}</td>
						<td>
							<fmt:parseDate value="${item.applyDate}" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
						</td>
						<td>${item.userName}</td>
						<td>${item.orgName}</td>
						<td>${item.sqnumber}</td>
          			</c:when>
          			<c:when test="${flag =='audited'}">
          				<td>
							<a type="button" class="button" target="navTab" href="<%=baseUrl %>/auditApply/searchApplyInfos?backNav=queryListNav&applyId=${item.oid}&flag=${flag}" title="查看呈批件"><span>查看</span></a>
						</td>
						<td>${item.applytype}</td>
						<td>${item.applystatus}</td>
						<td>${item.activityName}</td>
						<td>${item.name}</td>
						<td>
							<fmt:parseDate value="${item.applyDate}" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
						</td>
						<td>${item.userName}</td>
						<td>${item.orgName}</td>
						<td>${item.sqnumber}</td>
          			</c:when>
          			<c:when test="${flag =='all'}">
          				<td>
							<a type="button" class="button" rel="alldetailNav" target="navTab" href="<%=baseUrl %>/auditApply/searchApplyInfos?backNav=applyListNav&applyId=${item.oid}&flag=${flag}&status=${item.status}" title="查看呈批件"><span>查看</span></a>
						</td>
						<td>${item.applytype}</td>
						<td>${item.applystatus}</td>
						<td>${item.activityName}</td>
						<td>${item.name}</td>
						<td>
							<fmt:parseDate value="${item.applyDate}" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
						</td>
						<td>${item.userName}</td>
						<td>${item.orgName}</td>
          			</c:when>
          			<c:otherwise>
          				<td>
							<a type="button" class="button" target="navTab" href="<%=baseUrl %>/auditApply/searchApplyInfos?backNav=applyListNav&applyId=${item.oid}&flag=${flag}&status=${item.status}" title="查看呈批件"><span>查看</span></a>
						   <%-- <c:if test="${item.status =='process'}">
						  	 <a class="button" target="dialog" rel="applyListNav" mask="true" width="800" height="400" href="<%=baseUrl %>/auditApply/toadjustmentProcess?applyId=${item.oid}" title="流程调整"><span>流程调整</span></a>
						   </c:if> --%>
						</td>
						<td>${item.applytype}</td>
						<td>${item.applystatus}</td>
						<td>${item.activityName}</td>
						<td>${item.name}</td>
						<td>
							<fmt:parseDate value="${item.applyDate}" var="date"/>
							<fmt:formatDate value="${date}" pattern="yyyy-MM-dd"/>
						</td>
						<td>${item.sqnumber}</td>
          			</c:otherwise>
          		</c:choose>				
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 <c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>
<script type="text/javascript">
function openAudit(applyId)
{
	var url="<%=baseUrl %>/auditApply/searchApplyInfos?backNav=none&applyId="+applyId+"&flag=audit";
	window.open(url,"",'width='+screen.availWidth+',height='+
	screen.availHeight+',top=0,left=0,toolbar=0,location=no,directories=0,menubar=0,scrollbars=1,channelmode=1,resizable=1,status=1');
}
</script>