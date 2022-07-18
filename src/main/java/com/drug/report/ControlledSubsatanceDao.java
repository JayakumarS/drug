package com.drug.report;

import java.util.List;

import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;


public interface ControlledSubsatanceDao {
	
	List<ControlledSubstanceResultBean> getCompanyNameList() throws Exception;
	List<ControlledSubstanceResultBean> getReturnMemoNo() throws Exception;
//	List<SearchBean> getSearchList() throws Exception;

	
	SearchResultBean getSearchList(SearchBean bean) throws Exception;

	
}
