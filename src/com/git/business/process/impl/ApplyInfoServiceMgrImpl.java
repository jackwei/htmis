package com.git.business.process.impl;


import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.PassureInfos.PassureInfos;
import com.git.business.Passurepayments.PassurePayMents;
import com.git.business.PassureInfos.PassureInfosServiceMgr;
import com.git.business.Passurepayments.PassurePayMentsServiceMgr;
import com.git.business.process.ActivityDef;
import com.git.business.process.ActivityInst;
import com.git.business.process.ApplyInfoServiceMgr;
import com.git.business.process.ApplyInfos;
import com.git.business.process.DocInfos;
import com.git.business.process.ParticInst;
import com.git.business.process.ParticipantDef;
import com.git.business.process.ProcessDefServiceMgr;
import com.git.business.process.ProcessInst;
import com.git.business.sys.Org;
import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ExchageRateImpl;
import com.git.db.beans.TblActivityDef;
import com.git.db.beans.TblActivityInst;
import com.git.db.beans.TblApplyInfos;
import com.git.db.beans.TblDocInfos;
import com.git.db.beans.TblDocInfosExample;
import com.git.db.beans.TblDocInfosExample.Criteria;
import com.git.db.beans.TblParticInst;
import com.git.db.beans.TblPassurePayMents;
import com.git.db.beans.TblProcessInst;
import com.git.db.mapper.CaseBillDetailImplMapper;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.db.mapper.CaseClaimImplMapper;
import com.git.db.mapper.CaseInfoImplMapper;
import com.git.db.mapper.ClaimIncomeImplMapper;
import com.git.db.mapper.TblActivityDefMapper;
import com.git.db.mapper.TblActivityInstMapper;
import com.git.db.mapper.TblApplyInfosMapper;
import com.git.db.mapper.TblDocInfosMapper;
import com.git.db.mapper.TblParticInstMapper;
import com.git.db.mapper.TblPassurePayMentsMapper;
import com.git.db.mapper.TblProcessInstMapper;
import com.git.enums.AssureStatus;
import com.git.enums.ClaimStatus;
import com.git.enums.InComeStatus;
import com.git.enums.PClientStatus;
import com.git.util.Jutil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * 呈批件信息接口的实现
 * @author shona
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service(ApplyInfoServiceMgrImpl.SERVICE_NAME)
public class ApplyInfoServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ApplyInfoServiceMgr {

	@Autowired
	private TblApplyInfosMapper applyInfosMapper;
	@Autowired
	private TblDocInfosMapper docInfosMapper;
	@Autowired
	private CaseBillDetailImplMapper caseBillDetailMapper;
	@Autowired
	private TblActivityDefMapper activityDefMapper;
	@Autowired
	private TblProcessInstMapper processInstMapper;
	@Autowired
	private TblActivityInstMapper activityInstMapper;
	@Autowired
	private TblParticInstMapper particInstMapper;
	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
	@Autowired
	private CaseInfoImplMapper caseInfoImplMapper;
	@Autowired
	private CaseClaimImplMapper caseClaimImplMapper;
	@Autowired
	private SequenceService sequenceService;
	@Autowired
	private ProcessDefServiceMgr processDefServiceMgr;
	
	@Autowired
	private ClaimIncomeImplMapper claimIncomeImplMapper;
	
	@Autowired
	private PassurePayMentsServiceMgr passurePayMentsServiceMgr;
	
	@Autowired
	private TblPassurePayMentsMapper passurepaymentsmapper;
	
	@Autowired
	private PassureInfosServiceMgr passureInfosServiceMgr;
	
	@Autowired
	private OrgServiceMgr orgMgr;
	
	 /**
	 * 添加呈批件信息
	 * @param applyInfos
	 * @return
	 */
	public int addApplyInfos(ApplyInfos applyInfos) {
        TblApplyInfos tblApplyInfos=applyInfos.getTblApplyInfos();
		return applyInfosMapper.insert(tblApplyInfos);
	}

	/**
	 * 添加呈批件附件信息
	 * @param docInfos
	 * @return
	 */
	public int addDocInfos(DocInfos docInfos) {
		TblDocInfos tblDocInfos=docInfos.getTblDocInfos();
		return docInfosMapper.insert(tblDocInfos);
	}
	 /**
	  * 根据第三方状态id查询第三方信息
	  * @param detailId
	  * @return
	  */
	public CaseBillDetailImpl selectByDetailId(Long detailId) {
		return caseBillDetailMapper.selectByPrimaryKey(detailId);
	}

	/**
	 * 判断呈批件是否是申请状态
	 * @param parentId
	 * @return
	 */
	 public List<TblApplyInfos> selectByCondition(Long parentId) {
		return applyInfosMapper.selectByCondition(parentId);
	}

	 /**
	  * 根据第三方id查询第三方状态信息
	  * @param consignorid
	  * @return
	  */
	public CaseBillDetailImpl selectByConsignorid(Long consignorid) {
		return caseBillDetailMapper.selectByConsignorid(consignorid);
	}

	 /**
	  * 根据呈批件id查询对应的附件信息
	  * @param applyid
	  * @return
	  */
	public List<DocInfos> selectByApplyId(Long applyid,String docType) {
		TblDocInfosExample example = new TblDocInfosExample();
		Criteria criteria = example.createCriteria();
		criteria.andApplyidEqualTo(applyid);
		criteria.andDoctypeEqualTo(docType);
		List<TblDocInfos> listDocInfos = docInfosMapper.selectByExample(example);
		List<DocInfos> list=new ArrayList<DocInfos>();
		
		/*List<TblDocInfos> listDocInfos=docInfosMapper.selectByApplyId(applyid,docType);*/
		for(TblDocInfos tbl:listDocInfos){
             list.add(new DocInfos(tbl));			
		}
		return list;
	}

	/**
	  * 根据id删除附件信息
	  * @param oid
	  * @return
	  */
	public int deleteByOid(Long oid) {
		return docInfosMapper.deleteByPrimaryKey(oid);
	}

	 /**
	  * 根据id获取第三方状态信息
	  * @param detailId
	  * @return
	  */
	public CaseBillDetailImpl searchCaseBillDetail(Long detailId) {
		return caseBillDetailMapper.selectByPrimaryKey(detailId);
	}

	 /**
	  * 根据主键id查询文档信息
	  * @param oid
	  * @return
	  */
	public DocInfos selectByOid(Long oid) {
	   TblDocInfos tblDocInfos=docInfosMapper.selectByPrimaryKey(oid);
		return new DocInfos(tblDocInfos);
	}

	 /**
	  * 根据主键id查询呈批件信息
	  * @param oid
	  * @return
	  */
	public ApplyInfos searchApplyInfosByOid(Long oid) {
		TblApplyInfos tblApplyInfos=applyInfosMapper.selectByPrimaryKey(oid);
		if(tblApplyInfos != null)
			return new ApplyInfos(tblApplyInfos);
		else
			return null;
	}

