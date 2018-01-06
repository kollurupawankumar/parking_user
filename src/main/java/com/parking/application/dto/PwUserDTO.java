package com.parking.application.dto;

import java.util.Date;

import com.parking.application.model.PwUser;

public class PwUserDTO {

	private int userId;
	private String efftDt;
	private String phoneNo;
	private String emailId;
	private String firstName;
	private String lastName;
	private String sex;
	private String dateOfJoining;
	private Boolean corporateInd;
	private String otp;
	private String token;

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Boolean getCorporateInd() {
		return corporateInd;
	}

	public void setCorporateInd(Boolean corporateInd) {
		this.corporateInd = corporateInd;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getEfftDt() {
		return efftDt;
	}

	public void setEfftDt(String efftDt) {
		this.efftDt = efftDt;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public static PwUser generateModelUser(PwUserDTO pwUserDTO) {
		PwUser user = new PwUser();
		user.setCorporateInd(pwUserDTO.getCorporateInd());
		user.setDateOfJoining(new Date());
		user.setEfftDt(new Date());
		user.setEmailId(pwUserDTO.getEmailId());
		user.setFirstName(pwUserDTO.getFirstName());
		user.setLastName(pwUserDTO.getLastName());
		user.setPhoneNo(pwUserDTO.getPhoneNo());
		user.setSex(pwUserDTO.getSex());
		return user;
	}

}
