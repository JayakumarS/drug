package com.drug.common.services;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.setup.users.UsersMasterBean;

@Repository
public class CommonServicesDaoImpl implements CommonServicesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public boolean validateUserName(String userName) {
		// TODO Auto-generated method stub
		boolean count =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.GETUSERNAME,new Object[] { userName }, Boolean.class);
		if (count) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public void insertOtp(String userId, String emailId, String otp) {
		// TODO Auto-generated method stub
		HashMap<String,Object> saveMap = new HashMap();
		saveMap.put("userId", userId);saveMap.put("emailId", emailId);saveMap.put("otp", otp);
		namedParameterJdbcTemplate.update(CommonServicesQueryUtil.INSERT_OTP, saveMap);
		namedParameterJdbcTemplate.update(CommonServicesQueryUtil.INSERT_OTP_HISTORY, saveMap);
		
	}

	@Override
	public HashMap<String, Object> validateOtp(String userId, String otp) {
		// TODO Auto-generated method stub
		boolean count =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.VALIDATE_OTP,new Object[] { userId,otp }, Boolean.class);
		HashMap<String,Object> otpMap = new HashMap();
		otpMap.put("success", false);
		if(count) {
			otpMap.put("success", true);
			otpMap.put("message", "valid OTP");
		}else {
			otpMap.put("success", false);
			otpMap.put("message", "Entered OTP is invalid or Expired");
		}
		
		return otpMap;
	}

	@Override
	public String getUserDetails(String empid) {
		// TODO Auto-generated method stub
		String  usersMasterBean =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.GETUSERDETAILS,new Object[] { empid }, String .class);
		return usersMasterBean;
	}

	

}
