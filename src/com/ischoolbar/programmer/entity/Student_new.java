package com.ischoolbar.programmer.entity;

public class Student_new {
    /**
     * ѧ��id
     */
    private Integer sid;
    /**
     * ѧ������
     */
    private String sname;
    /**
     * ѧ��
     */
    private String snum;
    /**
     * �Ա�
     */
    private String ssex;
    /**
     * ����
     */
    private Integer sage;
    /**
     * �༶id,���������Ϊstring����ʽ������ǣ����id,����Ƶ����ݿ�֮��Ĳ�����ϵ��û�б�Ҫ��ô��
     */
    //private Integer cid;
    private String cid;
    /**
     * �༶��
     */
    private String cname;
    /**
     * ״̬
     */
    private String sstatus;
    /**
     * ��ע
     */
    private String sremark;
    /**
     * ���֤��
     */
    private String idcard;
    /**
     * �ֻ���
     */
    private String phone;
    /**
     * ��ͥסַ
     */
    private String address;
    /**
     * ����ʱ��
     */
    private String entime;
    /**
     * ����
     */
    private String pswd;
    /**
     * ��Ƭ��ַ
     */
    private String pic;

    public Student_new() {
    }

    public Student_new(Integer sid, String sname, String snum, String ssex, Integer sage, String cid, String cname, String sstatus, String sremark, String idcard, String phone, String address, String entime, String pswd, String pic) {
        this.sid = sid;
        this.sname = sname;
        this.snum = snum;
        this.ssex = ssex;
        this.sage = sage;
        this.cid = cid;
        this.cname = cname;
        this.sstatus = sstatus;
        this.sremark = sremark;
        this.idcard = idcard;
        this.phone = phone;
        this.address = address;
        this.entime = entime;
        this.pswd = pswd;
        this.pic = pic;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSnum() {
        return snum;
    }

    public void setSnum(String snum) {
        this.snum = snum;
    }

    public String getSsex() {
        return ssex;
    }

    public void setSsex(String ssex) {
        this.ssex = ssex;
    }

    public Integer getSage() {
        return sage;
    }

    public void setSage(Integer sage) {
        this.sage = sage;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getSstatus() {
        return sstatus;
    }

    public void setSstatus(String sstatus) {
        this.sstatus = sstatus;
    }

    public String getSremark() {
        return sremark;
    }

    public void setSremark(String sremark) {
        this.sremark = sremark;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEntime() {
        return entime;
    }

    public void setEntime(String entime) {
        this.entime = entime;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sid=" + sid +
                ", sname='" + sname + '\'' +
                ", snum='" + snum + '\'' +
                ", ssex='" + ssex + '\'' +
                ", sage=" + sage +
                ", cid=" + cid +
                ", cname='" + cname + '\'' +
                ", sstatus='" + sstatus + '\'' +
                ", sremark='" + sremark + '\'' +
                ", idcard='" + idcard + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", entime='" + entime + '\'' +
                ", pswd='" + pswd + '\'' +
                ", pic='" + pic + '\'' +
                '}';
    }
}