	/**
	  * 根据流程id查询流程的第一个实例
	  * @param processDefId
	  * @return
	  */
	public ActivityDef selectByProcessDefId(Long processDefId) {
		TblActivityDef tblActivityDef=activityDefMapper.selectByProcessDefId(processDefId);
		if(tblActivityDef != null)
			return new ActivityDef(tblActivityDef);
		else
			return null;
	}

	 /**
	  * 添加流程实例
	  * @param processInst
	  * @return
	  */
	public int addProcessInst(ProcessInst processInst) {
		TblProcessInst tblProcessInst=processInst.getTblProcessInst();
		return processInstMapper.insert(tblProcessInst);
	}

	/**
	  * 添加节点实例
	  * @param activityInst
	  * @return
	  */
	public int addActivityInst(ActivityInst activityInst) {
       TblActivityInst tblActivityInst=activityInst.getTblActivityInst();
		return activityInstMapper.insert(tblActivityInst);
	}

	 /**
	  * 添加节点对应的审批人
	  * @param particInst
	  * @return
	  */
	public int addParticInst(ParticInst particInst) {
		TblParticInst tblParticInst=particInst.getTblParticInst();
		return particInstMapper.insert(tblParticInst);
	}

	/**
	  * 根据主键id修改呈批件信息
	  * @param applyInfos
	  * @return
	  */
	public int updateApplyInfosById(ApplyInfos applyInfos) {
		TblApplyInfos tblApplyInfos=applyInfos.getTblApplyInfos();
		return applyInfosMapper.updateByPrimaryKeySelective(tblApplyInfos);
	}

	/**
	  * 根据主键id修改第三方状态信息
	  * @param record
	  * @return
	  */
	public int updateCaseBillDetailByOid(CaseBillDetailImpl record) {
		return caseBillDetailMapper.updateByPrimaryKeySelective(record);
	}

	 /**
	  * 分页查询审核呈批信息查询
	  * @param name
	  * @param user
	  * @param flag
	  * @param startIndex
	  * @param count
	  * @return
	  */
	public List<Map> getList(String sql,int startIndex,int count) {
		List<Map> list=list=Jutil.executeSQL(sql, startIndex, count);
		return list;
	}
	
	/**
	  * 审核呈批信息的总条数
	  * @param name
	  * @param flag
	  * @return
	  */
	public int getCountList(String sql) {
		int count=0;
		List<Map> list=list=Jutil.executeSQL(sql);
		if(list!=null && list.size()!=0){
			count=list.size();
		}
		return count;
	}
	
	/**
	 * 分页查询数据的公共部分
	 * @param name
	 * @param flag
	 * @param user
	 * @return
	 */
	public String searchApplyInfosCommon(String name,String flag,User user){
		StringBuffer tSqlBuffer = new StringBuffer(32);
		String partSql="";
		String exSql2="";
		if(name!=null && !"".equals(name)){
			partSql=" and (lower(a.name) like lower('%"+name+"%') or lower(a.sqnumber) like lower('%"+name+"%') ) ";
		}
		
		if("apply".equals(flag)){
			// WHEN  a.step=-1 THEN (SELECT Activity_Name FROM tbl_activity_def WHERE Activity_Def_Id=a.remarkb AND Process_Def_Id=a.processDefId)
			tSqlBuffer.append("SELECT a.oid,a.sqnumber sqnumber,(CASE a.remarkb WHEN 0 THEN '' ELSE (SELECT Activity_Name FROM tbl_activity_def WHERE activity_def_id=a.remarkb AND Process_Def_Id=a.processDefId) END )activityName,a.name name,IFNULL(a.applydate,'') applyDate,");
			tSqlBuffer.append("a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status ");
			tSqlBuffer.append("FROM tbl_applyinfos a,sys_dict_entry e ,sys_dict_entry f WHERE a.applytype=e.DictId AND e.DictTypeId='apply_type' AND  a.status=f.DictId  AND f.DictTypeId='apply_state' ");
			tSqlBuffer.append("and  a.userid=");
			tSqlBuffer.append(user.getId());
			if(!"".equals(partSql))
	    	{
	    		tSqlBuffer.append(partSql);
	    	}
	    	tSqlBuffer.append(" order by a.applydate desc");
		}
	    else if ("audit".equals(flag)){
	    	tSqlBuffer.append("SELECT a.oid,a.sqnumber sqnumber,d.Activity_Name activityName,a.name name,IFNULL(a.applydate,'') applyDate,");
	    	tSqlBuffer.append("a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status ");
	    	tSqlBuffer.append("FROM tbl_applyinfos a JOIN tbl_activity_inst b ON a.remarkc = CONCAT(b.process_inst_id,'') ");
	    	tSqlBuffer.append("JOIN tbl_partic_inst c ON c.Activity_inst_Id= b.Activity_inst_Id JOIN tbl_activity_def d ON b.Activity_Def_Id=d.Activity_Def_Id ");
	    	tSqlBuffer.append("left join sys_dict_entry e on a.applytype=e.DictId and e.DictTypeId='apply_type' left JOIN sys_dict_entry f ON a.status=f.DictId  and f.DictTypeId='apply_state'");
	    	tSqlBuffer.append("WHERE  a.status='process' AND b.Current_State IN ('1','3') AND c.Excute_State IN ('1','3') ");
	    	tSqlBuffer.append("AND c.Partic_User_Id=");
	    	tSqlBuffer.append(user.getId());
	    	if(!"".equals(partSql))
	    	{
	    		tSqlBuffer.append(partSql);
	    	}
	    	tSqlBuffer.append(" order by a.applydate desc");
	    	
		}else if ("audited".equals(flag)){

			//查询当前用户所有呈批件
			/*tSqlBuffer.append("SELECT a.oid,a.sqnumber sqnumber,d.Activity_Name activityName,a.name name,IFNULL(a.applydate,'') applyDate,");
	    	tSqlBuffer.append("a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status ");
	    	tSqlBuffer.append("FROM tbl_applyinfos a JOIN tbl_activity_inst b ON a.remarkc = CONCAT(b.process_inst_id,'') ");
	    	tSqlBuffer.append("left JOIN tbl_partic_inst c ON c.Activity_inst_Id= b.Activity_inst_Id JOIN tbl_activity_def d ON b.Activity_Def_Id=d.Activity_Def_Id ");
	    	tSqlBuffer.append("left join sys_dict_entry e on a.applytype=e.DictId and e.DictTypeId='apply_type' left JOIN sys_dict_entry f ON a.status=f.DictId  and f.DictTypeId='apply_state'");
	    	tSqlBuffer.append("WHERE  b.Current_State='2' AND c.Excute_State='2' ");
	    	tSqlBuffer.append("AND c.Partic_User_Id=");*/
	    	
	    	tSqlBuffer.append("select DISTINCT(a.oid),a.sqnumber sqnumber,");
	    	tSqlBuffer.append("(case a.remarkb when 0 then '' else (select Activity_Name from tbl_activity_def where activity_def_id=a.remarkb and Process_Def_Id=a.processDefId) end )activityName,");
	    	tSqlBuffer.append(" a.name name,IFNULL(a.applydate,'') applyDate,");
	    	tSqlBuffer.append(" a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status");
	    	tSqlBuffer.append(" from tbl_applyinfos a,sys_dict_entry e ,sys_dict_entry f , tbl_partic_inst c,tbl_activity_inst b");
	    	tSqlBuffer.append(" where a.applytype=e.DictId and e.DictTypeId='apply_type' and  a.status=f.DictId  and f.DictTypeId='apply_state' ");
	    	tSqlBuffer.append("and  a.remarkc = CONCAT(b.process_inst_id,'') and c.Activity_inst_Id= b.Activity_inst_Id  and c.`Partic_User_Id`=");
	    	tSqlBuffer.append(user.getId());
	    	
			if(!"".equals(partSql))
	    	{
	    		tSqlBuffer.append(partSql);
	    	}
	    	tSqlBuffer.append(" order by a.applydate desc");
		}else if("all".equals(flag)){
			/*tSqlBuffer.append("select DISTINCT(a.oid),a.sqnumber sqnumber,");
	    	tSqlBuffer.append("(case a.remarkb when 0 then '' else (select Activity_Name from tbl_activity_def where activity_def_id=a.remarkb and Process_Def_Id=a.processDefId) end )activityName,");
	    	tSqlBuffer.append(" a.name name,IFNULL(a.applydate,'') applyDate,");
	    	tSqlBuffer.append(" a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status");
	    	tSqlBuffer.append(" from tbl_applyinfos a,sys_dict_entry e ,sys_dict_entry f , tbl_partic_inst c,tbl_activity_inst b");
	    	tSqlBuffer.append(" where a.applytype=e.DictId and e.DictTypeId='apply_type' and  a.status=f.DictId  and f.DictTypeId='apply_state' ");
	    	tSqlBuffer.append("and  a.remarkc = CONCAT(b.process_inst_id,'') and c.Activity_inst_Id= b.Activity_inst_Id")*/
	    	
	    	tSqlBuffer.append("select DISTINCT(a.oid),a.sqnumber sqnumber,");
	    	tSqlBuffer.append("(case a.remarkb when 0 then '' else (select Activity_Name from tbl_activity_def where activity_def_id=a.remarkb and Process_Def_Id=a.processDefId) end )activityName,");
	    	tSqlBuffer.append(" a.name name,IFNULL(a.applydate,'') applyDate,");
	    	tSqlBuffer.append(" a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status");
	    	tSqlBuffer.append(" from tbl_applyinfos a,sys_dict_entry e ,sys_dict_entry f");
	    	tSqlBuffer.append(" where a.applytype=e.DictId and e.DictTypeId='apply_type' and  a.status=f.DictId  and f.DictTypeId='apply_state' ");
	    	
			if(!"".equals(partSql))
	    	{
	    		tSqlBuffer.append(partSql);
	    	}
	    	tSqlBuffer.append(" order by a.applydate desc");
		}
		
		return tSqlBuffer.toString();
	}
	
