<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent">
<form method="post" action="<%=baseUrl %>/processDef/insertActivityDef" class="pageForm required-validate" onsubmit="return validateCallback(this,navTabAjaxDone);">
	<input type="hidden" name="processId" value="${ processId }">
	<input type="hidden" name="id" value="${ activityDef.id }">
	<input type="hidden" name="preActivity" value="${ activityDef.preActivity }">
	<div class="pageContent sortDrag" selector="h1" layoutH="37">
	<div class="panel" defH="300">
	<h1>流程节点信息</h1>
	<div class="pageFormContent">
		<p class="a">
			<label>节点名称： </label>
			<input type="text" name="name" class="required" value="${activityDef.name }"/>
		</p>		
		<p>
			<label>触发方式： </label>
			<select class="combox" name="startType"  id="startType">
				    <option value="1" ${activityDef.startType=='1'?"selected='selected'":''}>直接启动</option>
				    <option value="2" ${activityDef.startType=='2'?"selected='selected'":''}>审批金额判断</option>
	        </select>
		</p>
		<p>
			<label>审批金额下限（元）: </label>
			<input type="text" name="param1" value="${activityDef.param1 }" class="number" min="1"/>
		</p>
		<dl class="nowrap">
			<dt>节点描述： </dt>
			<dd>
			<textarea name="desc" cols="55" rows="3">${activityDef.desc }</textarea>
			</dd>
		</dl>
		<p>
			<label>参与者类型：</label>
		   <select class="combox" name="type" onChange="changeValue(this)">
		   	   <option value="" ${type==''?"selected='selected'":''}>---请选择---</option>
			   <option value="1" ${type=='1'?"selected='selected'":''}>角色</option>
			   <option value="2" ${type=='2'?"selected='selected'":''}>用户</option>
		  </select>
		</p>
		<p>
			<label>参与者角色层级：</label>
		   <select class="combox" name="param2" >
			   <option value="1" ${activityDef.param2=='1'?"selected='selected'":''}>总公司</option>
			   <option value="2" ${activityDef.param2=='2'?"selected='selected'":''}>分支公司</option>
		  </select>
		</p>
		<c:choose>
          <c:when test="${type=='1' || type == null}">
		   	<p class="rolep">
				<label>角色： </label>
				<input type="hidden" name="orgLookup.id" value="${roleid}"/>
				<input type="text"  name="orgLookup.roleName" value="${ rolevalue }" readOnly/>
				<a class="btnLook" href="<%=baseUrl %>/processDef/participantValue?type=1" lookupGroup="orgLookup">角色查询</a>		
		  	</p>
		  </c:when>
		  <c:otherwise>
		   	<p class="rolep" style="display:none">
				<label>角色： </label>
				<input type="hidden" name="orgLookup.id" value="${roleid}"/>
				<input type="text"  name="orgLookup.roleName" value="${ rolevalue }" readOnly/>
				<a class="btnLook" href="<%=baseUrl %>/processDef/participantValue?type=1" lookupGroup="orgLookup">角色查询</a>		
		   	</p>
		  </c:otherwise>
		  
		  </c:choose>
		 <c:choose>
            <c:when test="${type=='2'}">
  		    <p class="userp">
			<label>用户： </label>
			<input type="hidden" name="orgLookup.userid" value="${userid}"/>
			<input type="text"  name="orgLookup.userName" value="${ uservalue }" readOnly/>
			<a class="btnLook"href="<%=baseUrl %>/processDef/participantValue?type=2" lookupGroup="orgLookup">用户查询</a>		
		   </p>
		   </c:when>
		   <c:otherwise>
		    <p class="userp" style="display:none">
			<label>用户： </label>
			<input type="hidden" name="orgLookup.userid" value="${userid}"/>
			<input type="text"  name="orgLookup.userName" value="${ uservalue }" readOnly/>
			<a class="btnLook"href="<%=baseUrl %>/processDef/participantValue?type=2" lookupGroup="orgLookup">用户查询</a>		
		   </p>
		   </c:otherwise>
		   </c:choose>
		</div>
	</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">保存</button></div></div></li>
			<li><a class="button" target="navTab" href="<%=baseUrl %>/processDef/backList?processId=${ processId }" title="流程节点信息"><span>返回</span></a></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div></li>
		</ul>
	</div>
</form>
<script type="text/javascript">
  function changeValue(val){
	  if(val.value==1){
		  $(".rolep").show();
		  $(".userp").hide();
	  }else{
		  $(".userp").show();
		  $(".rolep").hide();
	  }
  }
</script>
</div>
