package com.loanapp.exceptions.homeloan;

public class HomeLoanNotFoundExceptionResponse {

	private String HomeLoanNotFound;

	
	
	public HomeLoanNotFoundExceptionResponse(String homeLoanNotFound) {
		HomeLoanNotFound = homeLoanNotFound;
	}

	public String getHomeLoanNotFound() {
		return HomeLoanNotFound;
	}

	public void setHomeLoanNotFound(String homeLoanNotFound) {
		HomeLoanNotFound = homeLoanNotFound;
	}
	
	
}
