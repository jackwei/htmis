package com.git.web.sys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.sys.Org;
import com.git.business.sys.OrgConditionVO;
import com.git.business.sys.User;
import com.git.business.sys.UserConditionVO;
import com.git.business.sys.UserServiceMgr;
import com.git.db.BaseConditionVO;
import com.git.enums.Gender;
import com.git.enums.UserStatus;
import com.git.util.Jutil;
import com.git.web.BaseController;

import dwz.framework.config.Constants;
import dwz.framework.sys.exception.ServiceException;

@Controller("user.userController")
@RequestMapping(value="/system/user")
public class UserController extends BaseController{
	@Autowired
	private UserServiceMgr userMgr;

	@RequestMapping("")
	public String layout(UserConditionVO vo, Model model) {
		
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("keywords", vo.getKeywords());
		criterias.put("userStatus", vo.getUserStatus()== null ? "1":vo.getUserStatus());
		criterias.put("userGroup", vo.getUserGroup());
		
		Map userMap = userMgr.searchUser(criterias, vo);
		
		List<User> userList = (List<User>)userMap.get("userList");
		Integer totalCount = (Integer)userMap.get("count");
//		List<User> userList = userMgr.searchUser(vo);
//		Integer totalCount = userMgr.searchUserNum(vo);
		
		/*查询用户的所有部门*/
		List groupList = userMgr.searchUserGroup();
		vo.setTotalCount(totalCount);
		
		model.addAttribute("userList", userList);
		model.addAttribute("groupList",groupList);
		model.addAttribute("userStatusList", UserStatus.values());
		//model.addAttribute("pageSize", vo.getPageSize());
		model.addAttribute("vo",vo);

		return "/system/user/userList";
	}
		
	@RequestMapping("/add")
	public String add(Model model) {
		model.addAttribute("genderList", Gender.values());
		return "/system/user/userAdd";
	}
	
	@RequestMapping("/edit/{userId}")
	public String edit(@PathVariable("userId") Long userId, Model model) {
		User user = userMgr.getUser(userId);

		model.addAttribute("user", user);
		model.addAttribute("genderList", Gender.values());
		model.addAttribute("userStatusList", UserStatus.values());

		return "/system/user/userEdit";
	}
	
	@RequestMapping(value = "/checkUserCode")
	@ResponseBody
	public String checkCaseNumber(HttpServletRequest request){
		User user = new User();
		String userId = request.getParameter("userId");
		if(userId == null || "".equals(userId))
		{
			user.setId((long)0);
		}
		else
		{
			user.setId(Long.valueOf(userId));
		}
		
		user.setUserCode(request.getParameter("userCode"));
		
		boolean  result = userMgr.isUniqueUserCode(user);
		if(result)
			return "true";
		else
			return "false";
	}
	
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public ModelAndView insert(HttpServletRequest request,User user) {
		try {
			HttpSession session = request.getSession();
			User loginUser = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
			
			user.setOperatorId(loginUser.getId());
			user.setModifyOperatorId(loginUser.getId());
			
			String orgId = request.getParameter("orgLookup.id");
			String orgcode = request.getParameter("orgLookup.orgCode");
			String orgFullName = request.getParameter("orgLookup.extend1");
//			System.out.println("UserController中id:"+orgId);
//			System.out.println("UserController中orgcode:"+orgcode);
//			System.out.println("UserController中orgFullName:"+orgFullName);
			
			user.setOrgId(Long.valueOf(orgId));
			user.setOrgCode(orgcode);
			user.setOrgName(orgFullName);
			
			
			String roleId = request.getParameter("roleLookup.id");
			String roleName = request.getParameter("roleLookup.name");
			
			user.setExtend1(roleId);
			user.setExtend2(roleName);
			
			userMgr.addUser(user,roleId);
		} catch (ServiceException e) {
			return ajaxDoneError(e.getMessage());
		}

		return ajaxDone(200, "保存成功");

		//return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView update(HttpServletRequest request,User user) {
		HttpSession session = request.getSession();
		User loginUser = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		
		user.setModifyOperatorId(loginUser.getId());
		
		/*String orgId = request.getParameter("orgLookup.id");
		String orgFullName = request.getParameter("orgLookup.extend1");
		user.setOrgId(Long.valueOf(orgId));
		user.setOrgCode(orgId);
		user.setOrgName(orgFullName);*/
		/*if(!String.valueOf(user.getOrgId()).equals(orgId))//如果orgId不相等，表明用户重新选择了归属部门
		{
			//设置用户归属部门所在的机构，主要用来做后续的查询使用
			String tSql = "SELECT ifnull(org_code,'') orgCode FROM sys_group WHERE org_id = (SELECT parent_id FROM sys_group WHERE org_id ="+user.getOrgId()+" ) ";
			String tOrgCode = Jutil.getOneValue(tSql, "orgCode");
			user.setOrgCode(tOrgCode);
		}*/
		
		String roleId = request.getParameter("roleLookup.id");
		String roleName = request.getParameter("roleLookup.name");
		
		user.setExtend1(roleId);
		user.setExtend2(roleName);
		
		userMgr.updUser(user,roleId);
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}
	
	
	@RequestMapping("/delete/{userId}")
	public ModelAndView delete(@PathVariable("userId") Long userId) {

		userMgr.delUser(userId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/inactive/{userId}")
	public ModelAndView inactive(@PathVariable("userId") Long userId) {

		userMgr.inactiveUser(userId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/normal/{userId}")
	public ModelAndView normal(@PathVariable("userId") Long userId) {

		userMgr.normalUser(userId);

		return ajaxDoneError(getMessage("msg.operation.success"));
	}
	
	@RequestMapping("/userSearch")
	public String orgSearchlist(HttpServletRequest request,UserConditionVO vo,Model model) {
		
		String userStatus = request.getParameter("userStatus");
		String orgCode = request.getParameter("orgCode");//用户所属机构
		vo.setUserStatus(userStatus);//只查询正常的
		if(orgCode !=null && !"".equals(orgCode))
		{
			vo.setOrgCode(orgCode);
		}
		List<User> userList = userMgr.searchUser(vo);
		Integer totalCount = userMgr.searchUserNum(vo);
		vo.setTotalCount(totalCount);
		model.addAttribute(userList);
		model.addAttribute("vo", vo);
		
		return "/system/user/userSearch";
	}
}
