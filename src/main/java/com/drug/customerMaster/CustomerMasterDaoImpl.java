package com.drug.customerMaster;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.drug.wholesaler.WholesalerMasterQueryUtil;

@Repository
 
public class CustomerMasterDaoImpl implements CustomerMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public CustomerMasterResultBean save(CustomerMasterBean bean) throws Exception {
		CustomerMasterResultBean resultBean = new CustomerMasterResultBean();
 		try {
 			//save whosalar
 			String Wholesaler_Code = jdbcTemplate.queryForObject(WholesalerMasterQueryUtil.INSERT_WHOLESALER_MASTER, new Object[]{
 					bean.getWholesalerPolicyCode(),
 					bean.getWholesalerName(),
 					bean.getWholesalerExpiryPacket(),
 					bean.getWholesalerEmailID(),
 					bean.getWholesalerAllowOverride(),
 					bean.getWholesalerDepartment(),
 					bean.getWholesalerStreet(),
 					bean.getWholesalerCity(),
 					bean.getWholesalerState(),
 					bean.getWholesalerZipCode(),
 					bean.getWholesalerPhoneNo(),
 					bean.getWholesalerTollFreeNo(),
 					bean.getWholesalerFax(),
 					bean.getWholesalerPhone()}, String.class);
 			
 			
 			if(bean.getGeneralInfroWacAwapPer()==null || bean.getGeneralInfroWacAwapPer()=="" || bean.getGeneralInfroWacAwapPer().isEmpty()) {
 				bean.setGeneralInfroWacAwapPer("0");
 			}
 			
 			String result = jdbcTemplate.queryForObject(CustomerMasterQueryUtil.INSERT_CUSTOMER_MASTER, new Object[]{
					bean.getCompanyName(),
					bean.getCompanyDba(),
					bean.getCompanyStreet(),
					bean.getCompanyCity(),
					bean.getCompanyState(),
					bean.getCompanyPincode(),
					bean.getCompanyContact(),
					bean.getCompanyEmailID(),
					bean.getCompanyPhone(), 
					bean.getCompanyFax(),
					
					bean.getDefNumber(),
					bean.getDefExpirationDate(),
					 

					bean.getAuthorizedClasses(),
					bean.getCompanyFacilityType(),
					
					bean.getIssuesCreditsName(),
					bean.getIssuesCreditsStreet(),
					bean.getIssuesCreditsCity(),
					bean.getIssuesCreditsState(),
					bean.getIssuesCreditsZipCode(),
					bean.getIssuesCreditsPhone(),

					bean.getGeneralInfroWacAwapMyprice(),
					//"WAC",
					bean.getGeneralInfroWacAwapPer(),

					bean.getMyWholesalerPolicyType(),
					bean.getMyWholesalerPolicyMonths(),
					
					bean.isMyWholesalerCpp(),
					bean.getCppServiceRate(),
					bean.getCppShippingRate(),
					bean.getCppNoOfChecks(),
					Wholesaler_Code}, String.class);
 			
		    resultBean.setSuccess(true);
		    System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<CustomerMasterBean> getCustomerList() throws Exception {
		List<CustomerMasterBean> objCustomerMasterBean = new ArrayList<CustomerMasterBean>();
		try {
			objCustomerMasterBean = jdbcTemplate.query(CustomerMasterQueryUtil.getCustomerList, new BeanPropertyRowMapper<CustomerMasterBean>(CustomerMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCustomerMasterBean;
	}

	@Override
	public CustomerMasterResultBean edit(String code) throws Exception {
		CustomerMasterResultBean resultBean = new CustomerMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setCustomerMasterBean(jdbcTemplate.queryForObject(CustomerMasterQueryUtil.SELECT_CUSTOMER_DTL,new Object[] { code }, new BeanPropertyRowMapper<CustomerMasterBean>(CustomerMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public CustomerMasterResultBean delete(String cusCode) throws Exception {
		CustomerMasterResultBean resultBean = new CustomerMasterResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(CustomerMasterQueryUtil.DELETE_CUSTOMER,cusCode);
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
	public CustomerMasterResultBean update(CustomerMasterBean bean) throws Exception {
		CustomerMasterResultBean resultBean = new CustomerMasterResultBean();
		try {

			String Wholesaler_Code= jdbcTemplate.queryForObject(WholesalerMasterQueryUtil.UPDATE_WHOLESALER_MASTER, new Object[]{
 					bean.getWholesalerCode(),
 					bean.getWholesalerPolicyCode(),
 					bean.getWholesalerName(),
 					bean.getWholesalerExpiryPacket(),
 					bean.getWholesalerEmailID(),
 					bean.getWholesalerAllowOverride(),
 					bean.getWholesalerDepartment(),
 					bean.getWholesalerStreet(),
 					bean.getWholesalerCity(),
 					bean.getWholesalerState(),
 					bean.getWholesalerZipCode(),
 					bean.getWholesalerPhoneNo(),
 					bean.getWholesalerTollFreeNo(),
 					bean.getWholesalerFax(),
 					bean.getWholesalerPhone()}, String.class);
			
			if(bean.getGeneralInfroWacAwapPer()==null || bean.getGeneralInfroWacAwapPer()=="" || bean.getGeneralInfroWacAwapPer().isEmpty()) {
 				bean.setGeneralInfroWacAwapPer("0");
 			}
 			
 			String result = jdbcTemplate.queryForObject(CustomerMasterQueryUtil.UPDATE_CUSTOMER_MASTER, new Object[]{
 					bean.getCompanyCode(),
					bean.getCompanyName(),
					bean.getCompanyDba(),
					bean.getCompanyStreet(),
					bean.getCompanyCity(),
					bean.getCompanyState(),
					bean.getCompanyPincode(),
					bean.getCompanyContact(),
					bean.getCompanyEmailID(),
					bean.getCompanyPhone(), 
					bean.getCompanyFax(),
					
					bean.getDefNumber(),
					bean.getDefExpirationDate(),
					 

					bean.getAuthorizedClasses(),
					bean.getCompanyFacilityType(),
					
					bean.getIssuesCreditsName(),
					bean.getIssuesCreditsStreet(),
					bean.getIssuesCreditsCity(),
					bean.getIssuesCreditsState(),
					bean.getIssuesCreditsZipCode(),
					bean.getIssuesCreditsPhone(),

					bean.getGeneralInfroWacAwapMyprice(),
					//"WAC",
					bean.getGeneralInfroWacAwapPer(),

					bean.getMyWholesalerPolicyType(),
					bean.getMyWholesalerPolicyMonths(),
					
					bean.isMyWholesalerCpp(),
					bean.getCppServiceRate(),
					bean.getCppShippingRate(),
					bean.getCppNoOfChecks(),
					bean.getWholesalerCode()}, String.class);
 			
		    resultBean.setSuccess(true);
		    System.out.print(result);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}


}
