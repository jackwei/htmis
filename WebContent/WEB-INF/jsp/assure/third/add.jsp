<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/assure/thirdparty/insert?navTabId=tdLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="56">


		<p>
			<label>客户名称(中文): </label>
			<input type="text" name="namecn" class="required"/>
		</p>
		<p>
			<label>客户简称(中文): </label>
			<input type="text" name="namecns" class="required"/>
		</p>
		<p>
			<label>客户名称(英文): </label>
			<input type="text" name="nameen" class="required"/>
		</p>
		<p>
			<label>客户简称(英文):  </label>
			<input type="text" name="nameens" class="required"/>
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" class="required"/>
		</p>
		<p>
			<label>电话:  </label>
			<input type="text" name="telephone" class="phone"/>
		</p>
		<p>
			<label>账户:  </label>
			<input type="text" name="accountname" class="required"/>
		</p>
		<p>
			<label>账号:  </label>
			<input type="text" name="accountnum" class="required"/>
		</p>
		<p>
			<label>类型:  </label>
			<input type="text" name="type" class="required"/>
		</p>
		<p>
			<label>评级:  </label>
			<input type="text" name="property" class="required"/>
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
