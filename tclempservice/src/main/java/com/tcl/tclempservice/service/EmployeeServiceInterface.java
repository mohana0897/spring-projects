package com.tcl.tclempservice.service;

import java.util.List;

import com.tcl.tclempservice.Dto.EmployeeDto;
import com.tcl.tclempservice.entities.Employee;

public interface EmployeeServiceInterface {

	
	public Employee save(EmployeeDto emp);
	
	public void deleteemployee(Long id);
	
	public List<EmployeeDto> getallemp(int pageNo,int pageSize,String sortDir,String sortBy);
	

	public EmployeeDto updateemployee(Long id, EmployeeDto empdto);
	
	
}
