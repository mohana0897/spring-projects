package com.tcl.tclempservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcl.tclempservice.entities.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

}
