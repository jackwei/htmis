
package com.git.task;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.UserServiceMgr;
import com.git.db.beans.SysCode;
import com.git.db.beans.SysGroup;
import com.git.db.beans.SysUser;
import com.git.enums.Gender;
import com.git.util.PropertiesFileLoad;
import com.git.util.PubDateUtil;
import com.git.util.XmlOperate;

import dwz.framework.sys.business.BusinessFactory;

public class SyncUserDataTask implements Runnable  {
	
	static Logger logger = Logger.getLogger(SyncUserDataTask.class); 

	protected static String url = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.url");
	
	protected static String username = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.username");
	
	protected static String password = PropertiesFileLoad.getInstance().getP().getProperty("htmis.sync.password");
	
	protected static UserServiceMgr userMgr = BusinessFactory.getInstance().getService("userServiceMgr");

	protected static OrgServiceMgr orgMgr =  BusinessFactory.getInstance().getService("orgServiceMgr");

	public static void main(String[] args) {
		
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		try {
			String xml = marshallerUser();
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			unMarshallerUser(result);
			System.out.println(XmlOperate.formatXML(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String marshallerUser() throws Exception{
		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("SYN_USER_DATA");
		Element session = rootElement.addElement("session");
		session.addElement("username").setText(username);
		session.addElement("password").setText(password);
		Element param = rootElement.addElement("param");
		SysCode sysCode = orgMgr.getSysCode("1");
		param.addElement("synCode").setText(sysCode.getCodevalue());
		//param.addElement("synCode").setText("2028");
		logger.info(XmlOperate.formatXML(requestDocument.asXML()));
		return XmlOperate.formatXML(requestDocument.asXML());
	}
	
	@Override
	public void run() {
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod(url);
		try {
			String xml = marshallerUser();
			httpMethod.setRequestEntity(new StringRequestEntity(xml, "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			logger.info(XmlOperate.formatXML(result));
			httpMethod.releaseConnection();
			String ss = unMarshallerUser(result);
			logger.info(ss);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static String unMarshallerUser(String result) throws Exception{
		
		Document responseDocument = DocumentHelper.parseText(result);
		Element huataiElement = responseDocument.getRootElement();
		
		String ss = huataiElement.elementTextTrim("businessType");
		Element updateObjects = huataiElement.element("responseData").element("updateObjects");
		String nextSynCode =  huataiElement.element("responseData").element("nextSynCode").getTextTrim();
		
		SysCode sysCode = new SysCode();
		sysCode.setCodeid("1");
		sysCode.setCodevalue(nextSynCode);
		orgMgr.updateSysCode(sysCode);
		
		if(null == updateObjects){
			return "无更新数据";
		}
		
		List<Element> elements = updateObjects.selectNodes("SysData");
		
		for (Iterator<Element> iterator = elements.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			
			if("SysGroup".equals(element.elementTextTrim("objectName"))){
				Element groupElement = element.element("SysGroup");
				
				SysGroup sysGroup = new SysGroup();
				sysGroup.setOrgId(new Long(groupElement.elementText("id")));
				sysGroup.setOrgCode(groupElement.elementTextTrim("code")); /*部门编号*/
				sysGroup.setOrgName(groupElement.elementTextTrim("name"));
				sysGroup.setOrgEname(groupElement.elementTextTrim("describe"));
				//sysGroup.setOrgSname(groupElement.elementTextTrim("describe"));
				
				sysGroup.setParentId(new Long(groupElement.elementText("parentId")));
				
				if(("").equals(groupElement.elementTextTrim("createDate"))){
					sysGroup.setCreateTime(new Date());
				}else{
					sysGroup.setCreateTime(PubDateUtil.stringToDate(groupElement.elementTextTrim("createDate"), "yyyy-MM-dd HH:mm:ss"));
				}
				
				sysGroup.setExtend1(groupElement.elementTextTrim("region"));
				
				sysGroup.setExtend2(groupElement.elementTextTrim("name"));
			
				
				if (!"".equals(groupElement.elementText("isDel"))) {
					sysGroup.setOrgStatus(groupElement.elementText("isDel"));
				}
				if (!"".equals(groupElement.elementText("deptManagerId"))) {
					sysGroup.setDeptManagerId(new Long(groupElement.elementText("deptManagerId")));
				}
				if (!"".equals(groupElement.elementText("deptLeaderId"))) {
					sysGroup.setDeptLeaderId(new Long(groupElement.elementText("deptLeaderId")));
				}
				if("a".equals(element.elementTextTrim("operateSymbol"))){
					sysGroup.setFlag("1");
					sysGroup.setOrgLevel(2);
					sysGroup.setOrgType("D");
					//sysGroup.setExtend3("16000001");
					orgMgr.syncAddOrg(sysGroup);
				}else{
					orgMgr.sysUpdOrg(sysGroup);
				}

			}
			
			if("SysUser".equals(element.elementTextTrim("objectName"))){
				Element userElement = element.element("SysUser");
				
				SysUser user = new SysUser();
				user.setUserId(new Long(userElement.elementText("id")));
				user.setUserNo(userElement.elementTextTrim("code"));
				user.setUserCode(userElement.elementTextTrim("username"));
				user.setUserPwd(userElement.elementTextTrim("password"));// userElement.elementTextTrim("password")
				user.setName(userElement.elementTextTrim("truename"));
				user.setGender(userElement.elementTextTrim("sex").equals("男") ? Gender.M.toString():Gender.F.toString());
				user.setEmail(userElement.elementTextTrim("email"));
				user.setPhone(userElement.elementTextTrim("tel"));
				user.setUserStatus(userElement.elementTextTrim("status").equals("0") ? "1":"2");
				
				if(null == userElement.elementTextTrim("orderBy")){
					user.setOrderBy(1000001);
				}else{
					//user.setOrderBy(Integer.valueOf(userElement.elementTextTrim("orderBy")));
				}
				
				user.setEnName(userElement.elementTextTrim("lastname"));
				if(element.elementTextTrim("createDate") != null || "".equals(element.elementTextTrim("createDate"))){
					user.setCreateTime(PubDateUtil.stringToDate(element.elementTextTrim("createDate"), "yyyy-MM-dd HH:mm:ss"));
					user.setModifyTime(PubDateUtil.stringToDate(element.elementTextTrim("createDate"), "yyyy-MM-dd HH:mm:ss"));
				}else{
					user.setOperatorId(Long.valueOf("1"));
					user.setCreateTime(new Date());
				}
				user.setOrgCode(userElement.elementTextTrim("deptId"));
				System.out.println("======"+userElement.elementTextTrim("deptId"));
				user.setOrgId(Long.valueOf(userElement.elementTextTrim("deptId")));
				user.setOrgName(orgMgr.getOrg(user.getOrgId()).getOrgName());
				user.setsName(userElement.elementTextTrim("extendf5")); //获取用户简写
				
				/*user.setExtend1("10006");
				user.setExtend2("初始化用户");*/
				
				if("a".equals(element.elementTextTrim("operateSymbol"))){
					userMgr.syncAddUser(user);
					/*userMgr.syncUserRole(user, "10006");*/
				}else{
					//userMgr.syncAddUser(user);
					
					userMgr.syncUpdUser(user);
				}
				
			}
		}
		
		return ss;
	}
	
}
