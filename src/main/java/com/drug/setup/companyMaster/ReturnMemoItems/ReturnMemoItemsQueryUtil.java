package com.drug.setup.companyMaster.ReturnMemoItems;

public class ReturnMemoItemsQueryUtil {

	public static final String INSERT_DEBITMEMO_MASTER = "SELECT sp_add_returnmemo(?,?,?,?,?,?)";
	public static final String GETDEBITMEMO_LIST = "SELECT retMom.return_memo_no as returnMemoNo , retMom.return_memo_name as returnMemoName, retMom.return_memo_date as returnMemoDate, com.company_name as company from public.return_memo retMom left outer join company com on com.company_code=retMom.company order by return_memo_no desc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_DEBITMEMO = "delete from company where company_code = ?";
	public static final String SELECT_DEBITMEMO = "SELECT com.company_code as companyCode, com.company_name as companyName, com.dba_name as companyDba, com.street as companyStreet, com.city as companyCity, com.state as companyState, com.zip_code as companyPincode, com.contact_persosn as companyContact, com.mail_id as companyEmailID, com.phone_no as companyPhone, com.fax_no as companyFax, com.dea_no as defNumber, com.dea_exp_date as defExpirationDate, com.authorised_classes authorizedClasses, com.facility_type as companyFacilityType, com.credit_to_name as issuesCreditsName, com.credit_to_street as issuesCreditsStreet, com.credit_to_city as issuesCreditsCity, com.credit_to_state as issuesCreditsState, com.credit_to_zip_code as issuesCreditsZipCode, com.credit_to_phone_no as issuesCreditsPhone, com.return_pricing as generalInfroWacAwapMyprice, com.return_pricing_awp_per as generalInfroWacAwapPer, com.wholesaler_will_options as myWholesalerPolicyType, com.wholesaler_will_months as myWholesalerPolicyMonths, com.cpp_option as myWholesalerCpp, com.cpp_service_rate_per as cppServiceRate, com.cpp_cii_shipping as cppShippingRate, com.cpp_no_of_checks as cppNoOfChecks, wholsal.wholesaler_code as wholesalerCode, wholsal.wholesaler_name as wholesalerName, wholsal.department as wholesalerDepartment, wholsal.street as wholesalerStreet, wholsal.city as wholesalerCity, wholsal.state as wholesalerState, wholsal.zip_code as wholesalerZipCode, wholsal.contact_persosn as wholesalerPhone, wholsal.mail_id as wholesalerEmailID, wholsal.phone_no as wholesalerPhoneNo, wholsal.fax_no as wholesalerFax, wholsal.toll_free_no as wholesalerTollFreeNo, wholsal.expiry_packet as wholesalerExpiryPacket, wholsal.policy_code as wholesalerPolicyCode FROM public.company com left outer join wholesaler wholsal on wholsal.wholesaler_code = com.wholesaler where company_code = ?";
	public static final String UPDATE_DEBITMEMO = "SELECT sp_update_company(?,?,?,?,?,?,?,?,?,?,?,?,?::Date,?,?,?,?,?,?,?,?,?,?::numeric,?,?,?,?::numeric,?::numeric,?,?)";
	public static final String COMPANY_MASTER_DROPDOWNLIST = "select company_code as id, company_name as text from company order by company_name asc";
	public static final String DEBIT_MEMO_DROPDOWNLIST = "select return_memo_no as id, return_memo_name as text from return_memo order by return_memo_name asc";
	
}
