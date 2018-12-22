package com.git.web.sys;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

import com.git.business.sys.Role;
import com.git.business.sys.RoleServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.enums.Status;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller("role.roleController")
@RequestMapping(value="/system/role")
public class RoleController extends BaseController{
	@Autowired
	private RoleServiceMgr roleMgr;

	@RequestMapping("")
	public String layout(BaseConditionVO vo, Model model) {
		List<Role> roleList = roleMgr.searchRole(vo);
		Integer totalCount = roleMgr.searchRoleNum(vo);
		
		vo.setTotalCount(totalCount);
		model.addAttribute("roleList", roleList);
		model.addAttribute("vo",vo);

		return "/system/role/roleList";
	}
		
	@RequestMapping("/add")
	public String add(Model model) throws JsonGenerationException, JsonMappingException, IOException {
		
		List<Map> menuList = roleMgr.getMenuList();
		
		ObjectMapper mapper=new ObjectMapper();		
		model.addAttribute("menuList",mapper.writeValueAsString(menuList));
		
		return "/system/role/roleAdd";
	}
	
	@RequestMapping("/edit/{roleId}")
	public String edit(@PathVariable("roleId") Long roleId, Model model)throws JsonGenerationException, JsonMappingException, IOException {
		Role role = roleMgr.getRole(roleId);

		model.addAttribute("role", role);
		model.addAttribute("statusList", Status.values());
		
		List<Map> menuList = roleMgr.getMenuList();
		List<Map> roleMenuList = roleMgr.getRoleMenuList(role);
		
		ObjectMapper mapper=new ObjectMapper();		
		model.addAttribute("menuList",mapper.writeValueAsString(menuList));
		model.addAttribute("roleMenuList",mapper.writeValueAsString(roleMenuList));

		return "/system/role/roleEdit";
	}
		
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request,Role role) {
		
		String tRoleMenu = request.getParameter("selectMenuArray");
		
		role.setExtend1(tRoleMenu);
		
		roleMgr.addRole(role);
		

		return ajaxDone(200, "保存成功");

		//return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,Role role) {
		
		String tRoleMenu = request.getParameter("selectMenuArray1");
		
		String roleStatus = request.getParameter("roleStatus");
		
		role.setExtend1(tRoleMenu);
		role.setRoleStatus(roleStatus);
				
		roleMgr.updRole(role);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	@RequestMapping("/delete/{roleId}")
	public ModelAndView delete(@PathVariable("roleId") Long roleId) {

		roleMgr.delRole(roleId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
		
	@RequestMapping("/roleSearch")
	public String orgSearchlist(BaseConditionVO vo,Model model) {
		
		List<Role> roleList = roleMgr.searchRole(vo);
		Integer totalCount = roleMgr.searchRoleNum(vo);
		vo.setTotalCount(totalCount);
		model.addAttribute(roleList);
		model.addAttribute("vo", vo);
		
		return "/system/role/roleSearch";
	}
	
	@RequestMapping(value = "/checkRoleName")
	@ResponseBody
	public String checkRoleName(HttpServletRequest request){
		Role role = new Role();
		String roleId = request.getParameter("roleId");
		if(roleId == null || "".equals(roleId))
		{
			role.setId((long)0);
		}
		else
		{
			role.setId(Long.valueOf(roleId));
		}
		
		role.setRoleName(request.getParameter("roleName"));
		
		boolean  result = roleMgr.isUniqueRoleName(role);
		if(result)
			return "true";
		else
			return "false";
	}
}
