package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>赔款处理状态</strong><br>
 * <strong>Create on : 2013-07-10<br>
 * </strong>
 * @author GIT<br>
 * @version <strong></strong><br>
 */
public enum ClaimStatus implements BaseEnum<String>
{
	/**待提交*/
	ClaimFee0("待提交", "0"),
	/**审批中*/
	ClaimFee1("审批中","1"),
	/**待处理*/
	ClaimFee2("待处理", "2"),
	/**处理完毕*/
	ClaimFee3("处理完毕", "3"),
	/**赔款核销完毕*/
	ClaimFee4("赔款核销完毕", "4");
	
	private String desc;
	private String code;
	
	private ClaimStatus(String desc, String code)
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
