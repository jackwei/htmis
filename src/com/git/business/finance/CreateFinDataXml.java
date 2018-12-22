package com.git.business.finance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.UserServiceMgr;
import com.git.business.voucher.VoucherServiceMgr;
import com.git.db.beans.FinData;
import com.git.enums.VoucherStatus;
import com.git.util.PropertiesFileLoad;
import com.git.util.XmlOperate;

import dwz.framework.sys.business.BusinessFactory;

public class CreateFinDataXml {
	
	protected static  Logger logger = Logger.getLogger(CreateFinDataXml.class);
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.voucher.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.voucher.password");

	/*@Autowired
	private VoucherServiceMgr voucherServiceMgr;
*/
	public synchronized String createFile(HttpServletRequest request,Element requestElement) throws Exception
	{
		
		VoucherServiceMgr voucherServiceMgr = BusinessFactory.getInstance().getService("voucherServiceMgr");

		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_VOUCHER");
		
		String un = XmlOperate.getNodeAsText(requestElement.selectSingleNode("session/username"),"");
		String pwd = XmlOperate.getNodeAsText(requestElement.selectSingleNode("session/password"),"");
		
	
		if (!username.equals(un)) {
			Element result = rootElement.addElement("result");
			result.addElement("status").setText("2");
			result.addElement("code").setText("21");
			result.addElement("desc").setText("登录名不正确!");
			result.addElement("dataCount").setText("0");
		} else if (!password.equals(pwd)) {
			Element result = rootElement.addElement("result");
			result.addElement("status").setText("2");
			result.addElement("code").setText("22");
			result.addElement("desc").setText("密码不正确!");
			result.addElement("dataCount").setText("0");
		}else{
			Map criterias = new HashMap();
			criterias.put("dealFlag", VoucherStatus.Voucher1.getCode());
			
			Map map = voucherServiceMgr.searchFinData(criterias, null);
			//1、先获取目前还未同步的数据
			List<FinData> finDataList = (List)map.get("FinDataList");
			GetVoucherDataHandler gv = new GetVoucherDataHandler();
			gv.marshallFinData(finDataList,rootElement);
				
		}
		logger.info(XmlOperate.formatXML(rootElement.asXML()));
		return rootElement.asXML();
	}
	
	public static void main(String[] args) {
		VoucherServiceMgr voucherServiceMgr =  BusinessFactory.getInstance().getService("voucherServiceMgr");
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_VOUCHER");
		Element result = rootElement.addElement("result");
		
		Map criterias = new HashMap();
		criterias.put("dealFlag", VoucherStatus.Voucher1.getCode());
		Map map = voucherServiceMgr.searchFinData(criterias, null);
		//1、先获取目前还未同步的数据
		List<FinData> finDataList = (List)map.get("FinDataList");
		GetVoucherDataHandler gv = new GetVoucherDataHandler();
		gv.marshallFinData(finDataList,rootElement);
	}
}
