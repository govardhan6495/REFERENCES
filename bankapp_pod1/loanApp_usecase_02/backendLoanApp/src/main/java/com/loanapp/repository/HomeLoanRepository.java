package com.loanapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanapp.model.HomeLoan;


@Repository
public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long>{

}
