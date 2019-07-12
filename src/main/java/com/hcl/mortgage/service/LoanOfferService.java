package com.hcl.mortgage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.LoanOffer;
import com.hcl.mortgage.repository.LoanOfferRepository;

@Service
public class LoanOfferService 
{

	@Autowired
	LoanOfferRepository loanOfferRepository;
	
	public List<LoanOffer> fetchOffers(Double eligibleLoanAmount) throws Exception 
	{
		Optional<List<LoanOffer>> optionalListOfLoanOffer = loanOfferRepository.findByLoanAmountIsLessThanEqual(eligibleLoanAmount);

		boolean isPresentListOfLoanOffer = optionalListOfLoanOffer.isPresent();
		
		if(isPresentListOfLoanOffer)
		{
			List<LoanOffer> list = optionalListOfLoanOffer.get();
			return optionalListOfLoanOffer.get();
		}
			
		else
			throw new Exception("No Loan Offer found for you ");
	}
	

}
