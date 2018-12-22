<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="panel collapse" defH="150">
	<h1>立案6个月未发账案件</h1>
	<div>
	<table class="list" width="99%">
		<thead>
			<tr>
				<th width="50"></th>
				<th>案号</th>
				<th>船名</th>
				<th>币种</th>
				<th>服务费</th>
				<th>费用</th>
				<th>担保手续费</th>
				<th>第三方总金额</th>
				<th>其它费用</th>
				<th>赔款汇差</th>
				<th>总金额</th>
				<!-- <th>发账时间</th>
				<th>到账时间</th> -->
			</tr>
		</thead>
		<tbody>
		<c:forEach var="item" items="${caselistone}" varStatus="s">
			<tr id="billId" target="billId" style="cursor: pointer;" rel="${item.billId }" onclick="navTab.openTab('caseEditNav','<%=baseUrl %>/management/case/edit/${item.caseid}',{title:'案件信息',fresh:false})">
				<td>${s.index + 1}</td>
				<td>${item.casenumber}${item.excasenumber}</td>
				<td>${item.shipname}</td>
				<td>${item.currency}</td>
				<td>${item.servicefee}</td>
				<td>${item.expendses}</td>
				<td>${item.assurefee}</td>
				<td>${item.thirdpart}</td>
				<td>${item.otherfee}</td>
				<td>${item.compensationsub}</td>
				<td>${item.feeamount}</td>
<%-- 			<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
 --%>		</tr>
		</c:forEach>
		</tbody>
	</table>
	</div>
</div>

<div class="panel collapse" defH="150">
	<h1>待提交审批第三方费用案件</h1>
		<div>
		<table class="list" width="98%">
              <thead>
              <tr>
               <th width="50"></th>
               <th width="200">案号</th>
               <th>船名</th>
               <th>事发口岸</th>
               <th>委托人</th>
               <th width="250">案件描述</th>
               <th>主办人</th>
              </tr>
             </thead>
             <tbody>
             <c:forEach var="item" items="${caseIdListtwo}" varStatus="s">
              <tr target="caseId" rel="${item.Case_Id }" style="cursor: pointer;" onclick="navTab.openTab('caseEditNav','<%=baseUrl %>/management/case/edit/${item.Case_Id}',{title:'案件信息',fresh:false})" style="cursor: pointer;">
               <td>${s.index + 1}</td>
               <td>${item.casenumber}${item.excasenumber}</td>
               <td>${item.shipname}</td>
               <td>${item.accidentport}</td>
               <td>${item.consignorsn}</td>
               <td>${item.casedes}</td>
               <td>${item.username}</td>
               <%-- <td><input id="caseId" type="hidden" value="${item.caseId }"> </td> --%>
               <%-- <td><fmt:formatDate value="${item.publishDate}" pattern="yyyy-MM-dd"/></td>
               <td><fmt:formatDate value="${item.insertDate}" pattern="yyyy-MM-dd HH:mm:ss"/></td> --%>
              </tr>
             </c:forEach>
             </tbody>
            </table>
            </div>
	</div>
	
	<div class="panel collapse" defH="150">
		<h1>发账3个月未到账账单</h1>
		<div>
		<table class="list" width="98%">
			<thead>
				<tr>
					<th width="50"></th>
					<th>账单编号</th>
					<th>船名</th>
					<th>币种</th>
					<th>服务费</th>
					<th>费用</th>
					<th>担保手续费</th>
					<th>第三方总金额</th>
					<th>其它费用</th>
					<th>赔款汇差</th>
					<th>总金额</th>
					<th>发账时间</th>
					<!-- <th>到账时间</th> -->
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${caselistthree}" varStatus="s">
				<tr id="billId" target="billId" style="cursor: pointer;" rel="${item.billId }" onclick="navTab.openTab('caseEditNav','<%=baseUrl %>/management/case/edit/${item.caseid}',{title:'案件信息',fresh:false})">
					<td>${s.index + 1}</td>
					<%-- <td>${item.feenumber}</td> --%>
					<td>${item.feenumber}</td>
					<td>${item.shipname}</td>
					<td>${item.currency}</td>
					<td>${item.servicefee}</td>
					<td>${item.expendses}</td>
					<td>${item.assurefee}</td>
					<td>${item.thirdpart}</td>
					<td>${item.otherfee}</td>
					<td>${item.compensationsub}</td>
					<td>${item.feeamount}</td>
					<td><fmt:formatDate value="${item.accdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
<%-- 				<td><fmt:formatDate value="${item.arrdate}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
 --%>				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</div>
	
	<div class="panel collapse" defH="150">
		<h1>已到账未登记案件</h1>
		<div>
		<table class="list" width="98%">
			<thead>
				<tr>
					<th width="50"></th>
					<th>案号</th>
					<th>船名</th>
					<th>付款人</th>
					<th>到账币种</th>
					<th>到账金额</th>
					<th>对账余额</th>
					<th>到账时间</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="item" items="${caselistfour}" varStatus="s">
				<tr id="billId" target="billId" style="cursor: pointer;" rel="${item.billId }" onclick="navTab.openTab('caseEditNav','<%=baseUrl %>/management/case/edit/${item.caseid}',{title:'案件信息',fresh:false})" >
					<td>${s.index + 1}</td>
					<td>${item.casenumber}${item.excasenumber}</td>
					<td>${item.shipname}</td>
					<td>${item.payername}</td>
					<td>${item.currency}</td>
					<td>${item.changeamount}</td>
					<td>${item.differamount}</td>
					<td><fmt:formatDate value="${item.tradedate}" pattern="yyyy-MM-dd"/></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		</div>
	</div>