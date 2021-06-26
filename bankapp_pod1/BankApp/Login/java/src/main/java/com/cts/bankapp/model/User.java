package com.cts.bankapp.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User  implements Serializable{
	
	
	private String username;
	private int customerid;
	private String password;
	private String name;
	private String gender;
	private String gaurdianName;
	private String address;
	private String nationality;
	private String state;
	private String country;
	private String email;
	private String gaurdian;
	private String maritalStatus;
	private int contactNo;
	private Date registnDate;
	private String accountType;
	private String citizenStatus;
	private int initialDepoAmt;
	private String branchName;
	private String idenProof;
	private String idenDocNum;
	private String refAccntName;
    private String refAccntNumber;
    private String refAccntAddress;
	
	
  
	@Column(name="USRNAME")
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Column(name="USRPSWD")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Column(name="CSTNAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Column(name="GENDER")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	@Column(name="GAURDIAN")
	public String getGaurdianName() {
		return gaurdianName;
	}
	public void setGaurdianName(String gaurdianName) {
		this.gaurdianName = gaurdianName;
	}
	@Column(name="ADDRESS")
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Column(name="NATIONALITY")
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	@Column(name="STATE")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@Column(name="COUNTRY")
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Column(name="GAURDIANTYPE")
	public String getGaurdian() {
		return gaurdian;
	}
	public void setGaurdian(String gaurdian) {
		this.gaurdian = gaurdian;
	}
	@Column(name="MARITALSTATUS")
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	@Column(name="CNCTNO")
	public int getContactNo() {
		return contactNo;
	}
	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}
	@Column(name="RGSTNDATE")
	public Date getRegistnDate() {
		return registnDate;
	}
	public void setRegistnDate(Date registnDate) {
		this.registnDate = registnDate;
	}
	@Column(name="ACCOUNTTYPE")
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Column(name="CITIZENSTATUS")
	public String getCitizenStatus() {
		return citizenStatus;
	}
	public void setCitizenStatus(String citizenStatus) {
		this.citizenStatus = citizenStatus;
	}
	@Column(name="INITIALDEPOSIT")
	public int getInitialDepoAmt() {
		return initialDepoAmt;
	}
	public void setInitialDepoAmt(int initialDepoAmt) {
		this.initialDepoAmt = initialDepoAmt;
	}
	@Column(name="BRANCHNAME")
	public String getBranchName() {
		return branchName;
	}
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	@Column(name="IDENPROOF")
	public String getIdenProof() {
		return idenProof;
	}
	public void setIdenProof(String idenProof) {
		this.idenProof = idenProof;
	}
	@Column(name="IDENDOCNUM")
	public String getIdenDocNum() {
		return idenDocNum;
	}
	public void setIdenDocNum(String idenDocNum) {
		this.idenDocNum = idenDocNum;
	}
	@Column(name="REFACCNTNAME")
	public String getRefAccntName() {
		return refAccntName;
	}
	public void setRefAccntName(String refAccntName) {
		this.refAccntName = refAccntName;
	}
	@Column(name="REFACCNTNUMBER")
	public String getRefAccntNumber() {
		return refAccntNumber;
	}
	public void setRefAccntNumber(String refAccntNumber) {
		this.refAccntNumber = refAccntNumber;
	}
	@Column(name="REFACCNTADDRSS")
	public String getRefAccntAddress() {
		return refAccntAddress;
	}
	public void setRefAccntAddress(String refAccntAddress) {
		this.refAccntAddress = refAccntAddress;
	}
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="CUSTID")
	public int getCustomerid() {
		return customerid;
	}
	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}
	public User( ) {
		
	}
	public User(String username, int customerid, String password, String name, String gender, String gaurdianName,
			String address, String nationality, String state, String country, String email, String gaurdian,
			String maritalStatus, int contactNo, Date registnDate, String accountType, String citizenStatus,
			int initialDepoAmt, String branchName, String idenProof, String idenDocNum, String refAccntName,
			String refAccntNumber, String refAccntAddress) {
		super();
		this.username = username;
		this.customerid = customerid;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.gaurdianName = gaurdianName;
		this.address = address;
		this.nationality = nationality;
		this.state = state;
		this.country = country;
		this.email = email;
		this.gaurdian = gaurdian;
		this.maritalStatus = maritalStatus;
		this.contactNo = contactNo;
		this.registnDate = registnDate;
		this.accountType = accountType;
		this.citizenStatus = citizenStatus;
		this.initialDepoAmt = initialDepoAmt;
		this.branchName = branchName;
		this.idenProof = idenProof;
		this.idenDocNum = idenDocNum;
		this.refAccntName = refAccntName;
		this.refAccntNumber = refAccntNumber;
		this.refAccntAddress = refAccntAddress;
	}
	

	

}
