<%@page import="org.springframework.asm.commons.TryCatchBlockSorter"%>
<%@ page contentType="text/xml;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/include.inc.jsp"%>
<%@page import="com.git.business.finance.CreateFinDataXml" %>
<%@page import="com.git.business.finance.UpdateVoucherStatusHandler" %>
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
	
	Document requestDocument = DocumentHelper.parseText(sb.toString());
	System.out.print("buffer==================="+sb.toString());
	Element rootElement = requestDocument.getRootElement();
	String businessType = XmlOperate.getNodeAsText(rootElement.selectSingleNode("businessType"),"");
	System.out.println("type============"+businessType);
if("UPDATE_VOUCHER_STATUS".equals(businessType)){
	UpdateVoucherStatusHandler uv = new UpdateVoucherStatusHandler();
	String voucher = uv.updateHandler(request,rootElement);
	response.setContentType("text/xml");  
	out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); 
	out.write(voucher);
}else if("GET_VOUCHER".equals(businessType)){
	CreateFinDataXml createFinDataXml = new CreateFinDataXml();
	String task = createFinDataXml.createFile(request,rootElement);
	response.setContentType("text/xml");  
	out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n"); 
	out.write(task);
	}
%>
