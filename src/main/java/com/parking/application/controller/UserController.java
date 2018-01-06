package com.parking.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.application.dto.PwUserDTO;
import com.parking.application.model.PwUser;
import com.parking.application.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(path = "parkwisely/user")
@Api(value="User Information",description ="Operations pertaining to users in parking application")
public class UserController {

	@Autowired
	UserService userService;

	@ApiOperation(value = "Sending otp to your email",response = String.class)
	@RequestMapping(path = "/sendOTP", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Accept=*/*",
			produces = "application/json", method = RequestMethod.POST)
	public String sendOTP(@RequestBody PwUserDTO user) {
		System.out.println("Entering into sendOTP");
		return userService.sendOTPviaMail(user.getEmailId(), user.getFirstName());
	}

	@ApiOperation(value = "Registering the user. No need to send the Vehicle information",
			response = PwUser.class)
	@RequestMapping(path = "/register", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, headers = "Accept=*/*",
			produces = "application/json", method = RequestMethod.POST)
	public PwUser registerUser(@RequestBody PwUserDTO user) {
		System.out.println("Entering into register user");
		String checkOtp = userService.getOTPforEmail(user.getEmailId());
		System.out.println("otp value :"+checkOtp);
		if (checkOtp != null && user.getOtp() != null && user.getOtp().equalsIgnoreCase(checkOtp)) {
			PwUser pwUser =  PwUserDTO.generateModelUser(user);
			return userService.registerUser(pwUser);
		}else{
			System.out.println("Invalid otp");
		    return null;	
		}
	}
	
	
	@ApiOperation(value = "Get particular user information for the userId",
			response = PwUser.class)
    @RequestMapping(value = "/get/{userId}", 
			produces = "application/json",method= RequestMethod.GET)
    public PwUser getUser(@PathVariable Integer userId, Model model){
    	PwUser user = userService.findUserById(userId);
        return user;

    }
    
	
	@ApiOperation(value = "Get information of all the users",
			response = List.class)
    @RequestMapping(value = "/get",
			produces = "application/json",method= RequestMethod.GET)
    public List<PwUser> getAllUser(Model model){
    	List<PwUser> users = userService.getUsers();
        return users;

    }
	
	

}
