<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<style type="text/css">
.pageFormContent label { float:left; width:130px; padding:0 5px; line-height:21px;}
</style>

<div class="pageContent">
<form id="searchandcount" method="post" action="<%=baseUrl %>/searchcount/standardconditiont" class="pageForm required-validate" onsubmit="return iframeCallback(this,navTabAjaxDone);">
	<div class="pageFormContent" layoutH="56">
	<input type="hidden" name="forwardUrl" id="forwardUrl" value="<%=baseUrl%>/ShowReport.wx?PAGEID={id}&condition={con}"/>  	
	<p>
		<label>开始时间：</label> <input type="text" name="startdate1" id="startdate1" class="date" onblur="checkdate(this)" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
	</p>
	<p>
		<label>结束时间：</label> <input type="text" name="enddate1" id="enddate1" class="date" onblur="checkdate(this)" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
	</p>
	<p>
		<label>时间类型1：</label>
		<select name="timetype1" class="combox" id="timetype1" >
		<option value="0">请选择</option>
					<c:forEach var="ct" items="${timetype}">
			     		<option value="${fn:trim(ct['dictid']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
		 </select>
	</p>
	<p>
		<label>案件性质: </label>
		<select class="combox required" id="casetypename" name="casetypename" >
		<option value="0">请选择</option>
					<c:forEach var="ct" items="${casetype}">
			     		<option value="${ct['dictid'] }" >${fn:trim(ct['backup1']) }</option>
			    	</c:forEach>
		</select>
		<input  value="casetypename" type="radio" name="groupname"/>
	</p>
	<p>
		<label>开始时间：</label> <input type="text" name="startdate2" id="startdate2" class="date" onblur="checkdate(this)" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
	</p>
	<p>
		<label>结束时间：</label> <input type="text" name="enddate2" id="enddate2" class="date" onblur="checkdate(this)" size="30" /><a class="inputDateButton" href="javascript:;">选择</a>
	</p>
	<p>
		<label>时间类型2：</label>
		<select name="timetype2" class="combox" id="timetype2" >
		<option value="0">请选择</option>
					<c:forEach var="ct" items="${timetype}">
			     		<option value="${fn:trim(ct['dictid']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
		 </select>
	</p>
	<p>
		<label>委托人分类：</label> 
		<input type="hidden" name="consignorType.SortNo" id="st" /> 
		<input class="textInput valid" type="text" id="sort" size="30" readonly="readonly" lookupgroup="consignorType" name="consignorType.DictName" /> 
		<a class="btnLook" href="<%=baseUrl%>/client/consignor/sortsearch" onclick="clearwww('names','ns');" lookupgroup="consignorType" height="500">委托人分类查询</a>
	    <input name="groupname" type="radio"  value="consignortypename"/>
	</p>
	<p class="a">
		<label>委托人名称：</label> 
		<input type="hidden" id="names" name="orgLookup.oid"/> 
		<input class="textInput valid" type="text" size="30" readonly="readonly" id="ns" lookupgroup="orgLookup" name="orgLookup.names" autocomplete="off" /></input>
		<a class="btnLook" id="looks" href="<%=baseUrl%>/client/consignor/search?st={st}" warn="请选择委托人分类" lookupgroup="orgLookup" height="500">委托人</a>
	    <input  value="consignorsn" type="radio" name="groupname"/>
	</p>
	<p>
		<label>船名：</label> <input type="text" id="sp" name="sp" size="30" />
	</p>
	<p>
		<label>案发口岸：
		</label> <input type="hidden" id="accidentport" name="accidentport.oid" />
		<input class="textInput valid" type="text" size="30"  lookupgroup="accidentport" name="accidentport.paramtexta" autocomplete="off"></input> 
		<a class="btnLook" href="<%=baseUrl%>/params/search" lookupGroup="accidentport" height="500">事发口岸查询</a>
	    <input  value="accidentport" type="radio" name="groupname"/>
	</p>
	<p>
		<label>主办机构：</label>
		<input type="hidden" id ="zorg" name="orgLookupf.id" />
		<input class="textInput valid" size="30" readonly="readonly" type="text" lookupgroup="orgLookupf" name="orgLookupf.extend1" autocomplete="off" /></input>
		<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch"  onclick="clearwww('zuser','zname');" lookupgroup="orgLookupf" height="500">主办机构</a>			
		<input name="groupname" type="radio"  value="oraname" checked="true" />	
	</p>
	<p>
		<label>主办人：</label>
		<input type="hidden" id ="zuser" name="userLookupf.id" value="" />
		<input class="textInput valid" type="text" id="zname" size="30" readonly="readonly" lookupgroup="userLookupf" name="userLookupf.name" autocomplete="off" /></input>
		<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/user/userSearch?orgCode={zorg}" lookupgroup="userLookupf" height="500">主办人</a>			
        <input  value="username" type="radio" name="groupname"/>	
	</p>
	<p>
		<label>协办机构：</label>
		<input type="hidden" id ="xorg" name="orgLookups.id" />
		<input class="textInput valid" size="30" readonly="readonly" type="text" lookupgroup="orgLookups" name="orgLookups.extend1" autocomplete="off" /></input>
		<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/org/orgSearch" onclick="clearwww('xuser','xname');" lookupgroup="orgLookups" height="500">协办机构</a>			
			
	</p>
	<p>
		<label>协办人：</label>
		<input type="hidden" id ="xuser" name="userLookups.id" value="" />
		<input class="textInput valid" type="text" id="xname" size="30" readonly="readonly" lookupgroup="userLookups" name="userLookups.name" autocomplete="off" /></input>
		<a class="btnLook" id="looks"  href="<%=baseUrl %>/system/user/userSearch?orgCode={xorg}" lookupgroup="userLookups" height="500">协办人</a>			
	</p>
	<p>
		<label>第三方：</label>
		<input type="hidden" id="third" name="third.oid" value="" />
		<input  class="textInput valid" type="text" size="30" lookupgroup="third" readonly="readonly" suggestFields="oid,nameen" name="third.namecn" /></input>
		<a class="btnLook" href="<%=baseUrl %>/client/thirdparty/thirdsearch" lookupGroup="third" >第三方</a>	
	    <input  value="third" type="radio" name="groupname"/>
	</p>
	<p>
		<label>反担保人: </label>
		<input type="hidden" id="rewarranter" name="rewarranter.oid" value="" />
		<input class="textInput valid" type="text" size="30" lookupgroup="rewarranter" value="" readonly="readonly" name="rewarranter.names" autocomplete="off"></input>
		<a class="btnLook" href="<%=baseUrl %>/client/rewarranter/rewarrantersearch" lookupGroup="rewarranter">反担保人查询</a>	
	    <input  value="rewarranter" type="radio" name="groupname"/>
	</p>
	<p>
		<label>是否发账：</label> 
		<select class="combox required" id="accflag" name="billstatus">
						<option value="0">请选择</option>
						<option value="1">已发账</option>
						<option value="2">未发账</option>
		</select>
	</p>
	<p>
		<label>是否到账：</label> 
		<select class="combox required" id="arrflag" name="arrstatus">
						<option value="0">请选择</option>
						<option value="1">已到账</option>
						<option value="2">未到账</option>
		</select>
	</p>
	<p>
	   <label>案件收入金额区间：</label>
	   <input type="text" id="money1" name="money1" size="30" value="" class="text" />
	</p>
	<p>
	   <label>—————</label>
	   <input type="text" id="money2" name="money2" size="30" />
	</p>
	<p>
		<label>反担保人评级: </label> 
		<input type="hidden" name="propertyname.DictId">
		<input class="textInput valid" id="propertyname" type="text" size="30" lookupgroup="propertyname" readonly="readonly" name="propertyname.DictName" autocomplete="off"></input> 
		<a class="btnLook" href="<%=baseUrl%>/client/rewarranter/property" lookupGroup="propertyname">反担保人评级查询</a>
	    <input  value="property" type="radio" name="groupname"/>
	</p>
	<p>
		<label>担保币种：</label> 
		 <select name="currency" id="currency" class="combox required" selected="selected" >
		 <option value="0">请选择</option>
					<c:forEach var="ct" items="${currency}">
			     		<option value="${fn:trim(ct['dictname']) }" >${fn:trim(ct['dictname']) }</option>
			    	</c:forEach>
		 </select>
	</p>
	<p>
		<label>反担保人所在地区：</label> <input type="text" id="country" name="country" size="30" />
	</p>
	<p class="a">
		<label>委托人归属地区：</label> 
		<input class="textInput valid" id="warea" type="text" size="30" readonly="readonly" lookupgroup="warea" name="warea.area" autocomplete="off" /></input>
		<a class="btnLook" id="looks" href="<%=baseUrl%>/client/consignor/areasearch"  onclick="clearwww('wcountry','wcountry');" lookupgroup="warea" height="500">委托人归属地区域</a>
	    <!-- <input  value="warea" type="radio" name="groupname"/> -->
	</p>
	<p>
		<label>委托人归属国家：</label> 
		<input class="textInput valid" type="text" id="wcountry" size="30" readonly="readonly" lookupgroup="wcountry" name="wcountry.country" /> 
		<a class="btnLook" href="<%=baseUrl%>/client/consignor/countrysearch?warea={warea}" warn="请选择委托人归属地区域"  lookupgroup="wcountry" height="500">委托人归属地国家查询</a>
	   <!--  <input name="groupname" type="radio"  value="wcountry"/> -->
	</p>	
	<p>
		<label>收件人：</label> <input type="text" id="receiver" name="receiver" size="30" />
	</p>
	<p>
		<label>寄件人：</label> <input type="text" id="sender" name="sender" size="30" />
	</p>
	<p>
		<label>快递单号：</label> <input type="text" id="trackingNumber" name="trackingNumber" size="30" />
	</p>
	<p>
		<a class="button" rel="searchLav" target="navTab" href="<%=baseUrl %>/searchcount/search" title="综合查询" ><span>重置</span></a>
	    <!--<input type="reset" name="reset" value="重置" > -->
	</p>
    </div>
    <div class="formBar">
		<ul>
			<li><a class="button"  onclick="zpost('casesearch','zh01');"><span>案件查询</span></a></li>
			<li><a class="button"  onclick="zpost('casecount','zh02');"><span>案件统计</span></a></li>
			<li><a class="button"  onclick="zpost('billcount','zh03');"><span>账单统计</span></a></li>
			<li><a class="button"  onclick="zpost('thirdbill','zh04');"><span>第三方账务</span></a></li>
			<li><a class="button"  onclick="zpost('thirddetail','zh05');"><span>第三方明细</span></a></li>
			<li><a class="button"  onclick="zpost('passureinfosbill','zh06');"><span>担保账务</span></a></li>
			<li><a class="button"  onclick="zpost('passureinfosdetail','zh07');"><span>担保明细</span></a></li>
			<li><a class="button"  onclick="zpost('billincome','zh08');"><span>收入**美元及以上账单统计</span></a></li>
			<li><a class="button"  onclick="zpost('area','zh09');"><span>全球地区性市场份额</span></a></li>
			
