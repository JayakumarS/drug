package com.drug.setup.companyMaster.ReturnMemoItems;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.drug.core.util.DropDownList;
import com.drug.core.util.ResultResponse;
import com.drug.setup.companyMaster.DebitMemo.DebitMemoBean;
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
 			String result = jdbcTemplate.queryForObject(ReturnMemoItemsQueryUtil.INSERT_RETURNMEMOITEMS_MASTER, new Object[]{	
 					bean.getReturnMemoNo(),
 					bean.getNdcupcCode(),
 					"P",
 					bean.getQuantity(),
 					bean.getPrice(),
 					bean.getExpDate(),
 					bean.getReason(),
 					bean.getLotNo(),
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
	public List<ReturnMemoItemsBean> getDebitMemoList(ReturnMemoItemsBean bean) throws Exception {
		List<ReturnMemoItemsBean> objCompanyMasterBean = new ArrayList<ReturnMemoItemsBean>();
		try {
			
			String Query = "SELECT return_memo_items_code as returnMemoItemsCode, lot_no as lotNo, return_memo_no as returnMemoNo, ndcupc_code as ndcupcCode, quantity as quantity, price as price, exp_date as expDate FROM public.return_memo_items where LOWER(return_memo_no) like '%" + bean.getReturnMemoNo().toLowerCase()+ "%'";
			
			   if (bean.getNdcupcCode() != null && bean.getNdcupcCode().trim() != "" && !bean.getNdcupcCode().trim().isEmpty()) {
				   Query += " and LOWER(ndcupc_code) like '%" + bean.getNdcupcCode().toLowerCase() + "%'";				
				}
			   if (bean.getLotNo() != null && bean.getLotNo().trim() != "" && !bean.getLotNo().trim().isEmpty()) {
				   Query += " and LOWER(lot_no) like '%" + bean.getLotNo().toLowerCase() + "%'";				
				}
			   Query += " order by ndcupc_code desc";
			   
			   objCompanyMasterBean =  jdbcTemplate.query(Query,BeanPropertyRowMapper.newInstance(ReturnMemoItemsBean.class));
			   
			   return objCompanyMasterBean;
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
			resultBean.setReturnMemoItems(jdbcTemplate.queryForObject(ReturnMemoItemsQueryUtil.SELECT_DEBITMEMO,new Object[] { code }, new BeanPropertyRowMapper<ReturnMemoItemsBean>(ReturnMemoItemsBean.class)));
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
				jdbcTemplate.update(ReturnMemoItemsQueryUtil.DELETE_RETURNMEMOITEMS,cusCode);
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
 					bean.getReturnMemoItemsCode(),
 					bean.getReturnMemoNo(),
 					bean.getNdcupcCode(),
 					"P",
 					bean.getQuantity(),
 					bean.getPrice(),
 					bean.getExpDate(),
 					bean.getReason(),
 					bean.getLotNo(),
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

	@Override
	public ResultResponse fetchreturnMemoNamebyId(String bean) {
		ResultResponse resultBean = new ResultResponse();
		String returnMemoName="";
		try {
			returnMemoName = jdbcTemplate.queryForObject(ReturnMemoItemsQueryUtil.RETURN_MEMO_NAMEBYID, new Object[]{
					bean}, String.class);	
			resultBean.setText(returnMemoName);
		}catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}
}
