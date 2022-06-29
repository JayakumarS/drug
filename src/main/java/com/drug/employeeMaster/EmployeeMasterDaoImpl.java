package com.drug.employeeMaster;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.common.ErrorMessage;
import com.drug.core.util.CustomException;
import com.drug.usermanagement.User;

@Repository
public class EmployeeMasterDaoImpl implements EmployeeMasterDao{
	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeMasterDaoImpl.class);
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public EmployeeMasterResultBean addEmployeeMaster(EmployeeMasterBean objEmployee) throws CustomException {
		EmployeeMasterResultBean objEmployeeMasterResultBean = new EmployeeMasterResultBean();
		objEmployeeMasterResultBean.setSuccess(false);
		try {
			
			
			
			Map<String, Object> empMap = new HashMap<String, Object>();
			empMap.put("userId", objEmployee.getUsername());
			empMap.put("password", objEmployee.getPassword());
			empMap.put("empUserName", objEmployee.getEmpName());
			empMap.put("emailId", objEmployee.getEmail());
			empMap.put("empUserId", objEmployee.getUsername());
			String empId =  jdbcTemplate.queryForObject(EmployeeMasterQueryUtil.GETEMPID, String.class);
			empMap.put("empId", empId);
			
			int insetEmp = namedParameterJdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_Employee, empMap);
			
			int insertAppUser = namedParameterJdbcTemplate.update(EmployeeMasterQueryUtil.INSERT_AppUser, empMap);
			objEmployeeMasterResultBean.setSuccess(true);

		} catch (Exception e) {
			LOGGER.error("Error in addEmployeeMaster", e);
			objEmployeeMasterResultBean.setSuccess(false);
			objEmployeeMasterResultBean.setMessage(ErrorMessage.ERROR_ADD);
			throw new CustomException(ErrorMessage.ERROR_ADD);
		}
		
		return objEmployeeMasterResultBean;
	}

	@Override
	public Optional<User> getEmployeeUserName(String userName) throws CustomException {
		// TODO Auto-generated method stub
		Optional<User> userDetails = Optional.empty();
		//List<User> user = new ArrayList<User>();
		
		
		try {
			User user= jdbcTemplate.queryForObject(EmployeeMasterQueryUtil.GETUSERDETAILS, new Object[] { userName }, new BeanPropertyRowMapper<User>(User.class)); 
			//userDetails = 
			userDetails = Optional.of(user);
		} catch (Exception e) {
			LOGGER.error("Error in getEmployeeUserName", e);
			throw new CustomException(ErrorMessage.ERROR_LIST);
		}
		return userDetails;
	}

}
