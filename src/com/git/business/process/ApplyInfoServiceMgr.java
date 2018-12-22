package com.git.business.process;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.business.sys.User;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.TblApplyInfos;

import dwz.framework.sys.business.BusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * 呈批件信息接口
 * @author shona
 *
 */
public interface ApplyInfoServiceMgr extends BusinessObjectServiceMgr {

	String SERVICE_NAME = "applyInfoServiceMgr";
	
	 /**
	 * 添加呈批件信息
	 * @param applyInfos
	 * @return
	 */
	int addApplyInfos(ApplyInfos applyInfos);
	
	/**
	 * 添加呈批件附件信息
	 * @param docInfos
	 * @return
	 */
	int addDocInfos(DocInfos docInfos);
	
	 /**
	  * 根据第三方状态id查询第三方信息
	  * @param detailId
	  * @return
	  */
	 CaseBillDetailImpl selectByDetailId(Long detailId);
	 
	/**
	 * 判断呈批件是否是申请状态
	 * @param parentId
	 * @return
	 */
	 List<TblApplyInfos> selectByCondition(Long parentId);
	 
	 /**
	  * 根据第三方id查询第三方状态信息
	  * @param consignorid
	  * @return
	  */
	 CaseBillDetailImpl selectByConsignorid(Long consignorid);
	 
	 /**
	  * 根据呈批件id查询对应的附件信息
	  * @param applyid
	  * @return
	  */
	 List<DocInfos> selectByApplyId(Long applyid,String docType);;
	 
	 /**
	  * 根据id删除附件信息
	  * @param oid
	  * @return
	  */
	 int deleteByOid(Long oid);
	 
	 /**
	  * 根据id获取第三方状态信息
	  * @param detailId
	  * @return
	  */
	 CaseBillDetailImpl searchCaseBillDetail(Long detailId);
	 
	 /**
	  * 根据主键id查询文档信息
	  * @param oid
	  * @return
	  */
	 DocInfos selectByOid(Long oid);
	 
	  /**
	  * 根据主键id查询呈批件信息
	  * @param oid
	  * @return
	  */
	 ApplyInfos searchApplyInfosByOid(Long oid);
	 
	 /**
	  * 根据流程id查询流程的第一个实例
	  * @param processDefId
	  * @return
	  */
	 ActivityDef selectByProcessDefId(Long processDefId);
	 
	 /**
	  * 添加流程实例
	  * @param processInst
	  * @return
	  */
	 int addProcessInst(ProcessInst processInst);
	 
	 /**
	  * 添加节点实例
	  * @param activityInst
	  * @return
	  */
	 int addActivityInst(ActivityInst activityInst);
	 
	 /**
	  * 添加节点对应的审批人
	  * @param particInst
	  * @return
	  */
	 int addParticInst(ParticInst particInst);
	 
	 /**
	  * 根据主键id修改呈批件信息
	  * @param applyInfos
	  * @return
	  */
	 int updateApplyInfosById(ApplyInfos applyInfos);
	 
	 /**
	  * 根据主键id修改第三方状态信息
	  * @param record
	  * @return
	  */
	 int updateCaseBillDetailByOid(CaseBillDetailImpl record);
	 
	 /**
	  * 分页查询审核呈批信息查询
	  * @param name
	  * @param user
	  * @param flag
	  * @param startIndex
	  * @param count
	  * @return
	  */
	 List<Map> getList(String sql,int startIndex,int count);
	 
	 String searchApplyInfosCommon(String name,String flag,User user);
	 /**
	  * 审核呈批信息的总条数
	  * @param name
	  * @param flag
	  * @return
	  */
	 int getCountList(String sql);
	 
	 /**
	  * 根据主键id查询账单信息
	  * @param billId
	  * @return
	  */
	 CaseBillImpl selectCaseBillByBillId(Long billId);
	 
	 /**
	  * 根据主键id查询案件信息
	  * @param caseId
	  * @return
	  */
	 CaseInfoImpl selectCaseInfoById(Long caseId);
	 
