package com.drug.customerMaster;

public class CustomerMasterQueryUtil {

	public static final String INSERT_CUSTOMER_MASTER = "SELECT  sp_add_company(?,?,?,?,?,?,?,?,?,?,?,?,?::Date,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	 
	//	companyCode, companyName, dbaName, streetName, cityName, stateName, zipCode, 
//    contactPersosn, mailId, phoneNo, faxNo, deaNo, deaExpDate, authorisedClasses, facilityType,
//    creditToName, creditToStreet,creditToCity, creditToState,creditToZipCode,  creditToPhoneNo,
//    returnPricing, returnPricingAwpPer, wholesalerWillOptions, wholesalerWillMonths,
//    cppOption,cppServiceRatePer,cppCiiShipping,cppNoOfChecks, 'A'
	public static final String getCustomerList = "SELECT company_code as companyCode,company_name as companyName,mail_id as companyEmailID,state as companyState,city as companyCity FROM company order by company_code desc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_CUSTOMER = "delete from company where company_code = ?";
	public static final String SELECT_CUSTOMER_DTL = "SELECT company_code as companyCode, company_name as companyName, dba_name as companyDba, street as companyStreet,\r\n"
			+ " city as companyCity, state as companyState, zip_code as companyPincode, contact_persosn as companyContact, \r\n"
			+ " mail_id as companyEmailID, phone_no as companyPhone, fax_no as companyFax, dea_no as defNumber, dea_exp_date as defExpirationDate,\r\n"
			+ " authorised_classes  authorisedClasses, facility_type as companyFacilityType, credit_to_name as issuesCreditsName, credit_to_street as issuesCreditsStreet,\r\n"
			+ " credit_to_city as issuesCreditsCity, credit_to_state as issuesCreditsState, credit_to_zip_code as issuesCreditsZipCode, credit_to_phone_no as issuesCreditsPhone,\r\n"
			+ " return_pricing as generalInfroWacAwapMyprice, return_pricing_awp_per as generalInfroWacAwapPer, \r\n"
			+ " wholesaler_will_options as myWholesalerPolicyType, wholesaler_will_months as myWholesalerPolicyMonths, cpp_option as myWholesalerCpp, \r\n"
			+ " cpp_service_rate_per as cppServiceRate, cpp_cii_shipping as cppShippingRate, cpp_no_of_checks as cppNoOfChecks\r\n"
			+ "	FROM public.company where company_code = ?;";
	public static final String UPDATE_CUSTOMER_MASTER = "update customer set customer_name=:keyName,booking_person_email=:companyRegn,booking_person=:keyNumber,exchange_rate=:territory,sales_person_email=:transactionGST,operation_person_email=:vatNumber,office_no=:notificationMail,telex_no=:invoiceMail,cust_short_name=:shortName,address =:addressOfCus,country_name=:country,cr_limit=:creditLimit,email=:keymail,currency=:creditUsd,sales_person=:salesPerson,payment_center=:paymentCenter,city=:city,state=:stp,nat_of_business=:business,cr_days=:creditDays,website=:cusWebsite,key_name=:keyName,pan_no=:panNumber,\r\n"
			+ "pin_code=:zipCode  where customer_code=:cusCode";

}
