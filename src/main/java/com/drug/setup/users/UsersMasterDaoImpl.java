package com.drug.setup.users;

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

import com.drug.common.EmailService;
import com.drug.common.services.CommonServicesQueryUtil;
import com.drug.core.util.DropDownList;
import com.drug.employeeMaster.EmployeeMasterQueryUtil;
import com.drug.filesupload.FileUploadQueryUtil;
import com.drug.filesupload.FileUploadResultBean;
import com.drug.security.JwtUtils;

@Repository
public class UsersMasterDaoImpl implements UsersMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtUtils jwtUtils;
	
	@Override
	public UsersMasterResultBean save(UsersMasterBean bean) throws Exception {
		UsersMasterResultBean resultBean = new UsersMasterResultBean();
		
		try {
			Map<String, Object> saveMap = new HashMap<String, Object>();
			
			
			saveMap.put("userId", bean.getNewUserName());
			saveMap.put("firstName", bean.getFirstName());
			saveMap.put("lastName", bean.getLastName());
			saveMap.put("mobileNo", bean.getMobileNo());
			saveMap.put("password", encoder.encode(bean.getNewPassword()));
			saveMap.put("emailId", bean.getEmailId());
			saveMap.put("photoUrl", bean.getFileUploadUrl());
			saveMap.put("roleId", bean.getRoles());
			saveMap.put("empName", bean.getFirstName());
			saveMap.put("companyCode", bean.getCompanyCode());
			saveMap.put("userName", bean.getUserName());

			
			String empId =  jdbcTemplate.queryForObject(UsersMasterQueryUtil.GETEMPID, String.class);
			saveMap.put("empId", empId);
			
			int insetEmp = namedParameterJdbcTemplate.update(UsersMasterQueryUtil.INSERT_USER_DETAILS, saveMap);
			
			int insertAppUser = namedParameterJdbcTemplate.update(UsersMasterQueryUtil.INSERT_AppUser, saveMap);
			
			int insertUserRoleMap = namedParameterJdbcTemplate.update(UsersMasterQueryUtil.INSERT_USER_ROLE_MAP, saveMap);
			
			
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<UsersMasterBean> getList() throws Exception {
		List<UsersMasterBean> objCustomerMasterBean = new ArrayList<UsersMasterBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(UsersMasterQueryUtil.getList, new BeanPropertyRowMapper<UsersMasterBean>(UsersMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	@Override
	public UsersMasterResultBean edit(String code) throws Exception {
		UsersMasterResultBean resultBean = new UsersMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setUsersMasterBean(jdbcTemplate.queryForObject(UsersMasterQueryUtil.SELECT_DTL,new Object[] { code }, new BeanPropertyRowMapper<UsersMasterBean>(UsersMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public UsersMasterResultBean delete(Integer cusCode) throws Exception {
		UsersMasterResultBean resultBean = new UsersMasterResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(UsersMasterQueryUtil.DELETE,cusCode);
			}
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}	
		return resultBean;
	}

	@Override
	public UsersMasterResultBean update(UsersMasterBean bean) throws Exception {
		UsersMasterResultBean resultBean = new UsersMasterResultBean();
		try {
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
			    
				namedParameterJdbcTemplate.update(UsersMasterQueryUtil.UPDATE_CUSTOMER_MASTER,customerMasterMap);
			   resultBean.setSuccess(true);
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public UsersMasterResultBean getRoleList() throws Exception {
		UsersMasterResultBean resultBean =new UsersMasterResultBean ();
		resultBean.setSuccess(false);
		try {
			resultBean.setRoleList(jdbcTemplate.query(UsersMasterQueryUtil.GET_ROLE_LIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class)));
			resultBean.setSuccess(true);
			
		}catch(Exception e){
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public UsersMasterResultBean oldPasswordValidation(String inputPwd, String userId) throws Exception {
		// TODO Auto-generated method stub
		UsersMasterResultBean usersMasterResultBean = new UsersMasterResultBean();
		String password = jdbcTemplate.queryForObject(CommonServicesQueryUtil.GETOLDPASSWORD,new Object[] { userId }, String.class);
		
		usersMasterResultBean.setSuccess(false);
		if(!password.isEmpty()) {
			
			if(encoder.matches(inputPwd, password)) {
				usersMasterResultBean.setSuccess(true);
			}else {
				usersMasterResultBean.setSuccess(false);
			}
		}
		
		return usersMasterResultBean;
	}

	@Override
	public UsersMasterResultBean updatePassword(UsersMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
UsersMasterResultBean resultBean = new UsersMasterResultBean();
		
		try {
			Map<String, Object> updateChangePasswordMap = new HashMap<String, Object>();
			
			updateChangePasswordMap.put("newUserName", bean.getNewUserName());
			updateChangePasswordMap.put("newChangePassword", encoder.encode(bean.getNewChangePassword()));
			String  emailId =  jdbcTemplate.queryForObject(UsersMasterQueryUtil.GET_EMAIL_ID,new Object[] { bean.getNewUserName() }, String .class);
			int insertUserRoleMap = namedParameterJdbcTemplate.update(UsersMasterQueryUtil.UPDATE_CHANGE_PASSWORD, updateChangePasswordMap);
			EmailService.sendChangePasswordMail(emailId,bean.getNewUserName());
			
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}




}
