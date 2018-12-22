package com.git.enums;

/**
 * <strong>公共状态定义</strong><br>
 * <strong>Create on : 2013-07-10<br></strong>
 * <p><strong>Copyright (C) GIT Co.,Ltd.<br></strong></p>
 * @author git<br>
 */

import dwz.framework.sys.lang.enums.BaseEnum;

public enum Status implements BaseEnum<String>
{
	Normal("正常","1"),Invalid("失效","2");
	
	private String desc;
	private String code;
	
	private Status(String desc,String code)
	{
		this.desc = desc;
		this.code = code;
	}
	
	public String getCode()
	{
		return this.code;
	}

	public String getDesc()
	{
		return this.desc;
	}
	
}
