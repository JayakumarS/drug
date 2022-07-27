package com.drug.setup.users;
import java.util.List;
import java.util.Map;

public class UsersMasterBean {
	private List<Map<String,Object>> roles;
	
	private String newUserName;
	private String firstName;
	private String lastName;
	private String mobileNo;
	private String newPassword;
	private String confirmPassword;
	private String emailId;
	private String uploadImg;
//	private Integer roles;
	private String roleText;
	private String companyCode;
	private String empId;
	private String userName;

	private String imgUrl;
	
	private String firstNameLastName;
	// Change Password pop up beans

	
	private String roleName;
	
	// Change Password pop up beans

	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getUserName() {
		return userName;
	}
	public List<Map<String, Object>> getRoles() {
		return roles;
	}
	public void setRoles(List<Map<String, Object>> roles) {
		this.roles = roles;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	private String oldChangePassword;
	private String newChangePassword;
	private String confirmChangePassword;
	
	public String getNewChangePassword() {
		return newChangePassword;
	}
	public void setNewChangePassword(String newChangePassword) {
		this.newChangePassword = newChangePassword;
	}
	public String getConfirmChangePassword() {
		return confirmChangePassword;
	}
	public void setConfirmChangePassword(String confirmChangePassword) {
		this.confirmChangePassword = confirmChangePassword;

	}
	public String getRoleText() {
		return roleText;
	}
	public void setRoleText(String roleText) {
		this.roleText = roleText;
	}
	private String fileUploadUrl;
	
	//for roles dropdown
	private int id;
	private String text;
	
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
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
//	public Integer getRoles() {
//		return roles;
//	}
//	public void setRoles(Integer roles) {
//		this.roles = roles;
//	}
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
	public String getOldChangePassword() {
		return oldChangePassword;
	}
	public void setOldChangePassword(String oldChangePassword) {
		this.oldChangePassword = oldChangePassword;
	}
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getFirstNameLastName() {
		return firstNameLastName;
	}
	public void setFirstNameLastName(String firstNameLastName) {
		this.firstNameLastName = firstNameLastName;
	}
	
	
	

}
