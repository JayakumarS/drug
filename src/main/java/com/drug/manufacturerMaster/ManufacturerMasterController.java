package com.drug.manufacturerMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drug.filesupload.FileUploadResultBean;



@RestController
@RequestMapping("/api/auth/app/manufacturerMaster")
public class ManufacturerMasterController {

	@Autowired
	ManufacturerMasterService manufacturerMasterService;
	
	
	@RequestMapping(value="/save")
	public ManufacturerMasterResultBean save(@RequestBody ManufacturerMasterBean bean) {
		ManufacturerMasterResultBean resultBean = new ManufacturerMasterResultBean();
		try {
			resultBean = manufacturerMasterService.save(bean);
			resultBean.setSuccess(true);
		}catch(Exception e){
			resultBean.setSuccess(false);
			e.printStackTrace();	
		}
		return resultBean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public ManufacturerMasterResultBean getList() throws Exception {
		ManufacturerMasterResultBean objResultBean = new ManufacturerMasterResultBean();
		objResultBean.setListmanufacturerMasterBean(manufacturerMasterService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public ManufacturerMasterResultBean edit(@RequestParam("manufacturerId") String manufacturerId) throws Exception {
		ManufacturerMasterResultBean objResultBean = new ManufacturerMasterResultBean();
		try {
			objResultBean = manufacturerMasterService.edit(manufacturerId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public ManufacturerMasterResultBean update(@RequestBody ManufacturerMasterBean bean) {
		ManufacturerMasterResultBean objResultBean = new ManufacturerMasterResultBean();
		try {
			objResultBean = manufacturerMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public ManufacturerMasterResultBean delete(@RequestParam("manufacturerId") String manufacturerId) {
		ManufacturerMasterResultBean objResultBean = new ManufacturerMasterResultBean();
		try {
			objResultBean = manufacturerMasterService.delete(manufacturerId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	
}
