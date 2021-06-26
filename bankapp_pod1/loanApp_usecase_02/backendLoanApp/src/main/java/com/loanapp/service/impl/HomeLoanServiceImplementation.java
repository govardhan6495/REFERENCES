package com.loanapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.model.HomeLoan;
import com.loanapp.repository.HomeLoanRepository;
import com.loanapp.service.HomeLoanService;

@Service
public class HomeLoanServiceImplementation implements HomeLoanService{


	@Autowired
	HomeLoanRepository homeLoanRepo;
	
	@Override
	public HomeLoan applyHomeLoan(HomeLoan homeLoan) {
		return this.homeLoanRepo.save(homeLoan);
	}
	
	@Override
	public List<HomeLoan> getHomeLoans(){
		return this.homeLoanRepo.findAll();
	}
	


}
