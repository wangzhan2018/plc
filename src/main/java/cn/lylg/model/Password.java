package cn.lylg.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;
import java.sql.Date;

public class Password implements Serializable {
    /**
     * `password`.pid
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private Integer pid;

    /**
     * `password`.cid
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private Integer cid;

    /**
     * `password`.ppassword
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String ppassword;

    /**
     * `password`.psdate
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private Date psdate;

    /**
     * `password`.ptimes
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private Integer ptimes=0;

    /**
     * `password`.ptype
     * @ibatorgenerated 2015-06-18 22:44:15
     */
    private String ptype;
    
    private String pgroup;
     
    private String state;

    public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPgroup() {
		return pgroup;
	}

	public void setPgroup(String pgroup) {
		this.pgroup = pgroup;
	}

	private Customer customerCid;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getPpassword() {
        return ppassword;
    }

    public void setPpassword(String ppassword) {
        this.ppassword = ppassword;
    }

    public Date getPsdate() {
        return psdate;
    }

    public void setPsdate(Date psdate) {
        this.psdate = psdate;
    }

    public Integer getPtimes() {
        return ptimes;
    }

    public void setPtimes(Integer ptimes) {
        this.ptimes = ptimes;
    }

    public String getPtype() {
        return ptype;
    }

    public void setPtype(String ptype) {
        this.ptype = ptype;
    }
    @JsonBackReference
    public void setCustomerCid(Customer customerCid) {
        this.customerCid=customerCid;
    }

    public Customer getCustomerCid() {
        return customerCid;
    }

	@Override
	public String toString() {
		return "Password [pid=" + pid + ", cid=" + cid + ", ppassword="
				+ ppassword + ", psdate=" + psdate + ", ptimes=" + ptimes
				+ ", ptype=" + ptype + ", pgroup=" + pgroup + ", customerCid="
				+ customerCid + "]";
	}
    
    
}