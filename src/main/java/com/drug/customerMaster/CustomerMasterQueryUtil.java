package com.drug.customerMaster;

public class CustomerMasterQueryUtil {

	public static final String INSERT_CUSTOMER_MASTER = "Insert into customer (customer_code,exchange_rate,booking_person_email,booking_person,sales_person_email,operation_person_email,fax_no,customer_name,cust_short_name,address,country_name,cr_limit,email,office_no,telex_no,currency,sales_person,payment_center,city,state,nat_of_business,cr_days,website,key_name,pan_no,pin_code,cust_category,acct_head_code,created_by,created_on) "
			+ " values(:cusCode,:territory,:companyRegn,:keyNumber,:transactionGST,:vatNumber,:organisationName,:keyName,:shortName,:addressOfCus,:country,:creditLimit,:keymail,:notificationMail,:invoiceMail,:creditUsd,:salesPerson,:paymentCenter,:city,:stp,:business,:creditDays,:cusWebsite,:keyName,:panNumber,:zipCode,'t','CUS001','E0001',now())";
	public static final String getCustomerList = "select customer_code as cusCode,acct_head_code as name,customer_name as zipCode,cust_short_name as addressOfCus,office_no as notificationMail,telex_no as invoiceMail,country_name as organisationName from customer order by customer_code asc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_CUSTOMER = "delete from customer where customer_code = ?";
	public static final String SELECT_CUSTOMER_DTL = "select customer_code as cusCode,exchange_rate as territory,booking_person_email as companyRegn,booking_person as keyNumber,sales_person_email as transactionGST,operation_person_email as vatNumber, customer_name as keyName,fax_no as organisationName,office_no as notificationMail,telex_no as invoiceMail,cust_short_name as shortName,address as addressOfCus,country_name as country,cr_limit as creditLimit,email as keymail,currency as creditUsd,sales_person as salesPerson,payment_center as paymentCenter,city as city,state as stp,nat_of_business as business,cr_days as creditDays,website as cusWebsite,key_name as keyName,pan_no as panNumber,pin_code as zipCode from customer where customer_code = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update customer set customer_name=:keyName,booking_person_email=:companyRegn,booking_person=:keyNumber,exchange_rate=:territory,sales_person_email=:transactionGST,operation_person_email=:vatNumber,office_no=:notificationMail,telex_no=:invoiceMail,cust_short_name=:shortName,address =:addressOfCus,country_name=:country,cr_limit=:creditLimit,email=:keymail,currency=:creditUsd,sales_person=:salesPerson,payment_center=:paymentCenter,city=:city,state=:stp,nat_of_business=:business,cr_days=:creditDays,website=:cusWebsite,key_name=:keyName,pan_no=:panNumber,\r\n"
			+ "pin_code=:zipCode  where customer_code=:cusCode";

}