	 /**
	  * 根据呈批件id和用户id查询对应的未处理节点信息
	  * @param applyId
	  * @param userId
	  * @return
	  */
	 List<Map> getActivityInst(Long applyId,Long userId);
	 

	 /**
	  * 修改流程实例
	  * @param processInst
	  * @return
	  */
	 int updateProcessInst(ProcessInst processInst);
	 
	 /**
	  * 修改流程节点实例信息
	  * @param activityInst
	  * @return
	  */
	 int updateActivityInst(ActivityInst activityInst);
	 
	 /**
	  * 修改节点实例对应的参与者信息
	  * @param particInst
	  * @return
	  */
	 int updateParticInst(ParticInst particInst);
	 
	 /**
	  * 根据节点id和流程id查询下一个节点信息
	  * @param activityDefId
	  * @param processId
	  * @return
	  */
	 List<Map> getActivityDef(Long activityDefId,Long processId);
	 
	 /**
	  * 根据呈批件id和流程id查询查询审批信息
	  * @param applyId
	  * @return
	  */
	 List<Map> searchProcessAct(Long applyId);
	 
	 /**
	  * 添加或者修改呈批件信息
	  * @param applyInfos
	  * @param request
	  * @return
	  */
	 String addOrUpdApplyInfos(ApplyInfos applyInfos,HttpServletRequest request);
	 
	 /**
	  * 根据父节点id查询呈批件信息
	  * @param parentId
	  * @return
	  */
	 ApplyInfos selectByParentId(Long parentId);
	 
	 /**
	  * 根据流程实例id删除相关流程实例信息
	  * @param processInstId
	  */
	 void delAllProcess(Long processInstId);
	 
	 /**
	  * 发起呈批件流程
	  * @param applyInfos
	  * @return
	  */
	 boolean startProcess(ApplyInfos applyInfos,User user) throws ServiceException;
	 
	 /**
	  * 正常审批通过的流程处理
	  * @param applyInfos
	  * @param user
	  * @return
	  * @throws ServiceException
	  */
	 boolean passProcess(ApplyInfos applyInfos ,String auditDesc,Long userId) throws ServiceException;
	 
	 /**
	  * 拒绝审批通过
	  * @param applyInfos
	  * @param auditDesc
	  * @return
	  * @throws ServiceException
	  */
	 boolean refuseProcess(ApplyInfos applyInfos ,String auditDesc,Long userId) throws ServiceException;
	 
	 /**
	  * 根据主键id修改赔款登记信息
	  * @param record
	  * @return
	  */
     int updateByClaimId(CaseClaimImpl record);
     
     /**
	  * 根据角色id查询用户信息
	  * @param roleid
	  * @return
	  */
	 List<Map> searchUserByRoleId(Long roleId,String orgParam);
	 
	 String getApplyIdByBillParentId(String parentId,String applyType);
	 
	 /**
	  * 根据呈批件id和当前登录用户id查询节点参与者id
	  * @param applyId
	  * @param userId
	  * @return
	  */
	 String getParticIdByUserId(Long applyId,Long userId);
	 
	 /**
	  * 根据呈批件id查询节点实例id
	  * @param applyId
	  * @return
	  */
	 String getActivityIdByApplyId(Long applyId);
	 
	 /**
	  * 根据编号（Process_No）查询流程信息
	  * @param processNo
	  * @return
	  */
	 List<Map> getProcessDefByNo(String processNo);
	 
	 /**
	  * 根据条件查询节点实例参与者信息
	  * @param processInstId
	  * @param processDefId
	  * @param preActivityId
	  * @return
	  */
	 List<Map> searchParticInstByCondition(String processInstId,Long processDefId,String preActivityId);
	 
	 /**
	  * 根据条件修改节点实例参与者信息
	  * @param pi
	  */
	 void updateParticInstByCondition(ParticInst pi);
	 
	 /**
	  * 根据id删除呈批件信息
	  * @param applyId
	  */
	 void delApplyInfos(Long applyId);
	 
	 public String searchAdjustment(String name,String flag,User user);
	 
}
