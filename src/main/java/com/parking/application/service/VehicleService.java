package com.parking.application.service;

import java.util.List;

import com.parking.application.dto.PwVehicleTypeDTO;
import com.parking.application.model.PwUser;
import com.parking.application.model.PwVehicleType;

public interface VehicleService {
	
	public PwVehicleType registerVehicle(PwVehicleTypeDTO details);
	
	public PwVehicleType registerVehicle(PwVehicleType details);
	
	public List<PwVehicleType> findAll(PwUser user);
	
	public PwVehicleType updateVehicle(PwVehicleTypeDTO details);
	
	public List<PwVehicleType> findAll();
	
	public boolean deleteVehicle(int vehicleId);

}
