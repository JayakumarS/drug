package com.drug.setup.roles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth/app/rolesMaster")
public class RolesMasterController {
	@Autowired
	RolesMasterService rolesrMasterService;
	
	@RequestMapping(value="/save")
	public RolesMasterResultBean save(@RequestBody RolesMasterBean bean) {
		RolesMasterResultBean objbean = new RolesMasterResultBean();
		try {
			objbean = rolesrMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public RolesMasterResultBean getList() throws Exception {
		RolesMasterResultBean objResultBean = new RolesMasterResultBean();
		objResultBean.setRolesMasterDetails(rolesrMasterService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public RolesMasterResultBean edit(@RequestParam("id") Integer id) throws Exception {
		RolesMasterResultBean objResultBean = new RolesMasterResultBean();
		try {
			objResultBean = rolesrMasterService.edit(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public RolesMasterResultBean update(@RequestBody RolesMasterBean bean) {
		RolesMasterResultBean objResultBean = new RolesMasterResultBean();
		try {
			objResultBean = rolesrMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public RolesMasterResultBean delete(@RequestParam("deleteRole") Integer deleteRole) {
		RolesMasterResultBean objResultBean = new RolesMasterResultBean();
		try {
			objResultBean = rolesrMasterService.delete(deleteRole);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

}
