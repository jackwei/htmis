<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>华泰保险经纪-海事业务系统</title>

<!--[if IE]>
<link href="/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="<%=baseUrl%>/styles/dwz/js/speedup.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="<%=baseUrl%>/styles/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>
</head>

<body scroll="no">
<div>
<div style="padding:5px">
<div defH="40">
		<h1>呈批件审核</h1>
		<div style="position:relative; text-align:center;">
		<div class="STYLE1" style="position:relative;height:40px;">呈&nbsp;&nbsp;&nbsp;批&nbsp;&nbsp;&nbsp;件</div>
        </div>
</div>
<div>
		<div>
			<div>
				<div layoutH="146" style="float:left; display:block; overflow:auto; width:600px; border:solid 1px #CCC; line-height:21px">
				  			    
					<div class="STYLE3" style="margin-left:100px;margin-top:20px">支付海事业务垫付费用申请</div>
						<fieldset><legend>呈批件基本信息</legend>	
						<div class="STYLE2" id="cpjinfo" style="text-align:left; width:500px; margin-right:10px; margin-top:20px">
							<p style="font-size:15px;font-family: '黑体';">&nbsp;&nbsp;关于【<span><font color="red" style="TEXT-DECORATION: underline">${caseInfo.shipname }
							</font></span>】轮于【<span><font color="red" style="TEXT-DECORATION: underline">
							<fmt:formatDate value="${caseInfo.accidentdate}" pattern="yyyy-MM-dd"/>
							</font></span>】在【<span><font color="red" style="TEXT-DECORATION: underline">${caseInfo.accidentport }${caseInfo.casedes}</font></span>】的请示： 
					       	<br>               
					       	&nbsp;华泰案号：${caseInfo.casenumber }${caseInfo.excasenumber }
					       	</p>
							<h4>总公司领导：</h4>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.thingcause}</font></span></p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;就题述事宜，我司受【<span><font color="red" style="TEXT-DECORATION: underline">${caseInfo.consignorname }</font></span>】委托向【<span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.payee }</font></span>】
							垫付【<span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.recordcurrency}:${caseClaim.recordmount }</font></span>】。委托人确认该垫付款将于近期汇入我司账户或由业务人员在账单中收回。
							</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;有鉴于此，为妥善处理此事，特申请将此笔垫付款划付至指定的如下银行账户：
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;收&nbsp;&nbsp;款&nbsp;人： <span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.clientname }</font></span></p>
          					<p>&nbsp;&nbsp;&nbsp;&nbsp;开&nbsp;&nbsp;户&nbsp;行： <span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.applybank }</font></span></p>
           					<p>&nbsp;&nbsp;&nbsp;&nbsp;账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：  <span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.applybanknum }</font></span></p>
          					<p>&nbsp;&nbsp;&nbsp;&nbsp;垫付币种： <span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.recordcurrency }</font></span></p>
          					<p>&nbsp;&nbsp;&nbsp;&nbsp;垫付金额： <span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.recordmount }</font></span></p>
          					<p>&nbsp;&nbsp;&nbsp;&nbsp;划付币种： <span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.currency }</font></span></p>
      						<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;妥否，请批示。</p>
							
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请部门：
								<input name="orgname"   type="text" id="orgname" value="${applyInfos.orgname }" readonly="readonly">
							</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经&nbsp;&nbsp;办&nbsp;&nbsp;人：
							  	<input name="username"   type="text" id="username" value="${applyInfos.username }" class="readonly" />
							</p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请日期：
							   <input name="creatdate"   type="text" id="creatdate" readonly="readonly" value="<fmt:formatDate value="${applyInfos.creatdate }" pattern="yyyy-MM-dd"/>"/>
							</p>
						</div>
					   	</fieldset>  
					   	<fieldset><legend>提交审批流程信息</legend>	  
					    	<c:import url="../common/processCommon.jsp"></c:import>
					 	</fieldset>
					 	<fieldset><legend>垫付审批相关附件</legend>
					      <div style="text-align:left; width:500px;">
							<c:forEach var="item" items="${listDocs}" varStatus="s">
								<a class='icon' href='<%=baseUrl %>/FileDown/download?oid=${item.id}'>${item.filename }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							</c:forEach>
							<c:choose>
								<c:when test="${flag=='apply'}">
									<c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=applydoc"></c:import>
								</c:when>
								<c:otherwise>
									<c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=applydoc&mark=1"></c:import>
								</c:otherwise>
							</c:choose>
					  		</div>
					  </fieldset>
				</div>
				
				<div style="margin-left:200px;">
					<div style="position:absolute; left:650px; width:350px;">
					  <div style="position:relative;width:350px; ">
					    <div class="STYLE3" style="position:relative; width:350px;margin-left:100px; margin-top:20px">批示栏</div>
					    
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
					  <br>
					  <c:if test="${flag=='audit'}">
					  	<form method="post" name="approveFm" action="" >
							<fieldset><legend>审批意见和结论</legend>	      	
					   	  		<table>					   	  			
					           		<input type="hidden" name="applyId" id="applyId" value='${applyInfos.id}'>					           		
					   	  			<tr>
					             		<td width="80" align="left">审批结论：</td>
					             		<td width="160" align="left">
					             			<label><input type="radio" name="result" checked="checked" value="1" />同意</label>
											<label><input type="radio" name="result" value="0" class="required"/>退回</label>
										</td>
					           		</tr>					           		
					          		<tr>
					             		<td align="left">审批意见：</td>
					             		<td align="left">
					             			<textarea name="checkdes" cols="22" rows="3" class="required"  id="checkdes">同意</textarea>
										</td>
					           		</tr>					           		
					        		<tr>        
					          			<td colspan="2" align="center">
					          				<div class="buttonActive" id="btnDiv2"><div class="buttonContent"><button type="button" onclick="saveResult();">提交</button></div></div>
					          			</td>          			
					        		</tr>        
					      		</table>
					    	</fieldset>
					    </form>
					   </c:if>
					 </div>
				</div>
			</div>
		</div>		
	</div>
	</div>
</div>
<script type="text/javascript" >

function saveResult()
{
	var result = $("input[name='result']:checked").val();
	if(result == null || result =='') {
		return false;
	}
	else
	{
		$.post("<%=baseUrl %>/auditApply/passApplyInfosOut",{result: result, applyId:$('#applyId').attr('value'),checkdes:$('#checkdes').attr('value')},
		function(data)
		{			
			if(data.result == 'true' || data.result == true)
				{
					window.close();
				}
				else
				{
					alert(data.msg);
				}
		//goBack();
		});
	}
}
</script>
</body>
</html>