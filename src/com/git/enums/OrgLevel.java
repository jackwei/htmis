package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>机构层级</strong><br>
 * <strong>Create on : 2013-07-10<br></strong>
 * <p><strong>Copyright (C) GIT Co.,Ltd.<br></strong></p>
 * @author git<br>
 */
public enum OrgLevel implements BaseEnum<Integer>
{
	C1("总部",1),C2("分公司",2),C3("分支机构",3);
	private String desc;
	private Integer code;
	
	private OrgLevel(String desc,Integer code)
	{
		this.desc = desc;
		this.code = code;
	}

	@Override
	public Integer getCode()
	{
		return this.code;
	}

	@Override
	public String getDesc()
	{
		return this.desc;
	}
}
