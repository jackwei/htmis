<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>


<div class="pageContent">

     
    <table class="table" width="100%" layoutH="50">
    <thead>
      <tr>
        <th width="50" ></th>
        <th>担保编号</th>
        <th>船名</th>
        <th>事由</th>
        <th>出具时间</th>
        <th>担保币种</th>
        <th>担保金额</th>
        <th>反担保人</th>
        <th>委托人</th>
        <th>案号</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${wlist}" varStatus="s">
			<tr target="slt_objId" rel="${a.Case_Id}">
			    <td>${s.index + 1}</td>
			    <td>${a.assurenum}</td>
				<td>${a.shipname}</td>
				<td>${a.casedes}</td>
				<td>${a.issuedate}</td>
				<td>${a.currency}</td>
				<td>${a.assurefee}</td>
				<td>${a.rewarranter}</td>
				<td>${a.consignorname}</td>
				<td>${a.casenumber}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 