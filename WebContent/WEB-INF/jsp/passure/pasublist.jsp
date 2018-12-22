<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.TblPassurePayMents"%>

<%
	TblPassurePayMents tpp = (TblPassurePayMents) request.getAttribute("tpp");
%>

<div class="pageContent sortDrag" selector="h1">

	<div class="panel collapse" defH="145">
		<h1>划付申请单基本信息</h1>
		<div class="panelContent" >
		 <form method="post" id="paymentsend" action="<%=baseUrl %>/passure/paymentupdate?navTabId=unpaysubNav&callbackType=forward" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">		
		<div class="pageFormContent">
		        <input type="hidden" name="passurepayid" value="<%=tpp.getPassurepayid()%>">
		        <input type="hidden" id="payid" name="payid" value="<%=tpp.getPassurepayid()%>">
		        <input type="hidden" name="forwardUrl" value="<%=baseUrl %>/passure/unpaysubmit/{payid}"/> 
				<p>
					<label>机构：</label> <input type="text" name="orgname" readonly="readonly" value="<%=tpp.getOrgname() == null ? "" : tpp.getOrgname()%>">
				</p>
				<p>
					<label>制单员：</label> <input type="text" name="username" readonly="readonly" value="<%=tpp.getUsername() == null ? "" : tpp.getUsername()%>">
				</p>
				<p>
					<label>到账明细：</label> <input type="text" name="receivedetail" readonly="readonly" value="<%=tpp.getReceivedetail() == null ? "" : tpp.getReceivedetail()%>">
				</p>
				<p>
				    <label>担保份数：</label> <input type="text" name="total" readonly="readonly" value="<%=tpp.getTotal() == null ? "" : tpp.getTotal()%>" /> 
                </p>
				<p>
					<label>划付明细：</label> <input type="text" id="paydetail" name="paydetail" value="<%=tpp.getPaydetail() == null ? "" : tpp.getPaydetail()%>">
				</p>
				<p>
					<label>划付时间：</label> <input type="text" id="paydate" name="paydate" class="date" value="<fmt:formatDate value="<%=tpp.getPaydate() %>" pattern="yyyy-MM-dd"/> "  ><a class="hidden" href="javascript:;"></a>
				</p>
		</div>
		<div class="formBar">
		<ul>
		    <c:if test="${tpp.reportflag eq 'pass'}">  
			<li><div class="buttonActive"><div class="buttonContent"><button type="button" onclick="ensure();">确认划付</button></div></div></li>
			</c:if>
			<li><a class="buttonActive" target="navTab"  rel="unpayLiv" href="<%=baseUrl %>/passure/unpayment" title="担保待划付"><span>返回</span></a></li>
			<li><div class="buttonActive"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
					</form>
					</div>
	</div>
	
	<div class="panel collapse" >
		<h1>已划付担保信息</h1>
		<table class="table" width="100%" layoutH="280">
			<thead>
				<tr>
					<th></th>
					<th>反担保人</th>
					<th>担保编号</th>
					<th>出具时间</th>
					<th>担保币种</th>
					<th>担保金额</th>
					<th>到账币种</th>
					<th>到账手续费</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="a" items="${paysublist}" varStatus="s">
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
	
</div>


      <c:import url="../layout/pager/panelBar.jsp"></c:import>
      
<script type="text/javascript" >
function ensure(){
	var a = $('#paydetail').val().trim();
	var b = $('#paydate').val().trim();
   //if(a == null || a == ""){
	 //  alert("划付明细不能为空!");
   //}
   if(b == null || b == ""){
	   alert("划付时间不能为空!");
   }
   else{
	   $('#paymentsend').submit();
   }
}

</script>     