package com.cts.bankapp.controller;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cts.bankapp.convertor.UserConvertor;
import com.cts.bankapp.model.User;
import com.cts.bankapp.repository.UserRepository;
import com.cts.bankapp.request.LoginRequest;
import com.cts.bankapp.request.RegisterRequest;
import com.cts.bankapp.response.MessageResponse;
import com.cts.bankapp.response.UserResponse;
import com.cts.bankapp.security.jwt.TokenGeneratorUtil;
import com.cts.bankapp.security.services.UserDetailsImpl;



@CrossOrigin(origins = "http://localhost:3000")
@RestController

@RequestMapping(value = "/api/auth" )
public class UserController {
	public  static final String USER_NOT_FOUND="User not found";
	public  static final String INVALID_LOGIN_CREDENTIAL ="Invalid login credentials";

	
	 @Autowired
	 public UserRepository userRepo;
	 @Autowired
	 public AuthenticationManager authenticationManager;
	 @Autowired
    PasswordEncoder encoder;

	
	

	
	@PostMapping(
	        value = "/register",
	        consumes = {MediaType.APPLICATION_JSON_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
		if (this.userRepo.existsByUsername(registerRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		this.userRepo.save( UserConvertor.convertUserForRegistration(registerRequest));

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
	@GetMapping("/welcome")
	public String firstPage(@RequestParam(name = "name", required = false) String name) {
		return new String( "Welcome to vcbvcb "+name+"!");
	}

	


	
	//@PostMapping("/login")
	@PostMapping(
	        value = "/login",
	        consumes = {MediaType.APPLICATION_JSON_VALUE},
	        produces = {MediaType.APPLICATION_JSON_VALUE})
	//@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
	
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = TokenGeneratorUtil.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
	
	
		return ResponseEntity.ok(new UserResponse(jwt, userDetails.getId(), 
												 userDetails.getUsername()));
	}

}
