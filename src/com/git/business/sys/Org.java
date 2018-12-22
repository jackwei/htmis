/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package com.git.business.sys;

import java.util.Date;

import com.git.db.beans.SysGroup;
import com.git.enums.OrgLevel;
import com.git.enums.OrgType;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.business.BusinessFactory;
import dwz.framework.sys.lang.enums.EnumUtils;
import dwz.framework.sys.lang.enums.ExtEnumUtils;

public class Org extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private SysGroup sysGroup;

	/* generateConstructor */
	public Org() {
		this.sysGroup = new SysGroup();		
	}

	public Org(SysGroup sysGroup) {
		this.sysGroup = sysGroup;
	}

	public SysGroup getSysGroup() {
		return this.sysGroup;
	}

	public Long getId() {
		return this.sysGroup.getOrgId();
	}
	
	public void setId(Long orgId) {
		this.sysGroup.setOrgId(orgId);
	}
	
	public String getOrgCode() {
        return this.sysGroup.getOrgCode();
    }

    public void setOrgCode(String orgCode) {
        this.sysGroup.setOrgCode(orgCode);
    }
        
    public OrgLevel getOrgLevel() {
        return ExtEnumUtils.getRequiredByCode(sysGroup.getOrgLevel(), OrgLevel.values());
    }

    public void setOrgLevel(Integer orgLevel) {
    	this.sysGroup.setOrgLevel(orgLevel);
    }

    public OrgType getOrgType() {
    	if (EnumUtils.isDefined(OrgType.values(), sysGroup.getOrgType()))
			return OrgType.valueOf(sysGroup.getOrgType());
    	
    	return null;
    }

    public void setOrgType(OrgType orgType) {
    	if(orgType != null)
    	this.sysGroup.setOrgType(orgType.toString());
    }

    public Long getParentId() {
        return this.sysGroup.getParentId();
    }

    public void setParentId(Long parentId) {
    	this.sysGroup.setParentId(parentId);
    }
    
    public Org getOrg() {
		Long parentOrgId = getParentId();
		if (parentOrgId > 0) {
			OrgServiceMgr orgServiceMgr = BusinessFactory.getInstance()
					.getService(OrgServiceMgr.SERVICE_NAME);
			return orgServiceMgr.getOrg(parentOrgId);
		}
		return null;
	}

    public String getOrgSname() {
        return this.sysGroup.getOrgSname();
    }

    public void setOrgSname(String orgSname) {
    	this.sysGroup.setOrgSname(orgSname);
    }

    public String getOrgName() {
        return this.sysGroup.getOrgName();
    }

    public void setOrgName(String orgName) {
    	this.sysGroup.setOrgName(orgName);
    }

    public String getOrgEname() {
        return this.sysGroup.getOrgEname();
    }

    public void setOrgEname(String orgEname) {
    	this.sysGroup.setOrgEname(orgEname);
    }

    public String getLinkAddress() {
        return this.sysGroup.getLinkAddress();
    }

    public void setLinkAddress(String linkAddress) {
    	this.sysGroup.setLinkAddress(linkAddress);
    }

    public String getLinkPhone() {
        return this.sysGroup.getLinkPhone();
    }

    public void setLinkPhone(String linkPhone) {
    	this.sysGroup.setLinkPhone(linkPhone);
    }

    public String getFlag() {
        return this.sysGroup.getFlag();
    }

    public void setFlag(String flag) {
    	this.sysGroup.setFlag(flag);
    }

    public String getOrgStatus() {
        return this.sysGroup.getOrgStatus();
    }

    public void setOrgStatus(String orgStatus) {
    	this.sysGroup.setOrgStatus(orgStatus);
    }

    public Long getDeptManagerId() {
        return this.sysGroup.getDeptManagerId();
    }

    public void setDeptManagerId(Long deptManagerId) {
    	this.sysGroup.setDeptManagerId(deptManagerId);
    }

    public Long getDeptLeaderId() {
        return this.sysGroup.getDeptLeaderId();
    }

    public void setDeptLeaderId(Long deptLeaderId) {
    	this.sysGroup.setDeptLeaderId(deptLeaderId);
    }

    public Date getCreateTime() {
        return this.sysGroup.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
    	this.sysGroup.setCreateTime(createTime);
    }

    public Long getModifyOperatorId() {
        return this.sysGroup.getModifyOperatorId();
    }

    public void setModifyOperatorId(Long modifyOperatorId) {
    	this.sysGroup.setModifyOperatorId(modifyOperatorId);
    }

    public Date getModifyTime() {
        return this.sysGroup.getModifyTime();
    }

    public void setModifyTime(Date modifyTime) {
    	this.sysGroup.setModifyTime(modifyTime);
    }

    public Long getOperatorId() {
        return this.sysGroup.getOperatorId();
    }

    public void setOperatorId(Long operatorId) {
    	this.sysGroup.setOperatorId(operatorId);
    }

    public String getExtend1() {
		return this.sysGroup.getExtend1();
	}

	public void setExtend1(String extend1) {
		this.sysGroup.setExtend1(extend1);
	}
	
	public String getExtend2() {
		return this.sysGroup.getExtend2();
	}

	public void setExtend2(String extend2) {
		this.sysGroup.setExtend2(extend2);
	}
	
	public String getExtend3() {
		return this.sysGroup.getExtend3();
	}

	public void setExtend3(String extend3) {
		this.sysGroup.setExtend3(extend3);
	}
}
