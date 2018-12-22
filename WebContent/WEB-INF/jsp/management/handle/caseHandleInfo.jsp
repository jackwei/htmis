<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseHandleImpl" %>
<%
CaseHandleImpl caseHandleImpl = (CaseHandleImpl)request.getAttribute("caseHandleImpl");
%>
<script type="text/javascript">
function divSearch(form,rel){
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

function hid(val){
	  $("#username").val("");
}
</script>
	<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/handle/insert?navTabId=handleAddNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return divSearch(this, 'caseHandleNav');">
		<input type="hidden"  name="seqId" value="<%= caseHandleImpl.getSeqId()==null ? "":caseHandleImpl.getSeqId() %>"/>
		<input type="hidden"  name="caseId" value="${caseId}"/>
		<div  class="pageFormContent">
			<p>
				<label>协办机构：</label>
				<input type="hidden" id="orgCode" name="orgLookup.id" value="<%= caseHandleImpl.getOrgid() == null ? "":caseHandleImpl.getOrgid() %>" />
				<input class="required textInput valid" size="20" readonly="readonly" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off"  value="<%= caseHandleImpl.getOrgname() == null ? "":caseHandleImpl.getOrgname() %>" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch" onclick="hid(this);" lookupgroup="orgLookup" height="500">协办机构</a>			
			
			</p>
			<p>
				<label>协办人：</label>	
				<input type="hidden" name="userLookup.id" value="" />
				<input type="hidden" name="userLookup.sname" value="" />
				<input class="required textInput valid" type="text" id ="username" size="20" readonly="readonly" lookupgroup="userLookup" name="userLookup.name" autocomplete="off" value="<%= caseHandleImpl.getUsername()==null ? "":caseHandleImpl.getUsername() %>"/></input>
					<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/user/userSearch?orgCode={orgCode}" warn="请先选择协办机构" lookupgroup="userLookup" height="500">协办人</a>			
			</p>
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li>
					<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
				</li>
			</ul>
		</div>
	 </form>
	</div>