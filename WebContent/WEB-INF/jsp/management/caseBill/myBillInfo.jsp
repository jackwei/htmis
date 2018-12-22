<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>
<%@page import=" com.git.db.beans.CaseBillImpl" %>
<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
	CaseBillImpl caseBillImpl = (CaseBillImpl)request.getAttribute("caseBillImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>

<script type="text/javascript">

$(function(){
	var billId = <%=caseBillImpl.getBillId() %>;
	if(billId == null){
		var shipname = $("#shipname").val();
		var consignorsn = $("#consignorsn").val();
		var consignorname = $("#consignorname").val();
		if("QT"==consignorsn||"OWN"==consignorsn){
			$("#payer").val(consignorsn);
		}else {
			$("#payer").val("Owners/Charterers of m/v "+shipname);
			$("#coname").val(consignorname);
		}
	}
	
});

function feeCalculate() {
	var otherfee = formatFloat($("#otherfee").val(), 2, $("#otherfee").val());
	var thirdpart = formatFloat($("#thirdpart").val(), 2, $("#thirdpart").val());
	var servicefee = formatFloat($("#servicefee").val(), 2, $("#servicefee").val());
	var expendses = formatFloat($("#expendses").val(), 2, $("#expendses").val());
	var advancefee = formatFloat($("#advancefee").val(), 2, $("#advancefee").val());
	var compensationsub = formatFloat($("#compensationsub").val(), 2, $("#compensationsub").val()); 
	var feeamount = otherfee + thirdpart + servicefee+ expendses+compensationsub+advancefee;
	$("#feeamount").val(formatFloat(feeamount, 2, feeamount));
}

function createFeeNote(billId){
	if(billId == ""){
		alertMsg.warn("请保存账单信息!");
		return;
	}
	open("<%=baseUrl %>/management/caseBill/createFeeNote?billId="+billId,"账单", 'width:800,height:600,menubar=yes, resizable=yes,scrollbars=yes');
}

function sendBill(billId){
	<%-- var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward"; --%>
	var forwardUrl = "<%=baseUrl %>/management/caseBill/edit/{billId}";
	var url = "<%=baseUrl %>/management/caseBill/checkSendBill";
	var casenumber = $("#casenumber").val();
	
	$.post(url,{'casenumber':casenumber,'billId':billId},
			function(data){
				if(data.status == '3'){
					alertMsg.confirm("请确认该账单是否为final账单！", {
						okName:"是",cancelName:"否",
						okCall: function(){
							var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccFinal";
							$("#myBillForm").attr("action", url);
							$('#myBillForm').submit();
						},cancelCall: function(){
							/* $.post(url, {billId: billId,caseStatus:'AccPart',forwardUrl:forwardUrl}, DWZ.ajaxDone, "json"); */
							var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccPart";
							$("#myBillForm").attr("action", url);
							$('#myBillForm').submit();
						}
					});
				}else if(data.status == '2'){
					alertMsg.confirm("该案件下有汇款余额，是否需要添加至账单?", {
						okName:"是",cancelName:"否",
						okCall: function(){
							alertMsg.info("请添加后提交财务");
						},
						cancelCall: function(){
							alertMsg.confirm("请确认该账单是否为final账单！", {
								okName:"是",cancelName:"否",
								okCall: function(){
									var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccFinal";
									$("#myBillForm").attr("action", url);
									$('#myBillForm').submit();
								},cancelCall: function(){
									/* $.post(url, {billId: billId,caseStatus:'AccPart',forwardUrl:forwardUrl}, DWZ.ajaxDone, "json"); */
									var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccPart";
									$("#myBillForm").attr("action", url);
									$('#myBillForm').submit();
								}
							});
						}
					});
				}else if(data.status == '1'){
					alertMsg.confirm("该案件下有垫付费用，是否需要添加至账单?", {
						okName:"是",cancelName:"否",
						okCall: function(){
							alertMsg.info("请添加后提交财务");
						},
						cancelCall: function(){
							alertMsg.confirm("请确认该账单是否为final账单！", {
								okName:"是",cancelName:"否",
								okCall: function(){
									var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccFinal";
									$("#myBillForm").attr("action", url);
									$('#myBillForm').submit();
								},cancelCall: function(){
									/* $.post(url, {billId: billId,caseStatus:'AccPart',forwardUrl:forwardUrl}, DWZ.ajaxDone, "json"); */
									var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccPart";
									$("#myBillForm").attr("action", url);
									$('#myBillForm').submit();
								}
							});
						}
					});
				}else if(data.status == '4'){
					alertMsg.confirm("该账单下有汇款余额，提交财务后不能撤销操作，请确认", {
						okName:"确认",cancelName:"取消",
						okCall: function(){
							alertMsg.confirm("请确认该账单是否为final账单！", {
								okName:"是",cancelName:"否",
								okCall: function(){
									var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccFinal";
									$("#myBillForm").attr("action", url);
									$('#myBillForm').submit();
								},cancelCall: function(){
									/* $.post(url, {billId: billId,caseStatus:'AccPart',forwardUrl:forwardUrl}, DWZ.ajaxDone, "json"); */
									var url = "<%=baseUrl %>/management/caseBill/send?navTabId=caseEditNav&callbackType=forward&caseStatus=AccPart";
									$("#myBillForm").attr("action", url);
									$('#myBillForm').submit();
								}
							});
						},
						cancelCall: function(){
						}
					});
				}
				
			},'json');
}

function replace(v){
	
	if(v==1){
		alertMsg.confirm("请确认是否撤销该账单！", {
			okCall: function(){
				var url = "<%=baseUrl %>/management/caseBill/revoke?navTabId=caseEditNav&callbackType=forward";
				$("#myBillForm").attr("action", url);
				$("#myBillForm").submit();
			}
		});
	}else if(v==2 ){
		$("#myBillForm").submit();
	}
	
}
</script>

<div class="pageContent" >
	<form id="myBillForm" name="myBillForm" rel="bill" method="post" action="<%=baseUrl %>/management/caseBill/insert?navTabId=caseEditNav&callbackType=forward" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
		<input type="hidden" id="caseId" name="caseId" value="${caseInfoImpl.caseId}">
		<input type="hidden" id="casenumber" name="casenumber" value="${caseInfoImpl.casenumber}">
		<input type="hidden" id="billId" name="billId" value="<%=caseBillImpl.getBillId()==null ? "":caseBillImpl.getBillId() %>" />
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/caseBill/edit/{billId}"/>
		<input type="hidden" name="feestatuse" value="${caseBillImpl.feestatuse }"/>
		<input type="hidden" name="orgcode" value="${caseBillImpl.orgcode}"/>
		<input type="hidden" name="orgname" value="${caseBillImpl.orgname}"/>
		<input type="hidden" id="consignorsn" name="consignorsn" value="${caseInfoImpl.consignorsn}">
		<input type="hidden" id="shipname" name="shipname" value="${caseInfoImpl.shipname}">
		<input type="hidden" id="consignorname" name="consignorname" value="${caseInfoImpl.consignorname}">
		
		<div  class="pageFormContent" defH="20">
			<p>
				<label>账单编号：</label>
				<input name="feenumber" type="text" size="30" value="<%=caseBillImpl.getFeenumber()==null ? "":caseBillImpl.getFeenumber() %>" readonly="readonly"/>
			</p>
			<p>
				<label>To：</label>
				<input id="payer" name="payer" type="text" class="required" size="30" value="<%=caseBillImpl.getPayer()==null ? "":caseBillImpl.getPayer() %>" />
			</p>
			<p>
				<label>C/o：</label>
				<input id="coname" name="coname" type="text" class="required" size="30" value="<%=caseBillImpl.getConame()==null ? "":caseBillImpl.getConame() %>" />
			</p>
			<p>
				<label>Add：</label>
				<input name="address" type="text" size="30" value="<%=caseBillImpl.getAddress()==null ? "":caseBillImpl.getAddress() %>" />
			</p>
			<%-- <p>
				<label>担保手续费：</label>
				<input id="assurefee" name="assurefee" type="text" size="30" value="<%=caseBillImpl.getAssurefee() == null ? 0.0 :caseBillImpl.getAssurefee() %>" readonly="readonly"/>
			</p> --%>
			<p>
				<label>垫付费用</label>
				<input id="advancefee" name="advancefee" readonly="readonly"  size="30" type="text" value="<fmt:formatNumber value="${caseBillImpl.advancefee ==null ? 0.0:caseBillImpl.advancefee}" pattern="##.##" minFractionDigits="2" />" />
				<%-- <a class="btnLook" id="looks1"  href="<%=baseUrl %>/management/claim/searchAdvance?casenumber={casenumber}" lookupgroup="advanceLookup" >选择垫付费用</a> --%>			
			</p>
			<p>
				<label>汇款余额：</label>
				<input id="compensationsub"  name="compensationsub" type="text" size="30" readonly="readonly" value="<fmt:formatNumber value="${caseBillImpl.compensationsub == null ? 0.0:caseBillImpl.compensationsub}" pattern="##.##" minFractionDigits="2" />">
				<%-- <a class="btnLook" href="<%=baseUrl %>/params/search" lookupGroup="accidentport" height="500">垫付费用查询并带回选中的值</a> --%>	
			</p>
			<p>
				<label>第三方总金额：</label>
				<input id="thirdpart" name="thirdpart" type="text" size="30" value="<fmt:formatNumber value="${caseBillImpl.thirdpart ==null ? 0.0:caseBillImpl.thirdpart}" pattern="##.##" minFractionDigits="2" />" readonly="readonly"/>
			</p>
			<p>
				<label>其它费用：</label>
				<input id="otherfee" name="otherfee" type="text" size="30" value="<fmt:formatNumber value="${caseBillImpl.otherfee == null ? 0.0:caseBillImpl.otherfee}" pattern="##.##" minFractionDigits="2" />" readonly="readonly"/>
			</p>
			<p>
				<label>服务费：</label>
				<input id="servicefee" name="servicefee" class="required number" onchange="feeCalculate();" type="text" size="30" alt="0.00" value="<fmt:formatNumber value="${caseBillImpl.servicefee}" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>货币类型：</label>
				<select name="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq caseBillImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>费用：</label>
				<input id="expendses" name="expendses" class="required number" onchange="feeCalculate();" warn="ddd" type="text" size="30" alt="0.00" value="<fmt:formatNumber value="${caseBillImpl.expendses}" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>金额合计：</label>
				<input id="feeamount" name="feeamount" readonly="readonly" type="text" size="30" value="<fmt:formatNumber value="${caseBillImpl.feeamount == null ? 0.0:caseBillImpl.feeamount}" pattern="##.##" minFractionDigits="2" />" />
			</p>
			
			<dl class="nowrap">
				<dt>服务费说明：</dt>
				<dd><textarea name="servicedes" cols="80" rows="2"><%=caseBillImpl.getServicedes()==null ? "":caseBillImpl.getServicedes() %></textarea></dd>
			</dl>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2"><%=caseBillImpl.getRemark()==null ? "":caseBillImpl.getRemark() %></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<c:choose>
					<c:when test="${caseInfoImpl.casestatus eq 9 }">
					</c:when>
					<c:otherwise>
						<c:if test="${caseBillImpl.feestatuse eq null}">
							<li><div class="button"><a rel="bill" href="javascript:replace('2');" title="该案件下有赔款到账金额，请确认进行相应的处理" ><span>保存</span></a></div></li>
						</c:if>
						<c:if test="${caseBillImpl.feestatuse eq '0'}">
							<li><div class="button"><a rel="bill" href="javascript:replace('2');" title="该案件下有赔款到账金额，请确认进行相应的处理" ><span>修改</span></a></div></li>
							<li>
								<div class="button"><a rel="sub" href="javascript:sendBill('${billId}');"  alt="ddd"><span>提交财务</span></a></div>
							</li>
						</c:if>
						<c:if test="${caseBillImpl.feestatuse eq '1' }">
							<li>
								<div class="button"><a rel="bill" href="javascript:replace('1');" alt="queee" title="该案件下有赔款到账金额，请确认进行相应的处理" ><span>撤销账单</span></a></div>
							</li>
						</c:if>
						<li>
							<a class="button" href="javascript:createFeeNote('${billId}');"><span>生成账单</span></a>
						</li>
					</c:otherwise>
				</c:choose>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	</form>
</div>