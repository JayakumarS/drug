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
	public List<DebitMemoBean> getDebitMemoList(DebitMemoBean bean) throws Exception {
		List<DebitMemoBean> objCompanyMasterBean = new ArrayList<DebitMemoBean>();
		try {
			
			String Query = "SELECT retMom.return_memo_no as returnMemoNo , retMom.return_memo_name as returnMemoName, retMom.return_memo_date as returnMemoDate, com.company_name as company from public.return_memo retMom left outer join company com on com.company_code=retMom.company where LOWER(retMom.company) like '%" + bean.getCompany().toLowerCase()+ "%'";
					
		   if (bean.getReturnMemoNo() != null && bean.getReturnMemoNo().trim() != "" && !bean.getReturnMemoNo().trim().isEmpty()) {
			   Query += " and LOWER(retMom.return_memo_no) like '%" + bean.getReturnMemoNo().toLowerCase() + "%'";				
			}
		   
		   Query += " order by return_memo_no desc";
		   
		   objCompanyMasterBean =  jdbcTemplate.query(Query,BeanPropertyRowMapper.newInstance(DebitMemoBean.class));
		   
		   return objCompanyMasterBean;
			
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
 					bean.getReturnMemoNo(),
 					bean.getReturnMemoName(),
 					bean.getReturnMemoDate(),
 					bean.getCompany(),
 					"WEB",
 					bean.getCreatedBy()}, String.class);
 			
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
