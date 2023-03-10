package com.application.entity;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer cno;
	
	private String cname;
	private Integer mobileNO;
	private String location;
	

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@Version
	private Integer versionCount;

	public Integer getCno() {
		return cno;
	}

	public String getCname() {
		return cname;
	}

	public Integer getMobileNO() {
		return mobileNO;
	}

	public Integer getVersionCount() {
		return versionCount;
	}

	public void setCno(Integer cno) {
		this.cno = cno;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public void setMobileNO(Integer mobileNO) {
		this.mobileNO = mobileNO;
	}

	public void setVersionCount(Integer versionCount) {
		this.versionCount = versionCount;
	}

	@Override
	public String toString() {
		return "Customer [cno=" + cno + ", cname=" + cname + ", mobileNO=" + mobileNO + ", location=" + location
				+ ", versionCount=" + versionCount + "]";
	}

}
