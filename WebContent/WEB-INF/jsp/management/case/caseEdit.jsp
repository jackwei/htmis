<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>
<%
CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>
<%-- <c:import url="../../layout/pager/pagerForm.jsp"></c:import>
 --%>
<div class="pageContent sortDrag" selector="h1" layoutH="1">
	<div class="panel collapse">
		<h1 style="padding-left: 10px">案件基本信息</h1>
		<c:import url="../case/caseInfo.jsp" ></c:import>
	</div>
	<div class="divider"></div>
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>我的账单</span></a></li>
					<!-- <li><a href="javascript:;"><span>赔款信息</span></a></li> -->
					<li><a href="javascript:;"><span>第三方状态</span></a></li>
					<li><a href="javascript:;"><span>中再担保</span></a></li>
					<!-- <li><a href="javascript:;"><span>呈批件</span></a></li> -->
					<li><a href="javascript:;"><span>协办人</span></a></li>
					<li><a rel="caseClaimNav" href="javascript:;"><span>划款申请</span></a></li>
					<li><a href="javascript:;"><span>赔款到账</span></a></li>
				</ul>
			</div>
		</div>
		
		<div class="tabsContent">
			<div id="myBillList">
				<c:import url="../caseBill/myBillList.jsp"></c:import>
			</div>
			<!-- <div>赔款信息  </div> -->
			<div id="consignorNav">
				<c:import url="../caseBill/caseConsignor.jsp"></c:import>
			</div>
			<div id="passure">
			    <c:import url="../../passure/pdbList.jsp"></c:import>
			</div>
			<!-- <div>呈批件    </div> -->
			<div id="caseHandleNav">
				<c:import url="../handle/caseHandleList.jsp"></c:import>
			</div>
			<!-- <div> 赔款登记  </div> -->
			<div id="caseClaimNav">
			 	<c:import url="../claim/caseClaimList.jsp"></c:import>
			</div>
			<div id="claimIncomeNav">
				<c:import url="../claim/caseBalanceList.jsp"></c:import>
			</div>
		</div>
		
	</div>


</div>
