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
<div class="pageContent sortDrag" selector="h1" layoutH="10">
 		<form method="post" action="<%=baseUrl %>/management/claimHandle/insert?navTabId=claimHandleList&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
			<div class="panel collapse">
			<h1>赔款信息</h1>
				<input type="hidden" id="claimId" name="claimId" value="<%= caseClaimImpl.getClaimId()==null ? "":caseClaimImpl.getClaimId() %>"/>
				<input type="hidden" id="caseId" name="caseId" value="<%= caseClaimImpl.getCaseId()==null ? "":caseClaimImpl.getCaseId() %>"/>
				
				<div class="pageFormContent">
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
						<label>划付类型：</label>
						<c:forEach var="ct" items="${recordtype}">
							<c:if test="${ct['dictid'] eq caseClaimImpl.recordtype}">
								<input name="recordtype" readonly="readonly" type="text" size="30" value="${fn:trim(ct['dictname'])}" />
							</c:if>
			    		</c:forEach>
					</p>
					<p>
						<label>申请币种：</label>
						<input id="recordcurrency" name="recordcurrency" readonly="readonly"  type="text" size="30" value="<%= caseClaimImpl.getRecordcurrency() == null ? "":caseClaimImpl.getRecordcurrency() %>" />
					</p>
					<p>
						<label>申请金额：</label>
						<input type="text" readonly="readonly" name="recordmount" id="recordmount"  class="required" size="30" value="<fmt:formatNumber value="${caseClaimImpl.recordmount}" pattern="##.##" minFractionDigits="2" />" />
					</p>
					<p>
						<label>划付币种：</label>
						<select name="currency" id="currency" class="combox required">
							<c:forEach var="ct" items="${currency}">
								<option value="${ct['dictid'] }" ${ct['dictid'] eq caseClaimImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
				    		</c:forEach>
			    		</select>
					</p>
					<p>
						<label>划付金额：</label>
						<input type="text" name="realamount" id="realamount" readonly="readonly" class="required" size="30" alt="0.00" value="<fmt:formatNumber value="${caseClaimImpl.realamount == null ? 0.00:caseClaimImpl.realamount}" pattern="##.##" minFractionDigits="2" />" />
					</p>
					<p>
						<label>划付余额：</label>
						<input type="text" name="differamount" id="differamount" readonly="readonly"  class="required" size="30" value="<fmt:formatNumber value="${caseClaimImpl.differamount}" pattern="##.##" minFractionDigits="2" />" />
					</p>
					<p>
						<label>赔款汇率：</label>
						<input id="usdrate" type="text" name="usdrate" readonly="readonly" id="usdrate" size="30" value="<%= caseClaimImpl.getUsdrate()==null ? 0.0:caseClaimImpl.getUsdrate() %>" />
					</p>
					<!-- <p>
						<label>是否转汇差</label>
						<select id="isSubRate" name="isSubRate" class="combox required">
							<option value="1">是</option>
							<option value="0">否</option>
						</select>
					</p> -->
					<%-- <p>
						<label>USD金额：</label>
						<input type="text" name="usdamount" id="usdamount" class="required" size="30" value="<%= caseClaimImpl.getUsdamount()==null ? 0.0:caseClaimImpl.getUsdamount() %>" />
					</p> --%>
					<%-- <p>
						<label>银行流水号：</label>
						<input type="text" name="banknum" size="30" value="<%= caseClaimImpl.getBanknum()==null ? "":caseClaimImpl.getBanknum() %>" />
					</p> 
					<p>
						<label>划付时间：</label>
						<input type="text" name="treatdate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= caseClaimImpl.getTreatdate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
					</p>--%>
					<dl class="nowrap">
						<dt>备注：</dt>
						<dd><textarea name="remark" cols="80" rows="2" ><%= caseClaimImpl.getRemark() == null ? "":caseClaimImpl.getRemark()%></textarea></dd>
					</dl>
				</div>
				<!-- <div class="formBar">
					<ul>
						<li>
							<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
						</li>
					</ul>
				</div> -->
		</div>
	</form> 
	
	<div class="panel collapse">
		<h1>选择赔款到账</h1>
		<c:import url="../claimHandle/checkClaimList.jsp"></c:import>
	</div>
	
</div>