<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>


<script type="text/javascript">
	function bb(content){
		$("#content").val(content);
	}
</script>

<div class="pageContent">
	 <form id="caseForm" method="post" action="<%=baseUrl %>/management/case/insertSupervise?navTabId=caseNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return iframeCallback(this,dialogAjaxDone);">
		<div  class="pageFormContent">
			
			<dl class="nowrap">
				<dt>意见内容：</dt>
				<dd><textarea id="content" name="content" style="width: 560px" cols="50" rows="4" ></textarea></dd>
			</dl>
			
		</div>
		<div class="formBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
				<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
			</ul>
		</div>
	 </form>
	 <ul>
		 <li class="line"></li>
	 </ul>
	<div style="overflow:scroll;height: 300px">
		 <table class="table" width="100%" layoutH="1">
			<thead>
				<tr>
					<th width="50"></th>
					<th width="380">内容</th>
					<th>时间</th>
					<th>建议人</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${caseSuperviseImplList}" varStatus="s">
				<tr target="id" rel="${item.id }" >
					<td>${s.index + 1}</td>
					<td onclick="bb('${item.content}')">${item.content}</td>
					<td><fmt:formatDate value="${item.createTime}" pattern="yyyy-MM-dd"/></td>
					<td>${item.name}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	 </div>
	 
</div>