/**
 * 
 */
package com.git.business.voucher;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.db.BaseConditionVO;
import com.git.db.beans.FinData;
import com.git.db.beans.FinDataExample;
import com.git.db.beans.FinDataExample.Criteria;
import com.git.db.beans.FinDataResult;
import com.git.db.beans.FinDataResultExample;
import com.git.db.mapper.FinDataMapper;
import com.git.db.mapper.FinDataResultMapper;
import com.git.util.PubDateUtil;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("voucherServiceMgr")
public class VoucherServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements VoucherServiceMgr{

	@Autowired
	private FinDataMapper finDataMapper;
	
	@Autowired
	private FinDataResultMapper finDataResultMapper;
	
	/**
	 * 
	 * */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Map<Object,Object> searchFinData(Map criterias,BaseConditionVO vo){
		List<FinData> FinDataList = new ArrayList<FinData>();
		FinDataExample example = new FinDataExample();
		example.setOrderByClause("batch_no desc");
		Map search = new HashMap<Object, Object>();
		Criteria  criteria = example.createCriteria();
		if(null != criterias.get("dealFlag") && !"".equals(criterias.get("dealFlag"))){
			criteria.andDealFlagEqualTo(criterias.get("dealFlag").toString());
		}
		if(null != criterias.get("bussId") && !"".equals(criterias.get("bussId"))){
			criteria.andBussIdEqualTo(criterias.get("bussId").toString());
		}
		if(null != criterias.get("bussKeyNo") && !"".equals(criterias.get("bussKeyNo"))){
			criteria.andBussKeyNoEqualTo(criterias.get("bussKeyNo").toString());
		}
		if(null != criterias.get("makeTime") && !"".equals(criterias.get("makeTime"))){
			criteria.andMakeTimeEqualTo(PubDateUtil.stringToDate(criterias.get("makeTime").toString(), "yyyy-MM-dd"));
		}
		int count = 0;
		if(null == vo){
			FinDataList = finDataMapper.selectByExample(example);
			count = finDataMapper.countByExample(example);
		}else{
			RowBounds rowBounds = new RowBounds(vo.getStartIndex(),vo.getPageSize());
			FinDataList = finDataMapper.selectByExampleWithRowbounds(example, rowBounds);
		}
		count = finDataMapper.countByExample(example);
		search.put("count", count);
		search.put("FinDataList",FinDataList);
		return search;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Map<Object,Object> searchFinDataResult(Map criterias){
		List<FinDataResult> FinDataResultList = new ArrayList<FinDataResult>();
		FinDataResultExample example = new FinDataResultExample();
		example.setOrderByClause("seq_id desc");
		com.git.db.beans.FinDataResultExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(criterias.get("batchNo").toString());
		Map search = new HashMap<Object, Object>();
		FinDataResultList = finDataResultMapper.selectByExample(example);
		search.put("FinDataResultList", FinDataResultList);
		return search;
	}
	
	public FinData getFinData(String batchNo){
		return finDataMapper.selectByPrimaryKey(batchNo);
	}
	
	public FinDataResult getFinDataResult(String seqId){
		return finDataResultMapper.selectByPrimaryKey(Long.valueOf(seqId));
	}
	
	public int updateFindata(FinData finData){
		return finDataMapper.updateByPrimaryKeySelective(finData);
	}
	
	public int updateFinDataResult(FinDataResult finDataResult ){
		return finDataResultMapper.updateByPrimaryKeySelective(finDataResult);
	}
	
	public int deleteFinData(String batchNo){
		return finDataMapper.deleteByPrimaryKey(batchNo);
	}
	
	public int deleteFinDataResult(String batchNo){
		FinDataResultExample example = new FinDataResultExample();
		com.git.db.beans.FinDataResultExample.Criteria criteria = example.createCriteria();
		criteria.andBatchNoEqualTo(batchNo);
		return finDataResultMapper.deleteByExample(example);
	}
	
}
