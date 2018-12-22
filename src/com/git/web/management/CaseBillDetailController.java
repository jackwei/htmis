package com.git.web.management;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.caseService.CaseBillDetailServiceMgr;
import com.git.business.caseService.CaseBillServiceMgr;
import com.git.business.caseService.CaseServiceMgr;
import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.claimRate.ClaimRateServiceMgr;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimRateSubImpl;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value="/management/caseBillDetail")
public class CaseBillDetailController extends BaseController{
	
	@Autowired
	private CaseBillServiceMgr caseBillServiceMgr;
	
	@Autowired
	private CaseBillDetailServiceMgr caseBillDetailServiceMgr;
	
	@Autowired
	private CaseServiceMgr caseServiceMgr;
	
	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private ClaimRateServiceMgr claimRateServiceMgr;
	
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;
	
	@RequestMapping("/consignorList")
	public String consignorList(Model model,BaseConditionVO vo,HttpServletRequest request) {
		
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("billId", request.getSession().getAttribute("billId"));
		criterias.put("feeType", "thirdPart");
		List<CaseBillDetailImpl> consignorBillList = caseBillDetailServiceMgr.searchCaseBillDetail(criterias, vo);
		model.addAttribute("consignorBillList",consignorBillList);

		return "/management/caseBillDetail/consignorBillList";
	}
	
	/**
	 * 查询案件第三方信息
	 * @param request
	 * @param model
	 * @param vo
	 * @return
	 */
	@RequestMapping("/searchCaseBillDetail")
	public String searchHandle(HttpServletRequest request,Model model,BaseConditionVO vo){
		List<String> caseConsignorList=caseBillDetailServiceMgr.getCaseBillDetail(request.getSession().getAttribute("caseId").toString(), "thirdPart", vo);
		vo.setTotalCount(caseBillDetailServiceMgr.getCaseBillDetailCount(request.getSession().getAttribute("caseId").toString(), "thirdPart"));
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(request.getSession().getAttribute("caseId").toString());
        model.addAttribute("caseInfoImpl", caseInfoImpl);
		model.addAttribute("vo", vo);
		
		model.addAttribute("caseConsignorList", caseConsignorList);
		return "/management/caseBill/caseConsignor";
	}
	
	
	/**
	 * 查询第三方费用
	 * 
	 * */
	@RequestMapping("/searchthirdfee")
	public String searchthirdfee(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("billId", request.getSession().getAttribute("billId"));
		criterias.put("feeType", "thirdPart");
		List<CaseBillDetailImpl> consignorBillList = caseBillDetailServiceMgr
				.searchCaseBillDetail(criterias, vo);
		vo.setTotalCount(consignorBillList.size());
		
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		model.addAttribute("caseBillImpl", caseBillImpl);
		
		model.addAttribute("consignorBillList", consignorBillList);
		return "/management/caseBillDetail/consignorBillList";
	}
	
	/**
	 * 查询其他费用
	 * 
	 * */
	@RequestMapping("/searchOther")
	public String searchOther(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.clear();
		criterias.put("billId", request.getSession().getAttribute("billId"));
		criterias.put("feeType", "other");
		List<CaseBillDetailImpl> otherBillList = caseBillDetailServiceMgr
				.searchCaseBillDetail(criterias, vo);
		vo.setTotalCount(otherBillList.size());
		model.addAttribute("otherBillList", otherBillList);
		model.addAttribute("vo", vo);
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		model.addAttribute("caseBillImpl", caseBillImpl);

		return "/management/caseBillDetail/otherBillList";
	}
	
