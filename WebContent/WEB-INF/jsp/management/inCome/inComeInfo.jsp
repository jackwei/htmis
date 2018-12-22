<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.BillIncomeImpl" %>
<%
	BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getAttribute("billIncomeImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>
<script language="javascript" src="styles/js/htmis.util.js"></script>
<script type="text/javascript">

function statementCalculate(){
	var payamount = formatFloat($("#payamount").val(),2,$("#payamount").val());
	var lossamount = formatFloat($("#lossamount").val(),2,$("#lossamount").val());
	var transformrate = formatFloat($("#transformrate").val(), 2,$("#transformrate").val());
	var transformamount = 0.0;
	
	var isTransform =  $("#isTransform").val();
	if('0' == isTransform){
		var changeamount = payamount+lossamount;
		$("#changeamount").val(formatFloat(changeamount,2,changeamount));
	}else{
		if(transformrate !=0 ){
			changeamount =payamount/transformrate+lossamount;
		}
		$("#changeamount").val(formatFloat(changeamount,2,changeamount));
	}
}

function transformCalculate(){
	var payamount = formatFloat($("#payamount").val(),2,$("#payamount").val());
	var transformrate = formatFloat($("#transformrate").val(), 2,$("#transformrate").val());
	var lossamount = formatFloat($("#lossamount").val(),2,$("#lossamount").val());
	var transformamount = 0.0;
	if(transformrate !=0 ){
		transformamount =payamount/transformrate+lossamount;
	}
	$("#transformamount").val(formatFloat(transformamount,2,transformamount));
}

function submitForm(){
	/* var currency = $("#currency").val();
	var lossamount = $("#lossamount").val();
	if(currency == 'USD'){
		if(lossamount > 50){
			alertMsg.info("手续费不能大于50USD!");
			return ;
		}
	} */
	$("#inComeForm").submit();
	
}
</script>
	<div class="pageContent">
	 <form id="inComeForm" method="post" action="<%=baseUrl %>/management/inCome/insert?navTabId=billList&callbackType=forward" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<input type="hidden" id="inComeId"  name="inComeId" value="<%= billIncomeImpl.getIncomeId()==null ? "": billIncomeImpl.getIncomeId() %>"/>
		<input type="hidden" id="doctype" name="doctype" value="inComedoc">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/inCome/edit/{inComeId}"/>
		
		<div  class="pageFormContent" layoutH="236">
			<p>
				<label>进账单编号：</label>
				<input name="statementnumber" type="text" readonly="readonly" size="30" value="<%= billIncomeImpl.getStatementnumber() == null ? "":billIncomeImpl.getStatementnumber() %>" />
			</p>
			<p>
				<label>案件编号：</label>
				<input id="casenumber" type="text" name="feenumber" class="required" size="30" value="<%= billIncomeImpl.getFeenumber() ==null ? "": billIncomeImpl.getFeenumber() %>" onchange="checkCaseNumber(this.value)" />
			</p>
			<p>
				<label>付款人：</label>
				<input type="text" name="payername" class="required" size="30" value="<%= billIncomeImpl.getPayername() ==null ? "":billIncomeImpl.getPayername() %>" />
			</p>
			<p>
			    <label>进账单类型：</label>
			    <select name="incometype" class="combox required">
			    	<option value="">请选择</option>
			    	<c:forEach var="type" items="${inComeType}" >
			    		<option value="${type['code'] }" ${type['code'] eq billIncomeImpl.incometype ? 'selected="selected"':'' } >${fn:trim(type['desc']) }</option>
			    	</c:forEach>
			    </select> 
			</p>
			<p>
				<label>货币类型：</label>
				<select id="currency" name="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billIncomeImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>到账时间：</label>
				<input type="text" name="tradedate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= billIncomeImpl.getTradedate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>票面金额：</label>
				<input id="payamount" type="text" name="payamount"onchange="statementCalculate();" onchange="statementCalculate();" class="required" size="30" value="<fmt:formatNumber value="${billIncomeImpl.payamount}" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>手续费：</label>
				<input id="lossamount" type="text" name="lossamount" onchange="statementCalculate();" class="required" max="50" size="30" value="<fmt:formatNumber value="${billIncomeImpl.lossamount == null ? 0.00:billIncomeImpl.lossamount}" pattern="##.##" minFractionDigits="2" />" />
			</p>

			<%-- <p>
				<label>所属部门：</label>
				<input type="hidden" id="orgCode2" name="orgLookup.orgCode" value="<%= billIncomeImpl.getOrgcode2() == null ? "":billIncomeImpl.getOrgcode2() %>" />
				<input class="required textInput valid" size="23" readonly="readonly" type="text" id ="orgName2" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off"  value="<%= billIncomeImpl.getOrgname2() == null ? "":billIncomeImpl.getOrgname2() %>" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=D" lookupgroup="orgLookup" height="500">上级机构查找带回选中的值</a>			
			</p> --%>
			
			<p>
				<label>是否转换</label>
				<select id="isTransform" name="isTransform" class="combox required" onchange="statementCalculate();">
					<c:forEach var="ct" items="${yesno}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billIncomeImpl.isTransform ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
				</select>
			</p>
			<p>
				<label>转换币种</label>
				<select id="transformcurrency" name="transformcurrency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billIncomeImpl.transformcurrency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>转换汇率</label>
				<input id="transformrate" type="text" name="transformrate" onchange="statementCalculate();" size="30" value="<fmt:formatNumber value="${billIncomeImpl.transformrate == null ? 0.00:billIncomeImpl.transformrate}" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<%-- <p>
				<label>转换金额</label>
				<input id="transformamount" type="text" name="transformamount" readonly="readonly" size="30" value="<%= billIncomeImpl.getTransformamount() ==null ? 0.0:billIncomeImpl.getTransformamount() %>" />
			</p> --%>
			<p>
				<label>对账金额：</label>
				<input id="changeamount" type="text" name="changeamount" class="required" readonly="readonly" size="30" value="<fmt:formatNumber value="${billIncomeImpl.changeamount}" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>收款银行：</label>
				<select name="bank" class="combox required">
					<c:forEach var="ct" items="${banktype}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billIncomeImpl.bank ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2"><%=billIncomeImpl.getRemark()==null ? "":billIncomeImpl.getRemark() %></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><a class="button" href="javascript:submitForm();"><span>保存</span></a></li>
				<!-- <li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li> -->
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