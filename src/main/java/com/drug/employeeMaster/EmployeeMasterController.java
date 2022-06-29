package com.drug.employeeMaster;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags="Drug", description=" API operation")
@RestController
public class EmployeeMasterController {

	private final static Logger LOGGER = LoggerFactory.getLogger(EmployeeMasterController.class);
	
	@Autowired
	private EmployeeMasterService employeeMasterService;
	
	
	@ApiOperation(value = "Employee Master Controller")
	@PostMapping("/addEmployeeMaster")
	private EmployeeMasterResultBean addEmployeeMaster(@RequestBody EmployeeMasterBean employeeMasterBean) {
		EmployeeMasterResultBean employeeMasterResultBean = new EmployeeMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.addEmployeeMaster(employeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return employeeMasterResultBean;

	}
	
	private EmployeeMasterResultBean insertAppUserMaster(EmployeeMasterBean employeeMasterBean) {
		EmployeeMasterResultBean employeeMasterResultBean = new EmployeeMasterResultBean();
		try {
			employeeMasterResultBean = employeeMasterService.addEmployeeMaster(employeeMasterBean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return employeeMasterResultBean;

	}
}
