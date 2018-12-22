<!DOCTYPE HTML>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
<html>
<head>
<meta charset="UTF-8">
<title><decorator:title/></title>
<style type="text/css">
/* suggest */
#suggest{position:absolute; z-index:2000; left:50; top:0;}
#suggest ul{list-style:none; padding:1px; margin:0; background-color:#fff; border:1px solid #999; width:150px;}
#suggest li{display:block; color:#000; padding:3px; margin:0; border:1px solid #fff; background-color:transparent; text-align:left; cursor:default;}
#suggest li.selected{border:1px solid #0a246a; background-color:#b6bdd2}
#calendar {z-index:1000}

#alertBackground { display:none; width:100%; height:100%; opacity:0.4; filter:alpha(opacity=40); background:#FFF; position:absolute; top:0; left:0; z-index:100;}
</style>

<decorator:head/>
</head>

<body>

<section id="container" class="suggest">
	
	<section id="content">
		<decorator:body/>
	</section>
	
</section>

</body>
</html>
