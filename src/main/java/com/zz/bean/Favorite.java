package com.zz.bean;

import java.util.Date;

public class Favorite  {
    private Date date;

    private Integer rid;

    private Integer uid;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Favorite() {
    }

    public Favorite(Date date, Integer rid, Integer uid) {
        this.date = date;
        this.rid = rid;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "date=" + date +
                ", rid=" + rid +
                ", uid=" + uid +
                '}';
    }
}