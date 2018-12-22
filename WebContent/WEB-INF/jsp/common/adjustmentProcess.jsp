<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" java.util.List" %>
<div class="pageContent">
  <form method="post"  action="<%=baseUrl %>/auditApply/adjustmentPartic?navTabId=applyListNav&callbackType=closeCurrent"  class="pageForm required-validate"  onsubmit="return iframeCallback(this, dialogAjaxDone)">
	 <table class="table" width="100%"  layoutH="200">
		<thead align="center">
			<tr>
				<th width="50">No.</th>
				<th>参与者</th>
				<th>参与者ID</th>
			</tr>
		</thead>
		<tbody align="center"> 
		<c:forEach var="item" items="${ls}" varStatus="s">
			<tr>
				<td>${s.index+1}</td>
				<td>${item.Partic_User_Value}</td>
				<td>${item.Partic_User_Id}</td>
			</tr>
			<input type="hidden" name="processInstId" value="${item.Process_Inst_ID }">
			<input type="hidden" name="activityInstId" value="${item.Activity_Inst_ID }">
			<input type="hidden" name="particInstId" value="${item.Partic_Inst_Id }">
		</c:forEach>
		</tbody>
	</table>
	<%
	  List list=(List)request.getAttribute("ls");
	  if(list!=null && list.size()!=0){
	%>
	 <div  class="pageFormContent">
	    <p>
	           <label>机构：</label>
	           <input type="hidden" id ="zorg" name="orgLookupf.id" />
		       <input class="textInput valid" size="30" readonly="readonly" type="text" lookupgroup="orgLookupf" name="orgLookupf.extend1" autocomplete="off" /></input>
		      <a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch" lookupgroup="orgLookupf" height="500">主办机构</a>			
	    </p>
		<p>
				<label>调整审批人：</label>
				<input type="hidden" name="userLookup.id" value="" />
				<input class="required textInput valid" type="text" id ="username" size="30" readonly="readonly" lookupgroup="userLookup" name="userLookup.name" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/user/userSearch?orgCode={zorg}" warn="请先选择协办机构" lookupgroup="userLookup">审批人</a>			
	  </p>
	  </div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
	<%
	  }else{
	%>
	<div class="formBar">
		<ul>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
	<%
	  }
	%>
	</form>
</div>
