package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>案件状态</strong><br>
 * <strong>Create on : 2013-07-10<br>
 * </strong>
 * @author GIT<br>
 */
public enum CaseStatus implements BaseEnum<String>
{
	CaseNew("已立案未发账", "0"),CaseAccPart("部分发账","1"),CaseAccFinal("Final账单", "2"),CaseAccEnd("完全到账", "3"),CaseEnd("已结案", "9");
	
	private String desc;
	private String code;
	
	private CaseStatus(String desc, String code)
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
