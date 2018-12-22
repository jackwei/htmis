<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/client/thirdparty/insert?navTabId=tdLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">


		<p>
			<label>客户名称(中文): </label>
			<input type="text" name="namecn" class="required"/>
		</p>
		<p>
			<label>客户简称(中文): </label>
			<input type="text" name="namecns" />
		</p>
		<p>
			<label>客户名称(英文): </label>
			<input type="text" name="nameen" />
		</p>
		<p>
			<label>客户简称(英文):  </label>
			<input type="text" name="nameens" />
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" />
		</p>
		<p>
			<label>电话:  </label>
			<input type="text" name="telephone" />
		</p>
		<p>
		    <label>开户行:  </label>
		    <input type="text" name="accountcode" />
		</p>
		<p>
			<label>账户:  </label>
			<input type="text" name="accountname" />
		</p>
		<p>
			<label>账号:  </label>
			<input type="text" name="accountnum" />
		</p>
		<p>
			<label>类型:  </label>
			<input type="text" name="type" />
		</p>
		<p>
			<label>评级:  </label>
			<input type="text" name="property" />
		</p>
		<p>
		    <label>往来凭证科目:  </label>
		    <input type="text" name="currentcourse" />
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
