<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageHeader">
<form id="pagerForm" method="post" action="<%=baseUrl %>/management/case/csup" onsubmit="return divSearch(this,'sup')">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
	<div class="searchBar">
		<table class="searchContent">
			<tr>
				<td>案号 ：<input type="text" name="casenumber" value="${param.casenumber}"/></td>
				<td>船名 ：<input type="text" name="shipname" value="${param.shipname}"/></td>
				<td>扩展案号 ：<input type="text" name="excasenumber" value="${param.excasenumber}"/></td>
				<td>委托人：<input type="text" name="consignorsn" value="${param.consignorsn}"/></td>
				<td>
					<!-- <select class="combox required" name="billstatus">
						<option value="">请选择</option>
						<option value="2">已发账案件</option>
						<option value="0">待发账案件</option>
					</select> -->
				</td>
				
			</tr>
		</table>
		
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</form>
</div>

<div class="pageContent">
	<table class="table" width="100%" layoutH="150">
		<thead>
			<tr>
				<th width="50"></th>
				<th width="200">案号</th>
				<th>船名</th>
				<th>事发口岸</th>
				<th>委托人</th>
				<th width="250">案件描述</th>
				<th>主办人</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseList}" varStatus="s">
			<tr target="caseId" rel="${item.Case_Id }" onclick="navTab.openTab('caseEditNav','<%=baseUrl %>/management/case/edit/${item.Case_Id}?flag=view',{title:'案件信息',fresh:false})" style="cursor: pointer;">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}${item.excasenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.accidentport}</td>
				<td>${item.consignorsn}</td>
				<td>${item.casedes}</td>
				<td>${item.username}</td>
				<%-- <td><input id="caseId" type="hidden" value="${item.caseId }"> </td> --%>
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'${targetType}',data:{numPerPage:this.value},rel:'sup'})">
               	<c:forEach begin="20" end="20" step="10" varStatus="s">
  					<option value="${s.index}" ${vo.pageSize eq s.index?'selected="selected"':''}>${s.index}</option>
  				</c:forEach>
            </select>
            <span>条，共${vo.totalCount}条</span>
        </div>
        <div class="pagination" rel="sup" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="10" currentPage="${vo.pageNum}">
        </div>
    </div>	

</div>