package com.parking.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.application.dto.PwVehicleTypeDTO;
import com.parking.application.model.PwUser;
import com.parking.application.model.PwVehicleType;
import com.parking.application.service.UserService;
import com.parking.application.service.VehicleService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "parkwisely/vehicle")
@Api(value="Vehicle Information",description ="Operations pertaining to Vehicles in parking application")
public class VehicleController {

	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	UserService userService;

	@ApiOperation(value = "Registering the vehicle for an user. Send user userId only along with vehicle information.",
			response = PwVehicleType.class)
	@RequestMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Accept=*/*",
			produces = "application/json", method = RequestMethod.POST)
	public PwVehicleType registerVehicle(@RequestBody PwVehicleTypeDTO vehicle) {
		System.out.println("Entering into register vehicle");
		return vehicleService.registerVehicle(vehicle);
	}
	
	@ApiOperation(value = "Get all the vehicles from the system.",
			response = List.class)
	@RequestMapping(path = "/getAllVehicles",  
			produces = "application/json", method = RequestMethod.GET)
	public List<PwVehicleType> getAllVehiclesForUser(){
			return vehicleService.findAll();
		
	}
	
	@ApiOperation(value = "Get all the vehicles from the system for a particular id.",
			response = List.class)
	@RequestMapping(path = "/getUserVehicles/{userId}", 
			produces = "application/json", method = RequestMethod.GET)
	public List<PwVehicleType> getAllVehiclesForUser(@PathVariable Integer userId){
		PwUser user = userService.findUserById(userId);
		if (user != null){
			return vehicleService.findAll(user);
		}else{
			return new ArrayList<>();
		}
		
	}

}
