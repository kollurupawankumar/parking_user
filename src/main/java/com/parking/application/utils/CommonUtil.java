package com.parking.application.utils;

public class CommonUtil {

	/**
	 * Code used to send OTP
	 * 
	 * @return
	 */
	public static String generatePIN() {
		int randomPIN = (int) (Math.random() * 9000) + 1000;
		return String.valueOf(randomPIN);
	}

}
