package com.zz.bean;

public class routeImg {
    private Integer rgid;

    private Integer rid;

    private String bigpic;

    private String smallpic;

    public routeImg(Integer rgid, Integer rid, String bigpic, String smallpic) {
        this.rgid = rgid;
        this.rid = rid;
        this.bigpic = bigpic;
        this.smallpic = smallpic;
    }

    public routeImg() {
        super();
    }

    public Integer getRgid() {
        return rgid;
    }

    public void setRgid(Integer rgid) {
        this.rgid = rgid;
    }

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public String getBigpic() {
        return bigpic;
    }

    public void setBigpic(String bigpic) {
        this.bigpic = bigpic == null ? null : bigpic.trim();
    }

    public String getSmallpic() {
        return smallpic;
    }

    public void setSmallpic(String smallpic) {
        this.smallpic = smallpic == null ? null : smallpic.trim();
    }

    @Override
    public String toString() {
        return "routeImg{" +
                "rgid=" + rgid +
                ", rid=" + rid +
                ", bigpic='" + bigpic + '\'' +
                ", smallpic='" + smallpic + '\'' +
                '}';
    }
}