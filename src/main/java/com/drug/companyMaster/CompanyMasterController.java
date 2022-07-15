package com.drug.companyMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/companyMaster")
public class CompanyMasterController {
	@Autowired
	CompanyMasterService companyMasterService;
	
	@RequestMapping(value="/save")
	public CompanyMasterResultBean save(@RequestBody CompanyMasterBean bean) {
		CompanyMasterResultBean objbean = new CompanyMasterResultBean();
		try {
			objbean = companyMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public CompanyMasterResultBean getCompanyList() throws Exception {
		CompanyMasterResultBean objResultBean = new CompanyMasterResultBean();
		objResultBean.setListCompanyMaster(companyMasterService.getCompanyList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public CompanyMasterResultBean edit(@RequestParam("company") String company) throws Exception {
		CompanyMasterResultBean objResultBean = new CompanyMasterResultBean();
		try {
			objResultBean = companyMasterService.edit(company);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public CompanyMasterResultBean update(@RequestBody CompanyMasterBean bean) {
		CompanyMasterResultBean objResultBean = new CompanyMasterResultBean();
		try {
			objResultBean = companyMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public CompanyMasterResultBean delete(@RequestParam("company") String company) {
		CompanyMasterResultBean objResultBean = new CompanyMasterResultBean();
		try {
			objResultBean = companyMasterService.delete(company);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

}
