package com.drug.setup.users;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
import com.drug.filesupload.FileUploadQueryUtil;
import com.drug.filesupload.FileUploadResultBean;

@Repository
public class UsersMasterDaoImpl implements UsersMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public UsersMasterResultBean save(UsersMasterBean bean) throws Exception {
		UsersMasterResultBean resultBean = new UsersMasterResultBean();
		try {
			Map<String, Object> saveMap = new HashMap<String, Object>();
			saveMap.put("fileUploadUrl", bean.getFileUploadUrl());
			
			
			namedParameterJdbcTemplate.update(UsersMasterQueryUtil.INSERT,saveMap);
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
	public UsersMasterResultBean edit(Integer code) throws Exception {
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


}
