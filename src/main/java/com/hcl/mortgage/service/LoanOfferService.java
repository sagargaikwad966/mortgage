package com.hcl.mortgage.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.LoanOffer;
import com.hcl.mortgage.exception.UserDataNotValidException;
import com.hcl.mortgage.repository.LoanOfferRepository;

@Service
public class LoanOfferService 
{

	@Autowired
	LoanOfferRepository loanOfferRepository;
	/**
	 * This method is used to fetch the List of loan offers
	 * @param eligibleLoanAmount to get eligible Loan Amount for user
	 * @return List<LoanOffer> This return List of different offers depend on eligible loan amount
	 * @exception Exception on Loan entry not found
	 */
	public List<LoanOffer> fetchOffers(Double eligibleLoanAmount) throws Exception 
	{
		Optional<List<LoanOffer>> optionalListOfLoanOffer = loanOfferRepository.findByLoanAmountIsLessThanEqual(eligibleLoanAmount);

		boolean isPresentListOfLoanOffer = optionalListOfLoanOffer.isPresent();
		
		if(isPresentListOfLoanOffer)
		{
			return optionalListOfLoanOffer.get();
		}
			
		else
			throw new Exception("No Loan Offer found for you ");
	}
	

}
