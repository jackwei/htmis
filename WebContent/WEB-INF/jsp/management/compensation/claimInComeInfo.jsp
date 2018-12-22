<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.ClaimIncomeImpl" %>
<%
ClaimIncomeImpl claimIncomeImpl = (ClaimIncomeImpl)request.getAttribute("claimIncomeImpl");
%>

<script language="javascript" src="styles/js/util.js"></script>
<script language="javascript" src="styles/js/htmis.util.js"></script>

<script type="text/javascript">

/* function testConfirmMsg(url, data){
	alert(data);
	alertMsg.confirm("请选择保存或取消！", {
		okCall: function(){
			$.post(url, {'casenumber':data}, DWZ.ajaxDone, "json");
		}
	});
} */

function testConfirmMsg(url, data){
	var url="<%=baseUrl %>/management/case/check";
	$.post(url, {'casenumber':data}, DWZ.ajaxDone, "json");
}

function calculateInCome(){
	receiveamount = formatFloat($("#receiveamount").val(), 2, $("#receiveamount").val());
	bankfee = formatFloat($("#bankfee").val(), 2, $("#bankfee").val());
	var totalamount = receiveamount+bankfee;
	totalamount = formatFloat(totalamount, 2, totalamount);
	$("#totalamount").val(totalamount);
	usdrate = formatFloat($("#usdrate").val(), 2,$("#usdrate").val());
	var usdamount = 0.0;
	if(usdrate !=0 ){
		usdamount =totalamount/usdrate;
	}
	$("#usdamount").val(formatFloat(usdamount,2,usdamount));
}

</script>

	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/compensation/insert?navTabId=claimInComeList&callbackType=forward" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<input type="hidden" id="inComeId" name="inComeId" value="<%= claimIncomeImpl.getIncomeId()==null ? "": claimIncomeImpl.getIncomeId() %>"/>
		<input type="hidden" id="doctype" name="doctype" value="claimdoc">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/compensation/edit/{inComeId}"/>
		
		<div  class="pageFormContent" layoutH="236">
			<p>
				<label>案号：</label>
				<input id="casenumber" name="casenumber" type="text"  class="required" size="30" value="<%=claimIncomeImpl.getCasenumber()==null ? "":claimIncomeImpl.getCasenumber() %>"  onchange="checkCaseNumber(this.value)" />
			</p>
			<p>
				<label>船名：</label>
				<input id="shipname" name="shipname" readonly="readonly" type="text"  size="30" value="<%=claimIncomeImpl.getShipname()==null ? "":claimIncomeImpl.getShipname() %>" />
			</p>
			<p>
				<label>付款人：</label>
				<input name="payer" type="text" class="required" size="30" value="<%=claimIncomeImpl.getPayer()==null ? "":claimIncomeImpl.getPayer() %>" />
			</p>
			<p>
				<label>赔款币种：</label>
				<select name="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
					    <option value="${ct['dictid'] }" ${ct['dictid'] eq claimIncomeImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>到账金额：</label>
				<input id="receiveamount" name="receiveamount" onchange="calculateInCome();" type="text" class="required" size="30" value="<%=claimIncomeImpl.getReceiveamount()==null ? 0:claimIncomeImpl.getReceiveamount() %>" />
			</p>
			<p>
				<label>银行手续费：</label>
				<input id="bankfee" name="bankfee" onchange="calculateInCome();" type="text" class="required" size="30" value="<%=claimIncomeImpl.getBankfee()==null ? 0:claimIncomeImpl.getBankfee() %>" />
			</p>
			<p>
				<label>合计金额：</label>
				<input id="totalamount" name="totalamount" type="text" class="required" readonly="readonly" size="30" value="<%=claimIncomeImpl.getTotalamount()==null ? 0:claimIncomeImpl.getTotalamount() %>" />
			</p>
			<%-- <p>
				<label>USD汇率：</label>
				<input id="usdrate" name="usdrate" onchange="calculateInCome();" type="text" class="required" size="30" value="<%= claimIncomeImpl.getUsdrate()==null ? 0.0:claimIncomeImpl.getUsdrate() %>" />
			</p>
			<p>
				<label>USD金额：</label>
				<input id="usdamount" name="usdamount" type="text" class="required" size="30" value="<%= claimIncomeImpl.getUsdamount()==null ? 0:claimIncomeImpl.getUsdamount() %>" />
			</p> --%>
			<p>
				<label>银行流水号：</label>
				<input name="banknum" type="text" size="30" value="<%= claimIncomeImpl.getBanknum()==null ? 0: claimIncomeImpl.getBanknum() %>" />
			</p>
			<p>
				<label>收款银行：</label>
				<select name="bank" class="combox required">
					<c:forEach var="ct" items="${banktype}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billIncomeImpl.bank ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>到账时间：</label>
				<input type="text" name="receivedate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= claimIncomeImpl.getReceivedate() %>" pattern="yyyy-MM-dd"/>"  /><a class="inputDateButton" href="javascript:;">选择</a>
				
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" ><%= claimIncomeImpl.getRemark() == null ? "":claimIncomeImpl.getRemark()%></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><a target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{inComeId},{doctype}" warn="请先保存信息" title="附件上传" ><span>上传/查看附件</span></a></div></li>
				
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	 </form>
	 <div class="panel" >
		<h1>附件信息</h1>
		<div style="overflow:scroll;height: 200px;">
		 <table class="table" width="70%" layoutH="300">
		 	<thead>
				<tr align="center" class="headers">
					<th  width="15%"></th>
					<th>附件名称</th>
					<th>操作</th>
					<th width="30%">备注</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${docList}" varStatus="s">
				<tr target="oid" rel="${item.id }">
					<td>${s.index + 1}</td>
					<td>${item.docname}</td>
					<td>
						<a class='button' href='<%=baseUrl %>/FileDown/download?oid=${item.id }'><span>下载</span></a>
					</td>
					<td>${item.docdes}</td>
				</tr>
			</c:forEach>
		 </table>
		 </div>
	 </div>
	</div>