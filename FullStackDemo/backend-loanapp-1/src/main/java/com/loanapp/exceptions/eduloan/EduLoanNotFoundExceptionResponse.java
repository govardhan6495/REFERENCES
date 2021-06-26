package com.loanapp.exceptions.eduloan;

public class EduLoanNotFoundExceptionResponse {

	private String EduLoanNotFound;

	public EduLoanNotFoundExceptionResponse(String eduLoanNotFound) {
		EduLoanNotFound = eduLoanNotFound;
	}

	public String getEduLoanNotFound() {
		return EduLoanNotFound;
	}

	public void setEduLoanNotFound(String eduLoanNotFound) {
		EduLoanNotFound = eduLoanNotFound;
	}

	
}

