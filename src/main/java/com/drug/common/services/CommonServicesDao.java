package com.drug.common.services;

import java.util.HashMap;
import java.util.List;

import com.drug.core.util.DropDownList;
import com.drug.setup.users.UsersMasterBean;

public interface CommonServicesDao {

	boolean validateUserName(String userName);
	
	void insertOtp(String userId, String emailId, String otp);
	
	HashMap<String, Object> validateOtp(String userId,String otp);
	
	UsersMasterBean getUserDetails(String empid);

	Integer getCountValue(String empid);

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoList(String companyId);
	
	HashMap<String, Object> forgotPassword(String userNameEmailId,String otpForForgotPassword);
	
	boolean validateUnique(String tableName,String columnName,String columnValue);

	List<DropDownList> getManufacturerList();

	List<DropDownList> getStateDropdownList();
}
