<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
String caseid = request.getParameter("caseid");
%>


<div class="pageContent">
<form method="post" action="<%=baseUrl %>/guarantee/insert?rel=passure&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">  
           <input type="hidden" name="caseid" value="${caseid}" /> 
		<p>
			<label>担保编号：</label>
			<input type="text" name="assurenum" class="required"/>
		</p>
		<p>
			<label>反担保人：</label>
			<input type="text" name="rewarranter" />
		</p>
		<p>
			<label>被替换担保: </label>
			<input type="text" name="replacenum" />
		</p>
		<p>
			<label>出具时间：</label>
			<input type="text" name="issuedate" class="date"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>撤回时间：</label>
			<input type="text" name="backdate" class="date"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保金额：</label>
              <select name="currency" id="text" class="combox" selected="selected" >
					<c:forEach var="ct" items="${currency}">
			     		<option value="${fn:trim(ct['dictname']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
           <input type="text" name="assurefee" class="number" onchange="change(this)" />
		</p>
		<p>
			<label>USD金额：</label>
			<input type="text" id="usdfee" name="usdfee" class="number"/>
			</p>
		<p>
			<label>RMB金额：</label>
			<input type="text" id="rmbfee" name="rmbfee" class="number"/>
		</p>
		<p>
			<label>受益人：</label>
			<input type="text" name="assureder" />
		</p>
		<p>
			<label>反担保到否：</label>
			<input type="checkbox" name="receiveflag" value="1"/>
		</p>
		<p>
			<label>担保手续费：</label>
			<input type="text" name="servicefee" class="number"/>
		</p>
		<p>
			<label>是否上报集团：</label>
			<input type="checkbox" name="reportflag" value="1"/>
		</p>
		<p>
			<label>收取日期：</label>
			<input type="text" name="zbgatherdate" class="date"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>被担保人：</label>
			<input type="text" name="recognizorname" />
		</p>
		<p>
			<label>担保正本寄送日期：</label>
			<input type="text" name="zbsendtime" class="date"  /><a class="inputDateButton" href="javascript:;">选择</a>	
		</p>
		<p>
			<label>担保正本收件人：</label>
			<input type="text" name="receiver" />
		</p>
		<p>
			<label>BJ收到撤销担保日期： </label>
			<input type="text" name="securitydate" class="date"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保正本邮寄单号： </label>
			<input type="text" name="trackingnumber" />
		</p>
		<p>
			<label>反担保退回日期： </label>
			<input type="text" name="guaranteereturndate" class="date"  /><a class="inputDateButton" href="javascript:;">选择</a>	
		</p>
		<p>
			<label>撤销担保寄件人： </label>
			<input type="text" name="guaranteesender" />
		</p>
		<p>
			<label>反担保收件人： </label>
			<input type="text" name="canceltheguarantee" />
		</p>
		<p>
			<label>反担保正本邮寄单号：</label>
			<input type="text" name="guaranteeexpressnumber" />
		</p>
		    <dl class="nowrap">
				<dt>备注：</dt>
				<dd><textarea name="remark" cols="80" rows="2" ></textarea></dd>
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