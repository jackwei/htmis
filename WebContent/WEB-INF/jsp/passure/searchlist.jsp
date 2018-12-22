<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm" action="<%=baseUrl %>/passure/search" onsubmit="return navTabSearch(this)">

<div class="pageHeader">
	<div class="searchBar">
		<table class="searchContent">
			<tr>
			   <td>反担保人：<input type="text" name="rewarrantersn" value="${rewarrantersn}" ></td>
			   <td>担保编号：<input type="text" name="assurenum" value="${assurenum}" /></td>
			   <td>出具时间：<input type="text" name="issuedate1" value="${issuedate1}" class="date" onblur="checkdate(this)"/><a class="hidden" href="javascript:;"></a>---<input type="text" name="issuedate2" value="${issuedate2}" class="date" onblur="checkdate(this)"/><a class="hidden" href="javascript:;"></a></td>
			</tr>
			<tr>
			   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;船名：<input type="text" name="shipnameb" value="${shipnameb}" /></td>  
			   <td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;备注：<input type="text" name="remark" value="${remark}" ></td>
			   <td>撤回时间：<input type="text" name="backdate1" value="${backdate1}" class="date" /><a class="hidden" href="javascript:;"></a>---<input type="text" name="backdate2" value="${backdate2}" class="date" /><a class="hidden" href="javascript:;"></a></td>
			</tr>
			<tr>
			    <td>&nbsp;&nbsp;&nbsp;未发账：<input type="checkbox" name="accflag" value="1" /></td>
			</tr>
		</table>
		<div class="subBar">
			<ul>
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>


<div class="pageContent">       
    <table class="table" width="100%" layoutH="160">
    <thead>
      <tr>
        <th width="4%"></th>
        <th width="16%">案号</th>
        <th width="10%">船名</th>
        <th width="10%">反担保人</th>
        <th width="10%">担保编号</th>
        <th width="10%">状态</th>
        <th width="10%">出具时间</th>
        <th width="5%">担保币种</th>
        <th width="10%">担保金额</th>
        <th width="5%">发账币种</th>
        <th width="10%">发账手续费</th>
      </tr>
      </thead>
      <tbody>
		<c:forEach var="a" items="${slist}" varStatus="s">
			<tr target="slt_objId" style="cursor: pointer;" rel="${a.passureid}" onclick="navTab.openTab('addpassureandbill','<%=baseUrl %>/passure/edit/${a.caseid}',{title:'添加担保及担保账单',fresh:false})">
			    <td>${s.index + 1}</td>
			    <td>${a.casenumber}${a.excasenumber}</td>
<%-- 				<td>${a.casenumber}${a.excasenumber}</td>
 --%>				<td>${a.shipname}</td>
				<td>${a.rewarrantersn}</td>
				<td>${a.assurenum}</td>
				<td>
				   <c:forEach var="status" items="${assurestatue}">
						<c:if test="${status.code eq a.feestatuse }">${status.desc}</c:if>
					</c:forEach>
				</td>
				<td>${a.issuedate}</td>
				<td>${a.currency}</td>
				<td>${a.assurefee}</td>
				<td>${a.acccurrency}</td>
				<td>${a.accamount}</td>
			</tr>
		</c:forEach>
		</tbody>
    </table>
  
    <c:import url="../layout/pager/panelBar.jsp"></c:import>
  </div> 