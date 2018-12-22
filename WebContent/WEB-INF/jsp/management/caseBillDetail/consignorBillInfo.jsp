<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@ page import=" com.git.db.beans.CaseBillDetailImpl" %>
<%
	CaseBillDetailImpl caseBillDetailImpl = (CaseBillDetailImpl)request.getAttribute("caseBillDetailImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>
<script type="text/javascript">

function sendthird(){
	alertMsg.confirm("请及时上传第三方账单！", {
		okName:"是",cancelName:"否",
		okCall: function(){
			$('#consignorbill').submit();
		},cancelCall: function(){
			$('#consignorbill').submit();
		}
	});

}

function thirdPartCalculate() {
	//var servicefee = document.getElementById("servicefee").value;
	
	var servicefee =formatFloat($("#servicefee1").val(), 2,$("#servicefee1").val());
	var expendses = formatFloat($("#expendses1").val(), 2,$("#expendses1").val());
	var replacefee = formatFloat($("#replacefee1").val(), 2, $("#replacefee1").val());
	var changerate = formatFloat($("#changerate1").val(), 7, $("#changerate1").val());
	
	var feeamount = servicefee + expendses + replacefee ;
	$("#feeamount1").val(formatFloat(feeamount, 2, feeamount));
	var accamount = feeamount / changerate;
	$("#accamount1").val(formatFloat(accamount, 2, accamount));
}

function dialogReloadNavTab(json){
    DWZ.ajaxDone(json);
    var tabId = $("ul.navTab-tab li.selected").attr("tabid");
    if (json.statusCode == DWZ.statusCode.ok){
        if (json.navTabId || tabId!=null){
            navTab.reload(json.forwardUrl, {navTabId: json.navTabId});
        } else if (json.rel) {
            var $pagerForm = $("#pagerForm", navTab.getCurrentPanel());
            var args = $pagerForm.size()>0 ? $pagerForm.serializeArray() : {}
            navTabPageBreak(args, json.rel);
        }
        if ("closeCurrent" == json.callbackType) {
            $.pdialog.closeCurrent();
        }
    }
}
 
</script>

<div class="pageContent">
	<form method="post" id="consignorbill" action="<%=baseUrl %>/management/caseBillDetail/insertConsignor?navTabId=billEditNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, dialogAjaxDone);">
		<input type="hidden" id="detailId" name="detailId" value="<%=caseBillDetailImpl.getDetailId()==null ? "":caseBillDetailImpl.getDetailId() %>">
		<input type="hidden" name="billId" value="${billId }">
		<input type="hidden" name="feenumber" value="${feenumber }">
		<input type="hidden" id="doctype" name="doctype" value="pcasedoc">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/caseBill/edit/{billId}"/>

		<div  class="pageFormContent">
			<%-- <p>
				<label>单位名称：</label>
				<input name="consignorname" type="text" size="30" value="<%=caseBillDetailImpl.getConsignorname()==null ? "":caseBillDetailImpl.getConsignorname() %>"/>
			</p> --%>
			
			<p>
			    <label>单位名称：</label>
			    <input type="hidden" name="consignor.oid" value="<%=caseBillDetailImpl.getConsignorid() ==null ? "":caseBillDetailImpl.getConsignorid() %>" >
			    <input class="required" type="text" size="30" lookupgroup="consignor" readonly="readonly" value="<%=caseBillDetailImpl.getConsignorname()==null ? "":caseBillDetailImpl.getConsignorname() %>" suggestFields="oid,nameen" name="consignor.namecn" ></input>
			    <a class="btnLook" href="<%=baseUrl %>/client/thirdparty/thirdsearch" lookupGroup="consignor" >第三方客户查询</a>	
	        </p>
			
			<p>
				<label>报告时间：</label>
				<input name="reportdate" class="date required" onblur="checkdate(this)" type="text" size="30" value="<fmt:formatDate value="<%= caseBillDetailImpl.getReportdate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>第三方案号：</label>
				<input name="casenumber" class="required" type="text" size="30" value="<%=caseBillDetailImpl.getCasenumber()==null ? "":caseBillDetailImpl.getCasenumber() %>" />
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
				<label>委请时间：</label>
				<input name="applydate" class="date required" onblur="checkdate(this)" type="text" size="30" value="<fmt:formatDate value="<%= caseBillDetailImpl.getApplydate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>费用：</label>
				<input id="expendses1" name="expendses" class="required" onchange="thirdPartCalculate();" type="text" size="30"  value="<%=caseBillDetailImpl.getExpendses()==null ? 0.0:caseBillDetailImpl.getExpendses() %>" />
			</p>
			<p>
				<label>第三方服务费：</label>
				<input id="servicefee1" name="servicefee" class="required" onchange="thirdPartCalculate();" type="text" size="30" value="<%=caseBillDetailImpl.getServicefee()==null ? 0.0:caseBillDetailImpl.getServicefee() %>" />
			</p>
			<p>
				<label>折算汇率：</label>
				<input id="changerate1" name="changerate" class="required" onchange="thirdPartCalculate();" type="text" size="30" value="<%=caseBillDetailImpl.getChangerate()==null ? 1:caseBillDetailImpl.getChangerate() %>" />
			</p>
			<p>
				<label>第三方垫付费用：</label>
				<input id="replacefee1" name="replacefee" class="required" onchange="thirdPartCalculate();" type="text" size="30" value="<%=caseBillDetailImpl.getReplacefee()==null ? 0.0:caseBillDetailImpl.getReplacefee() %>" />
			</p>
			<p>
				<label>记账金额：</label>
				<input id="accamount1" name="accamount" class="required" type="text" size="30" value="${caseBillDetailImpl.accamount}" readonly="readonly" />
			</p>
			<%-- <p>
				<label>合计：</label>
				<input id="feeamount1" name="feeamount" type="text" size="30" value="<%=caseBillDetailImpl.getFeeamount()==null ? 0.0:caseBillDetailImpl.getFeeamount() %>" readonly="readonly"/>
			</p> --%>
			
		</div>
		<div class="formBar">
			<ul>
				<c:if test="${flag ne 'view'}">
					<div class="button"><a rel="sut" href="javascript:sendthird();"  alt="ddd"><span>保存</span></a></div>
<!-- 					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
 -->				</c:if>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>	</li>
				<%-- <li><div class="buttonActive"><a mask='true' target='dialog' width='600' height='300'  href='<%=baseUrl %>/applyInfos/toUploadFile/{detailId},{doctype}' warn="保存后方可上传附件"><span>上传附件</span></a></div></li> --%>
			</ul>
		</div>
	</form>
</div>