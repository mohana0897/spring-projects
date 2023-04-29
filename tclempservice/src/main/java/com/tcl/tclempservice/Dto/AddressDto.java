package com.tcl.tclempservice.Dto;

import java.math.BigInteger;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class AddressDto {
	
	private long aid;
	@NotBlank(message = "enter valid addresstype")
	@NotEmpty(message = "enter valid addresstype")
	private String address_typr;
	private String address;
	@NotBlank(message = "enter valid city")
	@NotEmpty(message = "enter valid city")
	private String city;
	private String state;
	@NotBlank(message = "enter valid pincode")
	@NotEmpty(message = "enter valid pincode")
	private BigInteger pincode;
	private String country;
	
	public AddressDto() {
		
	}
	
	public AddressDto(long aid,
			@NotBlank(message = "enter valid addresstype") @NotEmpty(message = "enter valid addresstype") String address_typr,
			String address, @NotBlank(message = "enter valid city") @NotEmpty(message = "enter valid city") String city,
			String state,
			@NotBlank(message = "enter valid pincode") @NotEmpty(message = "enter valid pincode") BigInteger pincode,
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
		return "AddressDto [aid=" + aid + ", address_typr=" + address_typr + ", address=" + address + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + ", country=" + country + "]";
	}
	
	

}
