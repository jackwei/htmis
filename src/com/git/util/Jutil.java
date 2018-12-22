package com.git.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.ibatis.session.RowBounds;
import org.dom4j.Document;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.WebUtils;

import com.git.db.beans.SysDictEntry;
import com.git.enums.OrgLevel;
import com.git.util.service.CommonService;
import com.git.util.service.CommonSqlService;
import com.git.util.service.impl.SequenceServiceImpl;

import dwz.framework.sys.business.BusinessFactory;
import dwz.framework.sys.lang.enums.BaseEnum;
import dwz.framework.sys.lang.enums.ExtEnumUtils;


public class Jutil 
{
	public static String webRootPath="";
	public static ServletContext servletContext=null;
	public static WebApplicationContext webApplicationContext =null;
	private static SequenceServiceImpl tSequenceServiceImpl=new SequenceServiceImpl();
	//public static MessageSource messageSource=new ClassPathXmlApplicationContext("spring/joylisten-messages.xml");;
	private static CommonSqlService mCommonSqlService = new CommonSqlService();
	
	private static CommonService mCommonService = BusinessFactory.getInstance().getService("commonService");;
	
	public static boolean sessionExist(HttpServletRequest request)
	{
		if(WebUtils.getSessionAttribute(request,"userSession")==null)
		{
			return false;
		}
		else
		{
			return true;
		}
	}
	
