package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>Voucher</strong><br>
 * voucher 通用<br> 
 * <strong>Create on : 2013-11-6<br></strong>
 */
public enum VoucherStatus implements BaseEnum<String>
{
	Voucher1("未导出","1"),Voucher2("成功","2"),Voucher3("失败","3"),Voucher4("已回写","4");
	
	private String desc;
	private String code;
	
	private VoucherStatus(String desc,String code)
	{
		this.desc = desc;
		this.code = code;
	}

	public String getCode() {
		return this.code;
	}

	public String getDesc() {
		return this.desc;
	}
	
}
