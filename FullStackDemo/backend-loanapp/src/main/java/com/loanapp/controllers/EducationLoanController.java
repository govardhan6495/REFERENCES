package com.loanapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanapp.domain.EducationLoan;
import com.loanapp.service.EducationLoanService;

@RestController
@RequestMapping("api/eloan")
@CrossOrigin
public class EducationLoanController {
	
	@Autowired
	EducationLoanService eduLoanService;
	
	@PostMapping("")
	public EducationLoan applyEducationLoan(@RequestBody EducationLoan eduLoan) {
		return eduLoanService.applyEducationLoan(eduLoan);
	}

	@GetMapping("")
	public List<EducationLoan> getEduLoans(){
		return eduLoanService.getEduLoans();
	}
	
	@DeleteMapping("/{eloanId}")
	public void deleteEduLoanById(@PathVariable Long eloanId) {
		eduLoanService.deleteEduLoanById(eloanId);
	}
}