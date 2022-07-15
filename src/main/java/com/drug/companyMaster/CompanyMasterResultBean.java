package com.drug.companyMaster;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;

public class CompanyMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	
	private CompanyMasterBean companyMaster;
	
	private List<CompanyMasterBean> listCompanyMaster;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public CompanyMasterBean getCompanyMaster() {
		return companyMaster;
	}

	public void setCompanyMaster(CompanyMasterBean companyMaster) {
		this.companyMaster = companyMaster;
	}

	public List<CompanyMasterBean> getListCompanyMaster() {
		return listCompanyMaster;
	}

	public void setListCompanyMaster(List<CompanyMasterBean> listCompanyMaster) {
		this.listCompanyMaster = listCompanyMaster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
}
