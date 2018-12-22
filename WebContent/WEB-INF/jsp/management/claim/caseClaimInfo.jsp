<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseClaimImpl" %>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>

<%
CaseClaimImpl caseClaimImpl = (CaseClaimImpl)request.getAttribute("caseClaimImpl");
CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");

System.out.print(request.getAttribute("status"));
int status=Integer.parseInt(request.getAttribute("status").toString());
%>

<script type="text/javascript">
function divSearch(form,rel){
	if('<%=status%>'==3 || '<%=status%>'==4){
		alertMsg.correct("审批完成，不允许修改信息");
		return false;
	}
	var $form=$(form);
	
	if(!$form.valid()){
  		return false;}
	
	if(form[DWZ.pageInfo.pageNum])form[DWZ.pageInfo.pageNum].value=1;
	if(rel){
	var $box=$("#"+rel);
	$box.ajaxUrl({
	type:"POST",url:$form.attr("action"),data:$form.serializeArray(),callback:function(){
	$box.find("[layoutH]").layoutH();}});}
	$.pdialog.closeCurrent();
	return false;
}

function payeeVal(){
	$("#payee").val($("#clientname").val());
}
</script>
	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/claim/insert?navTabId=${backNav}&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return divSearch(this,'caseClaimNav');">
		<input type="hidden" id="claimId" name="claimId" value="<%= caseClaimImpl.getClaimId()==null ? "":caseClaimImpl.getClaimId() %>"/>
		<input type="hidden" id="caseId" name="caseId" value="${caseId}"/>
		<input type="hidden" id="casenumber" name="casenumber" value="${casenumber}"/>
		<input type="hidden" id="shipname" name="shipname" value="${shipname}"/>
		<input type="hidden" id="doctype" name="doctype" value="applydoc" >
		<div class="pageFormContent" id="commonDiv">
			<p id="pdivId2">
				<label>收款人：</label>
				<input onchange="payeeVal()" id="clientname" name="clientname" type="text" class="required" value="<%= caseClaimImpl.getClientname() == null ? "":caseClaimImpl.getClientname() %>" />
			</p>
			<p>
				<label>申请类型：</label>
				<select id="recordtype" name="recordtype" class="combox required" onchange="recordHide(this.value)">
			     	<option value="A">代收代付</option>
			     	<option value="B">垫付费用</option>
			    </select>
			</p>
			<p id="pdivId4">
			  <label>开户行：</label>
				<input type="text" id="applybank" class="required" name="applybank"  value="<%= caseClaimImpl.getApplybank()==null ? "":caseClaimImpl.getApplybank() %>" />
			</p>
			<p id="pdivId5">
			  <label>账号：</label>
				<input type="text"  class="required" id="applybanknum" name="applybanknum"  value="<%= caseClaimImpl.getApplybanknum()==null ? "":caseClaimImpl.getApplybanknum() %>" />
			</p>
			
			<%-- <p id="pdivId6">
				<label>划付金额：</label>
				<input type="text" name="realamount" class="required"  alt="0.00" value="<fmt:formatNumber value="<%= caseClaimImpl.getRealamount()%>" pattern="##.##" minFractionDigits="2" />" />
			</p> --%>
			
			<p id="pdivId11">
			  <label>转为收入案号：</label>
			    <input type="hidden" name="incaseno" id="incaseno">
				<input type="text"  id="orgLookup.caseno" name="orgLookup.caseno"  value="<%= caseClaimImpl.getIncaseno()==null ? "":caseClaimImpl.getIncaseno() %>" readOnly/>
	            <a class="btnLook" href="<%=baseUrl %>/management/claim/searchCase?casestatus=0" lookupGroup="orgLookup">案件查询</a>
			</p>
			<p  id="pdivId7">
				<label>到账币种：</label>
				<select name="transfercurrency" id="transfercurrency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictname'] }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p  id="pdivId8">
			  <label>到账金额：</label>
				<input type="text" id="transfermount" name="transfermount"  alt="0.00" value="<fmt:formatNumber value="<%= caseClaimImpl.getTransfermount()%>" pattern="##.##" minFractionDigits="2" />"  onchange="Arabia_to_Chinese(this.value,'transfer')" />
			    <span id="transferBigValue" style="color:red"></span>
			</p>
			<p id="pdivId0">
				<label id="clb1" style="display:none">赔偿币种：</label>
				<label id="clb2" style="display:none">垫付款币种：</label>
				<label id="clb3" style="display:none">币种：</label>
				<select name="recordcurrency" id="recordcurrency" class="combox required">
					<c:forEach var="ct" items="${currency}">
			     		<option value="${ct['dictname'] }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p id="pdivId1">
			    <label id="lb1" style="display:none">赔偿金额：</label>
			    <label id="lb2" style="display:none">垫付款金额：</label>
			    <label id="lb3" style="display:none">金额：</label>
				<input type="text"  class="required" id="recordmount" name="recordmount" alt="0.00" value="<fmt:formatNumber value="<%= caseClaimImpl.getRecordmount()%>" pattern="##.##" minFractionDigits="2" />"  onchange="Arabia_to_Chinese(this.value,'record')"/>
			    <span id="recordmountBigValue" style="color:red"></span>
			</p>
			
			<p id="pdivId3">
				<label>划付币种：</label>
				<select name="currency" id="currency" class="combox required">
					<c:forEach var="ct" items="${currency}">
						<option value="${ct['dictid'] }" ${ct['dictid'] eq caseClaimImpl.currency ? 'selected="selected"':'' } >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
			    </select>
			</p>
			<p id="pdivId10">
			  <label>收款单位：</label>
				<input type="text" id="payee"  name="payee" value="<%= caseClaimImpl.getPayee()==null ? "":caseClaimImpl.getPayee() %>" />
			</p>
			 <p id="pdivId9">
	        <label>事由：</label>
	        <textarea name="thingcause" id="thingcause" cols="30" rows="2" ><%= caseClaimImpl.getThingcause()==null ? "":caseClaimImpl.getThingcause() %></textarea>
			</p>
	        
			<dl class="nowrap">
				<dt>备注：</dt>
				<br>
				<dd><textarea name="remark" cols="30" rows="2" ><%= caseClaimImpl.getRemark() == null ? "":caseClaimImpl.getRemark()%></textarea></dd>
			</dl>
			</div>
			
		<!-- div id="applyInfoDiv" class="pageFormContent" style="display:none;" >
		  	<p><label>呈批流呈：</label>
	           <input name="applytype" type="hidden" id="applytype" value="caseClaim"  />
	           <input name="status" type="hidden" id="status" value="${applyInfos.status }"  />
	           <input name="processId" type="hidden" id="processId" value="${applyInfos.processdefid }"  />
	           <input type="hidden" id="orgLookup.id" name="orgLookup.id" value="${orgLookup.id}"/>
	           <input type="text"  id="orgLookup.name" name="orgLookup.name" value="${applyInfos.processname }" class="required" readOnly/>
	           <a class="btnLook" href="<%=baseUrl %>/processDef/list?mark=2" lookupGroup="orgLookup">流程查询并带回选中的值</a>		
	      </p> 
	      <p>
	         <label>编号：</label>
	          <input type="text" id="sqnumber" name="sqnumber" value="${applyInfos.sqnumber }" readonly="readonly"/>
	      </p>
	     <p>
	       <label>呈批件标题：</label>
	       <input name="name" type="text" id="name" size="30" value="${applyInfos.name }"/>
	      </p>
	     <p>
	        <label>呈批内容：</label>
	        <textarea name="applydes" id="applydes" cols="30" rows="3">${applyInfos.applydes }</textarea>
	      </p>
		</div-->
		<div class="formBar">
			<ul>
				<c:choose>
					<c:when test="${caseInfoImpl.casestatus eq 9 }">
					</c:when>
					<c:otherwise>
						<c:choose>
							<c:when test="${flag eq 'add' }">
								<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
							</c:when>
							<c:otherwise>
								<c:if test="${caseClaimImpl.status eq 0 }">
									<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
								</c:if>
							</c:otherwise>
							</c:choose>
					</c:otherwise>
				</c:choose>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	 </form>
	 <script type="text/javascript">
	   $("#recordtype").val('<%=caseClaimImpl.getRecordtype()%>');
	   $("#currency").val('<%=caseClaimImpl.getCurrency()%>');
	   $("#transfercurrency").val('<%=caseClaimImpl.getTransfercurrency()%>');
	   $("#recordcurrency").val('<%=caseClaimImpl.getRecordcurrency()%>');
	   $("#recordtype").change();
	 	
	 	function recordHide(val){
	 		 if(val=="A"){
	 			$("#lb1").show();
	 			$("#lb2").hide();
	 			$("#lb3").hide();
	 			$("#clb1").show();
	 			$("#clb2").hide();
	 			$("#clb3").hide();
	 			$("#pdivId0").show();
	 			$("#pdivId1").show();
	 			$("#pdivId7").show();
	 			$("#pdivId8").show();
	 			/* $("#pdivId9").hide(); */
	 			$("#pdivId10").hide();
	 			$("#pdivId11").hide();
	 			$("#pdivId2").show();
	 			$("#pdivId3").show();
	 			$("#pdivId4").show();
	 			$("#pdivId5").show();
	 			$("#transfermount").attr("class","required");
	 			/* $("#pdivId6").show(); */
	 			//$("#commonDiv").show();
	 			//$("#TransferDiv").show();
	 			//$("#advanceDiv").hide();
	 		 }else if(val=="B"){
	 			$("#lb1").hide();
	 			$("#lb2").show();
	 			$("#lb3").hide();
	 			$("#clb1").hide();
	 			$("#clb2").show();
	 			$("#clb3").hide();
	 			$("#pdivId0").show();
	 			$("#pdivId1").show();
	 			$("#pdivId7").hide();
	 			$("#pdivId8").hide();
	 			$("#pdivId9").show();
	 			$("#pdivId10").show();
	 			$("#pdivId2").show();
	 			$("#pdivId3").show();
	 			$("#pdivId4").show();
	 			$("#pdivId5").show();
	 			/* $("#pdivId6").show(); */
	 			$("#pdivId11").hide();
	 			$("#transfermount").attr("class","");
	 			//$("#commonDiv").show();
	 			//$("#TransferDiv").hide();
	 			//$("#advanceDiv").show();
	 		 }else if(val=="C"){
	 			$("#pdivId7").hide();
	 			$("#pdivId8").hide();
	 			/* $("#pdivId9").hide(); */
	 			$("#pdivId10").hide();
	 			$("#lb1").hide();
	 			$("#lb2").hide();
	 			$("#lb3").show();
	 			$("#clb1").hide();
	 			$("#clb2").hide();
	 			$("#clb3").show();
	 			$("#pdivId0").show();
	 			$("#pdivId1").show();
	 			$("#pdivId2").hide();
	 			$("#pdivId3").hide();
	 			$("#pdivId4").hide();
	 			$("#pdivId5").hide();
	 			/* $("#pdivId6").hide(); */
	 			$("#pdivId11").show();
	 		 }else if(val=="D"){
	 			$("#pdivId0").hide();
	 			$("#pdivId1").hide();
	 			$("#pdivId7").hide();
	 			$("#pdivId8").hide();
	 			/* $("#pdivId9").hide(); */
	 			$("#pdivId10").hide();
	 			$("#pdivId2").show();
	 			$("#pdivId3").show();
	 			$("#pdivId4").show();
	 			$("#pdivId5").show();
	 			/* $("#pdivId6").show(); */
	 			$("#pdivId11").hide();
	 		 }
	 	  /*var needDisplay=[], needHide=[];
	 	   if(val=="A"){
	 		  needDisplay = ["transfermount","applybank","applybanknum"];
	 		  needHide = ["payee","thingcause","advancefeetype","transferdate","incaseno"];
	 	   }else if(val=="B"){
	 		  needDisplay = ["thingcause","payee","applybanknum","applybank","transferdate","advancefeetype"];
	 		  needHide = ["transfermount","incaseno"];
	 	   }else if(val=="C"){
	 		  $("#incaseno").val("C");
	 		  needDisplay = ["thingcause","incaseno"];
	 		  needHide = ["payee","applybanknum","applybank","transfermount","transferdate","advancefeetype"];
	 	   }else if(val=="D"){
	 		  needDisplay = ["thingcause","applybank","applybanknum"];
	 		  needHide = ["transfermount","payee","transferdate","advancefeetype","incaseno"];
	 	   }
	 	   for(var i=0; i<needDisplay.length; i++){
	 		   $("#"+needDisplay[i]).removeAttr("disabled");
		 	   $("#"+needDisplay[i]).addClass("required").removeClass("disabled");
	 	   }
	 	   for(var i=0; i<needHide.length; i++){
	 		   $("#"+needHide[i]).attr("disabled","disabled");
		 	   $("#"+needHide[i]).addClass("disabled").removeClass("required");
	 	   }*/
	 	}
	 	function Arabia_to_Chinese(Num,val) {
            for (i = Num.length - 1; i >= 0; i--) {
                Num = Num.replace(",", "");//替换tomoney()中的“,”
                Num = Num.replace(" ", "");//替换tomoney()中的空格
            }
            Num = Num.replace("￥", "");//替换掉可能出现的￥字符
            if (isNaN(Num)) { //验证输入的字符是否为数字
                alert("请检查小写金额是否正确");
                return;
            }
            //---字符处理完毕，开始转换，转换采用前后两部分分别转换---//
            part = String(Num).split(".");
            newchar = "";
            //小数点前进行转化
            for (i = part[0].length - 1; i >= 0; i--) {
                if (part[0].length > 10) { alert("位数过大，无法计算"); return ""; } //若数量超过拾亿单位，提示
                tmpnewchar = "";
                perchar = part[0].charAt(i);
                switch (perchar) {
                    case "0": tmpnewchar = "零" + tmpnewchar; break;
                    case "1": tmpnewchar = "壹" + tmpnewchar; break;
                    case "2": tmpnewchar = "贰" + tmpnewchar; break;
                    case "3": tmpnewchar = "叁" + tmpnewchar; break;
                    case "4": tmpnewchar = "肆" + tmpnewchar; break;
                    case "5": tmpnewchar = "伍" + tmpnewchar; break;
                    case "6": tmpnewchar = "陆" + tmpnewchar; break;
                    case "7": tmpnewchar = "柒" + tmpnewchar; break;
                    case "8": tmpnewchar = "捌" + tmpnewchar; break;
                    case "9": tmpnewchar = "玖" + tmpnewchar; break;
                }
                switch (part[0].length - i - 1) {
                    case 0: tmpnewchar = tmpnewchar + "元"; break;
                    case 1: if (perchar != 0) tmpnewchar = tmpnewchar + "拾"; break;
                    case 2: if (perchar != 0) tmpnewchar = tmpnewchar + "佰"; break;
                    case 3: if (perchar != 0) tmpnewchar = tmpnewchar + "仟"; break;
                    case 4: tmpnewchar = tmpnewchar + "万"; break;
                    case 5: if (perchar != 0) tmpnewchar = tmpnewchar + "拾"; break;
                    case 6: if (perchar != 0) tmpnewchar = tmpnewchar + "佰"; break;
                    case 7: if (perchar != 0) tmpnewchar = tmpnewchar + "仟"; break;
                    case 8: tmpnewchar = tmpnewchar + "亿"; break;
                    case 9: tmpnewchar = tmpnewchar + "拾"; break;
                }
                newchar = tmpnewchar + newchar;
            }
            //小数点之后进行转化
            if (Num.indexOf(".") != -1) {
                if (part[1].length > 2) {
                    alert("小数点之后只能保留两位,系统将自动截段");
                    part[1] = part[1].substr(0, 2);
                }
                for (i = 0; i < part[1].length; i++) {
                    tmpnewchar = "";
                    perchar = part[1].charAt(i);
                    switch (perchar) {
                        case "0": tmpnewchar = "零" + tmpnewchar; break;
                        case "1": tmpnewchar = "壹" + tmpnewchar; break;
                        case "2": tmpnewchar = "贰" + tmpnewchar; break;
                        case "3": tmpnewchar = "叁" + tmpnewchar; break;
                        case "4": tmpnewchar = "肆" + tmpnewchar; break;
                        case "5": tmpnewchar = "伍" + tmpnewchar; break;
                        case "6": tmpnewchar = "陆" + tmpnewchar; break;
                        case "7": tmpnewchar = "柒" + tmpnewchar; break;
                        case "8": tmpnewchar = "捌" + tmpnewchar; break;
                        case "9": tmpnewchar = "玖" + tmpnewchar; break;
                    }
                    if (i == 0) tmpnewchar = tmpnewchar + "角";
                    if (i == 1) tmpnewchar = tmpnewchar + "分";
                    newchar = newchar + tmpnewchar;
                }
            }
            //替换所有无用汉字
            while (newchar.search("零零") != -1)
                newchar = newchar.replace("零零", "零");
            newchar = newchar.replace("零亿", "亿");
            newchar = newchar.replace("亿万", "亿");
            newchar = newchar.replace("零万", "万");
            newchar = newchar.replace("零元", "元");
            newchar = newchar.replace("零角", "");
            newchar = newchar.replace("零分", "");

            if (newchar.charAt(newchar.length - 1) == "元" || newchar.charAt(newchar.length - 1) == "角")
                newchar = newchar + "整";
            //document.write(newchar);
            //return newchar;
            if(val=="record"){
            	$("#recordmountBigValue").html(newchar);
            }else if(val=="transfer"){
            	$("#transferBigValue").html(newchar);
            }
            /*else if(val=="record1"){
            	$("#recordmountBigValue1").html(newchar);
            }else if(val=="record2"){
            	$("#recordmountBigValue2").html(newchar);
            }*/
            
        }
	 </script>
	</div>