package com.hcl.mortgage.utility;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.hcl.mortgage.entity.LoanOffer;

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

	public static String getString(List<LoanOffer> offerList) {
		
		String result = "";
		for(LoanOffer offer : offerList)
		{
			result = result + offer + "\n";
		}
		return result;
	}

}
