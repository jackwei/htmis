package com.git.web.management;

import java.net.URLEncoder;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.git.business.billService.BillCheckServiceMgr;
import com.git.business.caseService.CaseBillDetailServiceMgr;
import com.git.business.caseService.CaseBillServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.claimRate.ClaimRateServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimRateSubImpl;
import com.git.db.beans.TblPassureInfos;
import com.git.enums.AccFlagStatus;
import com.git.enums.AccStatus;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.util.CommonUtil;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.util.NumberToEnglish;
import com.git.web.BaseController;

import dwz.common.util.HtmlOperator;
import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value = "/management/caseBill")
public class CaseBillController extends BaseController {

	@Autowired
	private CaseBillServiceMgr caseBillServiceMgr;

	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;

	@Autowired
	private CaseServiceMgr caseServiceMgr;

	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;

	//@Autowired
	//private ClaimRateServiceMgr claimRateServiceMgr;

	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;

	@Autowired
	private BillCheckServiceMgr billCheckServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	/**
	 * 添加我的账单
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping("/add/{caseId}")
	public String add(@PathVariable("caseId") String caseId,
			HttpServletRequest request, Model model) {

		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		model.addAttribute(caseInfoImpl);
		
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		
		//查询垫付费用
		criterias.put("casenumber", caseInfoImpl.getCasenumber());
		criterias.put("recordtype", "B");
		criterias.put("billId", 0);
		Map search = caseClaimServiceMgr.searchCaseClaimByStatus(criterias, null);
		List<CaseClaimImpl> caseClaimList = (List<CaseClaimImpl>) search.get("caseClaimList");
		model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
		model.addAttribute("caseClaimList", caseClaimList);

		//查询赔款汇差
		/*criterias.clear();
		criterias.put("casenumber", caseInfoImpl.getCasenumber());
		criterias.put("billId", 0);
		List<ClaimRateSubImpl> claimRateSubList = claimRateServiceMgr.searchClaimRate(criterias, null);
		model.addAttribute("claimRateSubList", claimRateSubList);*/
		
		// 查询汇款余额
		criterias.clear();
		criterias.put("billId", 0);
		criterias.put("status", InComeStatus.ClaimFee4.getCode());
		criterias.put("differamount", 0);
		
