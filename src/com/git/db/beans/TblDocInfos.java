package com.git.db.beans;

import java.util.Date;

public class TblDocInfos {
    private Long oid;

    private Long applyid;

    private String doctype;

    private String docname;

    private String docdes;

    private String userid;

    private String username;

    private Date createdate;

    private String filename;

    private String filelocation;

    private String secretflag;

    private String contenttype;

    private String parent2id;

    private String parent2name;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getApplyid() {
        return applyid;
    }

    public void setApplyid(Long applyid) {
        this.applyid = applyid;
    }

    public String getDoctype() {
        return doctype;
    }

    public void setDoctype(String doctype) {
        this.doctype = doctype == null ? null : doctype.trim();
    }

    public String getDocname() {
        return docname;
    }

    public void setDocname(String docname) {
        this.docname = docname == null ? null : docname.trim();
    }

    public String getDocdes() {
        return docdes;
    }

    public void setDocdes(String docdes) {
        this.docdes = docdes == null ? null : docdes.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename == null ? null : filename.trim();
    }

    public String getFilelocation() {
        return filelocation;
    }

    public void setFilelocation(String filelocation) {
        this.filelocation = filelocation == null ? null : filelocation.trim();
    }

    public String getSecretflag() {
        return secretflag;
    }

    public void setSecretflag(String secretflag) {
        this.secretflag = secretflag == null ? null : secretflag.trim();
    }

    public String getContenttype() {
        return contenttype;
    }

    public void setContenttype(String contenttype) {
        this.contenttype = contenttype == null ? null : contenttype.trim();
    }

    public String getParent2id() {
        return parent2id;
    }

    public void setParent2id(String parent2id) {
        this.parent2id = parent2id == null ? null : parent2id.trim();
    }

    public String getParent2name() {
        return parent2name;
    }

    public void setParent2name(String parent2name) {
        this.parent2name = parent2name == null ? null : parent2name.trim();
    }
}