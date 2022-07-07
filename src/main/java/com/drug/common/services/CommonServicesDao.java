package com.drug.common.services;

import java.util.HashMap;

public interface CommonServicesDao {

	boolean validateUserName(String userName);
	
	void insertOtp(String userId, String emailId, String otp);
	
	HashMap<String, Object> validateOtp(String userId,String otp);
}
