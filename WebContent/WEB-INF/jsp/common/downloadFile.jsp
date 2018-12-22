<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%><%@ include file="/include.inc.jsp"%>
	<div class="panel" >
		<h1>附件信息</h1>
		<div style="overflow:scroll;height: 200px;">
		 <table class="table" width="70%" layoutH="300">
		 	<thead>
				<tr align="center" class="headers">
					<th  width="15%"></th>
					<th>附件名称</th>
					<th>操作</th>
					<th width="30%">备注</th>
				</tr>
			</thead>
			<c:forEach var="item" items="${docList}" varStatus="s">
				<tr target="oid" rel="${item.id }">
					<td>${s.index + 1}</td>
					<td>${item.docname}</td>
					<td>
						<a class='button' href='<%=baseUrl %>/FileDown/download?oid=${item.id }'><span>下载</span></a>
					</td>
					<td>${item.docdes}</td>
				</tr>
			</c:forEach>
		 </table>
		 </div>
	</div>
