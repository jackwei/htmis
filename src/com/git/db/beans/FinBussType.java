package com.git.db.beans;

import java.io.Serializable;

public class FinBussType implements Serializable {
    private String bussId;

    private String bussName;

    private String remark;

    private String distillSql;

    private static final long serialVersionUID = 1L;

    public String getBussId() {
        return bussId;
    }

    public void setBussId(String bussId) {
        this.bussId = bussId == null ? null : bussId.trim();
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName == null ? null : bussName.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDistillSql() {
        return distillSql;
    }

    public void setDistillSql(String distillSql) {
        this.distillSql = distillSql == null ? null : distillSql.trim();
    }
}