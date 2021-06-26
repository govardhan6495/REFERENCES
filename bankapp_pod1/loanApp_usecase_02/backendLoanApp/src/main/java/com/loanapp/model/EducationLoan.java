package com.loanapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EducationLoan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long eloanId;
	
	private String cname;
	
	private int cfee;
	
	private String fname;
	
	private int ftotexp;
	
	private String focup;
	
	private int fcurexp;
	
	private String rtcno;
	
	private int aninc;

	public EducationLoan() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EducationLoan(long eloanId, String cname, int cfee, String fname, int ftotexp, String focup, int fcurexp,
			String rtcno, int aninc) {
		super();
		this.eloanId = eloanId;
		this.cname = cname;
		this.cfee = cfee;
		this.fname = fname;
		this.ftotexp = ftotexp;
		this.focup = focup;
		this.fcurexp = fcurexp;
		this.rtcno = rtcno;
		this.aninc = aninc;
	}

	public long getEloanId() {
		return eloanId;
	}

	public void setEloanId(long eloanId) {
		this.eloanId = eloanId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public int getCfee() {
		return cfee;
	}

	public void setCfee(int cfee) {
		this.cfee = cfee;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getFtotexp() {
		return ftotexp;
	}

	public void setFtotexp(int ftotexp) {
		this.ftotexp = ftotexp;
	}

	public String getFocup() {
		return focup;
	}

	public void setFocup(String focup) {
		this.focup = focup;
	}

	public int getFcurexp() {
		return fcurexp;
	}

	public void setFcurexp(int fcurexp) {
		this.fcurexp = fcurexp;
	}

	public String getRtcno() {
		return rtcno;
	}

	public void setRtcno(String rtcno) {
		this.rtcno = rtcno;
	}

	public int getAninc() {
		return aninc;
	}

	public void setAninc(int aninc) {
		this.aninc = aninc;
	}
	
	

}
