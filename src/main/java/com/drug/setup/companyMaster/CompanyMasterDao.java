package com.drug.setup.companyMaster;

import java.util.List;

import com.drug.core.util.DropDownList;

public interface CompanyMasterDao {

	CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception;

	List<CompanyMasterBean> getCompanyList() throws Exception;

	CompanyMasterResultBean edit(String bean) throws Exception;

	CompanyMasterResultBean delete(String bean) throws Exception;

	CompanyMasterResultBean update(CompanyMasterBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoList();

}
