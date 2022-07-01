package com.drug.report;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


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
}
