package com.drug.report;

import java.util.List;

import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;

public interface ControlledSubstanceService {
	


	SearchResultBean getSearchList(SearchBean bean) throws Exception;
	
	ReturnableResultBean getReturnSearchList(ReturableSearchBean bean) throws Exception;
	
	NonReturableSearchResultBean getNonReturnSearchList(NonReturnableSearchBean bean) throws Exception;
	
	ReportSearchResultBean getReportII(ReportSearchBean bean) throws Exception;
	
	ReportSearchResultBean getReportIII_V(ReportSearchBean bean) throws Exception;
	
	ReportSearchResultBean getInventory(ReportSearchBean bean) throws Exception;
	
	ReportSearchResultBean getPackingSlip(ReportSearchBean bean) throws Exception;



	


}
