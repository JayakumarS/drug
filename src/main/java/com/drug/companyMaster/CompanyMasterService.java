package com.drug.companyMaster;

import java.util.List;

public interface CompanyMasterService {

	CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception;

	public List<CompanyMasterBean> getCompanyList() throws Exception;

	CompanyMasterResultBean edit(String code) throws Exception;

	CompanyMasterResultBean delete(String code) throws Exception;
	
	CompanyMasterResultBean update(CompanyMasterBean bean) throws Exception;

}