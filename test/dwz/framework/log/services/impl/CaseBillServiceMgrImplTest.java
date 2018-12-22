package dwz.framework.log.services.impl;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.db.beans.CaseBillImpl;
import com.git.db.beans.SysSequence;
import com.git.db.mapper.CaseBillImplMapper;
import com.git.db.mapper.SysSequenceMapper;

import dwz.framework.junit.BaseJunitCase;


public class CaseBillServiceMgrImplTest extends BaseJunitCase{
	
	@Autowired
	private CaseBillImplMapper caseBillImplMapper;
	
	@Autowired
	private SysSequenceMapper tSysSequenceMapper;

	
	public CaseBillImplMapper getCaseBillImplMapper() {
		return caseBillImplMapper;
	}

	public void setCaseBillImplMapper(CaseBillImplMapper caseBillImplMapper) {
		this.caseBillImplMapper = caseBillImplMapper;
	}

	public SysSequenceMapper gettSysSequenceMapper() {
		return tSysSequenceMapper;
	}

	public void settSysSequenceMapper(SysSequenceMapper tSysSequenceMapper) {
		this.tSysSequenceMapper = tSysSequenceMapper;
	}
	
	//private  SequenceService sequenceService;
	
	@Test
	public void addCaseBill(){
		
		CaseBillImpl cb = null;
		for (int i = 0; i < 200; i++) {
			try {
				cb = new CaseBillImpl();
				cb.setBillId(getSequence("bill_id"));
				cb.setCaseId((long)103);
			//	cb.setBillNo("100000001");
				cb.setServicefee((float)20);
				cb.setPayer("Owners/Charterers");
				cb.setConame("The Britannia Steam Ship ");
				cb.setAddress("Regis House");
				cb.setAssurefee((float)30);
				cb.setOtherfee((float)40);
				cb.setThirdpart((float)50);
				cb.setCompensationsub((float)5.5);
				cb.setCurrency("RMB");
				cb.setExpendses((float)60);
				cb.setFeeamount((float)70);
				cb.setFeestatuse("1");
				cb.setServicedes("test bill");
				cb.setRemark("test bill");
				cb.setCreateTime(new Date());
				cb.setAccdate(new Date());
				cb.setArrdate(new Date());
				caseBillImplMapper.insertSelective(cb);
			} catch (Exception e) {
				e.printStackTrace();
				// TODO: handle exception
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

}
