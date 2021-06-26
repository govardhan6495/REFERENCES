package com.demo1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo1.domain.HomeLoan;

@Repository
public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long>{

	HomeLoan findHomeLoanById(Long hloanId);

	
	Iterable<HomeLoan> findALlByHomeLoanApplicant(String username);

}
