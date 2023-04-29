package com.tcl.tclempservice.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class EmployeeDto {
	
	private long id;
	
	
	@NotEmpty(message = "Enter valid name")
	@NotBlank(message = "Enter valid name")
	private String name;
	
	
	//@NotEmpty(message = "Enter valid age")
	//@NotBlank(message = "Enter valid age")
	private short age;
	
	
	//@NotEmpty(message = "Enter valid gender")
	//@NotBlank(message = "Enter valid gender")
	private char gender;
	
	
	@NotEmpty(message = "Enter valid num")
	@NotBlank(message = "Enter valid num")
	private String mobilenumber;
	
	
	private String altmobilenumber;
	
	private Double salary;
	
	
	@NotEmpty(message = "Enter valid email")
	@NotBlank(message = "Enter valid email")
	private String emailid;
	
	public EmployeeDto() {
		
	}
	
	

	public EmployeeDto(long id,
			@NotEmpty(message = "Enter valid name") @NotBlank(message = "Enter valid name") String name,
			@NotEmpty(message = "Enter valid age") @NotBlank(message = "Enter valid age") short age,
			@NotEmpty(message = "Enter valid gender") @NotBlank(message = "Enter valid gender") char gender,
			@NotEmpty(message = "Enter valid num") @NotBlank(message = "Enter valid num") String mobilenumber,
			String altmobilenumber, Double salary,
			@NotEmpty(message = "Enter valid email") @NotBlank(message = "Enter valid email") String emailid) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobilenumber = mobilenumber;
		this.altmobilenumber = altmobilenumber;
		this.salary = salary;
		this.emailid = emailid;
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public short getAge() {
		return age;
	}

	public void setAge(short age) {
		this.age = age;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getMobilenumber() {
		return mobilenumber;
	}

	public void setMobilenumber(String mobilenumber) {
		this.mobilenumber = mobilenumber;
	}

	public String getAltmobilenumber() {
		return altmobilenumber;
	}

	public void setAltmobilenumber(String altmobilenumber) {
		this.altmobilenumber = altmobilenumber;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Override
	public String toString() {
		return "EmployeeDto [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", mobilenumber="
				+ mobilenumber + ", altmobilenumber=" + altmobilenumber + ", salary=" + salary + ", emailid=" + emailid
				+ "]";
	}
	
	
	

}
