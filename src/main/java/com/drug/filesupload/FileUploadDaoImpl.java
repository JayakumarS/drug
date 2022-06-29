package com.drug.filesupload;

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

@Repository
public class FileUploadDaoImpl implements FileUploadDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public FileUploadResultBean save(FileUploadBean bean) throws Exception {
		FileUploadResultBean resultBean = new FileUploadResultBean();
		try {
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
			 customerMasterMap.put("customer", bean.getCustomer());
			 customerMasterMap.put("fileUploadUrl", bean.getFileUploadUrl());
			namedParameterJdbcTemplate.update(FileUploadQueryUtil.INSERT_FILE_UPLOAD,customerMasterMap);
		   resultBean.setSuccess(true);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<FileUploadBean> getList() throws Exception {
		List<FileUploadBean> objCustomerMasterBean = new ArrayList<FileUploadBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(FileUploadQueryUtil.getList, new BeanPropertyRowMapper<FileUploadBean>(FileUploadBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	@Override
	public FileUploadResultBean edit(String code) throws Exception {
		FileUploadResultBean resultBean = new FileUploadResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setFileUploadBean(jdbcTemplate.queryForObject(FileUploadQueryUtil.SELECT_CUSTOMER_DTL,new Object[] { code }, new BeanPropertyRowMapper<FileUploadBean>(FileUploadBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public FileUploadResultBean delete(String cusCode) throws Exception {
		FileUploadResultBean resultBean = new FileUploadResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(FileUploadQueryUtil.DELETE_CUSTOMER,cusCode);
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
	public FileUploadResultBean update(FileUploadBean bean) throws Exception {
		FileUploadResultBean resultBean = new FileUploadResultBean();
		try {
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
		    
			
			    
				namedParameterJdbcTemplate.update(FileUploadQueryUtil.UPDATE_CUSTOMER_MASTER,customerMasterMap);
			   resultBean.setSuccess(true);
	
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public FileUploadResultBean getCustomerList() throws Exception {
		FileUploadResultBean customerBean =new FileUploadResultBean ();
		customerBean.setSuccess(false);
		try {
			customerBean.setCustomerList(jdbcTemplate.query(FileUploadQueryUtil.GET_CUSTOMER_LIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class)));
			customerBean.setSuccess(true);
			
		}catch(Exception e){
			e.printStackTrace();
			customerBean.setSuccess(false);
		}
		return customerBean;
	}

}
