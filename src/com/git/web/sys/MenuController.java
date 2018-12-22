package com.git.web.sys;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.sys.Menu;
import com.git.business.sys.MenuServiceMgr;
import com.git.business.sys.OrgConditionVO;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.enums.OrgType;
import com.git.enums.Status;
import com.git.enums.YesNo;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping(value="/system/menu")
public class MenuController extends BaseController{
	@Autowired
	private MenuServiceMgr menuMgr;
	
	@RequestMapping("")
	public String list(Model model) {
		
		List<Menu> menuList = menuMgr.searchMenu((long)0);		
		model.addAttribute(menuList);
		
		return "/system/menu/menuList";
	}
	
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("orgTypeList",OrgType.values());
		//model.addAttribute("orgLevelList",Jutil.getDictEntry("orglevel"));
		model.addAttribute("yesNo",YesNo.values());
		return "/system/menu/orgAdd";
	}
	
	@RequestMapping("/edit/{menuId}")
	public String edit(@PathVariable("menuId") Long menuId, Model model) {
		Menu menu = menuMgr.getMenu(menuId);
		
		model.addAttribute("orgTypeList",OrgType.values());
		model.addAttribute("yesNo",YesNo.values());
		model.addAttribute("status",Status.values());
		model.addAttribute(menu);
		
		return "/system/menu/menuEdit";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request,Menu menu) {
		
		String parentOrgId = request.getParameter("orgLookup.id");
		String parentOrgLevel = request.getParameter("orgLookup.orgLevel");
		String parentOrgCode = request.getParameter("orgLookup.orgCode");
		
		
		
		menuMgr.addMenu(menu);

		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,Menu menu) throws ParseException {
				
		menuMgr.updMenu(menu);
		return ajaxDoneError(getMessage("msg.operation.success"));

	}
	
	@RequestMapping("/delete/{menuId}")
	public ModelAndView delete(@PathVariable("menuId") long menuId) {

		menuMgr.delMenu(menuId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/subMenu")
	public String subMenuSearch(HttpServletRequest request, Model model) {
		
		String tParentId = request.getParameter("parentId");
		if(tParentId == null || "".equals(tParentId))
			tParentId = "-1";
		List<Menu> menuList = menuMgr.searchMenu(Long.parseLong(tParentId));		
		model.addAttribute(menuList);
		
		return "/system/menu/subMenu";
	}
}
