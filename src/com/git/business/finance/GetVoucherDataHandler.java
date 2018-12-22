package com.git.business.finance;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Element;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.business.voucher.VoucherServiceMgr;
import com.git.db.beans.FinData;
import com.git.db.beans.FinDataResult;
import com.git.util.PubDateUtil;

import dwz.framework.sys.business.BusinessFactory;

public class GetVoucherDataHandler {
	Log log = LogFactory.getLog(GetVoucherDataHandler.class);
		
	/*< huatai>
	< businessType > GET_VOUCHER</ businessType >
	< result >
	<status>1</status>
	<code>1</code>
	<desc>请求成功！</desc>
	<dataCount>13</dataCount>
	</result>
	< responseData >
	*/
	public void marshallFinData(List<FinData> finDataList,Element rootElement){
		Element result = rootElement.addElement("result");
		result.addElement("status").setText("1");
		result.addElement("code").setText("1");
		result.addElement("desc").setText("请求成功!");
		result.addElement("dataCount").setText(String.valueOf(finDataList.size()));
		Element responseData = rootElement.addElement("responseData");
		
		for (FinData finData : finDataList) {
			Element voucher = responseData.addElement("Voucher");
			voucher.addAttribute("id",finData.getBatchNo());
			voucher.addAttribute("desc",finData.getFinName());
			voucher.addAttribute("version","1.0");
			marshallerVoucher(finData, voucher);
		}
	}
	
   /*<Voucher id="主键" desc="备注"  version="1.0">
		<voucher_head><!-- 凭证头 -->
		<create_date> 创建日期 格式:2012-11-06 12:12</create_date>
		<create_user> 创建人</create_user>
		<modify_date> 修改日期 格式:2012-11-06 12:12</modify_date>
		<modify_user> 修改人</modify_user>
		<voucher_type>凭证类型 1发账 2到账 3付款 ...</voucher_type>
		<remark>备注/摘要</remark>
		<currency>凭证币种：CNY/JPY/USD..</currency>
		<reserve1 >保留字段1</reserve1>
		<reserve2 />保留字段2</reserve1>
		<amount>凭证的金额合计</amount>
		</voucher_head>*/
	public void marshallerVoucher(FinData finData,Element voucher){
		VoucherServiceMgr voucherServiceMgr =  BusinessFactory.getInstance().getService("voucherServiceMgr");

		Element head = voucher.addElement("voucher_head");
		head.addElement("create_date").setText(PubDateUtil.dateFormat(new Date(), "yyyy-MM-dd HH:mm"));
		head.addElement("create_user").setText(finData.getMakeUser());
		head.addElement("modify_date").setText(PubDateUtil.dateFormat(finData.getMakeTime(), "yyyy-MM-dd HH:mm"));
		head.addElement("modify_user").setText(finData.getMakeUser());
		head.addElement("voucher_type").setText(finData.getBussId());
		head.addElement("name").setText(finData.getFinName()); //凭证名称/日记账名称
		head.addElement("remark").setText(finData.getBussKeyNo());
		head.addElement("currency").setText(finData.getCurrency());
		head.addElement("reserve1").setText("");
		head.addElement("reserve1").setText("");
		/*凭证的借方或者贷方金额合计*/
		head.addElement("amount").setText(finData.getMoney().toString());
		
		Element body = voucher.addElement("voucher_body");
		Map<String, String> criterias = new HashMap<String, String>();
		criterias.put("batchNo", finData.getBatchNo());
		Map<Object, Object> map = voucherServiceMgr.searchFinDataResult(criterias);
		
		List<FinDataResult> finDataResultList = (List)map.get("FinDataResultList");
		for (FinDataResult finDataResult : finDataResultList) {
			marshallerEntry(finDataResult, body);
		}
		
	}
	
	
	/*	
	 * <id>科目id，与业务系统ID有关</id>
		<type>*类型 1：借 2贷</type>
		<code>*科目编号</code>
		<summary>*描述</summary>
		<document_id>票据号，在科目是银行或往来时，可以填写此项</document_id>
		<document_date>票据日期，在科目是银行或往来时，可以填写此项 格式:2012-11-06</document_date>
		<currency>*币种</currency>
		<exchange_rate1>折本币汇率</exchange_rate1>
		<amount1>*原币金额</amount1>
		<amount2>折本币金额</amount2>
		<unit_price>单价 ,在科目有数量核算时，填写此项,在科目有数量核算时，填写此项</unit_price>
		<credit_quantity>数量</credit_quantity>
		<auxiliary_accounting>
		<item name="company_id">公司段编号 *例:北京海旅,天津海旅.的编号..对应部门表中的code2</item>
		<item name="dept_id">部门段编号 *科目有部门核算时不能为空,对应部门表中的code</item>
		<item name="personnel_id" >个人往来员工编号 *科目有个人核算时不能为空,对应用户表中的code</item>
		<item name="cust_id" >客户往来编号	*科目有客户核算时不能为空</item>
		<item name="supplier_id" >供应商往来编号	*科目有供应商核算时不能为空</item>
		<item name="item_class" >项目大类	*科目有项目核算时不能为空</item>
		<item name="item_id">项目编号	*科目有项目核算时不能为空(经纪业务数据都需对应项目编号)</item>
		<item name="bank_id" >银行子目编号,默认为0,如果科目为银行时需要设置此目,例:中行-基本户的编号</item>
		<item name="cash_flow" >现金流编号,现金类科目会需要设置此号，业务做账会给到</item>
		<item name="operator" >业务员</item>
		<item name="self_define1">扩展备注:oracle中的捕获信息</item>
	         公司段编号、子目编码、现金流*/
	
