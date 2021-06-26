package com.loanapp.services.eduloan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.domain.EducationLoan;
import com.loanapp.domain.User;
import com.loanapp.exceptions.eduloan.EduLoanIdException;
import com.loanapp.exceptions.eduloan.EduLoanNotFoundException;
import com.loanapp.repositories.EducationLoanRepository;
import com.loanapp.repositories.UserRepository;

@Service
public class EducationLoanService {

	@Autowired
	EducationLoanRepository eduLoanRepo;
	
	@Autowired
    private UserRepository userRepository;
	
	public EducationLoan applyEducationLoan(EducationLoan eduLoan) {
		return eduLoanRepo.save(eduLoan);
	}
	
	public List<EducationLoan> getEduLoans(){
		return eduLoanRepo.findAll();
	}
	
	public void deleteEduLoanById(Long eloanId) {
		EducationLoan eduLoan = eduLoanRepo.getOne(eloanId);
		eduLoanRepo.delete(eduLoan);
	}
	
	
	 public EducationLoan saveOrUpdateEduLoan(EducationLoan eduLoan, String username){

	        if(eduLoan.getEloanId() != null){
	        	EducationLoan existingEduLoan = eduLoanRepo.findByEloanId(eduLoan.getEloanId());
	            if(existingEduLoan !=null &&(!existingEduLoan.getEduLoanApplicant().equals(username))){
	                throw new EduLoanNotFoundException("EducationLoan not found in your account");
	            }else if(existingEduLoan == null){
	                throw new EduLoanNotFoundException("EducationLoan with ID: '"+eduLoan.getEloanId()+"' cannot be updated because it doesn't exist");
	            }
	        }

	        try{

	            User user = userRepository.findByUsername(username);
	            eduLoan.setUser(user);
	            eduLoan.setEduLoanApplicant(user.getUsername());
	            
	            return eduLoanRepo.save(eduLoan);

	        }catch (Exception e){
	            throw new EduLoanIdException("EducationLoan ID '"+eduLoan.getEloanId()+"' already exists");
	        }
	    }

	 public Iterable<EducationLoan> findAllEduLoans(String username){
		 return eduLoanRepo.findALlByEduLoanApplicant(username);
	 }

	 
	 public EducationLoan findEduLoanByIdentifier(Long eduLoanId, String username){

	        //Only want to return the HomeLoan if the user looking for it is the owner

		 EducationLoan eduLoan = eduLoanRepo.findByEloanId(eduLoanId);

	        if(eduLoan == null){
	            throw new EduLoanIdException("EducationLoan ID '"+eduLoanId+"' does not exist");
	        }

	        if(!eduLoan.getEduLoanApplicant().equals(username)){
	            throw new EduLoanIdException("EducationLoan not found in your account");
	        }

	        return eduLoan;
	    }

	 public void deleteEduLoanByIdentifier(Long eduLoanId, String username){

		 eduLoanRepo.delete(findEduLoanByIdentifier(eduLoanId, username));
  }


}
