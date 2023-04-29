package com.tcl.tclempservice.empcontroller;

import com.tcl.tclempservice.Dto.AddressDto;
import com.tcl.tclempservice.entities.Address;
import com.tcl.tclempservice.serviceImpl.AddressServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tcl/api")
public class AddressController {

	@Autowired
	private AddressServiceImpl addressServiceImpl;
	
	@PostMapping("employee/{empId}/address")
	public ResponseEntity<?> saveAddress(@PathVariable Long empId, @RequestBody AddressDto addressDto){
		
		return new ResponseEntity<Address>(addressServiceImpl.saveAddress(empId, addressDto), HttpStatus.CREATED);
		
		
	}
	
	
}
