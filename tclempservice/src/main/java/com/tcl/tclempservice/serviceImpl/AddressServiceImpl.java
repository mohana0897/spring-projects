package com.tcl.tclempservice.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.tcl.tclempservice.Dto.AddressDto;
import com.tcl.tclempservice.entities.Address;
import com.tcl.tclempservice.entities.Employee;
import com.tcl.tclempservice.exceptions.EmployeeException;
import com.tcl.tclempservice.repository.AddressRepository;
import com.tcl.tclempservice.repository.EmployeeRepository;
import com.tcl.tclempservice.service.AddressServiceInterface;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressServiceInterface {

	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	@Override
	public Address saveAddress(Long id, AddressDto addressDto) {
		
		Employee emp= employeeRepository.findById(id).orElseThrow(()-> new EmployeeException("Employee doesn't exist"));

		Address add = modelMapper.map(addressDto, Address.class);
		
		List<Address> addList= new ArrayList<>();
		
		addList.add(add);
		
		emp.setAddresslist(addList);
		
		try {
			
			return addressRepository.save(add);
			
		}catch(Exception e) {
			
			throw new EmployeeException("Address already existed ");
			
		}
		
		
	}

	@Override
	public List<AddressDto> getAllAddress() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AddressDto updateAddress(AddressDto addressDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAddress(AddressDto dto) {
		// TODO Auto-generated method stub
		
	}

	
	
	
}
