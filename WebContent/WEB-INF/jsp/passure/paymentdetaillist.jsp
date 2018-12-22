<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.TblPassurePayMents"%>

<%
	TblPassurePayMents tp = (TblPassurePayMents) request.getAttribute("tp");
%>
<script language="javascript" src="styles/js/util.js"></script>

<div class="pageContent">
<%--    <form method="post" id="payment" target="selectedTodo" rel="aids" action="<%=baseUrl%>/passure" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">		
 --%>   
 <form method="post" id="payment" action="<%=baseUrl%>/passure" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">		
		<div class="pageFormContent">
		        <input type="hidden" id="passurepayid" name="passurepayid" value="<%=tp.getPassurepayid()%>">
		        <input type="hidden" id="payid" name="payid" value="<%=tp.getPassurepayid()%>">
		         <input type="hidden" name="forwardUrl" value="<%=baseUrl %>/passure/passuresubmit/{payid}?navTabId=ppdNav"/> 
<%-- 		        <input type="hidden" name="forwardUrl" value="<%=baseUrl %>/auditApply/modifyApplyInfos?payid=<%=tp.getPassurepayid()%>&flag=apply&navTabId=cpjNav"   />
 --%>				<p>
					<label>机构：</label> <input type="text" name="orgname" readonly="readonly" value="<%=tp.getOrgname() == null ? "" : tp.getOrgname()%>">
				</p>
				<p>
					<label>制单员：</label> <input type="text" name="username" readonly="readonly" value="<%=tp.getUsername() == null ? "" : tp.getUsername()%>">
				</p>
				<p>
					<label>到账明细：</label> <input type="text" name="receivedetail" readonly="readonly" value="<%=tp.getReceivedetail() == null ? "" : tp.getReceivedetail()%>">
				</p>
				<p>
<%-- 					<label>生成时间：</label> <input type="text" name="createdate" readonly="readonly" value="<fmt:formatDate value="<%= tp.getCreatedate() %>" pattern="yyyy-MM-dd"/> ">
 --%>				<label>担保份数：</label> <input type="text" name="total" readonly="readonly" value="<%=tp.getTotal() == null ? "" : tp.getTotal()%>" /> 
                </p>
                <c:choose>
                  <c:when test="${tp.reportflag eq 'new'}">
                  	<p>
				        <label>呈批件年：</label><input class="number" type="text" id="year" name="year" value="<%=tp.getYear() == null ? "" : tp.getYear()%>">
				    </p>
				    <p>
				        <label>呈批件月：</label><input class="number" type="text" id="month" name="month" value="<%=tp.getMonth() == null ? "" : tp.getMonth()%>">
				    </p>                 
                  </c:when>
                  
                  <c:when test="${tp.reportflag eq 'save'}">
                  	<p>
				        <label>呈批件年：</label><input class="number" type="text" id="year" name="year" value="<%=tp.getYear() == null ? "" : tp.getYear()%>">
				    </p>
				    <p>
				        <label>呈批件月：</label><input class="number" type="text" id="month" name="month" value="<%=tp.getMonth() == null ? "" : tp.getMonth()%>">
				    </p>                 
                  </c:when>
                  
                  <c:otherwise>
				    <p>
				        <label>呈批件年：</label><input class="number" readonly="readonly" type="text" id="year" name="year" value="<%=tp.getYear() == null ? "" : tp.getYear()%>">
				    </p>
				    <p>
				        <label>呈批件月：</label><input class="number" readonly="readonly" type="text" id="month" name="month" value="<%=tp.getMonth() == null ? "" : tp.getMonth()%>">
				    </p>
                           
                  </c:otherwise>
                </c:choose>
		</div>
		<div class="formBar">
		<ul>
		<c:if test="${tp.reportflag eq 'new'}">
		    <li>
<%-- 		        <a class='button' target="ajaxTodo" href="<%=baseUrl%>/passure/sendpassureapply/{passurepayid}?rel=paysendid" title="你确定要保存呈批件吗?" ><span>保存</span></a>
		    
               <a class="button"  target="ajaxTodo"  rel="pbLiv" onclick="assureapply()" ><span>保存呈批件</span></a>
 --%> 
                   <a class="button" href="javascript:assureapply();" ><span>保存呈批件</span></a>
            </li>				
		</c:if>
		<c:if test="${tp.reportflag eq 'save'}">
			<li>
<%--  					<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?payid=<%=tp.getPassurepayid()%>&flag=apply' title="修改呈批件"><span>修改呈批件</span></a>
 --%> 			        <a class="button" href="javascript:assureapply();" ><span>修改呈批件年月</span></a>
            </li>
            <li>
                        <a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?payid=<%=tp.getPassurepayid()%>&flag=apply' title="添加附件及提交审批"><span>添加附件及提交审批</span></a>
            </li>            
		</c:if>
		<c:if test="${tp.reportflag eq 'submit' }">
			<li>
					<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?payid=<%=tp.getPassurepayid()%>&flag=view' title="查看呈批件"><span>查看呈批件</span></a>
			</li>
		</c:if>
		<c:if test="${tp.reportflag eq 'pass' }">
			<li>
					<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?payid=<%=tp.getPassurepayid()%>&flag=view' title="查看呈批件"><span>查看呈批件</span></a>
			</li>
		</c:if>
		    <!-- <li><div class="buttonActive"><div class="buttonContent"><button type="button" >生成账单</button></div></div></li> -->
		    <li><a class="button" target="navTab" rel="pbLiv" href="<%=baseUrl %>/passure/dbcplist?navTabId=paymentLiv" title="担保手续费呈批"><span>返回</span></a></li>
		    <%-- <li><a class="button" target="navTab" rel="pmLiv" href="<%=baseUrl%>/passure/payment"  title="担保划付"><span>返回</span></a></li> --%>
			<!-- <li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li> -->
		</ul>
	</div>
	</form>
	
</div>

<script type="text/javascript" >
<%-- function payubmit(){
var passurepayid = $('#passurepayid').val();
var url = "<%=baseUrl%>/passure/sendpassureapply?passurepayid="+passurepayid+"&navTabId=ppdNav&callbackType=forward";
$("#payment").attr("action", url);
$('#payment').submit();
}
 --%>
function assureapply(){
	var year = $('#year').val();
	var month = $('#month').val();
	if( year=="" || month==""){
		alert("呈批件年月不能为空！");
	}else{
		var passurepayid = $('#passurepayid').val();
		var url = "<%=baseUrl%>/passure/saveApplyInfos?navTabId=pbLiv&payId="+passurepayid+"&callbackType=forward";
		$("#payment").attr("action", url);
		$('#payment').submit();
	}

}

function modifyapply(){
	var passurepayid = $('#passurepayid').val();
	var year = $('#year').val();
	var month = $('#month').val();
	alert("year:"+year+",month:"+month);
	var url = "<%=baseUrl %>/auditApply/modifyApplyInfos&payid="+passurepayid+"&flag=apply";
	$("#payment").attr("action", url);
	$('#payment').submit();
}
</script>
									