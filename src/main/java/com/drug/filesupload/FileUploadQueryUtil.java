package com.drug.filesupload;

public class FileUploadQueryUtil {

	public static final String INSERT_FILE_UPLOAD =  "Insert into upload_dri (upload,customer_id) "
			+ " values(:fileUploadUrl,:customer)";
	public static final String getList = "select upload as fileUploadUrl,customer_id as customer from upload_dri order by customer_id asc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_CUSTOMER = "delete from customer where customer_code = ?";
	public static final String SELECT_CUSTOMER_DTL = "select customer_code as cusCode,exchange_rate as territory,booking_person_email as companyRegn,booking_person as keyNumber,sales_person_email as transactionGST,operation_person_email as vatNumber, customer_name as keyName,fax_no as organisationName,office_no as notificationMail,telex_no as invoiceMail,cust_short_name as shortName,address as addressOfCus,country_name as country,cr_limit as creditLimit,email as keymail,currency as creditUsd,sales_person as salesPerson,payment_center as paymentCenter,city as city,state as stp,nat_of_business as business,cr_days as creditDays,website as cusWebsite,key_name as keyName,pan_no as panNumber,pin_code as zipCode from customer where customer_code = ?";
	public static final String UPDATE_CUSTOMER_MASTER = "update customer set customer_name=:keyName,booking_person_email=:companyRegn,booking_person=:keyNumber,exchange_rate=:territory,sales_person_email=:transactionGST,operation_person_email=:vatNumber,office_no=:notificationMail,telex_no=:invoiceMail,cust_short_name=:shortName,address =:addressOfCus,country_name=:country,cr_limit=:creditLimit,email=:keymail,currency=:creditUsd,sales_person=:salesPerson,payment_center=:paymentCenter,city=:city,state=:stp,nat_of_business=:business,cr_days=:creditDays,website=:cusWebsite,key_name=:keyName,pan_no=:panNumber,\r\n"
			+ "pin_code=:zipCode  where customer_code=:cusCode";
	
	public static final String GET_CUSTOMER_LIST = "select customer_code as id ,customer_name as text from customer ";

}
