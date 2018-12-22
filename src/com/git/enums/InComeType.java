package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>进账单类型</strong><br>
 * <strong>Create on : 2013-08-19<br>
 * </strong>
 * @author GIT<br>
 * @version <strong></strong><br>
 */
public enum InComeType implements BaseEnum<String>
{
	InComeType1("案件账单", "1"),InComeType2("担保账单","2"),InComeType3("其他", "3");
	
	private String desc;
	private String code;
	
	private InComeType(String desc, String code)
	{
		this.desc = desc;
		this.code = code;
	}
	
	@Override
	public String getCode()
	{
		return this.code;
	}
	
	@Override
	public String getDesc()
	{
		return this.desc;
	}
}
