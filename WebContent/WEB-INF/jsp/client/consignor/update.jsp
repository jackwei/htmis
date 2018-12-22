<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/client/consignor/update?navTabId=consignorLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<input type="hidden" name="oid" value="${consignor.oid}">
	<div class="pageFormContent" layoutH="56">

		<p>
			<label>全称： </label>
			<input type="text" name="name" size="30" value="${consignor.name}" class="required"/>
		</p>
		<p>
			<label>简称:  </label>
			<input type="text" name="names" size="30" value="${consignor.names}" class="required"/>
		</p>
		<p>
			<label>地址:  </label>
			<input type="text" name="address" size="30" value="${consignor.address}" class="required"/>
		</p>
		<p>
			<label>国家:  </label>
			<input type="text" name="country" size="30" value="${consignor.country}" />
		</p>
		<p>
			<label>地区:  </label>
			<input type="text" name="area" size="30" value="${consignor.area}" />
		</p>
		<p>
			<label>开户行: </label>
			<input type="text" name="accountcode" size="30" value="${consignor.accountcode}" />
		</p>
		<p>
			<label>往来凭证科目: </label>
			<input type="text" name="currentcourse" size="30" value="${consignor.currentcourse}" />
		</p>
		<p>
			<label>类型：</label>
			<input class="required textInput valid" type="text" size="30" lookupgroup="orgLookup" readonly="readonly" name="orgLookup.DictName" value="${consignor.sort}" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/consignor/sortsearch" lookupGroup="orgLookup" height="500">委托人分类查询</a>	
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
