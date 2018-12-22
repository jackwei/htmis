package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>划付状态</strong><br>
 * <strong>Create on : 2013-07-10<br>
 * </strong>
 * @author GIT<br>
 */
public enum PayStatus implements BaseEnum<String>
{
	PayNew("录入", "0"),PayApply("申请","1"),PayEnd("完成", "2");
	
	private String desc;
	private String code;
	
	private PayStatus(String desc, String code)
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
