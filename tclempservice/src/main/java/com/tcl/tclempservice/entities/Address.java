package com.tcl.tclempservice.entities;

import java.math.BigInteger;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="address")
public class Address {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aid;
	private String address_typr;
	private String address;
	private String city;
	private String state;
	private BigInteger pincode;
	private String country;
	
//	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
//	@JoinColumn(name="id")
//	private Employee emp;
	
	public Address() {
		
	}

public Address(long aid, String address_typr, String address, String city, String state, BigInteger pincode,
		String country) {
	super();
	this.aid = aid;
	this.address_typr = address_typr;
	this.address = address;
	this.city = city;
	this.state = state;
	this.pincode = pincode;
	this.country = country;
}

public long getAid() {
	return aid;
}

public void setAid(long aid) {
	this.aid = aid;
}

public String getAddress_typr() {
	return address_typr;
}

public void setAddress_typr(String address_typr) {
	this.address_typr = address_typr;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public String getState() {
	return state;
}

public void setState(String state) {
	this.state = state;
}

public BigInteger getPincode() {
	return pincode;
}

public void setPincode(BigInteger pincode) {
	this.pincode = pincode;
}

public String getCountry() {
	return country;
}

public void setCountry(String country) {
	this.country = country;
}

@Override
public String toString() {
	return "Address [aid=" + aid + ", address_typr=" + address_typr + ", address=" + address + ", city=" + city
			+ ", state=" + state + ", pincode=" + pincode + ", country=" + country + "]";
}



	
	
	
	

}
