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
	
	
	//search
	
	public static final String getSearchList(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_returnable_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
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
	
	
	

}
