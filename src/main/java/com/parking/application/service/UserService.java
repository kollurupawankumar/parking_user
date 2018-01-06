package com.parking.application.service;

import java.util.List;

import com.parking.application.model.PwUser;

public interface UserService {
	
	public String sendOTPviaMail(String email, String user);
	
	public boolean sendOTPviaMobile(String mobileNumber);
	
	public PwUser registerUser(PwUser user);
	
	public PwUser updateUserDetails(PwUser user);
	
	public String getOTPforEmail(String email);
	
	public String getOTPforPhone(String phone);
	
	public PwUser findUserById(int userId);
	
	public List<PwUser> getUsers();
	
	public boolean deleteUser(int userId);

}
