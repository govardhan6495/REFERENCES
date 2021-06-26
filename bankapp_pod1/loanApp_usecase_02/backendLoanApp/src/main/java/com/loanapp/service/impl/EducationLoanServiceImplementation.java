package com.loanapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.model.EducationLoan;
import com.loanapp.repository.EducationLoanRepository;
import com.loanapp.service.EducationLoanService;

@Service
public class EducationLoanServiceImplementation implements EducationLoanService {

	@Autowired
	EducationLoanRepository eduLoanRepo;
	
	@Override
	public EducationLoan applyEduLaon(EducationLoan eduLoan) {
		return this.eduLoanRepo.save(eduLoan);
	}
	
	@Override
	public List<EducationLoan> getEduLoans(){
		return this.eduLoanRepo.findAll();
	}

}
