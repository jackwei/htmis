<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<form method="post" action="<%=baseUrl %>/processDef/updateProcessDef" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="id" value="${parm.id}">
	<div class="panel" defH="100">
	<h1>流程定义信息</h1>
	<div class="pageFormContent">
		<p>
			<label>流程名称： </label>
			<input type="text" name="name" class="required" value="${parm.name}"/>
		</p>
		<p>
		</p>
		<p>
			<label>流程描述： </label>
			<textarea name="desc" cols="30" rows="3">${parm.desc}</textarea>
		</p>
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
		</ul>
	</div>
	<div class="panel" defH="300">
	<h1>流程节点列表</h1>
	<div class="pageContent">
	<div class="panelBar">
		<ul class="toolBar">
			<li>
			  <a class="add" target="navTab" href="<%=baseUrl %>/processDef/addActivityDef?processId=${parm.id}" title="定义节点信息"><span>新增流程节点</span></a><br /><br />
            </li>
            <li>
             <a class="edit" target="navTab" href="<%=baseUrl %>/processDef/toActivityDef?activityId={slt_objId}&processId=${parm.id}"  title="编辑节点信息"><span>编辑节点</span></a><br /><br />
            </li>
			<li class="line">line</li>
		</ul>
	</div>
	 <table class="table" width="100%">
		<thead align="center">
			<tr>
				<th width="50">No.</th>
				<th>节点名称</th>
				<th>节点描述</th>
				<th>启动方式</th>
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="item" items="${list}" varStatus="s">
			<tr target="slt_objId" rel="${item.id}">
				<td>${s.index+1}</td>
				<td>${item.name}</td>
				<td>${item.desc}</td>
				<td>
				<c:choose>
				 <c:when test="${item.startType=='1'}">
				    直接启动
				 </c:when>
				  <c:when test="${item.startType=='2'}">
				     审批金额判断
				 </c:when>				 
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</form>
