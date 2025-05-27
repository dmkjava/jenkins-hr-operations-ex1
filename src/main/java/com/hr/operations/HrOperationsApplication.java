package com.hr.operations;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HrOperationsApplication { 

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(HrOperationsApplication.class, args); 
		
	} 

}