	/**
	 * 查询赔款汇差
	 * 
	 * */
	@RequestMapping("/searchCaseRateSub")
	public String searchCaseRateSub(HttpServletRequest request,Model model,BaseConditionVO vo){
		/*List<String> caseConsignorList=caseBillDetailServiceMgr.getCaseBillDetail(request.getSession().getAttribute("caseId").toString(), "thirdPart", vo);
		vo.setTotalCount(caseBillDetailServiceMgr.getCaseBillDetailCount(request.getSession().getAttribute("caseId").toString(), "thirdPart"));
		CaseInfoImpl caseInfoImpl = caseServiceMgr.getCaseInfo(request.getSession().getAttribute("caseId").toString());
        model.addAttribute("caseInfoImpl", caseInfoImpl);
		model.addAttribute("vo", vo);
		model.addAttribute("caseConsignorList", caseConsignorList);*/
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("casenumber",request.getSession().getAttribute("casenumber"));
		criterias.put("billId", request.getSession().getAttribute("billId"));
		List<ClaimRateSubImpl> claimRateSubList = claimRateServiceMgr
				.searchClaimRate(criterias, vo);
		vo.setTotalCount(claimRateSubList.size());
		model.addAttribute("vo", vo);
		model.addAttribute("claimRateSubList", claimRateSubList);
		
		return "/management/caseBillDetail/caseRateSubList";
	}
	
	/**
	 *  查询汇款余额
	 * 
	 * */
	@RequestMapping("/searchBalance")
	public String searchBalance(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.clear();
		criterias.put("billId", request.getSession().getAttribute("billId"));
		criterias.put("status", InComeStatus.ClaimFee4.getCode());
		criterias.put("differamount", 0);
		String casenumber = request.getSession().getAttribute("casenumber").toString();
		List<ClaimIncomeImpl> balanceBillList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias, casenumber);
		model.addAttribute("balanceBillList", balanceBillList);
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		model.addAttribute("caseBillImpl", caseBillImpl);
		