	public void marshallerEntry(FinDataResult finDataResult,Element body){
		Element entry = body.addElement("entry");
		entry.addElement("id").setText(finDataResult.getBussId());
		entry.addElement("type").setText(finDataResult.getItemType().equals("D") ? "1":"2");
		entry.addElement("code").setText(finDataResult.getItemId());
		entry.addElement("summary").setText(finDataResult.getItemName());
		entry.addElement("document_id").setText(finDataResult.getDocumentId()==null ? "":finDataResult.getDocumentId());
		entry.addElement("document_date").setText(finDataResult.getDocumentDate()==null ? "":finDataResult.getDocumentDate().toString());
		entry.addElement("currency").setText(finDataResult.getCurrency());
		entry.addElement("exchange_rate1").setText("0");
		entry.addElement("amount1").setText(String.valueOf(finDataResult.getMoney()));
		entry.addElement("amount2").setText("");
		entry.addElement("unit_price").setText("");
		entry.addElement("credit_quantity").setText("");
		Element accounting = entry.addElement("auxiliary_accounting");
		/*添加公司段编号--1105--*/
		accounting.addElement("item").addAttribute("name", "company_id").setText(finDataResult.getComCode());
		//accounting.addElement("company_id").setText(finDataResult.getComCode());
		accounting.addElement("item").addAttribute("name", "dept_id").setText(finDataResult.getDeptCode());
		accounting.addElement("item").addAttribute("name", "personnel_id").setText("");
		accounting.addElement("item").addAttribute("name", "cust_id").setText("");
		accounting.addElement("item").addAttribute("name", "supplier_id").setText("");
		accounting.addElement("item").addAttribute("name", "item_class").setText("");
		accounting.addElement("item").addAttribute("name", "item_id").setText("");
		accounting.addElement("item").addAttribute("name", "bank_id").setText(finDataResult.getBankCode());
		
		/*业务段与备用段编码 --1107--*/
		accounting.addElement("item").addAttribute("name", "business_id").setText("0");
		
		accounting.addElement("item").addAttribute("name", "reserve_id").setText("0");
		
		/*添加现金流- 不能为0  -1105--*/
		accounting.addElement("item").addAttribute("name", "cash_flow").setText(finDataResult.getBackupCode());
		
		accounting.addElement("item").addAttribute("name", "operator").setText("");
		/* 扩展备注:oracle中的捕获信息 --1211 */
		accounting.addElement("item").addAttribute("name", "self_define1").setText(finDataResult.getBussKeyNo());
		accounting.addElement("item").addAttribute("name", "self_define2").setText("");
		accounting.addElement("item").addAttribute("name", "self_define3").setText("");
		accounting.addElement("item").addAttribute("name", "self_define4").setText("");
		accounting.addElement("item").addAttribute("name", "self_define5").setText("");
		accounting.addElement("item").addAttribute("name", "self_define6").setText("");
		accounting.addElement("item").addAttribute("name", "self_define7").setText("");
		accounting.addElement("item").addAttribute("name", "self_define8").setText("");
		accounting.addElement("item").addAttribute("name", "self_define9").setText("");
		accounting.addElement("item").addAttribute("name", "self_define10").setText("");
		accounting.addElement("item").addAttribute("name", "self_define11").setText("");
		accounting.addElement("item").addAttribute("name", "self_define12").setText("");
		accounting.addElement("item").addAttribute("name", "self_define13").setText("");
		accounting.addElement("item").addAttribute("name", "self_define14").setText("");
		accounting.addElement("item").addAttribute("name", "self_define15").setText("");
		accounting.addElement("item").addAttribute("name", "self_define16").setText("");
	}

}
