package com.loanapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.loanapp.domain.HomeLoan;

@Repository
public interface HomeLoanRepository extends JpaRepository<HomeLoan, Long>{

}
