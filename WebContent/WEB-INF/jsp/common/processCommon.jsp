<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
     <form method="post" action="<%=baseUrl %>/applyInfos/insertApplyInfos?navTabId=transferNav"  class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
      	<div defH="180">
			<input type="hidden" name="applyid" id="applyid" value="${applyInfos.id}">
			<table>
           		<tr>
             		<td width="78" align="right">流程：</td>
             		<td width="126" align="left">
             		<!-- <input type="hidden" id="orgLookup.id" name="orgLookup.id" value="${orgLookup.id}"/> -->
	         		<input type="text" value="${applyInfos.processname }" size="30" id="orgLookup.name" name="orgLookup.name"  readOnly/>
             		<td> <!-- <c:if test="${flag=='apply'}"><a class="btnLook"  href="<%=baseUrl %>/processDef/list?mark=2" lookupGroup="orgLookup">流程查询并带回选中的值</a></c:if>	-->	
             		</td>
             		<td>&nbsp;</td>
           		</tr>
           		<tr>
           			<td colspan="4">&nbsp;</td>
           		</tr>
            	<tr>
              		<td align="right">编号：</td>
              		<td colspan="3" align="left"><input value="${applyInfos.sqnumber }" size="30" name="sqnumber"  readonly="readonly"  type="text" id="sqnumber" /></td>
           		</tr>
           		<tr>
           			<td colspan="4">&nbsp;</td>
           		</tr>
           		<tr>
             		<td align="right">标题：</td>
             		<td colspan="3" align="left"><input name="name" readOnly value="${applyInfos.name }" size="30" type="text"   id="name"  />
             		<input name="applytype" type="hidden" id="applytype" value="${applyInfos.applytype}"  />
             		<input name="parentid" type="hidden" id="parentid"  value="${applyInfos.parentid }"/></td>
           		</tr>
           		<tr>
           			<td colspan="4">&nbsp;</td>
           		</tr>
          		<tr>
             		<td align="right">内容：</td>
             		<td colspan="3" align="left"><textarea name="applydes" readOnly cols="40" rows="3" id="applydes">${applyInfos.applydes }</textarea>
              		<input name="id" type="hidden" id="id" value="${applyInfos.id }" />
              		<input name="processId" type="hidden" id=processId  value="${applyInfos.processdefid }"/></td>
           		</tr>
           		<tr>
           			<td colspan="4">&nbsp;</td>
           		</tr>
          		<tr>
          			<td colspan="4" >
          				<!-- <c:if test="${flag=='apply'}">
						<div class="buttonActive" id="btnDiv2"><div class="buttonContent"><button type="submit">保存呈批件</button></div></div>						
						</c:if>-->
						&nbsp;&nbsp;<div class="button" id="btnDiv1"><div class="buttonContent"><button type="button" onclick="generateApplyInfo('${applyInfos.id}','${caseClaim.recordtype }');">生成呈批件</button></div></div>
          			</td>
          		</tr>
         </table>			
		</div>
      </form>
<script type="text/javascript">

function generateApplyInfo(oid,type){
  	open("<%=baseUrl %>/auditApply/printApplyInfos?applyId="+oid+"&type="+type ,"呈批件", 'width:800,height:600,menubar=yes, resizable=yes,scrollbars=yes ');
}
/*
 function submitApply(applyid){

	if(!confirm("如果需要对呈批件信息进行修改，请先点击【保存呈批件】按钮，此操作不会保存已修改的内容。确认要提交呈批件进行审批么?")){
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
        		alert(data.msg);
   		  	   	document.getElementById("btnDiv1").style.display='none';
   		  	   	document.getElementById("btnDiv2").style.display='none';
           }
	  }
	     ,'json');
}
*/
  </script>
  <style type="text/css">
.STYLE1 {
	font-size: xx-large;
	font-family: "黑体";
}
.STYLE2 {
	font-size: 18px
}
.PageNext{page-break-after: always;
} 
.STYLE3 {
	font-size: 24px;
</style>
