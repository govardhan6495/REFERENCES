package com.loanapp.exceptions.homeloan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HomeLoanIdException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public HomeLoanIdException(String message) {
		super(message);
	}

	
}
