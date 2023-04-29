package com.ssd.empsystem.service;

import java.util.List;

import com.ssd.empsystem.model.Employee;
import com.ssd.empsystem.repositry.EmployeeRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
	
	
	@Autowired
	private EmployeeRepo employeeRepo;
	
	
	public Employee createEmployee(Employee emp) {
		
		return employeeRepo.save(emp);
		
	}
	
	
	public List<Employee> getAllEmployees(){
		
		return employeeRepo.findAll();
		
	}
	
	public Employee getEmployeeById(Long empId) {
		
		return employeeRepo.findOne(empId);
		
	}
	
	

}
