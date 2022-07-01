package com.drug.customerMaster;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerMasterBean {
	
	//private Integer
	private String companyCode;

	private String wholesalerAccount;
	private String wholesalerName;
	private String wholesalerContact;
	private String wholesalerDepartment;
	private String wholesalerStreet;
	private String wholesalerCity;

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

	private String authorisedClasses;
	private String issuesCreditsName;
	private String issuesCreditsStreet;
	private String issuesCreditsCity;
	private String issuesCreditsState;
	private String issuesCreditsZipCode;
	private String issuesCreditsPhone;

	private String generalInfroWacAwapMyprice;
	private Integer generalInfroWacAwapPer=0;

	private Integer myWholesalerPolicyType;
	private Integer myWholesalerPolicyMonths=0;
	private boolean myWholesalerCpp;
	private Integer cppServiceRate;
	private Integer cppShippingRate;
	private Integer cppNoOfChecks;

	

}
