package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>赔款到账处理状态</strong><br>
 * <strong>Create on : 2013-08-19<br>
 * </strong>
 * @author GIT<br>
 * @version <strong></strong><br>
 */
public enum InComeStatus implements BaseEnum<String>
{
	ClaimFee5("已到账", "0"),ClaimFee0("待提交", "1"),ClaimFee1("审批中","2"),
	ClaimFee2("待处理", "3"),ClaimFee3("处理完毕", "4"),ClaimFee4("赔款核销完毕", "5");
	
	private String desc;
	private String code;
	
	private InComeStatus(String desc, String code)
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
