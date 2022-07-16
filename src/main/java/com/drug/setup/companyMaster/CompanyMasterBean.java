package com.drug.setup.companyMaster;



public class CompanyMasterBean {

	private String wholesalerCode;
	private String wholesalerPolicyCode;
	private String wholesalerName;
	private String wholesalerExpiryPacket;
	private String wholesalerEmailID;
	private String wholesalerAllowOverride;
	private String wholesalerDepartment;
	private String wholesalerStreet;
	private String wholesalerCity;
	private String wholesalerState;
	private String wholesalerZipCode;
	private String wholesalerPhoneNo;
	private String wholesalerTollFreeNo;
	private String wholesalerFax;
	private String wholesalerPhone;

    private String companyCode;
	private String companyName;
	private String companyDba;
	private String companyStreet;
	private String companyCity;
	private String companyState;
	private String companyPincode;
	private String companyPhone;
	private String companyFax;
	private String companyContact;
	private String companyEmailID;
	private String companyFacilityType;

	private String defNumber;
	private String defExpirationDate;
	private String authorizedClasses;
	
	private String issuesCreditsName;
	private String issuesCreditsStreet;
	private String issuesCreditsCity;
	private String issuesCreditsState;
	private String issuesCreditsZipCode;
	private String issuesCreditsPhone;

	private String generalInfroWacAwapMyprice;
	//con double to string
	private String generalInfroWacAwapPer="0";

	private Integer myWholesalerPolicyType;
	private Integer myWholesalerPolicyMonths=0;
	private boolean myWholesalerCpp;
	//con double to string
	private String cppServiceRate;
	//con double to string
	private String cppShippingRate;
	private Integer cppNoOfChecks;
	
	
	
