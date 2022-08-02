package com.drug.report;

public class ControlledSubstanceQueryUtil {

	//SechudleII
	
	public static final String getReportII(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_reportii_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	
	//SechudleIII

	public static final String getReportIII_V(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_reportiii_v_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	//Invenory
	
	public static final String getInventory(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_inventory_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	
	//PackingSlip
	
		public static final String getPackingSlip(String company,String returnno,String fromdt,String todt) {
			String query = "select * from vw_get_packing_slip_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
			return query;
		}
	
	
		public static final String getSearchList(String reporttype,String company,String returnno,String fromdt,String todt) {
			String query = "select * from vw_get_reportsbytype('"+reporttype+"','"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
			return query;
		}
		
	
	//Returnable
	
		public static final String getReturnSearchList(String company,String returnno,String fromdt,String todt) {
			String query = "select * from vw_get_returnable_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
			return query;
		}
		
	
	//nonReturnable
	
	public static final String getNonReturnSearchList(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_nonreturnable_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	
	
	//ManufacturerAddress
	
		public static final String getManufacturerAddress(String manufacturercode) {
			String query = "select * from vw_get_manufacturer_address('"+manufacturercode+"')";

			return query;
		}
		
		
    //
		public static final String COMPANY_MASTER(String companyId) {
			String query = "select * from vw_get_company_address('"+companyId+"')";

			return query;
		}
		
		


					
//		public static final String COMPANY_MASTER = "select company_code as id, company_name as text,dba_name as department,street as street, city as city, \r\n"
//				+ "state as state, zip_code as zipCode, contact_persosn as contactPerson, mail_id as mailId, \r\n"
//				+ "phone_no as phoneNo, fax_no as faxNo, dea_no as deaNo,dea_exp_date as deaExpDate,\r\n"
//				+ "authorised_classes as authorisedClasses, facility_type as facilityType, credit_to_name as creditToName,\r\n"
//				+ "credit_to_street as creditToStreet, credit_to_city as creditToCity, credit_to_state as creditToState, \r\n"
//				+ "credit_to_zip_code as creditToZipCode,credit_to_phone_no as creditToPhoneNo, \r\n"
//				+ "return_pricing as returnPricing,  return_pricing_awp_per as returnPricingAwpPer,  \r\n"
//				+ "wholesaler_will_options as wholesalerWillOptions, wholesaler_will_months as wholesalerWillMonths,\r\n"
//				+ "cpp_option as cppOption,cpp_service_rate_per as cppServiceRatePer,cpp_cii_shipping as cppCiiShipping,\r\n"
//				+ "cpp_no_of_checks as cppNoOFChecks,is_active as isActive,wholesaler as wholesaler,created_by as createdBy,\r\n"
//				+ "modified_by as modifiedBy, modified_on as modifiedOn from company where company_name=?";
}



