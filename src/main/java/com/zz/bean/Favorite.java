package com.zz.bean;

import java.util.Date;

public class Favorite {
    private int fid;

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

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public Favorite() {
    }

    public Favorite(int fid, Date date, Integer rid, Integer uid) {
        this.fid = fid;
        this.date = date;
        this.rid = rid;
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Favorite{" +
                "fid=" + fid +
                ", date=" + date +
                ", rid=" + rid +
                ", uid=" + uid +
                '}';
    }
}