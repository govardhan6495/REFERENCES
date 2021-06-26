package com.loanapp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class HomeLoan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hloanId;
    
    private String cmpName;
            
    private String desgn;
    
    private int totExp;
    
    private int curExp;
            
    private int anInc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
    
    private String homeLoanApplicant;

	public HomeLoan() {
	
	}

	public Long getHloanId() {
		return hloanId;
	}

	public void setHloanId(Long hloanId) {
		this.hloanId = hloanId;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getDesgn() {
		return desgn;
	}

	public void setDesgn(String desgn) {
		this.desgn = desgn;
	}

	public int getTotExp() {
		return totExp;
	}

	public void setTotExp(int totExp) {
		this.totExp = totExp;
	}

	public int getCurExp() {
		return curExp;
	}

	public void setCurExp(int curExp) {
		this.curExp = curExp;
	}

	public int getAnInc() {
		return anInc;
	}

	public void setAnInc(int anInc) {
		this.anInc = anInc;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getHomeLoanApplicant() {
		return homeLoanApplicant;
	}

	public void setHomeLoanApplicant(String homeLoanApplicant) {
		this.homeLoanApplicant = homeLoanApplicant;
	}

	
}
