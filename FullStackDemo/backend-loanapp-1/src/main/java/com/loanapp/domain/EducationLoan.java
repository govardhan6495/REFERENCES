package com.loanapp.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class EducationLoan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eloanId;
    
    private String cName;
    
    private int cFee;
    
    private String fName;
    
    private int ftotExp;
    
    private String fOcup;
    
    private int fcurExp;
    
    private String rtcNo;
    
    private int anInc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private User user;
    
    private String eduLoanApplicant;

    public EducationLoan() {
	
	}

	public Long getEloanId() {
		return eloanId;
	}

	public void setEloanId(Long eloanId) {
		this.eloanId = eloanId;
	}

	public String getcName() {
		return cName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public int getcFee() {
		return cFee;
	}

	public void setcFee(int cFee) {
		this.cFee = cFee;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public int getFtotExp() {
		return ftotExp;
	}

	public void setFtotExp(int ftotExp) {
		this.ftotExp = ftotExp;
	}

	public String getfOcup() {
		return fOcup;
	}

	public void setfOcup(String fOcup) {
		this.fOcup = fOcup;
	}

	public int getFcurExp() {
		return fcurExp;
	}

	public void setFcurExp(int fcurExp) {
		this.fcurExp = fcurExp;
	}

	public String getRtcNo() {
		return rtcNo;
	}

	public void setRtcNo(String rtcNo) {
		this.rtcNo = rtcNo;
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

	public String getEduLoanApplicant() {
		return eduLoanApplicant;
	}

	public void setEduLoanApplicant(String eduLoanApplicant) {
		this.eduLoanApplicant = eduLoanApplicant;
	}

   
    
}
 