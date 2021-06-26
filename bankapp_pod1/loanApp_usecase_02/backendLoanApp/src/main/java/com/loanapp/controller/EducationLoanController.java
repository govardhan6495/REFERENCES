package com.loanapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanapp.model.EducationLoan;
import com.loanapp.service.EducationLoanService;

@RestController
@RequestMapping("eloan/v1")
@CrossOrigin(origins = "*")
public class EducationLoanController {

	@Autowired
	EducationLoanService eduLoanService;
	
	@PostMapping("/apply")
	public EducationLoan applyEduLoan(@RequestBody EducationLoan eduLoan) {
		return this.eduLoanService.applyEduLaon(eduLoan);
	}
	
	@GetMapping("/all")
	public List<EducationLoan> getEduLoans(){
		return this.eduLoanService.getEduLoans();
	}
}
