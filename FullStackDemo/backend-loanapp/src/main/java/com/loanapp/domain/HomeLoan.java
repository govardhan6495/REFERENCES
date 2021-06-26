package com.loanapp.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeLoan {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long hloanId;
    
    private String cmpName;
            
    private String desgn;
    
    private int totExp;
    
    private int curExp;
            
    private int anInc;

	public HomeLoan() {
	
	}

	public long getHloanId() {
		return hloanId;
	}

	public void setHloanId(long hloanId) {
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
}
