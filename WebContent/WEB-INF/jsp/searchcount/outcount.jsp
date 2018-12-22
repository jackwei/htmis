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
			<a class="button"  rel="bzwgj01" external="true" onclick="tack('bzwgj01');" ><span>1  境内银行新签约对外担保逐笔备案表（外币）</span></a>
		</p>
		<p>
			<a class="button"  rel="bzwgj02" external="true" onclick="tack('bzwgj02');" ><span>2  境内银行新签约对外担保逐笔备案表（人民币）</span></a>
		</p>
		<p>
			<a class="button"  rel="bzwgj03" external="true" onclick="tack('bzwgj03');" ><span>3  境内银行对外担保汇总备案表(外币)</span></a>
		</p>
		<p>
			<a class="button"  rel="bzwgj04" external="true" onclick="tack('bzwgj04');" ><span>4  境内银行对外担保汇总备案表（人民币）</span></a>
		</p>
		<p>
			<a class="button"  rel="bzwgj05" external="true" onclick="tack('bzwgj05');" ><span>5  境内银行融资性对外担保履约逐笔备案表（外币）</span></a>
		</p>
		<p>
			<a class="button"  rel="bzwgj06" external="true" onclick="tack('bzwgj06');" ><span>6  境内银行融资性对外担保履约逐笔备案表（外币）</span></a>
		</p>
		<p>
			<a class="button"  rel="bzwgj07" external="true" onclick="tack('bzwgj07');" ><span>7 北京地区对外担保余额标执行情况表 （人民币）</span></a>
		</p>
		<p>
			<a class="button" target="navTab" rel="bzwgj08" external="true" onclick="tack('bzwgj08');" ><span>8 北京地区对外担保余额标执行情况表（外币）</span></a>
		</p>
	</div>
</form>
</div>

<script type="text/javascript">
function tack(x){
  var par="<%=request.getContextPath()%>";
  var a = $('#startdate').val(); 
  var b = $('#enddate').val();

	  var str = "&startdate="+a+"&enddate="+b+"&path="+par;
	    var url = "<%=baseUrl %>/ShowReport.wx?PAGEID="+ x + str ;
	    window.open(url);
<%-- 	  o.href = "<%=baseUrl %>/ShowReport.wx?PAGEID="+ x + str ;
	  return true --%>;

}
</script>