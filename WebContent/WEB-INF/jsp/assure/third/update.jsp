<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/assure/thirdparty/update?navTabId=tdLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="oid" value="${third.oid}">
	<div class="pageFormContent" layoutH="56">

		<p>
			<label>客户名称(中文): </label>
			<input type="text" name="namecn" value="${third.namecn}" class="required"/>
		</p>
		<p>
			<label>客户简称(中文): </label>
			<input type="text" name="namecns" value="${third.namecns}" class="required"/>
		</p>
		<p>
			<label>客户名称(英文): </label>
			<input type="text" name="nameen" value="${third.nameen}" class="required"/>
		</p>
		<p>
			<label>客户简称(英文):  </label>
			<input type="text" name="nameens" value="${third.nameens}" class="required"/>
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" value="${third.address}" class="required"/>
		</p>
		<p>
			<label>电话:  </label>
			<input type="text" name="telephone" value="${third.telephone}" class="phone"/>
		</p>
		<p>
			<label>账户:  </label>
			<input type="text" name="accountname" value="${third.accountname}" class="required"/>
		</p>
		<p>
			<label>账号:  </label>
			<input type="text" name="accountnum" value="${third.accountnum}" class="required"/>
		</p>
		<p>
			<label>类型:  </label>
			<input type="text" name="type" value="${third.type}" class="required"/>
		</p>
		<p>
			<label>评级:  </label>
			<input type="text" name="property" value="${third.property}" class="required"/>
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
