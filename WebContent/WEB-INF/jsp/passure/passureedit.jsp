<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<style type="text/css">
.pageFormContent label { float:left; width:150px; padding:0 5px; line-height:21px;}
.pageFormContent dt { float:left; width:150px; padding:0 5px; line-height:21px;}
</style>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/passure/update?navTabId=caseEditNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">

	<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="caseid" value="${passure.caseid}">
		<input type="hidden" name="passureid" value="${passure.passureid}">
		<p>
			<label>担保编号：</label>
			<input type="text" name="assurenum" ${passure.accdate == null ? "" : "readonly='readonly'" } class='number required'  value="${passure.assurenum}"/>
		</p>
		<p>
			<label>反担保人: </label>
			<input type="hidden" name="rewarranter.oid" value="${passure.rewarranterid}">
			<input type="hidden" name="rewarranter.names" value="${passure.rewarrantersn}">
			<input type="hidden" name="rewarranter.propertyname" value="${passure.rewarranttype}">
			<input class="required textInput valid" type="text" lookupgroup="rewarranter" value="${passure.rewarranter}" name="rewarranter.name" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/rewarranter/rewarrantersearch" lookupGroup="rewarranter">反担保人评级查询</a>	
		</p>
		<p>
			<label>被替换担保: </label>
			<input type="text" name="replacenum" value="${passure.replacenum}"/>
		</p>
		<p>
			<label>出具时间：</label>
			<input type="text" name="issuedate" class="date required" onblur="checkdate(this)" value="<fmt:formatDate value="${passure.issuedate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>撤回时间：</label>
			<input type="text" name="backdate" class="date" onblur="checkdate(this)" value="<fmt:formatDate value="${passure.backdate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保金额：</label>
			  <input type="text" name="currency" size="5" class="required" value="${passure.currency}" readonly="readonly" />
           <input type="text" name="assurefee" id="assurefee" value="${passure.assurefee}" readonly="readonly" class="number required "/>
		</p>
		<p>
			<label>USD金额：</label>
			<input type="text" id="usdfee" name="usdfee" value="${passure.usdfee}" class="number required" />
			</p>
		<p>
			<label>RMB金额：</label>
			<input type="text" id="rmbfee" name="rmbfee" value="${passure.rmbfee}" class="number required" />
		</p>
		<p>
			<label>受益人：</label>
			<input type="text" name="assureder" value="${passure.assureder}"/>
		</p>
		<p>
			<label>反担保到否：</label>
			<input type="checkbox" name="receiveflag" value="${passure.receiveflag}" ${passure.receiveflag == 1 ? "checked='checked'" : "" } />
		</p>
		<p>
			<label>担保手续费：</label>
			<input type="text" name="servicefee" id="servicefee" readonly="readonly" value="${passure.servicefee}" class="number required" />
		</p>
		<p>
			<label>是否上报集团：</label>
			<input type="checkbox" name="reportflag" value="${passure.reportflag}" ${passure.reportflag == 1 ? "checked='checked'" : "" } />
		</p>
		<p>
			<label>反担保收取日期：</label>
			<input type="text" name="zbgatherdate" class="date" onblur="checkdate(this)" value="<fmt:formatDate value="${passure.zbgatherdate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>被担保人：</label>
			<input type="text" name="recognizorname" value="${passure.recognizorname}"/>
		</p>
		<p>
			<label>担保正本寄送日期：</label>
			<input type="text" name="zbsendtime" class="date" onblur="checkdate(this)" value="<fmt:formatDate value="${passure.zbsendtime}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>	
		</p>
		<p>
			<label>担保正本收件人：</label>
			<input type="text" name="receiver" value="${passure.receiver}"/>
		</p>
		<p>
			<label>BJ收到撤销担保日期： </label>
			<input type="text" name="securitydate" class="date" onblur="checkdate(this)" value="<fmt:formatDate value="${passure.securitydate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保正本邮寄单号： </label>
			<input type="text" name="trackingnumber" value="${passure.trackingnumber}"/>
		</p>
		<p>
			<label>反担保退回日期： </label>
			<input type="text" name="guaranteereturndate" class="date" onblur="checkdate(this)" value="<fmt:formatDate value="${passure.guaranteereturndate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>	
		</p>
		<p>
			<label>撤销担保寄件人： </label>
			<input type="text" name="guaranteesender" value="${passure.guaranteesender}"/>
		</p>
		<p>
			<label>反担保收件人： </label>
			<input type="text" name="canceltheguarantee" value="${passure.canceltheguarantee}"/>
		</p>
		<p>
			<label>反担保正本邮寄单号：</label>
			<input type="text" name="guaranteeexpressnumber" value="${passure.guaranteeexpressnumber}"/>
		</p>
		    <dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" >${passure.remark}</textarea></dd>
			</dl>

	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
