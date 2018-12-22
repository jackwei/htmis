<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent" style="padding:5px">
	<div class="panel" defH="40">
		<h1>呈批件审核</h1>
		<div style="position:relative; text-align:center;">
		<div class="STYLE1" style="position:relative;height:40px;">呈&nbsp;&nbsp;&nbsp;批&nbsp;&nbsp;&nbsp;件</div>
		</div>
	</div>
	<div class="tabs">
		<div class="tabsContent">
			<div>
				<div layoutH="146" style="float:left; display:block; overflow:auto; width:600px; border:solid 1px #CCC; line-height:21px">
				  			    
					<div class="STYLE3" style="margin-left:100px;margin-top:20px">支付海事业务转为收入申请</div>
						<fieldset><legend>呈批件基本信息</legend>	
						<div class="STYLE2" id="cpjinfo" style=" text-align:left; width:500px; margin-right:10px; margin-top:20px">
							<p style="font-size:15px;font-family: '黑体';">&nbsp;&nbsp;关于【<span><font color="red" size="15px;" style="TEXT-DECORATION: underline">${caseInfo.shipname }
							</font></span>】轮于【<span><font color="red" size="15px;" style="TEXT-DECORATION: underline">
							<fmt:formatDate value="${caseInfo.accidentdate}" pattern="yyyy-MM-dd"/>
							</font></span>】在【<span><font color="red" size="15px;" style="TEXT-DECORATION: underline">${caseInfo.accidentport }${caseInfo.casedes}</font></span>】的请示： 
					       	<br>
					       	<br>               
					       	&nbsp;华泰案号：${caseInfo.casenumber }${caseInfo.excasenumber }
					       	</p>
							<br>
							<h4>总公司领导：</h4>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;就题述事宜，根据委托人的确认，特申请将余额【<span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.recordcurrency}:${caseClaim.recordmount }</font></span>】
							转为【<span><font color="red" style="TEXT-DECORATION: underline">${caseClaim.incaseno }</font></span>】 的帐单到账。
							</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;妥否，请批示。</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请部门：
								<input name="orgname"   type="text" id="orgname" value="${applyInfos.orgname }" readonly="readonly">
							</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;经&nbsp;&nbsp;办&nbsp;&nbsp;人：
							  	<input name="username"   type="text" id="username" value="${applyInfos.username }" class="readonly" />
							</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请日期：
							   <input name="creatdate"   type="text" id="creatdate" readonly="readonly" value="<fmt:formatDate value="${applyInfos.creatdate }" pattern="yyyy-MM-dd"/>"/>
							</p>
						</div>
					   	</fieldset>  
					   	<fieldset><legend>提交审批流程信息</legend>	  
					    	<c:import url="../common/processCommon.jsp"></c:import>
					 	</fieldset>
					 	<fieldset><legend>转为收入审批相关附件</legend>
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
				
				<div id="jbsxBox" class="unitBox" style="margin-left:200px;">
					<c:import url="../common/AuditCommon.jsp"></c:import>
				</div>
	
			</div>
		</div>		
	</div>
	<div class="panel" defH="20">
		<div class="formBar">			
			<form method="post" name="backFm" action="<%=baseUrl %>/applyInfos/submitApplyInfos?navTabId=${backNav}&callbackType=closeCurrent&applyId=${applyInfos.id}" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
				
				<ul>
					<c:if test="${flag=='apply'}">
						<c:if test="${applyInfos.processdefid !=null }">					
						<li><div class="button" id="btnDiv1"><div class="buttonContent"><button type="submit">提交审批</button></div></div></li>
						</c:if>
					</c:if>			
					<li><div class="buttonActive"><div class="buttonContent"><button type="button" class="close">返回</button></div></div></li>							
				</ul>
			</form>
		</div>
	</div>
</div>




<div class="panel" defH="420">
<div style="position:relative; text-align:center;">
<div style="position:relative; border-bottom:thin; border-bottom-style:solid;">
   	  <div class="STYLE1" style="position:relative;width:700px; height:40px;">呈&nbsp;&nbsp;&nbsp;批&nbsp;&nbsp;&nbsp;件</div>
    <!--  <div style="position:relative;width:700px; text-align:left;margin-top:20px; height:40px;"><img width="232" src="/images/applyinfologo.gif" height="30" /></div>-->
  </div>
  <div style="position:absolute; left:0px; width:400px; height: 900px;">
    <div class="STYLE3" style="position:relative; width:300px; margin-top:40px">支付海事业务转为收入申请</div>
   <div class="STYLE2" id="cpjinfo" style="position:relative; text-align:left; width:390px; margin-right:10px; margin-top:20px">
       <p style="font-size:15px;font-family: '黑体';">&nbsp;关于${caseInfo.shipname }轮于<fmt:formatDate value="${caseInfo.accidentdate}" pattern="yyyy-MM-dd"/>在${caseInfo.accidentport }${caseInfo.casedes}的请示 
         <br>                
           	&nbsp;&nbsp;&nbsp;&nbsp;华泰案号：${caseInfo.casenumber }
       </p>
       <br>
       <p>&nbsp;&nbsp;&nbsp;&nbsp;总公司：</p>
       <br>
       <p>&nbsp;&nbsp;&nbsp;&nbsp;就题述事宜，因
        <input name="thingcause" type="text" id="thingcause" readonly="readonly" value="${caseClaim.thingcause }"/>
                     特申请将  
          <input name="applyamount" type="text" id="applyamount" readonly="readonly" value="${caseClaim.applyamount }"/>转为
         <input name="incaseno" type="text" id="incaseno" readonly="readonly" value="${caseClaim.incaseno }"/>
                      收入。
       </p>
      <p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;妥否，请批示。</p>
      <br>
      <c:import url="../common/processCommon.jsp"></c:import>
       <div style="position:relative; width:100%;">
        <div style="height:100%; width:100%;">
                    附件：
    	 <c:choose>
       	 <c:when test="${flag=='apply'}">
          <c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=applydoc"></c:import>
        	</c:when>
       	   <c:otherwise>
       	    <c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=applydoc&mark=1"></c:import>
        	</c:otherwise>
     	 </c:choose>
       </div>
       </div>
    </div>
  </div>
  <c:import url="../common/AuditCommon.jsp"></c:import>
</div>
</div>
