package com.git.business.process;


import java.util.Date;

import com.git.db.beans.TblDocInfos;

import dwz.framework.sys.business.AbstractBusinessObject;

/**
 * 附件
 * @author shona
 *
 */
public class DocInfos extends AbstractBusinessObject {

	private static final long serialVersionUID = 1L;
	private TblDocInfos tblDocInfos;
	
	public DocInfos(){
		this.tblDocInfos=new TblDocInfos();
	}
	public DocInfos(TblDocInfos tblDocInfos){
		this.tblDocInfos=tblDocInfos;
	}
	
	public TblDocInfos getTblDocInfos(){
		return this.tblDocInfos;
	}
	
	public Long getId() {
		return this.getTblDocInfos().getOid();
	}
	public void setId(Long oid) {
		this.getTblDocInfos().setOid(oid);
	}

    public Long getApplyid() {
        return this.getTblDocInfos().getApplyid();
    }

    public void setApplyid(Long applyid) {
        this.getTblDocInfos().setApplyid(applyid);
    }

    public String getDoctype() {
        return this.getTblDocInfos().getDoctype();
    }

    public void setDoctype(String doctype) {
        this.getTblDocInfos().setDoctype(doctype);
    }

    public String getDocname() {
        return this.getTblDocInfos().getDocname();
    }

    public void setDocname(String docname) {
       this.getTblDocInfos().setDocname(docname);
    }

    public String getDocdes() {
        return this.getTblDocInfos().getDocdes();
    }

    public void setDocdes(String docdes) {
       this.getTblDocInfos().setDocdes(docdes);
    }

    public String getUserid() {
        return this.getTblDocInfos().getUserid();
    }

    public void setUserid(String userid) {
        this.getTblDocInfos().setUserid(userid);
    }

    public String getUsername() {
        return this.getTblDocInfos().getUsername();
    }

    public void setUsername(String username) {
        this.getTblDocInfos().setUsername(username);
    }

    public Date getCreatedate() {
        return this.getTblDocInfos().getCreatedate();
    }

    public void setCreatedate(Date createdate) {
        this.getTblDocInfos().setCreatedate(createdate);
    }

    public String getFilename() {
        return this.getTblDocInfos().getFilename();
    }

    public void setFilename(String filename) {
        this.getTblDocInfos().setFilename(filename);
    }

    public String getFilelocation() {
        return this.getTblDocInfos().getFilelocation();
    }

    public void setFilelocation(String filelocation) {
        this.getTblDocInfos().setFilelocation(filelocation);
    }

    public String getSecretflag() {
        return this.getTblDocInfos().getSecretflag();
    }

    public void setSecretflag(String secretflag) {
       this.getTblDocInfos().setSecretflag(secretflag);
    }

    public String getContenttype() {
        return this.getTblDocInfos().getContenttype();
    }

    public void setContenttype(String contenttype) {
        this.getTblDocInfos().setContenttype(contenttype);
    }

    public String getParent2id() {
        return this.getTblDocInfos().getParent2id();
    }

    public void setParent2id(String parent2id) {
       this.getTblDocInfos().setParent2id(parent2id);
    }

    public String getParent2name() {
        return this.getTblDocInfos().getParent2name();
    }

    public void setParent2name(String parent2name) {
        this.getTblDocInfos().setParent2name(parent2name);
    }
}
