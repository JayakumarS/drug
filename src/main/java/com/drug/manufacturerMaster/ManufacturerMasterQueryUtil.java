package com.drug.manufacturerMaster;

public class ManufacturerMasterQueryUtil {

	public static final String INSERT_MANUFACTURE_MASTER = "SELECT sp_add_manufacturer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	public static final String GETCUSCODE = "SELECT manufacturer_code as manufacturerCode, manufacturer_name as manufacturerName, department as departmentName, street as streetName, city as cityName, state as stateName, zip_code as zipCode, contact_persosn as contact, mail_id as emailId, phone_no as phoneNo, fax_no as fax, toll_free_no as tollFreeNo, link_to as linkTo, bill_to as billTo, return_service as returnService FROM public.manufacturer where manufacturer_code = ?";
	public static final String GET_MANUFACTURE_LIST = "SELECT manufacturer_code as manufacturerCode, manufacturer_name as manufacturerName, department as departmentName, city as cityName, state as stateName FROM public.manufacturer order by manufacturer_code desc";
	public static final String DELETE_CUSTOMER = "delete from MANUFACTURE where MANUFACTURE_code = ?";
	public static final String UPDATE_MANUFACTURE_MASTER = "SELECT sp_update_manufacturer(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
}