<!-- 		<li><a class="button" target="navTab" rel="casesearch" external="true" onclick="zhsearch('casesearch','zh01');"><span>案件查询</span></a></li>
			<li><a class="button" target="navTab" rel="casecount" external="true" onclick="zhsearch('casecount','zh02');"> <span>案件统计</span></a></li>
			<li><a class="button" target="navTab" rel="billcount" external="true" onclick="zhsearch('billcount','zh03');"> <span>账单统计</span></a></li>
			<li><a class="button" target="navTab" rel="thirdbill" external="true" onclick="zhsearch('thirdbill','zh04');"> <span>第三方账务</span></a></li>
			<li><a class="button" target="navTab" rel="thirddetail" external="true" onclick="zhsearch('thirddetail','zh05');"> <span>第三方明细</span></a></li>
			<li><a class="button" target="navTab" rel="assurebill" external="true" onclick="zhsearch('passureinfosbill','zh06');"> <span>担保账务</span></a></li>
			<li><a class="button" target="navTab" rel="assuredetail" external="true" onclick="zhsearch('passureinfosdetail','zh07');"> <span>担保明细</span></a></li>	
			<li><a class="button" target="navTab" rel="billincome" external="true" onclick="zhsearch('billincome','zh08');"> <span>收入**美元及以上账单统计</span></a></li>
			<li><a class="button" target="navTab" rel="area" external="true" onclick="zhsearch('area','zh09');"> <span>全球地区性市场份额</span></a></li>			
 -->		</ul>
	</div>
    </form>
