package com.drug.report;

public class ControlledSubstanceQueryUtil {

	
	public static final String getCompanyNameList = "select company_code as id,company_name as text from company";

	public static final String getReturnMemoNo = "select return_memo_no as no from return_memo";
	
	
	public static final String getSearchList(String company,String returnno,String fromdt,String todt) {
		String query = "select * from vw_get_returnable_products('"+company+"','"+returnno+"','"+fromdt+"','"+todt+"')";
		return query;
	}
	
	

}
