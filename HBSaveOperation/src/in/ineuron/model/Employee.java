package in.ineuron.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Employee {

	
	private Integer empId;
	
	
	private String empName;
	

	private Double empSal;

	
	static {
		System.out.println("CLass Loading..");
	}
	
	public Employee() {
		System.out.println("Zero argument constructor");
	}
	
	public void setEmpId(Integer empId) {
		System.out.println("Settin id value");
		this.empId = empId;
		
	}

	public void setEmpName(String empName) {
		this.empName = empName;
		System.out.println("Setting name value");
	}

	public void setEmpSal(Double empSal) {
		this.empSal = empSal;
		System.out.println("Setting sal value");
	}

	public Integer getEmpId() {
		return empId;
	}

	public String getEmpName() {
		return empName;
	}

	public Double getEmpSal() {
		return empSal;
	}

	
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSal=" + empSal + "]";
	}

	
}
