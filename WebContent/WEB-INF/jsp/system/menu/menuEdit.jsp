<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="<%=baseUrl %>/management/book/edit/${menu.id}">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/system/menu/update?navTabId=orgListNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="56">		
		<p>
			<label>菜单名称： </label>
			<input type="text" name="menuName" value="${menu.menuName}" class="required"/>
		</p>
		
		<p class="a">
			<label>上级组织: </label>
			<input type="text" name="parentId" size="35" value="${menu.menu.menuName}" disabled="disabled" class="readonly"/>
		</p>
		
		<dl class="nowrap">
			<dt>URL: </dt>
			<dd>
			<textarea name="url" cols="80" rows="1" class="required">${menu.url}</textarea>
			</dd>
		</dl>
	</div>

	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
		</ul>
	</div>
</form>
</div>