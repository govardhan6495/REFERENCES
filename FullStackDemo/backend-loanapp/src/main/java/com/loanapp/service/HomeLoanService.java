package com.loanapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.domain.HomeLoan;
import com.loanapp.repositories.HomeLoanRepository;

@Service
public class HomeLoanService {

	@Autowired
	HomeLoanRepository homeLoanRepo;

	public HomeLoan applyHomeLoan(HomeLoan homeLoan) {
		return homeLoanRepo.save(homeLoan);
	}

	public List<HomeLoan> getHomeLoans() {
		return homeLoanRepo.findAll();
	}
	
	public void deleteHomeLoanById(Long hloanId) {
		HomeLoan homeLoan = homeLoanRepo.getOne(hloanId);
		
		if(homeLoan == null) {}
		
		homeLoanRepo.delete(homeLoan);
	}

}
