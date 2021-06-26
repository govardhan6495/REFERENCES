package com.demo1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


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


    @SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler
    public final ResponseEntity<Object> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex, WebRequest request){
        UsernameAlreadyExistsResponse exceptionResponse = new UsernameAlreadyExistsResponse(ex.getMessage());
        return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
    }


}