		List<ClaimIncomeImpl> balanceBillList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, caseInfoImpl.getCasenumber());
		model.addAttribute("balanceBillList", balanceBillList);
		
		model.addAttribute("caseBillImpl", new CaseBillImpl());
		model.addAttribute("caseBillDetailImpl", new CaseBillDetailImpl());
		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		return "/management/caseBill/caseBillInfo";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("/edit/{billId}")
	public String edit(@PathVariable("billId") String billId, Model model,
			HttpServletRequest request) {

		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageSize(1);
		vo.setPageNum(20);

		String caseId = request.getSession().getAttribute("caseId").toString();
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		model.addAttribute(caseInfoImpl);
		model.addAttribute("casestatus", caseInfoImpl.getCasestatus());
		
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId);
		
		model.addAttribute("caseBillImpl", caseBillImpl);

		Map<Object, Object> criterias = new HashMap<Object, Object>();

		try {
			if (null != caseBillImpl.getFeetype() && caseBillImpl.getFeetype().equals("assure")) {
				// 获取该案件下已生成账单的中再担保
				String flag = request.getParameter("flag");
				BaseConditionVO vo1 = new BaseConditionVO();
				criterias.put("caseId", caseInfoImpl.getCaseId());
				criterias.put("aflag", "1");
				criterias.put("feeid", billId);
				List<PassureInfos> passurelist = passureInfosServiceMgr
						.searchAllPassureInfos(vo, criterias);
				vo1.setTotalCount(passurelist.size());
				model.addAttribute("passurelist", passurelist);
				model.addAttribute("vo1", vo1);

				// 获取该案件下未生成账单的中再担保
				BaseConditionVO vo2 = new BaseConditionVO();
				criterias.clear();
				criterias.put("caseId", caseInfoImpl.getCaseId());
				criterias.put("bflag", "1");
				List<PassureInfos> unpassurelist = passureInfosServiceMgr
						.searchAllPassureInfos(vo, criterias);
				vo2.setTotalCount(unpassurelist.size());
				model.addAttribute("unpassurelist", unpassurelist);
				model.addAttribute("vo2", vo2);

				request.getSession().setAttribute("billId", billId);
				request.getSession().setAttribute("feenumber",
						caseBillImpl.getFeenumber());
				model.addAttribute("currency", Jutil.getDictEntry("currency"));
				model.addAttribute("flag",flag);

				return "/passure/assurebillinfo";
			} else {
				// 查询第三方费用
				criterias.put("billId", billId);
				criterias.put("feeType", "thirdPart");
				List<CaseBillDetailImpl> consignorBillList = caseBillDetailServiceMgr
						.searchCaseBillDetail(criterias, vo);
				vo.setTotalCount(consignorBillList.size());
				model.addAttribute("consignorBillList", consignorBillList);

				// 查询其他费用
				criterias.clear();
				criterias.put("billId", billId);
				criterias.put("feeType", "other");
				List<CaseBillDetailImpl> otherBillList = caseBillDetailServiceMgr
						.searchCaseBillDetail(criterias, vo);
				vo.setTotalCount(otherBillList.size());
				model.addAttribute("otherBillList", otherBillList);
				model.addAttribute("vo", vo);

				// 查询垫付费用
				criterias.clear();
				criterias.put("casenumber", caseInfoImpl.getCasenumber());
				criterias.put("recordtype", "B");
				criterias.put("billId", billId);
				Map search = caseClaimServiceMgr.searchCaseClaimByStatus(criterias, vo);
				List<CaseClaimImpl> caseClaimList = (List<CaseClaimImpl>) search.get("caseClaimList");
				int count = (Integer) search.get("count");
				vo.setTotalCount(count);
				model.addAttribute("vo", vo);
				model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
				model.addAttribute("caseClaimList", caseClaimList);

				// 查询赔款汇差
				/*criterias.clear();
				criterias.put("casenumber", caseInfoImpl.getCasenumber());
				criterias.put("billId", billId);
				List<ClaimRateSubImpl> claimRateSubList = claimRateServiceMgr
						.searchClaimRate(criterias, vo);
				vo.setTotalCount(claimRateSubList.size());
				model.addAttribute("vo", vo);
				model.addAttribute("claimRateSubList", claimRateSubList);*/

				// 查询汇款余额
				criterias.clear();
				criterias.put("billId", billId);
				criterias.put("status", InComeStatus.ClaimFee4.getCode());
				criterias.put("Islocked", "yes");
				criterias.put("differamount", 0);
				
				List<ClaimIncomeImpl> balanceBillList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, caseInfoImpl.getCasenumber());
				model.addAttribute("balanceBillList", balanceBillList);
				
				request.getSession().setAttribute("caseClaimList", caseClaimList);
				request.getSession().setAttribute("billId", billId);
				request.getSession().setAttribute("feenumber",
						caseBillImpl.getFeenumber());
				model.addAttribute("currency", Jutil.getDictEntry("currency"));
				return "/management/caseBill/caseBillInfo";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";

	}
	
	/**
	 * 提交财务时检查是否有汇差及垫付费用
	 * */
	@SuppressWarnings("rawtypes")
	@RequestMapping("/checkSendBill")
	@ResponseBody
	public Map<String,String> checkSendBill(HttpServletRequest request){
		Map<String,String> map = new HashMap<String,String>();
		Map<Object, Object> criterias = new HashMap<Object, Object>();

		String billId = request.getParameter("billId");
		
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("recordtype", "B");
		criterias.put("billId", "0");
		Map search = caseClaimServiceMgr.searchCaseClaimByStatus(criterias, null);
		int count = (Integer) search.get("count");
		
		if(count >0){
			map.put("status", "1");
			map.put("message", "该案件下有垫付费用，是否需要处理！");
			return map;
		}
		
		criterias.clear();
		criterias.put("billId", "0");
		criterias.put("status", InComeStatus.ClaimFee4.getCode());
		criterias.put("differamount", 0);
		
		List<ClaimIncomeImpl> balanceBillList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, request.getParameter("casenumber"));
		
		if(balanceBillList.size() > 0){
			map.put("status", "2");
			map.put("message", "该案件下有汇款余额，请处理！");
			return map;
		}
		
		criterias.clear();
		criterias.put("billId",billId);
		criterias.put("status", InComeStatus.ClaimFee4.getCode());
		criterias.put("differamount", 0);
		criterias.put("flag", "1");
		List<ClaimIncomeImpl> balanceBillList1 = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, request.getParameter("casenumber"));
		if(balanceBillList1.size() > 0){
			map.put("status", "4");
			map.put("message", "该账单下有汇款余额，提交财务后不允许撤销处理！");
			return map;
		}
		
		map.put("status", "3");
		map.put("message", "成功");
		
		return map;
	}

	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(HttpServletRequest request,
			CaseBillImpl caseBillImpl) throws ServiceException {
		try {
			caseBillServiceMgr.updCaseBill(caseBillImpl);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		String forwardUrl = request.getParameter("forwardUrl");

		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}",
					String.valueOf(caseBillImpl.getBillId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message, "", "", forwardUrl);
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	/**
	 * 提交账单
	 * */
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ModelAndView sendBill(CaseBillImpl caseBillImpl,HttpServletRequest request,Model model) {

		//CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getParameter("billId"));

		try {
			caseBillServiceMgr.processSendBill(caseBillImpl);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		
		//String forwardUrl = request.getContextPath()+"/management/caseBill/edit/{billId}";
		String forwardUrl = request.getParameter("forwardUrl");
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}",	caseBillImpl.getBillId().toString());
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message, "", "", forwardUrl);
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	/**
	 * 撤回账单
	 * */
	@RequestMapping(value = "/revoke", method = RequestMethod.POST)
	public ModelAndView revokeBill(HttpServletRequest request) {
		
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getParameter("billId"));
		caseBillImpl.setFeestatuse(AccStatus.AccNew.getCode());
//		caseBillImpl.setAccdate(new Date());
		caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		BillCheckImpl billCheckImpl =billCheckServiceMgr.getBillCheckByBillId(caseBillImpl.getBillId().toString());
		billCheckImpl.setFlag("0"); //0 失效,1 有效
		billCheckServiceMgr.updBillCheck(billCheckImpl);
		
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseBillImpl.getCaseId().toString());
		caseInfoImpl.setAccflag(AccFlagStatus.AccFlag0.getCode());
		caseServiceMgr.updateCase(caseInfoImpl);
		
		//查询账单下的垫付费用
		List<CaseClaimImpl> caseClaimList = caseClaimServiceMgr.searchCaseClaimByBillId(caseBillImpl.getBillId().toString(), null);
		
		for (CaseClaimImpl caseClaimImpl : caseClaimList) {
			caseClaimImpl.setStatus(ClaimStatus.ClaimFee3.getCode());
			caseClaimServiceMgr.updateCaseClaim(caseClaimImpl);
		}
		
		if(!"HTPI1300".equals(caseBillImpl.getCasenumber().substring(0, 8))){
			/*添加财务凭证 start */
			MMap mmap = new MMap();
			mmap.put("bill_id", caseBillImpl.getBillId());
			calFinItemServiceMgr.dealFinItem("101", mmap,-1);
			
			if(!caseInfoImpl.getOrgcode().equals("859")){
				calFinItemServiceMgr.dealFinItem("101001", mmap,-1);
			}
			/*end*/
		}
		
		
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}",	caseBillImpl.getBillId().toString());
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message, "", "", forwardUrl);
		}

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping(value = "/delete/{billId}", method = RequestMethod.POST)
	public ModelAndView delete(@PathVariable("billId") String billId,
			HttpServletRequest request, Model model) {
		caseBillServiceMgr.delete(billId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@RequestMapping("/searchBill")
	public String searchBill(HttpServletRequest request, Model model,
			BaseConditionVO vo) {
		List<CaseBillImpl> caseBillList = caseBillServiceMgr
				.searchCaseBillByCaseId(request.getSession()
						.getAttribute("caseId").toString());
		model.addAttribute("caseBillList", caseBillList);
		vo.setTotalCount(caseBillList.size());
		model.addAttribute("vo", vo);
		return "/management/caseBill/myBillList";
	}
	
	@RequestMapping("/searchBillInfo")
	public String searchBillInfo(HttpServletRequest request, Model model,
			BaseConditionVO vo) {
		String caseId = request.getSession().getAttribute("caseId").toString();
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseId);
		model.addAttribute(caseInfoImpl);
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		model.addAttribute(caseBillImpl);
		model.addAttribute("caseBillImpl", caseBillImpl);
		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		return "/management/caseBill/myBillInfo";
	}

	@RequestMapping("/createFeeNote")
	public ModelAndView createFeenoteDoc(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageSize(1);
		vo.setPageNum(20);
		String billId = request.getParameter("billId");
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId);
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(caseBillImpl.getCaseId().toString());
		HtmlOperator ho = new HtmlOperator();

		List<Object[]> list = null;
		if (caseBillImpl  != null ) {

			/*obs = list.get(0);
			to = (TblPcaseinfos) obs[0];
			tol = (TblPfeelist) obs[1];
			currency = tol.getCurrency();*/
			ho.loadTemplate("template/DebitNote_" + caseBillImpl.getCurrency() + ".doc", request);
			ho.setVar("FEENUMBER", caseBillImpl.getFeenumber());
			ho.setVar("CASENUMBER", caseBillImpl.getCasenumber() + caseInfoImpl.getExcasenumber());
			ho.setVar("CODES", CommonUtil.jasperEncode(caseBillImpl.getConame()));
			ho.setVar("PAYER", CommonUtil.jasperEncode(caseBillImpl.getPayer()));
			if (CommonUtil.isEmpty(caseBillImpl.getConame())) {
				ho.setVar("CODESFORM", "");
			} else {
				ho.setVar("CODES", CommonUtil.jasperEncode(caseBillImpl.getConame()));
			}
			if (CommonUtil.isEmpty(caseBillImpl.getAddress())) {
				ho.setVar("ADDRESSFORM", "");
			} else {
				ho.setVar("ADDRESS", CommonUtil.jasperEncode(caseBillImpl.getAddress()));
			}

			ho.setVar("YOURNUMBER", caseInfoImpl.getAcademynum());
			ho.setVar("CREATEDATE",CommonUtil.formatDate(new Date(), "yyyy-MM-dd"));
			ho.setVar("SHIPNAME", CommonUtil.jasperEncode(caseInfoImpl.getShipname()));
			ho.setVar("FEEDES", CommonUtil.jasperEncode(caseInfoImpl.getCasedes()));

			Map<Object, Object> criterias = new HashMap<Object, Object>();
			criterias.put("billId", billId);
			criterias.put("feeType", "thirdPart");
			List<CaseBillDetailImpl> consignorBillList = caseBillDetailServiceMgr.searchCaseBillDetail(criterias, vo);
			vo.setTotalCount(consignorBillList.size());
			
		/*	
			sql = "from TblPconsignor tp where tp.feeid = '" + tol.getOid()+ "'";
			List<TblPconsignor> tpList = ht.find(sql);
			boolean flag = false;
			TblPconsignor tp = null;*/
			boolean flag = false;
			CaseBillDetailImpl caseBillDetailImpl = null;
			for (int i = 0; i < consignorBillList.size(); i++) {
				caseBillDetailImpl = consignorBillList.get(i);
				ho.setVar("INSPECTIONNAME",CommonUtil.jasperEncode(caseBillDetailImpl.getConsignorname()));
				ho.setVar("THIRDPART",caseBillImpl.getCurrency() + " " + CommonUtil.FormatDoubleDoc(caseBillDetailImpl.getAccamount()));
				ho.parse("THIRDPARTFORM", true);
				flag = true;
			}
			if (!flag) {
				ho.setVar("THIRDPARTFORM", "");
			}
			flag = false;
			
			//担保费用
            PassureInfos passure = null;
			List pif = passureInfosServiceMgr.searchpassurebybillid(Long.valueOf(billId));

			for(int i=0;i<pif.size();i++){
				Map a = (Map) pif.get(i);
				Long pid = (Long) a.get("passureid");			
				passure = passureInfosServiceMgr.getPassureInfos(pid);
				 ho.setVar("ASSURENUM", passure.getAssurenum());
			     ho.setVar("ASSUREFEE", caseBillImpl.getCurrency() + " " + CommonUtil.FormatDoubleDoc(passure.getAccamount()));
			     ho.parse("ASSUREFEEFORM", true);
			     flag = true;
			}
			
			 if (!flag) {
			        ho.setVar("ASSUREFEEFORM", "");
			      }			 
			 flag = false;
			 
			/*flag = false;

			sql = "from TblPassureinfos tpa where tpa.feeid = '" + tol.getOid()+ "'";
			List<TblPassureinfos> tpaList = ht.find(sql);
			TblPassureinfos tpa = null;
			for (int i = 0; i < tpaList.size(); i++) {
				tpa = tpaList.get(i);
				ho.setVar("ASSURENUM", tpa.getAssurenum());
				ho.setVar("ASSUREFEE",tol.getCurrency()+ " "+ CommonUtil.FormatDoubleDoc(tpa.getAccamount()));
				ho.parse("ASSUREFEEFORM", true);
				flag = true;

			}
			if (!flag) {
				ho.setVar("ASSUREFEEFORM", "");
			}*/
			flag = false;

			if ((Float.valueOf(0).compareTo(caseBillImpl.getServicefee())) == 0) {
				ho.setVar("SERVICEFEEFORM", "");
			} else {
				ho.setVar("SERVICEFEE",caseBillImpl.getCurrency()+ " " + CommonUtil.FormatDoubleDoc(caseBillImpl.getServicefee()));
				ho.setVar("SERVICEDES",CommonUtil.jasperEncode(caseBillImpl.getServicedes()));
			}
			if ((Float.valueOf(0).compareTo(caseBillImpl.getExpendses())) == 0) {
				ho.setVar("EXPENSESFORM", "");
			} else {
				ho.setVar("EXPENSES",caseBillImpl.getCurrency()+ " "+ CommonUtil.FormatDoubleDoc(caseBillImpl.getExpendses()));

			}
			
			if((Float.valueOf(0).compareTo(caseBillImpl.getAdvancefee())) == 0){
				ho.setVar("ADVANCEFEEFORM", "");
			}else{
				ho.setVar("ADVANCEFEE", caseBillImpl.getCurrency()+ " "+ CommonUtil.FormatDoubleDoc(caseBillImpl.getAdvancefee()));
			}
			
			criterias.clear();
			criterias.put("billId", billId);
			criterias.put("feeType", "other");
			List<CaseBillDetailImpl> otherBillList = caseBillDetailServiceMgr.searchCaseBillDetail(criterias, vo);
			/*sql = "from TblPotherfee tpo where tpo.feeid = '" + tol.getOid()
					+ "'";
			List<TblPotherfee> tpoList = ht.find(sql);
			TblPotherfee tpo = null;*/
			
			for (int i = 0; i < otherBillList.size(); i++) {
				caseBillDetailImpl = otherBillList.get(i);
				ho.setVar("OTHERDES", CommonUtil.jasperEncode(caseBillDetailImpl.getRemark()));
				ho.setVar("OTHERFEE",caseBillImpl.getCurrency()+ " "+ CommonUtil.FormatDoubleDoc(caseBillDetailImpl.getAccamount()));
				ho.parse("OTHERFEEFORM", true);
				flag = true;

			}
			if (!flag) {
				ho.setVar("OTHERFEEFORM", "");
			}
			/*flag = false;

			sql = "from TblPcopensation tpc where tpc.feeid = '" + tol.getOid()+ "'";
			List<TblPcopensation> tpcList = ht.find(sql);
			TblPcopensation tpc = null;
			for (int i = 0; i < tpcList.size(); i++) {
				tpc = tpcList.get(i);
				ho.setVar("COPENSATIONSUB", tol.getCurrency() + " "+ CommonUtil.FormatDoubleDoc(tpc.getAccamount()));
				ho.parse("COPENSATIONSUBFORM", true);
				flag = true;

			}
			if (!flag) {
				ho.setVar("COPENSATIONSUBFORM", "");
			}*/
			flag = false;
			ho.setVar("FEEAMOUNT",caseBillImpl.getCurrency() + " "+ CommonUtil.FormatDoubleDoc(caseBillImpl.getFeeamount()));
			//转换为大写字母
			ho.setVar("FEEAMOUNTEN",NumberToEnglish.n2e(caseBillImpl.getFeeamount().toString()));

			ho.parse("main", false);

			response.setCharacterEncoding("utf-8");
		    response.setContentType("application/msword; charset=UTF-8");

		    String filename = "DebitNote";
		    filename = URLEncoder.encode(filename, "UTF-8");
		    response.setHeader("Content-disposition", "attachment; filename=" + filename);
		    response.getWriter().write(ho.printVar("main"));
		    return null;
		      
			/*response.setCharacterEncoding("utf-8");
			response.setContentType("application/msword; charset=UTF-8");

			String filename = "DebitNote";
			filename = URLEncoder.encode(filename, "UTF-8");
			
			response.setCharacterEncoding("utf-8");
			response.setHeader("Pragma", "No-Cache");
			response.setHeader("Cache-Control", "No-Cache");
			response.setDateHeader("Expires", 0);
			response.getWriter().write(ho.printVar("main"));
			return null;*/

		} 
		return null;
	}

}
