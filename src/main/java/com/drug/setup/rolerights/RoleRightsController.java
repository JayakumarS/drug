package com.drug.setup.rolerights;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.drug.setup.users.UsersMasterResultBean;


@RestController
@RequestMapping("/api/auth/app/roleRights")
public class RoleRightsController {
	@Autowired
	RoleRightsService rolesrMasterService;
	
	@RequestMapping(value="/save")
	public RoleRightsResultBean save(@RequestBody RoleRightsBean bean) {
		RoleRightsResultBean objbean = new RoleRightsResultBean();
		try {
			objbean = rolesrMasterService.save(bean);
		}catch(Exception e){
			e.printStackTrace();	
		}
		return objbean;
		
	}
	
	
	@RequestMapping(value = "/getList")
   	public RoleRightsResultBean getList() throws Exception {
		RoleRightsResultBean objResultBean = new RoleRightsResultBean();
		objResultBean.setRolesMasterDetails(rolesrMasterService.getList());
		objResultBean.setSuccess(true);
   		return objResultBean;
   	}
	
	@RequestMapping(value = "/edit")
	public RoleRightsResultBean edit(@RequestParam("id") Integer id) throws Exception {
		RoleRightsResultBean objResultBean = new RoleRightsResultBean();
		try {
			objResultBean = rolesrMasterService.edit(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/update")
	public RoleRightsResultBean update(@RequestBody RoleRightsBean bean) {
		RoleRightsResultBean objResultBean = new RoleRightsResultBean();
		try {
			objResultBean = rolesrMasterService.update(bean);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}
	
	@RequestMapping(value="/delete")
	public RoleRightsResultBean delete(@RequestParam("id") Integer id) {
		RoleRightsResultBean objResultBean = new RoleRightsResultBean();
		try {
			objResultBean = rolesrMasterService.delete(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return objResultBean;
	}

	@RequestMapping(value = "/getFormList")
   	public RoleRightsResultBean getFormList(@RequestParam("roleId") Integer roleId) throws Exception {
   		return rolesrMasterService.getFormList(roleId);
   	}
}
