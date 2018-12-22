<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.ClaimIncomeImpl" %>
<%@page import=" com.git.db.beans.CaseClaimImpl" %>
<%
ClaimIncomeImpl claimIncomeImpl = (ClaimIncomeImpl)request.getAttribute("claimIncomeImpl");
CaseClaimImpl caseClaimImpl = (CaseClaimImpl)request.getAttribute("caseClaimInpl");
%>

<script type="text/javascript">
function divSearch(form,rel){
	var $form=$(form);
	if(!$form.valid()){
  		return false;}
	
	if(form[DWZ.pageInfo.pageNum])form[DWZ.pageInfo.pageNum].value=1;
	if(rel){
	var $box=$("#"+rel);
	$box.ajaxUrl({
	type:"POST",url:$form.attr("action"),data:$form.serializeArray(),callback:function(){
	$box.find("[layoutH]").layoutH();}});}
	$.pdialog.closeCurrent();
	return false;
}
</script>
	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/claim/insert?navTabId=${backNav}&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return divSearch(this,'claimIncomeNav');">
		<input type="hidden" id="IncomeId" name="IncomeId" value="<%= claimIncomeImpl.getIncomeId()==null ? "":claimIncomeImpl.getIncomeId() %>"/>
		<input type="hidden" id="claimId" name="claimId" value="<%= caseClaimImpl.getClaimId()==null ? "":caseClaimImpl.getClaimId() %>"/>
		<input type="hidden" id="caseId" name="caseId" value="${caseId}"/>
		<input type="hidden" id="casenumber" name="casenumber" value="${casenumber}"/>
		<input type="hidden" id="shipname" name="shipname" value="${shipname}"/>
		<input type="hidden" id="doctype" name="doctype" value="applydoc" >
		<div class="pageFormContent" id="commonDiv">
			<p>
				<label>收款人：</label>
				<input name="clientname" type="text" class="required" value="<%= caseClaimImpl.getClientname() == null ? "":caseClaimImpl.getClientname() %>" />
			</p>
			<p>
				<label>申请类型：</label>
				<input type="hidden"  name="recordtype" value="D">
				<input type="text" disabled="disabled"  value="余额退回" />
			</p>
			<p >
			  <label>开户行：</label>
				<input type="text" id="applybank" class="required" name="applybank"  value="<%= caseClaimImpl.getApplybank()==null ? "":caseClaimImpl.getApplybank() %>" />
			</p>
			<p >
			  <label>账号：</label>
			  <input type="text"  class="required" id="applybanknum" name="applybanknum"  value="<%= caseClaimImpl.getApplybanknum()==null ? "":caseClaimImpl.getApplybanknum() %>" />
			</p>
			<p>
				<label>申请币种：</label>
				 <input type="text" id="recordcurrency" readonly="readonly" name="recordcurrency"  value="<%= claimIncomeImpl.getCurrency()==null ? "":claimIncomeImpl.getCurrency() %>" />
			</p>
			<p>
			  <label>申请金额：</label>
			  <input type="text" id="recordmount" readonly="readonly" name="recordmount"  value="<%= claimIncomeImpl.getDifferamount()==null ? "":claimIncomeImpl.getDifferamount() %>" />
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="30" rows="2" ><%= caseClaimImpl.getRemark() == null ? "":caseClaimImpl.getRemark()%></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<c:if test="${claimIncomeImpl.status eq '0' || claimIncomeImpl.status eq '5' || claimIncomeImpl.status eq '4'}">
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				</c:if>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	 </form>
	 <script type="text/javascript">
	  	$("#recordtype").val('D');
	 </script>
	</div>