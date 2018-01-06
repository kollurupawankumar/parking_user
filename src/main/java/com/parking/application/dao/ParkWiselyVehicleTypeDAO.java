package com.parking.application.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.parking.application.model.PwUser;
import com.parking.application.model.PwVehicleType;


@Repository
public interface ParkWiselyVehicleTypeDAO extends JpaRepository<PwVehicleType, Integer>{
	
	public List<PwVehicleType> findByUser(PwUser user);

}
