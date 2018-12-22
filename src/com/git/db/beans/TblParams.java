package com.git.db.beans;

import java.util.Date;

public class TblParams {
    private Long oid;

    private String biztype;

    private String biztypename;

    private String paramtype;

    private String paramtexta;

    private String paramtextb;

    private Long createoperatorid;

    private Long modifyoperatorid;

    private Date createtime;

    private Date modifytime;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getBiztype() {
        return biztype;
    }

    public void setBiztype(String biztype) {
        this.biztype = biztype == null ? null : biztype.trim();
    }

    public String getBiztypename() {
        return biztypename;
    }

    public void setBiztypename(String biztypename) {
        this.biztypename = biztypename == null ? null : biztypename.trim();
    }

    public String getParamtype() {
        return paramtype;
    }

    public void setParamtype(String paramtype) {
        this.paramtype = paramtype == null ? null : paramtype.trim();
    }

    public String getParamtexta() {
        return paramtexta;
    }

    public void setParamtexta(String paramtexta) {
        this.paramtexta = paramtexta == null ? null : paramtexta.trim();
    }

    public String getParamtextb() {
        return paramtextb;
    }

    public void setParamtextb(String paramtextb) {
        this.paramtextb = paramtextb == null ? null : paramtextb.trim();
    }

    public Long getCreateoperatorid() {
        return createoperatorid;
    }

    public void setCreateoperatorid(Long createoperatorid) {
        this.createoperatorid = createoperatorid;
    }

    public Long getModifyoperatorid() {
        return modifyoperatorid;
    }

    public void setModifyoperatorid(Long modifyoperatorid) {
        this.modifyoperatorid = modifyoperatorid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getModifytime() {
        return modifytime;
    }

    public void setModifytime(Date modifytime) {
        this.modifytime = modifytime;
    }
}