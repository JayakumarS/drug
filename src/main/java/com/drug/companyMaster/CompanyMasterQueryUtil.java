package com.drug.companyMaster;

public class CompanyMasterQueryUtil {

	public static final String INSERT_COMPANY_MASTER = "SELECT  sp_add_company(?,?,?,?,?,?,?,?,?,?,?,?::Date,?,?,?,?,?,?,?,?,?,?::numeric,?,?,?,?::numeric,?::numeric,?,?)";
	 
	//	companyCode, companyName, dbaName, streetName, cityName, stateName, zipCode, 
//    contactPersosn, mailId, phoneNo, faxNo, deaNo, deaExpDate, authorisedClasses, facilityType,
//    creditToName, creditToStreet,creditToCity, creditToState,creditToZipCode,  creditToPhoneNo,
//    returnPricing, returnPricingAwpPer, wholesalerWillOptions, wholesalerWillMonths,
//    cppOption,cppServiceRatePer,cppCiiShipping,cppNoOfChecks, 'A'
	public static final String GETCOMPANY_LIST = "SELECT company_code as companyCode,company_name as companyName,mail_id as companyEmailID,state as companyState,city as companyCity FROM company order by company_code desc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_COMPANY = "delete from company where company_code = ?";
	public static final String SELECT_COMPANY_DTL = "SELECT com.company_code as companyCode, com.company_name as companyName, com.dba_name as companyDba, com.street as companyStreet, com.city as companyCity, com.state as companyState, com.zip_code as companyPincode, com.contact_persosn as companyContact, com.mail_id as companyEmailID, com.phone_no as companyPhone, com.fax_no as companyFax, com.dea_no as defNumber, com.dea_exp_date as defExpirationDate, com.authorised_classes authorizedClasses, com.facility_type as companyFacilityType, com.credit_to_name as issuesCreditsName, com.credit_to_street as issuesCreditsStreet, com.credit_to_city as issuesCreditsCity, com.credit_to_state as issuesCreditsState, com.credit_to_zip_code as issuesCreditsZipCode, com.credit_to_phone_no as issuesCreditsPhone, com.return_pricing as generalInfroWacAwapMyprice, com.return_pricing_awp_per as generalInfroWacAwapPer, com.wholesaler_will_options as myWholesalerPolicyType, com.wholesaler_will_months as myWholesalerPolicyMonths, com.cpp_option as myWholesalerCpp, com.cpp_service_rate_per as cppServiceRate, com.cpp_cii_shipping as cppShippingRate, com.cpp_no_of_checks as cppNoOfChecks, wholsal.wholesaler_code as wholesalerCode, wholsal.wholesaler_name as wholesalerName, wholsal.department as wholesalerDepartment, wholsal.street as wholesalerStreet, wholsal.city as wholesalerCity, wholsal.state as wholesalerState, wholsal.zip_code as wholesalerZipCode, wholsal.contact_persosn as wholesalerPhone, wholsal.mail_id as wholesalerEmailID, wholsal.phone_no as wholesalerPhoneNo, wholsal.fax_no as wholesalerFax, wholsal.toll_free_no as wholesalerTollFreeNo, wholsal.expiry_packet as wholesalerExpiryPacket, wholsal.policy_code as wholesalerPolicyCode FROM public.company com left outer join wholesaler wholsal on wholsal.wholesaler_code = com.wholesaler where company_code = ?";
	public static final String UPDATE_COMPANY_MASTER = "SELECT sp_update_company(?,?,?,?,?,?,?,?,?,?,?,?,?::Date,?,?,?,?,?,?,?,?,?,?::numeric,?,?,?,?::numeric,?::numeric,?,?)";

}
