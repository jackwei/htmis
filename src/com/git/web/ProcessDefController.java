package com.git.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.git.business.process.ActivityDef;
import com.git.business.process.ParticipantDef;
import com.git.business.process.ProcessDef;
import com.git.business.process.ProcessDefServiceMgr;
import com.git.business.sys.Role;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.enums.UserStatus;
import com.git.log.Log;
import com.git.log.LogMessageObject;
import com.git.log.impl.LogUitl;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;


/**
 * 流程定义以及节点定义的Controller
 * @author shona
 *
 */
@Controller
@RequestMapping(value="/processDef")
public class ProcessDefController extends BaseController {

	@Autowired
	private ProcessDefServiceMgr processDefServiceMgr;
	
	@Autowired
	private SequenceService sequenceService;
	
	/**
	 * 进入流程列表页面
	 * @param vo
	 * @param request
	 * @return
	 */
	@RequestMapping("/list")
	public ModelAndView list(BaseConditionVO vo,ProcessDef processDef,HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		ModelAndView modelAndView=new ModelAndView();
		String mark=request.getParameter("mark");
		try{
//		  List<ProcessDef> list=processDefServiceMgr.searchProcessDefByCondition(null, null, vo.getStartIndex(), vo.getPageSize());
//		  int totalCount=processDefServiceMgr.searchProcessDefNum();
		  if(processDef.getCurrentState()!=null){
			  if(processDef.getCurrentState().equals("0")){
				  processDef.setCurrentState(null);
			  }
		  }
	      List<ProcessDef> list=processDefServiceMgr.selectByCondition(processDef,vo.getStartIndex(), vo.getPageSize());
	      int totalCount=processDefServiceMgr.countByCondition(processDef);
		  vo.setTotalCount(totalCount);
		  modelAndView.addObject("processDef", processDef);
		  modelAndView.addObject("list", list);
		  modelAndView.addObject("vo",vo);
			if(1==user.getId()){
				modelAndView.addObject("definedflag", "1");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		if(!"".equals(mark) && mark.equals("1")){
			modelAndView.setViewName("/process/processDefList");
		}else{
			modelAndView.setViewName("/common/processDefBack");
		}
		modelAndView.addObject("mark", mark);
		return modelAndView;
	}
	
	/**
	 * 进入流程定义界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/addProcessDef")
	public ModelAndView addProcessDef() {
		return new ModelAndView("/process/addProcessDef");
	}
	
	/**
	 * 流程定义信息
	 * @param processDef
	 * @return
	 */
	@Log(message="{0}定义流程  {1}。")
	@RequestMapping(value = "/insertProcessDef", method = RequestMethod.POST)
	public ModelAndView insertProcessDef(ProcessDef processDef,HttpServletRequest request){
	  try{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		processDef.setCurrentState("1");
		if(processDef.getDesc().contains("代收代付")){
			processDef.setNo("0001");
		}
		if(processDef.getDesc().contains("垫付")){
			processDef.setNo("0002");
		}
		if(processDef.getDesc().contains("第三方")){
			processDef.setNo("0005");
		}
		if(processDef.getDesc().contains("余额退回")){
			processDef.setNo("0006");
		}
		
		
		processDefServiceMgr.addProcessDef(processDef);
		LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),processDef.getName()}));
		return ajaxDoneSuccess(getMessage("msg.operation.success"));
	  }catch (Exception e) {
		 e.printStackTrace();
	   	return ajaxDoneError(getMessage("msg.operation.failure"));
	  }
	}
	
	/**
	 * 进入流程节点页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/toList/{processId}")
	public ModelAndView toList(@PathVariable("processId") Long processId){
//		ModelAndView model=new ModelAndView();
//		try{
//		  ProcessDef processDef=processDefServiceMgr.searchProcessDefById(processId);
//		  List<ActivityDef> listActivityDef=processDefServiceMgr.searchActivityDefByProcessId(processId);
//		  model.addObject("parm", processDef);
//		  model.addObject("list", listActivityDef);
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		 model.setViewName("/process/activityDefList");
//		return model;
		return this.commonList(processId);
	}
	
	public ModelAndView commonList(Long processId){
		ModelAndView model=new ModelAndView();
		try{
			ProcessDef processDef=processDefServiceMgr.searchProcessDefById(processId);
			List<ActivityDef> listActivityDef=processDefServiceMgr.searchActivityDefByProcessId(processId);
			model.addObject("parm", processDef);
			model.addObject("list", listActivityDef);
		}catch (Exception e) {
		  e.printStackTrace();
		}
		model.setViewName("/process/activityDefList");
		return model;
	}
	/**
	 * 返回节点页面
	 * @param request
	 * @return
	 */
	@RequestMapping("/backList")
	public ModelAndView backList(HttpServletRequest request){
		String processId=request.getParameter("processId");
		return this.commonList(Long.valueOf(processId));
	}
	
	
	/**
	 * 进入定义流程节点界面
	 * @param request
	 * @return
	 */
	@RequestMapping("/addActivityDef")
	public ModelAndView addActivityDef(HttpServletRequest request) {
		Long processId=Long.valueOf(request.getParameter("processId"));
		ModelAndView model=new ModelAndView();
		model.addObject("processId", processId);
		model.setViewName("/process/addActivityDef");
		return model;
	}
	/**
	 * 定义/修改流程节点信息
	 * @param processDef
	 * @return
	 */
	@Log(message="{0}{1}流程节点 {2}。")
	@RequestMapping(value = "/insertActivityDef", method = RequestMethod.POST)
	public ModelAndView insertActivityDef(ActivityDef activityDef,ParticipantDef participantDef,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		String ids="";
		String names="";
		if(participantDef.getType().equals("1")){
			 ids=request.getParameter("orgLookup.id");
			 names=request.getParameter("orgLookup.roleName");
		}else{
			ids=request.getParameter("orgLookup.userid");
			names=request.getParameter("orgLookup.userName");
		}
		Long processId=activityDef.getProcessId();
		Long activityId=activityDef.getId();
		participantDef.setActivityiId(activityId);
		String type=participantDef.getType();
		
	  try{
		int count=0;
		if(activityId!=null){
			processDefServiceMgr.updateByPrimaryKey(activityDef);
			List<ParticipantDef> list=processDefServiceMgr.selectByActivityDefId(participantDef);
			if(list!=null && list.size()!=0){
				count=processDefServiceMgr.deleteByActivityId(participantDef);
			}else{
				count=1;
			}
			LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"修改",activityDef.getName()}));
		}else{
			List<ActivityDef> list=processDefServiceMgr.searchActivityDefByProcessId(processId);
			if(list!=null && list.size()!=0){
	           activityDef.setPreActivity(String.valueOf(processDefServiceMgr.searchMaxId(processId)));
		    }else{
		       activityDef.setPreActivity("0");
		    }
			
		    activityId = sequenceService.getSequence("activity_def_id");
		    activityDef.setId(activityId);
		    
		    count=processDefServiceMgr.addActivityDef(activityDef);	
		    LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),"新增",activityDef.getName()}));
		}
	    if(count!=0){
	    	String[] arr=ids.split(",");
	    	String[] arr1=names.split(",");
	    	if(!"".equals(arr) && arr.length!=0){
	    		for(int i=0;i<arr.length;i++){
	    			if(!"".equals(arr[i])){
//	    				if("1".equals(type)){	    					
	    					 addParticipantDefCommon(arr1[i], type,Long.valueOf(arr[i]), activityId, processId,"");
//	    				}
	    			}
	    		}
	    	}
    	  return ajaxDoneSuccess(getMessage("msg.operation.success"));
	    }else{
	      return ajaxDoneError(getMessage("msg.operation.failure"));
		}
		}catch (Exception e) {
			e.printStackTrace();
			return ajaxDoneError(getMessage("msg.operation.failure"));
		}
	}
	
	/**
	 * 添加节点参与者信息
	 * @param value
	 * @param type
	 * @param valueId
	 * @param activityId
	 * @param processId
	 */
	public void addParticipantDefCommon(String value,String type,Long valueId,Long activityId, Long processId,String value2){
		 ParticipantDef participantDef=new ParticipantDef();
		 participantDef.setParticValue(value);
		 participantDef.setType(type);
    	 participantDef.setParticValueId(valueId);
    	 participantDef.setActivityiId(activityId);
    	 participantDef.setProcessId(processId);
    	 participantDef.setValue2(value2);
    	 processDefServiceMgr.addParticipantDef(participantDef);
	}
	
	/**
	 * 编辑流程定义信息
	 * @param processDef
	 * @return
	 */
	@Log(message="{0}修改流程{1}。")
	@RequestMapping(value = "/updateProcessDef", method = RequestMethod.POST)
	public ModelAndView updateProcessDef(ProcessDef processDef,HttpServletRequest request){
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
	    int count=processDefServiceMgr.updateByPrimaryKeySelective(processDef);
	    if(count!=0){
	    	 LogUitl.putArgs(LogMessageObject.newWrite().setObjects(new Object[]{user.getName(),processDef.getName()}));
	    	 return ajaxDoneSuccess(getMessage("msg.operation.success"));
	    }else{
	    	 return ajaxDoneError(getMessage("msg.operation.failure"));
	    }
	}
	
	/**
	 * 进入节点编辑页面
	 * @param processId
	 * @return
	 */
	@RequestMapping("/toActivityDef")
	public ModelAndView toActivityDef(HttpServletRequest request){
        String processId=request.getParameter("processId");
        Long activityId=Long.valueOf(request.getParameter("activityId")); 
		ModelAndView model=new ModelAndView();
		ActivityDef activityDef=processDefServiceMgr.searchActivityDefById(activityId);
		ParticipantDef participantDef=new ParticipantDef();
		participantDef.setActivityiId(activityId);
		participantDef.setProcessId(Long.valueOf(processId));
		List<ParticipantDef> list=processDefServiceMgr.selectByActivityDefId(participantDef);
		String values="";
		String ids="";
		String type="";
		String vl="";
        if(list!=null && list.size()!=0){
			for(int i=0;i<list.size();i++){
				ParticipantDef p=list.get(i);
				type=p.getType();				
				values+=p.getParticValue()+",";
				
				ids+=p.getParticValueId()+",";
			}
		}
		model.addObject("activityDef", activityDef);
		model.addObject("type", type);
		if(type.equals("1")){
			model.addObject("roleid", ids);
			model.addObject("rolevalue", values);
		}else{
			model.addObject("userid", ids);
			model.addObject("uservalue", values);
		}
		model.addObject("processId", processId);
		model.setViewName("/process/addActivityDef");
		return model;
	}
	
	
	/**
	 *读取节点定义参与者的相关信息
	 * @param request
	 * @return
	 */
	@RequestMapping("/participantValue")
	public ModelAndView participantValue(HttpServletRequest request,Role role,BaseConditionVO vo,User user){
		String type=request.getParameter("type");
		ModelAndView model=new ModelAndView();
		int totalCount=0;
		try{
        if(type.equals("1")){
        	role.setRoleStatus("1");
           List<Role> listRole=processDefServiceMgr.selectByRoleCondition(role, vo.getStartIndex(), vo.getPageSize());
           totalCount=processDefServiceMgr.countByRoleCondition(role);
 		   vo.setTotalCount(totalCount);
 		   model.addObject("role", role);
 		   model.addObject("list", listRole);
 		   model.addObject("vo",vo);
           model.setViewName("/process/roleList");
		}else{
			user.setUserStatus(String.valueOf(UserStatus.Normal.getCode()));
			List<User> listUser=processDefServiceMgr.selectByUserCondition(user, vo.getStartIndex(), vo.getPageSize());
		    totalCount=processDefServiceMgr.countByUserCondition(user);
		    vo.setTotalCount(totalCount);
	 		model.addObject("user", user);
	 	    model.addObject("list", listUser);
	 	    model.addObject("vo",vo);
	        model.setViewName("/process/userList");
		}
		}catch (Exception e) {
            e.printStackTrace();
            return ajaxDoneError(getMessage("msg.operation.failure"));
        }
		return model;
	}
}
