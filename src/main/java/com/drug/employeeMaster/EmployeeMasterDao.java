package com.drug.employeeMaster;

import java.util.Optional;

import com.drug.core.util.CustomException;
import com.drug.usermanagement.User;

public interface EmployeeMasterDao {
	public EmployeeMasterResultBean addEmployeeMaster(EmployeeMasterBean objEmployee) throws CustomException;
	
	public Optional<User> getEmployeeUserName(String userName) throws CustomException;
}
