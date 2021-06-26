package com.demo1.controllers;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class EducationLoan {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long eLoanId;
	
	@NotBlank(message = "Course Fee is required")
	private int cFee;
	
	@NotBlank(message = "Course Name is required")
	private String cName;
	
	@NotBlank(message = "Father Name is required")
	private String fName;
	
	@NotBlank(message = "Father Occupation is required")
	private String fOcup;
	
	@NotBlank(message = "Father Total Experience is required")
	private int fTotExp;
	
	@NotBlank(message = "Father Experience with current company is required")
	private int fCurExp;
	
	@NotBlank(message = "RationCard No. is required")
	private String rtCno;
	 
	@NotBlank(message = "Annual Income is required")
	private int anInc;
	
	public EducationLoan() {
	
	}
	
}
