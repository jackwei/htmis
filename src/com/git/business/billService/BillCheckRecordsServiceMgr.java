package com.git.business.billService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.git.db.BaseConditionVO;
import com.git.db.beans.BillCheckImpl;
import com.git.db.beans.BillCheckRecordsImpl;
import com.git.db.beans.BillIncomeImpl;
import com.git.db.beans.CaseBillImpl;

import dwz.framework.sys.business.BusinessObjectServiceMgr;

public interface BillCheckRecordsServiceMgr extends BusinessObjectServiceMgr {

	public int updBillCheckRecords(BillCheckRecordsImpl billCheckRecordsImpl);
	
	public int addBillCheckRecords(BillCheckRecordsImpl billCheckRecordsImpl);

	public int getCount();
	
}