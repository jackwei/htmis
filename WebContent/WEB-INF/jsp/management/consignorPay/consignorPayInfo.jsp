<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import="com.git.db.beans.ConsignorPayImpl" %>
<%
ConsignorPayImpl consignorPayImpl = (ConsignorPayImpl)request.getAttribute("consignorPayImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>

<script type="text/javascript">

function consignorPayCalculate(){
	payamount = formatFloat($("#payamount2").val(), 2, $("#payamount2").val());
	/* bankfee = formatFloat($("#bankfee").val(), 2, $("#bankfee").val());*/
	$("#feeamount2").val(payamount);
}

</script>
	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/consignorPay/insert?navTabId=consignorPayList&callbackType=forward" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<input type="hidden" id="payId" name="payId" value="${consignorPayImpl.payId }"/>
		<input type="hidden" id="doctype" name="doctype" value="thirdApply">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/consignorPay/edit/{payId}"/>
		
		<div  class="pageFormContent" layoutH="236">
			<p>
				<label>收款人名称：</label>
				<input type="hidden" name="consignor.oid" value="<%=consignorPayImpl.getPayeeid() == null ? "0":consignorPayImpl.getPayeeid() %>" >
				<%-- <input type="hidden" name="consignor.accountcode" value="<%=consignorPayImpl.getPayeeaccountname() == null ? "":consignorPayImpl.getPayeeaccountname() %>"" > --%>
				<%-- <input type="hidden" name="consignor.accountnum" value="<%=consignorPayImpl.getPayeeaccountnum() == null ? "0":consignorPayImpl.getPayeeaccountnum() %>"" > --%>
			    <input id="payeename" class="required textInput valid" type="text" size="23" lookupgroup="consignor" readonly="readonly" suggestFields="oid,nameen" name="consignor.namecn" value="<%=consignorPayImpl.getPayeename()==null ? "":consignorPayImpl.getPayeename() %>" ></input>
			    <a class="btnLook" href="<%=baseUrl %>/client/thirdparty/thirdsearch" lookupGroup="consignor" >收款人信息</a>	
			</p>
			<p>
				<label>机构部门：</label>
				<input type="hidden" id="orgCode" name="orgLookup.id" value="<%=consignorPayImpl.getOrgidb() == null ? "":consignorPayImpl.getOrgidb() %>" />
				<input class="required textInput valid" size="23" readonly="readonly" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off"  value="<%=consignorPayImpl.getOrgnameb()==null ? "":consignorPayImpl.getOrgnameb() %>" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=D" lookupgroup="orgLookup" height="500">上级机构</a>			
			</p>
			<p>
				<label>开户行：</label>
				<input id="payeeaccountname" name="consignor.accountname" type="text" size="30" value="<%=consignorPayImpl.getPayeeaccountname()==null ? "":consignorPayImpl.getPayeeaccountname() %>" />
			</p>
			<p>
				<label>银行账号：</label>
				<input id="payeeaccountnum" name="consignor.accountnum" type="text" size="30" value="<%=consignorPayImpl.getPayeeaccountnum()==null ? "":consignorPayImpl.getPayeeaccountnum() %>" />
			
			</p>
			<p>
				<label>货币类型：</label>
				<select name="paycurrency" class="combox required readonly">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq consignorPayImpl.paycurrency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>支付时间：</label>
				<input name="paydate" type="text" class="required date" size="30" value="<fmt:formatDate value="<%= consignorPayImpl.getPaydate() %>" pattern="yyyy-MM-dd" />" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>支付金额：</label>
				<input id="payamount2" name="payamount"  onchange="consignorPayCalculate();" type="text" size="30" value="<%=consignorPayImpl.getPayamount()==null ? 0:consignorPayImpl.getPayamount() %>" />
			</p>
			<%-- <p>
				<label>银行费用：</label>
				<input id="bankfee" name="bankfee"  onchange="calculate();" readonly="readonly" type="text"  size="30" value="<%= consignorPayImpl.getBankfee()==null ? 0.0:consignorPayImpl.getBankfee() %>" />
			</p> --%>
			<p>
				<label>合计：</label>
				<input id="feeamount2" name="feeamount" type="text" readonly="readonly" size="30" value="<%= consignorPayImpl.getFeeamount()==null ? 0:consignorPayImpl.getFeeamount() %>" />
			</p>
			<%-- <p>
				<label>银行流水号：</label>
				<input name="banknum" readonly="readonly"  type="text" size="30" value="<%= consignorPayImpl.getBanknum()==null ? "": consignorPayImpl.getBanknum() %>" />
			</p> 
			<p>
				<label>绑定明细：</label>
				<input name="binddetail" readonly="readonly" type="text" size="30" value="<%= consignorPayImpl.getBinddetail()==null ? "": consignorPayImpl.getBinddetail() %>" />
			</p>--%>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" alt="注:" > <%= consignorPayImpl.getRemark() == null ? "":consignorPayImpl.getRemark()%></textarea></dd>
			</dl>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><a target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{payId},{doctype}" warn="请先保存信息" title="附件上传" ><span>上传/查看附件</span></a></div></li>
				
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