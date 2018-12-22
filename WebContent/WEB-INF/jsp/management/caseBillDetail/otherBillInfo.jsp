<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@ page import=" com.git.db.beans.CaseBillDetailImpl" %>
<%
	CaseBillDetailImpl caseBillDetailImpl = (CaseBillDetailImpl)request.getAttribute("caseBillDetailImpl");
%>

<script language="javascript" src="styles/js/util.js"></script>
<script type="text/javascript">

function otherfeeCalculate() {
	var feeamount = formatFloat($("#feeamount2").val(), 2, $("#feeamount2").val());
	var changerate = formatFloat($("#changerate2").val(), 7, $("#changerate2").val());
	var accamount = feeamount / changerate;
	$("#accamount2").val(formatFloat(accamount, 2, accamount));
}

</script>
<div class="pageContent">
	<form method="post" action="<%=baseUrl %>/management/caseBillDetail/insertOther?navTabId=billEditNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" name="detailId" value="<%=caseBillDetailImpl.getDetailId()==null ? "":caseBillDetailImpl.getDetailId() %>">
		<input type="hidden" name="billId" value="${billId }">
		<input type="hidden" name="feenumber" value="${feenumber }">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/caseBill/edit/{billId}"/>
		
		<div  class="pageFormContent">
			<p>
				<label>发生时间：</label>
				<input name="happendate" class="date required" onblur="checkdate(this)" type="text" size="30" value="<fmt:formatDate value="<%= caseBillDetailImpl.getHappendate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>费用项目：</label>
				<input name="remark" class="required" type="text" size="30" value="<%=caseBillDetailImpl.getRemark()==null ? "":caseBillDetailImpl.getRemark() %>" />
			</p>
			<p>
				<label>货币类型：</label>
				<select name="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq caseBillDetailImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>金额：</label>
				<input id="feeamount2" name="feeamount" onchange="otherfeeCalculate();" class="required" type="text" size="30" value="<%=caseBillDetailImpl.getFeeamount()==null ? 0.0:caseBillDetailImpl.getFeeamount() %>" />
			</p>
			<p>
				<label>折算汇率：</label>
				<input id="changerate2" name="changerate" onchange="otherfeeCalculate();" class="required" type="text" size="30" value="<%=caseBillDetailImpl.getChangerate()==null ? 6.8:caseBillDetailImpl.getChangerate() %>" />
			</p>
			<p>
				<label>记账金额：</label>
				<input id="accamount2" name="accamount" class="required" type="text" size="30" value="<%=caseBillDetailImpl.getAccamount()==null ? 0.0:caseBillDetailImpl.getAccamount() %>" readonly="readonly" />
			</p>
			
		</div>
		<div class="formBar">
			<ul>
				<c:if test="${flag ne 'view'}">
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				</c:if>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>