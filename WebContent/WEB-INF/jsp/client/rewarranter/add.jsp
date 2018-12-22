<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/client/rewarranter/insert?navTabId=rewarranterLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">

		<p>
			<label>全称: </label>
			<input type="text" name="name" class="required"/>
		</p>
		<p>
			<label>简称: </label>
			<input type="text" name="names" class="required"/>
		</p>
		<p>
			<label>评级: </label>
			<input type="hidden" name="orgLookup.DictId" >
			<input class="required textInput valid" type="text" lookupgroup="orgLookup" readonly="readonly" name="orgLookup.DictName" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/rewarranter/property" lookupGroup="orgLookup">反担保人评级查询</a>	
		</p>
		<p>
			<label>地址: </label>
			<input type="text" name="address" class="required"/>
		</p>
		<p>
			<label>国家:  </label>
			<input type="text" name="country" />
		</p>
		<p>
			<label>地区:  </label>
			<input type="text" name="area" size="30" />
		</p>
		<p>
		   <label>是否添加到委托人</label>
		   <input type="checkbox" id="box" name="flag" value="1" onclick="hidden()"/>
		</p>
        <p class="reshow" style="display:none">
			<label>类型：</label>
			<input class="textInput valid" type="text" lookupgroup="consignortype" readonly="readonly" name="consignortype.DictName" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/consignor/sortsearch" lookupGroup="consignortype" height="500">委托人分类查询</a>	
	    </p>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
</div>

<script type="text/javascript"> 
  function hidden(){
	  if($("#box").attr("checked")=="checked"){
	    $(".reshow").show();
	  }else{
		 $(".reshow").hide();
	  }
  }
</script>