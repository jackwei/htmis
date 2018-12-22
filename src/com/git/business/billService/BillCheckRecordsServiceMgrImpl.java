/**
 * 
 */
package com.git.business.billService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.git.db.beans.BillCheckRecordsImpl;
import com.git.db.beans.BillCheckRecordsImplExample;
import com.git.db.mapper.BillCheckRecordsImplMapper;
import com.git.util.service.SequenceService;

import dwz.framework.sys.business.AbstractBusinessObjectServiceMgr;

/**
 * @author Administrator
 *
 */
@Transactional(rollbackFor = Exception.class)
@Service("billCheckRecordsServiceMgr")
public class BillCheckRecordsServiceMgrImpl extends AbstractBusinessObjectServiceMgr implements BillCheckRecordsServiceMgr{

	/*@Autowired
	private BillIncomeImplMapper billIncomeImplMapper;
	
	@Autowired
	private BillCheckImplMapper billCheckImplMapper;*/
	
	@Autowired
	private SequenceService sequenceService;
	
	@Autowired
	private BillCheckRecordsImplMapper billCheckRecordsImplMapper;
	
	public int updBillCheckRecords(BillCheckRecordsImpl billCheckRecordsImpl){
		return billCheckRecordsImplMapper.updateByPrimaryKeySelective(billCheckRecordsImpl);
	}
	
	public int addBillCheckRecords(BillCheckRecordsImpl billCheckRecordsImpl){
		billCheckRecordsImpl.setRecordsId(sequenceService.getSequence("records_id"));
		return billCheckRecordsImplMapper.insertSelective(billCheckRecordsImpl);
	}
	
	public int getCount(){
		BillCheckRecordsImplExample exa = new BillCheckRecordsImplExample();
		return billCheckRecordsImplMapper.countByExample(exa);
	}
	
}
