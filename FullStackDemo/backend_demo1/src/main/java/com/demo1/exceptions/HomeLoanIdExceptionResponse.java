package com.demo1.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public class HomeLoanIdExceptionResponse extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String homeLoanIdentifier;

	public HomeLoanIdExceptionResponse(String homeLoanIdentifier) {
		super();
		this.homeLoanIdentifier = homeLoanIdentifier;
	}

	public String getHomeLoanIdentifier() {
		return homeLoanIdentifier;
	}

	public void setHomeLoanIdentifier(String homeLoanIdentifier) {
		this.homeLoanIdentifier = homeLoanIdentifier;
	}
	
	 
	
}
