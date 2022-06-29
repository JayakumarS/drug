package com.drug.setup.roles;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;

public class RolesMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	private RolesMasterBean rolesMasterBean;
	private List<RolesMasterBean> rolesMasterDetails;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public RolesMasterBean getRolesMasterBean() {
		return rolesMasterBean;
	}
	public void setRolesMasterBean(RolesMasterBean rolesMasterBean) {
		this.rolesMasterBean = rolesMasterBean;
	}
	public List<RolesMasterBean> getRolesMasterDetails() {
		return rolesMasterDetails;
	}
	public void setRolesMasterDetails(List<RolesMasterBean> rolesMasterDetails) {
		this.rolesMasterDetails = rolesMasterDetails;
	}

	
	
}
