package com.loanapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.loanapp.exceptions.eduloan.EduLoanIdException;
import com.loanapp.exceptions.eduloan.EduLoanIdExceptionResponse;
import com.loanapp.exceptions.eduloan.EduLoanNotFoundException;
import com.loanapp.exceptions.eduloan.EduLoanNotFoundExceptionResponse;
import com.loanapp.exceptions.homeloan.HomeLoanIdException;
import com.loanapp.exceptions.homeloan.HomeLoanIdExceptionResponse;
import com.loanapp.exceptions.homeloan.HomeLoanNotFoundException;
import com.loanapp.exceptions.homeloan.HomeLoanNotFoundExceptionResponse;
import com.loanapp.exceptions.user.UsernameAlreadyExistsException;
import com.loanapp.exceptions.user.UsernameAlreadyExistsResponse;

@ControllerAdvice
@RestController
public class CustomResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler
    public final ResponseEntity<Object> handleHomeLoanIdException(HomeLoanIdException ex, WebRequest request){
        HomeLoanIdExceptionResponse exceptionResponse = new HomeLoanIdExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleHomeLoanNotFoundException(HomeLoanNotFoundException ex, WebRequest request){
        HomeLoanNotFoundExceptionResponse exceptionResponse = new HomeLoanNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

	
	@ExceptionHandler
    public final ResponseEntity<Object> handleEduLoanIdException(EduLoanIdException ex, WebRequest request){
        EduLoanIdExceptionResponse exceptionResponse = new EduLoanIdExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public final ResponseEntity<Object> handleEduLoanNotFoundException(EduLoanNotFoundException ex, WebRequest request){
        EduLoanNotFoundExceptionResponse exceptionResponse = new EduLoanNotFoundExceptionResponse(ex.getMessage());
        return new ResponseEntity<Object>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


    
    @SuppressWarnings({ "unchecked", "rawtypes" })
	@ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex, WebRequest request){
        UsernameAlreadyExistsResponse exceptionResponse = new UsernameAlreadyExistsResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }

}