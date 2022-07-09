package com.drug.wholesaler;

public class WholesalerMasterQueryUtil {

	public static final String INSERT_WHOLESALER_MASTER = "SELECT sp_add_wholesaler(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	public static final String GET_WHOLESALER_LIST = "select wholesaler_code as wholesalerCode, wholesaler_name as wholesalerName, mail_id as emailID, department as department, city as city, state as state from wholesaler order by wholesaler_code desc";
	public static final String GETCUSCODE = "SELECT wholesaler_code as wholesalerCode, wholesaler_name as wholesalerName, department as department, street as street, city as city, \r\n"
			+ "state as state, zip_code as zipCode, contact_persosn as phoneNo, mail_id as emailID, \r\n"
			+ "phone_no as phone, fax_no as fax, toll_free_no as tollFreeNo, expiry_packet as expiryPacket, policy_code as policyCode\r\n"
			+ "FROM wholesaler where wholesaler_code = ?";
	public static final String DELETE_CUSTOMER = "delete from wholesaler where wholesaler_code = ?";
	public static final String UPDATE_WHOLESALER_MASTER = "SELECT sp_upd_wholesaler(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
}
