<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="panel" defH="420">
<div style="position:relative; text-align:center;">
<div style="position:relative; border-bottom:thin; border-bottom-style:solid;">
   	  <div class="STYLE1" style="position:relative;width:700px; height:40px;">呈&nbsp;&nbsp;&nbsp;批&nbsp;&nbsp;&nbsp;件</div>
    <!--  <div style="position:relative;width:700px; text-align:left;margin-top:20px; height:40px;"><img width="232" src="/images/applyinfologo.gif" height="30" /></div>-->
  </div>
  <div style="position:absolute; left:0px; width:400px; height: 900px;">
    <div class="STYLE3" style="position:relative; width:300px; margin-top:40px">支付海事业务检验费申请</div>
    <div class="STYLE2" id="cpjinfo" style="position:relative; text-align:left; width:390px; margin-right:10px; margin-top:20px">
       <p>&nbsp;&nbsp;&nbsp;&nbsp;公司领导：</p>
       <p>&nbsp;&nbsp;&nbsp;&nbsp;关于：我司账单号
         <input name="casenumber" value="${casenumber }" type="text" class="inputauto" id="casenumber" readonly="readonly" />
       </p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;船名
        <input name="shipname"  value="${shipname }" type="text" class="inputauto" id="shipname" readonly="readonly" />
      </p>
      <br>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;检验费划付事宜         </p>
      <br>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;受
         <input name="consignorname"  value="${consignorname }" type="text" class="inputauto" id="consignorname" readonly="readonly" />
         委托，我司安排
         <br>
         &nbsp;&nbsp;&nbsp;&nbsp;<input name="inspection"  value="${inspection }" type="text" class="inputauto" id="inspection" readonly="readonly" />
         进行题议事宜的检验，检验费共 
         <br> &nbsp;&nbsp;&nbsp;&nbsp;<input name="currency"  value="${applyInfos.currency }" readonly="readonly"  type="text" class="shortInput_v inputauto" id="currency" />
         <input name="amounta" value="${applyInfos.amounta }" type="text" class="shortInput_n" id="amounta" readonly="readonly" />
         。<br />
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;现我司已收到委托人就题述事宜的付款，故申请将检验人费用划付至其指定账户。        </p>
      <br>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;妥否，请批示。</p>
      <br>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请部门：
         <input name="orgname" type="text" id="orgname" value="${applyInfos.orgname }"/>
       </p>
        <br>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经&nbsp;&nbsp;办&nbsp;&nbsp;人：
        <input name="username" type="text" id="username" value="${applyInfos.username }" />
      </p>
       <br>
       <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;期：
         <input name="applydate" type="text" id="applydate" value="<fmt:formatDate value="${applyInfos.applydate }" pattern="yyyy-MM-dd"/>"/>
      </p>
        <br>
        <form method="post" action="<%=baseUrl %>/applyInfos/insertApplyInfos"  class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
         <input name="id" type="hidden"  value="${applyInfos.id }" />
          <input name="status" type="hidden"  value="${applyInfos.status }" />
          <input type="hidden" name="parentid" value="${applyInfos.parentid }">
          <input type="hidden" name="processId" value="${applyInfos.processdefid }">
          <input name="applytype" type="hidden" id="applytype" value="thirdparty"  />
         <div   style="position:relative; display:; width:390px;">
         <table width="390">
           <tr>
             <td width="78" align="right">呈批流呈：</td>
             <td width="126" align="left">
             <input type="hidden" id="orgLookup.id" name="orgLookup.id" value="${orgLookup.id}"/>
	         <input type="text" value="${applyInfos.processname }" id="orgLookup.name" name="orgLookup.name" class="required" readOnly/>
             <td> <c:if test="${flag=='apply'}"><a class="btnLook" href="<%=baseUrl %>//processDef/list?mark=2" lookupGroup="orgLookup">流程查询</a></c:if>		</td>
             <td>&nbsp;</td>
           </tr>
             <tr>
              <td align="right">编号：</td>
              <td colspan="3" align="left"><input value="${applyInfos.sqnumber }" name="sqnumber"  readonly="readonly"  type="text" id="sqnumber" /></td>
           </tr>
           <tr>
             <td align="right">标题：</td>
             <td colspan="3" align="left"><input name="name"  value="${applyInfos.name }" type="text"  id="name"  />
           </tr>
           <tr>
             <td align="right">内容：</td>
             <td colspan="3" align="left"><textarea name="applydes" cols="30" rows="2"  id="applydes">${applyInfos.applydes }</textarea>
           </tr>
           <c:if test="${flag=='apply'}">
           <tr>
             <td>&nbsp;</td>
             <td><button type="submit">保存</button></td>
             <td><input type="button" onclick="submitApply('${applyInfos.id}');"  value="提交" /></td>
             <td></td>
           </tr>
           </c:if>
            <tr>
             <td colspan="4" align="right"><input  type="button" onclick="generateApplyInfo('${applyInfos.id}');"  value="生成呈批件" /></td>
           </tr>
         </table>
      </div>
      </form>
      <div style="position:relative; width:100%;">第三方附件：
      <div></div>
       <c:if test="${flag=='apply'}">
       <div style="height:100%; width:100%;">
                    附件：
       <c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=pcasedoc"></c:import>
       </div>
       </c:if>
       </div>
    </div>
  </div>
   
  <div class="STYLE2"  style="position:absolute; right:0px; width:300px; border-left:thin; border-left-style:solid; height: 900px;">
  <div id="checklisttable" style="position:relative;width:300px; ">
    <div class="STYLE3" style="position:relative; width:250px; margin-top:40px">批示栏</div>
       <c:forEach var="item" items="${list}" varStatus="s">
        <div style='position:relative; text-align:left; width:290px; margin-right:10px; margin-top:20px'>
			<div style='position:relative;width:290px; margin-top:10px;'>
			<c:choose>
                  <c:when test="${item.checkdes !=null}">
                     ${item.checkdes}
                   </c:when>
                   <c:otherwise>
                                                             未申请
                   </c:otherwise>
				</c:choose>
			</div><br /><div style='position:relative;width:290px; text-align:right;'>${item.Partic_User_Value }
			<br /><fmt:formatDate value="${item.checkdate }" pattern="yyyy-MM-dd"/>
			</div></div>
	   </c:forEach>
    </div>
    <div style="position:relative; width:250px; margin-top:40px;">
    </div>
  </div>
  <script type="text/javascript">
   function generateApplyInfo(oid){
	   open("<%=baseUrl %>/auditApply/printApplyInfos?applyId="+oid ,"呈批件", 'width:800,height:600,menubar=yes, resizable=yes,scrollbars=yes ');
   }
  function submitApply(oid){
	    var processId=$(':hidden[name="orgLookup.id"]').val();
	    if(processId==""){
	    	processId=$(':hidden[name="processId"]').val();
	    }
		$.post('<%=baseUrl %>/applyInfos/submitApplyInfos',
				{'oid':oid,'applydes':$("#applydes").val(),
			     'applyflowid':processId,
			     'applyflowname':$("input[id='orgLookup.name']").val(),
			     'name':$("#name").val(),
			     'currency':$("#currency").val(),
			     'amounta':$("#amounta").val()
			   },
	       function(data){
	           if(data.result=="1"){
	        	   alertMsg.warn("批件已提交！！不能重复提交！！");
	           }else if(data.result=="2"){
	        	   alertMsg.warn("批件处理成功！！");
	           }else if(data.result=="3"){
	        	   alertMsg.warn("批件不需要处理！！");
	           }else{
	        	   alertMsg.error("流程定义错误！！");
	           }
		  }
		     ,'json');
	}
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
</div>
</div>
