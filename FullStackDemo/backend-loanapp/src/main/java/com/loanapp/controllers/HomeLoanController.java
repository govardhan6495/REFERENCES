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

import com.loanapp.domain.HomeLoan;
import com.loanapp.service.HomeLoanService;

@RestController
@RequestMapping("api/hloan")
@CrossOrigin
public class HomeLoanController {

	@Autowired
	private HomeLoanService hloanService;
	
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
}
