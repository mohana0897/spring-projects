package com.tcl.tclempservice.service;

import java.util.List;

import com.tcl.tclempservice.Dto.AddressDto;
import com.tcl.tclempservice.entities.Address;

public interface AddressServiceInterface {
	
	public Address saveAddress(Long id, AddressDto addressDto);
	
	public List<AddressDto> getAllAddress();
	
	public AddressDto updateAddress(AddressDto addressDto);
	
	public void deleteAddress(AddressDto dto);

}
