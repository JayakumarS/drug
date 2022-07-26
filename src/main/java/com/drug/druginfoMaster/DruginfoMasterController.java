package com.drug.druginfoMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drug.manufacturerMaster.ManufacturerMasterResultBean;



@RestController
@RequestMapping("/api/auth/app/drugInfoMaster")
public class DruginfoMasterController {

	@Autowired
	DruginfoMasterService drugInfoMasterService;
	
	
	@RequestMapping(value="/save")
	public DruginfoMasterResultBean save(@RequestBody DruginfoMasterBean bean) {
		DruginfoMasterResultBean objbean = new DruginfoMasterResultBean();
		try {
			objbean = drugInfoMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	@RequestMapping(value = "/getList")
   	public DruginfoMasterResultBean getList() throws Exception {
		DruginfoMasterResultBean objResultBean = new DruginfoMasterResultBean();
		objResultBean.setListDrugInfoMasterBean(drugInfoMasterService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public DruginfoMasterResultBean edit(@RequestParam("drugInfoId") String drugInfoId) throws Exception {
		DruginfoMasterResultBean objResultBean = new DruginfoMasterResultBean();
		try {
			objResultBean = drugInfoMasterService.edit(drugInfoId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public DruginfoMasterResultBean update(@RequestBody DruginfoMasterBean bean) {
		DruginfoMasterResultBean objResultBean = new DruginfoMasterResultBean();
		try {
			objResultBean = drugInfoMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public DruginfoMasterResultBean delete(@RequestParam("drugInfoId") String drugInfoId) {
		DruginfoMasterResultBean objResultBean = new DruginfoMasterResultBean();
		try {
			objResultBean = drugInfoMasterService.delete(drugInfoId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	
	@RequestMapping(value = "/getManufacturerList")
   	public DruginfoMasterResultBean getManufacturerList() throws Exception {
   		return drugInfoMasterService.getManufacturerList();
   	}
	
	@RequestMapping(value="/saveDruginfoReturnPolicy")
	public DruginfoMasterResultBean saveDruginfoReturnPolicy(@RequestBody DruginfoReturnPolicyBean bean) {
		DruginfoMasterResultBean objbean = new DruginfoMasterResultBean();
		try {
			objbean = drugInfoMasterService.saveDruginfoReturnPolicy(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	@RequestMapping(value = "/editDruginfoReturnPolicy")
	public DruginfoMasterResultBean editDruginfoReturnPolicy(@RequestParam("drugInfoId") String drugInfoId) throws Exception {
		DruginfoMasterResultBean objResultBean = new DruginfoMasterResultBean();
		try {
			objResultBean = drugInfoMasterService.editDruginfoReturnPolicy(drugInfoId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
}