	/**
	 * 自定义查询SQL
	 * @param sql
	 * @return
	 */
	public static List executeSQL(String sql)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService = new CommonSqlService();
		}
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		List queryList=mCommonSqlService.executeSQL(parameterMap);
		return queryList;
	}
	
	/**
	 * 自定义查询SQL
	 * @param sql
	 * @return
	 */
	public static List executeSQL(Map parameterMap)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService= new CommonSqlService();
		}
		List queryList=mCommonSqlService.executeSQL(parameterMap);
		return queryList;
	}
	
	/**
	 * 自定义查询，并支持翻页，
	 * @param sql
	 * @param startIndex：起始条目
	 * @param count：一页显示多少条
	 * @return
	 */
	public static List executeSQL(String sql,int startIndex, int count)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService = new CommonSqlService();
		}
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		RowBounds rb = new RowBounds(startIndex, count);
		List queryList=mCommonSqlService.executeSQL(parameterMap,rb);
		return queryList;
	}
	
	/**
	 * 自定义查询，并支持翻页，
	 * @param sql
	 * @param startIndex：起始条目
	 * @param count：一页显示多少条
	 * @return
	 */
	public static List executeSQL(Map parameterMap,int startIndex, int count)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService= new CommonSqlService();
		}
		RowBounds rb = new RowBounds(startIndex, count);
		List queryList=mCommonSqlService.executeSQL(parameterMap,rb);
		return queryList;
	}
	
	public static int updateSQL(String sql)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService=new CommonSqlService();
		}
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		int rows=mCommonSqlService.updateSQL(parameterMap);
		return rows;
	}
	
	public static int insertSQL(String sql)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService=new CommonSqlService();
		}
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		int rows=mCommonSqlService.insertSQL(parameterMap);
		return rows;
	}
	
	public static int deleteSQL(String sql)
	{
		if(mCommonSqlService==null)
		{
			mCommonSqlService=new CommonSqlService();
		}
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		int rows=mCommonSqlService.deleteSQL(parameterMap);
		return rows;
	}
	
	/**
     * 获取唯一的返回值
     * @param sql String
     * @return String
     */
    public static String getOneValue(String sql,String colName)
    {
    	String tReturnValue = "";
    	
    	if(mCommonSqlService==null)
		{
			mCommonSqlService = new CommonSqlService();
		}
		Map parameterMap=new HashMap();
		parameterMap.put("SQL", sql);
		List queryList=mCommonSqlService.executeSQL(parameterMap);
		
		if(queryList != null && queryList.size() > 0)
		{
			Map tmpMap = (Map)queryList.get(0);
			tReturnValue =String.valueOf(tmpMap.get(colName));
		}
		
        return StrTool.cTrim(tReturnValue);
    }
	
	public static Log getLogger(Class logClass)
	{
		Log log = LogFactory.getLog(logClass);
		return log;
	}
	public static Object getBean(String beanName)
	{
		if(webApplicationContext==null)
		{
			webApplicationContext=ContextFactory.getWebApplicationContext();
		}
		return webApplicationContext.getBean(beanName);
	}
	/*
	public static String getMessage(String name)
	{
		return messageSource.getMessage(name,null,Locale.CHINA);
		
	}
	public static String getMessage(String name,Object[] o)
	{
		return messageSource.getMessage(name,o,Locale.CHINA);
	}
	*/
	
	public static List<String> tokenizerToList(String str, String split)
	{
		List list = new ArrayList();
		StringTokenizer st = new StringTokenizer(str, split);
		while (st.hasMoreElements())
		{
			list.add(st.nextToken());
		}
		return list;
	}
	
	public static synchronized long getSequence(String sequenceName)
	{
		return tSequenceServiceImpl.getSequence(sequenceName);
	}

	public static synchronized String getSequence(String sequenceName,
			String prefix, String suffix)
	{
		return tSequenceServiceImpl.getSequence(sequenceName, prefix, suffix);
	}
	
	public static synchronized String getSequence(String sequenceName,
			String prefix, String suffix,int intLength,char appendchar,char LRApp)
	{
		return tSequenceServiceImpl.getSequence(sequenceName, prefix, suffix,intLength,appendchar,LRApp);
	}
	
	public static Document parse(org.w3c.dom.Document doc) throws Exception { 
    if (doc == null) { 
    return (null); 
    } 
    org.dom4j.io.DOMReader xmlReader = new org.dom4j.io.DOMReader(); 
    return (xmlReader.read(doc)); 
  } 
  
  /** 
  * org.dom4j.Document -> org.w3c.dom.Document 
  * @param doc Document(org.dom4j.Document) 
  * @throws Exception 
  * @return Document 
  */ 
  public static org.w3c.dom.Document parse(Document doc) throws Exception { 
    if (doc == null) { 
    return (null); 
    } 
    java.io.StringReader reader = new java.io.StringReader(doc.asXML()); 
    org.xml.sax.InputSource source = new org.xml.sax.InputSource(reader); 
    javax.xml.parsers.DocumentBuilderFactory documentBuilderFactory = 
      javax.xml.parsers.DocumentBuilderFactory.newInstance(); 
    javax.xml.parsers.DocumentBuilder documentBuilder = documentBuilderFactory. 
      newDocumentBuilder(); 
    return (documentBuilder.parse(source)); 
  }
  
  public static String filterSQL(String inputString)
  {
	  return StringEscapeUtils.escapeSql(inputString);
  }
  
  public static String filterHTML(String inputString)
  {
	  return StringEscapeUtils.escapeHtml(inputString);
  }
  public static String[] filterHTML(String inputString[])
  {
	  int arrayLength=inputString.length;
	  String[] returnString=new String[arrayLength];
	  for(int i=0;i<arrayLength;i++)
	  {
		  returnString[i]=Jutil.filterHTML(inputString[i]);
	  }
	  return returnString;
  }
  
  public static String serializeObject(String fileName,List<Object> objectList)
  {
	  try
	  {
		  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		  out.writeObject(Integer.valueOf(objectList.size()));
		  for(Object obj:objectList)
		  {
			  out.writeObject(obj);
		  }
		  
		  out.close();
	  }
	  catch(Exception e)
	  {
		  return null;
	  }
	  return fileName;
  }
  
  public static String serializeObject(String fileName,Object o)
  {
	  try
	  {
		  ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName));
		  out.writeObject(Integer.valueOf(1));
		  out.writeObject(o);
		  
		  out.close();
	  }
	  catch(Exception e)
	  {
		  return null;
	  }
	  return fileName;
  }
  
  public static List<Object> deserializeObject(String fileName)
  {
	  List<Object> objectList=new ArrayList();
	  try
	  {
		  ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
		  boolean haveObject=true;
		  int objectSize=(Integer)in.readObject();
		  while(objectSize>0)
		  {
			  Object o=in.readObject();
			  objectList.add(o);
			  objectSize--;
		  }
		  
	  }
	  catch(Exception e)
	  {
		  return null;
	  }
	  return objectList;
  }
  
  /**
   * 根据数据字典类型查询书籍字典列表
   * @param dictTypeId
   * @return
   */
  public static List getDictEntry(String dictTypeId)
  {	  
	  List<Map> returnList=mCommonService.getDict(dictTypeId);
	
	  return returnList;
  }
  
  /**
   * 根据字典类型和父字典ID查询数据字典列表
   * @param dictTypeId
   * @param tParentDictId
   * @return
   */
  public static List getDictEntry(String dictTypeId,String tParentDictId)
  {	  
	  List<Map> returnList=mCommonService.getDict(dictTypeId);
	
	  return returnList;
  }
  
  /**
   * 根据字典类型和字典id查询数据字典名称
   * @param record
   * @return
   */
  public static String getDictName(String dictTypeId,String dictId){
	  String name="";
	  String sql="select * from sys_dict_entry where dicttypeid ='"+dictTypeId+"' and dictid='"+dictId+"'";
	  List ls=executeSQL(sql);
	  HashMap map=null;
	  if(ls!=null && ls.size()!=0){
		   map=(HashMap) executeSQL(sql).get(0);
		   name=map.get("DictName").toString();
	  }
	  return name;
  }
  
  /**
   * 根据自己传入的参数集对短信内容进行解析并替换
   * @param tInContent
   * @param tCalValueSet
   * @return
   */
  public static String calRealContentByValue(String tInContent,HashMap tCalValueSet)
  {
      String tContent, tStr = "", tStr1 = "",tRealValue = "";
      tContent = tInContent;
      try
      {
          while (true)
          {
              tStr = PubFun.getStr(tContent, 2, "#");
              if (tStr.equals(""))
              {
                  break;
              }
              tRealValue = String.valueOf(tCalValueSet.get(tStr));
              tStr1 = "#" + tStr.trim() + "#";
              //替换变量
              tContent = StrTool.replaceEx(tContent, tStr1, tRealValue);
          }
      }
      catch (Exception ex)
      {
      	ex.printStackTrace();
      }
      
      return tContent;
  }
    
  /**
   * 根据传入的参数集合，解释SQL语句中的变量，并返回完整的SQL语句
   * @return 解析后的ＳＱＬ
   */
  public static String interpretInSQL(MMap tCalValueSet,String tSqlIn)
  {
      String tSql, tStr = "", tStr1 = "";
      tSql = tSqlIn;
      try
      {
          while (true)
          {
              tStr = PubFun.getStr(tSql, 2, "?");
              if (tStr.equals(""))
                  break;
              tStr1 = "?" + tStr.trim() + "?";
              //替换变量
              tSql = StrTool.replaceEx(tSql, tStr1,tCalValueSet.get(tStr).toString());
          }
      }
      catch (Exception ex)
      {
      	ex.printStackTrace();
      }
      
      return tSql;
  }
  
  /**
   * 根据传入的参数集合，解释SQL语句中的变量，并返回完整的SQL语句
   * @return 解析后的ＳＱＬ
   */
  public static String interpretInContent(HashMap tCalValueSet,String tInContent)
  {
      String tContent, tStr = "", tStr1 = "";
      tContent = tInContent;
      try
      {
          while (true)
          {
              tStr = PubFun.getStr(tContent, 2, "#");
              if (tStr.equals(""))
                  break;
              tStr1 = "#" + tStr.trim() + "#";
              //替换变量
              tContent = StrTool.replaceEx(tContent, tStr1, (String)tCalValueSet.get(tStr));
          }
      }
      catch (Exception ex)
      {
      	ex.printStackTrace();
      }
      
      return tContent;
  }
  
  /**
   * 根据账单明细id查询案件所在机构的编码
   * @param billDetailId
   * @return
   */
  public static String getOrgCodeByBillDetail(Long billDetailId)
  {
	  return Jutil.getOneValue("SELECT c.orgcode orgCode FROM tbl_case_Bill_Detail a,tbl_case_bill b,tbl_case c WHERE a.bill_id = b.bill_id AND b.case_id = c.case_id AND detail_id = '"+billDetailId+"'", "orgCode");
  }
  
  /**
   * 根据账单明细id查询案件所在机构的编码
   * @param billDetailId
   * @return
   */
  public static String getOrgCodeByCaseId(Long claimId)
  {
	  return Jutil.getOneValue("SELECT c.orgcode orgCode FROM tbl_case c WHERE c.case_id = '"+claimId+"'", "orgCode");
  }
  
  public static void main(String[] args)
  {   	
	  BaseEnum t = ExtEnumUtils.getRequiredByCode(1, OrgLevel.values());
	  System.out.println("Desc======"+t.getDesc());
  }
}
