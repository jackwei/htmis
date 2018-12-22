/**
 * 
 */
package com.git.business.caseService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.process.CaseBillDetail;
import com.git.business.sys.Org;
import com.git.business.sys.OrgServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillDetailImplExample;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseBillImplExample;
import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.CaseInfoImplExample;
import com.git.db.beans.CaseInfoImplExample.Criteria;
import com.git.db.mapper.CaseBillDetailImplMapper;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.db.mapper.CaseInfoImplMapper;
import com.git.enums.AccFlagStatus;
import com.git.enums.CaseStatus;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("caseServiceMgr")
public class CaseServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements CaseServiceMgr{

	@Autowired
	private CaseInfoImplMapper caseInfoImplMapper;
	
	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
	
	@Autowired
	private CaseBillDetailImplMapper caseBillDetailImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private OrgServiceMgr orgServiceMgr;
		
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public CaseInfoImpl updCase(CaseInfoImpl caseInfoImpl){
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);
		Org org = orgServiceMgr.getOrg(user.getOrgId());
		//创建新案件
		if("".equals(request.getParameter("caseId")) || null == request.getParameter("caseId")){
			//创建案号生成规则
			SimpleDateFormat sd = new SimpleDateFormat("yyMM");
			Date date = new Date();
			String yearstr = sd.format(date);
			String casenumber = sequenceService.getSequence("casenumber", "HTPI", yearstr, "", 4, '0', 'L');
			caseInfoImpl.setCaseId(sequenceService.getSequence("case_id"));
			caseInfoImpl.setCasenumber(casenumber);
			//扩展案号生成规则  机构简称+委托人简称+用户简称
			String excasenumber = "";
			excasenumber += org.getOrgSname();
			excasenumber += request.getParameter("orgLookup.names");
			excasenumber += user.getsName();
				
			caseInfoImpl.setExcasenumber(excasenumber);
			caseInfoImpl.setFeecount((long)0);
			caseInfoImpl.setCreateOperator(user.getId());
			caseInfoImpl.setCreateTime(new Date());
			caseInfoImpl.setCasestatus(CaseStatus.CaseNew.getCode());
			caseInfoImpl.setAccflag(AccFlagStatus.AccFlag0.getCode());
			System.out.println("添加案件中：orgcode"+user.getOrgCode());
			caseInfoImpl.setOrgcode(user.getOrgCode());
			caseInfoImpl.setOraname(org.getOrgName());
			caseInfoImpl.setUsername(user.getName());
			caseInfoImpl.setUserid(String.valueOf(user.getId()));
			caseInfoImpl.setSetdate(new Date());
		}else{//修改案件
			caseInfoImpl = caseInfoImplMapper.selectByPrimaryKey(Long.valueOf(request.getParameter("caseId")));
//			caseInfoImpl.setCaseId(Long.valueOf(request.getParameter("caseId")));
//			caseInfoImpl.setCasenumber(request.getParameter("casenumber"));
			//caseInfoImpl.setExcasenumber("BJHM");
			caseInfoImpl.setModifyOperatorId(user.getId());
			caseInfoImpl.setModifyTime(new Date());
		}
		
		
		caseInfoImpl.setShipname(request.getParameter("shipname"));
		caseInfoImpl.setAccidentdate(PubDateUtil.stringToDate(request.getParameter("accidentdate"), "yyyy-MM-dd"));
		caseInfoImpl.setCasedes(request.getParameter("casedes"));
		
		//事发口岸
		caseInfoImpl.setAccidentportid(request.getParameter("accidentport.oid") == null ? "":request.getParameter("accidentport.oid"));
		caseInfoImpl.setAccidentport(request.getParameter("accidentport.paramtexta") == null ? "":request.getParameter("accidentport.paramtexta"));
		
