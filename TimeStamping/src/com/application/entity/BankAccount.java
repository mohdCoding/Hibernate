package com.application.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class BankAccount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer accountNo;
	
	private String accountHolderName;
	
	private Integer balance;
	
	@CreationTimestamp
	private LocalDateTime createdTime;
	
	@UpdateTimestamp
	private LocalDateTime modifiedTime;
	
	@Version
	private Integer versionNo;

	
	public Integer getAccountNo() {
		return accountNo;
	}


	public String getAccountHolderName() {
		return accountHolderName;
	}


	public Integer getBalance() {
		return balance;
	}


	public LocalDateTime getCreatedTime() {
		return createdTime;
	}


	public LocalDateTime getModifiedTime() {
		return modifiedTime;
	}


	public Integer getVersionNo() {
		return versionNo;
	}


	public void setAccountNo(Integer accountNo) {
		this.accountNo = accountNo;
	}


	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}


	public void setBalance(Integer balance) {
		this.balance = balance;
	}


	public void setCreatedTime(LocalDateTime createdTime) {
		this.createdTime = createdTime;
	}


	public void setModifiedTime(LocalDateTime modifiedTime) {
		this.modifiedTime = modifiedTime;
	}


	public void setVersionNo(Integer versionNo) {
		this.versionNo = versionNo;
	}


	@Override
	public String toString() {
		return "BankAccount [accountNo=" + accountNo + ", accountHolderName=" + accountHolderName + ", balance="
				+ balance + ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + ", versionNo="
				+ versionNo + "]";
	}
	
	
}
