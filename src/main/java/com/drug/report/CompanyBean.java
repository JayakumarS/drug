package com.drug.report;

import java.util.List;

public class CompanyBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<CompanyBean> companyList;
	
	private String id;
	private String text;
	private String department;
	private String street;
	private String city;
	private String state;
	private String zipCode;
	private String contactPerson;
	private String mailId;
	private String phoneNo;
	private String faxNo;
	private String deaNo;
	private String deaExpDate;
	private String authorisedClasses;
	private String facilityType;
	private String creditToName;
	private String creditToStreet;
	private String creditToCity;
	private String creditToState;
	private String creditToZipCode;
	private String creditToPhoneNo;
	private String returnPricing;
	private String returnPricingAwpPer;
	private String wholesalerWillOptions;
	private String wholesalerWillMonths;
	private String cppOption;
	private String cppServiceRatePer;
	private String cppCiiShipping;
	private String cppNoOFChecks;
	private String isActive;
	private String wholesaler;
	private String createdBy;
	private String modifiedBy;
	private String modifiedOn;
	
	
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public List<CompanyBean> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(List<CompanyBean> companyList) {
		this.companyList = companyList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getContactPerson() {
		return contactPerson;
	}
	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}
	public String getMailId() {
		return mailId;
	}
	public void setMailId(String mailId) {
		this.mailId = mailId;
	}
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFaxNo() {
		return faxNo;
	}
	public void setFaxNo(String faxNo) {
		this.faxNo = faxNo;
	}
	public String getDeaNo() {
		return deaNo;
	}
	public void setDeaNo(String deaNo) {
		this.deaNo = deaNo;
	}
	public String getDeaExpDate() {
		return deaExpDate;
	}
	public void setDeaExpDate(String deaExpDate) {
		this.deaExpDate = deaExpDate;
	}
	public String getAuthorisedClasses() {
		return authorisedClasses;
	}
	public void setAuthorisedClasses(String authorisedClasses) {
		this.authorisedClasses = authorisedClasses;
	}
	public String getFacilityType() {
		return facilityType;
	}
	public void setFacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getCreditToName() {
		return creditToName;
	}
	public void setCreditToName(String creditToName) {
		this.creditToName = creditToName;
	}
	public String getCreditToStreet() {
		return creditToStreet;
	}
	public void setCreditToStreet(String creditToStreet) {
		this.creditToStreet = creditToStreet;
	}
	public String getCreditToCity() {
		return creditToCity;
	}
	public void setCreditToCity(String creditToCity) {
		this.creditToCity = creditToCity;
	}
	public String getCreditToState() {
		return creditToState;
	}
	public void setCreditToState(String creditToState) {
		this.creditToState = creditToState;
	}
	public String getCreditToZipCode() {
		return creditToZipCode;
	}
	public void setCreditToZipCode(String creditToZipCode) {
		this.creditToZipCode = creditToZipCode;
	}
	public String getCreditToPhoneNo() {
		return creditToPhoneNo;
	}
	public void setCreditToPhoneNo(String creditToPhoneNo) {
		this.creditToPhoneNo = creditToPhoneNo;
	}
	public String getReturnPricing() {
		return returnPricing;
	}
	public void setReturnPricing(String returnPricing) {
		this.returnPricing = returnPricing;
	}
	public String getReturnPricingAwpPer() {
		return returnPricingAwpPer;
	}
	public void setReturnPricingAwpPer(String returnPricingAwpPer) {
		this.returnPricingAwpPer = returnPricingAwpPer;
	}
	public String getWholesalerWillOptions() {
		return wholesalerWillOptions;
	}
	public void setWholesalerWillOptions(String wholesalerWillOptions) {
		this.wholesalerWillOptions = wholesalerWillOptions;
	}
	public String getWholesalerWillMonths() {
		return wholesalerWillMonths;
	}
	public void setWholesalerWillMonths(String wholesalerWillMonths) {
		this.wholesalerWillMonths = wholesalerWillMonths;
	}
	public String getCppOption() {
		return cppOption;
	}
	public void setCppOption(String cppOption) {
		this.cppOption = cppOption;
	}
	public String getCppServiceRatePer() {
		return cppServiceRatePer;
	}
	public void setCppServiceRatePer(String cppServiceRatePer) {
		this.cppServiceRatePer = cppServiceRatePer;
	}
	public String getCppCiiShipping() {
		return cppCiiShipping;
	}
	public void setCppCiiShipping(String cppCiiShipping) {
		this.cppCiiShipping = cppCiiShipping;
	}
	public String getCppNoOFChecks() {
		return cppNoOFChecks;
	}
	public void setCppNoOFChecks(String cppNoOFChecks) {
		this.cppNoOFChecks = cppNoOFChecks;
	}
	public String getIsActive() {
		return isActive;
	}
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	public String getWholesaler() {
		return wholesaler;
	}
	public void setWholesaler(String wholesaler) {
		this.wholesaler = wholesaler;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public String getModifiedOn() {
		return modifiedOn;
	}
	public void setModifiedOn(String modifiedOn) {
		this.modifiedOn = modifiedOn;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	

	
	

}
