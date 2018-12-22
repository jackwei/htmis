/**
 * 
 * 
 */
package com.git.util;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * @author Johnny 2013-4-1
 * 公共的后台数据校验方法
 */
public class JVerify
{
	private static final Log log=LogFactory.getLog(Log.class);
	public static HashMap ruleMap=new HashMap();
	static
	{
		ruleMap.put("REQUIRED","true");
		ruleMap.put("NN","true");
		ruleMap.put("CHAR","true");
		ruleMap.put("CHARNUM","true");
		ruleMap.put("INT","true");
		ruleMap.put("NUMBER","true");
		ruleMap.put("EMAIL","true");
		ruleMap.put("MOBILE","true");
		ruleMap.put("MXL","true");
		ruleMap.put("MNL","true");
		ruleMap.put("NMAX","true");
		ruleMap.put("NMIN","true");
		ruleMap.put("URL","true");
		ruleMap.put("IP","true");
	}
	
	public static boolean check(String ruleName,String ruleValue,String inputValue)
	{
		if(ruleName.toUpperCase().equals("REQUIRED")||ruleName.toUpperCase().equals("NN"))
		{
			return JVerify.isREQUIRED(inputValue);
		}
		else if(ruleName.toUpperCase().equals("CHAR"))
		{
			return JVerify.isCHAR(inputValue);
		}
		else if(ruleName.toUpperCase().equals("CHARNUM"))
		{
			return JVerify.isCHARNUM(inputValue);
		}
		else if(ruleName.toUpperCase().equals("INT"))
		{
			return JVerify.isINT(inputValue);
		}
		else if(ruleName.toUpperCase().equals("NUMBER"))
		{
			return JVerify.isNUMBER(inputValue);
		}
		else if(ruleName.toUpperCase().equals("EMAIL"))
		{
			return JVerify.isEMAIL(inputValue);
		}
		else if(ruleName.toUpperCase().equals("MOBILE"))
		{
			return JVerify.isMOBILE(inputValue);
		}
		else if(ruleName.toUpperCase().equals("MXL"))
		{
			return JVerify.isMXL(inputValue,ruleValue);
		}
		else if(ruleName.toUpperCase().equals("MNL"))
		{
			return JVerify.isMNL(inputValue,ruleValue);
		}
		else if(ruleName.toUpperCase().equals("NMAX"))
		{
			return JVerify.isNMAX(inputValue,ruleValue);
		}
		else if(ruleName.toUpperCase().equals("NMIN"))
		{
			return JVerify.isNMIN(inputValue,ruleValue);
		}
		else if(ruleName.toUpperCase().equals("URL"))
		{
			return JVerify.isURL(inputValue);
		}
		else if(ruleName.toUpperCase().equals("IP"))
		{
			return JVerify.isINT(inputValue);
		}
		else
		{
			return false;
		}
	}
	

	public static boolean isREQUIRED(String inputValue)
	{
		return inputValue!=null&&!"".equals(inputValue);
	}

	public static boolean isCHAR(String inputValue)
	{
		Pattern p=Pattern.compile("[a-zA-Z ._-]+");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
	
	public static boolean isCHARNUM(String inputValue)
	{
		Pattern p=Pattern.compile("[a-zA-Z0-9 ._-]+");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
	
	public static boolean isINT(String inputValue)
	{
		Pattern p=Pattern.compile("[-+]?[0-9]+");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
	
	public static boolean isNUMBER(String inputValue)
	{
		Pattern p=Pattern.compile("[-+]?\\d*\\.?\\d+");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
	
	public static boolean isEMAIL(String inputValue)
	{
		Pattern p=Pattern.compile("([a-zA-Z0-9_\\.\\-\\+%])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
	
	
	public static boolean isMOBILE(String inputValue)
	{
		Pattern p=Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(18[0-9]))\\d{8}$");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
	

	public static boolean isMXL(String inputValue,String ruleValue)
	{
		return inputValue.length()<=Integer.parseInt(ruleValue);
	}
	
	public static boolean isMNL(String inputValue,String ruleValue)
	{
		return inputValue.length()>=Integer.parseInt(ruleValue);
	}
	
	public static boolean isNMAX(String inputValue,String ruleValue)
	{
		return Double.parseDouble(inputValue)<=Double.parseDouble(ruleValue);
	}
	
	public static boolean isNMIN(String inputValue,String ruleValue)
	{
		return Double.parseDouble(inputValue)>=Double.parseDouble(ruleValue);
	}
	
	
	public static boolean isURL(String inputValue)
	{
		Pattern p=Pattern.compile("(http|https|ftp)\\:\\/\\/[a-z0-9\\-\\.]+\\.[a-z]{2,3}(:[a-z0-9]*)?\\/?([a-z0-9\\-\\._\\?\\,\\'\\/\\\\\\+&amp;%\\$#\\=~])*");
		Matcher m=p.matcher(inputValue.toLowerCase());
		boolean reslut=m.matches();
		return reslut;
	}
	
	public static boolean isIP(String inputValue)
	{
		Pattern p=Pattern.compile("\\b((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\.((?!\\d\\d\\d)\\d+|1\\d\\d|2[0-4]\\d|25[0-5])\\b");
		Matcher m=p.matcher(inputValue);
		boolean reslut=m.matches();
		return reslut;
	}
}
