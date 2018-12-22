<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>华泰保险经纪-海事业务系统</title>

<link href="<%=baseUrl%>/styles/dwz/themes/default/style.css" rel="stylesheet" type="text/css" />
<link href="<%=baseUrl%>/styles/dwz/themes/css/core.css" rel="stylesheet" type="text/css" />
<link href="<%=baseUrl%>/styles/dwz/themes/css/git_revise.css" rel="stylesheet" type="text/css" />

<!--[if IE]>
<link href="/styles/dwz/themes/css/ieHack.css" rel="stylesheet" type="text/css" />
<![endif]-->

<script src="<%=baseUrl%>/styles/dwz/js/speedup.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery-1.7.2.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.cookie.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.validate.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/jquery.bgiframe.js" type="text/javascript"></script>

<script src="<%=baseUrl%>/styles/dwz/js/dwz.min.js" type="text/javascript"></script>
<script src="<%=baseUrl%>/styles/dwz/js/dwz.regional.zh.js" type="text/javascript"></script>

<script type="text/javascript">
$(function(){	
	DWZ.init("<%=baseUrl%>/styles/dwz/dwz.frag.xml", {		
		loginUrl:"<%=baseUrl%>/login",	// 跳到登录页面
		pageInfo:{pageNum:"pageNum", numPerPage:"pageSize", orderField:"orderField", orderDirection:"orderDirection"}, 
		debug:false,	// 调试模式 【true|false】
		callback:function(){
			initEnv();
			$("#themeList").theme({themeBase:"<%=baseUrl%>/styles/dwz/themes"});
		}
	});
});

$(document).ready(function() {
	var menuList=eval('('+'${menuList}'+')');
	var menuUl=$('#menuUl');
	var parentId=0;
	var endChildMenu = "</ul></div>";
	var menuStr="";
	var ctxPath = "${baseUrl}";
	for(var i=0;i<menuList.length;i++)
	{
		if(parentId==0)
		{
			parentId=menuList[i].parent_id;
			
			var parentMenu="<div class='accordionHeader' id='hs_menu_"+parentId+"'><h2><span>Folder</span><img class='ht_menu_img' src='<%= baseUrl%>/styles/dwz/themes/default/images/accordion/ht_menu_"+parentId+".png' align='absmiddle' />"+menuList[i].parent_name+"</h2></div>";			
			menuStr +=parentMenu;
			
			var subChildMenu = "<div class='accordionContent'><ul class='tree treeFolder'>";
			menuStr +=subChildMenu;
			
		}
		else if(parentId!=menuList[i].parent_id)
		{
			menuStr +=endChildMenu;
			
			parentId=menuList[i].parent_id;
			
			var parentMenu="<div class='accordionHeader' id='hs_menu_"+parentId+"'><h2><span>Folder</span><img class='ht_menu_img' src='<%= baseUrl%>/styles/dwz/themes/default/images/accordion/ht_menu_"+parentId+".png' align='absmiddle' />"+menuList[i].parent_name+"</h2></div>";

			menuStr +=parentMenu;
			
			var subChildMenu = "<div class='accordionContent'><ul class='tree treeFolder'>";
			menuStr +=subChildMenu;			
		}
		
		var childMenu="<li class='ht_menu_href'><a id='menu"+menuList[i].menu_id+"' href='"+ctxPath+menuList[i].url+"' target='navTab' rel='"+menuList[i].rel+"' external='"+menuList[i].external+"'><img class='ht_menu_second_img' src='<%= baseUrl%>/styles/dwz/themes/default/images/accordion/ht_menu_second.png' align='absmiddle' />"+menuList[i].menu_name+"</a></li>";
		
		menuStr +=childMenu;
		
		if((i+1)==menuList.length)
		{
			menuStr +=endChildMenu;
		}
	}
	menuUl.append(menuStr);
});


$(function(){
	var jumpPage = $("#jumpPage").val();
	var hrefObjs = $(".ht_menu_href");
	
	var hrefObj = null;//$(hrefObjs[0]).children("a");
	var parentNum = 0;
	
	switch(jumpPage){
		case '2'://呈批件核销
			hrefObj = $("#menu"+35);
			parentNum = 6;
			break;
		case '3'://对账核销
			hrefObj = $("#menu"+39);
			parentNum = 3;
			break;
		case '5'://凭证管理
			hrefObj = $("#menu"+57);
			parentNum = 3;
			break;
		case '6'://系统配置
			hrefObj = $("#menu"+37);
			parentNum = 5;
			break;
		default:
			//hrefObj = $("#menu"+6);
			jumpPage = 1;
	}
	
	var thisTabid = $(hrefObj).attr("rel");
	var thisUrl = $(hrefObj).attr("href");
	var thisTitle = $(hrefObj).text();
	
	if(jumpPage != 1){
		setTimeout(function(){
			//var parnetObjs = $(".accordionContent");
			//$(hrefObj).parent().parent().parent().prev().trigger("click");
			navTab.openTab(thisTabid, thisUrl, {title:thisTitle, fresh:true, external:false});
		},1000);
	}
	
});

