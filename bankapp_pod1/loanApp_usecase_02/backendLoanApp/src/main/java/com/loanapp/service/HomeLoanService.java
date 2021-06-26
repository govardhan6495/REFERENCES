package com.loanapp.service;

import java.util.List;

import com.loanapp.model.HomeLoan;

public interface HomeLoanService {
	

	public HomeLoan applyHomeLoan(HomeLoan homeLoan);
	
	public List<HomeLoan> getHomeLoans();
	
	
}
