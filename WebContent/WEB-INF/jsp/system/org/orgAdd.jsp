<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/system/org/insert?navTabId=orgListNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="56">
		<!-- p>
			<label>组织层级: </label>
			<select id="orgLevel" name="orgLevel" class="combox required" >
				<option value="">请选择</option>
				<c:forEach var="item" items="${orgLevelList}">
					<option value="${item['dictid'] }" >${fn:trim(item['dictname']) }</option>
				</c:forEach>
			</select>
		</p> -->
		<p class="a">
			<label>上级组织：</label>
			<input type="hidden" name="orgLookup.id" value="" />
			<input type="hidden" id="orgCode" name="orgLookup.orgCode" value="" />
			<input type="hidden" name="orgLookup.orgLevel" value="" />
			<input type="hidden" name="orgLookup.extend1" value="" />
			<input class="required textInput valid" readonly="readonly" size="23" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=C" lookupgroup="orgLookup" height="500">上级机构</a>			
		</p>
		<p>
			<label>组织类型：</label>
			<select name="orgType" class="combox required">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${orgTypeList}">
				<option value="${item}">${item.name}</option>
				</c:forEach>
			</select>
		</p>
		<!-- p>
			<label>组织编码: </label>
			<input type="text" name="orgLookup.orgCode" class="readonly" readonly="readonly" maxlength="20"/>
		</p-->
		<p>
			<label>组织中文简称: </label>
			<input type="text" size="30" name="orgSname" class="required"/>
		</p>
		<p>
			<label>组织英文简称: </label>
			<input type="text" size="30" name="orgEname" class="required"/>
		</p>
		<dl class="nowrap">
			<dt>组织全称: </dt>
			<dd>
			<textarea name="orgName" cols="80" rows="1" class="required"></textarea>
			</dd>
		</dl>
		<dl class="nowrap">
			<dt>联系地址：</dt>
			<dd><textarea name="linkAddress" cols="80" rows="1" ></textarea></dd>
		</dl>
		<p>
			<label>联系电话: </label>
			<input type="text" size="30" name="linkPhone" class="phone"/>
		</p>
		<p>
			<label>是否为营业机构：</label>
			<select name="flag" class="combox required">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${yesNo}">
					<option value="${item.code}">${item.desc}</option>
				</c:forEach>
			</select>
		</p>
		<p class="a">
			<label>组织主管：</label>
			<input type="hidden" name="deptLookup.id" value="" />
			<input class="required textInput valid" type="text" id ="names1" size="23" readonly="readonly" lookupgroup="deptLookup" name="deptLookup.name" autocomplete="off" value="" /></input>
				<a class="btnLook" id="looks1"  href="<%=baseUrl %>/system/user/userSearch" lookupgroup="deptLookup" height="500">选择组织主管</a>			
		</p>
		<p class="a">
			<label>组织分管高管：</label>
			<input type="hidden" name="leaderLookup.id" value="" />
			<input class="required textInput valid" type="text" id ="names2" size="23" readonly="readonly" lookupgroup="leaderLookup" name="leaderLookup.name" autocomplete="off" value="" /></input>
				<a class="btnLook" id="looks2"  href="<%=baseUrl %>/system/user/userSearch" lookupgroup="leaderLookup" height="500">选择组织分管领导</a>			
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
