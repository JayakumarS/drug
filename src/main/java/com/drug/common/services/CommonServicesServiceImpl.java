package com.drug.common.services;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.setup.users.UsersMasterBean;

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

	@Override
	public String getUserDetails(String empid) {
		// TODO Auto-generated method stub
		return commonServicesDao.getUserDetails(empid);
	}

	@Override
	public Integer getCountValue(String empid) {
		// TODO Auto-generated method stub
		return commonServicesDao.getCountValue(empid);
	}

	@Override
	public HashMap<String, Object> forgotPassword(String userNameEmailId,String otpForForgotPassword) {
		// TODO Auto-generated method stub
		return commonServicesDao.forgotPassword(userNameEmailId,otpForForgotPassword);
	}

	@Override
	public boolean validateUnique(String tableName, String columnName, String columnValue) {
		// TODO Auto-generated method stub
		return commonServicesDao.validateUnique(tableName,columnName,columnValue);
	}


	
}
