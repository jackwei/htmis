<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/processDef/insertProcessDef?navTabId=processLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageContent sortDrag" selector="h1" layoutH="37">
	<div class="panel" defH="300">
	<h1>流程定义信息</h1>
	<div class="pageFormContent">
		<p>
			<label>流程名称： </label>
			<input type="text" name="name" class="required"/>
		</p>
		<p>
		</p>
		<p>
			<label>流程描述： </label>
			<textarea name="desc" cols="30" rows="3"></textarea>
		</p>
		</div>
	</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
