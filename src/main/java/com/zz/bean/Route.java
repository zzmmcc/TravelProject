package com.zz.bean;

public class Route {
    private Integer rid;

    private String rname;

    private Double price;

    private String routeintroduce;

    private String rflag;

    private String rdate;

    private String isthemetour;

    private Integer count;

    private Integer cid;

    private String rimage;

    private Integer sid;

    private String sourceid;

    public Route(Integer rid, String rname, Double price, String routeintroduce, String rflag, String rdate, String isthemetour, Integer count, Integer cid, String rimage, Integer sid, String sourceid) {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeintroduce = routeintroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.isthemetour = isthemetour;
        this.count = count;
        this.cid = cid;
        this.rimage = rimage;
        this.sid = sid;
        this.sourceid = sourceid;
    }

    public Route() {
        super();
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname == null ? null : rname.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRouteintroduce() {
        return routeintroduce;
    }

    public void setRouteintroduce(String routeintroduce) {
        this.routeintroduce = routeintroduce == null ? null : routeintroduce.trim();
    }

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag == null ? null : rflag.trim();
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate == null ? null : rdate.trim();
    }

    public String getIsthemetour() {
        return isthemetour;
    }

    public void setIsthemetour(String isthemetour) {
        this.isthemetour = isthemetour == null ? null : isthemetour.trim();
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage == null ? null : rimage.trim();
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSourceid() {
        return sourceid;
    }

    public void setSourceid(String sourceid) {
        this.sourceid = sourceid == null ? null : sourceid.trim();
    }
}