package com.drug.setup.rolerights;

import java.util.List;
import java.util.Map;

public class RoleRightsBean {
	
	private Integer roleId;
	private List<Map<String,Object>> formList;
	private String userName;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public List<Map<String, Object>> getFormList() {
		return formList;
	}
	public void setFormList(List<Map<String, Object>> formList) {
		this.formList = formList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	
	
	
	

}
