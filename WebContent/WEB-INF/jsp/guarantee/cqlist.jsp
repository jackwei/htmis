<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>


<div class="pageContent">

     
    <table class="table" width="100%" layoutH="50">
    <thead>
      <tr>
        <th width="20" ></th>
        <th>案号</th>
        <th>船名</th>
        <th>事由</th>
        <th>委托人</th>
        <th>账单编号</th>
        <th>发账时间</th>
        <th>币种</th>
        <th>金额</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${clist}" varStatus="s">
			<tr target="slt_objId" rel="${a.Bill_Id}">
			    <td>${s.index + 1}</td>
				<td>${a.casenumber}</td>
				<td>${a.shipname}</td>
				<td>${a.casedes}</td>
				<td>${a.consignorsn}</td>
				<td>${a.feenumber}</td>
				<td>${a.accdate}</td>
				<td>${a.currency}</td>
				<td>${a.feeamount}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 