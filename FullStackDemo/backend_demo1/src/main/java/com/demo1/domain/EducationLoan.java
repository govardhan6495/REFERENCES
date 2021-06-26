package com.demo1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EducationLoan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eloanId;
    
    private String cName;
    
    private int cFee;
    
    private String fName;
    
    private int ftotExp;
    
    private String fOcup;
    
    private int fcurExp;
    
    private String rtcNo;
    
    private int anInc;

	public EducationLoan() {
	
	}

	public long getEloanId() {
		return eloanId;
	}

	public void setEloanId(long eloanId) {
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
    
    
}
 