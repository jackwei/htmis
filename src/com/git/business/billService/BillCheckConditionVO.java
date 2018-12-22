package com.git.business.billService;

import com.git.db.BaseConditionVO;

public class BillCheckConditionVO extends BaseConditionVO {
	
	private String feenum ;
	
	private String feeamount_start ;
	
	private String feeamount_end ;
	
	private String payername ;
	
	private String printBill ;
	
	public String getFeenum() {
		return feenum;
	}
	public void setFeenum(String feenum) {
		this.feenum = feenum;
	}
	public String getFeeamount_start() {
		return feeamount_start;
	}
	public void setFeeamount_start(String feeamount_start) {
		this.feeamount_start = feeamount_start;
	}
	public String getFeeamount_end() {
		return feeamount_end;
	}
	public void setFeeamount_end(String feeamount_end) {
		this.feeamount_end = feeamount_end;
	}
	public String getPayername() {
		return payername;
	}
	public void setPayername(String payername) {
		this.payername = payername;
	}
	public String getPrintBill() {
		return printBill;
	}
	public void setPrintBill(String printBill) {
		this.printBill = printBill;
	}

	

}
