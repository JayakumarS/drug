package com.drug.setup.companyMaster.DebitMemo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
import com.drug.wholesaler.WholesalerMasterQueryUtil;

@Repository
 
public class DebitMemoDaoImpl implements DebitMemoDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public DebitMemoResultBean save(DebitMemoBean bean) throws Exception {
		DebitMemoResultBean resultBean = new DebitMemoResultBean();
 		try {
 			String result = jdbcTemplate.queryForObject(DebitMemoQueryUtil.INSERT_DEBITMEMO_MASTER, new Object[]{	
 					bean.getReturnMemoNo(),
 					bean.getReturnMemoName(),
 					bean.getReturnMemoDate(),
 					bean.getCompany(),
 					"WEB",
 					bean.getCreatedBy()}, String.class);
		    resultBean.setSuccess(true);
		    System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<DebitMemoBean> getDebitMemoList() throws Exception {
		List<DebitMemoBean> objCompanyMasterBean = new ArrayList<DebitMemoBean>();
		try {
			objCompanyMasterBean = jdbcTemplate.query(DebitMemoQueryUtil.GETDEBITMEMO_LIST, new BeanPropertyRowMapper<DebitMemoBean>(DebitMemoBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCompanyMasterBean;
	}

	@Override
	public DebitMemoResultBean edit(String code) throws Exception {
		DebitMemoResultBean resultBean = new DebitMemoResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDebitMemo(jdbcTemplate.queryForObject(DebitMemoQueryUtil.SELECT_DEBITMEMO,new Object[] { code }, new BeanPropertyRowMapper<DebitMemoBean>(DebitMemoBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public DebitMemoResultBean delete(String cusCode) throws Exception {
		DebitMemoResultBean resultBean = new DebitMemoResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(DebitMemoQueryUtil.DELETE_DEBITMEMO,cusCode);
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
	public DebitMemoResultBean update(DebitMemoBean bean) throws Exception {
		DebitMemoResultBean resultBean = new DebitMemoResultBean();
		try {
 			
 			String result = jdbcTemplate.queryForObject(DebitMemoQueryUtil.UPDATE_DEBITMEMO, new Object[]{
 					bean.getCompany(),
 					bean.getReturnMemoDate(),
 					bean.getReturnMemoName(),
 					bean.getReturnMemoNo()}, String.class);
 			
		    resultBean.setSuccess(true);
		    System.out.print(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	@Override
	public List<DropDownList> getCompanyMasterList() {
		List<DropDownList> customerMasterList = new ArrayList<DropDownList>();
		try {
			customerMasterList = jdbcTemplate.query(DebitMemoQueryUtil.COMPANY_MASTER_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerMasterList;
	}

	@Override
	public List<DropDownList> getDebitMemoDropdownList() {
		List<DropDownList> customerMasterList = new ArrayList<DropDownList>();
		try {
			customerMasterList = jdbcTemplate.query(DebitMemoQueryUtil.DEBIT_MEMO_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerMasterList;
	}
}
