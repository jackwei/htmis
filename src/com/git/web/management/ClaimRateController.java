package com.git.web.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.git.business.claimRate.ClaimRateServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimRateSubImpl;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.web.BaseController;

import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

@Controller
@RequestMapping(value="/management/claimRate")
public class ClaimRateController extends BaseController{
	
	@Autowired
	private ClaimRateServiceMgr claimRateServiceMgr;
	
	@Log(message="用户 {0} 计算赔款汇差，案号为  {1}。")
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo, Model model) throws ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		if("".equals(request.getParameter("casenumber")) || null==request.getParameter("casenumber")){
			return  "/management/claimRate/claimRateList";
		}else{
			String casenumber = request.getParameter("casenumber");
			Map<String,String> criterias = new HashMap<String,String>();
			criterias.put("casenumber", casenumber);
			Map<String,List> map = claimRateServiceMgr.processClaimRate(criterias, vo);
			List<ClaimRateSubImpl> claimRateSubImplList = map.get("claimRateSubImplList");
			
			List<CaseClaimImpl> CaseClaimList = claimRateServiceMgr.searchCaseClaim(casenumber, false);
			List<ClaimIncomeImpl> ClaimIncomeList = claimRateServiceMgr.searchClaimInCome(casenumber, false);
			
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),casenumber}));

			model.addAttribute("ClaimIncomeList", ClaimIncomeList);
			model.addAttribute("CaseClaimList", CaseClaimList);
			model.addAttribute("claimRateSubImplList", claimRateSubImplList);
			
			return  "/management/claimRate/claimRateList";
		}
		
	}
	
	@RequestMapping("/search")
	public String searchRateSub(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<String,String> criterias = new HashMap<String,String>();
		criterias.put("casenumber", request.getParameter("casenumber"));
		List<ClaimRateSubImpl> claimRateSubImplList =claimRateServiceMgr.searchClaimRate(criterias,vo);
		model.addAttribute("claimRateSubImplList", claimRateSubImplList);
		
		return "/management/claimRate/claimRateSubList";
	}
	
}
