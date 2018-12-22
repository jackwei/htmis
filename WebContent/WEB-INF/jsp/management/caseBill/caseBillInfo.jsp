<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<script type="text/javascript">

	function ajaxTodo(url,callback){
		var $callback=callback||navTabAjaxDone;
		if(!$.isFunction($callback))$callback=eval('('+callback+')');
		$.ajax({
		type:'POST',
		url:url,
		dataType:"json",
		cache:false,
		success:function(data){
			if(url.indexOf('management/caseBillDetail/insertRateSub')>0){
				var backUrl = "<%=baseUrl %>/management/caseBillDetail/searchCaseRateSub";
				$("#caseRateSubNav").loadUrl(backUrl,'',function(){
			         $("#caseRateSubNav").find("[layoutH]").layoutH();
			     });
			}
			if(url.indexOf('management/caseBillDetail/insertAdvance')>0){
				var backUrl2 = "<%=baseUrl %>/management/caseBillDetail/searchCaseAdvance";
				$("#caseAdvanceNav").loadUrl(backUrl2,'',function(){
			         $("#caseAdvanceNav").find("[layoutH]").layoutH();
			     });
			}
			
			if(url.indexOf('management/caseBillDetail/thirddelete')>0){
				var backUrl = "<%=baseUrl %>/management/caseBillDetail/searchthirdfee";
				$("#consignorBillNav").loadUrl(backUrl,'',function(){
			         $("#consignorBillNav").find("[layoutH]").layoutH();
			     });
			}
			if(url.indexOf('management/caseBillDetail/otherdelete')>0){
				var backUrl2 = "<%=baseUrl %>/management/caseBillDetail/searchOther";
				$("#otherBillNav").loadUrl(backUrl2,'',function(){
			         $("#otherBillNav").find("[layoutH]").layoutH();
			     });
			}
			if(url.indexOf('management/caseBillDetail/insertBalance')>0){
				alertMsg.info(data.message);
				var backUrl2 = "<%=baseUrl %>/management/caseBillDetail/searchBalance";
				$("#balanceBillNav").loadUrl(backUrl2,'',function(){
			         $("#balanceBillNav").find("[layoutH]").layoutH();
			     });
			}
			
			var backUrl1 = "<%=baseUrl %>/management/caseBill/searchBillInfo";
			$("#myBillInfoNav").loadUrl(backUrl1,'',function(){
		         $("#myBillInfoNav").find("[layoutH]").layoutH();
		     });
		},
		error:DWZ.ajaxError});
		}
	
</script>

<div class="pageContent sortDrag " selector="h1" layoutH="0">
 	<input type="hidden" target="billId" rel="${caseBillImpl.getBillId()}" />

	<div class="tabs" >
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;" ><span>委托第三方</span></a></li>
					<li><a href="javascript:;"><span>其他费用</span></a></li>
					<li><a href="javascript:;"><span>垫付费用</span></a></li>
					<!-- <li><a href="javascript:;"><span>赔款汇差</span></a></li> -->
					<li><a href="javascript:;"><span>汇款余额</span></a></li>
				</ul>
			</div>
		</div>
		
		<div class="tabsContent">
			<div id="consignorBillNav">
				<c:import url="../caseBillDetail/consignorBillList.jsp"></c:import>
			</div>
			<div id="otherBillNav">
				<c:import url="../caseBillDetail/otherBillList.jsp"></c:import>
			</div>
			<div id="caseAdvanceNav">
				<c:import url="../caseBillDetail/caseAdvanceList.jsp"></c:import>		
			</div>
			<%-- <div id="caseRateSubNav">
				<c:import url="../caseBillDetail/caseRateSubList.jsp"></c:import>
			</div> --%>
			<div id="balanceBillNav">
				<c:import url="../caseBillDetail/balanceBillList.jsp"></c:import>
			</div>
		</div>
	</div>

	<div class="divider"></div>
	
	<div class="panel">
		<h1>账单基本信息</h1>
		<div id="myBillInfoNav">
			<c:import url="../caseBill/myBillInfo.jsp"></c:import>
		</div>
	</div>
</div>
