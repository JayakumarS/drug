package com.drug.customerMaster;

import java.util.Date;

import lombok.Data;

@Data
public class CustomerMasterBean {
	
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

	

}
