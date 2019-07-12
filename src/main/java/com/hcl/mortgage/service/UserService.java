package com.hcl.mortgage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.mortgage.entity.LoanOffer;
import com.hcl.mortgage.entity.User;
import com.hcl.mortgage.exception.UserDataNotValidException;
import com.hcl.mortgage.exception.UserNotEligibleException;
import com.hcl.mortgage.model.UserDTO;
import com.hcl.mortgage.repository.UserRepository;
import com.hcl.mortgage.utility.UserUtils;

@Service
public class UserService 
{
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	LoanOfferService loanOfferService;
	
	@Autowired
	UserRepository userRepository;
	
	public User mappingUser(UserDTO userDTO)
	{
		User user = new User();
		BeanUtils.copyProperties(userDTO, user);
		return user;
		
	}

	public List<LoanOffer> calculateLoanOffers(User user) throws UserDataNotValidException, UserNotEligibleException, Exception
	{
		List<LoanOffer> listOfLoanOffers = null;
		Double propertyValue = propertyService.calculatePropertyValue(user.getPropertyPincode(),user.getPropertyArea());
		
		if(propertyValue < 500000 )
			throw new UserNotEligibleException("User is not Eligible : Property Value should be greater than or equal to 5,00,000 Rs");
		else
		{
			userRepository.save(user);
			Double eligibleLoanAmount = UserUtils.calculateEligibleLoanAmount(propertyValue);
			listOfLoanOffers = loanOfferService.fetchOffers(eligibleLoanAmount);
		}
			
		return listOfLoanOffers;
	}

}
