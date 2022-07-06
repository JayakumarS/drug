package com.drug.wholesaler;

public class WholesalerMasterQueryUtil {

	public static final String INSERT_WHOLESALER_MASTER = "SELECT sp_add_wholesaler(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_WHOLESALER_LIST = "SELECT company_code as companyCode,company_name as companyName,mail_id as companyEmailID,state as companyState,city as companyCity FROM company order by company_code desc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_CUSTOMER = "delete from company where company_code = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update customer set customer_name=:keyName,booking_person_email=:companyRegn,booking_person=:keyNumber,exchange_rate=:territory,sales_person_email=:transactionGST,operation_person_email=:vatNumber,office_no=:notificationMail,telex_no=:invoiceMail,cust_short_name=:shortName,address =:addressOfCus,country_name=:country,cr_limit=:creditLimit,email=:keymail,currency=:creditUsd,sales_person=:salesPerson,payment_center=:paymentCenter,city=:city,state=:stp,nat_of_business=:business,cr_days=:creditDays,website=:cusWebsite,key_name=:keyName,pan_no=:panNumber,\r\n"
			+ "pin_code=:zipCode  where customer_code=:cusCode";
}