		String casetypeid = request.getParameter("casetypename");
		caseInfoImpl.setCasetypeid(casetypeid);
		String sql = "SELECT * FROM sys_dict_entry a WHERE a.dicttypeid='casetype' and a.dictid ='"+casetypeid+"' ";
		List<Map> casetype = Jutil.executeSQL(sql);	
		caseInfoImpl.setCasetypename(casetype.get(0).get("BackUp1").toString());
		
		//委托人分类
		caseInfoImpl.setConsignortypename(request.getParameter("consignorType.DictName"));
		caseInfoImpl.setConsignortypeid(request.getParameter("consignorType.SortNo"));
		
		//委托人
		caseInfoImpl.setConsignorsn(request.getParameter("orgLookup.names"));
		caseInfoImpl.setConsignorid(request.getParameter("orgLookup.oid"));
		caseInfoImpl.setConsignorname(request.getParameter("orgLookup.name"));
		
		caseInfoImpl.setCasecontact(request.getParameter("casecontact"));
		
		caseInfoImpl.setAcademynum(request.getParameter("academynum"));
		caseInfoImpl.setCheckcompany(request.getParameter("checkcompany"));
		caseInfoImpl.setBarristers(request.getParameter("barristers"));
		
		if("".equals(request.getParameter("caseId")) || null == request.getParameter("caseId")){
			caseInfoImplMapper.insert(caseInfoImpl);
		}else{
			caseInfoImplMapper.updateByPrimaryKeySelective(caseInfoImpl);
		}
		
