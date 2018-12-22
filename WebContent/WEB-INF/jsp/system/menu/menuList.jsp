<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent" id="mainMenuDiv" layoutH="0">
	
	<div class="accordion" style=" float:left; display:block; margin:10px; overflow:auto; width:300px; height:500px; overflow:auto; border:solid 1px #CCC; line-height:21px; background:#FFF;">
		<div class="accordionHeader">
			<h2><span>Folder</span>系统菜单</h2>
		</div>
		<div class="accordionContent" id="subMenuDiv">
			<ul class="tree treeFolder">
				<c:forEach var="item" items="${menuList}" varStatus="s">
					<li><a href="<%=baseUrl %>/system/menu/subMenu?parentId=${item.id}" target="ajax" rel="subMenuDiv">${item.menuName}</a></li>	
				</c:forEach>
			</ul>
		</div>		
	</div>
	
	
	<div class="accordion" id="menuDiv" style="width:600px;float:left;margin:5px;">
		
	</div>
	
	
</div>