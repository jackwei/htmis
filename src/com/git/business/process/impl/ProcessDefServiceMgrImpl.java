package com.git.business.process.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.book.BookSearchFields;
import com.git.business.process.ActivityDef;
import com.git.business.process.ParticipantDef;
import com.git.business.process.ProcessDef;
import com.git.business.process.ProcessDefServiceMgr;
import com.git.business.sys.Role;
import com.git.business.sys.User;
import com.git.db.beans.SysRole;
import com.git.db.beans.SysUser;
import com.git.db.beans.TblActivityDef;
import com.git.db.beans.TblParticipantDef;
import com.git.db.beans.TblProcessDef;
import com.git.db.beans.TblProcessDefExample;
import com.git.db.mapper.SysRoleMapper;
import com.git.db.mapper.SysUserMapper;
import com.git.db.mapper.TblActivityDefMapper;
import com.git.db.mapper.TblParticipantDefMapper;
import com.git.db.mapper.TblProcessDefMapper;
import com.git.enums.Status;
import com.git.util.Jutil;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * 流程定义以及节点定义的接口的实现
 * @author shona
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service(ProcessDefServiceMgr.SERVICE_NAME)
public class ProcessDefServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ProcessDefServiceMgr{

	@Autowired
	private TblProcessDefMapper processDefMapper;
	@Autowired
	private TblActivityDefMapper activityDefMapper;
	@Autowired
	private SysRoleMapper roleMapper;
	@Autowired
	private SysUserMapper userMapper;
	@Autowired
	private TblParticipantDefMapper participantDefMapper;
	
	/**
	 * 添加流程定义主信息表
	 */
	public int addProcessDef(ProcessDef processDef) {
		TblProcessDef tblProcessDef=processDef.gettblProcessDef();
		return processDefMapper.insert(tblProcessDef);
	}

	/**
	 * 删除流程定义主信息表
	 */
	public int deleteProcessDef(Long processId) {
		return processDefMapper.deleteByPrimaryKey(processId);
	}

	/**
	 * 查询流程定义主信息表
	 */
	public List<ProcessDef> searchProcessDefByCondition(
			Map<BookSearchFields, String> criterias, String orderField,
			int startIndex, int count) {
		 List<ProcessDef> list=new ArrayList<ProcessDef>();
		 TblProcessDefExample example=new TblProcessDefExample();
		 RowBounds rb = new RowBounds(startIndex, count);
	     List<TblProcessDef> listProcessDef=  processDefMapper.selectByExample(example,rb);
		 
	     for (TblProcessDef pro : listProcessDef) {
				list.add(new ProcessDef(pro));
			}
		return list;
	}

	/**
	 * 根据流程定义id查询流程定义主信息表
	 */
	public ProcessDef searchProcessDefById(Long processId) {
	    TblProcessDef tblProcessDef=processDefMapper.selectByPrimaryKey(processId);
		return new ProcessDef(tblProcessDef);
	}

	/**
	 * 获取流程定义主信息的总数
	 */
	public int searchProcessDefNum() {
		TblProcessDefExample example=new TblProcessDefExample();
		return processDefMapper.countByExample(example);
	}


    /**
     * 根据流程id查询对应的节点信息
     * @param processId
     * @return
     */
	public List<ActivityDef> searchActivityDefByProcessId(Long processId) {
		List<TblActivityDef> list=activityDefMapper.selectByProcessId(processId);
		List<ActivityDef> activityDefList=new ArrayList<ActivityDef>();
		for (TblActivityDef activityDef : list) {
			activityDefList.add(new ActivityDef(activityDef));
		}
		return activityDefList;
	}

	/**
	 * 根据流程id查询节点的最大值
	 * @param processId
	 * @return
	 */
	public Long searchMaxId(Long processId) {
		return activityDefMapper.searchMaxId(processId);
	}

	/**
	 * 获取所有角色
	 */
	public List<Role> selectAllRole() {
		List<Role> list=new ArrayList<Role>();
		SysRole sysRole= new SysRole();
		sysRole.setRoleStatus(String.valueOf(Status.Normal.getCode()));
		RowBounds rb = new RowBounds(0, 100);
		List<SysRole> listRole=roleMapper.selectByCondition(sysRole,rb);
		
		for(SysRole tempRole:listRole){
			list.add(new Role(tempRole));
		}
		return list;
	}

	/**
	 * 获取所有用户
	 * @return
	 */
	public List<User> selectAllUser() {
		List<User> list=new ArrayList<User>();
		List<SysUser> listUser=userMapper.selectAllUser();
		
		for(SysUser sysUser:listUser){
			list.add(new User(sysUser));
		}
		return list;
	}

	 /**
	  * 添加节点信息
	  * @param activityDef
	  * @return
	  */
	public int addActivityDef(ActivityDef activityDef) {
		TblActivityDef tblActivityDef=activityDef.getTblActivityDef();
		return activityDefMapper.insert(tblActivityDef);
	}

