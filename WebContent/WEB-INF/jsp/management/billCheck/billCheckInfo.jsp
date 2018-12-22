<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<%
	String flag = request.getParameter("flag");
%>

<div class="pageContent sortDrag" selector="h1" layoutH="10">

	<div class="panel collapse">
		<h1>进账单基本信息</h1>
		<c:import url="../billCheck/billInComeInfo.jsp"></c:import>
	</div>
	
	<c:if test="${flag eq 'check' }">
		<div class="panel collapse">
			<h1>账单列表</h1>
			<div id="billCheck">
				<c:import url="../billCheck/billCheckList.jsp"></c:import>	
			</div>
		</div>
	</c:if>
	
	<c:if test="${flag eq 'checked' }">
		<div id="billChecked" class="panel collapse" >
			<h1>账单列表</h1>
			<div id="billChecked">
				<c:import url="../billCheck/billCheckedList.jsp"></c:import>
			</div>
		</div>
	</c:if>
	
	
</div>