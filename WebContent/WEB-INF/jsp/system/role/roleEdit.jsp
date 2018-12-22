<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<div class="pageContent sortDrag" selector="h1" layoutH="1">
	
<form method="post" action="<%=baseUrl %>/system/role/update?navTabId=roleMainList&callbackType=closeCurrent" class="pageForm required-validate" onsubmit="return validateCallback(this, navTabAjaxDone);">
	<input type="hidden" id="selectMenuArray1" name="selectMenuArray1">
	<input type="hidden" id="id" name="id" value="${role.id}">
	<div class="panel collapse" >
		<h1>角色基本信息</h1>
		<div class="pageContent">
			<div  class="pageFormContent">
				<p>
					<label>角色名称: </label>
					<input type="text" id="roleName" name="roleName" value="${role.roleName}" class="required" onchange="checkRoleName(this.value)" />
				</p>
				<p>
					<label>角色状态：</label>
					<select name="roleStatus" >				
						<c:forEach var="item" items="${statusList}">
							<option value="${item.code}" ${item.code eq role.roleStatus.code ? 'selected="selected"' : ''}>${item.desc}</option>
						</c:forEach>
					</select>
				</p>
			</div>
		</div>			
	</div>
	<div class="divider"></div>
	<div class="panel collapse" >
		<h1>选择角色菜单</h1>
		<div id="menuCheckDiv1">
		
		</div>
	</div>
	<div class="formBar">
		<ul>
			<li><div class="buttonActive"><div class="buttonContent"><button type="submit">提交</button></div></div></li>
			<li><div class="button"><div class="buttonContent"><button type="button" class="close">取消</button></div></div></li>
		</ul>
	</div>
</form>
	
</div>
<script type="text/javascript">
var tResult="";
$(document).ready(function() {
	var menuList=eval('('+'${menuList}'+')');
	var roleMenuList=eval('('+'${roleMenuList}'+')');
	
	var menuUl=$('#menuCheckDiv1');
	
	var parentId=0;
	var endChildMenu = "</fieldset>";
	var menuStr="";
	//menuStr+="<ul class='tree treeFolder treeCheck expand' oncheck='checkSelect'>";
	
	for(var i=0;i<menuList.length;i++)
	{
		var menuId = menuList[i].menu_id;
				
		if(parentId==0)
		{
			parentId=menuList[i].parent_id;

			var parentMenu="<fieldset><legend>"+menuList[i].parent_name+"</legend>";			
			menuStr +=parentMenu;
		}
		else if(parentId!=menuList[i].parent_id)
		{
			menuStr +=endChildMenu;
			
			parentId=menuList[i].parent_id;
			
			var parentMenu="<fieldset><legend>"+menuList[i].parent_name+"</legend>";			
			menuStr +=parentMenu;
			
		}
		
		var flag=false;
		var childMenu="";
		
		for(var j=0;j<roleMenuList.length;j++)
		{
			if( menuId == roleMenuList[j].menu_id)
			{
				flag = true;
				break;
			}
		}
		
		if(flag)
		{
			childMenu ="<label><input type='checkbox' id='roleMenu1' checked='true' onclick='checkSelect();' name='roleMenu1' value='"+menuList[i].menu_id+"'>"+menuList[i].menu_name+"</label>";
		}
		else
		{
			childMenu ="<label><input type='checkbox' id='roleMenu1' onclick='checkSelect();' name='roleMenu1' value='"+menuList[i].menu_id+"'>"+menuList[i].menu_name+"</label>";
		}
		
		
		menuStr +=childMenu;
		
		if((i+1)==menuList.length)
		{
			menuStr +=endChildMenu;
		}
			
	}
	
	menuUl.append(menuStr);
});


/**
 * 校验系统角色名，不允许重复
 */
function checkRoleName(roleName){
    
	$.post('<%=baseUrl %>/system/role/checkRoleName',
            {'roleName':roleName,'roleId':'0'},
       function(data){
           if(data==false){
               alertMsg.error("已存在相同的用户登录名，请重新录入登录名！");
               $("#roleName").val("");
           }
      } ,'json');
    
} 

function checkSelect()
{
	var sign=0;
	var selectMenuArray ="";
	var inputs = document.getElementsByTagName('input');//获取所有的input标签对象。
	for(var i=0;i<inputs.length;i++)
	{
	    var obj = inputs[i];
	    if(obj.type=='checkbox')
	    {
	     	if(obj.checked==true)
	     	{
	      		sign=1;
	      		
	      		selectMenuArray+=obj.value+",";
	      	}
	    } 
	}
	
	if(sign != 1)
	{
		alertMsg.error("请选择角色菜单！");		
		return false;
	}
	else
	{
		$("#selectMenuArray1").val(selectMenuArray);
		return true;
	}	
}

</script>
