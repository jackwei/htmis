package com.git.web.management;

import java.util.ArrayList;
import java.util.HashMap;
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

import com.git.business.claim.CaseClaimServiceMgr;
import com.git.business.claim.ClaimInComeServiceMgr;
import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.process.DocInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.enums.ClaimStatus;
import com.git.enums.DocInfoType;
import com.git.enums.InComeStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value = "/management/compensation")
public class ClaimInComeController extends BaseController {
	@Autowired
	private ClaimInComeServiceMgr claimInComeServiceMgr;

	@Autowired
	private CaseClaimServiceMgr caseClaimServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		criterias.put("payer", request.getParameter("payer"));
		criterias.put("receivedate", request.getParameter("receivedate"));
		criterias.put("userId", user.getId());
		criterias.put("status", InComeStatus.ClaimFee5.getCode());
		Map search = claimInComeServiceMgr.searchClaimIncome(criterias, vo);

		List<ClaimIncomeImpl> claimIncomeList = (List<ClaimIncomeImpl>) search
				.get("claimIncomeList");
		int count = (Integer) search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("flag", request.getParameter("flag"));
		model.addAttribute("vo", vo);
		model.addAttribute("claimIncomeList", claimIncomeList);
		return "/management/compensation/claimInComeList";
	}

	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		model.addAttribute("banktype", Jutil.getDictEntry("banktype"));
		model.addAttribute("claimIncomeImpl", new ClaimIncomeImpl());
		return "/management/compensation/claimInComeInfo";
	}

	@RequestMapping("/edit/{inComeId}")
	public String edit(@PathVariable("inComeId") String inComeId, Model model) {
		ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr
				.getClaimIncome(inComeId);
		model.addAttribute(claimIncomeImpl);
		
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(claimIncomeImpl.getIncomeId()),DocInfoType.claimdoc.getCode());
		model.addAttribute("docList", docList);
		
		model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		model.addAttribute("banktype", Jutil.getDictEntry("banktype"));
		return "/management/compensation/claimInComeInfo";
	}

	/**
	 * 垫付到账核销
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("/process/{inComeId}")
	public String process(@PathVariable("inComeId") String inComeId,
			HttpServletRequest request, Model model, BaseConditionVO vo) {
		ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr
				.getClaimIncome(inComeId);

		model.addAttribute("claimIncomeImpl", claimIncomeImpl);
		model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency", Jutil.getDictEntry("currency"));

		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("casenumber", claimIncomeImpl.getCasenumber());
		// criterias.put("shipname", request.getParameter("shipname"));
		// criterias.put("clientname", request.getParameter("clientname"));
		criterias.put("recordtype", "B");
		criterias.put("flag", "nolock");

		Map search = caseClaimServiceMgr.searchCaseClaimByCondition(criterias,
				vo);
		List<CaseClaimImpl> caseClaimList = (List<CaseClaimImpl>) search
				.get("caseClaimList");
		int count = (Integer) search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		model.addAttribute("caseClaimList", caseClaimList);

		return "/management/compensation/advanceInComeInfo";
	}

	@Log(message = "用户 {0} {1}赔款到账  {2}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(ClaimIncomeImpl claimIncomeImpl,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(
				Constants.AUTHENTICATION_KEY);
		try {
			claimInComeServiceMgr.updClaimIncome(claimIncomeImpl, request);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		if ("".equals(request.getParameter("inComeId"))
				|| null == request.getParameter("inComeId")) {
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(
					new Object[] { user.getName(), "新增",
							claimIncomeImpl.getCasenumber() }));
		} else {
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(
					new Object[] { user.getName(), "修改",
							claimIncomeImpl.getCasenumber() }));
		}
		
		if(!"HTPI1300".equals(claimIncomeImpl.getCasenumber().substring(0, 8))){
			/*添加财务凭证 start */
			MMap mmap = new MMap();
			mmap.put("Income_Id", claimIncomeImpl.getIncomeId());
			calFinItemServiceMgr.dealFinItem("107", mmap,1);
			/*end*/
		}
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{inComeId}", String.valueOf(claimIncomeImpl.getIncomeId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	@Log(message = "用户 {0} 删除 赔款到账  {2}。")
	@RequestMapping("/delete/{inComeId}")
	public ModelAndView delete(@PathVariable("inComeId") String inComeId,
			HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute(
				Constants.AUTHENTICATION_KEY);

		claimInComeServiceMgr.del(inComeId);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(
				new Object[] { user.getName(), inComeId }));

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

	/**
	 * 进入余额退回页面
	 * 
	 * @param inComeId
	 * @param request
	 * @return
	 */
	@RequestMapping("/balanceBack/{inComeId}")
	public String balanceBack(@PathVariable("inComeId") String inComeId,
			HttpServletRequest request,Model model) {
		//ModelAndView model = new ModelAndView();
		ClaimIncomeImpl claimIncomeImpl = claimInComeServiceMgr
				.getClaimIncome(inComeId);
		CaseClaimImpl caseClaimInpl = claimInComeServiceMgr
				.searchcaseClaim(inComeId);
		if (caseClaimInpl == null) {
			caseClaimInpl = new CaseClaimImpl();
		}
		model.addAttribute("caseId", request.getSession().getAttribute("caseId"));
		model.addAttribute("casenumber",
				request.getSession().getAttribute("casenumber"));
		model.addAttribute("shipname",
				request.getSession().getAttribute("shipname"));
		model.addAttribute("currency", Jutil.getDictEntry("currency"));
		model.addAttribute("backNav", "balanceBackNav");
		model.addAttribute("claimIncomeImpl", claimIncomeImpl);
		model.addAttribute("recordtype", Jutil.getDictEntry("recordtype"));
		model.addAttribute("caseClaimInpl", caseClaimInpl);
		model.addAttribute("flag", request.getParameter("flag"));
		//model.setViewName("/management/claim/caseBalanceInfo");
		return "/management/claim/caseBalanceInfo";
	}

	/**
	 * 删除余额退回
	 * 
	 * @param inComeId
	 * @param request
	 * @return
	 */
	@RequestMapping("/del/{inComeId}")
	public ModelAndView deleteBalanceBack(
			@PathVariable("inComeId") String inComeId,
			HttpServletRequest request) {
		CaseClaimImpl caseClaimInpl = claimInComeServiceMgr.searchcaseClaim(inComeId);
		if(null == caseClaimInpl){
			return ajaxDoneError("已删除成功!");
		}
		
		if(!caseClaimInpl.getStatus().equals(ClaimStatus.ClaimFee0.getCode())){
			return ajaxDoneError("已提交审批,不能删除!");
		}
		
		ApplyInfos applyInfo=applyInfoServiceMgr.selectByParentId(caseClaimInpl.getClaimId());
		if(applyInfo.getRemarkc()!=null && !"".equals(applyInfo.getRemarkc())){
			applyInfoServiceMgr.delAllProcess(Long.valueOf(applyInfo.getRemarkc()));
		}
		applyInfoServiceMgr.delApplyInfos(applyInfo.getId());
		ClaimIncomeImpl claimIncome = new ClaimIncomeImpl();
		claimIncome.setStatus("0");
		claimIncome.setIslocked("no");
		claimIncome.setIncomeId(Long.valueOf(inComeId));
		claimInComeServiceMgr.updateClaimIncome(claimIncome);
		caseClaimServiceMgr.delCaseClaimByIncomeId(inComeId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	/**
	 * 查询赔款余额
	 * */
	@RequestMapping("/searchBalance")
	public String searchClaimBalance(HttpServletRequest request, Model model,BaseConditionVO vo){
		
		StringBuffer sql = new StringBuffer(16);
		sql.append(" select c.`casenumber`,c.`realamount`,c.`currency`,c.`usdrate`, c.`clientname`,i.`payer`,i.`totalamount`,i.`differamount`,d.`checkamount`,i.`currency` bizhong,i.`receivedate` from ");
		sql.append(" tbl_case_claim c, tbl_claim_income i, tbl_claim_income_detail d ");
		sql.append(" where c.`Claim_Id` = d.`Claim_Id` and i.`Income_Id` = d.`Income_Id`");
		
		if(null !=request.getParameter("casenumber") && !"".equals(request.getParameter("casenumber"))){
			sql.append(" and c.`casenumber` like '%"+request.getParameter("casenumber")+"%'");
		}
		sql.append(" order by c.`casenumber` desc");
		
		List<ClaimIncomeImpl> claimBalanceList = Jutil.executeSQL(sql.toString(), vo.getStartIndex(), vo.getPageSize());
		vo.setTotalCount(claimBalanceList.size());
		
		String count = Jutil.getOneValue("select count(1) row from  tbl_case_claim c,  tbl_claim_income i,  tbl_claim_income_detail d where c.`Claim_Id` = d.`Claim_Id`   and i.`Income_Id` = d.`Income_Id` ", "row");
		
		vo.setTotalCount(Integer.valueOf(count));
		model.addAttribute("vo", vo);
		model.addAttribute("claimBalanceList", claimBalanceList);
		return "/management/claimRate/claimBalanceList";
	}

	/**
	 * 查询赔款到账信息
	 * @param model
	 * @param request
	 * @return
	 */
	@RequestMapping("/searchClaimInCome")
	public String searchClaimInCome(Model model, HttpServletRequest request) {
		BaseConditionVO vo = new BaseConditionVO();
		vo.setPageNum(1);
		vo.setPageSize(0);
		Map<Object, Object> criterias = new HashMap<Object, Object>();
		criterias.put("differamount", 1);
		criterias.put("Islocked", "no");
		List<ClaimIncomeImpl> claimIncomeList = claimInComeServiceMgr.searchClaimIncomeByBill(criterias,request.getParameter("casenumber"));
		model.addAttribute("vo", vo);
		model.addAttribute("claimIncomeList", claimIncomeList);
		return "/management/claim/caseBalanceList";
	}
}
