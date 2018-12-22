<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<script type="text/javascript">

function searchSup(tabId){
	var tab = 'c';
	if("first1"==tabId){
		tab += "first";
	}else if("second1"==tabId){
		tab += "second";
	}else if("third1"==tabId){
		tab += "third";
	}else if("four1"==tabId){
		tab += "four";
	}
	var backUrl = "<%=baseUrl %>/management/case/"+tab;
	$("#"+tabId).loadUrl(backUrl,'',function(){
         $("#"+tabId).find("[layoutH]").layoutH();
     });
}
</script>

<div class="pageContent sortDrag" selector="h1" layoutH="1">
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
 				    <li><a href="javascript:;"><span>本机构案件</span></a></li>
					<li><a href="javascript:searchSup('first1');"><span>立案6个月未发账案件</span></a></li>
					<li><a href="javascript:searchSup('second1');"><span>待提交审批第三方费用案件</span></a></li>
					<li><a href="javascript:searchSup('third1');"><span>发账3个月未到账账单</span></a></li>
					<li><a href="javascript:searchSup('four1');"><span>已到账未登记案件</span></a></li>
				</ul>
			</div>
		</div>
		
		<div class="tabsContent">
 		    <div id="sup">
			    <c:import url="../case/csup.jsp"></c:import>
		    </div> 
			<div id="first1">
			    <c:import url="../case/first.jsp"></c:import>
			</div>
			<div id="second1">
			    <c:import url="../case/second.jsp"></c:import>
			</div>
			<div id="third1">
 			    <c:import url="../case/third.jsp"></c:import>
			</div>
			<div id="four1">
 			     <c:import url="../case/four.jsp"></c:import>
			</div>
		</div>
		
	</div>


</div>
