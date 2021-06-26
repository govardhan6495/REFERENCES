package com.cts.bankapp.convertor;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cts.bankapp.model.User;
import com.cts.bankapp.request.RegisterRequest;



public class UserConvertor {
	@Autowired
	static BCryptPasswordEncoder encoder;
	

	public static User convertUserForRegistration(RegisterRequest user) {
		User newUser=new User();
		newUser.setAccountType(user.getAccountType());
		newUser.setAddress(user.getAddress());
		newUser.setBranchName(user.getBranchName());
		newUser.setCitizenStatus(user.getCitizenStatus());
		newUser.setContactNo(user.getContactNo());
		newUser.setCountry(user.getCountry());
		newUser.setEmail(user.getEmail());
		newUser.setGaurdian(user.getGaurdian());
		newUser.setGaurdianName(user.getGaurdianName());
		newUser.setGender(user.getGender());
		newUser.setIdenDocNum(user.getIdenDocNum());
		newUser.setIdenProof(user.getIdenProof());
		newUser.setInitialDepoAmt(user.getInitialDepoAmt());
		newUser.setMaritalStatus(user.getMaritalStatus());
		newUser.setName(user.getName());
		newUser.setNationality(user.getNationality());
		//BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(); // 
		//String encodedPassword = encoder.encode(user.getPassword());
		int strength = 10; // work factor of bcrypt
		 BCryptPasswordEncoder bCryptPasswordEncoder =
		  new BCryptPasswordEncoder(strength, new SecureRandom());
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		newUser.setPassword(encodedPassword);
		newUser.setRefAccntAddress(user.getRefAccntAddress());
		newUser.setRefAccntName(user.getRefAccntName());
		newUser.setRefAccntNumber(user.getRefAccntNumber());
		newUser.setRegistnDate(user.getRegistnDate());
		newUser.setState(user.getState());
		newUser.setUsername(user.getUsername());
		return newUser;
	}

}
