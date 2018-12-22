package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>账单状态</strong><br>
 * <strong>Create on : 2013-07-10<br>
 * </strong>
 * @author GIT<br>
 * @version <br>
 */
public enum AccStatus implements BaseEnum<String>
{
	AccNew("已保存未提交", "0"),AccSubmit("已提交","1"),AccNut("已到账核销", "2"),AccPart("部分到账","7");
	
	private String desc;
	private String code;
	
	private AccStatus(String desc, String code)
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
