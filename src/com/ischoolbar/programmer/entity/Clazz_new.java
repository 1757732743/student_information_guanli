package com.ischoolbar.programmer.entity;

public class Clazz_new {
    /**
     * �༶id
     */
    private Integer cid;
    /**
     * �༶��
     */
    private String cname;
    /**
     * רҵid
     */
    private Integer mid;
    /**
     * רҵ��
     */
    private String mname;
    /**
     * ��ע
     */
    private String cremark;

    public Clazz_new() {
    }

    public Clazz_new(Integer cid, String cname, Integer mid, String mname, String cremark) {
        this.cid = cid;
        this.cname = cname;
        this.mid = mid;
        this.mname = mname;
        this.cremark = cremark;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getCremark() {
        return cremark;
    }

    public void setCremark(String cremark) {
        this.cremark = cremark;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", mid=" + mid +
                ", mname='" + mname + '\'' +
                ", cremark='" + cremark + '\'' +
                '}';
    }
}
