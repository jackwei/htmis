<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/client/rewarranter/update?navTabId=rewarranterLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
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
			<a class="btnLook" href="<%=baseUrl %>/client/rewarranter/property" lookupGroup="orgLookup">反担保人评级查询</a>	
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" value="${rewarranter.address}" class="required"/>
		</p>
		<p>
			<label>国家:  </label>
			<input type="text" name="country" value="${rewarranter.country}" />
		</p>
		<p>
			<label>地区:  </label>
			<input type="text" name="area" value="${rewarranter.area}" />
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
