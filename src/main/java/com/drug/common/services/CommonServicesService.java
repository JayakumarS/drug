package com.drug.common.services;

import java.util.HashMap;

import com.drug.setup.users.UsersMasterBean;

public interface CommonServicesService {
	
	boolean validateUserName(String userName);
	
	void insertOtp(String userId,String emailId,String otp);
	
	HashMap<String, Object> validateOtp(String userId,String otp);
	
	String getUserDetails(String empid);
	
}