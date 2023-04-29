package com.tcl.tclempservice.empcontroller;

import java.util.List;

import com.tcl.tclempservice.EmpFilterSearchService;
import com.tcl.tclempservice.Dto.EmployeeDto;
import com.tcl.tclempservice.Dto.EmployeeFilterSearch;
import com.tcl.tclempservice.Dto.FilterSearch;
import com.tcl.tclempservice.entities.Employee;
import com.tcl.tclempservice.serviceImpl.EmpServiceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tcl/api")
public class EmployeeController {

	@Autowired
	private EmpServiceImpl empServiceImpl;

	@Autowired
	private EmpFilterSearchService empFilterSearchService;
	
	
	private static Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	

	@PostMapping("/employees")
	public ResponseEntity<?> saveEmployee(@Validated @RequestBody EmployeeDto emp) {
		
		logger.debug("zjfdgjskgfvjsgvj");

		System.out.println(".........." + emp);

		return new ResponseEntity<Employee>(empServiceImpl.save(emp), HttpStatus.CREATED);

	}

	@DeleteMapping("/employees/{id}")
	public ResponseEntity<?> deleteemployee(@RequestParam Long id) {

		empServiceImpl.deleteemployee(id);

		return new ResponseEntity<String>("emp is succesfully deleted", HttpStatus.OK);
	}

	@GetMapping("/employees")
	public ResponseEntity<?> getAllemp(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
			@RequestParam(value = "pageSize", defaultValue = "2", required = false) int pageSize,
			@RequestParam(value = "sortDir", defaultValue = "asc", required = false) String sortDir,
			@RequestParam(value = "sortBy", defaultValue = "id", required = false) String sortBy) {
		
		logger.debug("Log File");
		
		
		return new ResponseEntity<List<EmployeeDto>>(empServiceImpl.getallemp(pageNo, pageSize, sortDir, sortBy),
				HttpStatus.OK);
		
		
		
		
	}

	@PutMapping("/employees/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDto emp) {

		return new ResponseEntity<EmployeeDto>(empServiceImpl.updateemployee(id, emp), HttpStatus.OK);
	}

	@GetMapping("employees/{column}/{value}")
	public ResponseEntity<?> allEmployeesByColumnAndValue(@PathVariable("column") String column,
			@PathVariable("value") String value) {

		List<Employee> empList = empFilterSearchService.getSpecification(column, value);
		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

	}

	@PostMapping("employees/fetch")
	public ResponseEntity<?> getAllEmpByGivenColumn(@RequestBody FilterSearch filterSearch) {
		List<Employee> empList = empFilterSearchService.getSpecification(filterSearch.getColumn(),
				filterSearch.getValue());

		return new ResponseEntity<List<Employee>>(empList, HttpStatus.OK);

	}

	@GetMapping("employee/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable Long id) {

		return new ResponseEntity<EmployeeDto>(empServiceImpl.getEmployeeById(id), HttpStatus.OK);

	}
	
	
	@PostMapping("/employee/list")
	public ResponseEntity<?> getAllEmpListByGivenColumnsAndValues(@RequestBody List<FilterSearch> dtoList){
		
		return new ResponseEntity<List<FilterSearch>>(empFilterSearchService.getSpecification(dtoList), HttpStatus.OK);
		
	}
	
	
	
//	@PostMapping("/employee/filterlist")
//	public ResponseEntity<?> getAllEmpListByColumnValueAndOperators(@RequestBody EmployeeFilterSearch employeeFilterSearch){
//		
//		return new ResponseEntity<List<FilterSearch>>(empFilterSearchService.getSpecs(employeeFilterSearch), HttpStatus.OK);
//		
//	}
	
	
	@PostMapping("/employee/filterlist")
	public ResponseEntity<?> getAllEmpListByColumnValueAndOperators(@RequestBody EmployeeFilterSearch requestSearchDto){
		
		return new ResponseEntity<List<EmployeeFilterSearch>>(empFilterSearchService.getSpecificationsByOperaors(requestSearchDto), HttpStatus.OK);
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
