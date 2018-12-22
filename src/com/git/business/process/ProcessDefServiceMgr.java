package com.git.business.process;


import java.util.List;
import java.util.Map;




import com.git.business.book.BookSearchFields;
import com.git.business.sys.Role;
import com.git.business.sys.User;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
/**
 * 流程定义以及节点定义的接口
 * @author shona
 *
 */
public interface ProcessDefServiceMgr extends BusinessObjectServiceMgr {
	
	String SERVICE_NAME = "ProcessDefServiceMgr";

	/**
	 * 添加流程定义主信息表
	 * @param processDef
	 * @return
	 */
	int addProcessDef(ProcessDef processDef);
	
	/**
	 * 删除流程定义主信息表
	 * @param processId
	 * @return
	 */
	
	int deleteProcessDef(Long processId);
	
	/**
	 * 查询流程定义主信息表
	 * @param criterias
	 * @param orderField
	 * @param startIndex
	 * @param count
	 * @return
	 */
	List<ProcessDef> searchProcessDefByCondition(Map<BookSearchFields, String> criterias,
				String orderField, int startIndex, int count);
	
	/**
	 * 根据流程名称以及状态查询流程定义信息
	 * @param tblProcessDef
	 * @param startIndex
	 * @param count
	 * @return
	 */
	List<ProcessDef> selectByCondition(ProcessDef processDef, int startIndex, int count);
	/**
	 * 根据流程定义id查询流程定义主信息表
	 * @param processId
	 * @return
	 */
	ProcessDef searchProcessDefById(Long processId);
	
	/**
	 * 获取流程定义主信息的总数
	 * @return
	 */
	int searchProcessDefNum();
	
	/**
	 * 根据流程名称以及状态查询流程个数
	 * @param processDef
	 * @return
	 */
	int countByCondition(ProcessDef processDef);
	

    /**
     * 根据流程id查询对应的节点信息
     * @param processId
     * @return
     */
	List<ActivityDef> searchActivityDefByProcessId(Long processId);
	
	/**
	 * 根据流程id查询节点的最大值
	 * @param processId
	 * @return
	 */
	Long searchMaxId(Long processId);
	
	/**
	 * 获取所有角色
	 * @return
	 */
	List<Role> selectAllRole();
	
	/**
	 * 获取所有用户
	 * @return
	 */
	 List<User> selectAllUser();
	 
	 /**
	  * 添加节点信息
	  * @param activityDef
	  * @return
	  */
	 int addActivityDef(ActivityDef activityDef);
	 
	    
	 /**
	  * 添加节点对应的审批人员信息
	  * @param participantDef
	  * @return
	  */
	 int addParticipantDef(ParticipantDef participantDef);
	 
	 /**
	  * 修改流程定义信息
	  * @param processDef
	  * @return
	  */
	 int updateByPrimaryKeySelective(ProcessDef processDef);
	 
	 /**
	  * 根据条件查询角色信息
	  * @param role
	  * @param rb
	  * @return
	  */
	 List<Role> selectByRoleCondition(Role role,int startIndex, int count);
	 
	 /**
	  * 根据条件查询角色信息个数
	  * @param role
	  * @return
	  */
	 int countByRoleCondition(Role role);
	 
	 /**
	  * 根据条件查询用户信息
	  * @param user
	  * @param startIndex
	  * @param count
	  * @return
	  */
	 List<User> selectByUserCondition(User user,int startIndex, int count);
	 
	 /**
	  * 根据条件查询用户信息个数
	  * @param user
	  * @return
	  */
	 int countByUserCondition(User user);
	 
	 /**
	  * 根据id查询节点信息
	  * @param activityId
	  * @return
	  */
	 ActivityDef searchActivityDefById(Long activityId);
	 
	 /**
	  * 根据节点id查询对应的参与者信息
	  * @param activityDefId
	  * @return
	  */
	 List<ParticipantDef> selectByActivityDefId(ParticipantDef participantDef);
	 
	 /**
	  * 修改节点信息
	  * @param activityDef
	  * @return
	  */
	 int updateByPrimaryKey(ActivityDef activityDef);
	 
	 /**
	  * 根据节点id删除参与者信息
	  * @param activityId
	  * @return
	  */
	 int deleteByActivityId(ParticipantDef participantDef);
	 	 
}
