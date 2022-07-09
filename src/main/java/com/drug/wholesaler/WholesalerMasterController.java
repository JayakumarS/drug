package com.drug.wholesaler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api/auth/app/wholesalerMaster")
public class WholesalerMasterController {

	@Autowired
	WholesalerMasterService wholesalerMasterService;
	
	
	@RequestMapping(value="/save")
	public WholesalerMasterResultBean save(@RequestBody WholesalerMasterBean bean) {
		WholesalerMasterResultBean objbean = new WholesalerMasterResultBean();
		try {
			objbean = wholesalerMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public WholesalerMasterResultBean getList() throws Exception {
		WholesalerMasterResultBean objResultBean = new WholesalerMasterResultBean();
		objResultBean.setListWholesalerMasterBean(wholesalerMasterService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public WholesalerMasterResultBean edit(@RequestParam("wholesalerId") String wholesalerId) throws Exception {
		WholesalerMasterResultBean objResultBean = new WholesalerMasterResultBean();
		try {
			objResultBean = wholesalerMasterService.edit(wholesalerId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public WholesalerMasterResultBean update(@RequestBody WholesalerMasterBean bean) {
		WholesalerMasterResultBean objResultBean = new WholesalerMasterResultBean();
		try {
			objResultBean = wholesalerMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public WholesalerMasterResultBean delete(@RequestParam("deleteUser") Integer deleteUser) {
		WholesalerMasterResultBean objResultBean = new WholesalerMasterResultBean();
		try {
			objResultBean = wholesalerMasterService.delete(deleteUser);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
}