		return caseInfoImpl;
	}
	
	public int updateCase(CaseInfoImpl caseInfoImpl){
		return caseInfoImplMapper.updateByPrimaryKeySelective(caseInfoImpl);
	}
	
	public void addCase(CaseInfoImpl caseInfoImpl){
		caseInfoImplMapper.insert(caseInfoImpl);
	}
	
	@SuppressWarnings("rawtypes")
	public Map<Object, Object> searchCase(Map criterias,BaseConditionVO vo){
		Map<Object, Object> search = new HashMap<Object, Object>();
		
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		
		StringBuffer sql = new StringBuffer("select * from tbl_case where 1=1 ");
		
		if(!"".equals(criterias.get("casenumber")) && null !=criterias.get("casenumber") ){
			sql.append(" and casenumber like '%"+criterias.get("casenumber").toString()+"%'");
		}
		if(!"".equals(criterias.get("shipname")) && null !=criterias.get("shipname")){
			sql.append(" and shipname like '%"+criterias.get("shipname").toString()+"%'");
		}
		if(!"".equals(criterias.get("excasenumber")) && null !=criterias.get("excasenumber") ){
			sql.append(" and excasenumber like '%"+criterias.get("excasenumber").toString()+"%'");
		}
		if(!"".equals(criterias.get("billstatus")) && null != criterias.get("billstatus")){
			sql.append(" and accflag = '"+criterias.get("billstatus").toString()+"'");
		}
		if(!"".equals(criterias.get("consignorsn")) && null != criterias.get("consignorsn")){
			sql.append(" and (consignorsn like '%"+criterias.get("consignorsn").toString()+"%' or consignorname like '%"+criterias.get("consignorsn").toString()+"%') ");
		}
		
		if(null != criterias.get("casestatus")){
			if("inspect".equals(criterias.get("casestatus"))){
				if(user.getExtend2().indexOf("海事业管") < 0){
					sql.append(" and orgcode = "+user.getOrgCode());
				}
			}else{
				if("0".equals(criterias.get("casestatus").toString())){
					sql.append(" and casestatus <> '9'");
				}else if("9".equals(criterias.get("casestatus").toString())){
					sql.append(" and casestatus = '9'");
				}
				sql.append(" and (Create_Operator = "+user.getId()+"  or Case_Id in (select h.`Case_Id` from tbl_case_handle h  where h.`User_Id` = "+user.getId()+" ))");
			}			
		}
		
		sql.append(" order by casenumber desc ");
		
		List caseList = Jutil.executeSQL(sql.toString(), vo.getStartIndex(), vo.getPageSize());
		String count = Jutil.getOneValue(sql.toString().replace("*", "count(1) as count"),"count");
		
		search.put("count", count);
		search.put("caseList", caseList);
		return search;
	}
	
	/**
	 * 获取案件所有第三方信息
	 * */
	public List<CaseBillDetailImpl> getCaseConsignor(String caseId){
		List<CaseBillDetailImpl> congsignorList = new ArrayList<CaseBillDetailImpl>();
		CaseBillImplExample example = new CaseBillImplExample();
		example.createCriteria().andCaseIdEqualTo(Long.valueOf(caseId));
		List<CaseBillImpl> caseBillList = caseBillImplMapper.selectByExample(example);
		
		for (CaseBillImpl caseBillImpl : caseBillList) {
			CaseBillDetailImplExample exa = new CaseBillDetailImplExample();
			com.git.db.beans.CaseBillDetailImplExample.Criteria criteria = exa.createCriteria();
			criteria.andBillIdEqualTo(caseBillImpl.getBillId());
			criteria.andFeetypeEqualTo("thirdPart");
			List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailImplMapper.selectByExample(exa);
			congsignorList.addAll(caseBillDetailList);
		}
		return congsignorList;
	}
	
	/**
	 * 获取第三方的账单的详细信息
	 */
	public List<CaseBillDetail> getCaseBillDetail(String caseId)
	{
		List<CaseBillDetail> resultList = new ArrayList<CaseBillDetail>();		
		
		CaseBillImplExample example = new CaseBillImplExample();
		example.createCriteria().andCaseIdEqualTo(Long.valueOf(caseId));
		List<CaseBillImpl> caseBillList = caseBillImplMapper.selectByExample(example);
		try
		{
			for (CaseBillImpl caseBillImpl : caseBillList) 
			{
				CaseBillDetailImplExample exa = new CaseBillDetailImplExample();
				com.git.db.beans.CaseBillDetailImplExample.Criteria criteria = exa.createCriteria();
				criteria.andBillIdEqualTo(caseBillImpl.getBillId());
				criteria.andFeetypeEqualTo("thirdPart");
				List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailImplMapper.selectByExample(exa);
				
				for (CaseBillDetailImpl po : caseBillDetailList) 
				{
					resultList.add(new CaseBillDetail(po));
				}				
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return resultList;
	}
	
	public CaseInfoImpl getCaseInfo(String caseId){
		CaseInfoImpl ci = caseInfoImplMapper.selectByPrimaryKey(Long.valueOf(caseId));
		return ci;
	}
	
	public void delCaseInfo(String caseId){
		caseInfoImplMapper.deleteByPrimaryKey(Long.valueOf(caseId));
	}
	
	public int getCount(){
		CaseInfoImplExample exa = new CaseInfoImplExample();
		return caseInfoImplMapper.countByExample(exa);
	}
	
	public CaseInfoImpl searchCaseInfoByCaseNumber(String casenumber){
		CaseInfoImplExample example = new CaseInfoImplExample();
		Criteria criteria = example.createCriteria();
		criteria.andCasenumberEqualTo(casenumber);
		List<CaseInfoImpl> caseInfoList = caseInfoImplMapper.selectByExample(example);
		return caseInfoList.get(0);
	}
	
	public String getCaseInfoByCaseNumber(String casenumber){
		CaseInfoImplExample example = new CaseInfoImplExample();
		Criteria criteria = example.createCriteria();
		criteria.andCasenumberEqualTo(casenumber);
		List<CaseInfoImpl> caseInfoList = caseInfoImplMapper.selectByExample(example);
		if(caseInfoList.size() <= 0){
			return "300";
		}else{
			for (CaseInfoImpl caseInfoImpl : caseInfoList) {
				return caseInfoImpl.getShipname();
			}
		}
		return "";
	}
	
}
