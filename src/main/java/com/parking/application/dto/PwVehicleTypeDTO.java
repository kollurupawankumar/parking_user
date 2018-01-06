package com.parking.application.dto;

import java.util.Date;

import com.parking.application.model.PwVehicleType;

public class PwVehicleTypeDTO {
	
	private int vehicalId;
	private String vehicleType;
	private String brand;
	private int model;
	private String regNo;
	private Date efftdt;
	private int userId;
	public int getVehicalId() {
		return vehicalId;
	}
	public void setVehicalId(int vehicalId) {
		this.vehicalId = vehicalId;
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
	public Date getEfftdt() {
		return efftdt;
	}
	public void setEfftdt(Date efftdt) {
		this.efftdt = efftdt;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	public static PwVehicleType convertToVehicleType(PwVehicleTypeDTO dto){
		PwVehicleType type = new PwVehicleType();
		type.setBrand(dto.getBrand());
		type.setEfftdt(new Date());
		type.setModel(dto.getModel());
		type.setRegNo(dto.getRegNo());
		type.setVehicleType(dto.getVehicleType());
		return type;
	}
	

}
