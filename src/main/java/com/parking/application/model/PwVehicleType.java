package com.parking.application.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;

/**
 * 
 * @author kpawan
 *
 */
@Entity
public class PwVehicleType {

	private int vehicleId;
	private String vehicleType="";
	private String brand;
	private int model;
	private String regNo;
	private Date efftdt;
	private PwUser user;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getModel() {
		return model;
	}

	public void setModel(int model) {
		this.model = model;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	@Temporal(TemporalType.DATE)
	public Date getEfftdt() {
		return efftdt;
	}

	public void setEfftdt(Date efftdt) {
		this.efftdt = efftdt;
	}

	@ManyToOne
	@JoinColumn(name = "user_id")
	@JsonBackReference
	public PwUser getUser() {
		return user;
	}

	public void setUser(PwUser user) {
		this.user = user;
	}

}
