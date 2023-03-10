package com.application.entity;

import javax.persistence.*;

@Entity
@Table(name="Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer eno;
   
	private String ename;

	private Integer esalary;
	
	private String email;
	
	private String addr;

	@Override
	public String toString() {
		return "Employee [eno=" + eno + ", ename=" + ename + ", esalary=" + esalary + ", email=" + email + ", addr="
				+ addr + "]";
	}

	/**
	public Integer getFno() {
		return fno;
	}

	public String getFname() {
		return fname;
	}

	public String getFrating() {
		return frating;
	}

	public void setFno(Integer fno) {
		this.fno = fno;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public void setFrating(String frating) {
		this.frating = frating;
	}
**/


}
