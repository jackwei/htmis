<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/params" onsubmit="return navTabSearch(this)">

<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>事发口岸：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>			
		</ul>
		<div class="subBar">
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>


<div class="pageContent">

	<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add" target="dialog" width="410" height="180"  rel="paramaddNav" mask="true" href="<%=baseUrl %>/params/add" title="添加海事口岸"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" width="410" height="180" rel="parameditNav" mask="true" href="<%=baseUrl %>/params/edit/{slt_objId}" title="编辑海事口岸信息"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/params/delete/{slt_objId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
     
    <table class="table" width="100%" layoutH="138">
    <thead>
      <tr>
        <th width="10%"></th>
        <th width="45%">中文</th>
        <th width="45%">英文</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${paramslist}" varStatus="s">
			<tr target="slt_objId" rel="${a.oid}">
			    <td>${s.index + 1}</td>
				<td>${a.paramtexta}</td>
				<td>${a.paramtextb}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>

    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 