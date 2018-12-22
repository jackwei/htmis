package dwz.framework.log.services.impl;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.git.db.beans.SysSequence;
import com.git.db.mapper.SysSequenceMapper;
import com.git.util.StrTool;

import dwz.framework.junit.BaseJunitCase;

public class SequenceServiceTest extends BaseJunitCase{
	
	@Autowired
	private	SysSequenceMapper tSysSequenceMapper;
	
	public void testGetSequenceString() {
		
		long sequenceNo=0;
		SysSequence tSysSequence=gettSysSequenceMapper().selectByPrimaryKey("casenumber");
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName("casenumber");
			tSysSequence.setSeqNo((long)101);
			sequenceNo=tSysSequence.getSeqNo();
			gettSysSequenceMapper().insert(tSysSequence);
		}
		else
		{
			tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			sequenceNo=tSysSequence.getSeqNo();
			gettSysSequenceMapper().updateByPrimaryKey(tSysSequence);
		}
		
		System.out.println(sequenceNo);
		
		fail("Not yet implemented");
	}
	
	public void testGetSequenceStringStringString() {
		
		String temp = "2"+"000005";
		int ss = Integer.parseInt(temp);
		ss++;
		temp = String.valueOf(ss);
		temp = temp.substring(1);
		System.out.println(temp);
	}

	public void testGetSequenceStringStringStringIntCharChar() {
		String sequenceName="case_test1";
		String sequenceNo="";
		SysSequence tSysSequence=tSysSequenceMapper.selectByPrimaryKey(sequenceName);
		if(tSysSequence==null)
		{
			tSysSequence=new SysSequence();
			tSysSequence.setSeqName(sequenceName);
			tSysSequence.setPrefix("");
			tSysSequence.setSuffix("13");
			tSysSequence.setSeqNo((long)1);
			
			String nowIndex = StrTool.getStringWith(String.valueOf(tSysSequence.getSeqNo()), 6,'0','L');
			sequenceNo=tSysSequence.getPrefix().concat(nowIndex).concat(tSysSequence.getSuffix());
			tSysSequenceMapper.insert(tSysSequence);
		}
		else
		{
			tSysSequence.setSeqNo(tSysSequence.getSeqNo()+1);
			
			String nowIndex = StrTool.getStringWith(String.valueOf(tSysSequence.getSeqNo()), 6,'0','L');
			sequenceNo=tSysSequence.getPrefix().concat(nowIndex).concat(tSysSequence.getSuffix());
			
			//tSysSequenceMapper.updateByPrimaryKey(tSysSequence);
		}
		
		System.out.println(sequenceNo);
		fail("Not yet implemented");
	}

	public void testTest() {
		fail("Not yet implemented");
	}

	@Test
	public void testMain() {
		long feecount = 0;
		feecount++;
		System.out.println("abcd"+"_"+feecount);
	}

	public void settSysSequenceMapper(SysSequenceMapper tSysSequenceMapper) {
		this.tSysSequenceMapper = tSysSequenceMapper;
	}

	public SysSequenceMapper gettSysSequenceMapper() {
		return tSysSequenceMapper;
	}
	
	public static void main(String[] args) {
		Float num1 = (float)4.2322;
		Float num2 = (float)4.1233;
		int num = num1.compareTo(num2);
		Float s = num2 - num1;
		System.out.println((float)(Math.round(s*100))/100);
		System.out.println("num====="+num);
		
	}

}
