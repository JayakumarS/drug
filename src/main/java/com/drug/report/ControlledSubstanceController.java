package com.drug.report;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drug.core.util.DropDownList;
import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;


@RestController
@RequestMapping("/api/auth/app/report")

public class ControlledSubstanceController {
	
	@Autowired
	ControlledSubstanceService controlledSubstanceService;
	
	
	//Search
	
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
	
	//Returnable 
		
	@RequestMapping(value="/getReturnSearchList")
	public ReturnableResultBean getReturnSearchList(@RequestBody ReturableSearchBean bean) {
		ReturnableResultBean objbean = new ReturnableResultBean();
		try {
			objbean = controlledSubstanceService.getReturnSearchList(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	
	//NonReturnable 
	
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
	
	
	//Inventory
	
	
	@RequestMapping(value="/getInventory")
	public ReportSearchResultBean getInventory(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getInventory(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//Packing Slip
	
	@RequestMapping(value="/getPackingSlip")
	public ReportSearchResultBean getPackingSlip(@RequestBody ReportSearchBean bean) {
		ReportSearchResultBean objbean = new ReportSearchResultBean();
		try {
			objbean = controlledSubstanceService.getPackingSlip(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	//ManufacturerAddress
	
//	@RequestMapping(value="/getManufacturerAddress")
//	public ManufacturerResultBean getManufacturerAddress(@RequestBody ManufacturerBean bean) {
//		ManufacturerResultBean objbean = new ManufacturerResultBean();
//		try {
//			objbean = controlledSubstanceService.getManufacturerAddress(bean);
//		}catch(Exception e){
//			e.printStackTrace();	
//		}
//		return objbean;
//		
//	}
	

	@RequestMapping(value= "/getManufacturerAddress")
	public List<ManufacturerBean> getManufacturerAddress(@RequestParam("manufacturercode") String manufacturercode){
			return controlledSubstanceService.getManufacturerAddress(manufacturercode);	
	}

}