		return "/management/caseBillDetail/balanceBillList";
	}
	
	/**
	 * 查询垫付费用
	 * 
	 * */
	@RequestMapping("/searchCaseAdvance")
	public String searchCaseAdvance(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("casenumber",request.getSession().getAttribute("casenumber"));
		criterias.put("billId", request.getSession().getAttribute("billId"));
		Map search = caseClaimServiceMgr.searchCaseClaimByStatus(criterias, vo);
		List<CaseClaimImpl> caseClaimList = (List<CaseClaimImpl>) search.get("caseClaimList");
		int count = (Integer) search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
	
		model.addAttribute("caseBillImpl", caseBillImpl);
		model.addAttribute("caseClaimList", caseClaimList);
		model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
		return "/management/caseBillDetail/caseAdvanceList";
	}
	
	
	@RequestMapping("/otherList")
	public String otherList(Model model,BaseConditionVO vo,HttpServletRequest request) {
		
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("billId", request.getSession().getAttribute("billId"));
		criterias.put("feeType", "other");
		List<CaseBillDetailImpl> otherBillList = caseBillDetailServiceMgr.searchCaseBillDetail(criterias, vo);
		model.addAttribute("otherBillList",otherBillList);

		return "/management/caseBillDetail/otherBillList";
	}
	
	@RequestMapping("/addConsignor/{billId}")
	public String addConsignor(@PathVariable("billId") String billId, HttpServletRequest request, Model model) {
		model.addAttribute("caseBillDetailImpl", new CaseBillDetailImpl());
		model.addAttribute("billId", billId);
		model.addAttribute("feenumber", request.getSession().getAttribute("feenumber"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		return "/management/caseBillDetail/consignorBillInfo";
	}
	
	@RequestMapping("/editConsignor/{detailId}")
	public String editConsignor(@PathVariable("detailId") String detailId, HttpServletRequest request, Model model) {
		CaseBillDetailImpl caseBillDetailImpl = caseBillDetailServiceMgr.searchCaseBillDetail(detailId);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute(caseBillDetailImpl);
		model.addAttribute("caseBillDetailImpl",caseBillDetailImpl);
		if(request.getParameter("flag") != null){
			model.addAttribute("flag", "view");
		}
		return "/management/caseBillDetail/consignorBillInfo";
	}
	
	@RequestMapping("/addOther/{billId}")
	public String addOther(@PathVariable("billId") String billId,Model model, HttpServletRequest request) {
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("billId", billId);
		model.addAttribute("feenumber", request.getSession().getAttribute("feenumber"));
		model.addAttribute("caseBillDetailImpl", new CaseBillDetailImpl());
		return "/management/caseBillDetail/otherBillInfo";
	}
	
	@RequestMapping("/editOther/{detailId}")
	public String editOther(@PathVariable("detailId") String detailId, HttpServletRequest request, Model model) {
		CaseBillDetailImpl caseBillDetailImpl = caseBillDetailServiceMgr.searchCaseBillDetail(detailId);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute(caseBillDetailImpl);
		if(request.getParameter("flag") != null){
			model.addAttribute("flag", "view");
		}
		return "/management/caseBillDetail/otherBillInfo";
	}
	
	/**
	 * 添加赔款余额到账单
	 * */
	@RequestMapping(value = "/insertBalance", method = RequestMethod.POST)
	public ModelAndView insertBalance(HttpServletRequest request,Model model){
		//String claimId = request.getParameter("claimId");
		
		String inComeId = request.getParameter("inComeId");
		
		String flag = request.getParameter("flag");
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		
		ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr.getClaimIncome(inComeId);
		//CaseClaimImpl caseClaimImpl = caseClaimServiceMgr.getCaseClaim(claimId);
		float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();

		float fee = caseBillImpl.getFeeamount();
		
		if("add".equals(flag)){
			
			if(claimIncomeImpl.getDifferamount() < 0){
				float balance = caseBillImpl.getCompensationsub()+claimIncomeImpl.getDifferamount()*-1;
				
				caseBillImpl.setCompensationsub(balance);
				caseBillImpl.setFeeamount(fee+balance);
				caseBillImpl.setReplaceamount(fee+balance);
				
			}else if(claimIncomeImpl.getDifferamount() > 0 ){
				
				if(fee == 0 ){
					return ajaxDoneError("当前账单费用已冲抵为0，无需在添加!");
				}
				
				float diff = claimIncomeImpl.getDifferamount()+caseBillImpl.getCompensationsub()*-1;
				
				float balance = claimIncomeImpl.getDifferamount()*-1+caseBillImpl.getCompensationsub();
				
				if(diff < allfee){
					caseBillImpl.setCompensationsub(balance);
					caseBillImpl.setFeeamount(allfee+balance);
					caseBillImpl.setReplaceamount(fee+balance);
					claimIncomeImpl.setRemark1("0");//剩余余额
				}else if(diff >= allfee){
					caseBillImpl.setCompensationsub(allfee*-1);
					caseBillImpl.setFeeamount(Float.valueOf("0"));
					caseBillImpl.setReplaceamount(Float.valueOf("0"));
					Float sy = diff-allfee;
					claimIncomeImpl.setRemark1(sy.toString());//剩余余额
				}
				
			}
			/*else if(claimIncomeImpl.getDifferamount() > caseBillImpl.getFeeamount()){
				float balance = caseBillImpl.getFeeamount()*-1+caseBillImpl.getCompensationsub();
				caseBillImpl.setCompensationsub(balance);
				caseBillImpl.setFeeamount(Float.valueOf("0"));
				caseBillImpl.setReplaceamount(Float.valueOf("0"));
			}*/
			
			claimIncomeImpl.setBillId(caseBillImpl.getBillId());
			claimIncomeImpl.setIslocked("yes");
			claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
			
		}else{
			claimIncomeImpl.setBillId((long)0);
			claimIncomeImpl.setIslocked("no");
			
			List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
			
			Float amount = (float)0.0; //获取当前账单总赔款余额
			Float remark1 = (float)0.0; //获取未使用的赔款余额
			
			for (Map map : claimList) {
				map.get("Income_Id");
				if(map.get("Income_Id").toString().equals(claimIncomeImpl.getIncomeId().toString())){
					continue;
				}
				amount += Float.valueOf(map.get("differamount").toString());
				remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());

			}
			
			Float ch = (float)0;
			
			if(null !=claimIncomeImpl.getRemark1() && Float.valueOf(claimIncomeImpl.getRemark1()) == 0){
				ch = claimIncomeImpl.getDifferamount();
			}else{
				ch = Float.valueOf(null == claimIncomeImpl.getRemark1() ? "0":claimIncomeImpl.getRemark1());
			}
					
			claimIncomeImpl.setRemark1(ch.toString());
			
			if(amount > allfee){
				caseBillImpl.setCompensationsub(allfee*-1);
				caseBillImpl.setFeeamount(Float.valueOf("0"));
				caseBillImpl.setReplaceamount(Float.valueOf("0"));
			}else if(amount < allfee){
				caseBillImpl.setCompensationsub(amount*-1);
				caseBillImpl.setFeeamount(allfee-amount);
				caseBillImpl.setReplaceamount(allfee-amount);
			}
			
			claimInComeServiceMgr.updateClaimIncome(claimIncomeImpl);
			//caseBillImpl.setCompensationsub(caseBillImpl.getCompensationsub()-claimIncomeImpl.getDifferamount()*-1);
		}
		
		int count = caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		//String forwardUrl = request.getParameter("forwardUrl");
		String forwardUrl = request.getContextPath()+"/management/caseBill/edit/{billId}";
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}", request.getSession().getAttribute("billId").toString());
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	/**
	 * 添加账单第三方 
	 **/
	@RequestMapping(value = "/insertConsignor", method = RequestMethod.POST)
	public ModelAndView insertConsignor(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) {
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(caseBillDetailImpl.getBillId().toString());

		if(!caseBillImpl.getCurrency().equals(request.getParameter("currency"))){
			if("1".equals(request.getParameter("changerate"))){
				return ajaxDoneError("币种不同折算汇率不能为1!");
			}
		}
		
		if("0".equals(request.getParameter("feeamount"))){
			return ajaxDoneError("合计金额不能为0!");
		}
		
		try {
			caseBillDetailServiceMgr.updConsignor(caseBillDetailImpl, request);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		
		List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetailByBillId(caseBillDetailImpl.getBillId().toString(), "thirdPart");
		
		BigDecimal amount = new BigDecimal("0.00");
		
		for (CaseBillDetailImpl caseBillDetailImpl2 : caseBillDetailList) {
			amount = amount.add(BigDecimal.valueOf(caseBillDetailImpl2.getAccamount()).setScale(2, BigDecimal.ROUND_HALF_UP));
		}
		
		caseBillImpl.setThirdpart(amount.floatValue());
		
		float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
		
		List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
		
		Float diffamount = (float)0.0; //获取当前账单总赔款余额
		Float remark1 = (float)0.0; //获取未使用的赔款余额
		
		for (Map map : claimList) {
			map.get("Income_Id");
			diffamount += Float.valueOf(map.get("differamount").toString());
			remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());

		}
		
		if(diffamount > allfee){
			caseBillImpl.setCompensationsub(allfee*-1);
			caseBillImpl.setFeeamount(Float.valueOf("0"));
			caseBillImpl.setReplaceamount(Float.valueOf("0"));
		}else if(diffamount < allfee){
			caseBillImpl.setCompensationsub(diffamount*-1);
			caseBillImpl.setFeeamount(allfee-diffamount);
			caseBillImpl.setReplaceamount(allfee-diffamount);
		}
		
		/*feeamount = BigDecimal.valueOf(caseBillImpl.getFeeamount()).add(amount);
		caseBillImpl.setFeeamount(feeamount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());
		caseBillImpl.setReplaceamount(feeamount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());*/
		
		caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}", String.valueOf(caseBillDetailImpl.getBillId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	/**
	 * 添加其他费用
	 * */
	@RequestMapping(value = "/insertOther", method = RequestMethod.POST)
	public ModelAndView insertOther(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) {
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(caseBillDetailImpl.getBillId().toString());

		if(!caseBillImpl.getCurrency().equals(request.getParameter("currency"))){
			if("1".equals(request.getParameter("changerate"))){
				return ajaxDoneError("币种不同折算汇率不能为1!");
			}
		}
		
		if("0".equals(request.getParameter("accamount"))){
			return ajaxDoneError("记账金额不能为0!");
		}
		
		try {
			caseBillDetailServiceMgr.updOther(caseBillDetailImpl, request);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}
		
		List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailServiceMgr.searchCaseBillDetailByBillId(caseBillDetailImpl.getBillId().toString(), "other");
		
		BigDecimal amount = new BigDecimal("0.00");
		
		for (CaseBillDetailImpl caseBillDetailImpl2 : caseBillDetailList) {
			amount = amount.add(BigDecimal.valueOf(caseBillDetailImpl2.getAccamount()).setScale(2,BigDecimal.ROUND_HALF_UP ));
		}
		
		caseBillImpl.setOtherfee(amount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());
		
		float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
		List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
		Float diffamount = (float)0.0; //获取当前账单总赔款余额
		Float remark1 = (float)0.0; //获取未使用的赔款余额
		
		for (Map map : claimList) {
			map.get("Income_Id");
			diffamount += Float.valueOf(map.get("differamount").toString());
			remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());
		}
		
		if(diffamount > allfee){
			caseBillImpl.setCompensationsub(allfee*-1);
			caseBillImpl.setFeeamount(Float.valueOf("0"));
			caseBillImpl.setReplaceamount(Float.valueOf("0"));
		}else if(diffamount < allfee){
			caseBillImpl.setCompensationsub(diffamount*-1);
			caseBillImpl.setFeeamount(allfee-diffamount);
			caseBillImpl.setReplaceamount(allfee-diffamount);
		}
		
		//BigDecimal feeamount = new BigDecimal("0.00");
		
		/*feeamount = BigDecimal.valueOf(caseBillImpl.getFeeamount()).add(amount);
		caseBillImpl.setFeeamount(feeamount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());
		caseBillImpl.setReplaceamount(feeamount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());*/
		
		caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}", String.valueOf(caseBillDetailImpl.getBillId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/editAdvance")
	public String editAdvance(HttpServletRequest request,Model model){
		String claimId = request.getParameter("claimId");
		CaseClaimImpl caseClaimImpl = caseClaimServiceMgr.getCaseClaim(claimId);
		model.addAttribute("caseClaimImpl",caseClaimImpl);
		
		return "/management/caseBillDetail/advanceEdit";
	}
	
	/**
	 * 添加垫付赔款
	 * */
	@RequestMapping(value = "/insertAdvance", method = RequestMethod.POST)
	public ModelAndView insertAdvance(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) {
		String claimId = request.getParameter("claimId");
		String flag = request.getParameter("flag");
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		CaseClaimImpl caseClaimImpl = caseClaimServiceMgr.getCaseClaim(claimId);
		
		if("add".equals(flag)){
			float usdamount = Float.valueOf(request.getParameter("usdamount"));
			caseClaimImpl.setUsdamount(usdamount);
			caseClaimImpl.setUsdrate(new BigDecimal(request.getParameter("usdrate")));
			caseClaimImpl.setBillId(caseBillImpl.getBillId());
			caseClaimImpl.setStatus(ClaimStatus.ClaimFee3.getCode());
			caseClaimServiceMgr.updateCaseClaim(caseClaimImpl);
			caseBillImpl.setAdvancefee(caseBillImpl.getAdvancefee()+usdamount);
		}else{
			caseClaimImpl.setBillId((long)0);
			caseClaimImpl.setStatus(ClaimStatus.ClaimFee3.getCode());
			caseClaimServiceMgr.updateCaseClaim(caseClaimImpl);
			caseBillImpl.setAdvancefee(caseBillImpl.getAdvancefee()-caseClaimImpl.getUsdamount());
		}
		
		
		float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
		List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
		Float diffamount = (float)0.0; //获取当前账单总赔款余额
		Float remark1 = (float)0.0; //获取未使用的赔款余额
		
		for (Map map : claimList) {
			map.get("Income_Id");
			diffamount += Float.valueOf(map.get("differamount").toString());
			remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());

		}
		
		if(diffamount > allfee){
			caseBillImpl.setCompensationsub(allfee*-1);
			caseBillImpl.setFeeamount(Float.valueOf("0"));
			caseBillImpl.setReplaceamount(Float.valueOf("0"));
		}else if(diffamount < allfee){
			caseBillImpl.setCompensationsub(diffamount*-1);
			caseBillImpl.setFeeamount(allfee-diffamount);
			caseBillImpl.setReplaceamount(allfee-diffamount);
		}
		
		int count = caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		//String forwardUrl = request.getParameter("forwardUrl");
		String forwardUrl = request.getContextPath()+"/management/caseBill/edit/{billId}";
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}", request.getSession().getAttribute("billId").toString());
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	/**
	 * 获取赔款汇差添加到账单
	 * */
	@RequestMapping(value = "/insertRateSub", method = RequestMethod.POST)
	public ModelAndView insertRateSub(HttpServletRequest request,Model model,BaseConditionVO vo) {
		String[] checkIds = request.getParameterValues("checkIds");
		String rateId = request.getParameter("rateId");
		String flag = request.getParameter("flag");
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(request.getSession().getAttribute("billId").toString());
		ClaimRateSubImpl claimRateSubImpl = claimRateServiceMgr.getClaimRate(rateId);
		
		if("add".equals(flag)){
			claimRateSubImpl.setBillId(caseBillImpl.getBillId());
			claimRateServiceMgr.updateClaimRateSub(claimRateSubImpl);
			caseBillImpl.setCompensationsub(caseBillImpl.getCompensationsub()+claimRateSubImpl.getCratesub());
		}else{
			claimRateSubImpl.setBillId((long)0);
			claimRateServiceMgr.updateClaimRateSub(claimRateSubImpl);
			caseBillImpl.setCompensationsub(caseBillImpl.getCompensationsub()-claimRateSubImpl.getCratesub());
		}
		
		BigDecimal feeamount = new BigDecimal("0.00");
		BigDecimal otherfee = BigDecimal.valueOf(caseBillImpl.getOtherfee());
		BigDecimal thirdpart = BigDecimal.valueOf(caseBillImpl.getThirdpart());
		BigDecimal advancefee = BigDecimal.valueOf(caseBillImpl.getAdvancefee());
		BigDecimal servicefee = BigDecimal.valueOf(caseBillImpl.getServicefee());
		BigDecimal expendses = BigDecimal.valueOf(caseBillImpl.getExpendses());
		BigDecimal Compensationsub = BigDecimal.valueOf(caseBillImpl.getCompensationsub());
		feeamount = feeamount.add(otherfee).add(thirdpart).add(advancefee).add(servicefee).add(expendses).add(Compensationsub);
		
		caseBillImpl.setFeeamount(feeamount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());
		caseBillImpl.setReplaceamount(feeamount.setScale(2, BigDecimal.ROUND_HALF_UP ).floatValue());
		
		int count = caseBillServiceMgr.updateCaseBill(caseBillImpl);
		
		//String forwardUrl = request.getParameter("forwardUrl");
		String forwardUrl = request.getContextPath()+"/management/caseBill/edit/{billId}";
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{billId}", request.getSession().getAttribute("billId").toString());
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
		//return  ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/thirddelete/{detailId}")
	public ModelAndView thirddelete(@PathVariable("detailId") String detailId,HttpServletRequest request) {
		CaseBillDetailImpl cbd = caseBillDetailServiceMgr.searchCaseBillDetail(detailId);
		Long billId = cbd.getBillId();
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId.toString());
		Float third = caseBillImpl.getThirdpart()-cbd.getAccamount();
		caseBillImpl.setThirdpart(third);

		//Float feecount = caseBillImpl.getFeeamount() - cbd.getAccamount();
		//caseBillImpl.setFeeamount(feecount);
		
		float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
		List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
		Float diffamount = (float)0.0; //获取当前账单总赔款余额
		Float remark1 = (float)0.0; //获取未使用的赔款余额
		
		for (Map map : claimList) {
			map.get("Income_Id");
			diffamount += Float.valueOf(map.get("differamount").toString());
			remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());

		}
		
		if(diffamount > allfee){
			caseBillImpl.setCompensationsub(allfee*-1);
			caseBillImpl.setFeeamount(Float.valueOf("0"));
			caseBillImpl.setReplaceamount(Float.valueOf("0"));
		}else if(diffamount < allfee){
			caseBillImpl.setCompensationsub(diffamount*-1);
			caseBillImpl.setFeeamount(allfee-diffamount);
			caseBillImpl.setReplaceamount(allfee-diffamount);
		}
		
		caseBillDetailServiceMgr.delete(detailId);
		caseBillServiceMgr.updateCaseBill(caseBillImpl);

		return ajaxDoneError(getMessage("msg.operation.success"));
}
	
	@RequestMapping("/otherdelete/{detailId}")
	public ModelAndView otherdelete(@PathVariable("detailId") String detailId,HttpServletRequest request) {
		CaseBillDetailImpl cbd = caseBillDetailServiceMgr.searchCaseBillDetail(detailId);
		Long billId = cbd.getBillId();
		CaseBillImpl caseBillImpl = caseBillServiceMgr.getCaseBill(billId.toString());
		
		Float other =caseBillImpl.getOtherfee() - cbd.getAccamount();
		caseBillImpl.setOtherfee(other);
			
		/*Float feecount = caseBillImpl.getFeeamount() - cbd.getAccamount();
		caseBillImpl.setFeeamount(feecount);*/
		
		float allfee = caseBillImpl.getServicefee()+caseBillImpl.getAdvancefee()+caseBillImpl.getOtherfee()+caseBillImpl.getExpendses()+caseBillImpl.getThirdpart();
		List<Map> claimList = claimInComeServiceMgr.searchClaimIncomeByBillId(caseBillImpl.getBillId().toString());
		Float diffamount = (float)0.0; //获取当前账单总赔款余额
		Float remark1 = (float)0.0; //获取未使用的赔款余额
		
		for (Map map : claimList) {
			map.get("Income_Id");
			diffamount += Float.valueOf(map.get("differamount").toString());
			remark1 +=map.get("remark1") == null ? Float.valueOf("0"): Float.valueOf(map.get("remark1").toString());

		}
		
		if(diffamount > allfee){
			caseBillImpl.setCompensationsub(allfee*-1);
			caseBillImpl.setFeeamount(Float.valueOf("0"));
			caseBillImpl.setReplaceamount(Float.valueOf("0"));
		}else if(diffamount < allfee){
			caseBillImpl.setCompensationsub(diffamount*-1);
			caseBillImpl.setFeeamount(allfee-diffamount);
			caseBillImpl.setReplaceamount(allfee-diffamount);
		}
		caseBillDetailServiceMgr.delete(detailId);
		caseBillServiceMgr.updateCaseBill(caseBillImpl);

		return ajaxDoneError(getMessage("msg.operation.success"));
}
}