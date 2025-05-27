package com.hr.operations.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	private int empId; 
	private String empName; 
	private String job; 
	private double salary; 
	private String mobileNo; 
	private String emailId;
}
