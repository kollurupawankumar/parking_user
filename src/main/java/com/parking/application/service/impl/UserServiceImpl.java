package com.parking.application.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.parking.application.dao.ParkWiselyOtpInformationDAO;
import com.parking.application.dao.ParkWiselyUserDAO;
import com.parking.application.model.PwOtpInformation;
import com.parking.application.model.PwUser;
import com.parking.application.service.UserService;
import com.parking.application.utils.CommonUtil;
import com.parking.application.utils.SendMail;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	ParkWiselyUserDAO pwUserDAO;

	@Autowired
	ParkWiselyOtpInformationDAO pwOtpinfo;

	@Override
	public boolean sendOTPviaMobile(String mobileNumber) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public PwUser registerUser(PwUser user) {
		return pwUserDAO.save(user);
	}

	@Override
	public PwUser updateUserDetails(PwUser user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String sendOTPviaMail(String email, String user) {
		String getOtp = CommonUtil.generatePIN();
		boolean status = SendMail.sendEmail(email, user, getOtp);
		if (status) {
			PwOtpInformation entity = new PwOtpInformation();
			entity.setEmail(email);
			entity.setOtp(getOtp);
			pwOtpinfo.saveAndFlush(entity);
			if (entity.getOtpId() != 0) {
				return "Successfully send the OTP to the emailId...";
			}

		}
		return "Error while send the email. Please enter vaild email Address";
	}

	@Override
	public String getOTPforEmail(String email) {
		/*PwOtpInformation information = new PwOtpInformation();
		information.setEmail(email);
		Example<PwOtpInformation> example = Example.of(information);
		List<PwOtpInformation> list = pwOtpinfo.findAll(example);*/
		
		List<PwOtpInformation> list = pwOtpinfo.findByEmail(email);
		if (list.size() != 0){
			return list.get(0).getOtp();
		}
		return "error";
	}

	@Override
	public String getOTPforPhone(String phone) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PwUser findUserById(int userId) {
		return pwUserDAO.findOne(userId);
	}

	@Override
	public List<PwUser> getUsers() {
		return pwUserDAO.findAll();
	}

	@Override
	public boolean deleteUser(int userId) {
		try {
			pwUserDAO.delete(userId);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
