package com.drug.manufacturerMaster;

public class ManufactureReturnPolicyBean {
	
	private String manufacturerCode;
	private String noMonthsBeforeExpiration;
	private String noMonthsAfterExpiration;
	private String acceptReturns;
	private String acceptPartialReturns;
	private String acceptpercentage;
	private String checkPackageOriginality;

	public String getManufacturerCode() {
		return manufacturerCode;
	}
	public void setManufacturerCode(String manufacturerCode) {
		this.manufacturerCode = manufacturerCode;
	}
	public String getNoMonthsBeforeExpiration() {
		return noMonthsBeforeExpiration;
	}
	public void setNoMonthsBeforeExpiration(String noMonthsBeforeExpiration) {
		this.noMonthsBeforeExpiration = noMonthsBeforeExpiration;
	}
	public String getNoMonthsAfterExpiration() {
		return noMonthsAfterExpiration;
	}
	public void setNoMonthsAfterExpiration(String noMonthsAfterExpiration) {
		this.noMonthsAfterExpiration = noMonthsAfterExpiration;
	}
	public String getAcceptReturns() {
		return acceptReturns;
	}
	public void setAcceptReturns(String acceptReturns) {
		this.acceptReturns = acceptReturns;
	}
	public String getAcceptPartialReturns() {
		return acceptPartialReturns;
	}
	public void setAcceptPartialReturns(String acceptPartialReturns) {
		this.acceptPartialReturns = acceptPartialReturns;
	}
	public String getAcceptpercentage() {
		return acceptpercentage;
	}
	public void setAcceptpercentage(String acceptpercentage) {
		this.acceptpercentage = acceptpercentage;
	}
	public String getCheckPackageOriginality() {
		return checkPackageOriginality;
	}
	public void setCheckPackageOriginality(String checkPackageOriginality) {
		this.checkPackageOriginality = checkPackageOriginality;
	}
	
	
}
