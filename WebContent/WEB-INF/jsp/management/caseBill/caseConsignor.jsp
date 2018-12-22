<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>

<%
	CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>

<div class="pageContent" >
 	<table class="table" width="100%" layoutH="100" >
		<thead>
			<tr>
				<th width="50"></th>
				<th>单位名称</th>
				<th>货币类型</th>
				<th>服务费</th>
				<th>费用</th>
				<th>代垫款</th>
				<th>记账金额</th>
				<th>发账时间</th>
				<th>到账时间</th>
				<th>状态</th>
				<th>划付呈批件</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caseConsignorList}" varStatus="s">
			<tr target="detailId" rel="${item.Detail_Id }">
				<td>${s.index + 1}</td>
				<td>${item.consignorname}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.replacefee}</td>
				<td>${item.accamount}</td>
				<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd"/></td>
				<td>
				<c:choose>
					<c:when test="${item.status =='0'}">
					 账单未到账
				    </c:when>
				    <c:when test="${item.status =='1'}">
					 已到账
				    </c:when>
				     <c:when test="${item.status =='2'}">
					已保存未提交
				    </c:when>
				     <c:when test="${item.status =='3'}">
					审批中
				    </c:when>
				     <c:when test="${item.status =='4'}">
					待划付
				    </c:when>
				    <c:when test="${item.status =='5'}">
					已申请批量划付
				    </c:when>
				    <c:otherwise>
				  	   已划付
				    </c:otherwise>
				</c:choose>
				
				</td>
				<c:choose>
					<c:when test="${item.status =='0'}">
          				<td>
							账单未到账&nbsp;
						</td>
          			</c:when>
          			<c:when test="${item.status =='1'}">
          				<td>
							 <a class="button" target="ajaxTodo"  rel="consignorNav"  href="<%=baseUrl %>/applyInfos/insertApplyInfos?backNav=caseEditNav&detail_id=${item.Detail_Id }&caseId=${caseInfoImpl.caseId }"  title="确定要保存呈批件信息吗?" ><span>保存</span></a> 
							<!--<form method="post" action="<%=baseUrl %>/applyInfos/insertApplyInfos" class="pageForm required-validate" onsubmit="return divSearch(this,'consignorNav');">
							   <input type="hidden" name="forwardUrl" value="<%=baseUrl %>/auditApply/modifyApplyInfos&detail_id=${item.id }&flag=apply"/>
							   <input name="flag" type="hidden" id="flag" value="apply"  />
							   <input type="hidden" name="name" value="(${item.feenumber})<%=caseInfoImpl.getShipname()%>">
							   <input type="hidden" name="applydes" value="${item.consignorname }(${item.feeamount })">
							   <input type="hidden" name="parentid" value="${item.id }">
							   <input type="hidden" name="parentname" value="${item.consignorname }">
							   <button type="submit">保存</button>
							</form>-->
						</td>
          			</c:when>
          			<c:when test="${item.status=='2'}">
          				<td>
          					<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&detail_id=${item.Detail_Id }&flag=apply' title="修改呈批件"><span>修改</span></a>
						</td>
          			</c:when>
          			<c:otherwise>
          				<td>
							<a class='button' target='navTab' href='<%=baseUrl %>/auditApply/modifyApplyInfos?backNav=caseEditNav&detail_id=${item.Detail_Id }&flag=view' title="呈批件预览"><span>呈批件预览</span></a>
						</td>
          			</c:otherwise>
          		</c:choose>
				<!-- td>
					<a type="button" class="button" target="navTab" onclick="statusCheck('0'); return false;" href="<%=baseUrl %>/applyInfos/toApplyInfos?detail_id=${item.id }&shipname=${caseInfoImpl.shipname }" title="第三方呈批件"><span>申请</span></a>
				</td> -->
				<%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
