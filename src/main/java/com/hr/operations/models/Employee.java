package com.hr.operations.models;

public class Employee {
	private int empId; 
	private String empName; 
	private String job; 
	private double salary; 
	private String mobileNo; 
	private String emailId;
	public Employee() {
		
	}
	public Employee(int empId, String empName, String job, double salary, String mobileNo, String emailId) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.job = job;
		this.salary = salary;
		this.mobileNo = mobileNo;
		this.emailId = emailId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", job=" + job + ", salary=" + salary
				+ ", mobileNo=" + mobileNo + ", emailId=" + emailId + "]\n";
	}
	
	
}
