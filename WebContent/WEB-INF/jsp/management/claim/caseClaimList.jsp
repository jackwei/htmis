<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>
<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>
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
		if(url.indexOf('management/claim/delete')>0){
			searchCaseClaim('caseClaimNav');
		}else if(url.indexOf('applyInfos/insertApplyInfos')>0){
			seachCaseBillDetail('consignorNav');
		}else if(url.indexOf('management/handle/delete')>0){
			searchHandle('caseHandleNav');
		}else if(url.indexOf('management/compensation/del')>0){
			alertMsg.info(data.message);
			searchClaimInCome('claimIncomeNav');
		}else{
			alertMsg.info(data.message);
			searchClaimInCome('claimIncomeNav');
		}
	},
	error:DWZ.ajaxError});
	}

function searchCaseClaim(divID){
	var backUrl = "<%=baseUrl %>/management/claim/searchCaseClaim";
	 $("#"+divID).loadUrl(backUrl,'',function(){
         $("#"+divID).find("[layoutH]").layoutH();
     });
}
function seachCaseBillDetail(divID){
	var backUrl = "<%=baseUrl %>/management/caseBillDetail/searchCaseBillDetail";
	 $("#"+divID).loadUrl(backUrl,'',function(){
		 $("#"+divID).find("[layoutH]").layoutH();
    });
}
function searchHandle(divID){
	var backUrl = "<%=baseUrl %>/management/handle/searchHandle";
	 $("#"+divID).loadUrl(backUrl,'',function(){
         $("#"+divID).find("[layoutH]").layoutH();
     });
}
function searchBill(divID){
	var backUrl = "<%=baseUrl %>/management/caseBill/searchBill";
	 $("#"+divID).loadUrl(backUrl,'',function(){
         $("#"+divID).find("[layoutH]").layoutH();
     });
}
 function searchClaimInCome(divID){
	var backUrl = "<%=baseUrl %>/management/compensation/searchClaimInCome";
	$("#"+divID).loadUrl(backUrl,'',function(){
	$("#"+divID).find("[layoutH]").layoutH();
  });
}

</script>
 <!--<c:import url="../_frag/pager/pagerForm.jsp"></c:import>
 
 <form id="pagerForm" method="post" action="<%=baseUrl %>/management/claim/searchCaseClaim" onsubmit="return divSearch(this, 'caseClaimNav');">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="${pageSize}" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form>-->
 
