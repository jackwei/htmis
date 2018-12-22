<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/client/thirdparty" onsubmit="return navTabSearch(this)">

<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>第三方：</label>
				<input type="text" name="keywords" value="${param.keywords}"/>
			</li>
			<!-- <li>
			    <label>类型：</label>
			    <input type="text" name="status" />
			</li>
			<li>
			    <label>评级：</label>
			    <input type="text" name="property" />
			</li>
			 -->			
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
			<li><a class="add" target="dialog" height="300" width="800" rel="thirdaddNav" mask="true" href="<%=baseUrl %>/client/thirdparty/add" title="添加第三方信息"><span>添加</span></a></li>
			<li><a class="edit" target="dialog" height="300" width="800" rel="thirdeditNav" mask="true" href="<%=baseUrl %>/client/thirdparty/edit/{slt_objId}" title="编辑第三方信息"><span>编辑</span></a></li>
			<li><a class="delete" target="ajaxTodo" href="<%=baseUrl %>/client/thirdparty/delete/{slt_objId}" title="你确定要删除吗?"><span>删除</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
       
    <table class="table" width="100%" layoutH="138">
    <thead>
      <tr>
        <th width="50"></th>
        <th >全称（中文）</th>
        <th >全称（英文）</th>
        <th >简称（中文）</th>
        <th >简称（英文）</th>
        <th >联系电话</th>
        <th >地址</th>
        <!-- 
        <th >类型</th>
        <th >评级</th>
        <th >开户行</th>
        <th >账户名</th>
        <th >账号</th>
        <th >往来科目凭证</th>  -->
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${thirdlist}" varStatus="s">
			<tr target="slt_objId" rel="${a.oid}">
			    <td>${s.index + 1}</td>
				<td>${a.namecn}</td>
				<td>${a.nameen}</td>
				<td>${a.namecns}</td>
				<td>${a.nameens}</td>
				<td>${a.telephone}</td>
				<td>${a.address}</td>
				<!--
				<td>${a.type}</td>
				<td>${a.property}</td> 
				<td>${a.accountcode}</td>
				<td>${a.accountname}</td>
				<td>${a.accountnum}</td>
				<td>${a.currentcourse}</td>  -->
				
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../../layout/pager/panelBar.jsp"></c:import>
  </div> 