package com.drug.common.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
import com.drug.employeeMaster.EmployeeMasterQueryUtil;
import com.drug.filesupload.FileUploadQueryUtil;
import com.drug.filesupload.FileUploadResultBean;
import com.drug.setup.users.UsersMasterQueryUtil;

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

	

}
