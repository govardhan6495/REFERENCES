package com.loanapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanapp.domain.EducationLoan;

@Repository
public interface EducationLoanRepository extends JpaRepository<EducationLoan, Long>{

}
