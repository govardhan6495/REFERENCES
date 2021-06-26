package com.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanapp.model.EducationLoan;

@Repository
public interface EducationLoanRepository extends JpaRepository<EducationLoan, Long> {

}