</div>
		
<script type="text/javascript">

//使用post方式提交表单

function zpost(flag,report){
	var searchform=$('#searchandcount').serialize();
	var url = "<%=baseUrl %>/searchcount/searchcondition?searchflag="+flag;
	$.post(url,searchform,
			function(data){
			        var url1 = "<%=baseUrl%>/ShowReport.wx?PAGEID="+report+"&condition="+data.result+"&group="+data.group+"&gid="+data.gid;
			    	window.open(url1);
			},'json');
}

  function zhsearch(flag,report){
	  	 var path= "<%=baseUrl %>/searchcount/searchcondition?navTabId="+flag+"&callbackType=forward"+"&searchflag="+flag+"&report="+report ;

 	 $("#searchandcount").attr("action", path);
	 $('#searchandcount').submit(); 
 
 }
  
 function clearwww(ax,bx){
	  $("#"+ax).val("");
	  $("#"+bx).val("");
 }
 
 function whid(val){
	 $("#wcountry").val("");
 }

  <%--  function casesearch(o,searchflag,pageid){
	   
	  //获取所有input type为text的值 
	  var startdate = $('#startdate').val();
	  var enddate = $('#enddate').val();
	  var timetype = $('#timetype').val();
	  var accstart = $('#accstart').val();
	  var accend = $('#accend').val();
	  var casetypename = $('#casetypename').val();
	  var sort = $('#sort').val();
	  var names = $('#names').val();
	  var sp = $('#sp').val();
	  var accidentport = $('#accidentport').val();
	  var zorg = $('#zorg').val();
	  var zuser = $('#zuser').val();
	  var xorg = $('#xorg').val();
	  var xuser = $('#xuser').val();
	  var third = $('#third').val();
	  var rewarranter = $('#rewarranter').val();
	  var accflag = $('#accflag').val();	  
	  var arrflag = $('#arrflag').val();
      var money1 = $('#money1').val();
      var money2 = $('#money2').val();
	  var propertyname = $('#propertyname').val();
	  var currency = $('#currency').val();
	  var country = $('#country').val();
	  var warea = $('#warea').val();
	  var wcountry = $('#wcountry').val();
	  var receiver = $('#receiver').val();
	  var sender = $('#sender').val();
	  var trackingNumber = $('#trackingNumber').val();
	    
	  var groupid = "";
	  var groupname = "";
	  
	  //获取单选框的值 
	  var radio = $('input[name="groupname"]:checked').val();
	  if("casetypename"==radio){
		// 按案件性质分组
		  groupid = "a.casetypename";
		  groupname = "a.casetypename";
	  }else if("consignortypename"==radio || "third"==radio || "rewarranter"==radio || "property"==radio){
 		   if(searchflag!="passureinfosbill" || searchflag!="passureinfosdetail"){ 
 				// 按委托人分类分组
			  groupid = "a.consignortypename";
			  groupname = "a.consignortypename";
 		   }else if("property"==radio){
				  groupid = "b.rewarranttype";
				  groupname = "b.rewarranttype";
			  } 
	  }else if("consignorsn"==radio){
		// 按委托人名称（简称）分组
		  groupid = "a.consignorid";
		  groupname = "a.consignorsn";
	  }else if("accidentport"==radio){
		// 按案发口岸分组
		  groupid = "a.accidentportid";
		  groupname = "a.accidentport";
	  }else if("oraname"==radio){
		// 按主办机构分组
		  groupid = "a.orgcode";
		  groupname = "a.oraname";
	  }else if("username"==radio){
		// 按主办人员
		  groupid = "a.userid";
		  groupname = "a.username";
	  }
	  alert("groupid:"+groupid+"--groupname:"+groupname);	  
	  
      //var b = "<%=baseUrl%>/searchcount/searchcondition";
	  var url = "<%=baseUrl%>/searchcount/searchcondition?searchflag="+searchflag+"&radio="+radio;

 var url = "<%=baseUrl%>/ShowReport.wx?PAGEID="+pageid+"&searchflag="+searchflag+"&startdate="+startdate
 +"&enddate="+enddate+"&timetype="+timetype+"&accstart="+accstart+"&accend="+accend+"&casetypename="+casetypename
 +"&sort="+sort+"&names="+names+"&shipname="+sp+"&accidentport="+accidentport+"&zorg="+zorg+"&zuser="+zuser
 +"&xorg="+xorg+"&xuser="+xuser+"&third="+third+"&rewarranter="+rewarranter+"&accflag="+accflag
 +"&arrflag="+arrflag+"&money1="+money1+"&money2="+money2+"&propertyname="+propertyname+"&currency="+currency
 +"&warea="+warea+"&wcountry="+wcountry+"&receiver="+receiver+"&sender="+sender+"&trackingNumber="+trackingNumber
 +"&gid="+groupid+"&gname="+groupname ;
 
 if(""!=startdate || ""!=enddate){
			if(""!=startdate && ""!=enddate){
				if("0"==timetype){
					alert("请选择时间类型1！");
				}else{
					alert(url);
					o.href = url + "";
					 // navTab.openTab(flag, url, { title:name, fresh:true, data:{"startdate":startdate,"enddate":enddate,"timetype":timetype,"casetypename":casetypename,"accstart":accstart,"accend":accend,"sort":sort,"names":names,"sp":sp,"accidentport":accidentport,"zorg":zorg,"zuser":zuser,"xorg":xorg,"xuser":xuser,"third":third,"rewarranter":rewarranter,"billstatus":billstatus,"propertyname":propertyname,"currency":currency,"receiver":receiver,"sender":sender,"trackingNumber":trackingNumber  } });
				}
			}else {
				alert("请选完整时间段！");
			}
	  }else{
		  if("0"!=timetype){
				alert("请选择完整时间段2！");
			}else{
				alert(url);
				o.href = url ;
				 // navTab.openTab(flag, url, { title:name, fresh:true, data:{"startdate":startdate,"enddate":enddate,"timetype":timetype,"casetypename":casetypename,"accstart":accstart,"accend":accend,"sort":sort,"names":names,"sp":sp,"accidentport":accidentport,"zorg":zorg,"zuser":zuser,"xorg":xorg,"xuser":xuser,"third":third,"rewarranter":rewarranter,"billstatus":billstatus,"propertyname":propertyname,"currency":currency,"receiver":receiver,"sender":sender,"trackingNumber":trackingNumber  } });
			}
	  }	
} --%>
  
</script>
