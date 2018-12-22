<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<style type="text/css">
.pageFormContent label { float:left; width:150px; padding:0 5px; line-height:21px;}
</style>

<div class="pageContent">
<form method="post" action="<%=baseUrl %>/client/consignor/insert?navTabId=consignorLav&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this,dialogAjaxDone);">
	<div class="pageFormContent" layoutH="56">


		<p>
			<label>全称: </label>
			<input type="text" name="name" size="30" class="required"/>
		</p>
		<p>
			<label>简称: </label>
			<input type="text" name="names" size="30" class="required"/>
		</p>
		<p>
			<label>地址: </label>
			<input type="text" name="address" size="30" class="required"/>
		</p>
		<p>
			<label>国家:  </label>
			<input type="text" name="country" size="30" />
		</p>
		<p>
			<label>地区:  </label>
			<input type="text" name="area" size="30" />
		</p>
		<p>
			<label>类型：</label>
			<input class="required textInput valid" type="text" size="30" lookupgroup="orgLookup" readonly="readonly" name="orgLookup.DictName" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/consignor/sortsearch" lookupGroup="orgLookup" height="500">委托人分类查询</a>	
	    </p>
	    <p>
			<label>开户行: </label>
			<input type="text" name="accountcode" size="30" />
		</p>
		<p>
			<label>往来凭证科目: </label>
			<input type="text" name="currentcourse" size="30" />
		</p>
	    <p>
		   <label>是否添加到反担保人</label>
		   <input type="checkbox" id="box" name="flag" value="1" onclick="hidden()"/>
		</p>
		<p class="pjshow" style="display:none">
			<label>评级: </label>
			<input class="textInput valid" type="text" size="30" lookupgroup="rewarranter" readonly="readonly" name="rewarranter.DictName" autocomplete="off"></input>
			<a class="btnLook" href="<%=baseUrl %>/client/rewarranter/property" lookupGroup="rewarranter">反担保人评级查询</a>	
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
	    $(".pjshow").show();
	  }else{
		 $(".pjshow").hide();
	  }
  }
</script>
