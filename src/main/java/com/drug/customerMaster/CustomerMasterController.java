package com.drug.customerMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/customerMaster")
public class CustomerMasterController {
	@Autowired
	CustomerMasterService customerMasterService;
	
	@RequestMapping(value="/save")
	public CustomerMasterResultBean save(@RequestBody CustomerMasterBean bean) {
		CustomerMasterResultBean objbean = new CustomerMasterResultBean();
		try {
			objbean = customerMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public CustomerMasterResultBean getCustomerList() throws Exception {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		objResultBean.setCustomerMasterDetails(customerMasterService.getCustomerList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public CustomerMasterResultBean edit(@RequestParam("customer") String customer) throws Exception {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		try {
			objResultBean = customerMasterService.edit(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public CustomerMasterResultBean update(@RequestBody CustomerMasterBean bean) {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		try {
			objResultBean = customerMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public CustomerMasterResultBean delete(@RequestParam("customer") String customer) {
		CustomerMasterResultBean objResultBean = new CustomerMasterResultBean();
		try {
			objResultBean = customerMasterService.delete(customer);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

}