	/**
	 * 查询流程调整呈批件
	 * 
	 * */
	public String searchAdjustment(String name,String flag,User user){
		StringBuffer tSqlBuffer = new StringBuffer(32);
		String partSql="";
		if(name!=null && !"".equals(name)){
			partSql=" and (lower(a.name) like lower('%"+name+"%') or lower(a.sqnumber) like lower('%"+name+"%') ) ";
		}
		
    	tSqlBuffer.append("SELECT a.oid,a.sqnumber sqnumber,d.Activity_Name activityName,a.name name,IFNULL(a.applydate,'') applyDate,");
    	tSqlBuffer.append("a.username userName,a.orgname orgName,IFNULL(a.remarkc,'') processInstId,e.DictName applytype,f.DictName applystatus,a.status ");
    	tSqlBuffer.append("FROM tbl_applyinfos a JOIN tbl_activity_inst b ON a.remarkc = CONCAT(b.process_inst_id,'') ");
    	tSqlBuffer.append("left JOIN tbl_partic_inst c ON c.Activity_inst_Id= b.Activity_inst_Id JOIN tbl_activity_def d ON b.Activity_Def_Id=d.Activity_Def_Id ");
    	tSqlBuffer.append("left join sys_dict_entry e on a.applytype=e.DictId and e.DictTypeId='apply_type' left JOIN sys_dict_entry f ON a.status=f.DictId  and f.DictTypeId='apply_state'");
    	tSqlBuffer.append("WHERE  a.status='process' AND b.Current_State IN ('1','3') AND c.Excute_State IN ('1','3') ");
    	
    	if(!"".equals(partSql))
    	{
    		tSqlBuffer.append(partSql);
    	}
    	tSqlBuffer.append(" order by a.applydate desc");
	    	
		return tSqlBuffer.toString();
	}
	
	

	 /**
	  * 根据主键id查询账单信息
	  * @param billId
	  * @return
	  */
	public CaseBillImpl selectCaseBillByBillId(Long billId) {
		return caseBillImplMapper.selectByPrimaryKey(billId);
	}

	 /**
	  * 根据主键id查询案件信息
	  * @param caseId
	  * @return
	  */
	public CaseInfoImpl selectCaseInfoById(Long caseId) {
		return caseInfoImplMapper.selectByPrimaryKey(caseId);
	}

	 /**
	  * 根据呈批件id和流程id查询对应的未处理节点信息
	  * @param applyId
	  * @param userId
	  * @return
	  */
	public List<Map> getActivityInst(Long applyId, Long userId) {
		
		StringBuffer tSql = new StringBuffer(16);
		
		tSql.append("SELECT pi.process_inst_id,ai.Current_State,ai.activity_inst_id,pt.partic_inst_id,IFNULL(pi.param1,0) param1,IFNULL(pi.param2,'') param2,IFNULL(pi.param3,'') param3 ");
		tSql.append(" FROM tbl_process_inst PI,tbl_activity_inst ai,tbl_partic_inst pt,tbl_applyinfos a ");
		tSql.append(" WHERE pi.process_inst_id=ai.process_inst_id and a.remarkc = CONCAT(pi.process_inst_id,'') AND ai.activity_inst_id=pt.activity_inst_id AND ai.Current_State='3'");
		tSql.append(" AND pt.Partic_User_Id=");
		tSql.append(userId);
		tSql.append(" AND a.oid=");
		tSql.append(applyId);
		
		List<Map> list=list=Jutil.executeSQL(tSql.toString());
		return list;
	}

	/**
	  * 修改流程实例
	  * @param processInst
	  * @return
	  */
	public int updateProcessInst(ProcessInst processInst) {
		TblProcessInst tblProcessInst=processInst.getTblProcessInst();
		return processInstMapper.updateByPrimaryKeySelective(tblProcessInst);
	}

