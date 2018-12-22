<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import="com.git.db.beans.ConsignorPayImpl" %>
<%
ConsignorPayImpl consignorPayImpl = (ConsignorPayImpl)request.getAttribute("consignorPayImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>

<script type="text/javascript">

function calculate(){
	payamount = formatFloat($("#payamount").val(), 2, $("#payamount").val());
	bankfee = formatFloat($("#bankfee").val(), 2, $("#bankfee").val());
	feeamount = payamount+bankfee;
	$("#feeamount").val(formatFloat(feeamount, 2, feeamount));
}


function getReport(){
<%-- 	navTab.openTab('thirdpayNav','<%=baseUrl %>/management/consignorPay/notice',{title:'第三方付款通知',fresh:false,data:{"PayId":<%= consignorPayImpl.getPayId()==null ? "": consignorPayImpl.getPayId() %> }});
 --%> 	open("<%=baseUrl %>/management/consignorPay/notice?PayId=<%=consignorPayImpl.getPayId()%>","第三方付款通知", 'width:800,height:600,menubar=yes, resizable=yes,scrollbars=yes');
 }
 
function uploadDoc(){
	alertMsg.confirm("请确认是否需要上传附件！", {
		okName:"是",cancelName:"否",
		okCall: function(){
			return false;
		},cancelCall: function(){
			$("#payForm").submit();
			$.navTab.closeCurrentTab();
		}
	});
}

</script>
	<div class="pageContent">
	 <form id="payForm" method="post" action="<%=baseUrl %>/management/consignorPay/payProcess?navTabId=consignorProcessList&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<input type="hidden" id="payId" name="payId" value="${consignorPayImpl.payId }"/>
		<input type="hidden" id="doctype" name="doctype" value="thirdPay">
		<div  class="pageFormContent" layoutH="256">
			<p>
				<label>收款人名称：</label>
				<input type="hidden" name="consignor.oid" value="consignor.oid" >
			    <input id="payeename" class="required textInput valid" type="text" size="30" lookupgroup="consignor" readonly="readonly" suggestFields="oid,nameen" name="consignor.nameen" value="<%=consignorPayImpl.getPayeename()==null ? "":consignorPayImpl.getPayeename() %>" ></input>
			    <%-- <a class="btnLook" href="<%=baseUrl %>/client/thirdparty/thirdsearch" lookupGroup="consignor" >收款人信息</a> --%>	
			</p>
			<p>
				<label>机构部门：</label>
				<input type="hidden" id="orgCode" name="orgLookup.orgCode" value="" />
				<input class="required textInput valid" size="30" readonly="readonly" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off"  value="<%=consignorPayImpl.getOrgnameb()==null ? "":consignorPayImpl.getOrgnameb() %>" /></input>
				<%-- <a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=C" lookupgroup="orgLookup" height="500">上级机构查找带回选中的值</a> --%>			
			</p>
			<p>
				<label>账号户名：</label>
				<input name="payeeaccountname" type="text" readonly="readonly" size="30" value="<%=consignorPayImpl.getPayeeaccountname()==null ? "":consignorPayImpl.getPayeeaccountname() %>" />
			</p>
			<p>
				<label>银行账号：</label>
				<input name="payeeaccountnum" type="text" readonly="readonly" size="30" value="<%=consignorPayImpl.getPayeeaccountnum()==null ? 0:consignorPayImpl.getPayeeaccountnum() %>" />
			</p>
			<p>
				<label>货币类型：</label>
				<input name="paycurrency" type="text" readonly="readonly" class="required" size="30" value="<%=consignorPayImpl.getPaycurrency()==null ? "":consignorPayImpl.getPaycurrency() %>" />
				<%-- <select name="paycurrency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select> --%>
			</p>
			<p>
				<label>支付时间：</label>
				<input name="paydate" type="text" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= consignorPayImpl.getPaydate() %>" pattern="yyyy-MM-dd" />" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>支付金额：</label>
				<input id="payamount" name="payamount" readonly="readonly"  onchange="calculate();" type="text" class="required" size="30" value="<%=consignorPayImpl.getPayamount()==null ? 0:consignorPayImpl.getPayamount() %>" />
			</p>
			<p>
				<label>银行手续费：</label>
				<input id="bankfee" name="bankfee"  onchange="calculate();" type="text" class="required" size="30" value="<%= consignorPayImpl.getBankfee()==null ? 0:consignorPayImpl.getBankfee() %>" />
			</p>
			<p>
				<label>合计：</label>
				<input id="feeamount" name="feeamount" readonly="readonly" type="text" class="required" size="30" value="<%= consignorPayImpl.getFeeamount()==null ? 0:consignorPayImpl.getFeeamount() %>" />
			</p>
			<p>
				<label>银行流水号：</label>
				<input name="banknum" type="text" size="30" value="<%= consignorPayImpl.getBanknum()==null ? "": consignorPayImpl.getBanknum() %>" />
			</p>
			<p>
				<label>绑定明细：</label>
				<input name="binddetail" readonly="readonly" type="text" size="30" value="<%= consignorPayImpl.getBinddetail()==null ? "": consignorPayImpl.getBinddetail() %>" />
			</p>
			<p>
				<label>汇率：</label>
				<input id="rmbrate" name="rmbrate" type="text" class="required" size="30" value="<%=consignorPayImpl.getRmbrate()==null ? 1:consignorPayImpl.getRmbrate() %>" />
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" alt="注:" > <%= consignorPayImpl.getRemark() == null ? "":consignorPayImpl.getRemark()%></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<c:if test="${consignorPayImpl.paystatus ne '2'}">
					<!-- <li><div class="buttonActive"><div class="buttonContent"><button type="button" >确认支付</button></div></div></li> -->
					<li><div class="button"><a rel="bill" href="javascript:uploadDoc();" ><span>确认支付</span></a></div></li>
					
				    <li><div class="button"><a target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{payId},{doctype}" warn="请先保存信息" title="附件上传" ><span>上传/查看附件</span></a></div></li>
				</c:if>
				<c:if test="${consignorPayImpl.paystatus eq '2'}">
					<li><div class="button"><div class="buttonContent"><button type="button" onclick="getReport();" >第三方付款通知</button></div></div></li>
				</c:if>				
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	 </form>
	 
	 <div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>支付明细</span></a></li>
						<li><a href="javascript:;"><span>附件信息</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div id="bind">
				 	<c:import url="../consignorPay/bindList.jsp"></c:import>
				</div>
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
	</div>