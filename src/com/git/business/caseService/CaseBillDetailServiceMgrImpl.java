/**
 * 
 */
package com.git.business.caseService;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.business.sys.User;
import com.git.db.BaseConditionVO;
import com.git.db.beans.CaseBillDetailImpl;
import com.git.db.beans.CaseBillDetailImplExample;
import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.CaseBillImplExample;
import com.git.db.mapper.CaseBillDetailImplMapper;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.enums.PClientStatus;
import com.git.util.Jutil;
import com.git.util.PubDateUtil;
import com.git.util.StrTool;
import com.git.util.service.SequenceService;

import dwz.framework.config.Constants;
import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;
import dwz.framework.sys.exception.ServiceException;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("caseBillDetailServiceMgr")
public class CaseBillDetailServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements CaseBillDetailServiceMgr{
	
	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
		
	@Autowired
	private CaseBillDetailImplMapper caseBillDetailImplMapper;
	
	@Autowired
	private SequenceService sequenceService;
	
	/** 
	 * 添加第三方账单
	 * @throws ServiceException 
	 * @throws IOException 
	 * @throws IllegalStateException 
	 */
	public int updConsignor(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) throws  ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);
		if("".equals(request.getParameter("detailId")) || null == request.getParameter("detailId")){
			caseBillDetailImpl.setDetailId(sequenceService.getSequence("detail_id"));
			caseBillDetailImpl.setStatus(PClientStatus.ClientFee0.getCode());
			caseBillDetailImpl.setPayid("null");
			caseBillDetailImpl.setBillId(Long.valueOf(request.getParameter("billId")));
			caseBillDetailImpl.setFeenumber(request.getParameter("feenumber"));
			caseBillDetailImpl.setCasenumber(request.getParameter("casenumber"));
			caseBillDetailImpl.setCreateOperator(user.getId());
			caseBillDetailImpl.setCreateTime(new Date());
		}else{
			caseBillDetailImpl.setDetailId(Long.valueOf(request.getParameter("detailId")));
			caseBillDetailImpl.setModifyOperatorId(user.getId());
			caseBillDetailImpl.setModifyTime(new Date());
		}
		
		caseBillDetailImpl.setFeetype("thirdPart");
		caseBillDetailImpl.setBussno("thirdPart");
		
		//单位名称
		caseBillDetailImpl.setConsignorid(Long.valueOf(request.getParameter("consignor.oid")));
		caseBillDetailImpl.setConsignorname(request.getParameter("consignor.namecn"));
		
		caseBillDetailImpl.setReportdate(PubDateUtil.stringToDate(request.getParameter("reportdate"),"yyyy-MM-dd"));
		caseBillDetailImpl.setCurrency(request.getParameter("currency"));
		caseBillDetailImpl.setApplydate(PubDateUtil.stringToDate(request.getParameter("applydate"),"yyyy-MM-dd"));
		caseBillDetailImpl.setExpendses(Float.valueOf(request.getParameter("expendses")));
		caseBillDetailImpl.setServicefee(Float.valueOf(request.getParameter("servicefee")));

		caseBillDetailImpl.setChangerate(new BigDecimal(request.getParameter("changerate")));
		
		caseBillDetailImpl.setReplacefee(Float.valueOf(request.getParameter("replacefee")));
		caseBillDetailImpl.setAccamount(Float.valueOf(request.getParameter("accamount")));
		//caseBillDetailImpl.setFeeamount(Float.valueOf(request.getParameter("feeamount")));
		
		if("".equals(request.getParameter("detailId")) || null == request.getParameter("detailId")){
			return caseBillDetailImplMapper.insert(caseBillDetailImpl);
		}{
			return caseBillDetailImplMapper.updateByPrimaryKeySelective(caseBillDetailImpl);
		}
		
	}
	
	public int updOther(CaseBillDetailImpl caseBillDetailImpl,HttpServletRequest request) throws ServiceException{
		User user = (User)request.getSession().getAttribute(Constants.AUTHENTICATION_KEY);

		if("".equals(request.getParameter("detailId")) || null == request.getParameter("detailId")){
			caseBillDetailImpl.setDetailId(sequenceService.getSequence("detail_id"));
			caseBillDetailImpl.setFeetype("other");
			caseBillDetailImpl.setBussno("other");
			caseBillDetailImpl.setStatus(PClientStatus.ClientFee0.getCode());
			caseBillDetailImpl.setPayid("null");
			caseBillDetailImpl.setFeenumber(request.getParameter("feenumber"));
			caseBillDetailImpl.setBillId(Long.valueOf(request.getParameter("billId")));
			caseBillDetailImpl.setCreateOperator(user.getId());
			caseBillDetailImpl.setCreateTime(new Date());
		}else{
			caseBillDetailImpl.setModifyOperatorId(user.getId());
			caseBillDetailImpl.setModifyTime(new Date());
		}
		
		caseBillDetailImpl.setHappendate(PubDateUtil.stringToDate(request.getParameter("happendate"),"yyyy-MM-dd"));
		caseBillDetailImpl.setRemark(request.getParameter("remark"));
		caseBillDetailImpl.setCurrency(request.getParameter("currency"));
		caseBillDetailImpl.setFeeamount(Float.valueOf(request.getParameter("feeamount")));
		caseBillDetailImpl.setChangerate(new BigDecimal(request.getParameter("changerate")));
		caseBillDetailImpl.setAccamount(Float.valueOf(request.getParameter("accamount")));
		
		if("".equals(request.getParameter("detailId")) || null == request.getParameter("detailId")){
			return caseBillDetailImplMapper.insert(caseBillDetailImpl);
		}{
			return caseBillDetailImplMapper.updateByPrimaryKeySelective(caseBillDetailImpl);
		}
		
	}
	
	/**
	 * 获取账单明细信息
	 * */
	public CaseBillDetailImpl searchCaseBillDetail(String detailId){
		CaseBillDetailImpl caseBillDetailImpl = caseBillDetailImplMapper.selectByPrimaryKey(Long.valueOf(detailId));
		return caseBillDetailImpl;
	}
	
	/**
	 * 
	 * 获取案件账单明细
	 * */
	@SuppressWarnings("rawtypes")
	public List<CaseBillDetailImpl> searchCaseBillDetail(Map criterias,BaseConditionVO vo){
		CaseBillDetailImplExample cbi = new CaseBillDetailImplExample();
		com.git.db.beans.CaseBillDetailImplExample.Criteria criteria = cbi.createCriteria();
		if(null != criterias){
			criteria.andBillIdEqualTo(StrTool.getLong(criterias.get("billId")));
			if(null != criterias.get("feeType")){
				criteria.andFeetypeEqualTo(criterias.get("feeType").toString());
			}
		}
		RowBounds rowBounds = null;
		if(null != vo){
			rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize());
		}
		
		List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailImplMapper.selectByExample(cbi);
		return caseBillDetailList;
	}
	
	public List<CaseBillDetailImpl> searchCaseBillDetailByBillId(String billId,String feeType){
		CaseBillDetailImplExample cbi = new CaseBillDetailImplExample();
		com.git.db.beans.CaseBillDetailImplExample.Criteria criteria = cbi.createCriteria();
		
		criteria.andBillIdEqualTo(Long.valueOf(billId));
		if(!"".equals(feeType)){
			criteria.andFeetypeEqualTo(feeType);
		}
		
		List<CaseBillDetailImpl> caseBillDetailList = caseBillDetailImplMapper.selectByExample(cbi);
		return caseBillDetailList;
	}
	
	
	
	public List<CaseBillDetailImpl> searchCaseBillDetailByPayId(String payId){
		List<CaseBillDetailImpl> caseBillDetailList = new ArrayList<CaseBillDetailImpl>();
		CaseBillDetailImplExample cbd = new CaseBillDetailImplExample();
		CaseBillDetailImplExample.Criteria cr = cbd.createCriteria();
		cr.andPayidEqualTo(payId);
		caseBillDetailList = caseBillDetailImplMapper.selectByExample(cbd);
		return caseBillDetailList;
		
	}
	
	public List<CaseBillDetailImpl> searchCaseBillDetail(String orgCode,String consignorid,String payId,String status,String currency){
		
		//CaseBillImplExample example = new CaseBillImplExample();
		//example.createCriteria().andOrgcodeEqualTo(orgCode);
		//List<CaseBillImpl> caseBillList = caseBillImplMapper.selectByExample(example);
		
		//List<CaseBillDetailImpl> caseBillDetailList = new ArrayList<CaseBillDetailImpl>();
		
		/*for (CaseBillImpl caseBillImpl : caseBillList) {
			
			CaseBillDetailImplExample cbd = new CaseBillDetailImplExample();
			CaseBillDetailImplExample.Criteria cr = cbd.createCriteria();
			cr.andBillIdEqualTo(caseBillImpl.getBillId());
			cr.andFeetypeEqualTo("thirdPart");
			if(!"".equals(consignorid)){
				cr.andConsignoridEqualTo(Long.valueOf(consignorid));
				cr.andStatusEqualTo(status);
				cr.andPayidEqualTo("null");
				cr.andCurrencyEqualTo(currency);
			}else{
				cr.andPayidEqualTo(payId);
				cr.andCurrencyEqualTo(currency);
			}
			
			List<CaseBillDetailImpl> detailList = caseBillDetailImplMapper.selectByExample(cbd);
			for (CaseBillDetailImpl caseBillDetailImpl : detailList) {
				caseBillDetailList.add(caseBillDetailImpl);
			}
			
		}*/
		
		StringBuffer sql = new StringBuffer();
		sql.append("select tc.* from tbl_case_bill tb ,tbl_case_bill_detail tc where tb.`Bill_Id` = tc.`Bill_Id` and tb.`orgcode`='"+orgCode+"'");
		
		if(!"".equals(consignorid)){
			sql.append(" and tc.`status`='4' and tc.`payid` = 'null' and tc.`consignorid`='"+consignorid+"' and tc.`currency` = '"+currency+"'");
		}else{
			sql.append(" and tc.`payid`='"+payId+"' and tc.`currency` = '"+currency+"'");
		}
		
		List<CaseBillDetailImpl> caseBillDetailList = Jutil.executeSQL(sql.toString());
		
		return caseBillDetailList;
	}
	
	public int updateCaseBillDetail(CaseBillDetailImpl caseBillDetailImpl){
		return caseBillDetailImplMapper.updateByPrimaryKeySelective(caseBillDetailImpl);
	}
	
	public int getTotalConunt(String feeType){
		CaseBillDetailImplExample cbi = new CaseBillDetailImplExample();
		com.git.db.beans.CaseBillDetailImplExample.Criteria criteria = cbi.createCriteria();
		criteria.andFeetypeEqualTo(feeType);
		return caseBillDetailImplMapper.countByExample(cbi);
	}
	
	public int delete(String detailId){
		return caseBillDetailImplMapper.deleteByPrimaryKey(Long.valueOf(detailId));
	}

	/**
	 * 根据案件id查询第三方信息
	 */
	public List<String> getCaseBillDetail(String caseId,String feeType,BaseConditionVO vo) {
		StringBuffer sb = new StringBuffer(16);
        sb.append("SELECT * FROM tbl_case_bill_detail WHERE Bill_Id IN (SELECT Bill_Id FROM tbl_case_bill WHERE case_id IN (SELECT case_id FROM tbl_case WHERE case_id='"+caseId+"')) and feetype='"+feeType+"'");
        List<String> caseBillDetailList = Jutil.executeSQL(sb.toString(),vo.getStartIndex(),vo.getPageSize());
		return caseBillDetailList;
	}

	/**
	 * 根据案件id查询第三方信息的个数
	 */
	public int getCaseBillDetailCount(String caseId, String feeType) {
		StringBuffer sb = new StringBuffer(16);
        sb.append("SELECT * FROM tbl_case_bill_detail WHERE Bill_Id IN (SELECT Bill_Id FROM tbl_case_bill WHERE case_id IN (SELECT case_id FROM tbl_case WHERE case_id='"+caseId+"')) and feetype='"+feeType+"'");
        List<String> caseBillDetailList = Jutil.executeSQL(sb.toString());
		return caseBillDetailList.size();
	}
		

}
