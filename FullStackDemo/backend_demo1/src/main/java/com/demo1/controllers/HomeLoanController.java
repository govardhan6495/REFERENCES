package com.demo1.controllers;

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

import com.demo1.domain.HomeLoan;
import com.demo1.services.HomeLoanService;
import com.demo1.services.MapValidationErrorService;

@RestController
@RequestMapping("api/hloan")
@CrossOrigin
public class HomeLoanController {

	@Autowired
	private HomeLoanService hloanService;
	
	@Autowired
    private MapValidationErrorService mapValidationErrorService;

	
	@PostMapping("")
	public HomeLoan applyHomeLoan(@RequestBody HomeLoan homeLoan ) {
		return hloanService.applyHomeLoan(homeLoan);
	}
	
	
	@GetMapping("")
	public List<HomeLoan> getHomeLoans(){
		return hloanService.getHomeLoans();
	}
	
	@DeleteMapping("/{hloanId}")
	public void deleteHomeLoan(@PathVariable Long hloanId) {
		hloanService.deleteHomeLoanById(hloanId);
	}
	
	@PostMapping("/applyHLoan")
	public ResponseEntity<?> applyHLoan(@Valid @RequestBody HomeLoan hLoan,  BindingResult result, Principal principal){

        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
        if(errorMap!=null) return errorMap;

        HomeLoan hLoan1 = hloanService.saveOrUpdateHomeLoan(hLoan, principal.getName());
        return new ResponseEntity<HomeLoan>(hLoan1, HttpStatus.CREATED);
    }
	
	@GetMapping("/hLoan/all/{hLoanId}")
	public ResponseEntity<?> getHomeLoanById(@PathVariable Long hLoanId, Principal principal){
		HomeLoan homeLoan = hloanService.findHomeLoanByIdentifier(hLoanId, principal.getName());
		
		return new ResponseEntity<HomeLoan>(homeLoan, HttpStatus.OK);
	}
	
	@DeleteMapping("/hLoan/delete/{hLoanId}")
    public ResponseEntity<?> deleteHomeLoan(@PathVariable Long hLoanId, Principal principal){
		hloanService.deleteHomeLoanByIdentifier(hLoanId, principal.getName());

        return new ResponseEntity<String>("HomeLoan with ID: '"+hLoanId+"' was deleted", HttpStatus.OK);
    }
	
}
