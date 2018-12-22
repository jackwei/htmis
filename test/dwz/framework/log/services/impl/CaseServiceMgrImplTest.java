package dwz.framework.log.services.impl;


import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.db.beans.CaseInfoImpl;
import com.git.db.beans.SysSequence;
import com.git.db.mapper.CaseInfoImplMapper;
import com.git.db.mapper.SysSequenceMapper;
import com.git.util.service.SequenceService;

import dwz.framework.junit.BaseJunitCase;

public class CaseServiceMgrImplTest extends BaseJunitCase{
	
	@Autowired
	private CaseInfoImplMapper caseInfoImplMapper;
	
	@Autowired
	private SysSequenceMapper tSysSequenceMapper;
	
	private  SequenceService sequenceService;

	@Test
	public void testAddCase() {
		CaseInfoImpl caseInfoImpl = null;
		for (int i = 0; i < 30; i++) {
			 caseInfoImpl = new CaseInfoImpl();
			try {
				caseInfoImpl.setCaseId(getSequence("case_id"));
				caseInfoImpl.setCasenumber("10000");
				caseInfoImpl.setShipname("test ship");
				caseInfoImpl.setCasetypename("test type");
				caseInfoImpl.setAccidentport("test 口岸 ");
				caseInfoImpl.setCasedes("test des");
				caseInfoImpl.setCreateTime(new Date());
				caseInfoImpl.setUsername("test user");
				caseInfoImpl.setOrgcode("10001");
				caseInfoImplMapper.insert(caseInfoImpl);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
	public  long getSequence(String sequenceName)
	{
		long sequenceNo=0;
		SysSequence tSysSequence=tSysSequenceMapper.selectByPrimaryKey(sequenceName);
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName(sequenceName);
			tSysSequence.setSeqNo((long)10000001);
			sequenceNo=tSysSequence.getSeqNo();
			tSysSequenceMapper.insert(tSysSequence);
		}
		else
		{
			tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			sequenceNo=tSysSequence.getSeqNo();
			tSysSequenceMapper.updateByPrimaryKey(tSysSequence);
		}
		
		return sequenceNo;
	}

	public void setCaseInfoImplMapper(CaseInfoImplMapper caseInfoImplMapper) {
		this.caseInfoImplMapper = caseInfoImplMapper;
	}

	public CaseInfoImplMapper getCaseInfoImplMapper() {
		return caseInfoImplMapper;
	}

	public void setSequenceService(SequenceService sequenceService) {
		this.sequenceService = sequenceService;
	}

	public SequenceService getSequenceService() {
		return sequenceService;
	}

}
