<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<script type="text/javascript">
  $("#billstatus").val('<%=request.getAttribute("billstatus")%>');
</script>
<form method="post" rel="pagerForm" action="<%=baseUrl %>/management/claim/searchCase?casestatus=${casestatus}" onsubmit="return dwzSearch(this, 'dialog');">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value="${casenumber1}"/></td>
				<td>船名 ：<input type="text" name="shipname" value="${shipname1}"/></td>
				<td>扩展案号 ：<input type="text" name="excasenumber" value="${excasenumber }"/></td>
				<td>
					<select class="combox required" name="billstatus" id="billstatus">
						<option value="0">请选择</option>
						<option value="1">已发账</option>
						<option value="2">未发账</option>
					</select>
				</td>
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
<div class="pageContent">
	<table class="table" width="100%" layoutH="138">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>船名</th>
				<th>事发口岸</th>
				<th>委托人</th>
				<th>案件描述</th>
				<th>主办人</th>
				<th>查找带回</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseList}" varStatus="s">
			<tr target="caseId" rel="${item.caseId }">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.accidentport}</td>
				<td>${item.consignorname}</td>
				<td>${item.casedes}</td>
				<td>${item.username}</td>
				<td><a class="btnSelect" href="javascript:$.bringBack({caseno:'${item.casenumber}'})" title="查找带回">选择</a></td>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'dialog',numPerPage:this.value})">
               	<c:forEach begin="0" end="20" varStatus="s">
  					<option value="${s.index}" ${vo.pageSize eq s.index?'selected="selected"':''}>${s.index}</option>
  				</c:forEach>
            </select>
            <span>条，共${vo.totalCount}条</span>
        </div>
        <div class="pagination" targetType="dialog" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="5" currentPage="${vo.pageNum}">
        </div>
    </div>	
</div>