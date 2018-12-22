package com.git.business.caseService;

import com.git.db.BaseConditionVO;

public class CaseConditionVO extends BaseConditionVO {
	
	private String casenumber;
	
	private String shipname;
	
	private String excasenumber;
	
	private String consignorsn;
	
	private String billstatus;
	
	private String casestatus;
	
	private String thirdpart;

	public String getCasenumber() {
		return casenumber;
	}

	public void setCasenumber(String casenumber) {
		this.casenumber = casenumber;
	}

	public String getShipname() {
		return shipname;
	}

	public void setShipname(String shipname) {
		this.shipname = shipname;
	}

	public String getExcasenumber() {
		return excasenumber;
	}

	public void setExcasenumber(String excasenumber) {
		this.excasenumber = excasenumber;
	}

	public String getConsignorsn() {
		return consignorsn;
	}

	public void setConsignorsn(String consignorsn) {
		this.consignorsn = consignorsn;
	}

	public String getBillstatus() {
		return billstatus;
	}

	public void setBillstatus(String billstatus) {
		this.billstatus = billstatus;
	}

	public String getCasestatus() {
		return casestatus;
	}

	public void setCasestatus(String casestatus) {
		this.casestatus = casestatus;
	}

	public String getThirdpart() {
		return thirdpart;
	}

	public void setThirdpart(String thirdpart) {
		this.thirdpart = thirdpart;
	}
	
	
	

}
