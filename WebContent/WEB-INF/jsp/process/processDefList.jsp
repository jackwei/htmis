<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<c:import url="../common/processSearch.jsp"></c:import>

<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
		<c:choose>
		<c:when test="${definedflag eq '1'}">
			<li><a class="add" target="navTab"  href="<%=baseUrl %>/processDef/addProcessDef" title="定义流程"><span>定义流程</span></a></li>
		</c:when>
		</c:choose>
			<li><a class="add" target="navTab"  href="<%=baseUrl %>/processDef/toList/{slt_objId}" title="流程节点信息"><span>流程节点信息</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	<table class="table" width="100%" layoutH="138">
		<thead align="center">
			<tr>
				<th width="50">No.</th>
				<th>流程中文名称</th>
				<th>业务流程描述</th>
				<th>当前状态</th>
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="item" items="${list}" varStatus="s">
			<tr target="slt_objId" rel="${item.id}">
				<td>${s.index+1}</td>
				<td>${item.name}</td>
				<td>${item.desc}</td>
				<td>
				<c:choose>
                  <c:when test="${item.currentState=='1'}">
                                                      有效
                   </c:when>
                   <c:otherwise>
                                                        无效  
                   </c:otherwise>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 <c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>