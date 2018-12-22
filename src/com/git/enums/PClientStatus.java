package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>第三方费用的处理状态</strong><br>
 * <strong>Create on : 2013-07-10<br>
 * </strong>
 * @author GIT<br>
 */
public enum PClientStatus implements BaseEnum<String>
{
	ClientFee0("已发账", "0"),ClientFee1("已到账","1"),ClientFee2("已保存未提交", "2"),ClientFee3("审批中", "3"),ClientFee4("待划付", "4"),
	ClientFee5("已申请批量划付", "5"),ClientFee6("已划付", "6");
	
	private String desc;
	private String code;
	
	private PClientStatus(String desc, String code)
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
