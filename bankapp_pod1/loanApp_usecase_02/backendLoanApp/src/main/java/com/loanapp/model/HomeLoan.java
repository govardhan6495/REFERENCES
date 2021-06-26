package com.loanapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class HomeLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hloanId;
	
	private String cmpname;
		
	private String desgn;
	
	private int totexp;
	
	private int curexp;
		
	private int aninc;

	
	public HomeLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HomeLoan(long hloanId, String cmpname, String desgn, int totexp, int curexp, int aninc) {
		super();
		this.hloanId = hloanId;
		this.cmpname = cmpname;
		this.desgn = desgn;
		this.totexp = totexp;
		this.curexp = curexp;
		this.aninc = aninc;
	}

	public long getHloanId() {
		return hloanId;
	}

	public void setHloanId(long hloanId) {
		this.hloanId = hloanId;
	}

	public String getCmpname() {
		return cmpname;
	}

	public void setCmpname(String cmpname) {
		this.cmpname = cmpname;
	}

	public String getDesgn() {
		return desgn;
	}

	public void setDesgn(String desgn) {
		this.desgn = desgn;
	}

	public int getTotexp() {
		return totexp;
	}

	public void setTotexp(int totexp) {
		this.totexp = totexp;
	}

	public int getCurexp() {
		return curexp;
	}

	public void setCurexp(int curexp) {
		this.curexp = curexp;
	}

	public int getAninc() {
		return aninc;
	}

	public void setAninc(int aninc) {
		this.aninc = aninc;
	}
	
	

}
