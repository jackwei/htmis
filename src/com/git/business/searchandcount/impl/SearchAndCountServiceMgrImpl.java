package com.git.business.searchandcount.impl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.searchandcount.SearchAndCountServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

@Transactional(rollbackFor = Exception.class) 
@Service("searchAndCountServiceMgr")
public class SearchAndCountServiceMgrImpl extends
		AbstractBusinessObjectServiceMgr implements SearchAndCountServiceMgr {

	// 单选框分组信息处理
	public Map<String,String> group(HttpServletRequest request) {
		Map<String,String> map = new HashMap<String,String>(); 
		// 分组项信息
		String radio = request.getParameter("groupname");
		String group = null;
		String gid = null;
		// 按案件性质分组
		if (radio.equals("casetypename")) {
			group = "a.casetypename as groupid, a.casetypename as groupname";
			gid = "a.casetypename";
		}
		// 按委托人分类分组
		if (radio.equals("consignortypename") || radio.equals("third") || radio.equals("rewarranter") || radio.equals("property")) {
			group = "a.consignortypeid as groupid, a.consignortypename as groupname";
			gid = "a.consignortypeid";
		}
		// 按委托人名称（简称）分组
		if (radio.equals("consignorsn")) {
			group = "a.consignorid as groupid, a.consignorsn as groupname";
			gid = "a.consignorid";
		}
		// 按案发口岸分组
		if (radio.equals("accidentport")) {
			group = "a.accidentportid as groupid, a.accidentport as groupname";
			gid = "a.accidentportid";
		}
		// 按主办机构分组
		if (radio.equals("oraname")) {
			group = "a.orgcode as groupid, a.oraname as groupname";
			gid = "a.orgcode";
		}
		// 按主办人分组
		if (radio.equals("username")) {
			group = "a.userid as groupid, a.username as groupname";
			gid = "a.userid";
		}
		//按反担保人评级（只对担保账务，担保明细有搜索功能）
//		if(radio.equals("property")) {
//			group = "a.propertyid as groupid, a.propertyname as groupname";
//			gid = "a.propertyid";
//		}
		map.put("group", group);
		map.put("gid", gid);
		return map;
	}

	// 单选框分组信息处理b
	public String groupb(HttpServletRequest request) {
		System.out.println("单选框处理1");
		 
		// 分组项信息
		//正式
//		String radio = request.getParameter("radio");
		//测试用
		String radio = request.getParameter("groupname");
		System.out.println("radio2:"+radio);
		String group = null;
		// 按案件性质分组
		if (radio.equals("casetypename")) {
			group = "casetypename";
		}
		// 按委托人分类分组
		if (radio.equals("consignortypename") || radio.equals("third") || radio.equals("rewarranter") || radio.equals("property")) {
			group = "consignortypename";
		}
		// 按委托人名称（简称）分组
		if (radio.equals("consignorsn")) {
			group = "consignorid";
		}
		// 按案发口岸分组
		if (radio.equals("accidentport")) {
			group = "accidentportid";
		}
		// 按主办机构分组
		if (radio.equals("oraname")) {
			group = "orgcode";
		}
		// 按主办人分组
		if (radio.equals("username")) {
			group = "userid";
		}

		return group;
	}

	// 所有输入查询条件处理
	public String condition(HttpServletRequest request, StringBuffer sf) {
		// 查询标识判断
		String searchflag = request.getParameter("searchflag");
		System.out.println("查询标识判断3："+searchflag);

		// 各种时间段
		String timetype = request.getParameter("timetype");
		String startdate = request.getParameter("startdate");
		String enddate = request.getParameter("enddate");

		// 案件性质
		String casetypename = request.getParameter("casetypename");
		
		// 新增的查询某个时间段立案且某个时间段发账的案件
		String accstart = request.getParameter("accstart");
		String accend = request.getParameter("accend");

		// 委托人分类及名称
//		String sort = request.getParameter("sort");
		String sort = request.getParameter("consignorType.DictName");
		System.out.println("委托人分类:"+sort);
//		String names = request.getParameter("names");
		String names = request.getParameter("orgLookup.oid");
		System.out.println("委托人名称:"+names);

		// 船名及事发口岸
		String shipname = request.getParameter("sp");
//		String accidentport = request.getParameter("accidentport");
		String accidentport = request.getParameter("accidentport.oid");

		// 主办机构及主办人,协办机构及协办人
		String zorg = request.getParameter("orgLookupf.id");
		String zuser = request.getParameter("userLookupf.id");
		String xorg = request.getParameter("orgLookups.id");
		String xuser = request.getParameter("userLookups.id");
		
/*		String zorg = request.getParameter("zorg");
		String zuser = request.getParameter("zuser");
		String xorg = request.getParameter("xorg");
		String xuser = request.getParameter("xuser");*/

		// 第三方及反担保人,反担保人评级
		String third = request.getParameter("third.oid");
		String rewarranter = request.getParameter("rewarranter.oid");
		String propertyid = request.getParameter("propertyname.DictId");
		String propertyname = request.getParameter("propertyname.DictName");
		
		/*String third = request.getParameter("third");
		String rewarranter = request.getParameter("rewarranter");
		String propertyname = request.getParameter("propertyname");*/

		// 是否发账、到账及账单状态
		String billstatus = request.getParameter("billstatus");
		String arrstatus = request.getParameter("arrstatus");
		String feestatuse = request.getParameter("feestatuse");
		
		//案件金额区间查询
		String money1 = request.getParameter("money1");
		String money2 = request.getParameter("money2");

		// 担保币种查询
		String currency = request.getParameter("currency");

		// 反担保人所在地区、委托人归属区域
		String country = request.getParameter("country");
		String area = request.getParameter("area");

		// 收件人、寄件人、快递单号
		String receiver = request.getParameter("receiver");
		String sender = request.getParameter("sender");
		String trackingNumber = request.getParameter("trackingNumber");
		

		// 案件查询及案件统计标识判断
		if (!"".equals(timetype) && null != timetype && !"0".equals(timetype)) {
			// 出具时间
			if ("t1".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(caseid) from tbl_passureinfos b where b.issuedate between '"
						+ startdate + "' and '" + enddate + "')) ");
			}
			// 撤回时间
			if ("t9".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(caseid) from tbl_passureinfos b where b.backdate between '"
						+ startdate + "' and '" + enddate + "')) ");
			}
			// 立案时间
			if ("t2".equals(timetype)) {
				sf.append("and (a.setdate between '" + startdate + "' and '" + enddate + "') ");
			}
			// 案发时间
			if ("t3".equals(timetype)) {
				sf.append("and (a.accidentdate between '" + startdate + "' and '" + enddate + "') ");
			}
			// 发账时间
			if ("t4".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.accdate between '"
						+ startdate + "' and '" + enddate + "')) ");
			}
			// 到账时间
			if ("t5".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.arrdate between '"
						+ startdate + "' and '" + enddate + "')) ");
			}
			// 委请时间
			if ("t6".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.bill_id in(select DISTINCT(bill_id) from tbl_case_bill_detail c where c.bussno = 'thirdPart' and c.applydate between '"
						+ startdate + "' and '" + enddate + "'))) ");
			}
			// 划付时间
			if ("t7".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.bill_id in(select DISTINCT(bill_id) from tbl_case_bill_detail c where c.bussno = 'thirdPart' and c.paydate between '"
						+ startdate + "' and '" + enddate + "'))) ");
			}
			// 报告时间
			if ("t8".equals(timetype)) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.bill_id in(select DISTINCT(bill_id) from tbl_case_bill_detail c where c.bussno = 'thirdPart' and c.reportdate between '"
						+ startdate + "' and '" + enddate + "'))) ");
			}
		} else {
			// 立案时间
			if (!"".equals(startdate) && null != startdate && !"".equals(enddate) && null != enddate) {
				sf.append("and (a.setdate between '" + startdate + "' and '" + enddate + "') ");
			}
		}
		
		// 案件性质
		if (!"".equals(casetypename) && null != casetypename && !"0".equals(casetypename)) {
			sf.append("and a.casetypename = '" + casetypename + "' ");
		}
		
		// 发账时间(此处需要进行判断！！)
		if (null != accstart && !"".equals(accstart) && null != accend && !"".equals(accend)) {
			sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.accdate between '"
					+ accstart + "' and '" + accend + "')) ");
		}

		/* 到账时间
		 if(null!=arrstart && !"".equals(arrstart) && null!=arrend &&
		 !"".equals(arrend)){
		 sf.append("and (a.case_id in (select DISTINCT(caseid) from tbl_passureinfos b where b.arrdate between '"+startdate+"' and '"+enddate+"')) ");
		 } */
		
		// 委托人分类
		if (!"".equals(sort) && null != sort) {
			sf.append("and a.consignortypename = '" + sort + "' ");
		}

		// 委托人名称
		if (!"".equals(names) && null != names) {
			sf.append("and a.consignorid = '" + names + "' ");
		}
		
		// 船名
		if (!"".equals(shipname) && null != shipname) {
			sf.append("and a.shipname = '" + shipname + "' ");
		}

		// 事发口岸
		if (!"".equals(accidentport) && null != accidentport) {
			sf.append("and a.accidentportid = '" + accidentport + "' ");
		}
		
		// 主办机构
		if (!"".equals(zorg) && null != zorg) {
			sf.append("and a.orgcode = '" + zorg + "' ");
		}
		// 主办人
		if (!"".equals(zuser) && null != zuser) {
			sf.append("and a.userid = '" + zuser + "' ");
		}
		
		// 协办机构
		if (!"".equals(xorg) && null != xorg) {
			sf.append("and (a.case_id in (select distinct(case_id) from tbl_case_handle b where b.orgid = '"
					+ xorg + "')) ");
		}

		//协办人
		if (!"".equals(xuser) && null != xuser) {
			sf.append("and (a.case_id in (select distinct(case_id) from tbl_case_handle b where b.user_id = '"
					+ xuser + "')) ");
		}
		
		//第三方
		if(!"".equals(third) && null != third){
			sf.append("and (a.case_id in (select distinct(case_id) from tbl_case_bill b where b.bill_id in (select distinct(bill_id) from tbl_case_bill_detail c where c.consignorid ='"
					+ third +"'))) ");
		}
		
		//反担保人
		if(!"".equals(rewarranter) && null != rewarranter){
			sf.append("and (a.case_id in (select distinct(caseid) from tbl_passureinfos b where b.rewarranterid = '"
					+ rewarranter +"')) ");
		}
		
		// 是否发账
		if (null != billstatus && !"".equals(billstatus) && !"0".equals(billstatus)) {
			sf.append("and a.accflag = '" + billstatus + "' ");
		}
		
		// 是否到账
		if (null != arrstatus && !"".equals(arrstatus) && !"0".equals(arrstatus)) {
			if("1".equals(arrstatus)){
				sf.append("and a.casestatus >=3 ");
			}else{
				sf.append("and a.casestatus <3 ");
			}
		}
		
		//案件金额
		if(!"casesearch".equals(searchflag)){
			if (null!= money1 && !"".equals(money1)){
				sf.append("and b.income >= " + money1 + " ");
			}
			if (null!= money2 && !"".equals(money2)){
				sf.append("and b.income <= " + money2 + " ");
			}
		}

		
		// 反担保人评级
		if(!"".equals(propertyname) && null != propertyname){
			sf.append("and (a.case_id in (select distinct(caseid) from tbl_passureinfos b where b.rewarranttype = '"
					+ propertyname +"')) ");
		}


		// 币种查询
		if ("billcount".equals(searchflag) || "billcountdetail".equals(searchflag) || "thirdinfos".equals(searchflag) || "passureinfos".equals(searchflag)) {
			if (!"".equals(currency) && null != currency && !"0".equals(currency)) {
				//担保币种
				sf.append("and b.currency = '" + currency + "' ");
			}
		} else {
			if (!"".equals(currency) && null != currency && !"0".equals(currency)) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_passureinfos b where b.currency = '" + currency + "')) ");
			}
		}
		
		// 反担保人所在地
		if (!"".equals(country) && null != country) {
			sf.append("and (a.case_id in (select DISTINCT(caseid) FROM tbl_passureinfos b WHERE b.rewarranterid IN (SELECT c.rewarranterid FROM tbl_rewarranter c WHERE c.country = '"
					+ country + "'))) ");
		}
		
		//委托人归属区域
		if (!"".equals(area) && null != area){
			sf.append("and (a.consignorid in (select DISTINCT(consignorid) FROM tbl_consignor g WHERE g.country ='" + area + "') ");
		}

		// 收件人
		if (!"".equals(receiver) && null != receiver) {
			sf.append("and (a.case_id in (select DISTINCT(caseid) FROM tbl_passureinfos b WHERE b.rewarranterid IN (SELECT c.rewarranterid FROM tbl_rewarranter c WHERE c.receiver = '"
					+ receiver + "'))) ");
		}

		// 寄件人
		if (!"".equals(sender) && null != sender) {
			sf.append("and (a.case_id in (select DISTINCT(caseid) FROM tbl_passureinfos b WHERE b.rewarranterid IN (SELECT c.rewarranterid FROM tbl_rewarranter c WHERE c.guaranteeSender = '"
					+ sender + "'))) ");
		}

		// 快递单号
		if (!"".equals(trackingNumber) && null != trackingNumber) {
			sf.append("and (a.case_id in (select DISTINCT(caseid) FROM tbl_passureinfos b WHERE b.rewarranterid IN (SELECT c.rewarranterid FROM tbl_rewarranter c WHERE c.guaranteeExpressNumber = '"
					+ trackingNumber + "'))) ");
		}

		// 账单状态
		if (!"passureinfos".equals(searchflag)) {
			if (!"".equals(feestatuse) && null != feestatuse) {
				sf.append("and (a.case_id in (select DISTINCT(case_id) from tbl_case_bill b where b.feestatuse = '" + feestatuse + "')) ");
			}
		}else{
			// 账单状态查询
			if (!"".equals(feestatuse) && null != feestatuse) {
				sf.append("and b.feestatuse = '" + feestatuse + "' ");
			}
		}

		System.out.println("sf:"+sf.toString());
		return sf.toString();
	}

	// 标准 报表-使用wabacus实现

}
