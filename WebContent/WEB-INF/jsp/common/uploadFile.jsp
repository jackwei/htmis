<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<%
  Object type=request.getAttribute("doctype");
%>
<form method="post" action="<%=baseUrl %>/applyInfos/UploadDocinfos"  enctype="multipart/form-data" class="pageForm required-validate" onsubmit="return iframeCallback(this, dialogAjaxDone)">
   <div defH="180">
   <input type="hidden" name="applyid" id="applyid"  value="${applyId }" />
   <input type="hidden"  name="secretflag" value="1" />
   <input type="hidden" id="doctype" name="doctype"  value="${doctype }" />
   <c:if test="${mark!='1'}">
	    <p>
	      <label>名称：</label>
          <input type="text" name="docname">
 	    </p>
 	    <br>
 	    <p>
 	      <label>附件：</label>
 	      <input type="file" name="file1" class="required" />
 	    </p>
 	     <br>
 	    <c:if test="${doctype =='applydoc'}">
 	    <p>
	      <label>分类：</label>
          <select name="parent2id">
		    <c:forEach var="ct" items="${filetype}">
			    <option value="${fn:trim(ct['dictid']) }" >${fn:trim(ct['dictname']) }</option>
			 </c:forEach>
	      </select>
 	    </p>
 	     <br>
 	    </c:if>
 	    <p>
 	      <label>备注：</label>
 	      <textarea name="docdes" rows="2"></textarea>
 	    </p>
 	    <p></p>
 	      <br>
 	     <div class="buttonActive"><div class="buttonContent"> <button type="submit">上传</button></div></div>
		<div class="button"><div class="buttonContent"><button type="button" class="close">关闭</button></div></div>
	</c:if>
	<br/><br/><br/>
		<div style="overflow:scroll;height: 100px">
			<table class="dtsheet" width="100%">
				<thead>
					<tr align="center" class="headers">
						<th width="25%">附件名称</th>
						<c:if test="${doctype =='applydoc'}">
							<th width="30%">分类</th>
						</c:if>
						<th width="20%">操作</th>
						<th width="25%">备注</th>
					</tr>
				</thead>
				<tbody align="center" id="tby">
				</tbody>
			</table>
		</div>
	</div>
</form>
<script type="text/javascript">
function dialogAjaxDone(json){
	DWZ.ajaxDone(json);
	if (json.statusCode == DWZ.statusCode.ok){
		docInfosList();
		if (json.navTabId){
			navTab.reload(json.forwardUrl, {}, json.navTabId);
		}
	}
}

$(function(){
	docInfosList();
});

function docInfosList(){
$.ajax({
    type:'post',
    url:'<%=baseUrl %>/applyInfos/searchDocInfos?applyid='+$("#applyid").val()+'&docType='+$("#doctype").val(),
    dataType:'json',
    contentType:'application/json;charset=utf-8',
    success:function(data){
    	$("#tby").html("");
    	var oid=data.oid;
    	var dname=data.name;
    	var desc=data.desc;
    	var filename=data.filename;
    	var path=data.path;
    	var type=data.type;
    	var arrIds=oid.split(",");
    	var arrDnames=dname.split(",");
    	var arrDescs=desc.split(",");
    	var arrFileName=filename.split(",");
    	var arrPath=path.split(",");
    	var arrType=type.split(",");
    	if(arrIds!=""){
    		for(var i=0;i<arrIds.length;i++){
    			if(arrIds[i]!=""){
    			if(arrType[i]=="null" || arrType[i]==undefined){
    				arrType[i]="";
    			}
    			var htmlStr ="";
    			 if('<%=type%>'=='applydoc'){
    				  htmlStr ="<tr><td width='25%'>"+arrDnames[i]+"</td><td width='30%'>"+arrType[i]+"</td><td width='20%'><a class='delete' href='javascript:del("+arrIds[i]+",\""+arrPath[i]+"\")'><span>删除</span></a>&nbsp;&nbsp;<a class='icon' href='<%=baseUrl %>/FileDown/download?oid="+arrIds[i]+"'><span>下载</span></a></td><td width='25%'>"+arrDescs[i]+"</td></tr>" ; 
    			 }else{
    				 htmlStr ="<tr><td width='25%'>"+arrDnames[i]+"</td><td width='20%'><a class='delete' href='javascript:del("+arrIds[i]+",\""+arrPath[i]+"\")'><span>删除</span></a>&nbsp;&nbsp;<a class='icon' href='<%=baseUrl %>/FileDown/download?oid="+arrIds[i]+"'><span>下载</span></a></td><td width='25%'>"+arrDescs[i]+"</td></tr>" ;  
    			 }
        		 $("#tby").append(htmlStr);
    			}
    		}
    	}
    }
});
}

function del(oid,path){
	if(!confirm("确认删除吗?")){
		return;
	}
	$.post('<%=baseUrl%>/applyInfos/deleteDoc',
			{'oid':oid,
		     'cxtPath':path},
       function(data){
           if(data.result=="1"){
        	   alertMsg.info("删除成功");
        	   docInfosList();
           }else{
        	   alertMsg.error("删除失败");
           }		
	  }
	     ,'json');
}
</script>

<style>
.dtsheet {border-collapse:collapse;  border-top: 1px solid #afb8c8; border-left: 1px solid #afb8c8; background-color: #fdfdfd; }
.dtsheet .headers {background:url("./styles/dwz/themes/default/images/grid/tableth.png") repeat-x scroll 0 0 #F0EFF0;}
.dtsheet td,th { cursor: text; padding: 2px;  border-bottom: 1px solid #afb8c8; border-right: 1px solid #afb8c8; }
</style>
