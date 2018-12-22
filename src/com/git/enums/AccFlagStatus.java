package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>YesNo</strong><br>
 * Yes/No 通用<br> 
 * <strong>Create on : 2013-7-6<br></strong>
 */
public enum AccFlagStatus implements BaseEnum<String>
{
	AccFlag0("未发账","0"),AccFlag1("部分发账","1"),AccFlag2("已发账","2");
	
	private String desc;
	private String code;
	
	private AccFlagStatus(String desc,String code)
	{
		this.desc = desc;
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}
	
}
