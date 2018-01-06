package com.parking.application.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.application.dao.ParkWiselyUserDAO;
import com.parking.application.dao.ParkWiselyVehicleTypeDAO;
import com.parking.application.dto.PwVehicleTypeDTO;
import com.parking.application.model.PwUser;
import com.parking.application.model.PwVehicleType;
import com.parking.application.service.VehicleService;


@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	ParkWiselyVehicleTypeDAO vehicle;
	
	@Autowired
	ParkWiselyUserDAO user;

	@Override
	public PwVehicleType registerVehicle(PwVehicleTypeDTO details) {
		PwUser userDetails = user.findOne(details.getUserId());
		if (userDetails != null){
			PwVehicleType pwVehicleType = PwVehicleTypeDTO.convertToVehicleType(details);
			pwVehicleType.setUser(userDetails);
			vehicle.save(pwVehicleType);
			return pwVehicleType;
		}else{
            return new PwVehicleType();	
		}

	}

	@Override
	public PwVehicleType updateVehicle(PwVehicleTypeDTO details) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PwVehicleType> findAll(PwUser user) {
		List<PwVehicleType> vehicleList =  vehicle.findByUser(user);
		for (PwVehicleType type : vehicleList){
			System.out.println(type.getVehicleType());
		}
		if (vehicleList != null && vehicleList.size() > 0){
			return vehicleList;
		}else{
			return new ArrayList<>();
		}
	}

	@Override
	public List<PwVehicleType> findAll() {
		List<PwVehicleType> vehicleList = vehicle.findAll();
		if (vehicleList != null && vehicleList.size() > 0){
			return vehicle.findAll();
		}else{
			return new ArrayList<>();
		}
		
	}

	@Override
	public PwVehicleType registerVehicle(PwVehicleType details) {
			return vehicle.save(details);
		}

	@Override
	public boolean deleteVehicle(int vehicleId) {
		try {
			vehicle.delete(vehicleId);
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	}
	
	

