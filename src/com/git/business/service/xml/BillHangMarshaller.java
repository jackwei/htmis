package com.git.business.service.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.git.business.billHangService.BillHangServiceMgr;
import com.git.business.sys.UserServiceMgr;
import com.git.db.beans.BillHangImpl;
import com.git.util.PropertiesFileLoad;
import com.git.util.PubDateUtil;
import com.git.util.XmlOperate;

import dwz.framework.sys.business.BusinessFactory;

public class BillHangMarshaller {
	Logger logger = Logger.getLogger(BillHangMarshaller.class); 
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.voucher.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.voucher.password");

	public synchronized String SyncBillHangHandler (HttpServletRequest request,Element requestElement) throws Exception{
		
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("PUSH_BANKINFO");
		Element result = rootElement.addElement("result");
		logger.info(requestElement.asXML());
		String un = XmlOperate.getNodeAsText(requestElement.selectSingleNode("session/username"),"");
		String pwd = XmlOperate.getNodeAsText(requestElement.selectSingleNode("session/password"),"");

		//List<Map<String,String>> bankInfoList = this.unMarshallerBankInfo(requestElement);
		
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
			unMarshallerBankInfo(requestElement);
			result.addElement("status").setText("1");
			result.addElement("code").setText("1");
			result.addElement("desc").setText("更新成功!");
				
		}
		logger.info(rootElement.asXML());
		return rootElement.asXML();
	}
	
	public void unMarshallerBankInfo(Element requestElement) throws Exception{
		BillHangServiceMgr billHangServiceMgr = BusinessFactory.getInstance().getService("billHangServiceMgr");

		List bankInfoList = requestElement.selectNodes("requestData/BankInfo");
		
		//List<Map<String,String>> bankInfos = new ArrayList<Map<String,String>>();
		
		for (Iterator it = bankInfoList.iterator(); it.hasNext();) {
			Element voucherElement = (Element) it.next();
			BillHangImpl billHangImpl = null;
			
			String id = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("id"), "");
			String payer = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("payer"), "");
			String currency = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("currency"), "");
			String amount = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("amount"), "");
			String recordDate = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("recordDate"), "");
			String createDate = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("createDate"), "");
			String serialNumber = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("serialNumber"), "");
			String bankInfoCode = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("bankInfoCode"), "");
			String bankInfoCode2 = XmlOperate.getNodeAsText(voucherElement.selectSingleNode("bankInfoCode2"), "");

			billHangImpl = new BillHangImpl();
			
			billHangImpl.setId(Long.valueOf(id));
			billHangImpl.setRemitter(payer);
			billHangImpl.setRemittancedate(PubDateUtil.stringToDate(recordDate, "yyyy-MM-dd"));
			billHangImpl.setCurrency(currency);
			billHangImpl.setRemitmoney(Float.valueOf(amount));
			billHangImpl.setRemittancecustomers(payer);
			billHangImpl.setCreateTime(PubDateUtil.stringToDate(createDate, "yyyy-MM-dd HH:mm:ss"));
			billHangImpl.setBankinfo(bankInfoCode);
			billHangImpl.setBankcode(bankInfoCode2);
			billHangImpl.setRemark(serialNumber);
			billHangImpl.setEntrypeople("同步数据");

			if(null == billHangServiceMgr.getBillHang(id)){
				billHangServiceMgr.insertBillHang(billHangImpl);
			}else{
				billHangServiceMgr.updateBillHang(billHangImpl);
			}
			//bankInfos.add(bankInfoMap);
		}
	}
	
	

	
}
