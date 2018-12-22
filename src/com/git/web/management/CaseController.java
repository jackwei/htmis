package com.git.web.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.PassureInfos.PassureInfos;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.caseService.CaseBillDetailServiceMgr;
import com.git.business.caseService.CaseBillServiceMgr;
import com.git.business.caseService.CaseConditionVO;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.caseService.CaseSuperviseMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.handle.CaseHandleServiceMgr;
import com.git.business.process.CaseBillDetail;
import com.git.business.sys.Org;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseHandleImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.CaseSuperviseImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.TblPassureInfosExample;
import com.git.enums.AccStatus;
import com.git.enums.AssureStatus;
import com.git.enums.CaseStatus;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.git.util.dwz.AjaxObject;
import com.git.util.excel.XlsExport;
import com.git.web.BaseController;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.ibm.icu.text.SimpleDateFormat;

import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value="/management/case")
public class CaseController extends BaseController{
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private CaseBillServiceMgr caseBillServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private CaseHandleServiceMgr caseHandleServiceMgr; 
	
	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;
	
	@Autowired
	private CaseSuperviseMgr caseSuperviseMgr;
	
	
	
	@Log(message="{0} 结束案件 {1}。")
	@RequestMapping("/close")
	public ModelAndView closeCase(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		String caseId = request.getParameter("caseId");
		if("".equals(caseId) || null==caseId){
			return ajaxDoneError("请先保存案件信息!");
		}
		
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		
		if(caseInfoImpl == null){
			return ajaxDoneError("案件不存在，请检查!");
		}
		
		List<CaseBillImpl> caseBillList =  caseBillServiceMgr.searchCaseBillByCaseId(caseId);
		
		for (CaseBillImpl caseBillImpl : caseBillList) {
			if(caseBillImpl.getAccdate() == null){
				return ajaxDoneError("账单未发账，不能进行结案!");
			}
			List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetailByBillId(caseBillImpl.getBillId().toString(), "");
			
			for (CaseBillDetailImpl caseBillDetailImpl : caseBillDetailList) {
				if(caseBillDetailImpl.getArrdate() ==null){
					return ajaxDoneError("账单未到账，不能进行结案!");
				}
			}
		}
		
		List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByCaseId(caseInfoImpl.getCaseId().toString());

		for (CaseClaimImpl caseClaimImpl : caseClaimList) {
			if(!caseClaimImpl.getStatus().equals(ClaimStatus.ClaimFee4)){
				return ajaxDoneError("划款申请未处理完毕，不能进行结案!");
			}
		}
		
		caseInfoImpl.setCasestatus(CaseStatus.CaseEnd.getCode());
		caseInfoImpl.setEnddate(new Date());
		caseServiceMgr.updateCase(caseInfoImpl);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),caseInfoImpl.getCasenumber()}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@Log(message="{0} 恢复案件 {1}。")
	@RequestMapping("/recover")
	public ModelAndView recoverCase(HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		String caseId = request.getParameter("caseId");
		
		if("".equals(caseId) || null==caseId){
			return ajaxDoneError("操作错误");
		}
		
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		caseInfoImpl.setCasestatus(CaseStatus.CaseNew.getCode());
		caseServiceMgr.updateCase(caseInfoImpl);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),caseInfoImpl.getCasenumber()}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("")
	public ModelAndView list(HttpServletRequest request,CaseConditionVO vo){
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);
		
		ModelAndView modelAndView = new ModelAndView();
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", vo.getCasenumber());
		criterias.put("shipname", vo.getShipname());
		criterias.put("excasenumber", vo.getExcasenumber());
		criterias.put("billstatus", request.getParameter("billstatus"));
		criterias.put("consignorsn", vo.getConsignorsn());
		if(null != request.getParameter("casestatus")){
			criterias.put("casestatus", request.getParameter("casestatus").toString());
		}
		/*显示所有已经发账且存在第三方费用，并且含有第三方费用的账单全部确认到账*/
		criterias.put("thirdpart", request.getParameter("thirdpart"));
		
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>)caseInfoMap.get("caseList");
		int count = Integer.valueOf(caseInfoMap.get("count").toString());
		vo.setTotalCount(count);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("caseList",caseList);
		modelAndView.addObject("casestatus",request.getParameter("casestatus"));
		modelAndView.addObject("orgType",org.getOrgType());
		modelAndView.setViewName("/management/case/caseList");
		return  modelAndView;
	}
	
	//案件监督
	@RequestMapping("/csupervise")
	public ModelAndView csupervise(HttpServletRequest request,CaseConditionVO vo){
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
	    Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);

		//第一个选项卡查询所有案件
		ModelAndView modelAndView = new ModelAndView();
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("excasenumber", request.getParameter("excasenumber"));
		criterias.put("billstatus", request.getParameter("billstatus"));
		criterias.put("consignorsn", request.getParameter("consignorsn"));
		if(null != request.getParameter("casestatus")){
			criterias.put("casestatus", request.getParameter("casestatus").toString());
		}
		/*显示所有已经发账且存在第三方费用，并且含有第三方费用的账单全部确认到账*/
