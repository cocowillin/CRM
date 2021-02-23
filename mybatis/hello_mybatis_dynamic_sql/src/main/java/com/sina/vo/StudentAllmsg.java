package com.sina.vo;

/**
 * @author radio
 * @create 2021-02-23 4:56 PM
 */
public class StudentAllmsg {
        //学生的信息
        private String sid;
        private String sname;
        private Integer age;
        //班级的所有信息
        private String cid;
        private String cname;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
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

    @Override
    public String toString() {
        return "StudentAllmsg{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", age=" + age +
                ", cid='" + cid + '\'' +
                ", cname='" + cname + '\'' +
                '}';
    }
}
