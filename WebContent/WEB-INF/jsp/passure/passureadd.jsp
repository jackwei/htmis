 <%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<style type="text/css">
.pageFormContent label { float:left; width:150px; padding:0 5px; line-height:21px;}
.pageFormContent dt { float:left; width:150px; padding:0 5px; line-height:21px;}
</style>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/passure/insert?rel=passure&navTabId=caseEditNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone)">
	
	<div class="pageFormContent" layoutH="56">  
	        <input type="hidden" target="caseId" rel="${caseId}" />
		<p>
			<label>担保编号：</label>
			<input type="text" name="assurenum" class="number required"/>
		</p>
		<p>
			<label>反担保人: </label>
			<input type="hidden" name="rewarranter.oid">
			<input type="hidden" name="rewarranter.names">
			<input type="hidden" name="rewarranter.propertyid">
			<input type="hidden" name="rewarranter.propertyname">
			<input class="required textInput valid" type="text" lookupgroup="rewarranter" value="" readonly="readonly" name="rewarranter.name" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/rewarranter/rewarrantersearch" lookupGroup="rewarranter">反担保人评级查询</a>	
		</p>
		<p>
			<label>被替换担保: </label>
			<input type="text" name="replacenum" />
		</p>
		<p>
			<label>出具时间：</label>
			<input type="text" name="issuedate" class="date required" onblur="checkdate(this)" dateFmt="yyyy-MM-dd" /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>撤回时间：</label>
			<input type="text" name="backdate" class="date" onblur="checkdate(this)"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保金额：</label>
              <select name="currency" id="text" class="combox required" selected="selected" onchange="change();">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${fn:trim(ct['dictname']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
           <input type="text" id="assurefee1" name="assurefee" class="number required" onchange="change();" />
		</p>
		<p>
			<label>USD金额：</label>
			<input type="text" id="usdfee1" name="usdfee" class="number required" onchange="usdchange();" />
			</p>
		<p>
			<label>RMB金额：</label>
			<input type="text" id="rmbfee1" name="rmbfee" class="number required" onchange="rmbchange();" />
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
			<input type="text" name="servicefee" id="servicefee1" class="number required"  onchange="schange();" />
		</p>
		<p>
			<label>是否上报集团：</label>
			<input type="checkbox" name="reportflag" value="1"/>
		</p>
		<p>
			<label>反担保收取日期：</label>
			<input type="text" name="zbgatherdate" class="date" onblur="checkdate(this)"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>被担保人：</label>
			<input type="text" name="recognizorname" />
		</p>
		<p>
			<label>担保正本寄送日期：</label>
			<input type="text" name="zbsendtime" class="date" onblur="checkdate(this)" /><a class="inputDateButton" href="javascript:;">选择</a>	
		</p>
		<p>
			<label>担保正本收件人：</label>
			<input type="text" name="receiver" />
		</p>
		<p>
			<label>BJ收到撤销担保日期：</label>
			<input type="text" name="securitydate" class="date" onblur="checkdate(this)"  /><a class="inputDateButton" href="javascript:;">选择</a>
		</p>
		<p>
			<label>担保正本邮寄单号： </label>
			<input type="text" name="trackingnumber" />
		</p>
		<p>
			<label>反担保退回日期： </label>
			<input type="text" name="guaranteereturndate" class="date" onblur="checkdate(this)"  /><a class="inputDateButton" href="javascript:;">选择</a>	
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
<!-- 		<p>
			<label>汇率</label> <input id="accrate" name="accrate" type="text" value="1" onchange="change();" />
	    </p>	 -->

	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>

<script type="text/javascript"> 
function change(){
	  var va = formatFloat($('#assurefee1').val(), 2, $('#assurefee1').val());
	  var accrate = formatFloat($('#accrate').val(), 2, $('#accrate').val());
	  //$('#servicefee').val(va/100);
	  var servicefee = va/100;
	  if($("#text").val()=="USD"){
		  $("#usdfee1").val(formatFloat(va, 2, va));
		  $("#rmbfee1").val("");
		  $("#servicefee1").val(formatFloat(servicefee, 2, servicefee));
		  }
	  else if($("#text").val()=="RMB"){
		  $("#rmbfee1").val(formatFloat(va, 2, va));
		  $("#usdfee1").val("");
		  }
	  else{
		  $("#usdfee1").val("");
		  $("#rmbfee1").val("");
	  }
 	  $("#servicefee1").val(formatFloat(servicefee, 2, servicefee)); 
}

function rmbchange(){
	  var rmb = formatFloat($('#rmbfee1').val(), 2, $('#rmbfee1').val());
	  var servicefee = rmb/100;
	  if($("#text").val()=="RMB"){
		 //$('#assurefee').val(rmb);
		 //$('#servicefee').val(rmb/100);
		  $("#assurefee1").val(formatFloat(rmb, 2, rmb));
 		  $("#servicefee1").val(formatFloat(servicefee, 2, servicefee)); 
		  $("#usdfee1").val("");
	  }
}
	  
function usdchange(){
		  var usd = formatFloat($('#usdfee1').val(), 2, $('#usdfee1').val());
		  var servicefee = usd/100;
		  if($("#text").val()=="USD"){
			  //$('#assurefee').val(usd);
			  //$('#servicefee').val(usd/100);
			  $("#assurefee1").val(formatFloat(usd, 2, usd));
 		      $("#servicefee1").val(formatFloat(servicefee, 2, servicefee)); 
			  $("#rmbfee1").val("");
		  }
}
//设定为担保手续费1%后暂不用
/* function schange(){
	  var va = $('#assurefee1').val();
	  var s = $('#servicefee1').val();
	  if(parseInt(s)>parseInt(va)){
		  alert("担保手续费不能大于担保金额！");
		  $('#servicefee1').val("");
	  }
} */

</script>