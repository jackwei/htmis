
package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>机构类别</strong><br>
 * <strong>Create on : 2013-07-10<br></strong>
 * <p><strong>Copyright (C) GIT Co.,Ltd.<br></strong></p>
 * @author git<br>
 */
public enum OrgType implements BaseEnum<String>
{
	C("机构","C"), D("部门","D");

	private String desc;
	private String code;
	
	private OrgType(String desc, String code)
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
