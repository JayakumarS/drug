package com.drug.report;

public class ControlledSubstanceQueryUtil {

	
	public static final String getReportII(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_reportii_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	public static final String getReportIII_V(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_reportiii_v_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}	
	
	public static final String getSearchList(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_returnable_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	public static final String getNonReturnSearchList(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_nonreturnable_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	
	

}
