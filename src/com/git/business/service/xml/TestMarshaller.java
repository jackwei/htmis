package com.git.business.service.xml;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.git.util.XmlOperate;

public class TestMarshaller {
	
	static Logger logger  =  Logger.getLogger(TestMarshaller. class );
	
	//static String url = "http://localhost:8080/voucher_exp.jsp";
	static String url = "http://localhost:8080/sync_data_req.jsp";
	
	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		try {
			//String xml = marshallerMessage();
			//String xml = marshalerVoucher();
			//String xml = marshalerBankInfo();
			String xml = marshallerTask();
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			logger.error(result);
			//System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String marshalerBankInfo() throws Exception{
		//--》》<?xml version="1.0" encoding="UTF-8"?><huatai><businessType>GET_VOUCHER</businessType>
		//<session><username>admin</username><password>123</password></session></huatai>
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_VOUCHER");
		//rootElement.addElement("businessType").setText("PUSH_BANKINFO");
		Element param = rootElement.addElement("session");
		param.addElement("username").setText("admin");
		param.addElement("password").setText("123");
		logger.info(XmlOperate.formatXML(requestDocument.asXML()));
		return requestDocument.asXML();
		
	}
	
	
	public static String marshallerMessage() throws Exception{
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("SEND_MESSAGE");
		Element session = rootElement.addElement("session");
		Element param = rootElement.addElement("param");
		param.addElement("receiveUserIds").setText("1");
		param.addElement("receiveUserNames").setText("admin");
		param.addElement("title").setText("test");
		param.addElement("content").setText("test");
		param.addElement("sendUserId").setText("1");
		param.addElement("sendUserName").setText("admin");
		
		logger.error(requestDocument.asXML());
		return requestDocument.asXML();
	}
	
	public static String marshallerTask() throws Exception{
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_TASK_APPROVAL");
		Element param = rootElement.addElement("param");
		param.addElement("ticket").setText("1387765646006");
		logger.info(XmlOperate.formatXML(requestDocument.asXML()));
		return requestDocument.asXML();
	}
	
	
	public static String marshalerVoucher() throws Exception{
		//--》》<?xml version="1.0" encoding="UTF-8"?><huatai><businessType>GET_VOUCHER</businessType>
		//<session><username>admin</username><password>123</password></session></huatai>
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_VOUCHER");
		Element param = rootElement.addElement("session");
		param.addElement("username").setText("admin");
		param.addElement("password").setText("123");
		logger.info(XmlOperate.formatXML(requestDocument.asXML()));
		return requestDocument.asXML();
		
	}
	
}
