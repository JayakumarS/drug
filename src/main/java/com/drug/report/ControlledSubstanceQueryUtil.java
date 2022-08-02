package com.drug.report;

public class ControlledSubstanceQueryUtil {

	
	//search
	
	public static final String getSearchList(String reportType,String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_reportsbytype('"+reportType+"','"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
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
		
}



