package com.hcl.mortgage.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USER")
public class User 
{
	@Id
	@Column(name = "USER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	
	@Column(name = "USER_NAME", nullable = false)
	private String userName;
	
	@Column(name = "PHONE", nullable = false, length = 10)
	private String phone;
	
	@Column(name = "DOB", nullable = false)
	private LocalDate dob;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@Column(name = "PAN", nullable = false)
	private String pan;
	
	@Column(name = "GENDER", nullable = false)
	private String gender;
	
	@Column(name = "SALARY", nullable = false)
	private Double salary;
	
	@Column(name = "PROPERTY_TYPE", nullable = false)
	private String propertyType;
	
	@Column(name = "PROPERTY_ADDRESS", nullable = false)
	private String propertyAddress;
	
	@Column(name = "PROPERTY_PINCODE", nullable = false)
	private String propertyPincode;
	
	@Column(name = "PROPERTY_AREA", nullable = false)
	private Double propertyArea;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

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
