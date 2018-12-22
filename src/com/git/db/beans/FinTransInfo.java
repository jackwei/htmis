package com.git.db.beans;

import java.io.Serializable;

public class FinTransInfo extends FinTransInfoKey implements Serializable {
    private String itemName;

    private String distillMode;

    private String distillClass;

    private String distillSql;

    private static final long serialVersionUID = 1L;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName == null ? null : itemName.trim();
    }

    public String getDistillMode() {
        return distillMode;
    }

    public void setDistillMode(String distillMode) {
        this.distillMode = distillMode == null ? null : distillMode.trim();
    }

    public String getDistillClass() {
        return distillClass;
    }

    public void setDistillClass(String distillClass) {
        this.distillClass = distillClass == null ? null : distillClass.trim();
    }

    public String getDistillSql() {
        return distillSql;
    }

    public void setDistillSql(String distillSql) {
        this.distillSql = distillSql == null ? null : distillSql.trim();
    }
}