package com.git.db.beans;

import java.io.Serializable;
import java.util.Date;

public class TblConsignor implements Serializable {
    private Long oid;

    private String name;

    private String names;

    private String address;

    private String sort;

    private String country;

    private String area;

    private Long createoperatorid;

    private Long modifyoperatorid;

    private Date createtime;

    private Date modifytime;

    private String accountcode;

    private String currentcourse;

    private static final long serialVersionUID = 1L;

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names == null ? null : names.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort == null ? null : sort.trim();
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
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

    public String getAccountcode() {
        return accountcode;
    }

    public void setAccountcode(String accountcode) {
        this.accountcode = accountcode == null ? null : accountcode.trim();
    }

    public String getCurrentcourse() {
        return currentcourse;
    }

    public void setCurrentcourse(String currentcourse) {
        this.currentcourse = currentcourse == null ? null : currentcourse.trim();
    }
}