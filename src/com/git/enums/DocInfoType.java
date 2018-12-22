package com.git.enums;

import dwz.framework.sys.lang.enums.BaseEnum;

/**
 * <strong>附件类型</strong><br>
 * <strong>Create on : 2013-08-19<br>
 * </strong>
 * @author GIT<br>
 * @version <strong></strong><br>
 */
public enum DocInfoType implements BaseEnum<String>
{
	applydoc("赔款呈批件", "applydoc"),bangdoc("挂账单","bangdoc"),inComedoc("到账单", "inComedoc"),
	pcasedoc("第三方","pcasedoc"),thirdparty("第三方呈批件","thirdparty"),
	assure("担保呈批件","assuredoc"),claimdoc("赔款到账","claimdoc"),
	claimPaydoc("赔款划付","claimPaydoc"),thirdPay("第三方划付","thirdPay"),
	thirdApply("第三方到账","thirdApply");
	
	private String desc;
	private String code;
	
	private DocInfoType(String desc, String code)
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
