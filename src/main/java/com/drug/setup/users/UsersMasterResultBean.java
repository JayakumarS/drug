package com.drug.setup.users;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.drug.core.util.BasicResultBean;
import com.drug.core.util.DropDownList;

public class UsersMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	private UsersMasterBean usersMasterBean;
	private List<UsersMasterBean> usersMasterDetails;
	
	private List<DropDownList> roleList;
	
	
	private String fileName;
	private String filePath;
	private String newUserName;
	private String userName;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private List<Map<String,Object>> roles;
	
	
	
	public List<Map<String, Object>> getRoles() {
		return roles;
	}
	public void setRoles(List<Map<String, Object>> roles) {
		this.roles = roles;
	}
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
	public UsersMasterBean getUsersMasterBean() {
		return usersMasterBean;
	}
	public void setUsersMasterBean(UsersMasterBean usersMasterBean) {
		this.usersMasterBean = usersMasterBean;
	}
	public List<UsersMasterBean> getUsersMasterDetails() {
		return usersMasterDetails;
	}
	public void setUsersMasterDetails(List<UsersMasterBean> usersMasterDetails) {
		this.usersMasterDetails = usersMasterDetails;
	}
	public List<DropDownList> getRoleList() {
		return roleList;
	}
	public void setRoleList(List<DropDownList> roleList) {
		this.roleList = roleList;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	
	
}
