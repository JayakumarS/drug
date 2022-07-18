package com.drug.setup.companyMaster.ReturnMemoItems;

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
 
public class ReturnMemoItemsDaoImpl implements ReturnMemoItemsDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public ReturnMemoItemsResultBean save(ReturnMemoItemsBean bean) throws Exception {
		ReturnMemoItemsResultBean resultBean = new ReturnMemoItemsResultBean();
 		try {
 			String result = jdbcTemplate.queryForObject(ReturnMemoItemsQueryUtil.INSERT_DEBITMEMO_MASTER, new Object[]{	
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
	public List<ReturnMemoItemsBean> getDebitMemoList() throws Exception {
		List<ReturnMemoItemsBean> objCompanyMasterBean = new ArrayList<ReturnMemoItemsBean>();
		try {
			objCompanyMasterBean = jdbcTemplate.query(ReturnMemoItemsQueryUtil.GETDEBITMEMO_LIST, new BeanPropertyRowMapper<ReturnMemoItemsBean>(ReturnMemoItemsBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCompanyMasterBean;
	}

	@Override
	public ReturnMemoItemsResultBean edit(String code) throws Exception {
		ReturnMemoItemsResultBean resultBean = new ReturnMemoItemsResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setDebitMemo(jdbcTemplate.queryForObject(ReturnMemoItemsQueryUtil.SELECT_DEBITMEMO,new Object[] { code }, new BeanPropertyRowMapper<ReturnMemoItemsBean>(ReturnMemoItemsBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public ReturnMemoItemsResultBean delete(String cusCode) throws Exception {
		ReturnMemoItemsResultBean resultBean = new ReturnMemoItemsResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(ReturnMemoItemsQueryUtil.DELETE_DEBITMEMO,cusCode);
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
	public ReturnMemoItemsResultBean update(ReturnMemoItemsBean bean) throws Exception {
		ReturnMemoItemsResultBean resultBean = new ReturnMemoItemsResultBean();
		try {
 			
 			String result = jdbcTemplate.queryForObject(ReturnMemoItemsQueryUtil.UPDATE_DEBITMEMO, new Object[]{
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
			customerMasterList = jdbcTemplate.query(ReturnMemoItemsQueryUtil.COMPANY_MASTER_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerMasterList;
	}

	@Override
	public List<DropDownList> getDebitMemoDropdownList() {
		List<DropDownList> customerMasterList = new ArrayList<DropDownList>();
		try {
			customerMasterList = jdbcTemplate.query(ReturnMemoItemsQueryUtil.DEBIT_MEMO_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerMasterList;
	}
}
