package com.ssd.empsystem.employeeController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssd.empsystem.model.Employee;
import com.ssd.empsystem.service.EmployeeService;

@Controller
@RequestMapping("employees")
public class EmployeeController {

	
	@Autowired
	EmployeeService empService;
	
	@GetMapping("employees")
	public ResponseEntity<?> getAllEmployees(){
		
		return new ResponseEntity<List<Employee>>(empService.getAllEmployees(), HttpStatus.OK);
		
	}
	
	public ResponseEntity<?> createEmployee(@RequestBody Employee emp){
		
		return new ResponseEntity<Employee>(empService.createEmployee(emp), HttpStatus.CREATED);
		
	}
	
	
}
