package com.drug.report;

import java.util.List;

import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;

public interface ControlledSubstanceService {
	
	public List<ControlledSubstanceResultBean> getCompanyNameList() throws Exception;
	public List<ControlledSubstanceResultBean> getReturnMemoNo() throws Exception;

	SearchResultBean getSearchList(SearchBean bean) throws Exception;
//	public List<SearchBean> getSearchList() throws Exception;



}
