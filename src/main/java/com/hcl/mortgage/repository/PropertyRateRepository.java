package com.hcl.mortgage.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.PropertyRate;


@Repository
public interface PropertyRateRepository extends JpaRepository<PropertyRate, Long> {
	
	public Optional<PropertyRate> findByPropertyPincode(String propertyPincode);

}
