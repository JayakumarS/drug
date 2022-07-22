package com.drug.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;


@RestController
@RequestMapping("/api/auth/app/report")

public class ControlledSubstanceController {
	
	@Autowired
	ControlledSubstanceService controlledSubstanceService;
	
	
	@RequestMapping(value="/getSearchList")
	public SearchResultBean getSearchList(@RequestBody SearchBean bean) {
		SearchResultBean objbean = new SearchResultBean();
		try {
			objbean = controlledSubstanceService.getSearchList(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value="/getNonReturnSearchList")
	public NonReturableSearchResultBean getNonReturnSearchList(@RequestBody NonReturnableSearchBean bean) {
		NonReturableSearchResultBean objbean = new NonReturableSearchResultBean();
		try {
			objbean = controlledSubstanceService.getNonReturnSearchList(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	//ScheduleII
	
	@RequestMapping(value="/getReportII")
	public ReportSearchResultBean getReportII(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getReportII(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//ScheduleIII_V

	
	@RequestMapping(value="/getReportIII_V")
	public ReportSearchResultBean getReportIII_V(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getReportIII_V(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	

	

	

}
