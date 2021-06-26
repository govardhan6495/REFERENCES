package com.loanapp.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.loanapp.model.HomeLoan;
import com.loanapp.service.HomeLoanService;

@RestController
@RequestMapping("hloan/v1")
@CrossOrigin(origins = "*")
public class HomeLoanController {

	@Autowired
	HomeLoanService hloanServive;
	
	
	@PostMapping("/apply")
	public HomeLoan applyHomeLoan(@RequestBody HomeLoan hloan ) {
		return this.hloanServive.applyHomeLoan(hloan);
	}
	
	@GetMapping("/all")
	public List<HomeLoan> getHomeLoans(){
		return this.hloanServive.getHomeLoans();
	}
}
