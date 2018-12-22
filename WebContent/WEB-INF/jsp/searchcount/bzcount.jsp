<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/searchcount/standardconditiont" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">  
        <p>
		   <label>开始时间：</label> <input type="text" name="startdate" id="startdate" class="date" onblur="checkdate(this)" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
	    </p>
	    <p>
		   <label>结束时间：</label> <input type="text" name="enddate" id="enddate" class="date" onblur="checkdate(this)"  size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
	    </p>
	    <p>
		<label>时间类型：</label>
		    <select name="bztimetype" class="combox" id="bztimetype" >
		       <option value="0">请选择</option>
					<c:forEach var="ct" items="${bztimetype}">
			     		<option value="${fn:trim(ct['dictid']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
		    </select>
	    </p>
<%-- 		<p>
			<label>担保报表: </label>
			<select name="passurereport" class="combox" id="passurereport" >
		       <option value="0">请选择</option>
					<c:forEach var="ct" items="${report}">
			     		<option value="${fn:trim(ct['dictid']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
		    </select>
		</p> --%>
		<p>
				<label>机构：</label>
				<input type="hidden" id="orgCode" name="orgLookup.orgCode" value="" />
				<input class="required textInput valid" size="30" readonly="readonly" type="text" id ="orgName" lookupgroup="orgLookup" name="orgLookup.extend1" autocomplete="off"  value="" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch?orgType=C" onclick="hid(this);" lookupgroup="orgLookup" height="500">协办机构</a>			
			
		</p>
		<p>
				<label>人员：</label>
				<input type="hidden" id="usercode" name="userLookup.id" value="" />
				<input class="required textInput valid" type="text" id ="username" size="30" readonly="readonly" lookupgroup="userLookup" name="userLookup.name" autocomplete="off" value="" /></input>
				<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/user/userSearch?orgCode={orgCode}" warn="请先选择机构" lookupgroup="userLookup" height="500">协办人</a>			
		</p>
		<p>
			<a class="button"  rel="consignorcasecompare" external="true" onclick="tack('bz01');" ><span>委托人案件数同期比较</span></a>
		</p>
		<p>
			<a class="button"  rel="consignorincomecompare" external="true" onclick="tack('bz02');" ><span>委托人收入同期比较</span></a>
		</p>
		<p>
			<a class="button"  rel="jgajassurelist" external="true" onclick="tack('bz10');" ><span>机构案件数同期比较</span></a>
		</p>
		<p>
			<a class="button"  rel="jgsrassurelist" external="true" onclick="tack('bz11');" ><span>机构收入同期比较</span></a>
		</p>
		<p>
			<a class="button"  rel="ajnumberassurelist" external="true" onclick="tack('bz15');" ><span>案件性质案件数同期比较</span></a>
		</p>
		<p>
			<a class="button"  rel="ajmoneyassurelist" hexternal="true" onclick="tack('bz16');" ><span>案件性质收入同期比较</span></a>
		</p>

		<p>
			<a class="button"  rel="bz17" external="true" onclick="tack('bz17');" ><span>服务费分段汇总</span></a>
		</p>

		<p>
			<a class="button"  rel="provideassurelist" external="true" onclick="tack('bz04');" ><span>出具担保明细表</span></a>
		</p>
		<p>
			<a class="button"  rel="createassurelist" external="true" onclick="tack('bz03');" ><span>生成现有效担保报表</span></a>
		</p>
		<p>
			<a class="button"  rel="repealeassurelist" external="true" onclick="tack('bz05');" ><span>撤销担保明细表</span></a>
		</p>
		<p>
			<a class="button"  rel="cjdbassurelist" external="true" onclick="tack('bz12');" ><span>出具担保评级汇总</span></a>
		</p>
		<p>
			<a class="button"  rel="bz13" external="true" onclick="tack('bz13');" ><span>撤销担保评级汇总</span></a>
		</p>		
		<p>
			<a class="button"  rel="bz14" external="true" onclick="tack('bz14');" ><span>有效担保评级汇总</span></a>
		</p>
		<p>
			<a class="button"  rel="bz18" external="true" onclick="tack('bz18');" ><span>出具担保金额分段汇总</span></a>
		</p>
		<p>
			<a class="button"  rel="bz19" external="true" onclick="tack('bz19');" ><span>撤销担保金额分段汇总</span></a>
		</p>
		<p>
			<a class="button"  rel="bz20" external="true" onclick="tack('bz20');" ><span>有效担保金额分段汇总</span></a>
		</p>
		<p>
			<a class="button"  rel="enureassurelist" external="true" onclick="tack('bz07');" ><span>有效担保中金额居前五位的明细</span></a>
		</p>
		<p>
			<a class="button"  rel="pjassurelist" external="true" onclick="tack('bz09');" ><span>现有效担保中按标普评级分类汇总及比例</span></a>
		</p>
		<p>
			<a class="button"  rel="feeassurelist" external="true" onclick="tack('bz08');" ><span>担保手续费到账统计表</span></a>
		</p>			
		<p>
			<a class="button"  rel="reportassurelist" external="true" onclick="tack('bz06');" ><span>上报集团的担保明细表</span></a>
		</p>		</div>
</form>
</div>

<script type="text/javascript">
function tack(x){
  var par="<%=request.getContextPath()%>";
  var a = $('#startdate').val(); 
  var b = $('#enddate').val();
  var c = $('#bztimetype').val();
  var d = $('#orgCode').val();
  var e = $('#usercode').val();
  
  //var a = window.document.getElementById(startdate).value; 
  //alert(a);
  
  
  var str = "";
  var a1 = "";
  var b1 = "";

  if(a!=null&&a!=""){
	  var arra = a.split("-");
	  var ax1 = arra[0];
	  var ax2 = arra[1];
	  var ax3 = arra[2];
	      a1 = ax1-1+"-"+ax2+"-"+ax3;
  }
  
  if(b!=null&&b!=""){
	  var arrb = b.split("-");
	  var bx1 = arrb[0];
	  var bx2 = arrb[1];
	  var bx3 = arrb[2];
	      b1 = bx1-1+"-"+bx2+"-"+bx3;
  }

  if(x =='bz17' || x == 'bz02' || x=='bz11' || x=='bz16'){
	  if(c==4){
		  str = "&arrstartdate="+a+"&arrstartdate1="+a1+"&arrenddate="+b+"&arrenddate1="+b1+"&orgCode="+d+"&usercode="+e+"&path="+par;
	  }else{
		  str = "&accstartdate="+a+"&accstartdate1="+a1+"&accenddate="+b+"&accenddate1="+b1+"&orgCode="+d+"&usercode="+e+"&path="+par;
	  }
  }else if(x=='bz01' || x=='bz10' || x=='bz15'){
	  if(c==2){
		  str = "&afstartdate="+a+"&afstartdate1="+a1+"&afenddate="+b+"&afenddate1="+b1+"&orgCode="+d+"&usercode="+e+"&path="+par;
	  }else{
		  str = "&setstartdate="+a+"&setstartdate1="+a1+"&setenddate="+b+"&setenddate1="+b1+"&orgCode="+d+"&usercode="+e+"&path="+par;
	  }
  }
  else{
	  str = "&startdate="+a+"&enddate="+b+"&bztimetype="+c+"&orgCode="+d+"&usercode="+e+"&path="+par;
  }
    var url = "<%=baseUrl %>/ShowReport.wx?PAGEID="+ x + str ;
    window.open(url);
<%-- 	  o.href = "<%=baseUrl %>/ShowReport.wx?PAGEID="+ x + str ;--%>
	  return true; 

}
</script>