package com.git.business.service.xml;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.git.business.sys.Org;
import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.User;
import com.git.business.sys.UserServiceMgr;
import com.git.util.Jutil;
import com.git.util.XmlOperate;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.BusinessFactory;

@Service
public class TodoTaskMarshaller {
	
	static Logger logger = Logger.getLogger(TodoTaskMarshaller.class); 
	
	@Autowired
	public UserServiceMgr userServiceMgr;

	public synchronized String handleTask(HttpServletRequest request,Element requestElement)
			throws HttpException, IOException, DocumentException {

		Document requestDocument = DocumentHelper.createDocument();
		requestDocument.setXMLEncoding("UTF-8");
		Element rootElement = requestDocument.addElement("huatai");
		rootElement.addElement("businessType").setText("GET_TASK_APPROVAL");
		Element result = rootElement.addElement("result");
		Element responseData = rootElement.addElement("responseData");
		
		UserServiceMgr userMgr = BusinessFactory.getInstance().getService(
		"userServiceMgr");
		OrgServiceMgr orgMgr = BusinessFactory.getInstance().getService(
		"orgServiceMgr");
		logger.info("requestElement====="+requestElement.asXML());
		//String ticket = request.getParameter("ticket");
		String ticket = XmlOperate.getNodeAsText(requestElement.selectSingleNode("param/ticket"),"");
		
		String status = "";
		String code = "";
		String desc = "";
		if (("".equals(ticket)) || (ticket == null)) {
			result.addElement("status").setText("2");
			result.addElement("code").setText("2");
			result.addElement("desc").setText("请传输入ticket!");
		} else {
			// 验证ticket
			String userKey = userMgr.getRemoteKey(ticket, request);
			logger.info("userKey================"+userKey);
			
			User user = userMgr.getUser(Long.valueOf(userKey));
			
			request.getSession().setAttribute(Constants.AUTHENTICATION_KEY, user);
			Org org = orgMgr.getOrg(user.getOrgId());
			request.getSession().setAttribute(Constants.ORGCODE_KEY,org);
			
			logger.info("userKey=============="+userKey);
			if (userKey == null) {
				result.addElement("status").setText("2");
				result.addElement("code").setText("2");
				result.addElement("desc").setText("ticket认证失败!");
			} else {
				result.addElement("status").setText("1");
				result.addElement("code").setText("1");
				result.addElement("desc").setText("请求成功！");
				
				//String tSql = "select a.oid as oid,a.sqnumber as id,a.name as title,IFNULL(a.creatdate,'') as creatdate,a.username as createUserName from tbl_applyinfos a,sys_dict_entry e ,sys_dict_entry f where a.applytype=e.DictId and e.DictTypeId='apply_type' and  a.status=f.DictId  and f.DictTypeId='apply_state' and  a.userid='"+userKey+"'  order by a.applydate desc"; 
				//List<Map> menuList=Jutil.executeSQL(tSql.toString());
				
				StringBuffer tSqlBuffer = new StringBuffer(32);
				tSqlBuffer.append("SELECT a.oid as oid,a.sqnumber as id,a.name as title,IFNULL(a.creatdate,'') as creatdate,a.username as createUserName ");
		    	tSqlBuffer.append("FROM tbl_applyinfos a JOIN tbl_activity_inst b ON a.remarkc = CONCAT(b.process_inst_id,'') ");
		    	tSqlBuffer.append("JOIN tbl_partic_inst c ON c.Activity_inst_Id= b.Activity_inst_Id JOIN tbl_activity_def d ON b.Activity_Def_Id=d.Activity_Def_Id ");
		    	tSqlBuffer.append("left join sys_dict_entry e on a.applytype=e.DictId and e.DictTypeId='apply_type' left JOIN sys_dict_entry f ON a.status=f.DictId  and f.DictTypeId='apply_state'");
		    	tSqlBuffer.append("WHERE  a.status='process' AND b.Current_State IN ('1','3') AND c.Excute_State IN ('1','3') ");
		    	tSqlBuffer.append("AND c.Partic_User_Id=");
		    	tSqlBuffer.append(user.getId());
		    	tSqlBuffer.append(" order by a.applydate desc");
				
		    	List<Map> menuList=Jutil.executeSQL(tSqlBuffer.toString());
				result.addElement("dataCount").setText(String.valueOf(menuList.size()));
				ObjectMapper mapper=new ObjectMapper();
				
				for (Map map : menuList) {
					marshallerTask(responseData,map);
				}
			}
		}
		logger.info("rootElement================="+rootElement.asXML());

		return rootElement.asXML();
	}
	
	/**
	 * 将呈批件列表转为xml数据
	 * 
	 * @param list
	 * @return
	 */
	public void marshallerTask(Element responseData,Map map) {
		Element Task = responseData.addElement("Task");
		Task.addElement("id").setText(map.get("id").toString());
		Task.addElement("title").setText(map.get("title").toString());
		Task.addElement("createUserName").setText(map.get("createUserName").toString());
		Task.addElement("level").setText("2");
		Task.addElement("url").setText("/auditApply/searchApplyInfos?backNav=none&flag=audit&applyId="+map.get("oid").toString());
		Task.addElement("urlType").setText("2");
		Task.addElement("createDate").setText(map.get("creatdate").toString());
	}
	
	public static void main(String[] args) {
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod("http://localhost:8080/htmis_hs0805/sync_data_req.jsp");
		try {
			//httpMethod.setRequestEntity(new StringRequestEntity("", "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			System.out.println(XmlOperate.formatXML(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void unMarshallerTask(){
		HttpClient client = new HttpClient();
		PostMethod httpMethod = new PostMethod("http://localhost:8080/htmis_hs0805/sync_data_req.jsp?ticket=121212");
		try {
			httpMethod.setRequestEntity(new StringRequestEntity("", "text/xlm", "utf-8"));
			client.executeMethod(httpMethod);
			String result = httpMethod.getResponseBodyAsString().trim();
			httpMethod.releaseConnection();
			System.out.println(XmlOperate.formatXML(result));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
