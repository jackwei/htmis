<%@ page contentType="text/xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@page import=" com.git.business.service.xml.TodoTaskMarshaller"%>
<%@page import="com.git.business.finance.UpdateVoucherStatusHandler" %>
<%@page import="com.git.business.service.xml.BillHangMarshaller" %>
<%@ page import = "java.io.*"%>
<%@page import="org.dom4j.*"%>
<%@page import="com.git.util.XmlOperate"%>

<%
InputStream is = request.getInputStream();
BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
String buffer = null;
StringBuffer sb = new StringBuffer();
while ((buffer = br.readLine()) != null) {
	sb.append(buffer);
}

System.out.println("===buffer======"+sb.toString());

Document requestDocument = DocumentHelper.parseText(sb.toString());
Element rootElement = requestDocument.getRootElement();
String businessType = XmlOperate.getNodeAsText(rootElement.selectSingleNode("businessType"),"");
System.out.println("type===================="+businessType);
	
if("GET_TASK_APPROVAL".equals(businessType)){
		System.out.println("businessTypebusinessTypebusinessTypebusinessType");
		TodoTaskMarshaller todoTaskMarshaller = new TodoTaskMarshaller();
		String task = todoTaskMarshaller.handleTask(request,rootElement);
		response.setContentType("text/xml");  
		out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); 
		out.write(task);
}else if("PUSH_BANKINFO".equals(businessType)){
		BillHangMarshaller bm = new BillHangMarshaller();
		String billBank = bm.SyncBillHangHandler(request,rootElement);
		response.setContentType("text/xml");  
		out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); 
		out.write(billBank);
}
    
%>