//		criterias.put("thirdpart", request.getParameter("thirdpart"));
		
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>)caseInfoMap.get("caseList");
		int count = Integer.valueOf(caseInfoMap.get("count").toString());
		vo.setTotalCount(count);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("caseList",caseList);
		modelAndView.addObject("casestatus",request.getParameter("casestatus"));
		modelAndView.addObject("orgType",org.getOrgType());
//		modelAndView.setViewName("/management/case/caseList");
		
		//第二至第五个选项卡
/*		String condition = "";		
		if(user.getExtend2().indexOf("分公司主管") >= 0){
			  condition+=" and a.orgcode = "+user.getOrgCode();
		}
		
		//立案6个月未发账案件
		BaseConditionVO vo1 = new BaseConditionVO();
	   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
       Calendar rightNow = Calendar.getInstance();
       rightNow.setTime(new Date());
       rightNow.add(Calendar.MONTH, -6);        
       String sDate = sdf.format(rightNow.getTime());
       
//		String date = PubDateUtil.getCurrentDateByMonth(-6).toString();
       //第一部分立案六个月未生成账单
       String one = "select a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,'' currency,'' servicefee,'' expendses,'' assurefee,'' thirdpart, '' otherfee, '' compensationsub, '' feeamount from tbl_case a where a.`feecount` = 0 and a.`Create_Time` < '"+sDate+"' "+condition;
       //第二部分立案六个月有账单但未发账
       one += " union all select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.otherfee,b.compensationsub,b.feeamount from tbl_case a, tbl_case_bill b WHERE a.case_id = b.case_id and b.bill_id is not null and b.accdate is null and a.`Create_Time` < '"+sDate+"' "+condition;
       //第三部分案件中最后一个账单为中期账单（非final账单）且六个月内未再发新账单
	   one += " union all select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.otherfee,b.compensationsub,b.feeamount from tbl_case a, tbl_case_bill b WHERE a.case_id = b.case_id AND a.casestatus =1 AND a.`Create_Operator` ="+user.getId()+" AND (a.case_id in (SELECT acc1.case_id from (SELECT a.case_id ,MAX(b.`Bill_Id`)FROM tbl_case a,tbl_case_bill b WHERE a.case_id = b.`Case_Id` and  b.accdate is not null and b.accdate < '"+sDate+"'  GROUP BY a.case_id  )acc1))  ";
		List<CaseInfoImpl> caselistone = Jutil.executeSQL(one, vo1.getStartIndex(), vo1.getPageSize());
		String count1 = "select count(1) as count from ("+one+") one";
		int total1= Integer.valueOf(Jutil.getOneValue(count1.toString(), "count"));
		vo1.setTotalCount(total1);
		modelAndView.addObject("caselistone",caselistone);
		modelAndView.addObject("total1",total1);
		
		
		//待提交审批第三方费用案件
		BaseConditionVO vo2 = new BaseConditionVO();
		String sql = "select distinct a.* from tbl_case_bill_detail d,tbl_case_bill b,tbl_case a where d.`Bill_Id` = b.`Bill_Id` and b.`Case_Id`=a.`Case_Id` AND b.`thirdpart` > 0 AND b.`arrdate` IS NOT NULL AND d.`paydate` IS NULL and d.status < 3 "+condition;
		List<CaseInfoImpl> caseIdListtwo = Jutil.executeSQL(sql, vo2.getStartIndex(), vo2.getPageSize());
		String count2 = "select count(1) as count from ("+sql+") two";
		int total2= Integer.valueOf(Jutil.getOneValue(count2.toString(), "count"));
		vo2.setTotalCount(total2);
//		modelAndView.addObject("vo2",vo2);
		modelAndView.addObject("total2",total2);
		modelAndView.addObject("caseIdListtwo",caseIdListtwo);

		
		//发账3个月未到账账单
		BaseConditionVO vo3 = new BaseConditionVO();
		rightNow.clear();
		rightNow.setTime(new Date());
		rightNow.add(Calendar.MONTH, -3);
		String tDate = sdf.format(rightNow.getTime());
		String sqlthree = "select a.case_id as caseid,a.shipname,a.excasenumber,b.* from tbl_case a, tbl_case_bill b where a.case_id = b.case_id and b.feestatuse <> 2 and b.accdate is not null and b.accdate < '"+ tDate +"' "+condition;
		List<CaseInfoImpl> caselistthree = Jutil.executeSQL(sqlthree, vo3.getStartIndex(), vo3.getPageSize());
		String count3 = "select count(1) as count from ("+sqlthree+") three";
		int total3= Integer.valueOf(Jutil.getOneValue(count3.toString(), "count"));
		vo3.setTotalCount(total3);
//		modelAndView.addObject("vo3",vo3);
		modelAndView.addObject("total3",total3);
		modelAndView.addObject("caselistthree",caselistthree);
		
		
		//已到账未登记账单
		BaseConditionVO vo4 = new BaseConditionVO();
		String sqlt4 = "select * from (select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,c.payername,c.differamount,c.changeamount,c.tradedate,c.`Create_Time` from tbl_case a,tbl_bill_income c where a.casenumber=c.feenumber and c.checkdate is null and a.feecount = 0 and a.Create_Operator ="+user.getId();
		String link = " union ";
		String sqlfour = "select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,c.payername,c.differamount,c.changeamount,c.tradedate,c.`Create_Time` from tbl_case a, tbl_case_bill b, tbl_bill_income c where a.case_id = b.case_id and b.casenumber = c.feenumber and c.checkdate is null and b.accdate is null and b.Operator_Id ="+user.getId()+" ";
		String sql4 = "SELECT a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,b.payername,b.changeamount,b.differamount,b.tradedate,b.`Create_Time` FROM tbl_case a,tbl_bill_income b WHERE b.`differamount` > (SELECT IFNULL(sum(c.replaceamount),0) FROM tbl_case_bill c WHERE c.`casenumber` = b.`feenumber` and c.feestatuse =1) AND a.casenumber=b.feenumber AND b.checkdate IS NULL and a.Create_Operator ="+user.getId()+") t ORDER BY t.`Create_Time` DESC";
		
		String sql4 = "SELECT a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,b.payername,b.currency,b.changeamount,b.differamount,b.tradedate,b.`Create_Time` FROM tbl_case a,tbl_bill_income b WHERE b.`differamount` > (SELECT IFNULL(sum(c.replaceamount),0) FROM tbl_case_bill c WHERE c.`casenumber` = b.`feenumber` and  c.`accdate` IS NOT NULL) AND a.casenumber=b.feenumber AND b.checkdate IS NULL "+condition+" ORDER BY b.`Create_Time` DESC";

		List<CaseInfoImpl> caselistfour = Jutil.executeSQL(sql4, vo4.getStartIndex(), vo4.getPageSize());
		String count4 = "select count(1) as count from ("+sql4+") four";
		int total4= Integer.valueOf(Jutil.getOneValue(count4.toString(), "count"));
		vo4.setTotalCount(total4);
		modelAndView.addObject("total4",total4);
		modelAndView.addObject("caselistfour",caselistfour);*/
		
		modelAndView.setViewName("/management/case/csupervise");
		return  modelAndView;
	}
	
	
	//第一个选项卡搜索刷新
	@RequestMapping("/csup")
	public ModelAndView csup(Model model, BaseConditionVO vo,HttpServletRequest request) {
	    Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);

		//第一个选项卡所有案件
		ModelAndView modelAndView = new ModelAndView();
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("excasenumber", request.getParameter("excasenumber"));
		criterias.put("billstatus", request.getParameter("billstatus"));
		criterias.put("consignorsn", request.getParameter("consignorsn"));
		if(null != request.getParameter("casestatus")){
			criterias.put("casestatus", request.getParameter("casestatus").toString());
		}
		
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List<CaseInfoImpl> caseList = (List<CaseInfoImpl>)caseInfoMap.get("caseList");
		int count = Integer.valueOf(caseInfoMap.get("count").toString());
		vo.setTotalCount(count);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("caseList",caseList);
		modelAndView.addObject("orgType",org.getOrgType());
		modelAndView.setViewName("/management/case/csup");
		return modelAndView;
	}
	
	
	//立案6个月未发账案件搜索刷新
	@RequestMapping("/cfirst")
	public ModelAndView casefirst(Model model, BaseConditionVO vo,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		ModelAndView modelAndView = new ModelAndView();
		String condition = "and a.casestatus <> '9' ";
		//第一部分查询条件
		String condition1 = "";
		//二、三部分查询条件
		String condition2 = "";
		//主页查询标识main
		String supflag = request.getParameter("supflag");
		if(null!=supflag && !"".equals(supflag)){
			if(supflag.equals("main")){
				condition1 = condition + " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" )) ";
				if(user.getExtend2().indexOf("担保") >= 0){
				   condition2 = condition + " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+") or b.assurefee > 0) ";
			   }else{
				   condition2 = condition + " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" )) and b.assurefee = 0 ";
				}
				  modelAndView.addObject("supflag", supflag);
				  //主页div查询标识
				  modelAndView.addObject("divflag", "first");
			}
		}else{
			if(user.getExtend2().indexOf("分公司主管") >= 0){
			    condition1=" and a.orgcode = "+user.getOrgCode();
			    condition2 = condition1;
			}
			//案件监督div查询标识
				  modelAndView.addObject("divflag", "first1");
		}
		//设置查询条件
		if(!"".equals(request.getParameter("casenumber")) && null !=request.getParameter("casenumber") ){
			condition1+=" and a.casenumber like '%"+request.getParameter("casenumber").toString()+"%' ";
			condition2+=" and a.casenumber like '%"+request.getParameter("casenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("shipname")) && null !=request.getParameter("shipname")){
			condition1+=" and a.shipname like '%"+request.getParameter("shipname").toString()+"%' ";
			condition2+=" and a.shipname like '%"+request.getParameter("shipname").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("excasenumber")) && null !=request.getParameter("excasenumber") ){
			condition1+=" and a.excasenumber like '%"+request.getParameter("excasenumber").toString()+"%' ";
			condition2+=" and a.excasenumber like '%"+request.getParameter("excasenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("billstatus")) && null != request.getParameter("billstatus")){
			condition1+=" and a.accflag = '"+request.getParameter("billstatus").toString()+"' ";
			condition2+=" and a.accflag = '"+request.getParameter("billstatus").toString()+"' ";
		}
		if(!"".equals(request.getParameter("consignorsn")) && null != request.getParameter("consignorsn")){
			condition1+=" and (a.consignorsn like '%"+request.getParameter("consignorsn").toString()+"%' or a.consignorname like '%"+request.getParameter("consignorsn").toString()+"%') ";
			condition2+=" and (a.consignorsn like '%"+request.getParameter("consignorsn").toString()+"%' or a.consignorname like '%"+request.getParameter("consignorsn").toString()+"%') ";
		}

	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
      Calendar rightNow = Calendar.getInstance();
      rightNow.setTime(new Date());
      rightNow.add(Calendar.MONTH, -6);        
      String sDate = sdf.format(rightNow.getTime());
      
      //第一部分立案六个月未生成账单
      String one = "select a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,'' currency,'' servicefee,'' expendses,'' assurefee,'' thirdpart, '' otherfee, '' compensationsub, '' feeamount from tbl_case a where a.`feecount` = 0 and a.`Create_Time` < '"+sDate+"' "+condition1;
      //第二部分立案六个月有账单但未发账
      one += " union all select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.otherfee,b.compensationsub,b.feeamount from tbl_case a, tbl_case_bill b WHERE a.case_id = b.case_id and b.bill_id is not null and b.accdate is null and a.`Create_Time` < '"+sDate+"' "+condition2;
      //第三部分案件中最后一个账单为中期账单（非final账单）且六个月内未再发新账单
	  one += " union all select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.otherfee,b.compensationsub,b.feeamount from tbl_case a, tbl_case_bill b WHERE a.case_id = b.case_id AND a.casestatus =1 AND (a.case_id in (SELECT acc1.case_id from (SELECT a.case_id ,MAX(b.`Bill_Id`)FROM tbl_case a,tbl_case_bill b WHERE a.case_id = b.`Case_Id` and  b.accdate is not null and b.accdate < '"+sDate+"' "+condition2+" GROUP BY a.case_id  )acc1))  ";
	  List<CaseInfoImpl> caselistone = Jutil.executeSQL(one, vo.getStartIndex(), vo.getPageSize());
	  String count1 = "select count(1) as count from ("+one+") one";
	  int total1= Integer.valueOf(Jutil.getOneValue(count1.toString(), "count"));
	  vo.setTotalCount(total1);
	  modelAndView.addObject("caselistone",caselistone);
	  modelAndView.addObject("total1", total1);
	  modelAndView.addObject("vo",vo);
	  modelAndView.setViewName("/management/case/first");
	  return modelAndView;
	}
	
	
	//待提交审批第三方费用案件搜索刷新
	@RequestMapping("/csecond")
	public ModelAndView csecond(Model model, BaseConditionVO vo,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		ModelAndView modelAndView = new ModelAndView();
		String condition = " and a.casestatus <> '9' ";
		String supflag = request.getParameter("supflag");
		if(null!=supflag && !"".equals(supflag)){
			if(supflag.equals("main")){
				if(user.getExtend2().indexOf("担保") >= 0){
					   condition += " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+") or b.assurefee > 0) ";
				   }else{
					   condition += " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" )) and b.assurefee = 0 ";
					}
				  modelAndView.addObject("supflag", supflag);
				  modelAndView.addObject("divflag", "second");
			}
		}else{
			if(user.getExtend2().indexOf("分公司主管") >= 0){
			    condition=" and a.orgcode = "+user.getOrgCode();
			}
			modelAndView.addObject("divflag", "second1");
		}	
		//设置查询条件
		if(!"".equals(request.getParameter("casenumber")) && null !=request.getParameter("casenumber") ){
			condition+=" and a.casenumber like '%"+request.getParameter("casenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("shipname")) && null !=request.getParameter("shipname")){
			condition+=" and a.shipname like '%"+request.getParameter("shipname").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("excasenumber")) && null !=request.getParameter("excasenumber") ){
			condition+=" and a.excasenumber like '%"+request.getParameter("excasenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("billstatus")) && null != request.getParameter("billstatus")){
			condition+=" and a.accflag = '"+request.getParameter("billstatus").toString()+"' ";
		}
		if(!"".equals(request.getParameter("consignorsn")) && null != request.getParameter("consignorsn")){
			condition+=" and (a.consignorsn like '%"+request.getParameter("consignorsn").toString()+"%' or a.consignorname like '%"+request.getParameter("consignorsn").toString()+"%') ";
		}

       //待提交审批第三方费用案件
		String sql = "select distinct a.* from tbl_case_bill_detail d,tbl_case_bill b,tbl_case a where d.`Bill_Id` = b.`Bill_Id` and b.`Case_Id`=a.`Case_Id` AND b.`thirdpart` > 0 AND b.`arrdate` IS NOT NULL AND d.`paydate` IS NULL and d.status < 3 "+condition;
		List<CaseInfoImpl> caseIdListtwo = Jutil.executeSQL(sql, vo.getStartIndex(), vo.getPageSize());
		String count2 = "select count(1) as count from ("+sql+") two";
		int total2= Integer.valueOf(Jutil.getOneValue(count2.toString(), "count"));
		vo.setTotalCount(total2);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("total2",total2);
		modelAndView.addObject("caseIdListtwo",caseIdListtwo);
		modelAndView.setViewName("/management/case/second");
	  return modelAndView;
	}
	
	
	//发账3个月未到账账单搜索刷新
	@RequestMapping("/cthird")
	public ModelAndView cthird(Model model, BaseConditionVO vo,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		ModelAndView modelAndView = new ModelAndView();
		String condition = " and a.casestatus <> '9' ";						
		String supflag = request.getParameter("supflag");
		if(null!=supflag && !"".equals(supflag)){
			if(supflag.equals("main")){
				if(user.getExtend2().indexOf("担保") >= 0){
					   condition += " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+") or b.assurefee > 0) ";
				   }else{
					   condition += " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" )) and b.assurefee = 0 ";
					}
				modelAndView.addObject("supflag", supflag);
				modelAndView.addObject("divflag", "third");
			}
		}else{
			if(user.getExtend2().indexOf("分公司主管") >= 0){
			    condition=" and a.orgcode = "+user.getOrgCode();
			}
			modelAndView.addObject("divflag", "third1");
		}	
		//设置查询条件
		if(!"".equals(request.getParameter("casenumber")) && null !=request.getParameter("casenumber") ){
			condition+=" and a.casenumber like '%"+request.getParameter("casenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("shipname")) && null !=request.getParameter("shipname")){
			condition+=" and a.shipname like '%"+request.getParameter("shipname").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("excasenumber")) && null !=request.getParameter("excasenumber") ){
			condition+=" and a.excasenumber like '%"+request.getParameter("excasenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("billstatus")) && null != request.getParameter("billstatus")){
			condition+=" and a.accflag = '"+request.getParameter("billstatus").toString()+"' ";
		}
		if(!"".equals(request.getParameter("consignorsn")) && null != request.getParameter("consignorsn")){
			condition+=" and (a.consignorsn like '%"+request.getParameter("consignorsn").toString()+"%' or a.consignorname like '%"+request.getParameter("consignorsn").toString()+"%') ";
		}

		//发账3个月未到账账单
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	    Calendar rightNow = Calendar.getInstance();
	    rightNow.setTime(new Date());
		rightNow.add(Calendar.MONTH, -3);
		String tDate = sdf.format(rightNow.getTime());
		String sqlthree = "select a.case_id as caseid,a.shipname,a.excasenumber,b.* from tbl_case a, tbl_case_bill b where a.case_id = b.case_id and b.feestatuse <> 2 and b.accdate is not null and b.accdate < '"+ tDate +"' "+condition;
		List<CaseInfoImpl> caselistthree = Jutil.executeSQL(sqlthree, vo.getStartIndex(), vo.getPageSize());
		String count3 = "select count(1) as count from ("+sqlthree+") three";
		int total3= Integer.valueOf(Jutil.getOneValue(count3.toString(), "count"));
		vo.setTotalCount(total3);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("total3",total3);
		modelAndView.addObject("caselistthree",caselistthree);
		modelAndView.setViewName("/management/case/third");
	  return modelAndView;
	}
	
	
	//已到账未登记搜索刷新
	@RequestMapping("/cfour")
	public ModelAndView cfour(Model model, BaseConditionVO vo,HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		ModelAndView modelAndView = new ModelAndView();
		String condition = " and a.casestatus <> '9' ";						
		String supflag = request.getParameter("supflag");
		if(null!=supflag && !"".equals(supflag)){
			if(supflag.equals("main")){
				condition+=" and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" ))";
				if(user.getExtend2().indexOf("担保") >= 0){
					   condition += " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+") or b.incometype = 2 ) ";
				   }else{
					   condition += " and (a.Create_Operator = "+user.getId()+"  or a.Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" )) and b.incometype <> 2 ";
					}
				modelAndView.addObject("supflag", supflag);
				modelAndView.addObject("divflag", "four");
			}
		}else{
			if(user.getExtend2().indexOf("分公司主管") >= 0){
			    condition=" and a.orgcode = "+user.getOrgCode();
			}
			modelAndView.addObject("divflag", "four1");
		}	
		//设置查询条件
		if(!"".equals(request.getParameter("casenumber")) && null !=request.getParameter("casenumber") ){
			condition+=" and a.casenumber like '%"+request.getParameter("casenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("shipname")) && null !=request.getParameter("shipname")){
			condition+=" and a.shipname like '%"+request.getParameter("shipname").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("excasenumber")) && null !=request.getParameter("excasenumber") ){
			condition+=" and a.excasenumber like '%"+request.getParameter("excasenumber").toString()+"%' ";
		}
		if(!"".equals(request.getParameter("billstatus")) && null != request.getParameter("billstatus")){
			condition+=" and a.accflag = '"+request.getParameter("billstatus").toString()+"' ";
		}
		if(!"".equals(request.getParameter("consignorsn")) && null != request.getParameter("consignorsn")){
			condition+=" and (a.consignorsn like '%"+request.getParameter("consignorsn").toString()+"%' or a.consignorname like '%"+request.getParameter("consignorsn").toString()+"%') ";
		}

		//已到账未登记账单
     	String sql4 = "SELECT a.case_id AS caseid,a.shipname,a.casenumber,a.excasenumber,b.payername,b.currency,b.changeamount,b.differamount,b.tradedate,b.`Create_Time` FROM tbl_case a,tbl_bill_income b WHERE b.`differamount` > (SELECT IFNULL(sum(c.replaceamount),0) FROM tbl_case_bill c WHERE c.`casenumber` = b.`feenumber` and  c.`accdate` IS NOT NULL) AND a.casenumber=b.feenumber AND b.checkdate IS NULL "+condition+" ORDER BY b.`Create_Time` DESC";

		List<CaseInfoImpl> caselistfour = Jutil.executeSQL(sql4, vo.getStartIndex(), vo.getPageSize());
		int total4 = Jutil.executeSQL(sql4).size();
		vo.setTotalCount(total4);
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("total4",total4);
		modelAndView.addObject("caselistfour",caselistfour);
		modelAndView.setViewName("/management/case/four");
	  return modelAndView;
	}
	
	//财务通知刷新
	@RequestMapping("/list2")
	public ModelAndView list2(Model model, BaseConditionVO vo,HttpServletRequest request) {
	    ModelAndView modelAndView = new ModelAndView();
	    String flag = "list2";
		
		//已发账单提醒
		String sqlfive = "select a.case_id as caseid,a.shipname,a.casenumber,a.excasenumber,a.username,b.feenumber,b.currency,b.servicefee,b.expendses,b.assurefee,b.thirdpart,b.feeamount,b.accdate from tbl_case a,tbl_case_bill b where a.case_id = b.case_id and b.accdate is not null AND b.`feestatuse` <> 2 ";
		List<CaseInfoImpl> caselistfive = Jutil.executeSQL(sqlfive,vo.getStartIndex(), vo.getPageSize());
		String count5 = "select count(1) as count from ("+sqlfive+") one";
		int total5= Integer.valueOf(Jutil.getOneValue(count5.toString(), "count"));
		vo.setTotalCount(total5);
		modelAndView.addObject("vo", vo);
		modelAndView.addObject("total5",total5);
		modelAndView.addObject("caselistfive", caselistfive);
		modelAndView.addObject("flag", flag);
		modelAndView.setViewName("/notice/list2");
		return modelAndView;
	}
	
	/**
	 * 显示所有已经发账且存在第三方费用，并且含有第三方费用的账单全部确认到账
	 * @throws Exception 
	 * @throws JsonMappingException 
	 * @throws JsonGenerationException 
	 * */
	@RequestMapping("/search")
	public ModelAndView search(HttpServletRequest request,BaseConditionVO vo) throws JsonGenerationException, JsonMappingException, Exception{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);
		ModelAndView modelAndView = new ModelAndView();
		
		//String sql = "select distinct b.`Case_Id` from tbl_case_bill_detail d,tbl_case_bill b where d.`Bill_Id` = b.`Bill_Id` and d.`status` = '0' and b.`Operator_Id`="+user.getId();
		String sql = "select distinct c.* from tbl_case_bill_detail d,tbl_case_bill b,tbl_case c where d.`Bill_Id` = b.`Bill_Id` and b.`Case_Id`=c.`Case_Id` and d.`status` = '0' and b.`Operator_Id`="+user.getId();
		
		List<CaseInfoImpl> caseIdList = Jutil.executeSQL(sql);
		
		/*List<CaseInfoImpl> caseList = new ArrayList<CaseInfoImpl>();
		
		for (int i = 0; i < caseIdList.size(); i++) {
			Map ids = (Map) caseIdList.get(i);
			caseList.add(caseServiceMgr.getCaseInfo(ids.get("Case_Id").toString()));
		}*/
		String count = Jutil.getOneValue(sql.replace("distinct c.*", "COUNT(distinct c.`Case_Id` ) as count"),"count");
		vo.setTotalCount(Integer.valueOf(count));
		modelAndView.addObject("vo",vo);
		modelAndView.addObject("caseList",caseIdList);
		modelAndView.addObject("orgType",org.getOrgType());
		modelAndView.addObject("casestatus",request.getParameter("casestatus"));
		modelAndView.setViewName("/management/case/caseList");
		return  modelAndView;
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		model.addAttribute("caseInfoImpl",new CaseInfoImpl());
		return "/management/case/caseEdit";
	}
	
	@RequestMapping("/getSupervise")
	public String getSupervise(Model model,HttpServletRequest request){
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		String caseId = request.getSession().getAttribute("caseId").toString();
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("caseId", caseId);
		
		Map<Object, Object>  caseSuperviseMap = caseSuperviseMgr.searchSupervise(criterias);
		
		List<CaseSuperviseImpl> caseSuperviseImplList =(List<CaseSuperviseImpl>)caseSuperviseMap.get("caseSuperviseImplList");
		
		model.addAttribute("caseSuperviseImplList",caseSuperviseImplList);
		return "/management/case/caseSupervise";
	}
	
	@RequestMapping(value = "/insertSupervise", method = RequestMethod.POST)
	public ModelAndView insertSupervise(HttpServletRequest request,CaseSuperviseImpl caseSuperviseImpl){
		String caseId = request.getSession().getAttribute("caseId").toString();
		if("".equals(request.getParameter("content"))){
			return ajaxDoneError("建议内容不能为空!");
		}
		caseSuperviseImpl.setCaseid(Long.valueOf(caseId));
		caseSuperviseMgr.addSupervise(caseSuperviseImpl);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/edit/{caseId}")
	public String edit(@PathVariable("caseId") String caseId, Model model,HttpServletRequest request) throws ServiceException{
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);

		model.addAttribute("caseInfoImpl", caseInfoImpl);
		if(request.getParameter("flag") !=null){
			model.addAttribute("flag", request.getParameter("flag"));
		}else{
			model.addAttribute("flag", "edit");
		}
		
		BaseConditionVO vo =  new BaseConditionVO();
		vo.setPageNum(1);
		vo.setPageSize(0);
		
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		/**获取我的账单信息*/
		criterias.put("caseId", caseInfoImpl.getCaseId());
		List<CaseBillImpl> caseBillList = caseBillServiceMgr.searchCaseBill(criterias,vo);
		model.addAttribute("caseBillList",caseBillList);
		model.addAttribute("accstatus", AssureStatus.values());
		vo.setTotalCount(caseBillList.size());
		model.addAttribute("vo", vo);
		
		/**获取汇款申请信息*/
		List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByCaseId(caseInfoImpl.getCaseId().toString());
		model.addAttribute("caseClaimList", caseClaimList);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		
		/**获取协办人信息*/
		List<CaseHandleImpl> caseHandleList = caseHandleServiceMgr.searchCaseHandle(criterias, vo);
		model.addAttribute("caseHandleList", caseHandleList);
		
		/**获取第三方信息*/
		List<String> caseConsignorList=caseBillDetailServiceMgr.getCaseBillDetail(caseId, "thirdPart", vo);
		vo.setTotalCount(caseBillDetailServiceMgr.getCaseBillDetailCount(caseId, "thirdPart"));
		model.addAttribute("vo", vo);
		model.addAttribute("caseConsignorList", caseConsignorList);
		model.addAttribute("caseId",caseId);
		
		/**查询赔款大于0的到账信息*/
		criterias.clear();
		criterias.put("differamount", 1);
		criterias.put("Islocked", "no");
		List<ClaimIncomeImpl> claimIncomeList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, caseInfoImpl.getCasenumber());
		model.addAttribute("vo", vo);
		model.addAttribute("claimIncomeList", claimIncomeList);
		
		/**查询中再担保*/
		criterias.clear();
		criterias.put("caseId", caseInfoImpl.getCaseId());
		BaseConditionVO vo2 = new BaseConditionVO();
		vo2.setPageNum(1);
		List<PassureInfos> passurelist = passureInfosServiceMgr.searchAllPassureInfos(vo2, criterias);
		TblPassureInfosExample example = new TblPassureInfosExample();
		int total = passureInfosServiceMgr.countPassureInfos(example, criterias);
		vo2.setTotalCount(total);
		model.addAttribute("passurelist", passurelist);
		model.addAttribute("vo2", vo2);
		
		request.getSession().setAttribute("caseId", caseId);
		request.getSession().setAttribute("casenumber", caseInfoImpl.getCasenumber());
		request.getSession().setAttribute("shipname", caseInfoImpl.getShipname());
		
		
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		//枚举类显示担保状态
		model.addAttribute("assurestatue", AssureStatus.values());
		return "/management/case/caseEdit";
	}
	
	@Log(message="{0} {1} 案件 {2}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(HttpServletRequest request,CaseInfoImpl caseInfoImpl,Model model,BaseConditionVO vo){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Org org = (Org)request.getSession().getAttribute(Constants.ORGCODE_KEY);

		if(org.getOrgType().equals("C")){
			return ajaxDoneError("总公司不能添加案件!");
		}
		
		caseInfoImpl = caseServiceMgr.updCase(caseInfoImpl);
		
		if("".equals(request.getParameter("caseId")) || null == request.getParameter("caseId")){
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",caseInfoImpl.getCasenumber()}));
		}else{
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改",caseInfoImpl.getCasenumber()}));
		}
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{caseId}", String.valueOf(caseInfoImpl.getCaseId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
		
	}
	
	@Log(message="{0}删除案件。")
	@RequestMapping("/delete/{caseId}")
	public ModelAndView delete(@PathVariable("caseId") String caseId,HttpServletRequest request) {
		caseServiceMgr.delCaseInfo(caseId);
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName()}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/check")
	public ModelAndView checkCaseNumber(HttpServletRequest request){
		String message = caseServiceMgr.getCaseInfoByCaseNumber(request.getParameter("casenumber"));
		if("300".equals(message)){
			return ajaxDoneError("您输入的案件号不存在!");
		}
		return ajaxDoneSuccess(message);
	}
	
	/**
	 * 查询导出案件列表
	 * */
	@RequestMapping("/dwzExport")
	public String dwzExport(HttpServletRequest request,HttpServletResponse response,BaseConditionVO vo){
		response.setContentType("Application/excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=caseList.xls");
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("shipname", request.getParameter("shipname"));
		criterias.put("excasenumber", request.getParameter("excasenumber"));
		criterias.put("billstatus", request.getParameter("billstatus"));
		criterias.put("consignorsn", request.getParameter("consignorsn"));
		//if(null != request.getParameter("casestatus")){
		criterias.put("casestatus", "0");
		//}
		Map<Object, Object> caseInfoMap = caseServiceMgr.searchCase(criterias, vo);
		List caseList = (List)caseInfoMap.get("caseList");
		
		XlsExport e = new XlsExport();
		int rowIndex = 0;
		e.createRow(rowIndex++);
		for (ExportFiled filed : ExportFiled.values()) {
			e.setCell(filed.ordinal(), filed.toString());
		}
		/*for (int i = 0; i < caseList.size(); i++) {
			Map map = (Map)caseList.get(i);
			CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(map.get("case_id").toString());
			
		}*/
		for (int i = 0; i < caseList.size(); i++) {
			Map map = (Map)caseList.get(i);
			CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(map.get("Case_Id").toString());
			
			e.createRow(rowIndex++);

			for (ExportFiled filed : ExportFiled.values()) {
				switch (filed) {
				case 案号:
					e.setCell(filed.ordinal(), caseInfoImpl.getCasenumber());
					break;
				case 船名:
					e.setCell(filed.ordinal(), caseInfoImpl.getShipname());
					break;
				case 事发口岸:
					e.setCell(filed.ordinal(), caseInfoImpl.getAccidentport());
					break;
				case 委托人:
					e.setCell(filed.ordinal(), caseInfoImpl.getConsignorsn());
					break;
				default:
					break;
				}

			}
		}

		e.exportXls(response);
		return null;
		//return "/management/case/dwz-team.xls";
	}
	
	private static enum ExportFiled {
		案号,船名,事发口岸,委托人;
	}
	
}
