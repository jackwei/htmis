package com.git.business.finance;

import java.util.List;

import com.git.db.beans.FinData;
import com.git.db.beans.FinDataResult;
import com.git.util.MMap;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface CalFinItemServiceMgr extends BusinessObjectServiceMgr {
	
	public boolean dealFinItem(String bussType,MMap paramMap,int flag);
/*	public List<FinData> getUFList(String dealFlag);
	public List<FinDataResult> getFinDataResultByBatchNo();*/
}
