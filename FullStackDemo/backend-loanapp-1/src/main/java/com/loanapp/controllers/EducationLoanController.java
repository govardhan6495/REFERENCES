package com.loanapp.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanapp.domain.EducationLoan;
import com.loanapp.services.MapValidationErrorService;
import com.loanapp.services.eduloan.EducationLoanService;

@RestController
@RequestMapping("api/eloan")
@CrossOrigin
public class EducationLoanController {
	
	@Autowired
	EducationLoanService eduLoanService;
	
	@Autowired
	MapValidationErrorService mapValidationErrorService;
	
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

	//Includes the server-side Validation and error handling	

	@PostMapping("/applyELoan")
	public ResponseEntity<?> applyELoan(@Valid @RequestBody EducationLoan eLoan,  BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        EducationLoan eLoan1 = eduLoanService.saveOrUpdateEduLoan(eLoan, principal.getName());
        return new ResponseEntity<EducationLoan>(eLoan1, HttpStatus.CREATED);
    }
	
	@GetMapping("/{eduLoanId}")
	public ResponseEntity<?> getEduLoanById(@PathVariable Long eduLoanId, Principal principal){
		EducationLoan eduLoan = eduLoanService.findEduLoanByIdentifier(eduLoanId, principal.getName());
		
		return new ResponseEntity<EducationLoan>(eduLoan, HttpStatus.OK);
	}

	@GetMapping("/all")
	public Iterable<EducationLoan> getAllEduLoans(Principal principal){
		return eduLoanService.findAllEduLoans(principal.getName());
	}
	
	@DeleteMapping("/delete/{eduLoanId}")
    public ResponseEntity<?> deleteHomeLoan(@PathVariable Long eduLoanId, Principal principal){
		eduLoanService.deleteEduLoanByIdentifier(eduLoanId, principal.getName());

        return new ResponseEntity<String>("HomeLoan with ID: '"+eduLoanId+"' was deleted", HttpStatus.OK);
    }
	
}