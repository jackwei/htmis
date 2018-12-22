<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/client/thirdparty/update?navTabId=tdLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<input type="hidden" name="oid" value="${third.oid}">
	<div class="pageFormContent" layoutH="56">

		<p>
			<label>客户名称(中文): </label>
			<input type="text" name="namecn" value="${third.namecn}" class="required"/>
		</p>
		<p>
			<label>客户简称(中文): </label>
			<input type="text" name="namecns" value="${third.namecns}" />
		</p>
		<p>
			<label>客户名称(英文): </label>
			<input type="text" name="nameen" value="${third.nameen}" />
		</p>
		<p>
			<label>客户简称(英文):  </label>
			<input type="text" name="nameens" value="${third.nameens}" />
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" value="${third.address}" />
		</p>
		<p>
			<label>电话:  </label>
			<input type="text" name="telephone" value="${third.telephone}" />
		</p>
		<p>
		    <label>开户行:  </label>
		    <input type="text" name="accountcode" value="${third.accountcode}"/>
		</p>
		<p>
			<label>账户:  </label>
			<input type="text" name="accountname" value="${third.accountname}" />
		</p>
		<p>
			<label>账号:  </label>
			<input type="text" name="accountnum" value="${third.accountnum}" />
		</p>
		<p>
			<label>类型:  </label>
			<input type="text" name="type" value="${third.type}" />
		</p>
		<p>
			<label>评级:  </label>
			<input type="text" name="property" value="${third.property}" />
		</p>
		<p>
		    <label>往来凭证科目:  </label>
		    <input type="text" name="currentcourse" value="${third.currentcourse}" />
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
