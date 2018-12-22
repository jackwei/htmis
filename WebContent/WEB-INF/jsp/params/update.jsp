<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/params/update?navTabId=paramLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<input type="hidden" name="oid" value="${params.oid}">
	<div class="pageFormContent" layoutH="56">

		<p>
			<label>中文: </label>
			<input type="text" name="paramtexta" value="${params.paramtexta}" class="required"/>
		</p>
		<p>
			<label>英文:  </label>
			<input type="text" name="paramtextb" value="${params.paramtextb}" class="required"/>
		</p>

	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>
