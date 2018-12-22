package com.git.db.beans;

public class SysDictType {
    private String dicttypeid;

    private String dicttypename;

    private String parentdicttypeid;

    private Integer sortno;

    private String backup1;

    public String getDicttypeid() {
        return dicttypeid;
    }

    public void setDicttypeid(String dicttypeid) {
        this.dicttypeid = dicttypeid == null ? null : dicttypeid.trim();
    }

    public String getDicttypename() {
        return dicttypename;
    }

    public void setDicttypename(String dicttypename) {
        this.dicttypename = dicttypename == null ? null : dicttypename.trim();
    }

    public String getParentdicttypeid() {
        return parentdicttypeid;
    }

    public void setParentdicttypeid(String parentdicttypeid) {
        this.parentdicttypeid = parentdicttypeid == null ? null : parentdicttypeid.trim();
    }

    public Integer getSortno() {
        return sortno;
    }

    public void setSortno(Integer sortno) {
        this.sortno = sortno;
    }

    public String getBackup1() {
        return backup1;
    }

    public void setBackup1(String backup1) {
        this.backup1 = backup1 == null ? null : backup1.trim();
    }
}