function checkdate(ob){
	var dateStr = ob.value;
	var temp="";
	
	if(!(/\d\d\d\d-[01]{0,1}\d-[0123]{0,1}\d/.test(dateStr))){
		if((/\d\d\d\d[01]\d[0123]\d/.test(dateStr))){
			temp+=dateStr.substr(0,4);
			temp+="-";
			temp+=dateStr.substr(4,2);
			temp+="-";
			temp+=dateStr.substr(6,2);
			ob.value=temp;
			return true;
		}else{
			
			if(dateStr!=""){
				alert("请输入正确的日期格式");
				//ob.focus();
				return false;
			}

		}
	}else{
		return true;
	}
} 

function searchMainCase(tabId){
	var tab = 'c';
	tab += tabId;
	var backUrl = "<%=baseUrl %>/management/case/"+tab+"?supflag=main";
	$("#"+tabId).loadUrl(backUrl,'',function(){
         $("#"+tabId).find("[layoutH]").layoutH();
     });
}

</script>
<style type="text/css">

</style>

</head>

<body scroll="no">
	<div id="layout">
		<div id="header">
			<div class="headerNav">
				<a class="logo" href="javascript:void(0)" style="width: 756px;">Logo</a>
				<ul class="nav">
					<li><a href="<%=baseUrl%>/main">主页</a></li>
					<%--<li><a href="<%=baseUrl%>/sendMessage/open" rel="sendMessageNav" width="800" height="225" target="dialog" mask="true">内部联系</a></li>
					 <li><a href="<%=baseUrl%>/editPwd" target="dialog" mask="true">修改密码</a></li> --%>
					<li><a href="<%=baseUrl%>/passport/logout">重新登录</a></li>
				</ul>
				<ul style="top: 27px;height: 23px;position: absolute;z-index: 31;right: 15px;">
					<li><a style="color: #B9CCDA;" >当前用户 : ${message}</a></li>
				</ul>
			</div>
		</div>
		
		<div id="leftside">
			<div id="sidebar_s">
				<div class="collapse">
					<div class="toggleCollapse"><div></div></div>
				</div>
			</div>
			<div id="sidebar">
				<div class="toggleCollapse"></div>
				
				<div class="accordion" fillSpace="sideBar" id="menuUl">
				</div>				
			</div>
		</div>
		<div id="container">
			<div id="navTab" class="tabsPage">
				<div class="tabsPageHeader">
					<div class="tabsPageHeaderContent"><!-- 显示左右控制时添加 class="tabsPageHeaderMargin" -->
						<ul class="navTab-tab">
							<li tabid="main" class="main"><a href="javascript:void(0)"><span><span class="home_icon">我的主页</span></span></a></li>
						</ul>
					</div>
					<div class="tabsLeft">left</div><!-- 禁用只需要添加一个样式 class="tabsLeft tabsLeftDisabled" -->
					<div class="tabsRight">right</div><!-- 禁用只需要添加一个样式 class="tabsRight tabsRightDisabled" -->
					<div class="tabsMore">more</div>
				</div>
				<ul class="tabsMoreList">
					<li><a href="javascript:void(0)">我的主页</a></li>
				</ul>
				<div class="navTab-panel tabsPageContent layoutBox">
					<div>
						<a id="voucher" style="display: none;"  target="navTab" href="<%=baseUrl%>/voucher/searchFinData">凭证管理</a>
					    <a id="org" style="display: none;"  target="navTab" href="<%=baseUrl%>/system/org">机构管理</a>
					
						<div class="accountInfo">
							<div class="right">
								<p><fmt:formatDate value="${now}" pattern="yyyy年 MM月 dd日, EEEE"/></p>
							</div>
							<p><span>您好:${message}，欢迎您登录！</span></p>
						</div>
						<div class="pageContent sortDrag" selector="h1" layoutH="62">
							<c:if test="${flag eq 'list1'}">
								<div class="tabs">
									<div class="tabsHeader">
										<div class="tabsHeaderContent">
											<ul>
												<li><a href="javascript:;"><span>立案6个月未发账案件</span></a></li>
												<li><a href="javascript:searchMainCase('second');"><span>待提交审批第三方费用案件</span></a></li>
												<li><a href="javascript:searchMainCase('third');"><span>发账3个月未到账账单</span></a></li>
												<li><a href="javascript:searchMainCase('four');"><span>已到账未登记案件</span></a></li>
											</ul>
										</div>
									</div>
									
									<div class="tabsContent">
										<div id="first">
										    <c:import url="./management/case/first.jsp"></c:import>
										</div>
							 			<div id="second">
										    <c:import url="./management/case/second.jsp"></c:import>
										</div>
										<div id="third">
							 			    <c:import url="./management/case/third.jsp"></c:import>
										</div>
										<div id="four">
							 			     <c:import url="./management/case/four.jsp"></c:import>
										</div> 
									</div>
									
								</div>
							</c:if>
							<c:if test="${flag eq 'list2'}">
							<div class="tabs">
									<div class="tabsHeader">
										<div class="tabsHeaderContent">
											<ul>
												<li><a href="javascript:;"><span>已发账单提醒</span></a></li>
											</ul>
										</div>
									</div>
							</div>
							<div class="tabsContent">		
							   <div id="list2">
								<c:import url="notice/list2.jsp"></c:import>
								</div>
							</div>	
							</c:if>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
	<div id="footer">@CopyRight 华泰保险经纪海事业务系统<input id="jumpPage" type="hidden" value="${ jumpPage }" /></div>
</body>
</html>
<script>
</script>