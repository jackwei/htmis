<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<c:import url="../common/processSearch.jsp"></c:import>

<div class="pageContent">
	<table class="table" width="100%" layoutH="138"  targetType="dialog">
		<thead align="center">
			<tr>
				<th width="50">No.</th>
				<th>流程中文名称</th>
				<th>业务流程描述</th>
				<th>当前状态</th>
				<th>查找带回</th>
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
				<td><a class="btnSelect" href="javascript:$.bringBack({id:${item.id}, name:'${item.name}'})" title="查找带回">选择</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 <c:import url="../layout/pager/panelBar.jsp"></c:import>
</div>