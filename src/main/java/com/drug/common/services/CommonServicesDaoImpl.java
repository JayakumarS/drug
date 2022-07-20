package com.drug.common.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
import com.drug.setup.companyMaster.CompanyMasterQueryUtil;
import com.drug.common.EmailService;
import com.drug.setup.users.UsersMasterBean;

@Repository
public class CommonServicesDaoImpl implements CommonServicesDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	PasswordEncoder encoder;
	
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
		Integer otpCount = jdbcTemplate.queryForObject(CommonServicesQueryUtil.GETOTPVALUE,new Object[] { userId }, Integer .class);
		if(otpCount==0) {
			namedParameterJdbcTemplate.update(CommonServicesQueryUtil.INSERT_OTP, saveMap);
			namedParameterJdbcTemplate.update(CommonServicesQueryUtil.INSERT_OTP_HISTORY, saveMap);
		}
		else {
			jdbcTemplate.queryForObject(CommonServicesQueryUtil.DELETE_OTP,new Object[] { userId }, String .class);
			namedParameterJdbcTemplate.update(CommonServicesQueryUtil.INSERT_OTP, saveMap);
			namedParameterJdbcTemplate.update(CommonServicesQueryUtil.INSERT_OTP_HISTORY, saveMap);
		}
		
		
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

	@Override
	public Integer getCountValue(String empid) {
		// TODO Auto-generated method stub
		Integer  countBean =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.GETCOUNTVALUE,new Object[] { empid }, Integer .class);
		return countBean;
	}

	@Override
	public List<DropDownList> getCompanyMasterList() {
		List<DropDownList> dropDownList = new ArrayList<DropDownList>();
		try {
			dropDownList = jdbcTemplate.query(CommonServicesQueryUtil.COMPANY_MASTER_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return dropDownList;
	}

	@Override
	public List<DropDownList> getDebitMemoList(String companyId) {
		List<DropDownList> dropDownList = new ArrayList<DropDownList>();
		try {
		//String  emailId =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.GET_EMAIL_ID,new Object[] { userNameEmailId }, String .class);
			dropDownList = jdbcTemplate.query(CommonServicesQueryUtil.DEBIT_MEMO_DROPDOWNLIST, new Object[] { companyId }, new BeanPropertyRowMapper<>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return dropDownList;
	}
	
	public HashMap<String, Object> forgotPassword(String userNameEmailId,String otpForForgotPassword) {
		// TODO Auto-generated method stub
		HashMap<String,Object> saveMap = new HashMap();
		saveMap.put("userNameEmailId", userNameEmailId);
		saveMap.put("otpForForgotPassword",encoder.encode(otpForForgotPassword));
		System.out.println("New Password is "+otpForForgotPassword);
		if(userNameEmailId.contains("@")) {
			namedParameterJdbcTemplate.update(CommonServicesQueryUtil.UPDATE_PASSWORD_WITH_EMAIL, saveMap);
		}
		else{
			try {
				String  emailId =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.GET_EMAIL_ID,new Object[] { userNameEmailId }, String .class);
				namedParameterJdbcTemplate.update(CommonServicesQueryUtil.UPDATE_PASSWORD_WITHOUT_EMAIL, saveMap);
				EmailService.sendForgotPasswordMail(emailId,userNameEmailId,otpForForgotPassword);
				saveMap.put("message", "Your Password was changed.Please Check your email");
			}
			catch(Exception e) {
				e.printStackTrace();
			}
			
		}
		
		saveMap.put("success", true);
		return saveMap;
	}

	@Override
	public boolean validateUnique(String tableName, String columnName, String columnValue) {
		// TODO Auto-generated method stub
		boolean count =  jdbcTemplate.queryForObject(CommonServicesQueryUtil.VALIDATE_UNIQUE,new Object[] { tableName,columnName,columnValue }, Boolean.class);
		return count;
	}

	@Override
	public List<DropDownList> getManufacturerList() {
		List<DropDownList> dropDownList = new ArrayList<DropDownList>();
		try {
			dropDownList = jdbcTemplate.query(CommonServicesQueryUtil.GET_MANUFACTURER_LIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return dropDownList;
	}

	

}
