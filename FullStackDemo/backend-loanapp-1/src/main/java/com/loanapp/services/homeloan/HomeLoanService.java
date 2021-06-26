package com.loanapp.services.homeloan;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.loanapp.domain.HomeLoan;
import com.loanapp.domain.User;
import com.loanapp.exceptions.homeloan.HomeLoanIdException;
import com.loanapp.exceptions.homeloan.HomeLoanNotFoundException;
import com.loanapp.repositories.HomeLoanRepository;
import com.loanapp.repositories.UserRepository;

@Service
public class HomeLoanService {

	@Autowired
	HomeLoanRepository homeLoanRepo;
	
	@Autowired
    private UserRepository userRepository;

	public HomeLoan applyHomeLoan(HomeLoan homeLoan) {
		return homeLoanRepo.save(homeLoan);
	}

	public List<HomeLoan> getHomeLoans() {
		return homeLoanRepo.findAll();
	}
	
	public void deleteHomeLoanById(Long hloanId) {
		HomeLoan homeLoan = homeLoanRepo.getOne(hloanId);
		
		if(homeLoan == null) {}
		
		homeLoanRepo.delete(homeLoan);
	}
	
	 public HomeLoan saveOrUpdateHomeLoan(HomeLoan hLoan, String username){

	        if(hLoan.getHloanId() != null){
	        	HomeLoan existingHomeLoan = homeLoanRepo.findByHloanId(hLoan.getHloanId());
	            if(existingHomeLoan !=null &&(!existingHomeLoan.getHomeLoanApplicant().equals(username))){
	                throw new HomeLoanNotFoundException("HomeLoan not found in your account");
	            }else if(existingHomeLoan == null){
	                throw new HomeLoanNotFoundException("HomeLoan with ID: '"+hLoan.getHloanId()+"' cannot be updated because it doesn't exist");
	            }
	        }

	        try{

	            User user = userRepository.findByUsername(username);
	            hLoan.setUser(user);
	            hLoan.setHomeLoanApplicant(user.getUsername());
	            
	            return homeLoanRepo.save(hLoan);

	        }catch (Exception e){
	            throw new HomeLoanIdException("HomeLoan ID '"+hLoan.getHloanId()+"' already exists");
	        }
	    }
	 
	 public HomeLoan findHomeLoanByIdentifier(Long hLoanId, String username){

	        //Only want to return the HomeLoan if the user looking for it is the owner

		 HomeLoan homeLoan = homeLoanRepo.findByHloanId(hLoanId);

	        if(homeLoan == null){
	            throw new HomeLoanIdException("HomeLoan ID '"+hLoanId+"' does not exist");
	        }

	        if(!homeLoan.getHomeLoanApplicant().equals(username)){
	            throw new HomeLoanIdException("HomeLoan not found in your account");
	        }

	        return homeLoan;
	    }
	 
	 public Iterable<HomeLoan> findAllHomeLoans(String username){
		 return homeLoanRepo.findALlByHomeLoanApplicant(username);
	 }

	 public void deleteHomeLoanByIdentifier(Long hLoanId, String username){

		 homeLoanRepo.delete(findHomeLoanByIdentifier(hLoanId, username));
     }
	 

}
