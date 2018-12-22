<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/assure/rewarranter/update?navTabId=rewarranterLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="oid" value="${rewarranter.oid}">
	<div class="pageFormContent" layoutH="56">

		<p>
			<label>全称： </label>
			<input type="text" name="name" value="${rewarranter.name}" class="required"/>
		</p>
		<p>
			<label>简称:  </label>
			<input type="text" name="names" value="${rewarranter.names}" class="required"/>
		</p>
		<p>
			<label>评级: </label>
			<input class="required textInput valid" type="text" lookupgroup="orgLookup" readonly="readonly" value="${rewarranter.propertyname}" name="orgLookup.DictName" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/assure/rewarranter/property" lookupGroup="orgLookup">反担保人评级查询</a>	
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" value="${rewarranter.address}" class="required"/>
		</p>
		<p>
			<label>地区（国家）:  </label>
			<input type="text" name="country" value="${rewarranter.country}" class="required"/>
		</p>

	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">Save</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">Close</button></div></div></li>
		</ul>
	</div>
</form>
</div>
