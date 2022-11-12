package com.example.Employee.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class EmployeeDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="emp_id")
	private int empID;
	@Column(name="name")
	private String emp_name;
	@Column(name="designation")
	private String emp_designation;
	@Column(name="salary")
	private float salary;
	@Column(name="doj")
	private Date emp_doj;
	
	@ManyToOne
    @JoinColumn(name = "c_id")
    private Company company;
	
	public EmployeeDetails() {
		
	}
	
	@Override
	public String toString() {
		return "Employee_details [empID=" + empID + ", emp_name=" + emp_name + ", emp_designation=" + emp_designation
				+ ", salary=" + salary + ", emp_doj=" + emp_doj + "]";
	}
	public EmployeeDetails(int empID, String emp_name, String emp_designation, float salary, Date emp_doj, Company cmp) {
		super(); 
		this.empID = empID;
		this.emp_name = emp_name;
		this.emp_designation = emp_designation;
		this.salary = salary;
		this.emp_doj = emp_doj;
		this.company = cmp;
	}
	
	
	public int getEmpID() {
		return empID;
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	
	
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	
	
	public String getEmp_designation() {
		return emp_designation;
	}
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	
	
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	
	public Date getEmp_doj() {
		return emp_doj;
	}
	public void setEmp_doj(Date emp_doj) {
		this.emp_doj = emp_doj;
	}
	

}
