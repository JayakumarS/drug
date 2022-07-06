package com.drug.wholesaler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import com.drug.setup.users.UsersMasterBean;

@Service
public class WholesalerMasterDaoImpl implements WholesalerMasterDao {

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public WholesalerMasterResultBean save(WholesalerMasterBean bean) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
 		try {
 		
 			
 			int result= jdbcTemplate.update(WholesalerMasterQueryUtil.INSERT_WHOLESALER_MASTER,
 					bean.getPolicyCode(),
 					bean.getWholesalerName(),
 					bean.getExpiryPacket(),
 					bean.getEmailID(),
 					bean.getAllowOverride(),
 					bean.getDepartment(),
 					bean.getStreet(),
 					bean.getCity(),
 					bean.getState(),
 					bean.getZipCode(),
 					bean.getPhoneNo(),
 					bean.getTollFreeNo(),
 					bean.getFax(),
 					bean.getContact());

		    resultBean.setSuccess(true);
		    System.out.print(result);
		}catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		
		return resultBean;
	}

	@Override
	public List<WholesalerMasterBean> getList() throws Exception {
		List<WholesalerMasterBean> objWholesalerMasterBean = new ArrayList<WholesalerMasterBean>();
		try {
			objWholesalerMasterBean = jdbcTemplate.query(WholesalerMasterQueryUtil.GET_WHOLESALER_LIST, new BeanPropertyRowMapper<WholesalerMasterBean>(WholesalerMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objWholesalerMasterBean;
	}

	@Override
	public WholesalerMasterResultBean edit(String code) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setWholesalerMasterBean(jdbcTemplate.queryForObject(WholesalerMasterQueryUtil.GETCUSCODE,new Object[] { code }, new BeanPropertyRowMapper<WholesalerMasterBean>(WholesalerMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public WholesalerMasterResultBean delete(Integer code) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
		try {
			if(code!=null) {
				jdbcTemplate.update(WholesalerMasterQueryUtil.DELETE_CUSTOMER,code);
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
	public WholesalerMasterResultBean update(WholesalerMasterBean bean) throws Exception {
		WholesalerMasterResultBean resultBean = new WholesalerMasterResultBean();
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
			    
				namedParameterJdbcTemplate.update(WholesalerMasterQueryUtil.GETCUSCODE,customerMasterMap);
			   resultBean.setSuccess(true);
			
//			uomCategoryMap.put("categoryName", bean.getCategoryName());
//			uomCategoryMap.put("categoryDesp", bean.getCategoryDesp());
//			uomCategoryMap.put("uomCode", bean.getUomCode());
//			namedParameterJdbcTemplate.update(WholesalerMasterQueryUtil.UPDATE_UOM_CATEGORY,uomCategoryMap);
//		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return resultBean;
	}

	


}
