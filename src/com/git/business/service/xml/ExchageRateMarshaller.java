package com.git.business.service.xml;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Service;

import com.git.db.beans.ExchageRateImpl;
import com.git.util.PropertiesFileLoad;
import com.git.util.XmlOperate;

@Service
public class ExchageRateMarshaller {
	protected static String url = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.url");
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.password");
	
	public List<ExchageRateImpl> syncExchageRate(String searchDate){
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		try {
			String xml = marshallerRate(searchDate);
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			System.out.println(XmlOperate.formatXML(result));
			return unMarshallerRate(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
	
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		String searchDate="";
		try {
			String xml = marshallerRate(searchDate);
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			System.out.println(XmlOperate.formatXML(result));
			unMarshallerRate(result);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
		
	public static String marshallerRate(String searchDate) throws Exception{
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_EXCHANGERATE");
		Element session = rootElement.addElement("session");
		session.addElement("username").setText(username);
		session.addElement("password").setText(password);
		Element param = rootElement.addElement("param");
		param.addElement("searchDate").setText(searchDate);
		System.out.println(XmlOperate.formatXML(requestDocument.asXML()));
		return requestDocument.asXML();
	}
	
	/*<businessType>GET_EXCHANGERATE</businessType>
    <result>
        <status>1</status>
        <code>1</code>
        <desc>查询成功！</desc>
        <dataCount>0</dataCount>
    </result>
    <responseData>
        <ExchangeRate version="1.0">
            <rate4>1.67</rate4>
            <rate1>1.67</rate1>
            <rate2>1.67</rate2>
            <rate3>1.67</rate3>
            <shortName/>
            <currency>AED</currency>
        </ExchangeRate>*/
     
	public static List<ExchageRateImpl> unMarshallerRate(String result) throws DocumentException{
		
		Document responseDocument = DocumentHelper.parseText(result);
		Element rootElement = responseDocument.getRootElement();
		String businessType = XmlOperate.getNodeAsText(rootElement.selectSingleNode("businessType"),"");
		
		String status = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/status"),"");
		String code = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/code"),"");
		String desc = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/desc"),"");
		String dataCount = XmlOperate.getNodeAsText(rootElement.selectSingleNode("result/dataCount"),"");
		
		//if(Integer.valueOf(dataCount) > 0){
			List ExchangeRate = rootElement.selectNodes("responseData/ExchangeRate");
			List<ExchageRateImpl> rateList = new ArrayList<ExchageRateImpl>();
			for (Iterator it = ExchangeRate.iterator(); it.hasNext();) {
				Element rateElement = (Element) it.next();
				ExchageRateImpl exchangeRateImpl= new ExchageRateImpl();
				exchangeRateImpl.setCurrency(XmlOperate.getNodeAsText(rateElement.selectSingleNode("currency"), ""));
				exchangeRateImpl.setShortname(XmlOperate.getNodeAsText(rateElement.selectSingleNode("shortName"), ""));
				exchangeRateImpl.setRate1(XmlOperate.getNodeAsText(rateElement.selectSingleNode("rate1"), ""));
				exchangeRateImpl.setRate2(XmlOperate.getNodeAsText(rateElement.selectSingleNode("rate2"), ""));
				exchangeRateImpl.setRate3(XmlOperate.getNodeAsText(rateElement.selectSingleNode("rate3"), ""));
				exchangeRateImpl.setRate4(XmlOperate.getNodeAsText(rateElement.selectSingleNode("rate4"), ""));
				rateList.add(exchangeRateImpl);
			}
		//}
		return rateList;
		
	}
}
	
