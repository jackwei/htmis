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
import org.springframework.web.servlet.ModelAndView;

import com.git.business.handle.CaseHandleServiceMgr;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseHandleImpl;
import com.git.util.Jutil;
import com.git.web.BaseController;

@Controller
@RequestMapping(value="/management/handle")
public class CaseHandleController extends BaseController{
	
	@Autowired
	private CaseHandleServiceMgr caseHandleServiceMgr;
	
	@RequestMapping("/add/{caseId}")
	public String add(@PathVariable("caseId") String caseId, Model model) {
		model.addAttribute("caseId",caseId);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		model.addAttribute("caseHandleImpl",new CaseHandleImpl());
		return "/management/handle/caseHandleInfo";
	}
	
	@RequestMapping("/edit/{seqId},{caseId}")
	public String edit(@PathVariable("seqId") String seqId,@PathVariable("caseId") String caseId, Model model) {
		CaseHandleImpl caseHandleImpl = caseHandleServiceMgr.getCaseHandle(seqId);
		model.addAttribute(caseHandleImpl); 
		model.addAttribute("caseHandleImpl", caseHandleImpl);
		model.addAttribute("caseId",caseId);
		model.addAttribute("recordtype",Jutil.getDictEntry("recordtype"));
		model.addAttribute("currency",Jutil.getDictEntry("currency"));
		return "/management/handle/caseHandleInfo";
	}
	
	@RequestMapping("/insert")
	public String insertAndUpdate(Model model,CaseHandleImpl  caseHandleImpl,HttpServletRequest request,BaseConditionVO vo){
		caseHandleServiceMgr.updCaseHandle(caseHandleImpl, request);
		Map<Object,Object> criterias = new HashMap<Object, Object>();
		criterias.put("caseId", request.getParameter("caseId"));
		List<CaseHandleImpl> caseHandleList = caseHandleServiceMgr.searchCaseHandle(criterias, vo);
		model.addAttribute("caseHandleList", caseHandleList);
		vo.setTotalCount(caseHandleList.size());
		model.addAttribute("vo", vo);
		return "/management/handle/caseHandleList";
	}
	
	@RequestMapping("/delete/{seqId}")
	public ModelAndView delete(@PathVariable("seqId") String seqId) {
		caseHandleServiceMgr.delCaseHandle(seqId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/searchHandle")
	public String searchHandle(HttpServletRequest request,Model model,BaseConditionVO vo){
		Map<Object,Object> criterias = new HashMap<Object, Object>();
		criterias.put("caseId", request.getSession().getAttribute("caseId"));
		List<CaseHandleImpl> caseHandleList = caseHandleServiceMgr.searchCaseHandle(criterias, vo);
		model.addAttribute("caseHandleList", caseHandleList);
		vo.setTotalCount(caseHandleList.size());
		model.addAttribute("vo", vo);
		return "/management/handle/caseHandleList";
	}
	
}
