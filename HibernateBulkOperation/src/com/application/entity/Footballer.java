package com.application.entity;

import javax.persistence.*;

@Entity
@Table(name="Footballer")
public class Footballer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer fno;
   
	private String fname;

	private String frating;

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
	public String toString() {
		return "Footballer [fno=" + fno + ", fname=" + fname + ", frating=" + frating + "]";
	}

}
