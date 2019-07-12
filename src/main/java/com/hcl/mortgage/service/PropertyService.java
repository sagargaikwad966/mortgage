package com.hcl.mortgage.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.PropertyRate;
import com.hcl.mortgage.exception.UserDataNotValidException;
import com.hcl.mortgage.repository.PropertyRateRepository;

/**
 * @author Sagar Gaikwad
 *
 */
@Service
public class PropertyService 
{
	@Autowired
	PropertyRateRepository propertyRateRepository;
	
	/**
	 * This method is used to calculate property Value
	 * @param propertyPincode to get property Pincode for user property
	 * @param propertyArea to get property area for user property in square feet
	 * @return Double This return property value of user property
	 * @exception UserDataNotValidException on Invalid Pincode entry
	 */
	public Double calculatePropertyValue(String propertyPincode, Double propertyArea) throws UserDataNotValidException 
	{
		PropertyRate propertyRate = null;
		Optional<PropertyRate> optionalPropertyRate = propertyRateRepository.findByPropertyPincode(propertyPincode);
		
		boolean isPresentPropertyRate = optionalPropertyRate.isPresent();
		
		if(isPresentPropertyRate) {
			propertyRate = optionalPropertyRate.get();
		} 
		else
		{
			throw new UserDataNotValidException("Invalid value entered : Property Pincode");
		}
		
		return (propertyRate.getSquareFeetRate() * propertyArea );
	}

}
