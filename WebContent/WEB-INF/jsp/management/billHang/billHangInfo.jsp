<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.BillHangImpl" %>
<%
	BillHangImpl billHangImpl = (BillHangImpl)request.getAttribute("billHangImpl");
%>
<script language="javascript" src="styles/js/util.js"></script>
<script language="javascript" src="styles/js/htmis.util.js"></script>
<script type="text/javascript">

</script>

	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/billHang/insert?navTabId=billHangListNav&callbackType=forward" class="pageForm required-validate" fresh="true" onsubmit="return iframeCallback(this,navTabAjaxDone);">
		<input type="hidden" id="id" name="id" value="${billHangImpl.id }"/>
		<input type="hidden" id="doctype" name="doctype" value="bangdoc">
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/billHang/edit/{id}"/>
		<div  class="pageFormContent" layoutH="250" >
			<p>
				<label>汇款人：</label>
				<input name="remitter" type="text" class="required" size="30" value="${billHangImpl.remitter }" />
			</p>
			<%-- <p>
				<label>汇款客户：</label>
				<input type="text" name="remittancecustomers" class="required" size="30" value="${billHangImpl.remittancecustomers}"  />
			</p> --%>
			<p>
				<label>汇款币种：</label>
				<select name="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billHangImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p>
				<label>汇款日期：</label>
				<input type="text" name="remittancedate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= billHangImpl.getRemittancedate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<p>
				<label>汇款金额：</label>
				<input type="text" name="remitmoney" class="required" size="30" value="<fmt:formatNumber value="${billHangImpl.remitmoney}" pattern="##.##" minFractionDigits="2" />" />
			</p>

			<p>
				<label>收款银行：</label>
				<select name="bank" class="combox required">
					<c:forEach var="ct" items="${banktype}">
			     		<option value="${ct['dictid'] }" ${ct['dictid'] eq billHangImpl.bankinfo ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2">${billHangImpl.remark}</textarea></dd>
			</dl>
			
		</div>
			<div class="formBar">
				<ul>
				<c:if test="${flag }">
					<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
					<li><div class="button"><a target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{id},{doctype}" warn="请先保存信息" title="附件上传" ><span>上传/查看附件</span></a></div></li>
					
					<li>
						<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
					</li>
				</c:if>	
				
				</ul>
			</div>
	 </form>
	</div>
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