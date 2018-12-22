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
				  			    
					<div class="STYLE3" style="margin-left:20px;margin-top:20px">关于【<span><font color="red" style="TEXT-DECORATION: underline">${year}</font></span>】年【<span><font color="red" style="TEXT-DECORATION: underline">${month}</font></span>】月中再担保手续费到帐及划付事</div>
					
					
						<fieldset><legend>呈批件基本信息</legend>	
						<br>
						<div class="STYLE2"  style="text-align:left; width:500px; margin-right:10px; margin-top:20px">
							<h4>公司领导：</h4>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp; 【<span><font color="red" style="TEXT-DECORATION: underline">${year}</font></span>】年【<span><font color="red" style="TEXT-DECORATION: underline">${month}</font></span>】月，中再担保手续费到帐【<span><font color="red" style="TEXT-DECORATION: underline">${total}</font></span>】份，累计金额为【<span><font color="red" style="TEXT-DECORATION: underline">${feemount}</font></span>】美元。 					         
							</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp; &nbsp;根据集团公司海事担保手续费划拨流程的新规定，我司应将【<span><font color="red" style="TEXT-DECORATION: underline">${year}</font></span>】年【<span><font color="red" style="TEXT-DECORATION: underline">${month}</font></span>】月担保手续费【<span><font color="red" style="TEXT-DECORATION: underline">${feemount}</font></span>】美元划给集团公司下述指定美元账户：							</p>
							<p><br>
							  户名：中国再保险（集团）股份有限公司 <br>
							  </p>
							<p>开户行：中行北京丰盛支行 <br>
							  </p>
							<p>账号：344161244188 </p>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</p>
							<p> &nbsp;&nbsp;&nbsp;妥否，请批示。</p>
							<br>					
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申&nbsp;&nbsp;请&nbsp;&nbsp;人：
								<input name="username"   type="text" id="username" value="${applyInfos.username }" readonly="readonly">
							</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请部门：
								<input name="orgname"   type="text" id="orgname" value="${applyInfos.orgname }" readonly="readonly">
							</p>
							<br>
							<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;申请日期：
							<input name="creatdate"   type="text" id="creatdate" readonly="readonly" value="<fmt:formatDate value="${applyInfos.creatdate }" pattern="yyyy-MM-dd"/>"/>
							  <!-- <input name="applydate"   type="text" id="applydate" readonly="readonly" value="<fmt:formatDate value="${applyInfos.applydate }" pattern="yyyy-MM-dd"/>"/> --> 
							</p>
						</div>
					   	</fieldset>  
					   	<fieldset><legend>提交审批流程信息</legend>	  
					    	<c:import url="../common/processCommon.jsp"></c:import>
					 	</fieldset>
					 	<fieldset><legend>划付审批相关附件</legend>
					      <div style="text-align:left; width:500px; ">
					           <c:forEach var="item" items="${listDocs}" varStatus="s">
								 <a class='icon' href='<%=baseUrl %>/FileDown/download?oid=${item.id}'>${item.filename }</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							   </c:forEach>
					        <c:choose>
					       	 <c:when test="${flag=='apply'}">
					          <c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=assuredoc"></c:import>
					        	</c:when>
					       	   <c:otherwise>
					       	    <c:import url="/applyInfos/toFileUpload?applyId=${applyInfos.id }&doctype=assuredoc&mark=1"></c:import>
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
				<input type="hidden" id="caseId" name="caseId" value="${caseId }">
				<ul>
					<c:if test="${flag=='apply'}">
						<li><div class="button" id="btnDiv1"><div class="buttonContent"><button type="submit">提交审批</button></div></div></li>
					</c:if>			
					<li><div class="buttonActive"><div class="buttonContent"><button type="button" class="close">返回</button></div></div></li>					
				   <!--  <li><a class="button" target="navTab" rel="caseEditNav" href="<%=baseUrl %>/management/case/edit/{caseId}" title="案件信息"><span>返回</span></a></li>	 -->	
				</ul>
			</form>
		</div>
	</div>
</div>
