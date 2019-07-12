package com.hcl.mortgage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.entity.LoanOffer;
import com.hcl.mortgage.entity.User;
import com.hcl.mortgage.exception.UserDataNotValidException;
import com.hcl.mortgage.exception.UserNotEligibleException;
import com.hcl.mortgage.model.UserDTO;
import com.hcl.mortgage.service.UserService;
import com.hcl.mortgage.utility.UserUtils;

@RestController
@RequestMapping("/LoanOffer")
public class MortgageController 
{
	@Autowired
	UserService userService;
	
	/**
	 * This method is used to fetch Loan Offers depend on User Information
	 * @param userDTO to get UserDTO Object
	 * @return ResponseEntity<?> This returns List of Offers or Error Message and status code
	 * @exception UserDataNotValidException / UserNotEligibleException on input error
	 */
	@PostMapping("/Offers")
	public ResponseEntity<?> calculateLoanOffers(@RequestBody UserDTO userDTO)
	{
		List<LoanOffer> offerList = null;
		try 
		{
			
			validateUserData(userDTO);
			User user = userService.mappingUser(userDTO);
			offerList = userService.calculateLoanOffers(user);
			
		} 
		catch (UserDataNotValidException | UserNotEligibleException  e) 
		{
			return new ResponseEntity<String>("Invalid Data : "+e.getMessage(),HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Sorry ! : "+e.getMessage(),HttpStatus.NOT_ACCEPTABLE);
		}
		
		return new ResponseEntity<List<LoanOffer>>(offerList, HttpStatus.OK);
	}

	/**
	 * This method is used to validate the user
	 * @param user to get user information
	 * @exception UserDataNotValidException / UserNotEligibleException on input error
	 */
	private void validateUserData(UserDTO user) throws UserDataNotValidException, UserNotEligibleException 
	{
		if(StringUtils.isEmpty(user.getUserName()))
			throw new UserDataNotValidException("Mandatory field Missing : Username");
		
		if(StringUtils.isEmpty(user.getPan()))
			throw new UserDataNotValidException("Mandatory field Missing : PAN");
		
		if(StringUtils.isEmpty(user.getDob()))
			throw new UserDataNotValidException("Mandatory field Missing : DOB");
		
		if(StringUtils.isEmpty(user.getPropertyAddress()))
			throw new UserDataNotValidException("Mandatory field Missing : Property Address");
		
		if(StringUtils.isEmpty(user.getPropertyPincode()))
			throw new UserDataNotValidException("Mandatory field Missing : Property Pincode");
		
		if(StringUtils.isEmpty(user.getPropertyArea()))
			throw new UserDataNotValidException("Mandatory field Missing : Property Area");
		
		if(StringUtils.isEmpty(user.getPropertyType()))
			throw new UserDataNotValidException("Mandatory field Missing : Property Type");
		
		if(StringUtils.isEmpty(user.getSalary()))
			throw new UserDataNotValidException("Mandatory field Missing : Salary");
		
		if(StringUtils.isEmpty(user.getPhone()))
			throw new UserDataNotValidException("Mandatory field Missing : Phone Number");
		
		if(StringUtils.isEmpty(user.getEmail()))
			throw new UserDataNotValidException("Mandatory field Missing : Email Address");
		
		if(UserUtils.calculateAge(user.getDob()) < 25)
			throw new UserNotEligibleException("User is not Eligible : Age should be greater than or equal to 25");
		
		if(user.getSalary() < 10000)
			throw new UserNotEligibleException("User is not Eligible : salary should be greater than or equal to 10,000 Rs.");
	}

}
