<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.BillIncomeImpl" %>
<%
	BillIncomeImpl billIncomeImpl = (BillIncomeImpl)request.getSession().getAttribute("billIncomeImpl");
%>
		<input type="hidden"  name="inComeId" value="<%= billIncomeImpl.getIncomeId()==null ? "": billIncomeImpl.getIncomeId() %>"/>
		<div  class="pageFormContent">
			<p>
				<label>进账单编号：</label>
				<input name="statementnumber" type="text" readonly="readonly" size="30" value="<%= billIncomeImpl.getStatementnumber() == null ? "":billIncomeImpl.getStatementnumber() %>" />
			</p>
			<p>
				<label>案件编号：</label>
				<input type="text" name="feenumber" readonly="readonly" class="required" size="30" value="<%= billIncomeImpl.getFeenumber() ==null ? "": billIncomeImpl.getFeenumber() %>" />
			</p>
			<p>
				<label>付款人：</label>
				<input type="text" name="payername" readonly="readonly" class="required" size="30" value="<%= billIncomeImpl.getPayername() ==null ? "":billIncomeImpl.getPayername() %>" />
			</p>
			<p>
				<label>货币类型：</label>
				<input type="text" name="currency" readonly="readonly" class="required" size="30" value="<%= billIncomeImpl.getCurrency() ==null ? "":billIncomeImpl.getCurrency() %>" />
			</p>
			<p>
				<label>到账时间：</label>
				<input type="text" name="tradedate" readonly="readonly" class="date required" size="30" value="<fmt:formatDate value="<%= billIncomeImpl.getTradedate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>票面金额：</label>
				<input type="text" name="payamount" readonly="readonly" class="required" size="30" value="<fmt:formatNumber value="<%= billIncomeImpl.getPayamount() ==null ? 0.0:billIncomeImpl.getPayamount() %>" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>手续费：</label>
				<input type="text" name="lossamount" readonly="readonly" class="required" size="30" value="<fmt:formatNumber value="<%= billIncomeImpl.getLossamount() ==null ? 0.0:billIncomeImpl.getLossamount() %>" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>对账金额：</label>
				<input type="text" name="changeamount" readonly="readonly" class="required" size="30" value="<fmt:formatNumber value="<%= billIncomeImpl.getChangeamount() ==null ? 0.0:billIncomeImpl.getChangeamount() %>" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<p>
				<label>所属部门：</label>
				<input type="text" name="orgname" readonly="readonly" class="required" size="30" value="<%= billIncomeImpl.getOrgname() ==null ? "":billIncomeImpl.getOrgname()%>" />
			</p>
			<p>
				<label>对账余额：</label>
				<input type="text" name="differamount" readonly="readonly" class="required" size="30" value="<fmt:formatNumber value="<%= billIncomeImpl.getDifferamount() ==null ? 0.0:billIncomeImpl.getDifferamount() %>" pattern="##.##" minFractionDigits="2" />" />
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" readonly="readonly"><%=billIncomeImpl.getRemark()==null ? "":billIncomeImpl.getRemark() %></textarea></dd>
			</dl>
		
		</div>
