package com.drug.report;

import java.util.List;

public interface ControlledSubsatanceDao {
	

	SearchResultBean getSearchList(SearchBean bean) throws Exception;

	List<ManufacturerBean> getManufacturerAddress(String manufacturercode);

	List<CompanyBean> getCompanyAddress(String companyId);
	
	
}