	 /**
	  * 修改流程节点实例信息
	  * @param activityInst
	  * @return
	  */
	public int updateActivityInst(ActivityInst activityInst) {
		TblActivityInst tblActivityInst=activityInst.getTblActivityInst();
		return activityInstMapper.updateByPrimaryKeySelective(tblActivityInst);
	}

	/**
	  * 修改节点实例对应的参与者信息
	  * @param particInst
	  * @return
	 */
	public int updateParticInst(ParticInst particInst) {
		TblParticInst tblParticInst=particInst.getTblParticInst();
		return particInstMapper.updateByPrimaryKeySelective(tblParticInst);
	}

	/**
	  * 根据节点id和流程id查询下一个节点信息
	  * @param activityDefId
	  * @param processId
	  * @return
	  */
	public List<Map> getActivityDef(Long activityDefId, Long processId) {
		String sql="SELECT * FROM tbl_activity_def WHERE Process_Def_Id='"+processId+"' AND Pre_Activity ='"+activityDefId+"'";
		List<Map> list=list=Jutil.executeSQL(sql.toString());
		return list;
	}

	/**
	  * 根据节点id和流程id查询审批信息
	  * @param applyId(AND ai.`Current_State`='2')
	  * @return
	  */
	public List<Map> searchProcessAct(Long applyId) {
		String sql="SELECT pc.Process_Inst_ID, ai.`Activity_Inst_ID`,ai.checkdes,ai.checkdate,pt.Partic_User_Value,ai.Aduit_Result " +
				" FROM tbl_process_inst pc,tbl_activity_inst ai,tbl_partic_inst pt,tbl_applyinfos ap "+
				"WHERE pc.`Process_Inst_ID`=ai.`Process_Inst_ID` AND ai.`Activity_Inst_ID`=pt.`Activity_Inst_ID` " +
				" AND pc.`Process_Inst_ID`=pt.`Process_Inst_ID`   AND pt.Excute_State NOT IN ('4') AND  ap.remarkc=pc.`Process_Inst_ID` AND ap.oid='"+applyId+"'";
		List<Map> list=list=Jutil.executeSQL(sql.toString());
		return list;
	}

	 /**
	  * 添加或者修改呈批件信息
	  * @param applyInfos
	  * @param request
	  * @return
	  */
	public String addOrUpdApplyInfos(ApplyInfos applyInfos,HttpServletRequest request) {
		    HttpSession session = request.getSession();
			User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
			
     		long applyId=0;
									
			String applynumber = applyInfos.getSqnumber();
			if(applynumber == null || "".equals(applynumber))
			{
				//创建呈批件编号生成规则
				SimpleDateFormat sd = new SimpleDateFormat("yy");
				Date date = new Date();
				String yearstr = sd.format(date);
				applynumber = sequenceService.getSequence("applynumber", "HTRC", yearstr, "", 6, '0', 'L');
			}
			//添加
//		   if(applyId == 0)
//		   {
			   if("thirdparty".equals(applyInfos.getApplytype()))
			   {
				   CaseBillDetailImpl caseBillDetail=selectByDetailId(applyInfos.getParentid());
				   if(PClientStatus.ClientFee0.getCode().equals(caseBillDetail.getStatus()) ){//账单未到账
					   return "账单未到账，暂不能进行划付申请操作！"+","+applynumber+","+applyId+",false";
				   }
				   else if(PClientStatus.ClientFee5.getCode().equals(caseBillDetail.getStatus())||
							PClientStatus.ClientFee6.getCode().equals(caseBillDetail.getStatus())){//已支付
						return "此账单已划付完成，不允许此操作！"+","+applynumber+","+applyId+",false";
				   }
				   else if(PClientStatus.ClientFee3.getCode().equals(caseBillDetail.getStatus())){//正在审批中
						return "划付申请正在处理中，请到【我的呈批件】查看审批结果。"+","+applynumber+","+applyId+",false";
				   }
				   applyInfos.setAmounta(BigDecimal.valueOf(caseBillDetail.getAccamount()==null?0:caseBillDetail.getAccamount()));
				   applyInfos.setCurrency(caseBillDetail.getCurrency());
				   
				   applyInfos.setOrgid(Jutil.getOrgCodeByBillDetail(caseBillDetail.getDetailId()));
				   Org org = orgMgr.getOrg(Long.valueOf(Jutil.getOrgCodeByBillDetail(caseBillDetail.getDetailId())));
				   applyInfos.setOrgname(org.getOrgName());
			   }
			   else if("caseClaim".equals(applyInfos.getApplytype()))
			   {
				   //applyInfos.setAmounta(BigDecimal.valueOf(caseBillDetail.getFeeamount()==null?0:caseBillDetail.getFeeamount()));
				   //applyInfos.setCurrency(caseBillDetail.getCurrency());
				   
				   applyInfos.setOrgid(Jutil.getOrgCodeByCaseId(applyInfos.getParentid()));
				   Org org = orgMgr.getOrg(Long.valueOf(Jutil.getOrgCodeByCaseId(applyInfos.getParentid())));
				   applyInfos.setOrgname(org.getOrgName());
			   }else if("assure".equals(applyInfos.getApplytype())){
				   applyInfos.setOrgid(user.getOrgId().toString());
				   Org org = orgMgr.getOrg(user.getOrgId());
				   applyInfos.setOrgname(org.getOrgName());
			   }
			   
			   applyInfos.setDeleted("0");
			   applyInfos.setUserid(user.getId().toString());
			   applyInfos.setUsername(user.getName());
			   applyInfos.setStep(0);
			   applyInfos.setRemarkb("0");
			   applyInfos.setSqnumber(applynumber);
			   applyInfos.setCreatdate(new Date());
			   addApplyInfos(applyInfos);
			   applyId=Integer.valueOf(applyInfos.getId().toString());
			   
	     /*}else
		   {//修改
			   
			   String status=applyInfos.getStatus();
			   if("finish".equals(status)){
					return "划付申请已审批处理完毕，不能再次提交。"+","+applynumber+","+applyId+",false";
			   }
			   
			   updateApplyInfosById(applyInfos);
			}*/
		 return "保存成功！"+","+applynumber+","+applyId+",true";
	}

	 /**
	  * 根据父节点id查询呈批件信息
	  * @param parentId
	  * @return
	  */
	public ApplyInfos selectByParentId(Long parentId) {
		String  applyId = getApplyIdByBillParentId(parentId.toString(),"caseClaim");
		TblApplyInfos tblApplyInfos=applyInfosMapper.selectByPrimaryKey(Long.valueOf(applyId));
		return new ApplyInfos(tblApplyInfos);
	}

