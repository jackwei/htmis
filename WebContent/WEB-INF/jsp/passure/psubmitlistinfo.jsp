<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.TblPassurePayMents"%>


<div class="pageContent sortDrag" selector="h1" layoutH="1">

	<div class="panel collapse" id="assurebill">
		<h1>呈批件信息</h1>
		<c:import url="../passure/paymentdetaillist.jsp"></c:import>
	</div>
	
	<div class="divider"></div>
	
	<div class="tabs">
	
		<c:choose>	
		<c:when test="${tp.reportflag eq 'submit' }">
			<div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>已申请呈批担保手续费</span></a></li>
				</ul>
			</div>
		</div>
		
		<div class="tabsContent">
		   <div  id="pptlist">
		        <c:import url="../passure/passurepaymentlist.jsp"></c:import>

		</div>
		</div>
		</c:when>
		<c:otherwise>
		    <div class="tabsHeader">
			<div class="tabsHeaderContent">
				<ul>
					<li><a href="javascript:;"><span>已申请呈批担保手续费</span></a></li>
					<c:if test="${tp.reportflag eq 'new'}">
					<li><a href="javascript:;"><span>未申请呈批担保手续费</span></a></li>  
			        </c:if>
			        <c:if test="${tp.reportflag eq 'save'}">
					<li><a href="javascript:;"><span>未申请呈批担保手续费</span></a></li>  
			        </c:if>

				</ul>
			</div>
		</div>
		
		<div class="tabsContent">
		   <div  id="pptlist">
		        <c:import url="../passure/passurepaymentlist.jsp"></c:import>
	       </div>
	       <c:if test="${tp.reportflag eq 'new'}">
			<div  id="unpptlist">
		        <c:import url="../passure/unpassurepaymentlist.jsp"></c:import>
	        </div>
           </c:if>
           <c:if test="${tp.reportflag eq 'save'}">
			<div  id="unpptlist">
		        <c:import url="../passure/unpassurepaymentlist.jsp"></c:import>
	        </div>
           </c:if>
		</div>				
		</c:otherwise>
		</c:choose>
			
		
		
	</div>

</div>