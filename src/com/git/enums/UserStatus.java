package com.git.enums;

/**
 * <strong>用户状态</strong><br>
 * <strong>Create on : 2013-07-10<br></strong>
 * <p><strong>Copyright (C) GIT Co.,Ltd.<br></strong></p>
 * @author git<br>
 */
import dwz.framework.sys.lang.enums.BaseEnum;

public enum UserStatus implements BaseEnum<String>
{
	Pending("未启用","0"),Normal("正常","1"),Invalid("失效","2"),Inactive("冻结","3")/*,Delete("已删除",4)*/;
	
	private String desc;
	private String code;
	
	private UserStatus(String desc,String code)
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
