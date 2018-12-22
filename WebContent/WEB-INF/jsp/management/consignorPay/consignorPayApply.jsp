<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import="com.git.db.beans.ConsignorPayImpl" %>
<%
ConsignorPayImpl consignorPayImpl = (ConsignorPayImpl)request.getSession().getAttribute("consignorPayImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>

<script type="text/javascript">
	

</script>

	<div class="pageContent">
		<div class="panel collapse">
			<h1>划付信息</h1>
			<div class="pageFormContent">
			<p>
				<label>收款人名称：</label>
				<input type="hidden" name="consignor.oid" value="consignor.oid" >
			    <input id="payeename" class="required textInput valid" type="text" size="30" lookupgroup="consignor" readonly="readonly" suggestFields="oid,nameen" name="consignor.nameen" value="<%=consignorPayImpl.getPayeename()==null ? "":consignorPayImpl.getPayeename() %>" ></input>
<%-- 			    <a class="btnLook" href="<%=baseUrl %>/client/thirdparty/thirdsearch" lookupGroup="consignor" >收款人信息</a>	
 --%>			</p>
			<p>
				<label>机构部门：</label>
				<input type="hidden" id="orgCode" name="orgLookup.orgCode" value="" />
				<input class="required textInput valid" size="30" readonly="readonly" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off"  value="<%=consignorPayImpl.getOrgnameb()==null ? "":consignorPayImpl.getOrgnameb() %>" /></input>
<%-- 				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=C" lookupgroup="orgLookup" height="500">上级机构查找带回选中的值</a>			
 --%>			</p>
			<p>
				<label>账号户名：</label>
				<input name="payeeaccountname" type="text" readonly="readonly" class="required" size="30" value="<%=consignorPayImpl.getPayeeaccountname()==null ? "":consignorPayImpl.getPayeeaccountname() %>" />
			</p>
			<p>
				<label>银行账号：</label>
				<input name="payeeaccountnum" type="text" readonly="readonly" class="required" size="30" value="<%=consignorPayImpl.getPayeeaccountnum()==null ? 0:consignorPayImpl.getPayeeaccountnum() %>" />
			</p>
			<p>
				<label>货币类型：</label>
				<input name="paycurrency" type="text" readonly="readonly" class="required" size="30" value="<%=consignorPayImpl.getPaycurrency()==null ? "":consignorPayImpl.getPaycurrency() %>" />
				
				<%-- <select name="paycurrency" class="combox required" disabled="disabled">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq consignorPayImpl.paycurrency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select> --%>
			</p>
<%-- 			<p>
				<label>支付时间：</label>
				<input name="paydate" type="text" class="date required" size="30" value="<fmt:formatDate value="<%= consignorPayImpl.getPaydate() %>" pattern="yyyy-MM-dd" />" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p> --%>
			<p>
				<label>支付金额：</label>
				<input id="payamount" name="payamount" type="text" readonly="readonly" class="required" size="30" value="<%=consignorPayImpl.getPayamount()==null ? 0:consignorPayImpl.getPayamount() %>" />
			</p>
<%-- 			<p>
				<label>银行费用：</label>
				<input id="bankfee" name="bankfee"  type="text" class="required" size="30" value="<%= consignorPayImpl.getBankfee()==null ? 0.0:consignorPayImpl.getBankfee() %>" />
			</p> --%>
<%-- 			<p>
				<label>合计：</label>
				<input id="feeamount" name="feeamount" type="text" class="required" size="30" value="<%= consignorPayImpl.getFeeamount()==null ? 0:consignorPayImpl.getFeeamount() %>" />
			</p> --%>
<%-- 			<p>
				<label>银行流水号：</label>
				<input name="banknum" type="text" size="30" value="<%= consignorPayImpl.getBanknum()==null ? "": consignorPayImpl.getBanknum() %>" />
			</p> --%>
			<p>
				<label>绑定明细：</label>
				<input name="binddetail" readonly="readonly" type="text" size="30" value="<%= consignorPayImpl.getBinddetail()==null ? "": consignorPayImpl.getBinddetail() %>" />
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" alt="注:" > <%= consignorPayImpl.getRemark() == null ? "":consignorPayImpl.getRemark()%></textarea></dd>
			</dl>
		</div>
		</div>
		
		<div class="tabs">
			<div class="tabsHeader">
				<div class="tabsHeaderContent">
					<ul>
						<li><a href="javascript:;"><span>支付明细</span></a></li>
						<li><a href="javascript:;"><span>未支付列表</span></a></li>
					</ul>
				</div>
			</div>
			<div class="tabsContent">
				<div id="bind">
				 	<c:import url="../consignorPay/bindList.jsp"></c:import>
				</div>
				
				<div id="unbind">
					<c:import url="../consignorPay/unBindList.jsp"></c:import>
				</div>
			</div>
		</div>
	</div>
