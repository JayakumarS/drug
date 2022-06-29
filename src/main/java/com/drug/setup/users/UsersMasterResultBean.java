package com.drug.setup.users;

import java.io.Serializable;
import java.util.List;

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
