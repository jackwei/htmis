<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>
<%
CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>
<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<div class="pageContent sortDrag" selector="h1" >

	<div class="panel collapse">
		<h1>案件基本信息</h1>
		<c:import url="pcaseInfo.jsp" ></c:import>
	</div>
	
	<div class="divider"></div>
	
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>我的账单</span></a></li>
					<li><a href="javascript:;"><span>中再担保</span></a></li>
					<li><a href="javascript:;"><span>协办人</span></a></li>
				</ul>
			</div>
		</div>
		
		<div class="tabsContent" layoutH="50" >
			<div>
				<c:import url="pmyBillList.jsp"></c:import>
			</div>
			<div id="passure">
			    <c:import url="pdbList.jsp"></c:import>
			</div>
			<div>
				<c:import url="pcaseHandleList.jsp"></c:import>
			</div>
		</div>
		
	</div>

</div>
