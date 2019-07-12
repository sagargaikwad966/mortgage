package com.hcl.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LOAN_OFFER")
public class LoanOffer 
{
	@Id
	@Column(name = "OFFER_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerId;
	
	@Column(name = "LOAN_AMOUNT", nullable = false)
	private Double loanAmount;
	
	@Column(name = "TENURE", nullable = false)
	private Integer tenure;
	
	@Column(name = "ROI", nullable = false)
	private Double roi;
	
	@Column(name = "EMI", nullable = false)
	private Double emi;

	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
	

	public Double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(Double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getRoi() {
		return roi;
	}

	public void setRoi(Double roi) {
		this.roi = roi;
	}

	public Double getEmi() {
		return emi;
	}

	public void setEmi(Double emi) {
		this.emi = emi;
	}

}
