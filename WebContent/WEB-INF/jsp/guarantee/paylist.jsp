<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>


<form method="post" rel="pagerForm" action="<%=baseUrl %>/guarantee/pay/" onsubmit="return navTabSearch(this)">
</form>

<div class="pageContent">     
    <table class="table" width="100%" layoutH="50">
    <thead>
      <tr>
        <th width="5%" ></th>
        <th width="10%">机构</th>
        <th width="10%">姓名</th>
        <th width="20%">划付明细</th>
        <th width="10%">划付时间</th>
        <th width="10%">生成时间</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${plist}" varStatus="s">
			<tr target="slt_objId" rel="${a.payid}">
			    <td>${s.index + 1}</td>
				<td>${a.orgname}</td>
				<td>${a.username}</td>
				<td>${a.paydetail}</td>
				<td>${a.paydate}</td>
				<td>${a.createdate}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 