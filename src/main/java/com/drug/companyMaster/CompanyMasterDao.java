package com.drug.companyMaster;

import java.util.List;

public interface CompanyMasterDao {

	CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception;

	List<CompanyMasterBean> getCompanyList() throws Exception;

	CompanyMasterResultBean edit(String bean) throws Exception;

	CompanyMasterResultBean delete(String bean) throws Exception;

	CompanyMasterResultBean update(CompanyMasterBean bean) throws Exception;

}
