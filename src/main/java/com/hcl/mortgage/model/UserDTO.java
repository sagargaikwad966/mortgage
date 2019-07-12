package com.hcl.mortgage.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;



public class UserDTO {
	
	@NotNull@NotBlank
	private String userName;
	
	@NotNull@NotBlank
	@Length(min = 10, max = 10)
	private String phone;
	
	@NotNull@NotBlank
	private LocalDate dob;
	
	@NotNull@NotBlank
	private String email;
	
	@NotNull@NotBlank
	@Length(min = 10, max = 10)
	private String pan;
	
	@NotNull@NotBlank
	private String gender;
	
	@NotNull@NotBlank
	private Double salary;
	
	@NotNull@NotBlank
	private String propertyType;
	
	@NotNull@NotBlank
	private String propertyAddress;
	
	@NotNull@NotBlank
	private String propertyPincode;
	
	@NotNull@NotBlank
	private Double propertyArea;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public String getPropertyPincode() {
		return propertyPincode;
	}

	public void setPropertyPincode(String propertyPincode) {
		this.propertyPincode = propertyPincode;
	}

	public Double getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(Double propertyArea) {
		this.propertyArea = propertyArea;
	}

	
}
