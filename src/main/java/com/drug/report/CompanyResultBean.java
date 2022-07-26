package com.drug.report;

import java.util.List;

public class CompanyResultBean {
	
	private static final long serialVersionUID = 1L;
	
	public boolean success;


	private List<CompanyBean> companyAddressList;


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public List<CompanyBean> getCompanyAddressList() {
		return companyAddressList;
	}


	public void setCompanyAddressList(List<CompanyBean> companyAddressList) {
		this.companyAddressList = companyAddressList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}



}
 