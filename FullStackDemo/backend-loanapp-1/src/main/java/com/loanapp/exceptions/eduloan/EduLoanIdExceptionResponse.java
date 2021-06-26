package com.loanapp.exceptions.eduloan;


public class EduLoanIdExceptionResponse {

	private String eduLoanIdentifier;

	public EduLoanIdExceptionResponse(String eduLoanIdentifier) {
		super();
		this.eduLoanIdentifier = eduLoanIdentifier;
	}

	public String getEduLoanIdentifier() {
		return eduLoanIdentifier;
	}

	public void setEduLoanIdentifier(String eduLoanIdentifier) {
		this.eduLoanIdentifier = eduLoanIdentifier;
	}


}
