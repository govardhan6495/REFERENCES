package com.loanapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.domain.EducationLoan;
import com.loanapp.repositories.EducationLoanRepository;

@Service
public class EducationLoanService {

	@Autowired
	EducationLoanRepository eduLoanRepo;
	
	public EducationLoan applyEducationLoan(EducationLoan eduLoan) {
		return eduLoanRepo.save(eduLoan);
	}
	
	public List<EducationLoan> getEduLoans(){
		return eduLoanRepo.findAll();
	}
	
	public void deleteEduLoanById(Long eloanId) {
		EducationLoan eduLoan = eduLoanRepo.getOne(eloanId);
		eduLoanRepo.delete(eduLoan);
	}
}
