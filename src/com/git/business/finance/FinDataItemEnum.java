package com.git.business.finance;

import java.util.Date;

public enum FinDataItemEnum 
{	
	/* 批次号 */
	batchNo,
	/* 业务类型ID */
    bussId,
    /* 业务主键号码 */
    bussKeyNo,
    /* 科目编码 */
    itemId,
    /* 科目名称 */
    itemName,
    /* 借贷标志 */
    itemType,
    /* 金额 */
    money,
    /* 币种 */
    currency,
    /* 财务日期 */
    finDate,
    /* 组织机构 */
    orgCode,
    /* 公司段 */
    comCode,
    /* 部门段 */
    deptCode,
    /* 子目段，存储银行编号等信息 */
    bankCode,
    /* 业务段，辅助核算的业务号码信息 */
    bussCode,
    /* 产品段 */
    productCode,
    /* 往来科目段，往来第三方等财务编号 */
    transCode,
    /* 备用段，暂时不用*/
    backupCode,
    /* 备用字段，暂时不用 */
    extend1,

    extend2,

    extend3
}
