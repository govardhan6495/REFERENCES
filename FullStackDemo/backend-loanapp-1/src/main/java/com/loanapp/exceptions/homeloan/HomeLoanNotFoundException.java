package com.loanapp.exceptions.homeloan;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class HomeLoanNotFoundException extends RuntimeException  {

	private static final long serialVersionUID = 1L;

	public HomeLoanNotFoundException(String message) {
		super(message);
	}

	
}
