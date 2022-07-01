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
		jdbcTemplate.update(CustomerMasterQueryUtil.INSERT_CUSTOMER_MASTER,
					"dsf",
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
					 

					"2N",
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
					bean.getCppNoOfChecks());
		    resultBean.setSuccess(true);
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
			Map<String, Object> customerMasterMap = new HashMap<String, Object>();
		    
//			 customerMasterMap.put("country", bean.getCountry());
//			    customerMasterMap.put("city", bean.getCity());
//			    customerMasterMap.put("territory", bean.getTerritory());
//			    customerMasterMap.put("salesPerson", bean.getSalesPerson());
//			    customerMasterMap.put("addressOfCus", bean.getAddressOfCus());
//			    customerMasterMap.put("business", bean.getBusiness());
//			    customerMasterMap.put("stp", bean.getStp());
//			    customerMasterMap.put("organisationName", bean.getOrganisationName());
//			    customerMasterMap.put("zipCode", bean.getZipCode());
//			    customerMasterMap.put("shortName", bean.getShortName());
//			    customerMasterMap.put("cusWebsite", bean.getCusWebsite());
//			    customerMasterMap.put("companyRegn", bean.getCompanyRegn());
//			    customerMasterMap.put("keyName", bean.getKeyName());
//			    
//			    customerMasterMap.put("keyNumber", bean.getKeyNumber());
//			    customerMasterMap.put("transactionGST", bean.getTransactionGST());
//			    customerMasterMap.put("vatNumber", bean.getVatNumber());
//			    customerMasterMap.put("panNumber", bean.getPanNumber());
//			    
//			    customerMasterMap.put("paymentCenter", bean.getPaymentCenter());
//			    customerMasterMap.put("creditLimit", bean.getCreditLimit());
//			    customerMasterMap.put("creditUsd", bean.getCreditUsd());
//			    customerMasterMap.put("creditDays", bean.getCreditDays());
//			    customerMasterMap.put("keymail", bean.getKeymail());
//			    
//			    customerMasterMap.put("notificationMail", bean.getNotificationMail());
//			    customerMasterMap.put("invoiceMail", bean.getInvoiceMail());
//			    customerMasterMap.put("creditAgreement", bean.getCreditAgreement());
//			    customerMasterMap.put("kycDoc", bean.getKycDoc());
//			    customerMasterMap.put("exemptionDoc", bean.getExemptionDoc());
//			    customerMasterMap.put("nonGstDoc", bean.getNonGstDoc());
//			    customerMasterMap.put("name", bean.getName());
//			    customerMasterMap.put("designation", bean.getDesignation());
//			    customerMasterMap.put("department", bean.getDepartment());
//			    
//			    customerMasterMap.put("phoneno", bean.getPhoneno());
//			    customerMasterMap.put("landline", bean.getLandline());
//			    customerMasterMap.put("email", bean.getEmail());
//				customerMasterMap.put("cusCode", bean.getCusCode());
			    
				namedParameterJdbcTemplate.update(CustomerMasterQueryUtil.UPDATE_CUSTOMER_MASTER,customerMasterMap);
			   resultBean.setSuccess(true);
			
//			uomCategoryMap.put("categoryName", bean.getCategoryName());
//			uomCategoryMap.put("categoryDesp", bean.getCategoryDesp());
//			uomCategoryMap.put("uomCode", bean.getUomCode());
//			namedParameterJdbcTemplate.update(CustomerMasterQueryUtil.UPDATE_UOM_CATEGORY,uomCategoryMap);
//		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}


}
