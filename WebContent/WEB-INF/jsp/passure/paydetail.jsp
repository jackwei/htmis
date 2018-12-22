<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import="com.git.db.beans.TblPassurePayMents" %>
<%
  String payid = request.getParameter("payid");
  TblPassurePayMents tblPassurePayMents = (TblPassurePayMents)request.getAttribute("TblPassurePayMents");
%>


<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/paysearch?payid=<%=payid %>" onsubmit="return navTabSearch(this)">
</form>

	<div class="panel collapse" defH="100">
		<h1>划付信息</h1>
		<div  class="pageFormContent">
		<p>
		  <label>机构：</label>
		  <input type="text" name="orgname" value="<%=tblPassurePayMents.getOrgname() == null ? "" : tblPassurePayMents.getOrgname() %>" >
		</p>
		<p>
		  <label>制单员：</label>
		  <input type="text" name="username" value="<%=tblPassurePayMents.getUsername() ==null ? "" : tblPassurePayMents.getUsername() %>" >
		</p>
		<p>
		  <label>到账明细：</label>
		  <input type="text" name="receivedetail" value="<%=tblPassurePayMents.getReceivedetail() == null ? "" : tblPassurePayMents.getReceivedetail()%>" >
		</p>
		<p>
		  <label>担保份数：</label> <input type="text" name="total" value="<%=tblPassurePayMents.getTotal() == null ? "" : tblPassurePayMents.getTotal()%>" /> 
        </p>
        <p>
		  <label>呈批件年：</label><input class="number" readonly="readonly" type="text" id="year" name="year" value="<%=tblPassurePayMents.getYear() == null ? "" : tblPassurePayMents.getYear()%>">
		</p>
		<p>
		  <label>呈批件月：</label><input class="number" readonly="readonly" type="text" id="month" name="month" value="<%=tblPassurePayMents.getMonth() == null ? "" : tblPassurePayMents.getMonth()%>">
		</p>
		<p>
		  <label>划付明细：</label>
		  <input type="text" name="paydetail" value="<%=tblPassurePayMents.getPaydetail() == null ? "" : tblPassurePayMents.getPaydetail() %>" >
		</p>
		<p>
		  <label>划付时间：</label>
		  <input type="text" name="paydate" value="<fmt:formatDate value="<%=tblPassurePayMents.getPaydate() %>" pattern="yyyy-MM-dd"/> " >
		</p>
		<p style="display:none">	         
		</p>
		
		<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?payid=<%=tblPassurePayMents.getPassurepayid()%>&flag=view' title="查看呈批件"><span>查看呈批件</span></a>
		<a class="button" target="navTab" rel="payLiv" href="<%=baseUrl %>/passure/pay" title="划付查询"><span>返回</span></a>
		
		</div>
	</div>
	
	<div class="panel collapse" >
		<h1>已划付担保信息</h1>
		<table class="table" width="100%" layoutH="220">
    <thead>
      <tr>
        <th width="5%" ></th>
        <th width="15%">反担保人</th>
        <th width="10%">担保编号</th>
        <th width="10%">出具时间</th>
        <th width="10%">担保币种</th>
        <th width="10%">担保金额</th>
        <th width="10%">到账币种</th>
        <th width="10%">到账手续费</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${passuredlist}" varStatus="s">
			<tr target="payid" rel="${a.passurepayid}">
			    <td>${s.index + 1}</td>
				<td>${a.rewarrantersn}</td>
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
	</div>
	
      <c:import url="../layout/pager/panelBar.jsp"></c:import>