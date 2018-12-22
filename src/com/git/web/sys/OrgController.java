package com.git.web.sys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.httpclient.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.sys.Org;
import com.git.business.sys.OrgConditionVO;
import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.enums.OrgType;
import com.git.enums.Status;
import com.git.enums.YesNo;
import com.git.util.PubDateUtil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/system/org")
public class OrgController extends BaseController{
	@Autowired
	private OrgServiceMgr orgMgr;
	
	@RequestMapping("")
	public String list(OrgConditionVO vo,Model model,HttpServletRequest request) {
		
		//List<Org> orgList = orgMgr.searchOrg(vo, vo.getStartIndex(), vo.getPageSize());
		
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("keywords", vo.getKeywords());
		criterias.put("orgStatus", vo.getOrgStatus() == null ? "1":vo.getOrgStatus());
		
		Map search = orgMgr.searchOrg(criterias, vo);
		List<Org> orgList = (List<Org>)search.get("orgList");
		Integer totalCount = (Integer)search.get("count");
		
		//int totalCount = orgMgr.searchOrgNum(vo);
		vo.setTotalCount(totalCount);
		model.addAttribute("orgList",orgList);
		model.addAttribute("vo", vo);
		model.addAttribute("orgStatusList",Status.values());
		return "/system/org/orgList";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("orgTypeList",OrgType.values());
		//model.addAttribute("orgLevelList",Jutil.getDictEntry("orglevel"));
		model.addAttribute("yesNo",YesNo.values());
		return "/system/org/orgAdd";
	}
	
	@RequestMapping("/edit/{orgId}")
	public String edit(@PathVariable("orgId") Long orgId, Model model) {
		Org org = orgMgr.getOrg(orgId);
		
		model.addAttribute("orgTypeList",OrgType.values());
		model.addAttribute("yesNo",YesNo.values());
		model.addAttribute("status",Status.values());
		model.addAttribute(org);
		
		return "/system/org/orgEdit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request,Org org) {
		
		String parentOrgId = request.getParameter("orgLookup.id");
		String parentOrgLevel = request.getParameter("orgLookup.orgLevel");
		String parentOrgCode = request.getParameter("orgLookup.orgCode");
		String parentOrgName = request.getParameter("orgLookup.extend1");
		
		String orgMainUser = request.getParameter("deptLookup.id");
		String orgLeaderUser = request.getParameter("leaderLookup.id");
		
		org.setParentId(Long.valueOf(parentOrgId));
		org.setOrgLevel(Integer.valueOf(parentOrgLevel)+1);
		org.setOrgCode(parentOrgCode);
		org.setExtend1(parentOrgName.concat("->").concat(org.getOrgSname()));
		org.setDeptManagerId(Long.valueOf(orgMainUser));
		org.setDeptLeaderId(Long.valueOf(orgLeaderUser));
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		org.setOperatorId(user.getId());
		org.setModifyOperatorId(user.getId());
		
		orgMgr.addOrg(org);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,Org org) throws ParseException {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		String createTime = request.getParameter("createTime");
		String orgLevel = request.getParameter("orgLevel");
		org.setOrgLevel(Integer.valueOf(orgLevel));
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(createTime != null && !"".equals(createTime))
		{
			org.setCreateTime(df.parse(createTime));
		}
		
		org.setModifyOperatorId(user.getId());
		orgMgr.updOrg(org);
		return ajaxDoneError(getMessage("msg.operation.success"));

	}
	
	@RequestMapping("/delete/{orgId}")
	public ModelAndView delete(@PathVariable("orgId") long orgId) {

		orgMgr.delOrg(orgId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/orgSearch")
	public String orgSearchlist(HttpServletRequest request,OrgConditionVO vo,Model model) {
		
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("orgType", request.getParameter("orgType") == null ? "767":request.getParameter("orgType"));
		criterias.put("keywords", vo.getKeywords());
		criterias.put("orgStatus", vo.getOrgStatus() == null ? "1":vo.getOrgStatus());
		
		Map search = orgMgr.searchOrg(criterias, vo);
		List<Org> orgList = (List<Org>)search.get("orgList");
		Integer totalCount = (Integer)search.get("count");
		
		//int totalCount = orgMgr.searchOrgNum(vo);
		vo.setTotalCount(totalCount);
		model.addAttribute("orgList",orgList);
		model.addAttribute("vo", vo);
		
		vo.setTotalCount(totalCount);
		model.addAttribute(orgList);
		model.addAttribute("vo", vo);
		return "/system/org/orgSearch";
	}
}
