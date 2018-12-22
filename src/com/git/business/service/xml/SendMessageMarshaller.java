package com.git.business.service.xml;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.git.util.PropertiesFileLoad;
import com.git.util.XmlOperate;

@Service
public class SendMessageMarshaller {
	protected static String url = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.url");
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.password");
	
	public static void main(String[] args) {
	
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		try {
			String xml = marshallerMessage();
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			System.out.println(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static String marshallerMessage() throws Exception{
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("SEND_MESSAGE");
		Element session = rootElement.addElement("session");
		session.addElement("username").setText(username);
		session.addElement("password").setText(password);
		Element param = rootElement.addElement("param");
		param.addElement("receiveUserIds").setText("1");
		param.addElement("receiveUserNames").setText("admin");
		param.addElement("title").setText("test");
		param.addElement("content").setText("test");
		param.addElement("sendUserId").setText("1");
		param.addElement("sendUserName").setText("admin");
		
		System.out.println(requestDocument.asXML());
		return requestDocument.asXML();
	}
}
	
