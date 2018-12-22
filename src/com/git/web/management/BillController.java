package com.git.web.management;

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

import com.git.business.billService.BillServiceMgr;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.DocInfos;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.BillIncomeImpl;
import com.git.enums.DocInfoType;
import com.git.enums.InComeType;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/management/inCome")
public class BillController extends BaseController{

	@Autowired
	private BillServiceMgr billServiceMgr;
	
	@Autowired
	private ApplyInfoServiceMgr applyInfoServiceMgr;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		
		criterias.put("statementnumber", request.getParameter("statementnumber"));
		criterias.put("payername", request.getParameter("payername"));
		criterias.put("feenumber", request.getParameter("feenumber"));
		criterias.put("tradedate", request.getParameter("tradedate"));
		criterias.put("userId", user.getId());
		criterias.put("bill", request.getParameter("bill"));
		Map search = billServiceMgr.searchBillInCome(criterias, vo);
		List<BillIncomeImpl> billIncomeList = (List<BillIncomeImpl>)search.get("billInComeList");
		int totalCount = (Integer)search.get("count");
		vo.setTotalCount(totalCount);
		model.addAttribute("vo",vo);
		model.addAttribute("bill",request.getParameter("bill"));
		model.addAttribute("billIncomeList",billIncomeList);
		return  "/management/inCome/inComeList";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		model.addAttribute("banktype",Jutil.getDictEntry("banktype"));
		model.addAttribute("yesno",Jutil.getDictEntry("yesno"));
		model.addAttribute("inComeType",InComeType.values());
		model.addAttribute("billIncomeImpl",new BillIncomeImpl());
		return "/management/inCome/inComeInfo";
	}
	
	@RequestMapping("/edit/{inComeId}")
	public String edit(@PathVariable("inComeId") String inComeId, Model model,BaseConditionVO vo) {
		BillIncomeImpl billIncomeImpl = billServiceMgr.getBillIncome(inComeId);
		model.addAttribute("billIncomeImpl", billIncomeImpl);
		
		List<DocInfos> docList=applyInfoServiceMgr.selectByApplyId(Long.valueOf(billIncomeImpl.getIncomeId()),DocInfoType.inComedoc.getCode());
		model.addAttribute("docList", docList);
		
		model.addAttribute("vo", vo);
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("casetype",Jutil.getDictEntry("casetype"));
		model.addAttribute("banktype",Jutil.getDictEntry("banktype"));
		model.addAttribute("yesno",Jutil.getDictEntry("yesno"));
		model.addAttribute("inComeType",InComeType.values());
		return "/management/inCome/inComeInfo";
	}
	
	@Log(message="用户 {0} {1}对账单  {2}。")
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insertAndUpdate(BillIncomeImpl billIncomeImpl,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		try {
			billServiceMgr.updBillInCome(billIncomeImpl,request);
		} catch (Exception e) {
			return ajaxDoneError(e.getMessage());
		}
		
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",billIncomeImpl.getStatementnumber()}));
		}else{
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改",billIncomeImpl.getStatementnumber()}));

		}
		
		
		String forwardUrl = request.getParameter("forwardUrl");
		
		if (forwardUrl != null) {
			forwardUrl = forwardUrl.replace("{inComeId}", String.valueOf(billIncomeImpl.getIncomeId()));
			String message = getMessage("msg.operation.success");
			return ajaxDone(200, message,"","", forwardUrl);
		}
		
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	@RequestMapping("/delete/{inComeId}")
	public ModelAndView delete(@PathVariable("inComeId") String inComeId) {
		billServiceMgr.delBillIncome(inComeId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
}
