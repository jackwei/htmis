<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseClaimImpl" %>
<%
CaseClaimImpl caseClaimImpl = (CaseClaimImpl)request.getAttribute("caseClaimImpl");
%>

<script language="javascript" src="styles/js/util.js"></script>
<script type="text/javascript">

function calculate(){
	
	var realamount = $("#realamount").val();
	var usdrate = $("#usdrate").val();
	var usdamount = $("#usdamount").val();
	
	$("#realamount").val(formatFloat(realamount, 2, realamount));
	$("#usdrate").val(formatFloat(usdrate, 7, usdrate));
	usdamount =realamount/usdrate;
	$("#usdamount").val(formatFloat(usdamount, 2, usdamount));
}

function msgInfo(){
	alertMsg.info("划付币种是否为USD/RMB");
}

function uploadDoc(){
	alertMsg.confirm("请确认是否需要上传附件！", {
		okName:"是",cancelName:"否",
		okCall: function(){
			return false;
		},cancelCall: function(){
			$("#advanceForm").submit();
			$.navTab.closeCurrentTab();
		}
	});
}
</script>
<div class="pageContent">
 		<form id="advanceForm" method="post" action="<%=baseUrl %>/management/claimHandle/insert?navTabId=claimPayListNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
				<input type="hidden" id="claimId" name="claimId" value="${caseClaimImpl.claimId }"/>
				<input type="hidden" id="caseId" name="caseId" value="<%= caseClaimImpl.getCaseId()==null ? "":caseClaimImpl.getCaseId() %>"/>
				<input type="hidden" id="doctype" name="doctype" value="claimPaydoc">
				
				<div class="pageFormContent" layoutH="236">
					<p>
						<label>案号 ：</label>
						<input name="casenumber" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getCasenumber() == null ? "":caseClaimImpl.getCasenumber() %>" />
					</p>
					<p>
						<label>船名：</label>
						<input name="shipname" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getShipname() == null ? "":caseClaimImpl.getShipname() %>" />
					</p>
					<p>
						<label>收款人：</label>
						<input name="clientname" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getClientname() == null ? "":caseClaimImpl.getClientname() %>" />
					</p>
					
					<p>
						<label>开户行：</label>
						<input name="applybank" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getApplybank() == null ? "":caseClaimImpl.getApplybank() %>" />
					</p>
					
					<p>
						<label>帐号：</label>
						<input name="applybanknum" readonly="readonly" type="text" size="30" value="<%= caseClaimImpl.getApplybanknum() == null ? "":caseClaimImpl.getApplybanknum() %>" />
					</p>

					<p>
						<label>划付类型：</label>
						<c:forEach var="ct" items="${recordtype}">
							<c:if test="${ct['dictid'] eq caseClaimImpl.recordtype}">
								<input name="recordtype" readonly="readonly" type="text" size="30" value="${fn:trim(ct['dictname'])}" />
							</c:if>
			    		</c:forEach>
					</p>
					<p>
						<label>申请币种：</label>
						<input name="recordcurrency" readonly="readonly"  type="text" size="30" value="<%= caseClaimImpl.getRecordcurrency() == null ? "":caseClaimImpl.getRecordcurrency() %>" />
					</p>
					<p>
						<label>申请金额：</label>
						<input type="text" readonly="readonly" name="recordmount" id="recordmount" class="required" size="30" value="<%= caseClaimImpl.getRecordmount()==null ? 0.0:caseClaimImpl.getRecordmount() %>" />
					</p>
					<p>
						<label>划付币种：</label>
						<select name="currency" id="currency" class="combox required" onchange="msgInfo();">
							<option>请选择</option>
							<c:forEach var="ct" items="${currency}">
								<option value="${ct['dictid'] }" ${ct['dictid'] eq caseClaimImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
				    		</c:forEach>
			    		</select>
					</p>
					<p>
						<label>划付金额：</label>
						<input type="text" name="realamount" id="realamount"  class="required" size="30" value="<%= caseClaimImpl.getRealamount()==null ? 0.0:caseClaimImpl.getRealamount() %>" />
					</p>
					
					<p>
						<label>划付汇率：</label>
						<input id="usdrate" type="text" name="usdrate" class="required" id="usdrate" size="30" value="${caseClaimImpl.usdrate }" />
					</p>
					
					<p>
						<label>划付时间：</label>
						<input type="text" name="treatdate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= caseClaimImpl.getTreatdate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
					</p>
					
					<dl class="nowrap">
						<dt>备注：</dt>
						<dd><textarea name="remark" cols="80" rows="2" ><%= caseClaimImpl.getRemark() == null ? "":caseClaimImpl.getRemark()%></textarea></dd>
					</dl>
				</div>
				<div class="formBar">
						<ul>
							<li><div class="button"><a rel="bill" href="javascript:uploadDoc();" ><span>划款支付</span></a></div></li>
							<!-- <li><div class="buttonActive"><div class="buttonContent"><button type="submit">划款支付</button></div></div></li> -->
							<li><div class="button"><a target="dialog" mask="true" rel="uploadNav" width="600" height="300"  href="<%=baseUrl %>/applyInfos/toUploadFile/{claimId},{doctype}" warn="请先保存信息" title="附件上传" ><span>上传/查看附件</span></a></div></li>
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