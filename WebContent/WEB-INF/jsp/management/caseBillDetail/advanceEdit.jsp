<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@ page import="com.git.db.beans.CaseClaimImpl" %>
<%
	CaseClaimImpl caseClaimImpl = (CaseClaimImpl)request.getAttribute("caseClaimImpl");
%>

<script language="javascript" src="styles/js/util.js"></script>
<script type="text/javascript">
	function advanceCalculate(){
		var realamount =formatFloat($("#realamount").val(), 2,$("#realamount").val());
		var usdrate = formatFloat($("#usdrate").val(), 7, $("#usdrate").val());
		var usdamount = realamount / usdrate;
		$("#usdamount").val(usdamount);
	}
	
</script>

<div class="pageContent">
	<form method="post" action="<%=baseUrl %>/management/caseBillDetail/insertAdvance?navTabId=billEditNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="billId" value="${billId }">
		<input type="hidden" name="claimId" value="${caseClaimImpl.claimId }">
		<input type="hidden" name="flag" value="add">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/caseBill/edit/{billId}"/>
		
		<div  class="pageFormContent">
			<p>
				<label>收款人：</label>
				<input name="clientname" class="required" type="text"  readonly="readonly" size="30" value="${caseClaimImpl.clientname}" />
			</p>
			<p>
				<label>申请类型：</label>
				<input name="recordtype" class="required" type="text" readonly="readonly" size="30" value="垫付费用" />
			</p>
			<p>
				<label>划付币种：</label>
				<input id="currency3" name="currency" class="required" readonly="readonly" type="text" size="30" value="${caseClaimImpl.currency}" />
			</p>
			<p>
				<label>划付金额：</label>
				<input id="realamount" name="realamount" class="required" readonly="readonly" type="text" size="30" value="<%=caseClaimImpl.getRealamount()==null ? 0.0:caseClaimImpl.getRealamount() %>" />
			</p>
			<p>
				<label>划付时间：</label>
				<input name="treatdate" class="required" readonly="readonly" onblur="checkdate(this)" type="text" size="30" value="<fmt:formatDate value="<%= caseClaimImpl.getTreatdate() %>" pattern="yyyy-MM-dd"/>" />
			</p>
			<p>
				<label>折算汇率：</label>
				<input id="usdrate" name="usdrate" readonly="readonly" onchange="advanceCalculate();" class="required" type="text" size="30" value="${caseClaimImpl.usdrate}" />
			</p>
			<p>
				<label>记账金额：</label>
				<input id="usdamount" name="usdamount" readonly="readonly" class="required" type="text" size="30" value="${caseClaimImpl.usdamount }" />
			</p>
		</div>
		<div class="formBar">
			<ul>
				<c:if test="${flag ne 'view'}">
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">添加</button></div></div></li>
				</c:if>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>