<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<ul>
<c:forEach var="item" items="${menuList}" varStatus="s">
	<li><a href="<%=baseUrl %>/system/menu/menuEdit?menuId=${item.id}" target="ajax" rel="menuDiv">${item.menuName}</a></li>	
</c:forEach>
</ul>