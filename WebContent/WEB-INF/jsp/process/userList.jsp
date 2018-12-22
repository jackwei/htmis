<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<c:import url="../layout/pager/pagerForm.jsp"></c:import>

<form method="post" rel="pagerForm"  action="<%=baseUrl %>/processDef/participantValue?type=2"  onsubmit="return dwzSearch(this, 'dialog');">
<div class="pageHeader">
	<div class="searchBar">
		<ul class="searchContent">
			<li>
				<label>用户名称：</label>
				<input type="text" name="name" value="${user.name }"/>
			</li>
		</ul>
		<div class="subBar">
			<span style="margin-left: 5px; line-height: 25px; float: left">总数: <strong>${vo.totalCount}</strong></span>
			<ul>						
				<li><div class="buttonActive"><div class="buttonContent"><button type="submit">搜索</button></div></div></li>
			</ul>
		</div>
	</div>
</div>
</form>


<div class="pageContent">
<div class="panelBar">
		<ul class="toolBar">
			<li><a class="add"  rel="ids" href="javascript:back()"><span>确定</span></a></li>
			<li class="line">line</li>
		</ul>
	</div>
	 <table class="table" width="100%"  layoutH="200">
		<thead align="center">
			<tr>
				<th><input type="checkbox" group="ids" class="checkboxCtrl"></th>
				<th>用户名称</th>
				<th>用户编号</th>
				<th>用户状态</th>
			</tr>
		</thead>
		<tbody align="center">
		<c:forEach var="item" items="${list}" varStatus="s">
			<tr target="slt_objId" rel="${item.id}">
				<td><input name="ids" value="${item.id}&${item.name}" type="checkbox">
				</td>
				<td>${item.name}</td>
				<td>${item.userCode}</td>
				<td>
				<c:choose>
                  <c:when test="${item.userStatus=='1'}">
                                                     正常
                   </c:when>
				</c:choose>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	 <div class="panelBar">
        <div class="pages">
            <span>显示</span>
            <select class="combox" name="numPerPage" onchange="dwzPageBreak({targetType:'dialog',numPerPage:this.value})">
               	<c:forEach begin="0" end="20" varStatus="s">
  					<option value="${s.index}" ${vo.pageSize eq s.index?'selected="selected"':''}>${s.index}</option>
  				</c:forEach>
            </select>
            <span>条，共${vo.totalCount}条</span>
        </div>
        <div class="pagination" targetType="dialog" totalCount="${vo.totalCount}" numPerPage="${vo.pageSize}" pageNumShown="5" currentPage="${vo.pageNum}">
        </div>
    </div>	
	 <script type="text/javascript">
	    function back(){
	    	var ids="";
	    	var names="";
	    	var result="";
	    	$('input[name="ids"]:checked').each(function(){   
	    		result=result+ $(this).val()+","; 
	    	});
	    	var arr=result.split(",");
	    	for(var i=0;i<arr.length;i++){
	    		if(arr[i]!=""){
	    			ids+=arr[i].substring(0,arr[i].indexOf('&'))+",";
		    		names+=arr[i].substring(arr[i].indexOf('&')+1,arr[i].length)+",";
	    		}
	    	}
	    	$.bringBack({userid:ids, userName:names});
	    }
	 </script>
</div>


