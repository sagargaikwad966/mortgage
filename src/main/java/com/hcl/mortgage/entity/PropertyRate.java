package com.hcl.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PROPERTY_RATE")
public class PropertyRate 
{
	@Id
	@Column(name = "PROPERTY_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long propertyId;
	
	@Column(name = "PROPERTY_PINCODE", nullable = false)
	private String propertyPincode;
	
	@Column(name = "SQUARE_FEET_RATE", nullable = false)
	private Double squareFeetRate;

	public Long getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(Long propertyId) {
		this.propertyId = propertyId;
	}

	public String getPropertyPincode() {
		return propertyPincode;
	}

	public void setPropertyPincode(String propertyPincode) {
		this.propertyPincode = propertyPincode;
	}

	public Double getSquareFeetRate() {
		return squareFeetRate;
	}

	public void setSquareFeetRate(Double squareFeetRate) {
		this.squareFeetRate = squareFeetRate;
	}

	
}