	 /**
	  * 发起呈批件流程
	  * @param applyInfos
	  * @return
	 */
	public boolean startProcess(ApplyInfos applyInfos,User user) throws ServiceException{
		boolean result= false;
		ActivityDef activityDef=selectByProcessDefId(Long.valueOf(applyInfos.getProcessdefid()));
	    if(activityDef!=null && activityDef.getId() > 0)
	    {	    	
	    	applyInfos.setStep(Integer.valueOf(activityDef.getId().toString()));
	    	applyInfos.setRemarkb(activityDef.getId().toString());
	    	applyInfos.setApplydate(new Date());
	    	
	    	applyInfos.setStatus("process");
			
	    	ProcessInst processInst=new ProcessInst();
	    	
	    	Long processInstId = sequenceService.getSequence("process_inst_id");
	    	applyInfos.setRemarkc(processInstId+"");//将业务流程示例ID存储到呈批件信息表中,便于后续的查找
	    	
	    	processInst.setId(processInstId);
	    	processInst.setProcessDefId(applyInfos.getProcessdefid());
	    	processInst.setProcessinstname(applyInfos.getProcessname());
	    	processInst.setCreator(user.getUserCode());
	    	processInst.setCreateTime(new Date());
	    	processInst.setBussNo(applyInfos.getId().toString());//工作流中的业务号码存储审批流程号码
	    	
	    	processInst.setParam1(Float.valueOf(applyInfos.getAmounta()+""));//将呈批件的审批金额信息保存到param1中，便于后续的程序进行流程判断处理
	    	processInst.setParam3(applyInfos.getCurrency());
	    	processInst.setParam2(applyInfos.getOrgid());//将呈批件所属机构存储到param2中,便于查询参与者,实际上取的orgCode
	    	
	    	//1.运行2.完成3.终止
	    	processInst.setCurrentState("1");
	    	
	    	addProcessInst(processInst);//新增流程信息
	    	
	    	ActivityInst activityInst=new ActivityInst();
	    	
	    	//Long activityInstId = sequenceService.getSequence("activity_inst_id");
	    	
	    	//activityInst.setId(activityInstId);
	    	activityInst.setProcessInstId(processInst.getId());
	    	activityInst.setActivityDefId(activityDef.getId());
	    	//1.待处理 ;2.已处理;3.处理中
	    	activityInst.setCurrentState("1");
	    	activityInst.setCreateTime(new Date());
	    	addActivityInst(activityInst);
	    	ParticipantDef participant=new ParticipantDef();
			participant.setActivityiId(activityDef.getId());
			participant.setProcessId(applyInfos.getProcessdefid());
	    	List<ParticipantDef> participantDefList=processDefServiceMgr.selectByActivityDefId(participant);
	    	String orgParam = "";
	    	
	    	if(activityDef.getParam2() != null && "2".equals(activityDef.getParam2()))//如果是分支机构层级的角色参与处理,则需要将呈批件所属的机构参数带入,只查询该机构下满足此参与者条件的角色
	    	{
	    		orgParam = processInst.getParam2();
	    	}
	    	boolean exsitPartic = false;
	    	if(participantDefList!=null && participantDefList.size()!=0)
	    	{
	    		for(int i=0;i<participantDefList.size();i++)
	    		{
		    		 ParticipantDef participantDef=participantDefList.get(i);
		    		 ParticInst particInst;
		    		 if("2".equals(participantDef.getType()))//如果参与者是用户，则直接将用户信息放入实例表中
					 {
		    			 particInst=new ParticInst();
				    	 particInst.setActivityInstId(activityInst.getId());
				    	 particInst.setProcessInstId(processInst.getId());
				    	 particInst.setParticUserId(participantDef.getParticValueId());
				    	 particInst.setParticUserValue(participantDef.getParticValue());
				    	 particInst.setPartiinType(participantDef.getType());
				    	 //1.待处理 2.已处理;3.处理中
				    	 particInst.setExcuteState("1");
				    	 addParticInst(particInst);
				    	 
				    	 exsitPartic = true;
					 }
		    		 else if("1".equals(participantDef.getType()))//如果参与者是角色，则需要根据角色ID查询当前的用户信息
		    		 {
		    			 List<Map> userList = searchUserByRoleId(participantDef.getParticValueId(),orgParam);
		    			 if(userList!=null && userList.size()!=0){
					    	 for(int k=0;k<userList.size();k++){
					    		 Map p=(Map)userList.get(k);
					    		 
					    		 particInst=new ParticInst();
						    	 particInst.setActivityInstId(activityInst.getId());
						    	 particInst.setProcessInstId(processInst.getId());
						    	 particInst.setParticUserId(Long.valueOf(p.get("userId").toString()));
						    	 particInst.setParticUserValue(p.get("name").toString());
						    	 particInst.setPartiinType(participantDef.getType());
						    	 //1.待处理 2.已处理;3.处理中
						    	 particInst.setExcuteState("1");
						    	 addParticInst(particInst);	
						    	 exsitPartic = true;
					    	 }
					    }
		    		 }    		 
	    		}
	    	}
	    	
	    	if(!exsitPartic)
	    	{
	    		throw new ServiceException("未找到下一流程节点的参与者，请联系系统管理员协助解决！");	    		
	    	}
	    	
	    	updateApplyInfosById(applyInfos);
	    	result= true;
	    }
	    else
	    {
	    	throw new ServiceException("未找到该呈批件对应的审批处理流程，请先确认是否已保存审批流程，或者联系系统管理员协助解决！");	    	
	    }
		return result;
	}
	
