<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/guarantee/search" onsubmit="return navTabSearch(this)">

<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>担保管理：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
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
    <table class="table" width="100%" layoutH="110">
    <thead>
      <tr>
        <th width="50"></th>
        <th >ID</th>
        <th >案号</th>
        <th >船名</th>
        <th >反担保人</th>
        <th >担保编号</th>
        <th >出具时间</th>
        <th>担保币种</th>
        <th>担保金额</th>
        <th>发账币种</th>
        <th>发账手续费</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${slist}" varStatus="s">
			<tr target="slt_objId" rel="${a.passureid}">
			    <td>${s.index + 1}</td>
			    <td>${a.passureid}</td>
				<td>${a.caseid}</td>
				<td>${a.shipname}</td>
				<td>${a.rewarranter}</td>
				<td>${a.assurenum}</td>
				<td>${a.issuedate}</td>
				<td>${a.currency}</td>
				<td>${a.assurefee}</td>
				<td>${a.acccurrency}</td>
				<td>${a.accamount}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 