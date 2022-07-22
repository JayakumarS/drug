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
	
	
	@RequestMapping(value = "/getCompanyNameList")
   	public ControlledSubstanceResultBean getCompanyNameList() throws Exception {
		ControlledSubstanceResultBean objResultBean = new ControlledSubstanceResultBean();
		objResultBean.setCompanyNameList(controlledSubstanceService.getCompanyNameList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/getReturnMemoNo")
   	public ControlledSubstanceResultBean getReturnMemoNo() throws Exception {
		ControlledSubstanceResultBean objResultBean = new ControlledSubstanceResultBean();
		objResultBean.setReturnMemoNo(controlledSubstanceService.getReturnMemoNo());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	
	
	
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
	
	
	
//	@RequestMapping(value="/getReportList")
//	public NonReturableSearchResultBean getReportList(@RequestBody NonReturnableSearchBean bean) {
//		NonReturableSearchResultBean objbean = new NonReturableSearchResultBean();
//		try {
//			objbean = controlledSubstanceService.getReportList(bean);
//		}catch(Exception e){
//			e.printStackTrace();	
//		}
//		return objbean;
//		
//	}
	

	

}
