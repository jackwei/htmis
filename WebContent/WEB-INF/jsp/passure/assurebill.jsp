<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl"%>
<%@page import=" com.git.db.beans.CaseBillImpl"%>
<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl) request.getAttribute("caseInfoImpl");
	CaseBillImpl caseBillImpl = (CaseBillImpl) request.getAttribute("caseBillImpl");
%>

<script type="text/javascript" >

function cfNote(billId){
	open("<%=baseUrl %>/management/caseBill/createFeeNote?billId="+billId,"账单", 'width:800,height:600,menubar=yes, resizable=yes,scrollbars=yes');
}

function asend(){
	var forwardUrl = "<%=baseUrl %>/passure/assurebilledit/{billId}";
	var url = "<%=baseUrl%>/passure/assurebillsend?navTabId=assurebilleditNav&callbackType=forward";
	$("#assureform").attr("action", url);
	$('#assureform').submit();
}

function cancelbill(){
	var forwardUrl = "<%=baseUrl %>/passure/assurebilledit/{billId}";
	var url = "<%=baseUrl%>/passure/cancelbill?navTabId=assurebilleditNav&callbackType=forward";
	$("#assureform").attr("action", url);
	$('#assureform').submit();
}

function asschange(){
	var fee = formatFloat($('#assurefee').val(), 2, $('#assurefee').val()) ;
	if(""==fee || 0==fee){
		alert("请输入正确的担保手续费！");
		$("#feeamount").val(0.00);
	}else{
    	$("#feeamount").val(formatFloat(fee, 2, fee));
	}
}

</script>


		<div class="panelContent" style="height: 250px;">
		
			<form method="post" id="assureform" action="<%=baseUrl%>/passure/billsave?navTabId=assurebilleditNav&callbackType=forward" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);"> 
				<div class="pageFormContent">
					<input type="hidden" id="caseId" name="caseId" value="${caseInfoImpl.getCaseId()}">				
			        <input type="hidden" id="billId" name="billId" value="<%=caseBillImpl.getBillId() == null ? "" : caseBillImpl.getBillId()%>" />
                    <input type="hidden" name="forwardUrl" value="<%=baseUrl %>/passure/assurebilledit/{billId}"/>
					<input type="hidden" name="feestatuse" value="<%=caseBillImpl.getFeestatuse() == null ? "" : caseBillImpl.getFeestatuse() %>">
					<input type="hidden" name="feetype" value="<%=caseBillImpl.getFeetype() == null ? "" : caseBillImpl.getFeetype() %>">
							<div style="display: none">
						<dd>
							<textarea name="servicedes" cols="80" rows="2"><%=caseBillImpl.getServicedes() == null ? "" : caseBillImpl.getServicedes()%></textarea>
						</dd>
					</div>
					<p>
						<label>账单编号：</label> <input name="feenumber" type="text" size="30" value="<%=caseBillImpl.getFeenumber() == null ? "" : caseBillImpl.getFeenumber()%>" readonly="readonly" />
					</p>
					<p>
						<label>To：</label> <input name="payer" type="text" size="30" value="<%=caseBillImpl.getPayer() == null ? "Owners/Charterers of m/v blue" : caseBillImpl.getPayer()%>" />
					</p>
					<p>
						<label>C/o：</label> <input name="coname" type="text" size="30" value="<%=caseBillImpl.getConame() == null ? "Amercian Steamship Owners Mutual Protection & Indemnity Association, Inc." : caseBillImpl.getConame()%>" />
					</p>
					<p>
						<label>Add：</label> <input name="address" type="text" size="30" value="<%=caseBillImpl.getAddress() == null ? "One Battery Park Plaza, 31st Floor New York, New York 10004 U.S.A" : caseBillImpl.getAddress()%>" />
					</p>
                    <%-- <p>
						<label>担保币种：</label> <select name="currency" class="combox required">
							<c:forEach var="ct" items="${currency}">
								<option value="${ct['dictid'] }"  ${ct['dictid'] eq "<%=caseBillImpl.getCurrency()%>" ? 'selected="selected"' : ''}>${fn:trim(ct['dictname'])}</option>
							</c:forEach>
						</select>
					</p> --%>
					<p>
						<label>担保手续费：</label> <input id="assurefee" name="assurefee" onchange="asschange();" alt="0.00" type="text" size="30" value="<%=caseBillImpl.getAssurefee() == null ? "" : String.format( "%.2f ", caseBillImpl.getAssurefee()) %>" />
					</p>
					<p>
					    <label>发账币种：</label> <input id="pcurrency" name="currency" value="USD" type="text" size="30" readonly="readonly">
					</p>

					<p>
						<label>金额合计：</label> <input id="feeamount" name="feeamount" type="text"  readonly="readonly" size="30" value="<%=caseBillImpl.getFeeamount() == null ? 0.00 : String.format( "%.2f ", caseBillImpl.getFeeamount())%>" />
					</p>

					<dl class="nowrap">
						<dt>备注：</dt>
						<dd>
							<textarea name="remark" cols="80" rows="2"><%=caseBillImpl.getRemark() == null ? "" : caseBillImpl.getRemark()%></textarea>
						</dd>
					</dl>
					
					<p>
						<label>汇率</label> <input name="accrate" type="text" size="30" value="1"/>
					</p>
				</div>
				
				<c:choose>  
  
                 <c:when test="${flag eq 'view'}">  
  <div class="formBar">
					<ul>	
						 <li>
							<a class="buttonActive" href="javascript:cfNote('${billId}');"><span>下载账单</span></a>
							</li> 
	
						<li>
							<div class="buttonActive">
									<div class="buttonContent"><button type="button" class="close">关闭</button></div>
							</div>
						</li>
					</ul>
				</div>
  
                 </c:when>  
                 <c:otherwise>  
  
  <div class="formBar">
					<ul>
					<c:if test="${caseBillImpl.feestatuse eq '0'}">
						<li><div class="buttonActive">
								<div class="buttonContent">
									<button type="submit">修改</button>
								</div>
							</div>
						</li>
						<li>
							<a class="button" href="javascript:cfNote('${billId}');"><span>下载账单</span></a>
						</li> 
						<li>
							<a class="buttonActive" rel="assurebilleditNav" href="javascript:asend();" title="你确定要提交财务吗?" warn="请保存账单"><span>提交财务</span></a>
						</li>
					</c:if>
					<c:if test="${caseBillImpl.feestatuse eq '1' }">
						<li>
							<a class="buttonActive" rel="assurebilleditNav" href="javascript:cancelbill();" ><span>撤销账单</span></a>
						</li>	
						 <li>
							<a class="button" href="javascript:cfNote('${billId}');"><span>下载账单</span></a>
							</li> 
					</c:if>		
						<li>
							<div class="buttonActive">
									<a class="edit" target="navTab" rel="caseEditNav" href="<%=baseUrl %>/passure/edit/{caseId}" title="添加担保及担保账单" ><span>返回</span></a>
							</div></li>
					</ul>
				</div>
                </c:otherwise>  
  
                </c:choose>  
			
			</form>
		</div>


