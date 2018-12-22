<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form id="pagerForm" method="post" action="<%=baseUrl %>/management/book/edit/${org.id}">
	<input type="hidden" name="pageNum" value="1" />
</form>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/system/org/update?navTabId=orgListNav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="id" value="${org.id}"/>
	<input type="hidden" name="orgLevel" value="${org.orgLevel.code}"/>
	<input type="hidden" name="parentId" value="${org.parentId}" />	
	<input type="hidden" name="createTime" value="<fmt:formatDate value="${org.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"></input>
	
	<input type="hidden" name="operatorId" value="${org.operatorId}" />	
	<div class="pageFormContent" layoutH="56">		
		<p>
			<label>组织编码: </label>
			<input type="text" name="id" value="${org.id}" class="readonly" />
		</p>
		<p>
			<label>组织层级: </label>
			<input type="text" name="orgLevelDesc" value="${org.orgLevel.desc}" disabled="disabled" class="readonly"/>
		</p>
		<p>
			<label>组织类型：</label>
			<select name="orgType" class="combox required">
				<c:forEach var="item" items="${orgTypeList}">
				<option value="${item.code}" ${item.code eq org.orgType.code ? 'selected="selected"':'' } >${item.desc}</option>
				</c:forEach>
			</select>
		</p>
		<p class="a">
			<label>上级组织: </label>
			<input type="text" name="parentOrg" size="35" value="${org.org.orgName}" disabled="disabled" class="readonly"/>
		</p>
		<!-- p class="a">
			<label>上级组织：</label>
			<input name="categoryId" class="required" value="${org.parentId}" type="hidden"/>
			<input type="hidden" name="orgLookup.id" value="" />
			<input type="hidden" id="orgCode" name="orgLookup.orgCode" value="" />
			<input type="hidden" name="orgLookup.orgLevel" value="" />
			<input name="orgLookup.orgName" value="${org.org.orgName}" type="text" disabled="disabled" class="readonly" lookupgroup="orgLookup" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch" lookupgroup="orgLookup" height="500">上级机构</a>			
		</p-->
		<p>
			<label>组织中文简称: </label>
			<input type="text" name="orgSname" value="${org.orgSname}" class="required"/>
		</p>
		<p>
			<label>组织英文简称: </label>
			<input type="text" name="orgEname" value="${org.orgEname}" class="required"/>
		</p>
		<dl class="nowrap">
			<dt>组织全称: </dt>
			<dd>
			<textarea name="orgName" cols="80" rows="1" class="required">${org.orgName}</textarea>
			</dd>
		</dl>
		<dl class="nowrap">
			<dt>联系地址：</dt>
			<dd><textarea name="linkAddress" cols="80" rows="1" >${org.linkAddress}</textarea></dd>
		</dl>
		<p>
			<label>联系电话: </label>
			<input type="text" name="linkPhone" value="${org.linkPhone}" class="phone"/>
		</p>
		<p>
			<label>是否为营业机构：</label>
			<select name="flag" class="required">
				<option value="">--请选择--</option>
				<c:forEach var="item" items="${yesNo}">
					<option value="${item.code}" ${item.code eq org.flag ? 'selected="selected"' : ''}>${item.desc}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>机构状态：</label>
			<select name="orgStatus" >				
				<c:forEach var="item" items="${status}">
					<option value="${item.code}" ${item.code eq org.orgStatus ? 'selected="selected"' : ''}>${item.desc}</option>
				</c:forEach>
			</select>
		</p>
		<p>
			<label>组织完全路径: </label>
			<input type="text" name="extend1" value="${org.extend1}" disabled="disabled" class="readonly" />
		</p>
		<p>
			<label>公司段编码: </label>
			<input type="text" name="extend3" value="${org.extend3}" />
		</p>
		<p>
			<label>部门段编码: </label>
			<input type="text" name="orgCode" value="${org.orgCode}" />
		</p>
		<p class="a">
			<label>部门主管：</label>
			<input type="hidden" name="orgLookup.oid" value="" />
			<input class="textInput valid" type="text" id ="names" size="30" readonly="readonly" onclick="check()" lookupgroup="orgLookup" name="orgLookup.names" autocomplete="off" value=""/></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/assure/consignor/search?st={st}" lookupgroup="orgLookup" height="500">选择部门主管</a>			
		</p>
		<p class="a">
			<label>部门分管高管：</label>
			<input type="hidden" name="orgLookup.oid" value="" />
			<input class="textInput valid" type="text" id ="names" size="30" readonly="readonly" onclick="check()" lookupgroup="orgLookup" name="orgLookup.names" autocomplete="off" value=""/></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/assure/consignor/search?st={st}" lookupgroup="orgLookup" height="500">选择部门分管领导</a>			
		</p>
	
	</div>

	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">修改</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>