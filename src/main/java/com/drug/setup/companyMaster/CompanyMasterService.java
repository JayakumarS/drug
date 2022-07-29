package com.drug.setup.companyMaster;

import java.util.List;

import com.drug.core.util.DropDownList;

public interface CompanyMasterService {

	CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception;

	public List<CompanyMasterBean> getCompanyList(String company, Boolean isRoleAdmin) throws Exception;

	CompanyMasterResultBean edit(String code) throws Exception;

	CompanyMasterResultBean delete(String code) throws Exception;
	
	CompanyMasterResultBean update(CompanyMasterBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoList();

}