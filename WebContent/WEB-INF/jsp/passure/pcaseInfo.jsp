<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.db.beans.CaseInfoImpl" %>

<%
CaseInfoImpl caseInfoImpl = (CaseInfoImpl)request.getAttribute("caseInfoImpl");
%>

<%-- <form id="pagerForm" method="post" action="#rel#">
	<input type="hidden" name="pageNum" value="1" />
	<input type="hidden" name="pageSize" value="20" />
	<input type="hidden" name="orderField" value="${param.orderField}" />
	<input type="hidden" name="orderDirection" value="${param.orderDirection}" />
</form> --%>
<script language="javascript" src="styles/js/util.js"></script>

<script type="text/javascript">
  function hid(val){
	  $("#names").val("");
	  $("#name").val("");
  }
</script>
<div class="pageContent">
	 <form method="post" action="<%=baseUrl %>/management/case/insert?navTabId=caseNav&callbackType=forward" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
		<input type="hidden" id="caseId" name="caseId" value="<%= caseInfoImpl.getCaseId()==null ? "":caseInfoImpl.getCaseId() %>"/>
		<input type="hidden" name="forwardUrl" value="<%=baseUrl %>/management/case/edit/{caseId}"/>
		<div  class="pageFormContent" layoutH="250">
			<p>
				<label>案号：</label>
				<input name="casenumber" type="text" size="30" value="<%= caseInfoImpl.getCasenumber() == null ? "":caseInfoImpl.getCasenumber().concat(caseInfoImpl.getExcasenumber()) %>" readonly="readonly"/>
			</p>
			<p>
				<label>立案时间：</label>
				<input type="text" name="setdate" class="text" readonly="readonly" size="30" value="<fmt:formatDate value="<%= caseInfoImpl.getCreateTime() %>" pattern="yyyy-MM-dd"/>"  />
			</p>
			<p>
				<label>船名：</label>
				<input class="required" name="shipname" type="text" size="30" value="<%= caseInfoImpl.getShipname() %>"/>
			</p>
			<p>
				<label>案发时间：</label>
				<input type="text" name="accidentdate" class="date required" onblur="checkdate(this)" size="30" value="<fmt:formatDate value="<%= caseInfoImpl.getSetdate() %>" pattern="yyyy-MM-dd"/>" /><a class="inputDateButton" href="javascript:;">选择</a>
			</p>
			<dl class="nowrap">
				<dt>案件描述：</dt>
				<dd><textarea name="casedes" cols="80" rows="2" ><%= caseInfoImpl.getCasedes() == null ? "": caseInfoImpl.getCasedes() %></textarea></dd>
			</dl>
			<p>
				<label>案发口岸：</label>
				<input type="hidden" name="accidentport.oid" value="<%= caseInfoImpl.getAccidentportid()==null ? "":caseInfoImpl.getAccidentportid() %>" />
				<input class="required textInput valid" type="text" size="23" readonly="readonly" lookupgroup="accidentport" name="accidentport.paramtexta" autocomplete="off" value="<%=caseInfoImpl.getAccidentport()==null ? "":caseInfoImpl.getAccidentport() %>"></input>
				<a class="btnLook" href="<%=baseUrl %>/params/search" lookupGroup="accidentport" height="500">事发口岸查询</a>	
			</p>
			<p>
				<label>案件性质：</label>
				<select class="combox required" name="casetypename">
					<option value="">请选择</option>
					<c:forEach var="ct" items="${casetype}">
			     		<option value="${ct['dictid']}" ${ct['dictid'] eq caseInfoImpl.casetypeid ? 'selected="selected"' : '' } >${fn:trim(ct['backup1']) }</option>
			    	</c:forEach>
				</select>
				<!-- <input class="required" name="casetypename" type="text" size="30" value="100001" /> -->
			</p>
			<p>
			    <label>委托人分类：</label>
			    <input type="hidden" name="consignorType.DictName" id="st" value="<%= caseInfoImpl.getConsignortypeid()==null ? "":caseInfoImpl.getConsignortypeid() %>" />
			    <input class="required textInput valid" type="text" id ="sort" size="23" readonly="readonly" lookupgroup="consignorType" name="consignorType.DictName" value="<%= caseInfoImpl.getConsignortypename()==null ? "":caseInfoImpl.getConsignortypename() %>" />    
			    <a class="btnLook" href="<%=baseUrl %>/client/consignor/sortsearch" onclick="hid(this);" lookupgroup="consignorType" height="500">委托人分类查询</a>	
	        </p>
			<p>
				<label>客户办案人：</label>
				<input name="casecontact" type="text" size="30" value="<%=caseInfoImpl.getCasecontact() == null ? "":caseInfoImpl.getCasecontact() %>" />
			</p>
		    <p class="a">
				<label>委托人：</label>
				<input type="hidden" name="orgLookup.oid" value="<%=caseInfoImpl.getConsignorid()==null ? "":caseInfoImpl.getConsignorid() %>" />
				<input class="required textInput valid" type="text" id ="names" size="23" readonly="readonly" onclick="check()" lookupgroup="orgLookup" name="orgLookup.names" autocomplete="off" value="<%= caseInfoImpl.getConsignorsn()==null ? "":caseInfoImpl.getConsignorsn()%> "/></input>
					<a class="btnLook" id="looks"  href="<%=baseUrl %>/client/consignor/search?st={st}" warn="请选择委托人分类" lookupgroup="orgLookup" height="500">委托人</a>			
			</p>
			<p>
				<label>客户案号：</label>
				<input name="academynum" type="text" size="30" value="<%= caseInfoImpl.getAcademynum()==null ? "":caseInfoImpl.getAcademynum() %>" />
			</p>
			<p>
				<label>委托人全称：</label>
				<input name="orgLookup.name" type="text" id="name" size="30"  readonly="readonly" value="<%=caseInfoImpl.getConsignorname()==null ? "":caseInfoImpl.getConsignorname()%>"/>
			</p>
			<p>
				<label>检验公司：</label>
				<input name="checkcompany" type="text" size="30" value="<%= caseInfoImpl.getCheckcompany() == null ? "":caseInfoImpl.getCheckcompany() %>" />
			</p>
			<p>
				<label>律师行：</label>
				<input name="barristers" type="text" size="30" value="<%= caseInfoImpl.getBarristers()==null ? "":caseInfoImpl.getBarristers() %>" />
			</p>
						
		</div>
		<div class="formBar">
			<ul>
						<li><a class="button" target="navTab" rel="guateeLiv" href="<%=baseUrl %>/passure?casestatus=0"  title="担保登记"><span>返回</span></a></li>
				</ul>
		</div>
	 </form>	 

</div>