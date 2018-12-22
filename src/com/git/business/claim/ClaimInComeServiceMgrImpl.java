/**
 * 
 */
package com.git.business.claim;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.finance.CalFinItemServiceMgr;
import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseClaimImpl;
import com.git.db.beans.ClaimIncomeImpl;
import com.git.db.beans.ClaimIncomeImplExample;
import com.git.db.beans.ClaimIncomeImplExample.Criteria;
import com.git.db.mapper.CaseClaimImplMapper;
import com.git.db.mapper.ClaimIncomeImplMapper;
import com.git.util.Jutil;
import com.git.util.MMap;
import com.git.enums.InComeStatus;
import com.git.util.PubDateUtil;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("claimInComeServiceMgr")
public class ClaimInComeServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements ClaimInComeServiceMgr{

	@Autowired
	private ClaimIncomeImplMapper claimIncomeImplMapper;
	
	@Autowired
	private CaseClaimImplMapper caseClaimImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private CalFinItemServiceMgr calFinItemServiceMgr;
	
	/**
	 * 添加赔款到账
	 * */
	public int updClaimIncome(ClaimIncomeImpl claimIncomeImpl,HttpServletRequest request ) throws ServiceException{
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(Constants.AUTHENTICATION_KEY);

		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			claimIncomeImpl.setIncomeId(sequenceService.getSequence("claimIncomeImpl"));
			claimIncomeImpl.setDifferamount(Float.valueOf(request.getParameter("totalamount")));
			claimIncomeImpl.setStatus(InComeStatus.ClaimFee5.getCode());
			claimIncomeImpl.setIslocked("no");
			claimIncomeImpl.setCreateOperator(user.getId());
			claimIncomeImpl.setCreateTime(new Date());
			
		}else{
			if(!"HTPI1300".equals(claimIncomeImpl.getCasenumber().substring(0, 8))){
				MMap mmap = new MMap();
				mmap.put("Income_Id", claimIncomeImpl.getIncomeId());
				calFinItemServiceMgr.dealFinItem("107", mmap,-1);
			}
			
			if(claimIncomeImpl.getLockdate() != null){
				throw new ServiceException("已处理赔款到账，不能修改");
			}
			claimIncomeImpl.setIncomeId(Long.valueOf(request.getParameter("inComeId")));
			claimIncomeImpl.setModifyOperatorId(user.getId());
			claimIncomeImpl.setModifyTime(new Date());
		}
		
		claimIncomeImpl.setCasenumber(request.getParameter("casenumber"));
		claimIncomeImpl.setBank(request.getParameter("bank"));
		claimIncomeImpl.setBankfee(Float.valueOf(request.getParameter("bankfee")));
		claimIncomeImpl.setBanknum(request.getParameter("banknum"));
		claimIncomeImpl.setCurrency(request.getParameter("currency"));
		claimIncomeImpl.setPayer(request.getParameter("payer"));
		claimIncomeImpl.setReceiveamount(Float.valueOf(request.getParameter("receiveamount")));
		claimIncomeImpl.setReceivedate(PubDateUtil.stringToDate(request.getParameter("receivedate"), "yyyy-MM-dd"));
		claimIncomeImpl.setRemark(request.getParameter("remark"));
		claimIncomeImpl.setShipname(request.getParameter("shipname"));
		claimIncomeImpl.setTotalamount(Float.valueOf(request.getParameter("totalamount")));
		
		/*claimIncomeImpl.setUsdamount(Float.valueOf(request.getParameter("usdamount")));
		claimIncomeImpl.setUsdrate(new BigDecimal(request.getParameter("usdrate")));*/
		
