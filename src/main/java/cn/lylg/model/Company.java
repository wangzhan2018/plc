package cn.lylg.model;

import java.io.Serializable;

public class Company implements Serializable {
    /**
     * company.uid
     * @ibatorgenerated 2015-06-18 22:44:14
     */
    private Integer uid;

    /**
     * company.uname
     * @ibatorgenerated 2015-06-18 22:44:14
     */
    private String uname;

    /**
     * company.upassword
     * @ibatorgenerated 2015-06-18 22:44:14
     */
    private String upassword;

    /**
     * company.uphone
     * @ibatorgenerated 2015-06-18 22:44:14
     */
    private String uphone;

    /**
     * company.uemail
     * @ibatorgenerated 2015-06-18 22:44:14
     */
    private String uemail;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getUphone() {
        return uphone;
    }

    public void setUphone(String uphone) {
        this.uphone = uphone;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }
}