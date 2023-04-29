package com.tcl.tclempservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.tcl.tclempservice.Dto.EmployeeDto;
import com.tcl.tclempservice.entities.Employee;
import com.tcl.tclempservice.exceptions.EmployeeException;
import com.tcl.tclempservice.repository.EmployeeRepository;
import com.tcl.tclempservice.service.EmployeeServiceInterface;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	
	private static Logger logger= LoggerFactory.getLogger(EmpServiceImpl.class);
	
	@Override
	public Employee save(EmployeeDto emp) {
		
		Employee empl= modelMapper.map(emp, Employee.class);
		logger.debug("from service");
		
		try {
		
		return employeeRepository.save(empl);
		}catch (Exception e) {
throw new EmployeeException("Employee is already existed");

		}
	}

	@Override
	public void deleteemployee(Long id) {
	
		 employeeRepository.deleteById(id);
	}

	@Override
	public List<EmployeeDto> getallemp(int pageNo,int pageSize,String sortDir,String sortBy) {
		
		Sort sort=sortDir.equalsIgnoreCase(Sort.Direction.ASC.name() ) ? Sort.by(sortBy).ascending() :
			Sort.by(sortBy).descending();
		logger.debug("get method from service layer");
	Pageable pageable=	PageRequest.of(pageNo, pageSize, sort);
	List<EmployeeDto> empdtolist= new ArrayList<>();
	employeeRepository.findAll(pageable).getContent().forEach(emp->{
		EmployeeDto dto=modelMapper.map(emp, EmployeeDto.class);
		empdtolist.add(dto);});
	
	return empdtolist;}
	

	@Override
	public EmployeeDto updateemployee(Long id,EmployeeDto empdto) {
		Employee emp=	employeeRepository.findById(id).get();
		if(id.equals(emp.getId())) {
			emp.setName(empdto.getName());
//			emp.setEmailid(empdto.getEmailid());
//			emp.setGender(empdto.getGender());
//			emp.setAge(empdto.getAge());
//			emp.setMobilenumber(empdto.getMobilenumber());
//			emp.setAltmobilenumber(empdto.getAltmobilenumber());
			
		}
		Employee newemp=	employeeRepository.save(emp);
		
		
		return modelMapper.map(newemp,EmployeeDto.class );
	}
	
	public EmployeeDto getEmployeeById(Long id) {
		
		
		
		Employee emp = employeeRepository.findById(id).orElseThrow(()-> new EmployeeException("Employee doesn't exist"));
		
		return modelMapper.map(emp, EmployeeDto.class);
		
		
		
	}
	
	



}
