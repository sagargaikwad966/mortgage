package com.hcl.mortgage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.LoanOffer;

@Repository
public interface LoanOfferRepository extends JpaRepository<LoanOffer, Long> {
	
	public Optional<List<LoanOffer>> findByLoanAmountIsLessThanEqual(Double eligibleLoanAmount);

}
