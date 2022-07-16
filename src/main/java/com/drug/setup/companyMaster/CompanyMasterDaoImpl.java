package com.drug.setup.companyMaster;

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
 
public class CompanyMasterDaoImpl implements CompanyMasterDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
	@Autowired
	NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception {
		CompanyMasterResultBean resultBean = new CompanyMasterResultBean();
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
 			
 			String result = jdbcTemplate.queryForObject(CompanyMasterQueryUtil.INSERT_COMPANY_MASTER, new Object[]{
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
	public List<CompanyMasterBean> getCompanyList() throws Exception {
		List<CompanyMasterBean> objCompanyMasterBean = new ArrayList<CompanyMasterBean>();
		try {
			objCompanyMasterBean = jdbcTemplate.query(CompanyMasterQueryUtil.GETCOMPANY_LIST, new BeanPropertyRowMapper<CompanyMasterBean>(CompanyMasterBean.class));
			
		}catch(Exception e){
			e.printStackTrace();
		}
		return objCompanyMasterBean;
	}

	@Override
	public CompanyMasterResultBean edit(String code) throws Exception {
		CompanyMasterResultBean resultBean = new CompanyMasterResultBean();
		resultBean.setSuccess(false);
		try {
			resultBean.setCompanyMaster(jdbcTemplate.queryForObject(CompanyMasterQueryUtil.SELECT_COMPANY_DTL,new Object[] { code }, new BeanPropertyRowMapper<CompanyMasterBean>(CompanyMasterBean.class)));
			resultBean.setSuccess(true);
		}
		catch(Exception e) {
			e.printStackTrace();
			resultBean.setSuccess(false);
		}
		return resultBean;
	}

	@Override
	public CompanyMasterResultBean delete(String cusCode) throws Exception {
		CompanyMasterResultBean resultBean = new CompanyMasterResultBean();
		try {
			if(cusCode!=null) {
				jdbcTemplate.update(CompanyMasterQueryUtil.DELETE_COMPANY,cusCode);
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
	public CompanyMasterResultBean update(CompanyMasterBean bean) throws Exception {
		CompanyMasterResultBean resultBean = new CompanyMasterResultBean();
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
 			
 			String result = jdbcTemplate.queryForObject(CompanyMasterQueryUtil.UPDATE_COMPANY_MASTER, new Object[]{
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

	@Override
	public List<DropDownList> getCompanyMasterList() {
		List<DropDownList> customerMasterList = new ArrayList<DropDownList>();
		try {
			customerMasterList = jdbcTemplate.query(CompanyMasterQueryUtil.COMPANY_MASTER_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerMasterList;
	}

	@Override
	public List<DropDownList> getDebitMemoList() {
		List<DropDownList> customerMasterList = new ArrayList<DropDownList>();
		try {
			customerMasterList = jdbcTemplate.query(CompanyMasterQueryUtil.DEBIT_MEMO_DROPDOWNLIST, new BeanPropertyRowMapper<DropDownList>(DropDownList.class));	
		}catch(Exception e){
			e.printStackTrace();
		}
		return customerMasterList;
	}
}