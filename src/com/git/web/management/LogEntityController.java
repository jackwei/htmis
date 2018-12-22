package com.git.web.management;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.service.LogEntityService;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.LogEntity;
import com.git.log.Log;
import com.git.log.LogLevel;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.web.BaseController;

import dwz.framework.config.Constants;

@Controller
@RequestMapping("/management/logEntity")
public class LogEntityController extends BaseController{
	
	@Autowired
	private LogEntityService logEntityService;
	
	private User user;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("")
	public String list(HttpServletRequest request,BaseConditionVO vo,Model model) {
		Map<Object, Object> criterias = new HashMap<Object,Object>();
		criterias.put("username", request.getParameter("username"));
		criterias.put("ipAddress", request.getParameter("ipAddress"));
		criterias.put("logLevel", request.getParameter("logLevel"));
		
		Map search = logEntityService.search(criterias, vo);
		List<LogEntity> logEntityList = (List<LogEntity>)search.get("logEntityList");
		int count = (Integer)search.get("count");
		vo.setTotalCount(count);
		model.addAttribute("vo", vo);
		model.addAttribute("logLevels", LogLevel.values());
		model.addAttribute("logEntityList", logEntityList);
		return "/management/logEntity/list";
	}
	
	@Log(message="{0} 删除了 {1} 条日志。")
	@RequestMapping("/delete")
	public ModelAndView delete(HttpServletRequest request){
		user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		String[] ids = request.getParameterValues("ids");

		for (int i = 0; i < ids.length; i++) {
			String id = ids[i];
			logEntityService.delete(Long.valueOf(id));
		}
		
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),ids.length}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	}

}
