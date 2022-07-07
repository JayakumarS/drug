package com.drug.common.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommonServicesServiceImpl implements CommonServicesService {
	@Autowired
	CommonServicesDao commonServicesDao;

	@Override
	public boolean validateUserName(String userName) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateUserName(userName);
	}

	@Override
	public void insertOtp(String userId, String emailId, String otp) {
		// TODO Auto-generated method stub
		commonServicesDao.insertOtp(userId, emailId, otp);
	}

	@Override
	public HashMap<String, Object> validateOtp(String userId, String otp) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateOtp(userId, otp);
	}


	
}
