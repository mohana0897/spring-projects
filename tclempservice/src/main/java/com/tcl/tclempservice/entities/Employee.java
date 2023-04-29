package com.tcl.tclempservice.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employee")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private short age;
	@Column(nullable = false)
	private char gender;
	private String mobilenumber;
	private String altmobilenumber;
	private Double salary;
    @Column(nullable = false,unique = true)
	private String emailid;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<Address> addresslist;

	public Employee(long id, String name, short age, char gender, String mobilenumber, String altmobilenumber,
			Double salary, String emailid, List<Address> addresslist) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.mobilenumber = mobilenumber;
		this.altmobilenumber = altmobilenumber;
		this.salary = salary;
		this.emailid = emailid;
		this.addresslist = addresslist;
	}

	public Employee() {
		super();
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

	public List<Address> getAddresslist() {
		return addresslist;
	}

	public void setAddresslist(List<Address> addresslist) {
		this.addresslist = addresslist;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", mobilenumber="
				+ mobilenumber + ", altmobilenumber=" + altmobilenumber + ", salary=" + salary + ", emailid=" + emailid
				+ ", addresslist=" + addresslist + "]";
	}
	
	
	

	
	
	
	

}