<div class="pageContent">
	<input type="hidden" target="caseId" rel="${caseId}" />
	<div class="panelBar">
		<ul class="toolBar">
			
			<c:choose>
				<c:when test="${caseInfoImpl.casestatus eq 9 }">
					<li><a  iconClass="magnifier" target="dialog" mask="true" rel="caseClaimEditNav" width="800" height="320"   href="<%=baseUrl %>/management/claim/edit/{claimId},{caseId}?flag=edit" title="查看划款申请"><span>查看</span></a></li>
				</c:when>
				
				<c:otherwise>
					<li><a class="add" target="dialog" mask="true" rel="caseClaimAddNav" width="800" height="320" href="<%=baseUrl %>/management/claim/add/{caseId}?flag=add" warn="请新建案件!" title="添加划款申请"><span>添加</span></a></li>
					<li><a class="edit" target="dialog" mask="true" rel="caseClaimEditNav" width="800" height="320"   href="<%=baseUrl %>/management/claim/edit/{claimId},{caseId}?flag=edit" title="编辑划款申请"><span>编辑</span></a></li>
				</c:otherwise>
			</c:choose>
			
		    <%-- <li><a class="delete" target="ajaxTodo"  rel="caseClaimNav" href="<%=baseUrl %>/management/claim/delete/{claimId}"  title="你确定要删除吗?"><span>删除</span></a></li> --%> 
			<li class="line">line</li>
			<!-- <li><a class="icon" href="demo/common/dwz-team.xls" target="dwzExport" targetType="navTab" title="实要导出这些记录吗?"><span>导出EXCEL</span></a></li>-->		</ul>
	</div>
	<table class="table" width="100%" layoutH="160">
		<thead>
			<tr>
				<th width="50"></th>
				<th>收款人</th>
				 <th>申请币种</th>
				<th>申请金额</th>
				<th>申请类型</th>
				<th>划付币种</th>
				<th>划付金额</th>
				<th>划付时间</th>
				<th>登记时间</th>
				<th>处理状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseClaimList}" varStatus="s">
			<tr target="claimId" rel="${item.claimId }">
				<td>${s.index + 1}</td>
				<td>${item.clientname}</td>
				<td>${item.recordcurrency}</td>
				<td>${item.recordmount}</td>
				<td>
				<c:forEach var="ct" items="${recordtype}">
					<c:if test="${fn:trim(ct['dictid']) eq item.recordtype}">
			     		${fn:trim(ct['dictname']) }
					</c:if>
			    </c:forEach></td>
				<td>${item.currency}</td>
				<td>${item.realamount}</td>
				<td><fmt:formatDate value="${item.treatdate}" pattern="yyyy-MM-dd"/></td>
				<c:choose>
					<c:when test="${item.status =='3' || item.status =='4' }">
						<td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd"/></td>
					</c:when>
					<c:otherwise>
						<td></td>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${item.status =='0'}">
          				<td>
							待提交审批
						</td>
						<td>
							<a type="button" class="button" target="navTab" rel="transferNav" href="<%=baseUrl %>/auditApply/claimApplyInfoDetail?backNav=caseEditNav&claimId=${item.claimId }&flag=apply" title="申请呈批"><span>申请呈批</span></a>
						</td>
          			</c:when>
          			<c:when test="${item.status =='1'}">
          				<td>
							审批中
						</td>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&claimId=${item.claimId }&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
						</td>
          			</c:when>
          			<c:when test="${item.status =='2'}">
          				<td>
							审批完成（待处理）
						</td>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&claimId=${item.claimId }&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
							<a class='button' target="dialog" mask="true" rel="downNav" width="600" height="300"  href='<%=baseUrl %>/FileDown/openFile?oId=${item.claimId}&docType=claimPaydoc'><span>查看附件</span></a>
						</td>
          			</c:when>
          			<c:otherwise>
          				<td>
							处理完毕
						</td>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&claimId=${item.claimId }&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
						    <a class='button' target="dialog" mask="true" rel="downNav" width="600" height="300"  href='<%=baseUrl %>/FileDown/openFile?oId=${item.claimId}&docType=claimPaydoc'><span>查看附件</span></a>
						</td>
          			</c:otherwise>
          		</c:choose>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<!--<c:import url="../_frag/pager/panelBar.jsp"></c:import>
	 <script type="text/javascript">
	function submitApply(claimId){
		alertMsg.confirm("确认要提交呈批件么?",{
			okCall: function(){
				$.post('<%=baseUrl %>/applyInfos/submitApplyInfos',
						{'claimId':claimId},
						function(data){
							   if(data.result=="1"){
								   alertMsg.warn("批件已提交！！不能重复提交！！");
					           }else if(data.result=="2"){
					        	   alertMsg.warn("批件处理成功！！");
					           }else if(data.result=="3"){
					        	   alertMsg.warn("批件不需要处理！！");
					           }else if(data.result=="5"){
					        	   alertMsg.warn("申请正在处理中，请不要重复申请！！");
					           }else if(data.result=="6"){
					        	   alertMsg.warn("第三方未到账，不能申请！");
					           }else if(data.result=="7"){
					        	   alertMsg.warn("第三方已经支付，不能申请！");
					           }else if(data.result=="8"){
					        	   alertMsg.warn("呈批件已经申请过，不能重复申请！");
					           }
					           else{
					        	   alertMsg.error("流程定义错误！！");
					           }
					  }	,"json");
			}});
	}
	</script> -->
</div>
