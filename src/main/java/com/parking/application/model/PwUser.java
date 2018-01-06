package com.parking.application.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;

/**
 * 
 * @author kpawan
 *
 */
@Entity
public class PwUser {
	
	private int userId;
	private Date efftDt;
	private String phoneNo;
	private String emailId;
	private String firstName;
	private String lastName;
	private String sex;
	private Date dateOfJoining;
	private Boolean corporateInd;
	private List<PwVehicleType> vehicle;
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getEfftDt() {
		return efftDt;
	}
	public void setEfftDt(Date efftDt) {
		this.efftDt = efftDt;
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
	
	@Temporal(TemporalType.DATE)
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	@Type(type="yes_no")
	public Boolean getCorporateInd() {
		return corporateInd;
	}
	public void setCorporateInd(Boolean corporateInd) {
		this.corporateInd = corporateInd;
	}
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<PwVehicleType> getVehicle() {
		return vehicle;
	}
	public void setVehicle(List<PwVehicleType> vehicle) {
		this.vehicle = vehicle;
	}
	
	
	
	

}
