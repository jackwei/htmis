<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/guarantee/update?rel=passure&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);" >
	<div class="pageFormContent" layoutH="56">
		<input type="hidden" name="passureid" value="${passure.passureid}">
		<input type="hidden" name="caseid" value="${passure.caseid}">
		<p>
			<label>担保编号：</label>
			<input type="text" name="assurenum" readonly="readonly" value="${passure.assurenum}"/>
		</p>
		<p>
			<label>反担保人：</label>
			<input type="text" name="rewarranter" value="${passure.rewarranter}"/>
		</p>
		<p>
			<label>被替换担保: </label>
			<input type="text" name="replacenum" value="${passure.replacenum}"/>
		</p>
		<p>
			<label>出具时间：</label>
			<input type="text" name="issuedate" class="date" value="<fmt:formatDate value="${passure.issuedate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>撤回时间：</label>
			<input type="text" name="backdate" class="date" value="<fmt:formatDate value="${passure.backdate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保金额：</label>
              <select name="currency" id="text" class="combox" value="${passure.currency}">

					<c:forEach var="ct" items="${currency}">
			     		<option value="${fn:trim(ct['dictid']) }"  ${ct['dictid'] eq passure.currency ? 'selected="selected"' : ''}>${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
           <input type="text" name="assurefee" value="${passure.assurefee}" onchange="change(this)" class="number"/>
		</p>
		<p>
			<label>USD金额：</label>
			<input type="text" id="usdfee" name="usdfee" value="${passure.usdfee}" class="number"/>
			</p>
		<p>
			<label>RMB金额：</label>
			<input type="text" id="rmbfee" name="rmbfee" value="${passure.rmbfee}" class="number"/>
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
			<input type="text" name="servicefee" value="${passure.servicefee}" class="number"/>
		</p>
		<p>
			<label>是否上报集团：</label>
			<input type="checkbox" name="reportflag" value="${passure.reportflag}" ${passure.reportflag == 1 ? "checked='checked'" : "" } />
		</p>
		<p>
			<label>收取日期：</label>
			<input type="text" name="zbgatherdate" class="date" value="<fmt:formatDate value="${passure.zbgatherdate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>被担保人：</label>
			<input type="text" name="recognizorname" value="${passure.recognizorname}"/>
		</p>
		<p>
			<label>担保正本寄送日期：</label>
			<input type="text" name="zbsendtime" class="date" value="<fmt:formatDate value="${passure.zbsendtime}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>	
		</p>
		<p>
			<label>担保正本收件人：</label>
			<input type="text" name="receiver" value="${passure.receiver}"/>
		</p>
		<p>
			<label>BJ收到撤销担保日期： </label>
			<input type="text" name="securitydate" class="date" value="<fmt:formatDate value="${passure.securitydate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保正本邮寄单号： </label>
			<input type="text" name="trackingnumber" value="${passure.trackingnumber}"/>
		</p>
		<p>
			<label>反担保退回日期： </label>
			<input type="text" name="guaranteereturndate" class="date" value="<fmt:formatDate value="${passure.guaranteereturndate}" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>	
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
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">Save</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">Close</button></div></div></li>
		</ul>
	</div>
</form>

</div>

<script type="text/javascript"> 
  function change(va){
	  if($("#text").val()=="USD"){
		  $("#usdfee").val(va.value);
		  }
	  else if($("#text").val()=="RMB"){
		  $("#rmbfee").val(va.value);
		  }
	  else{
		  alert("输入的不是数字！请重新输入！");
	  }
  }
</script>