	/**
	 * 正常审批通过的流程处理
	 * @param applyInfos
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean passProcess(ApplyInfos applyInfos ,String auditDesc,Long userId) throws ServiceException{
		boolean result= false;		
		
		List<Map> activityInstList=this.getActivityInst(applyInfos.getId(), userId);
		
		boolean endFlag = false;
		boolean startNextFlag= false;
		ApplyInfos uptApplyInfos=null;
		
		if(activityInstList!=null && activityInstList.size()>0)
		{
			Map currentActivity=activityInstList.get(0);
			
			String activityState = String.valueOf(currentActivity.get("Current_State"));
			if("2".equals(activityState))
			{
				throw new ServiceException("该流程已审批过，请不要重复审批！");	 
			}
			
			ActivityInst activityInst=new ActivityInst();
			activityInst.setCheckdes(auditDesc);
			activityInst.setCheckdate(new Date());
			activityInst.setFinalTime(new Date());
			activityInst.setAduitResult("1");//审核结论，1：通过；0：拒绝
			activityInst.setCurrentState("2");
			activityInst.setId(Long.valueOf(currentActivity.get("activity_inst_id").toString()));
			
			ParticInst oldParticInst=new ParticInst();
			oldParticInst.setExcuteState("2");
			oldParticInst.setId(Long.valueOf(currentActivity.get("partic_inst_id").toString()));
						
			//获取下一个节点
			Map pDef=this.getNextActivityDef(Long.valueOf(applyInfos.getStep()), applyInfos.getProcessdefid(), 
						Double.valueOf(currentActivity.get("param1").toString()),String.valueOf(currentActivity.get("param3")));
			Long processInstId = Long.valueOf(applyInfos.getRemarkc());
						
			if(pDef != null)//如果是需要金额判断才能继续的话，就需要获取全局的金额参数和定义中的param1进行比较了。
			{
				startNextFlag = true;
			}
							
			boolean exsitPartic = false;
			
			if(startNextFlag)//需要启动下一节点
			{
		    	ActivityInst ai=new ActivityInst();
		    	ai.setProcessInstId(processInstId);
		    	ai.setActivityDefId(Long.valueOf(pDef.get("Activity_Def_Id").toString()));
		    	//ai.setId(sequenceService.getSequence("activity_inst_id"));
		    	//1.待处理 2.已处理
		    	ai.setCurrentState("1");
		    	ai.setCreateTime(new Date());
		    	
		    	this.addActivityInst(ai);
		    	
		    	String orgParam =""; 
		    	String defParticType = String.valueOf(pDef.get("Param2"));//该呈批件定义的参与者层级，1：总公司；2：分支机构，如果是分支机构，则在查询角色时需要增加机构代码的条件
		    	
		    	if(defParticType != null && "2".equals(defParticType))//如果是分支机构层级的角色参与处理,则需要将呈批件所属的机构参数带入,只查询该机构下满足此参与者条件的角色
		    	{
		    		orgParam = String.valueOf(currentActivity.get("param2"));//该案件归属的机构代码
		    	}
		    	
		    	ParticipantDef participantQuery=new ParticipantDef();
		    	participantQuery.setActivityiId(Long.valueOf(pDef.get("Activity_Def_Id").toString()));
		    	participantQuery.setProcessId(Long.valueOf(applyInfos.getProcessdefid()));
		    	List<ParticipantDef> participantDefList=processDefServiceMgr.selectByActivityDefId(participantQuery);
		    	if(participantDefList!=null && participantDefList.size()!=0)
		    	{
		    		ParticInst particInst;
		    		for(int i=0;i<participantDefList.size();i++)
		    		{
			    	 	
			    	 	ParticipantDef participantDef=participantDefList.get(i);
			    		
			    		 if("2".equals(participantDef.getType()))//如果参与者是用户，则直接将用户信息放入实例表中
						 {
			    			 particInst=new ParticInst();
					    	 particInst.setActivityInstId(ai.getId());
					    	 particInst.setProcessInstId(processInstId);
					    	 particInst.setParticUserId(participantDef.getParticValueId());
					    	 particInst.setParticUserValue(participantDef.getParticValue());
					    	 particInst.setPartiinType(participantDef.getType());
					    	 //1.待处理 2.已处理;3.处理中
					    	 particInst.setExcuteState("1");
					    	 this.addParticInst(particInst);
					    	 
					    	 exsitPartic = true;
						 }
			    		 else if("1".equals(participantDef.getType()))//如果参与者是角色，则需要根据角色ID查询当前的用户信息
			    		 {
			    			 List<Map> userList = this.searchUserByRoleId(participantDef.getParticValueId(),orgParam);
			    			 if(userList!=null && userList.size()!=0){
						    	 for(int k=0;k<userList.size();k++){
						    		 Map p1=(Map)userList.get(k);
						    		 
						    		 particInst=new ParticInst();
							    	 particInst.setActivityInstId(ai.getId());
							    	 particInst.setProcessInstId(processInstId);
							    	 particInst.setParticUserId(Long.valueOf(p1.get("userId").toString()));
							    	 particInst.setParticUserValue(p1.get("name").toString());
							    	 particInst.setPartiinType(participantDef.getType());
							    	 //1.待处理 2.已处理;3.处理中
							    	 particInst.setExcuteState("1");
							    	 this.addParticInst(particInst);	
							    	 exsitPartic = true;
						    	 }
						    }
			    		 } 
		    		}
		    	}
		    	
		    	uptApplyInfos = new ApplyInfos();
		    	uptApplyInfos.setStep(Integer.valueOf(pDef.get("Activity_Def_Id").toString()));
		    	uptApplyInfos.setRemarkb(pDef.get("Activity_Def_Id").toString());
		    	uptApplyInfos.setId(applyInfos.getId());
		    	if(!exsitPartic)
		    	{
		    		throw new ServiceException("未找到下一流程节点的参与者，请联系系统管理员协助解决！");	    		
		    	}
			}
			else
			{
				endFlag = true;
			}
			
			if(endFlag)
			{
				uptApplyInfos = new ApplyInfos();
				uptApplyInfos.setStatus("finish");
				uptApplyInfos.setStep(-1);
				uptApplyInfos.setId(applyInfos.getId());
				
				ProcessInst processInst=new ProcessInst();
				processInst.setCurrentState("2");
				processInst.setFinalTime(new Date());
				processInst.setId(Long.valueOf(currentActivity.get("process_inst_id").toString()));
				this.updateProcessInst(processInst);
				
				if(applyInfos.getApplytype()!= null && "thirdparty".equals(applyInfos.getApplytype()))//第三方支付的呈批件处理
				{
					CaseBillDetailImpl record = new CaseBillDetailImpl();
					record.setDetailId(applyInfos.getParentid());
					record.setStatus(PClientStatus.ClientFee4.getCode());
					
					this.updateCaseBillDetailByOid(record);
				}
				else if(applyInfos.getApplytype()!=null && "caseClaim".equals(applyInfos.getApplytype()))//如果claimId不为空，则表明是赔款呈批件的处理
				{
					CaseClaimImpl caseClaimImpl=caseClaimImplMapper.selectByPrimaryKey(Long.valueOf(applyInfos.getParentid()));
					if(caseClaimImpl.getRecordtype().equals("D")){
						ClaimIncomeImpl claimIncomeImpl=new ClaimIncomeImpl();
						claimIncomeImpl.setIncomeId(Long.valueOf(caseClaimImpl.getRemark1()));
						claimIncomeImpl.setStatus(InComeStatus.ClaimFee2.getCode());
						claimIncomeImplMapper.updateByPrimaryKeySelective(claimIncomeImpl);
						
						CaseClaimImpl caseClaim=new CaseClaimImpl();
						caseClaim.setStatus(ClaimStatus.ClaimFee2.getCode());
						caseClaim.setClaimId(Long.valueOf(applyInfos.getParentid()));
						this.updateByClaimId(caseClaim);
						
					}else{
						CaseClaimImpl caseClaim=new CaseClaimImpl();
						caseClaim.setStatus(ClaimStatus.ClaimFee2.getCode());
						caseClaim.setClaimId(Long.valueOf(applyInfos.getParentid()));
						this.updateByClaimId(caseClaim);
					}
				}else if(applyInfos.getApplytype()!=null && "assure".equals(applyInfos.getApplytype())){
					PassureInfos tp = null;
				    TblPassurePayMents tppm = passurePayMentsServiceMgr.selectpassurepayments(applyInfos.getParentid());
//				    PassurePayMents ppm = passurePayMentsServiceMgr.getPassurePayMents(applyInfos.getParentid());
				    //修改PassurePayMents状态为已提交submit
				    tppm.setReportflag("pass");
				    passurePayMentsServiceMgr.updpayment(tppm);
				    Map<Object, Object> criterias = new HashMap<Object, Object>();
				    criterias.put("paymentid", tppm.getPassurepayid());
				    BaseConditionVO vo = new BaseConditionVO();
					List<PassureInfos> plist = passureInfosServiceMgr.searchAllPassureInfos(vo, criterias);
					for(int i=0;i<plist.size();i++){
						Long billid = plist.get(i).getPassureid();
						tp = passureInfosServiceMgr.getPassureInfos(billid);
						//修改对应申请呈批担保状态为5
						tp.setFeestatuse(AssureStatus.AssureStatus5.getCode());
						passureInfosServiceMgr.update(tp);
					}
				}
			}
			
			this.updateActivityInst(activityInst);//更新当前节点状态
			this.updateParticInst(oldParticInst);//更新当前参与者状态 
			this.updateApplyInfosById(uptApplyInfos);

			result = true;
		}else{
			throw new ServiceException("当前流程已终止，请联系管理员协助解决！");	  
		}
		
		return result;
	}
	
	/**
	 * 根据流程定义ID和当前任务节点定义ID
	 * @param currentActivityDefId
	 * @param processDefId
	 * @param currentMoney 实际该呈批件中审批金额
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private Map getNextActivityDef(Long currentActivityDefId, Long processDefId,Double currentMoney,String currency)
	{
		//1、根据当前节点ID查找下一节点
		List<Map> list=this.getActivityDef(currentActivityDefId, processDefId);
		if(list!=null && list.size()!=0)
		{
			Map pDef=list.get(0);
			pDef.put("nextFlag", "0");//初始默认是不触发的
			String tStartType =String.valueOf(pDef.get("Start_Type"));//获取启动方式
			
			if("2".equals(tStartType))//如果是需要金额判断才能继续的话，就需要获取全局的金额参数和定义中的param1进行比较了。
			{
				String defMoney = String.valueOf(pDef.get("Param1"));//流程中定义的金额下限
				//Double currentMoney = 0.0;
				if(!currency.equals("RMB")){
					ExchageRateImpl exchageRateImpl = sequenceService.getRateByCurrency(currency);
					if(exchageRateImpl != null){
						currentMoney = Double.valueOf(currentMoney)*Double.valueOf(exchageRateImpl.getRate1());
					}
				}
				
				if(currentMoney > Double.parseDouble(defMoney))//如果实际审批金额大于了定义的金额下限，则需要触发流程
				{
					pDef.put("nextFlag", "1");
					return pDef;
				}
				else//否则，还要根据流程阶段配置信息继续循环判断下一节点，循环终止的条件为：后续有节点是需要直接触发的，或者知道流程结束也没有直接触发的；
				{
					//调用循环处理
					while(true)
					{
						pDef = this.getNextActivityDef(Long.valueOf(pDef.get("Activity_Def_Id").toString()), processDefId,currentMoney,currency);
						/*解释：1、如果返回的pDef==null，则表明下一节点为空，表示不存在下一节点，可以结束流程，因此直接退出，返回null
						 * 2、如果返回的pDef ！=null，此时也要做判断，如果返回的下一节点触发类型是直接触发（Start_Type代码=1），此时也需要跳出循环，直接返回pDef，交由主程序做下一步处理
						 * 3、当返回的下一节点触发类型是需要金额判断（Start_Type代码=2）时，此时需要用到另外一个标记“nextFlag”，如果nextFlag=1，则也需要跳出循环。
						 * 4、只有当返回的下一节点触发类型是需要金额判断（Start_Type代码=2）时，需要再次调用当前方法查询下一节点，直到跳出循环为止。
						*/
						if(pDef==null || "1".equals(String.valueOf(pDef.get("Start_Type")))
								|| "1".equals(String.valueOf(pDef.get("nextFlag"))))
						{
							break;
						}
					}
					
					return pDef;
				}
			}
			else//如果是直接触发，则也需要启动下一节点
			{
				return pDef;
			}
		}
		else
		{
			return null;
		}
	}
	
	/**
	 * 拒绝退回的审批流程处理
	 * @param applyInfos
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public boolean refuseProcess(ApplyInfos applyInfos ,String auditDesc,Long userId) throws ServiceException
	{
		boolean result= false;
		
		List<Map> activityInstList=this.getActivityInst(applyInfos.getId(), userId);
		
		if(activityInstList!=null && activityInstList.size()!=0)
		{
			try
			{
				Map currentActivity=activityInstList.get(0);
				
				String activityState = String.valueOf(currentActivity.get("Current_State"));
				if("2".equals(activityState))
				{
					throw new ServiceException("该流程已审批过，请不要重复审批！");	 
				}
				
				ActivityInst activityInst=new ActivityInst();
				activityInst.setCheckdes(auditDesc);
				activityInst.setCheckdate(new Date());
				activityInst.setFinalTime(new Date());
				activityInst.setAduitResult("0");//审核结论，1：通过；0：拒绝
				activityInst.setCurrentState("2");
				activityInst.setId(Long.valueOf(currentActivity.get("activity_inst_id").toString()));
				
				this.updateActivityInst(activityInst);
				
				if(applyInfos.getApplytype()!= null && "thirdparty".equals(applyInfos.getApplytype()))//第三方支付的呈批件处理
				{
					CaseBillDetailImpl record = new CaseBillDetailImpl();
					record.setDetailId(applyInfos.getParentid());
					record.setStatus(PClientStatus.ClientFee2.getCode());
					
					this.updateCaseBillDetailByOid(record);
				}
				else if(applyInfos.getApplytype()!=null && "caseClaim".equals(applyInfos.getApplytype()))//如果claimId不为空，则表明是赔款呈批件的处理
				{
					CaseClaimImpl caseClaimImpl=caseClaimImplMapper.selectByPrimaryKey(Long.valueOf(applyInfos.getParentid()));
					if(caseClaimImpl.getRecordtype().equals("D")){
						ClaimIncomeImpl claimIncomeImpl=new ClaimIncomeImpl();
						claimIncomeImpl.setIncomeId(Long.valueOf(caseClaimImpl.getRemark1()));
						claimIncomeImpl.setStatus(InComeStatus.ClaimFee0.getCode());
						claimIncomeImplMapper.updateByPrimaryKeySelective(claimIncomeImpl);
						
						CaseClaimImpl caseClaim=new CaseClaimImpl();
						caseClaim.setStatus(ClaimStatus.ClaimFee0.getCode());
						caseClaim.setClaimId(Long.valueOf(applyInfos.getParentid()));
						this.updateByClaimId(caseClaim);
					}else{
						CaseClaimImpl caseClaim=new CaseClaimImpl();
						caseClaim.setStatus(ClaimStatus.ClaimFee0.getCode());
						caseClaim.setClaimId(Long.valueOf(applyInfos.getParentid()));
						this.updateByClaimId(caseClaim);
					}
				}else if(applyInfos.getApplytype()!=null && "assure".equals(applyInfos.getApplytype())){
					TblPassurePayMents ppm = new TblPassurePayMents();
					ppm =  passurepaymentsmapper.selectByPrimaryKey(Long.valueOf(applyInfos.getParentid()));
					String sql = "select a.* from tbl_passureinfos a where a.paymentid ="+applyInfos.getParentid();
					List<Map> piflist = Jutil.executeSQL(sql);
					for(int i=0;i<piflist.size();i++){
						String pid = piflist.get(i).get("passureid").toString();
						PassureInfos pif = passureInfosServiceMgr.getPassureInfos(Long.valueOf(pid));
                        pif.setFeestatuse(AssureStatus.AssureStatus3.getCode());
                        passureInfosServiceMgr.update(pif);
					}
					ppm.setReportflag("save");
					passurePayMentsServiceMgr.updpayment(ppm);
				}
				Long appId=applyInfos.getId();
				applyInfos=new ApplyInfos();
				applyInfos.setStatus("refused");
				applyInfos.setStep(0);
				applyInfos.setRemarkb("0");
				applyInfos.setId(appId);
				//applyInfos.setRemarkc(null);//清空上一条工作流记录的实例ID
				
				this.updateApplyInfosById(applyInfos);
				
				
			}catch(Exception e)
			{
				e.printStackTrace();
				throw new ServiceException("处理审批时发生异常错误，请联系管理员协助解决！");
			}
		
			result = true;
		}else{
			throw new ServiceException("当前流程已终止，请联系管理员协助解决！");	  
		}
		
		return result;
	}

	 /**
	  * 根据主键id修改赔款登记信息
	  * @param record
	  * @return
	  */
	public int updateByClaimId(CaseClaimImpl record) {
		return caseClaimImplMapper.updateByPrimaryKeySelective(record);
	}
	
	/**
	  * 根据角色id查询用户信息
	  * @param roleid
	  * @return
	  */
	public List<Map> searchUserByRoleId(Long roleid,String orgParam) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT user_id userId,name FROM sys_user WHERE  User_Id IN (SELECT user_id FROM sys_user_role WHERE role_id='"+roleid+"') AND user_status='1'");
		if(orgParam != null && !"".equals(orgParam))
		{
			tSql.append(" and org_code ='"+orgParam+"' ");
		}
		
		return Jutil.executeSQL(tSql.toString());
	}
	
	public String getApplyIdByBillParentId(String parentId,String applyType)
	{
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT IFNULL(oid,0) applyId FROM tbl_applyinfos WHERE applytype='"+applyType+"' and parentid = '"+parentId+"'");
		
		return Jutil.getOneValue(tSql.toString(), "applyId");
		
	}

	 /**
	  * 根据呈批件id和当前登录用户id查询节点参与者id
	  * @param applyId
	  * @param userId
	  * @return
	  */
	public String getParticIdByUserId(Long applyId, Long userId) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT partic_inst_id particId FROM tbl_partic_inst WHERE activity_inst_id IN ");
		tSql.append("(SELECT activity_inst_id FROM tbl_activity_inst WHERE process_inst_id IN (SELECT IFNULL(remarkc,'0') FROM tbl_applyinfos WHERE oid="+applyId+") AND current_state = '1') ");
		tSql.append(" AND partic_user_id = '"+userId+"'");
		List<Map> ls=Jutil.executeSQL(tSql.toString());
		if(ls!=null && ls.size()!=0){
			 Map map=ls.get(0);
			 return map.get("particId").toString();
		}else{
		  return null;
		}
	}

	/**
	  * 根据呈批件id查询节点实例id
	  * @param applyId
	  * @return
	  */
	public String getActivityIdByApplyId(Long applyId) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT activity_inst_id activityId FROM tbl_activity_inst WHERE current_state = '1' AND process_inst_id IN (SELECT IFNULL(remarkc,'0') FROM tbl_applyinfos WHERE oid="+applyId+")");
		List<Map> ls=Jutil.executeSQL(tSql.toString());
		if(ls!=null && ls.size()!=0){
			 Map map=ls.get(0);
			 return map.get("activityId").toString();
		}else{
		  return null;
		}
	}


     /**
	  * 根据编号（Process_No）查询流程信息
	  * @param processNo
	  * @return
	 */
	public List<Map> getProcessDefByNo(String processNo) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("select Process_Def_Id,Process_Name from tbl_process_def where Process_No='"+processNo+"' and Current_State='1'");
		List<Map> ls=Jutil.executeSQL(tSql.toString());
		return ls;
	}

	 /**
	  * 根据条件查询节点实例参与者信息
	  * @param processInstId
	  * @param processDefId
	  * @param preActivityId
	  * @return
	 */
	public List<Map> searchParticInstByCondition(String processInstId,
			Long processDefId, String preActivityId) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT Partic_User_Id,Partic_User_Value,Partic_Inst_Id,Process_Inst_ID,Activity_Inst_ID FROM tbl_partic_inst WHERE Activity_Inst_ID IN (SELECT Activity_Inst_ID FROM tbl_activity_inst WHERE Process_Inst_ID='"+processInstId+"' AND Activity_Def_Id IN (SELECT Activity_Def_Id FROM tbl_activity_def WHERE Process_Def_Id='"+processDefId+"' AND Activity_Def_Id='"+preActivityId+"') AND Current_State  NOT IN ('2')) AND Excute_State NOT IN ('2','4')");
		List<Map> ls=Jutil.executeSQL(tSql.toString());
		return ls;
	}

	 /**
	  * 根据条件修改节点实例参与者信息
	  * @param pi
	  */
	public void updateParticInstByCondition(ParticInst pi) {
//		String sql="update tbl_partic_inst set Excute_State ='"+pi.getExcuteState()+"' where Partic_Inst_Id='87'";
//	    Jutil.updateSQL(sql);
		TblParticInst tblParticInst=pi.getTblParticInst();
		particInstMapper.updateByPrimaryKeySelective(tblParticInst);
	}

	 /**
	  * 根据流程实例id删除相关流程实例信息
	  * @param processInstId
	  */
	public void delAllProcess(Long processInstId) {
		particInstMapper.deleteByProcessInstId(processInstId);
		activityInstMapper.deleteByProcessInstId(processInstId);
		processInstMapper.deleteByPrimaryKey(processInstId);
	}

	/**
	  * 根据id删除呈批件信息
	  * @param applyId
	  */
	public void delApplyInfos(Long applyId) {
          applyInfosMapper.deleteByPrimaryKey(applyId);		
	}
}