	public String getWholesalerCode() {
		return wholesalerCode;
	}
	public void setWholesalerCode(String wholesalerCode) {
		this.wholesalerCode = wholesalerCode;
	}
	public String getWholesalerPolicyCode() {
		return wholesalerPolicyCode;
	}
	public void setWholesalerPolicyCode(String wholesalerPolicyCode) {
		this.wholesalerPolicyCode = wholesalerPolicyCode;
	}
	public String getWholesalerName() {
		return wholesalerName;
	}
	public void setWholesalerName(String wholesalerName) {
		this.wholesalerName = wholesalerName;
	}
	public String getWholesalerExpiryPacket() {
		return wholesalerExpiryPacket;
	}
	public void setWholesalerExpiryPacket(String wholesalerExpiryPacket) {
		this.wholesalerExpiryPacket = wholesalerExpiryPacket;
	}
	public String getWholesalerEmailID() {
		return wholesalerEmailID;
	}
	public void setWholesalerEmailID(String wholesalerEmailID) {
		this.wholesalerEmailID = wholesalerEmailID;
	}
	public String getWholesalerAllowOverride() {
		return wholesalerAllowOverride;
	}
	public void setWholesalerAllowOverride(String wholesalerAllowOverride) {
		this.wholesalerAllowOverride = wholesalerAllowOverride;
	}
	public String getWholesalerDepartment() {
		return wholesalerDepartment;
	}
	public void setWholesalerDepartment(String wholesalerDepartment) {
		this.wholesalerDepartment = wholesalerDepartment;
	}
	public String getWholesalerStreet() {
		return wholesalerStreet;
	}
	public void setWholesalerStreet(String wholesalerStreet) {
		this.wholesalerStreet = wholesalerStreet;
	}
	public String getWholesalerCity() {
		return wholesalerCity;
	}
	public void setWholesalerCity(String wholesalerCity) {
		this.wholesalerCity = wholesalerCity;
	}
	public String getWholesalerState() {
		return wholesalerState;
	}
	public void setWholesalerState(String wholesalerState) {
		this.wholesalerState = wholesalerState;
	}
	public String getWholesalerZipCode() {
		return wholesalerZipCode;
	}
	public void setWholesalerZipCode(String wholesalerZipCode) {
		this.wholesalerZipCode = wholesalerZipCode;
	}
	public String getWholesalerPhoneNo() {
		return wholesalerPhoneNo;
	}
	public void setWholesalerPhoneNo(String wholesalerPhoneNo) {
		this.wholesalerPhoneNo = wholesalerPhoneNo;
	}
	public String getWholesalerTollFreeNo() {
		return wholesalerTollFreeNo;
	}
	public void setWholesalerTollFreeNo(String wholesalerTollFreeNo) {
		this.wholesalerTollFreeNo = wholesalerTollFreeNo;
	}
	public String getWholesalerFax() {
		return wholesalerFax;
	}
	public void setWholesalerFax(String wholesalerFax) {
		this.wholesalerFax = wholesalerFax;
	}
	public String getWholesalerPhone() {
		return wholesalerPhone;
	}
	public void setWholesalerPhone(String wholesalerPhone) {
		this.wholesalerPhone = wholesalerPhone;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getCompanyDba() {
		return companyDba;
	}
	public void setCompanyDba(String companyDba) {
		this.companyDba = companyDba;
	}
	public String getCompanyStreet() {
		return companyStreet;
	}
	public void setCompanyStreet(String companyStreet) {
		this.companyStreet = companyStreet;
	}
	public String getCompanyCity() {
		return companyCity;
	}
	public void setCompanyCity(String companyCity) {
		this.companyCity = companyCity;
	}
	public String getCompanyState() {
		return companyState;
	}
	public void setCompanyState(String companyState) {
		this.companyState = companyState;
	}
	public String getCompanyPincode() {
		return companyPincode;
	}
	public void setCompanyPincode(String companyPincode) {
		this.companyPincode = companyPincode;
	}
	public String getCompanyPhone() {
		return companyPhone;
	}
	public void setCompanyPhone(String companyPhone) {
		this.companyPhone = companyPhone;
	}
	public String getCompanyFax() {
		return companyFax;
	}
	public void setCompanyFax(String companyFax) {
		this.companyFax = companyFax;
	}
	public String getCompanyContact() {
		return companyContact;
	}
	public void setCompanyContact(String companyContact) {
		this.companyContact = companyContact;
	}
	public String getCompanyEmailID() {
		return companyEmailID;
	}
	public void setCompanyEmailID(String companyEmailID) {
		this.companyEmailID = companyEmailID;
	}
	public String getCompanyFacilityType() {
		return companyFacilityType;
	}
	public void setCompanyFacilityType(String companyFacilityType) {
		this.companyFacilityType = companyFacilityType;
	}
	public String getDefNumber() {
		return defNumber;
	}
	public void setDefNumber(String defNumber) {
		this.defNumber = defNumber;
	}
	public String getDefExpirationDate() {
		return defExpirationDate;
	}
	public void setDefExpirationDate(String defExpirationDate) {
		this.defExpirationDate = defExpirationDate;
	}
	public String getAuthorizedClasses() {
		return authorizedClasses;
	}
	public void setAuthorizedClasses(String authorizedClasses) {
		this.authorizedClasses = authorizedClasses;
	}
	public String getIssuesCreditsName() {
		return issuesCreditsName;
	}
	public void setIssuesCreditsName(String issuesCreditsName) {
		this.issuesCreditsName = issuesCreditsName;
	}
	public String getIssuesCreditsStreet() {
		return issuesCreditsStreet;
	}
	public void setIssuesCreditsStreet(String issuesCreditsStreet) {
		this.issuesCreditsStreet = issuesCreditsStreet;
	}
	public String getIssuesCreditsCity() {
		return issuesCreditsCity;
	}
	public void setIssuesCreditsCity(String issuesCreditsCity) {
		this.issuesCreditsCity = issuesCreditsCity;
	}
	public String getIssuesCreditsState() {
		return issuesCreditsState;
	}
	public void setIssuesCreditsState(String issuesCreditsState) {
		this.issuesCreditsState = issuesCreditsState;
	}
	public String getIssuesCreditsZipCode() {
		return issuesCreditsZipCode;
	}
	public void setIssuesCreditsZipCode(String issuesCreditsZipCode) {
		this.issuesCreditsZipCode = issuesCreditsZipCode;
	}
	public String getIssuesCreditsPhone() {
		return issuesCreditsPhone;
	}
	public void setIssuesCreditsPhone(String issuesCreditsPhone) {
		this.issuesCreditsPhone = issuesCreditsPhone;
	}
	public String getGeneralInfroWacAwapMyprice() {
		return generalInfroWacAwapMyprice;
	}
	public void setGeneralInfroWacAwapMyprice(String generalInfroWacAwapMyprice) {
		this.generalInfroWacAwapMyprice = generalInfroWacAwapMyprice;
	}
	public String getGeneralInfroWacAwapPer() {
		return generalInfroWacAwapPer;
	}
	public void setGeneralInfroWacAwapPer(String generalInfroWacAwapPer) {
		this.generalInfroWacAwapPer = generalInfroWacAwapPer;
	}
	public Integer getMyWholesalerPolicyType() {
		return myWholesalerPolicyType;
	}
	public void setMyWholesalerPolicyType(Integer myWholesalerPolicyType) {
		this.myWholesalerPolicyType = myWholesalerPolicyType;
	}
	public Integer getMyWholesalerPolicyMonths() {
		return myWholesalerPolicyMonths;
	}
	public void setMyWholesalerPolicyMonths(Integer myWholesalerPolicyMonths) {
		this.myWholesalerPolicyMonths = myWholesalerPolicyMonths;
	}
	public boolean isMyWholesalerCpp() {
		return myWholesalerCpp;
	}
	public void setMyWholesalerCpp(boolean myWholesalerCpp) {
		this.myWholesalerCpp = myWholesalerCpp;
	}
	public String getCppServiceRate() {
		return cppServiceRate;
	}
	public void setCppServiceRate(String cppServiceRate) {
		this.cppServiceRate = cppServiceRate;
	}
	public String getCppShippingRate() {
		return cppShippingRate;
	}
	public void setCppShippingRate(String cppShippingRate) {
		this.cppShippingRate = cppShippingRate;
	}
	public Integer getCppNoOfChecks() {
		return cppNoOfChecks;
	}
	public void setCppNoOfChecks(Integer cppNoOfChecks) {
		this.cppNoOfChecks = cppNoOfChecks;
	}

	

}
