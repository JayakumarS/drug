package com.drug.setup.users;

public class UsersMasterBean {
	
	private String newUserName;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String newPassword;
	private String confirmPassword;
	private String emailId;
	private String uploadImg;
	private Integer roles;
	private String roleText;
	private String companyCode;
	private String empId;
	
	public String getRoleText() {
		return roleText;
	}
	public void setRoleText(String roleText) {
		this.roleText = roleText;
	}
	private String fileUploadUrl;
	
	
	
	
	public String getNewUserName() {
		return newUserName;
	}
	public void setNewUserName(String newUserName) {
		this.newUserName = newUserName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getUploadImg() {
		return uploadImg;
	}
	public void setUploadImg(String uploadImg) {
		this.uploadImg = uploadImg;
	}
	public Integer getRoles() {
		return roles;
	}
	public void setRoles(Integer roles) {
		this.roles = roles;
	}
	public String getFileUploadUrl() {
		return fileUploadUrl;
	}
	public void setFileUploadUrl(String fileUploadUrl) {
		this.fileUploadUrl = fileUploadUrl;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
	

}
