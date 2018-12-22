<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/weishou" onsubmit="return navTabSearch(this)">
<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			   <td>担保编号：<input type="text" name="assurenum" value="${assurenum}" /></td>
			   <td>船名：<input type="text" name="shipnamed" value="${shipnamed}" /></td>  
			   <td>出具时间：<input type="text" name="issuedate1" value="${issuedate1}" class="date" onblur="checkdate(this)"/><a class="hidden" href="javascript:;"></a>---<input type="text" name="issuedate2" value="${issuedate2}" class="date" onblur="checkdate(this)"/><a class="hidden" href="javascript:;"></a></td>
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
        <th width="50" ></th>
        <th>案号</th>
        <th>担保编号</th>
        <th>船名</th>
        <th>事由</th>
        <th>出具时间</th>
        <th>担保币种</th>
        <th>担保金额</th>
        <th>反担保人</th>
        <th>委托人</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${wlist}" varStatus="s">
			<tr target="slt_objId" rel="${a.Case_Id}" style="cursor: pointer;" onclick="navTab.openTab('addpassureandbill','<%=baseUrl %>/passure/edit/${a.caseid}',{title:'添加担保及担保账单',fresh:false})">
			    <td>${s.index + 1}</td>
			    <td>${a.casenumber}${a.excasenumber}</td>
			    <td>${a.assurenum}</td>
				<td>${a.shipname}</td>
				<td>${a.casedes}</td>
				<td>${a.issuedate}</td>
				<td>${a.currency}</td>
				<td>${a.assurefee}</td>
				<td>${a.rewarrantersn}</td>
				<td>${a.consignorsn}</td>
<%-- 				<td>${a.casenumber}</td> --%>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 