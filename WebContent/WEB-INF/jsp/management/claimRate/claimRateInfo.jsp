<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseClaimImpl" %>
<%
CaseClaimImpl caseClaimImpl = (CaseClaimImpl)request.getAttribute("caseClaimImpl");
%>

<script language="javascript" src="styles/js/util.js"></script>
<script type="text/javascript">

function calculate(){
	
	var realamount = $("#realamount").val();
	var usdrate = $("#usdrate").val();
	var usdamount = $("#usdamount").val();
	
	$("#realamount").val(formatFloat(realamount, 2, realamount));
	$("#usdrate").val(formatFloat(usdrate, 7, usdrate));
	usdamount =realamount/usdrate;
	$("#usdamount").val(formatFloat(usdamount, 2, usdamount));
}

</script>
	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/claimHandle/insert?navTabId=claimHandleList&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<input type="hidden" id="claimId" name="claimId" value="<%= caseClaimImpl.getClaimId()==null ? "":caseClaimImpl.getClaimId() %>"/>
		<input type="hidden" id="caseId" name="caseId" value="<%= caseClaimImpl.getCaseId()==null ? "":caseClaimImpl.getCaseId() %>"/>
		
		<div class="pageFormContent" layoutH="56">
			<p>
				<label>案号 ：</label>
				<input name="casenumber" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getCasenumber() == null ? "":caseClaimImpl.getCasenumber() %>" />
			</p>
			<p>
				<label>船名：</label>
				<input name="shipname" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getShipname() == null ? "":caseClaimImpl.getShipname() %>" />
			</p>
			<p>
				<label>收款人：</label>
				<input name="clientname" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getClientname() == null ? "":caseClaimImpl.getClientname() %>" />
			</p>
			<p>
				<label>申请类型：</label>
				<input name="recordtype" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getRecordtype() == null ? "":caseClaimImpl.getRecordtype() %>" />
			</p>
			<p>
				<label>申请币种：</label>
				<input name="applycurrency" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getApplycurrency() == null ? "":caseClaimImpl.getApplycurrency() %>" />
			</p>
			<p>
				<label>申请金额：</label>
				<input type="text" name="applyamount" id="applyamount"  onchange="calculate();" class="required" size="30" value="<%= caseClaimImpl.getApplyamount()==null ? 0.0:caseClaimImpl.getApplyamount() %>" />
			</p>
			<p>
				<label>交易币种：</label>
				<select name="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>金额：</label>
				<input type="text" name="realamount" id="realamount" class="required" onchange="calculate();" size="30" value="<%= caseClaimImpl.getRealamount()==null ? 0.0:caseClaimImpl.getRealamount() %>" />
			</p>
			<p>
				<label>USD汇率：</label>
				<input type="text" name="usdrate" id="usdrate" class="required"  onchange="calculate();" size="30" value="<%= caseClaimImpl.getUsdrate()==null ? 0.0:caseClaimImpl.getUsdrate() %>" />
			</p>
			<p>
				<label>USD金额：</label>
				<input type="text" name="usdamount" id="usdamount" class="required" size="30" value="<%= caseClaimImpl.getUsdamount()==null ? 0.0:caseClaimImpl.getUsdamount() %>" />
			</p>
			<p>
				<label>银行流水号：</label>
				<input type="text" name="banknum" size="30" value="<%= caseClaimImpl.getBanknum()==null ? "":caseClaimImpl.getBanknum() %>" />
			</p>
			<p>
				<label>划付时间：</label>
				<input type="text" name="treatdate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= caseClaimImpl.getTreatdate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" ><%= caseClaimImpl.getRemark() == null ? "":caseClaimImpl.getRemark()%></textarea></dd>
			</dl>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	 </form>
	</div>