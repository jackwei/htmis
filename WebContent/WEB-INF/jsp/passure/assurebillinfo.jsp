<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent sortDrag" selector="h1" layoutH="1">

	<div class="panel collapse" id="assurebill">
		<h1>担保账单基本信息</h1>
		<c:import url="../passure/assurebill.jsp"></c:import>
	</div>
	
	<div class="divider"></div>
	
	<div class="tabs">
		<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>未生成账单担保手续费</span></a></li>
					<li><a href="javascript:;"><span>已生成账单担保手续费</span></a></li>
				</ul>
			</div>
		</div>
		
		<div class="tabsContent">
		   <div  id="unarrbill">
		        <c:import url="../passure/unarrbill.jsp"></c:import>
	       </div>
			<div  id="arrbill">
		        <c:import url="../passure/arrbill.jsp"></c:import>
	        </div>
		</div>
		
	</div>

</div>