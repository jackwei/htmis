package com.git.web;

import javax.servlet.http.HttpServletRequest;

import com.git.business.sys.User;
import com.git.util.PropertiesFileLoad;
import com.git.util.XmlOperate;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/sendMessage")
public class SendMessageController extends BaseController {

	protected static String url = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.url");
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.password");

	@RequestMapping("/open")
	public String openMessage(){
		return "/sendMessage";
	}
	
	@RequestMapping("/send")
	public ModelAndView sendMessage(HttpServletRequest request){
		
		String xml = this.marshallerMessage(request);
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		String desc = "";
		try {
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			System.out.println(result);
			desc = this.resultMessage(result);
		}catch (Exception e) {
			return ajaxDoneError(desc+e.getMessage());
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	public String resultMessage(String result) throws DocumentException{
		Document responseDocument = DocumentHelper.parseText(result);
		Element rootElement = responseDocument.getRootElement();
		String businessType = XmlOperate.getNodeAsText(rootElement.selectSingleNode("businessType"),"");
		String status = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/status"),"");
		String code = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/code"),"");
		String desc = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/desc"),"");
		
		return desc;
	}

	
	public String marshallerMessage(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("SEND_MESSAGE");
		Element session = rootElement.addElement("session");
		session.addElement("username").setText(username);
		session.addElement("password").setText(password);
		
		Element param = rootElement.addElement("param");
		param.addElement("receiveUserIds").setText(request.getParameter("userLookup.id"));
		param.addElement("receiveUserNames").setText(request.getParameter("userLookup.name"));
		
		param.addElement("title").setText(request.getParameter("title"));
		param.addElement("content").setText(request.getParameter("content"));
		
		param.addElement("sendUserId").setText(user.getId().toString());
		param.addElement("sendUserName").setText(user.getName());
		
		System.out.println(requestDocument.asXML());
		return requestDocument.asXML();
	}
	
}
