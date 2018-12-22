package com.git.enums;

/**
 * <strong>Gender</strong><br>
 * <strong>Create on : 2013-07-10<br></strong>
 * <p><strong>Copyright (C) GIT Software Co.,Ltd.<br></strong></p>
 * @author GIT<br>
 */
public enum Gender
{
	M("男"),F("女"),U("未知");
	
	private String desc;
	
	private Gender(String desc)
	{
		this.desc = desc;
	}

	public String getDesc()
	{
		return this.desc;
	}
	
}
