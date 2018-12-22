/*
 * Powered By [dwz4j-framework]
 * Web Site: http://j-ui.com
 * Google Code: http://code.google.com/p/dwz4j/
 * Generated 2012-09-10 08:51:33 by code generator
 */
package com.git.business.sys;

import java.util.Date;

import com.git.db.beans.SysUser;
import com.git.enums.Gender;

import dwz.framework.sys.business.AbstractBusinessObject;
import dwz.framework.sys.lang.enums.EnumUtils;

public class User extends AbstractBusinessObject {
	private static final long serialVersionUID = 1L;
	private SysUser sysUser;

	/* generateConstructor */
	public User() {
		this.sysUser = new SysUser();		
	}

	public User(SysUser sysUser) {
		this.sysUser = sysUser;
	}

	public SysUser getSysUser() {
		return this.sysUser;
	}

	public Long getId() {
		return this.sysUser.getUserId();
	}
	
	public void setId(Long userId) {
		this.sysUser.setUserId(userId);
	}
	
	public String getUserNo() {
        return this.sysUser.getUserNo();
    }

    public void setUserNo(String userNo) {
        this.sysUser.setUserNo(userNo);
    }
        
    public String getUserCode() {
        return this.sysUser.getUserCode();
    }

    public void setUserCode(String userCode) {
    	this.sysUser.setUserCode(userCode) ;
    }

    public String getUserPwd() {
        return this.sysUser.getUserPwd();
    }

    public void setUserPwd(String userPwd) {
        this.sysUser.setUserPwd(userPwd);
    }

    public String getName() {
        return this.sysUser.getName();
    }

    public void setName(String name) {
        this.sysUser.setName(name);
    }
	

	public Gender getGender() {
		if (EnumUtils.isDefined(Gender.values(), sysUser.getGender()))
			return Gender.valueOf(sysUser.getGender());

		return null;
	}

	public void setGender(Gender gender) {
		if (gender != null)
			sysUser.setGender(gender.toString());
	}

	public String getEmail() {
		return this.sysUser.getEmail();
	}

	public void setEmail(String email) {
		this.sysUser.setEmail(email);
	}

	public String getPhone() {
		return this.sysUser.getPhone();
	}

	public void setPhone(String phone) {
		this.sysUser.setPhone(phone);
	}
	
	/*
	public UserStatus getUserStatus() {
        return ExtEnumUtils.getRequiredByCode(Integer.valueOf(sysUser.getUserStatus()), UserStatus.values());        		
    }*/
	
	public String getUserStatus(){
		return this.sysUser.getUserStatus();
	}

    public void setUserStatus(String userStatus) {
        this.sysUser.setUserStatus(String.valueOf(userStatus));
    }

    public String getExtend1() {
		return this.sysUser.getExtend1();
	}

	public void setExtend1(String extend1) {
		this.sysUser.setExtend1(extend1);
	}
	
	public String getExtend2() {
		return this.sysUser.getExtend2();
	}

	public void setExtend2(String extend2) {
		this.sysUser.setExtend2(extend2);
	}
	
	public String getExtend3() {
		return this.sysUser.getExtend3();
	}

	public void setExtend3(String extend3) {
		this.sysUser.setExtend3(extend3);
	}
	
	public Long getOrgId() {
        return this.sysUser.getOrgId();
    }

    public void setOrgId(Long orgId) {
        this.sysUser.setOrgId(orgId);
    }
    
    public Date getCreateTime() {
        return this.sysUser.getCreateTime();
    }

    public void setCreateTime(Date createTime) {
        this.sysUser.setCreateTime(createTime);
    }

    public Long getModifyOperatorId() {
        return this.sysUser.getModifyOperatorId();
    }

    public void setModifyOperatorId(Long modifyOperatorId) {
        this.sysUser.setModifyOperatorId(modifyOperatorId);
    }

    public Date getModifyTime() {
        return this.sysUser.getModifyTime();
    }

    public void setModifyTime(Date modifyTime) {
        this.sysUser.setModifyTime(modifyTime);
    }

    public Long getOperatorId() {
        return this.sysUser.getOperatorId();
    }

    public void setOperatorId(Long operatorId) {
        this.sysUser.setOperatorId(operatorId);
    }
    
    public String getOrgName() {
        return this.sysUser.getOrgName();
    }

    public void setOrgName(String orgName) {
        this.sysUser.setOrgName(orgName == null ? null : orgName.trim());
    }

    public String getsName() {
        return this.sysUser.getsName();
    }

    public void setsName(String sName) {
        this.sysUser.setsName(sName == null ? null : sName.trim());
    }

    public String getEnName() {
        return this.sysUser.getEnName();
    }

    public void setEnName(String enName) {
        this.sysUser.setEnName(enName == null ? null : enName.trim());
    }
    
    public String getOrgCode() {
		return this.sysUser.getOrgCode();
	}

	public void setOrgCode(String orgCode) {
		this.sysUser.setOrgCode(orgCode);
	}
    
}
