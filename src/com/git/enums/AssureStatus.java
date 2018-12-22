package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>担保处理状态</strong><br>
 * <strong>Create on : 2013-07-10<br>
 * </strong>
 * @author GIT<br>
 */
public enum AssureStatus implements BaseEnum<String>
{
	AssureStatus0("已保存未提交", "0"),AssureStatus1("已发账","1"),AssureStatus2("已到账", "2"),AssureStatus3("已申请待呈批", "3"),AssureStatus4("审批中", "4"),
	AssureStatus5("待划付", "5"),AssureStatus6("已划付", "6"),AssureStatus7("部分到账", "7");
	
	private String desc;
	private String code;
	
	private AssureStatus(String desc, String code)
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