		if("".equals(request.getParameter("inComeId")) || null==request.getParameter("inComeId")){
			return claimIncomeImplMapper.insert(claimIncomeImpl);
		}else{
			return claimIncomeImplMapper.updateByPrimaryKeySelective(claimIncomeImpl);
		}
	}
	
	public int updateClaimIncome(ClaimIncomeImpl claimIncomeImpl){
		return claimIncomeImplMapper.updateByPrimaryKeySelective(claimIncomeImpl);
	}
	
	/**
	 * 查询赔款到账信息
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map searchClaimIncome(Map criterias,BaseConditionVO vo){
		Map search = new HashMap();
		List<ClaimIncomeImpl> claimIncomeList = new ArrayList<ClaimIncomeImpl>();
		ClaimIncomeImplExample example = new ClaimIncomeImplExample();
		example.setOrderByClause(" casenumber desc");
		Criteria criteria = example.createCriteria();
		criteria.andCreateOperatorEqualTo((Long)criterias.get("userId"));
		
		if(null != criterias.get("casenumber") && !"".equals(criterias.get("casenumber"))){
			criteria.andCasenumberLike("%"+criterias.get("casenumber").toString()+"%");
		}
		if(null != criterias.get("payer") && !"".equals(criterias.get("payer"))){
			criteria.andPayerLike("%"+criterias.get("payer").toString()+"%");
		}
		if(null != criterias.get("receivedate") && !"".equals(criterias.get("receivedate"))){
			criteria.andReceivedateEqualTo(PubDateUtil.stringToDate(criterias.get("receivedate").toString(), "yyyy-MM-dd"));
		}
		
		if(null != criterias.get("status") && !"".equals(criterias.get("status"))){
			criteria.andStatusEqualTo(criterias.get("status").toString());
		}
		
		int count = claimIncomeImplMapper.countByExample(example);
		
		//criteria.andCaseIdEqualTo(StrTool.getLong(criterias.get("caseId")));
		RowBounds rb = new RowBounds(vo.getStartIndex(),vo.getPageSize()) ;
		claimIncomeList = claimIncomeImplMapper.selectByExampleWithRowbounds(example, rb);
		search.put("claimIncomeList", claimIncomeList);
		search.put("count", count);
		
		return search;
	}
	
	public List<ClaimIncomeImpl> searchClaimIncomeByCaseNum(Map criterias,String caseNumber){
		List<ClaimIncomeImpl> claimIncomeList = new ArrayList<ClaimIncomeImpl>();
		ClaimIncomeImplExample example = new ClaimIncomeImplExample();
		example.setOrderByClause(" casenumber desc");
		Criteria criteria = example.createCriteria();
		criteria.andCasenumberEqualTo(caseNumber);
		
		if(null != criterias){
			if(null != criterias.get("differamount") && !"".equals(criterias.get("differamount"))){
				criteria.andDifferamountNotEqualTo(new Float(criterias.get("differamount").toString()));
			}
			
			if(null != criterias.get("status") && !"".equals(criterias.get("status"))){
				criteria.andStatusEqualTo(criterias.get("status").toString());
			}
			
		}
		
		claimIncomeList = claimIncomeImplMapper.selectByExample(example);
		return claimIncomeList;
	}
	
	/**
	 * 查询赔款余额
	 * */
	@SuppressWarnings("unchecked")
	public List<ClaimIncomeImpl> searchClaimIncomeByBill(Map criterias,String caseNumber){
		List<ClaimIncomeImpl> claimIncomeList = new ArrayList<ClaimIncomeImpl>();
		
		StringBuffer sb = new StringBuffer("select * from tbl_claim_income i where 1=1 ");
		if(null != caseNumber && !"".equals(caseNumber)){
			sb.append(" and i.`casenumber`= '"+ caseNumber+"'");
		}
		
		if(null != criterias){
			if(null != criterias.get("differamount") && !"".equals(criterias.get("differamount"))){
				if(Float.valueOf(criterias.get("differamount").toString()) == 0){
					//sb.append(" and i.`differamount` <> "+new Float(criterias.get("differamount").toString()));
				}else{
					sb.append(" and i.`differamount` >= 0");
				}
			}
			
			if(null != criterias.get("billId") && !"".equals(criterias.get("billId"))){
				if(criterias.get("billId").toString().equals("0")){
					sb.append(" and i.`bill_id` = "+criterias.get("billId").toString());
				}else if(null != criterias.get("flag") && !"".equals(criterias.get("flag"))){
					sb.append(" and i.`bill_id` = "+criterias.get("billId").toString());
				}else{
					sb.append(" and (i.`bill_id` = 0 or i.`bill_id`="+criterias.get("billId").toString()+" )");
				}
			}
			
			if(null != criterias.get("status") && !"".equals(criterias.get("status"))){
				sb.append(" and i.`status`= '"+criterias.get("status").toString()+"'");
			}
			
			if(null != criterias.get("Islocked") && !"".equals(criterias.get("Islocked"))){
				sb.append(" and i.`Islocked`= '"+criterias.get("Islocked").toString()+"'");
			}
		}
		sb.append(" order by i.`casenumber` desc");
		
		claimIncomeList = Jutil.executeSQL(sb.toString());
		
		return claimIncomeList;
	}
	
	/**
	 * 赔款查询
	 * */
	public List<ClaimIncomeImpl> searchClaimIncomeByLock(Map criterias,String caseNumber){
		List<ClaimIncomeImpl> claimIncomeList = new ArrayList<ClaimIncomeImpl>();
		ClaimIncomeImplExample example = new ClaimIncomeImplExample();
		example.setOrderByClause(" casenumber desc");
		Criteria criteria = example.createCriteria();
		criteria.andCasenumberEqualTo(caseNumber);
		
		if(null != criterias){
			if(null != criterias.get("InComeStatus") && !"".equals(criterias.get("InComeStatus"))){
				criteria.andStatusEqualTo(criterias.get("InComeStatus").toString());
			}
		}
		
		claimIncomeList = claimIncomeImplMapper.selectByExample(example);
		return claimIncomeList;
	}
	
	public ClaimIncomeImpl getClaimIncome(String inComeId){
		ClaimIncomeImpl cc = claimIncomeImplMapper.selectByPrimaryKey(Long.valueOf(inComeId));
		return cc;
	}
	
	public void del(String inComeId){
		claimIncomeImplMapper.deleteByPrimaryKey(Long.valueOf(inComeId));
	}
	
	public int getCount(){
		ClaimIncomeImplExample exa = new ClaimIncomeImplExample();
		return claimIncomeImplMapper.countByExample(exa);
	}

	  
	/**
	 * 根据到账id查询赔款登记信息
	 * @param claimIncomeId
	 * @return
	 */
	public CaseClaimImpl searchcaseClaim(String claimIncomeId) {
		return caseClaimImplMapper.searchcaseClaimByIncomeId(claimIncomeId);
	}

	/**
	 * 根据案号id查询赔款到账信息以及赔款登记信息
	 * @param caseNumber
	 * @return
	 */
	public List<Map> searchClaimIncomeByNum(String caseNumber) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("SELECT cm.Income_Id,cm.casenumber,cm.currency,cm.shipname,cm.payer,cm.receiveamount,cm.bankfee,cm.totalamount,cm.differamount,cm.receivedate,cm.status,cc.Claim_Id FROM tbl_claim_income cm,tbl_case_claim cc WHERE cc.remark1=cm.Income_Id AND cm.casenumber='"+caseNumber+"' ORDER BY cm.casenumber DESC");
		List<Map> ls=Jutil.executeSQL(tSql.toString());
		return ls;
	}
	
	/**
	 * 根据案号billId查询赔款到账信息
	 * @param BillID
	 * @return
	 */
	public List<Map> searchClaimIncomeByBillId(String billId) {
		StringBuffer tSql = new StringBuffer(16);
		tSql.append("select * from tbl_claim_income i where 1=1 and i.`bill_id`="+billId);
		List<Map> ls=Jutil.executeSQL(tSql.toString());
		return ls;
	}
	
}
