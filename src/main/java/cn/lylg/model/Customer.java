package cn.lylg.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;


public class Customer implements Serializable {
    /**
     * customer.cid
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private Integer cid;

    /**
     * customer.cname
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String cname;

    /**
     * customer.coname
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String coname;

    /**
     * customer.cophone
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String cophone;

    /**
     * customer.coaddress
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String coaddress;

    /**
     * customer.cotype
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String cotype;

    /**
     * customer.cosale
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String cosale;

    /**
     * customer.codate
     * @ibatorgenerated 2015-06-18 22:44:15
     */
  /*  @DateTimeFormat(pattern="yyyy-MM-dd")*/
    private Date codate;

    private Set<Password> passwordsCid = new HashSet(0);

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

    public String getConame() {
        return coname;
    }

    public void setConame(String coname) {
        this.coname = coname;
    }

    public String getCophone() {
        return cophone;
    }

    public void setCophone(String cophone) {
        this.cophone = cophone;
    }

    public String getCoaddress() {
        return coaddress;
    }

    public void setCoaddress(String coaddress) {
        this.coaddress = coaddress;
    }

    public String getCotype() {
        return cotype;
    }

    public void setCotype(String cotype) {
        this.cotype = cotype;
    }

    public String getCosale() {
        return cosale;
    }

    public void setCosale(String cosale) {
        this.cosale = cosale;
    }

    public Date getCodate() {
        return codate;
    }

    public void setCodate(Date codate) {
        this.codate = codate;
    }

    public void setPasswordsCid(Set passwordsCid) {
        this.passwordsCid=passwordsCid;
    }

    public Set<Password> getPasswordsCid() {
        return passwordsCid;
    }
}