	/**
	  * 添加节点对应的审批人员信息
	  * @param participantDef
	  * @return
	  */
	public int addParticipantDef(ParticipantDef participantDef) {
		TblParticipantDef tblParticipantDef=participantDef.gettblParticipantDef();
		return participantDefMapper.insert(tblParticipantDef);
	}

	/**
	  * 修改流程定义信息
	  * @param processDef
	  * @return
	  */
	public int updateByPrimaryKeySelective(ProcessDef processDef) {
		TblProcessDef tblProcessDef=processDef.gettblProcessDef();
		return processDefMapper.updateByPrimaryKeySelective(tblProcessDef);
	}

	/**
	 * 根据流程名称以及状态查询流程定义信息
	 * @param tblProcessDef
	 * @param startIndex
	 * @param count
	 * @return
	 */
	public List<ProcessDef> selectByCondition(ProcessDef processDef,
			int startIndex, int count) {
		 TblProcessDef tblProcessDef=processDef.gettblProcessDef();
	   	 List<ProcessDef> list=new ArrayList<ProcessDef>();
		 RowBounds rb = new RowBounds(startIndex, count);
	     List<TblProcessDef> listProcessDef=  processDefMapper.selectByCondition(tblProcessDef, rb);
		 
	     for (TblProcessDef pro : listProcessDef) {
				list.add(new ProcessDef(pro));
			}
		return list;
	}

	/**
	 * 根据流程名称以及状态查询流程个数
	 * @param processDef
	 * @return
	 */
	public int countByCondition(ProcessDef processDef) {
		TblProcessDef tblProcessDef=processDef.gettblProcessDef();
		return processDefMapper.countByCondition(tblProcessDef);
	}

	/**
	  * 根据条件查询角色信息
	  * @param role
	  * @param rb
	  * @return
	  */
	public List<Role> selectByRoleCondition(Role role,int startIndex, int count) {
		SysRole sysRole=role.getSysRole();
		RowBounds rb = new RowBounds(startIndex, count);
		List<SysRole> list= roleMapper.selectByCondition(sysRole, rb);
		List<Role> listRole=new ArrayList<Role>();
		
		for(SysRole srole:list){
			listRole.add(new Role(srole));
		}
		
		return listRole;
	}

	/**
	  * 根据条件查询角色信息个数
	  * @param role
	  * @return
	  */
	public int countByRoleCondition(Role role) {
		SysRole sysRole=role.getSysRole();
		return roleMapper.countByCondition(sysRole);
	}

	 /**
	  * 根据条件查询用户信息
	  * @param user
	  * @param startIndex
	  * @param count
	  * @return
	  */
	public List<User> selectByUserCondition(User user, int startIndex, int count) {
         SysUser sysUser=user.getSysUser();
         RowBounds rb = new RowBounds(startIndex, count);
         List<SysUser> userList=userMapper.selectByUserCondition(sysUser, rb);
         List<User> list=new ArrayList<User>();
         
         for(SysUser users:userList){
                list.add(new User(users));        	 
         }
		return list;
	}


	 /**
	  * 根据条件查询用户信息个数
	  * @param user
	  * @return
	  */
	public int countByUserCondition(User user) {
		SysUser sysUser=user.getSysUser();
		return userMapper.countByUserCondition(sysUser);
	}

	/**
	  * 根据id查询节点信息
	  * @param activityId
	  * @return
	  */
	public ActivityDef searchActivityDefById(Long activityId) {
	    TblActivityDef tblActivityDef=activityDefMapper.selectByPrimaryKey(activityId);
		return new ActivityDef(tblActivityDef);
	}

	/**
	  * 根据节点id查询对应的参与者信息
	  * @param activityDefId
	  * @return
	  */
	public List<ParticipantDef> selectByActivityDefId(ParticipantDef participantDef) {
		TblParticipantDef tblParticipantDef=participantDef.gettblParticipantDef();
		List<ParticipantDef> list=new ArrayList<ParticipantDef>();
		List<TblParticipantDef> listP=participantDefMapper.selectByActivityDefId(tblParticipantDef);
		
		for(TblParticipantDef par:listP){
			list.add(new ParticipantDef(par));
		}
		return list;
	}

	 /**
	  * 修改节点信息
	  * @param activityDef
	  * @return
	  */
	public int updateByPrimaryKey(ActivityDef activityDef) {
		TblActivityDef tblActivityDef=activityDef.getTblActivityDef();
		return activityDefMapper.updateByPrimaryKey(tblActivityDef);
	}

	 /**
	  * 根据节点id删除参与者信息
	  * @param activityId
	  * @return
	  */
	public int deleteByActivityId(ParticipantDef participantDef) {
		TblParticipantDef tblParticipantDef=participantDef.gettblParticipantDef();
		return participantDefMapper.deleteByActivityId(tblParticipantDef);
	}
}
