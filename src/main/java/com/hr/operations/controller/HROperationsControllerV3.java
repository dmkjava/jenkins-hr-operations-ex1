package com.hr.operations.controller;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hr.operations.models.Employee;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/hr-operations")  
public class HROperationsControllerV3 {
	Logger logger = LoggerFactory.getLogger(HROperationsControllerV3.class);
	List<Employee> empsList; 
	
	HROperationsControllerV3(){
		Employee e1 = new Employee(101, "Anil", "Business Analyst", 56000, "7788994411", "anil@gmail.com");
		Employee e2 = new Employee(102, "Bharath", "Manager", 96000, "7788994422", "bharath@gmail.com");
		Employee e3 = new Employee(103, "Chandu", "Clerk", 26000, "7788994433", "chandu@gmail.com");
		
		empsList = new ArrayList<Employee>();
		empsList.add(e1);
		empsList.add(e2);
		empsList.add(e3);
		
	}
	@GetMapping
	String welcome() {
		return "Welcome to HR-Operations Application";
	}
	@GetMapping("/get-all-employees")
	List<Employee> getAllEmployees(HttpServletRequest request){
		logger.info("Hi, I am from getAllEmployees");
		logger.info(request.getMethod());
		
		return empsList;
	}
	
	@GetMapping("/get-employee-by-id/{id}")
	Employee getEmployeeById(HttpServletRequest request, @PathVariable int id){
		System.out.println("Hi, I am from getEmployeeById "+ id);
		logger.info("Hi, I am from getEmployeeById: "+ id);
		logger.info(request.getMethod());
		
		for (Employee e : empsList) {
			if(e.getEmpId() ==  id)
				return e;
		}
		throw new NullPointerException ("Employee Not found with given id: "+ id);
	}
	@PostMapping("/create-employee")
	Employee createEmployee(HttpServletRequest request, @RequestBody Employee emp){
		System.out.println("Hi, I am from createEmployee");
		logger.info("Hi, I am from createEmployee");
		logger.info(request.getParameter("empName"));
		Enumeration  paramNames = request.getParameterNames();
		while(paramNames.hasMoreElements()) {
			logger.info(paramNames.nextElement().toString());
		}
		logger.info(request.getMethod());
		logger.info(emp.toString());
		empsList.add(emp);
		return emp;
	}
	@PutMapping("/update-employee/{id}")
	Employee updateEmployee(HttpServletRequest request, @PathVariable int id, @RequestBody Employee emp){
		System.out.println("Hi, I am from updateEmployee");
		logger.info("Hi, I am from updateEmployee");
		logger.info(request.getMethod());
		if(id != emp.getEmpId()) {
			throw new RuntimeException("Invalid Employee Id: "+id);
		}
		ListIterator<Employee> liItr = empsList.listIterator();
		while(liItr.hasNext()) {
			Employee e1 = liItr.next();
			if(e1.getEmpId() == id) {
				liItr.remove();
				liItr.add(emp);
				return emp;
			}
		}
		throw new NullPointerException ("Employee Not found with given id: "+ id);
	}
	@DeleteMapping("/delete-employee/{id}")
	Employee deleteEmployee(HttpServletRequest request, @PathVariable int id){
		System.out.println("Hi, I am from deleteEmployee: "+ id);
		logger.info("Hi, I am from deleteEmployee "+ id);
		logger.info(request.getMethod());
		ListIterator<Employee> liItr = empsList.listIterator();
		while(liItr.hasNext()) {
			Employee e1 = liItr.next();
			if(e1.getEmpId() == id) {
				liItr.remove();
				return e1;
			}
		}
		throw new NullPointerException ("Employee Not found with given id: "+ id);
	}

}
