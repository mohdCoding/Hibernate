package com.application.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class InsurancePremiumPolicy {
	
	@Id
	private Integer policyId;

	private String policyName;

	private String policyType;

	private String company;

	private Integer tenure;

	public Integer getPolicyId() {
		return policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public String getPolicyType() {
		return policyType;
	}

	public String getCompany() {
		return company;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setPolicyId(Integer policyId) {
		this.policyId = policyId;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public String toString() {
		return "InsurancePolicy [policyId=" + policyId + ", policyName=" + policyName + ", policyType=" + policyType
				+ ", company=" + company + ", tenure=" + tenure + "]";
	}
}
