<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent"  id="jbsxBox">
<form method="post" action="<%=baseUrl %>/applyInfos/insertApplyInfos?navTabId=caseEditNav&callbackType=forward" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
	<input type="hidden" name="parentid" value="${caseBillDetail.detailId }">
	<input type="hidden" name="parentname" value="${caseBillDetail.consignorname }">
	<input type="hidden" name="processId" value="${applyInfos.processdefid }">
	<input type="hidden" name="applyid" id="applyid">
	<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=${backNav}&detail_id=${caseBillDetail.detailId}&flag=apply"/>
	<div class="pageContent sortDrag layoutBox" selector="h1">
	<div class="panel" defH="180">
	 <h1>第三方状态信息</h1>
	 <div class="pageFormContent">
	 <p>
			<label>单位名称： </label>
			<label><input type="text" value="${caseBillDetail.consignorname }" size="50" readonly="readonly"></label>
		</p>
		<p></p>
		<p>
			<label>报告时间： </label>
		    <label><input type="text" readonly="readonly" value="<fmt:formatDate value="${caseBillDetail.reportdate }" pattern="yyyy-MM-dd"/>"></label>
		</p>
		<p>
			<label>对方案号： </label>
			<label><input type="text" readonly="readonly" value="${caseBillDetail.casenumber }"></label>
		</p>
		<p>
			<label>货币类型： </label>
			<label><input type="text"  id="currency"  name="currency" readonly="readonly" value="${caseBillDetail.currency}"></label>
		</p> 
		
		<p>
		   <label>委请时间：</label>
		   <label><input type="text" readonly="readonly" value="<fmt:formatDate value="${caseBillDetail.applydate }" pattern="yyyy-MM-dd"/>"></label>
		</p>
		<p>
		   <label>费用：</label>
		   <label><input type="text" readonly="readonly" value="${caseBillDetail.expendses }"></label>
		</p>
		<p>
		   <label>第三方服务费：</label>
		   <label><input type="text" readonly="readonly"  value="${caseBillDetail.servicefee }"></label>
		</p>
		<p>
		   <label>折算汇率：</label>
		   <label><input type="text"  readonly="readonly" value="${caseBillDetail.changerate }"></label>
		</p>
		<p>
		   <label>第三方垫付费用：</label>
		   <label><input type="text" readonly="readonly" value="${caseBillDetail.replacefee }"></label>
		</p>
		<p>
		   <label>记账金额：</label>
		   <label><input type="text" readonly="readonly"  value="${caseBillDetail.accamount }"></label>
		</p>
		<p>
		   <label>合计：</label>
		   <label><input type="text" id="amounta" name="amounta" readonly="readonly" value="${caseBillDetail.feeamount }"></label>
		</p>
		<p>
		   <label>第三方附件：</label>
		   <label>
		   	<c:forEach var="item" items="${listDocs}" varStatus="s">
			 	<a class='icon' href='<%=baseUrl %>/FileDown/download?oid=${item.id}'>${item.filename }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		   	</c:forEach>
		   </label>
		</p>
	</div>
	</div>
	<div  class="panel collapse" defH="220">
	<h1>第三方呈批件</h1>
	<div class="pageFormContent">
	  <p><label>呈批流呈：</label>
	  <input name="applytype" type="hidden" id="applytype" value="thirdparty"  />
	  <input name="flag" type="hidden" id="flag" value="apply"  />
	  <input type="hidden" id="orgLookup.id" name="orgLookup.id" value="${orgLookup.id}"/>
	  <input type="text"  id="orgLookup.name" name="orgLookup.name" value="${applyInfos.processname }" class="required" readOnly/>
	  <a class="btnLook" href="<%=baseUrl %>//processDef/list?mark=2" lookupGroup="orgLookup">流程查询</a>		
	  </p> 
	  <p>
	    <label>编号：</label>
	    <input type="text" name="sqnumber" id="sqnumber" readonly="readonly"/>
	  </p>
	  <p>
	   <label>呈批件标题：</label>
	   <input name="name" type="text" id="name" size="30" value="(${caseBillDetail.feenumber})${shipname}"/>
	   <input type="hidden" name="applyname" value="(${caseBillDetail.feenumber})${shipname}">
	  </p>
	  <dl class="nowrap">
			<dt>呈批内容：</dt>
			<dd><textarea name="applydes" cols="80" rows="3" >${caseBillDetail.consignorname }(${caseBillDetail.feeamount })</textarea></dd>
	  </dl>
	  
	  <!--  <p>
	   <label>附件：</label>
	   <input type="file" name="image" class="required" size="25" />
	  </p>-->
	  <p></p>
	  <p></p>
	  <dl>
	  	<div class="buttonActive" id="btnDiv2"><div class="buttonContent"><button type="submit">保存呈批件</button></div></div>
	  	<div id= "btnDiv" style="display:none;">
		  	<a class='button' mask='true' target='dialog' width='600' height='480'  href='<%=baseUrl %>/applyInfos/toUploadFile/{applyid},{applytype}'  warn="保存呈批件后方上传附件"><span>上传附件</span></a>
			<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/searchApplyInfos/{applyid},{flag}' warn="保存呈批件后方可查看信息"><span>呈批件预览</span></a>			
		</div>
	  </dl>
	  <ul>
	  	<div id= "btnDiv1" style="display:none;">		  	
			<li><a class='button' type="button" onclick='submitApply($("#applyid").val())' ><span>提交审批</span></a></li>
		</div>
		<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
	  </ul>	  	  
	  </div>
	  </div>
	</div>
	<script type="text/javascript">
	function ApplyAjaxDone(data){
		if(data.id=="0"){
			$("#applyid").val("");
		}else{
		  	$("#applyid").val(data.id);
		  	document.getElementById("btnDiv").style.display='';
		  	document.getElementById("btnDiv1").style.display='';
	    }
		$("#sqnumber").val(data.result);
		
		alertMsg.correct(data.message);
	}
	function submitApply(applyid){
		var processName=$(':input[id="orgLookup.name"]').val();
		if(applyid == null || applyid =='' || applyid == '0'){
			alert("必须先保存呈批件信息！");
			return;
		}
		if(!confirm("确认要提交呈批件么?")){
			return;
		}
		
		$.post('<%=baseUrl %>/applyInfos/submitApplyInfos',
				{'applyId':applyid},
	       function(data){
				   if(data.result=="false"){
					   alertMsg.error(data.msg);
		           }
		           else
		           {
		        	   alertMsg.correct(data.msg);
		        	   	document.getElementById("btnDiv").style.display='none';
		   		  	   	document.getElementById("btnDiv1").style.display='none';
		   		  	   	document.getElementById("btnDiv2").style.display='none';
		           }
		  		}
		     ,'json');
	}
	</script>
</form>
</div>
