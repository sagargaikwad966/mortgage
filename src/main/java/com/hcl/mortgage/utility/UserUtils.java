package com.hcl.mortgage.utility;

import java.time.LocalDate;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;

public class UserUtils 
{
	public static Integer calculateAge(LocalDate dob)
	{
		LocalDate currentDate = LocalDate.now();
		return currentDate.getYear() - dob.getYear();	
	}

	public static Double calculateEligibleLoanAmount(Double propertyValue) 
	{
		return ( propertyValue * 0.8 );
		
	}

}
