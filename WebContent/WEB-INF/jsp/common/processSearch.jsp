<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/processDef/list?mark=${mark}" onsubmit="if(${mark=='1'}){return navTabSearch(this)}else{return dwzSearch(this, 'dialog');}">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>流程名称：</label>
				<input type="text" name="name" value="${processDef.name }"/>
			</li>
			<li>
				<label>状态：</label>
				<select class="combox" name="currentState">
				    <option value="0">所有</option>
	               	<option value="1" ${processDef.currentState=='1'?"selected='selected'":''}>有效</option>
	               	<option value="2" ${processDef.currentState=='2'?"selected='selected'":''}>无效</option>
	            </select>
			</li>
		</ul>
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left">总数: <strong>${vo.totalCount}</strong></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>
