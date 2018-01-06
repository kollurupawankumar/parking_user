package com.parking.application.mvc.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.parking.application.model.PwUser;
import com.parking.application.model.PwVehicleType;
import com.parking.application.service.UserService;
import com.parking.application.service.VehicleService;

@Controller
@RequestMapping(path = "parkwisely/mvc")
public class VehicleMVCController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	UserService userService;
	
	
	@RequestMapping("/vehicles")
	public ModelAndView getAllVehicles(Model model) {
		try {
			model.addAttribute("vehicle", vehicleService.findAll());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ModelAndView("vehicles");
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/vehicle/getbyuser")
	public String getAllUserVehicles(Model model, int userId) throws Exception {

		try {
			System.out.println("Billa is here");
			PwUser user = userService.findUserById(userId);
			List<PwVehicleType> vehicleList = vehicleService.findAll(user);
			model.addAttribute("vehicles", vehicleList);
			model.addAttribute("vehicle", new PwVehicleType());
			model.addAttribute("userId", userId);
		} catch (Exception e) {
			return "error";
		}
		return "user_vehicles";
	}
	
	
	@RequestMapping(method = RequestMethod.POST, value = "/vehicle/add")
	public String addVehicle(@ModelAttribute PwVehicleType vehicle, 
							 int userId,
							 Model model) throws Exception {

		try {
			PwUser user = userService.findUserById(userId);
			vehicle.setUser(user);
			vehicle.setEfftdt(new Date());
			vehicleService.registerVehicle(vehicle);
			List<PwVehicleType> vehicleList = vehicleService.findAll(user);
			model.addAttribute("vehicles", vehicleList);
			model.addAttribute("vehicle", new PwVehicleType());
			model.addAttribute("userId", userId);
		} catch (Exception e) {
			return "error";
		}
		return "user_vehicles";
	}
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/vehicle/delete")
	public String deleteVehicle(Model model,int vehicleId,int userId) throws Exception {
		try {
			System.out.println(vehicleId + "   "+ userId);
			PwUser user = userService.findUserById(userId);
			vehicleService.deleteVehicle(vehicleId);
			List<PwVehicleType> vehicleList = vehicleService.findAll(user);
			model.addAttribute("vehicles", vehicleList);
			model.addAttribute("vehicle", new PwVehicleType());
			model.addAttribute("userId", userId);
		} catch (Exception e) {
			return "error";
		}
		return "user_vehicles";
	}
	

}
