<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div layoutH="146" style="position:absolute; left:650px; width:350px;">
  <div id="checklisttable" style="position:relative;width:350px; ">
    <div class="STYLE3" style="position:relative; width:250px;margin-left:100px; margin-top:20px">批示栏</div>
    
     <c:forEach var="item" items="${list}" varStatus="s">
     <c:choose>
      <c:when test="${item.checkdes !=null}">
          <fieldset><legend>已审批节点信息</legend>	
        <div style='position:relative; text-align:left; width:290px; margin-right:10px; margin-top:20px'>
			<div style='position:relative;width:290px; margin-top:10px;'>
			<c:choose>
                 <c:when test="${item.Aduit_Result =='1'}">
                    	&nbsp;&nbsp;审批结论：通过。
                  </c:when>
                  <c:when test="${item.Aduit_Result =='0'}">
                    	&nbsp;&nbsp;审批结论：拒绝。
                  </c:when>
                  <c:otherwise>
                        	
                  </c:otherwise>
			</c:choose> 
			<br />
			<br />
			&nbsp;&nbsp;审批意见：${item.checkdes}
			<!--<c:choose>
                 <c:when test="${item.checkdes !=null}">
                    	&nbsp;&nbsp;审批意见：${item.checkdes}
                  </c:when>
                  <c:otherwise>
                        &nbsp;&nbsp;未申请
                  </c:otherwise>
			</c:choose> -->
			</div>
			<br />
			<div style='position:relative;width:290px; text-align:right;'>${item.Partic_User_Value }
			<br /><fmt:formatDate value="${item.checkdate }" pattern="yyyy-MM-dd"/>
			</div>
			</div>
		</fieldset>
	 </c:when>
	 <c:otherwise>
	     <fieldset><legend>未审批节点信息</legend>
	      <br />
	       &nbsp;&nbsp;未申请
	       	<br />
			<div style='position:relative;width:290px; text-align:right;'>${item.Partic_User_Value }
			<br /><fmt:formatDate value="${item.checkdate }" pattern="yyyy-MM-dd"/>
			</div>
	     </fieldset>	
     </c:otherwise>
	</c:choose>
	</c:forEach>	   
  </div>
        
  <c:if test="${flag=='audit'}">
  	<form method="post" name="approveFm" action="<%=baseUrl %>/auditApply/passApplyInfos?navTabId=${backNav}&callbackType=closeCurrent&applyId=${applyInfos.id}" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
		<fieldset><legend>审批意见和结论</legend>	      	
   	  		<table>
   	  			<tr>
           			<td colspan="2">&nbsp;</td>
           		</tr> 
   	  			<tr>
             		<td width="80" align="right">审批结论：</td>
             		<td width="160" align="left">
             			<label><input type="radio" name="result" checked="checked" value="1" class="required"/>同意</label>
						<label><input type="radio" name="result" value="0" class="required"/>退回</label>
					</td>
           		</tr>
           		<tr>
           			<td colspan="2">&nbsp;</td>
           		</tr>
          		<tr>
             		<td align="right">审批意见：</td>
             		<td align="left">
             			<textarea name="checkdes" cols="30" rows="4" class="required"  id="checkdes">同意</textarea>
					</td>
           		</tr>
           		<tr>
           			<td colspan="4">&nbsp;</td>
           		</tr>  	  
        		<tr>        
          			<td colspan="2" align="center">
          				<div class="buttonActive" id="btnDiv2"><div class="buttonContent"><button type="submit">提交</button></div></div>
          			</td>          			
        		</tr>        
      		</table>
    	</fieldset>
    </form>
   </c:if>
 </div>
  
<!--  <script type="text/javascript">
 
 function returnApplyInfo(){
	 var checkdes =  $('#checkdes').val(); 
	 if(checkdes ==null || checkdes=='')
	 {
	 	alert("审批意见不能为空!");
	 	return;
	 }
	 $.post('<%=baseUrl%>/auditApply/returnApplyInfos',
				{'applyId':$(':hidden[name="id"]').val(),
			     'checkdes':$('#checkdes').val()},
	       function(data){
			    	 if(data.result=="false"){
						   alertMsg.error(data.msg);
			           }
			           else
			           {
			        		alertMsg.correct(data.msg);			        		
			        		document.getElementById("btnDiv").style.display='none';			        		
			           }
			     },'json');
 }
 function passApplyInfo(){
	 var checkdes =  $('#checkdes').val(); 
	 if(checkdes ==null || checkdes=='')
	 {
	 	alert("审批意见不能为空!");
	 	return;
	 }
	 
	 $.post('<%=baseUrl%>/auditApply/passApplyInfos',
				{'applyId':$(':hidden[name="id"]').val(),
			     'checkdes':$('#checkdes').val()},
	       function(data){
			    	 if(data.result=="false"){
						   alertMsg.error(data.msg);
			           }
			           else
			           {
			        		alertMsg.correct(data.msg);			        		
			        		document.getElementById("btnDiv").style.display='none';			        		
			           }
			     },'json');
 }
  </script>-->