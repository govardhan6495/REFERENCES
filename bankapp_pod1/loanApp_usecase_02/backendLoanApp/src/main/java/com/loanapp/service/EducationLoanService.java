package com.loanapp.service;

import java.util.List;

import com.loanapp.model.EducationLoan;

public interface EducationLoanService {

	
	
	public EducationLoan applyEduLaon(EducationLoan eduLoan);

	
	public List<EducationLoan> getEduLoans();
}
