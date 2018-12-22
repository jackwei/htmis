<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/assure/rewarranter" onsubmit="return navTabSearch(this)">

<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>反担保人名称：</label>
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
			<li><a class="add" target="navTab" rel="rewarranterNav" href="<%=baseUrl %>/assure/rewarranter/add" title="添加反担保人"><span>添加</span></a></li>
			<li><a class="edit" target="navTab" rel="rewarranterNav" href="<%=baseUrl %>/assure/rewarranter/edit/{slt_objId}" title="编辑反担保人信息"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/assure/rewarranter/delete/{slt_objId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
       
    <table class="table" width="100%" layoutH="138">
    <thead>
      <tr>
        <th width="50"></th>
        <th >全称</th>
        <th >简称</th>
        <th >评级</th>
        <th >地址</th>
        <th >地区（国家）</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${rewarranterlist}" varStatus="s">
			<tr target="slt_objId" rel="${a.oid}">
			    <td>${s.index + 1}</td>
				<td>${a.name}</td>
				<td>${a.names}</td>
				<td>${a.propertyname}</td>
				<td>${a.address}</td>
				<td>${a.country}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../../layout/pager/panelBar.jsp"></c:import>
  </div> 