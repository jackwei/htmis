package com.git.business.finance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.business.voucher.VoucherServiceMgr;
import com.git.db.beans.FinData;
import com.git.db.beans.FinDataResult;
import com.git.db.mapper.FinDataResultMapper;
import com.git.util.PropertiesFileLoad;
import com.git.util.XmlOperate;

import dwz.framework.sys.business.BusinessFactory;

public class UpdateVoucherStatusHandler {
	static Logger logger = Logger.getLogger(UpdateVoucherStatusHandler.class);
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.voucher.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.voucher.password");

	public synchronized String updateHandler (HttpServletRequest request,Element requestElement) throws Exception{
		
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("UPDATE_VOUCHER_STATUS");
		Element result = rootElement.addElement("result");
		
		logger.info(requestElement.asXML());
		
		String un = XmlOperate.getNodeAsText(requestElement.selectSingleNode("session/username"),"");
		String pwd = XmlOperate.getNodeAsText(requestElement.selectSingleNode("session/password"),"");
		
		VoucherServiceMgr voucherServiceMgr =  BusinessFactory.getInstance().getService("voucherServiceMgr");

		//List<Map<String,String>> voucherList 
		
		
		if (!username.equals(un)) {
			result.addElement("status").setText("2");
			result.addElement("code").setText("21");
			result.addElement("desc").setText("登录名不正确!");
			result.addElement("dataCount").setText("0");
		} else if (!password.equals(pwd)) {
			result.addElement("status").setText("2");
			result.addElement("code").setText("22");
			result.addElement("desc").setText("密码不正确!");
			result.addElement("dataCount").setText("0");
		}else{
			/*for (Map<String,String> voucher : voucherList) {
				String id = voucher.get("id");
				//String status = voucher.get("status");
				FinData finData = new FinData();
				finData.setBatchNo(id);
				finData.setDealFlag("1");
				voucherServiceMgr.updateFindata(finData);
			}*/
			int ss = this.unMarshallerUpdateVoucher(requestElement);
			result.addElement("status").setText("1");
			result.addElement("code").setText("1");
			result.addElement("desc").setText("更新成功!");
				
		}
		logger.info(XmlOperate.formatXML(rootElement.asXML()));
		return rootElement.asXML();
	}
	
	public int unMarshallerUpdateVoucher(Element requestElement) throws Exception{
		//Document requestDocument = DocumentHelper.parseText("");
		//Element rootElement = requestDocument.getRootElement();
		VoucherServiceMgr voucherServiceMgr =  BusinessFactory.getInstance().getService("voucherServiceMgr");
		
		List voucherStatus = requestElement.selectNodes("requestData/VoucherStatus");
		
		//List<Map<String,String>> voucherList = new ArrayList<Map<String,String>>();
		
		for (Iterator it = voucherStatus.iterator(); it.hasNext();) {
			Element voucherElement = (Element) it.next();
			String id = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("id"), "");
			String status = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("status"), "");
			FinData finData = new FinData();
			if(status.equals("2")){
				finData.setBatchNo(id);
				finData.setDealFlag("2");
			}else if(status.equals("3")){
				String expStatus = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("expStatus"), "");
				String voucherCode =XmlOperate.getNodeAsText(voucherElement.selectSingleNode("voucherCode"), "");
				String expDate = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("expDate"), "");
				finData.setBatchNo(id);
				finData.setDealFlag("4");
			}
			
			voucherServiceMgr.updateFindata(finData);
		}
		int i = 0;
		return i;
	}
	
	

	
}
