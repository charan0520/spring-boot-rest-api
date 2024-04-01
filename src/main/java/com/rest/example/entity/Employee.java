package com.rest.example.entity;

import java.util.Date;

import com.rest.example.dto.EmployeeDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private Date dob;
	private String designation;
	private String phoneNumber;
	private String email;
	private String address;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Date getDob() {
		return dob;
	}
	
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Employee(Integer id, String firstName, String lastName, Date dob, String designation, String phoneNumber,
			String email, String address) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.designation = designation;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
	}

	public Employee() {
		super();
	}

	public EmployeeDTO convertToDTO()
	{
		return new EmployeeDTO(this.getId(),this.getFirstName()
				,this.getLastName(),this.getDob(),this.getDesignation(),
				this.getPhoneNumber(),this.getEmail(),this.getAddress());
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob
				+ ", designation=" + designation + ", phoneNumber=" + phoneNumber + ", email=" + email + ", address="
				+ address + "]";
	}
	
	
	
}
