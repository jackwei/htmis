package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>YesNo</strong><br>
 * Yes/No 通用<br> 
 * <strong>Create on : 2013-7-6<br></strong>
 */
public enum YesNo implements BaseEnum<String>
{
	Yes("是","1"),No("否","0");
	
	private String desc;
	private String code;
	
	private YesNo(String desc,String code)
	{
		this.desc = desc;
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String getDesc() {
		// TODO Auto-generated method stub
		return this.desc;
	}
	
	public static YesNo bool2YesNo(boolean flag)
	{
		if (flag)
		{
			return YesNo.Yes;
		}
		return YesNo.No;
	}
	
	public boolean boolValue()
	{
		if (this.equals(YesNo.Yes))
		{
			return true;
		}
		return false;
	}
}
