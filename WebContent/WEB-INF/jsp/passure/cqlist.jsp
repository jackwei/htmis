<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/chaoqi" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			   <td>案号：<input type="text" name="casenumbera" value="${casenumbera}" /></td>
			   <td>船名：<input type="text" name="shipnamec" value="${shipnamec}" /></td>  
			   <td>发账时间：<input type="text" name="accdate1" value="${accdate1}" class="date" onblur="checkdate(this)" /><a class="hidden" href="javascript:;"></a>---<input type="text" name="accdate2" value="${accdate2}" class="date" onblur="checkdate(this)" /><a class="hidden" href="javascript:;"></a></td>
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

     
    <table class="table" width="100%" layoutH="110">
    <thead>
      <tr>
        <th width="5%"></th>
        <th width="15%">案号</th>
        <th width="10%">船名</th>
        <th width="20%">事由</th>
        <th width="5%">委托人</th>
        <th width="10%">账单编号</th>
        <th width="10%">发账时间</th>
        <th width="5%">币种</th>
        <th width="10%">金额</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${clist}" varStatus="s">
			<tr target="slt_objId" rel="${a.Bill_Id}" style="cursor: pointer;" onclick="navTab.openTab('addpassureandbill','<%=baseUrl %>/passure/edit/${a.caseid}',{title:'添加担保及担保账单',fresh:false})">
			    <td>${s.index + 1}</td>
			    <td>${a.casenumber}${a.excasenumber}</td>
				<%-- <td>${a.casenumber}${a.excasenumber}</td> --%>
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