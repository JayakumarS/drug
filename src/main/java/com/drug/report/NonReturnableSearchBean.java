package com.drug.report;

import java.util.List;

/**
 * @author PARAGON
 *
 */
/**
 * @author PARAGON
 *
 */
public class NonReturnableSearchBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<NonReturnableSearchBean> nonSearchList;

	
	public List<NonReturnableSearchBean> getNonSearchList() {
		return nonSearchList;
	}
	public void setNonSearchList(List<NonReturnableSearchBean> nonSearchList) {
		this.nonSearchList = nonSearchList;
	}
	
	
	private String company;
	private String companyId;
	private String companyName;
	private String returnMemoNo;
	private String returnMemoDate;
	private String ndcupcCode;
	private String description;
	private String isReturnable;
	private String strength;
	private String dosage;
	private String lotNo;
	private String pakageSize;
	private String expDate;
	private String fullQuantity;
	private String partialQuantity;
	private String price;
	private String estValue;
	
	//for search
	private String startDate;
	private String endDate;


	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getCompanyId() {
		return companyId;
	}
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getReturnMemoNo() {
		return returnMemoNo;
	}
	public void setReturnMemoNo(String returnMemoNo) {
		this.returnMemoNo = returnMemoNo;
	}
	public String getReturnMemoDate() {
		return returnMemoDate;
	}
	public void setReturnMemoDate(String returnMemoDate) {
		this.returnMemoDate = returnMemoDate;
	}
	public String getNdcupcCode() {
		return ndcupcCode;
	}
	public void setNdcupcCode(String ndcupcCode) {
		this.ndcupcCode = ndcupcCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIsReturnable() {
		return isReturnable;
	}
	public void setIsReturnable(String isReturnable) {
		this.isReturnable = isReturnable;
	}
	public String getStrength() {
		return strength;
	}
	public void setStrength(String strength) {
		this.strength = strength;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public String getPakageSize() {
		return pakageSize;
	}
	public void setPakageSize(String pakageSize) {
		this.pakageSize = pakageSize;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getFullQuantity() {
		return fullQuantity;
	}
	public void setFullQuantity(String fullQuantity) {
		this.fullQuantity = fullQuantity;
	}
	public String getPartialQuantity() {
		return partialQuantity;
	}
	public void setPartialQuantity(String partialQuantity) {
		this.partialQuantity = partialQuantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getEstValue() {
		return estValue;
	}
	public void setEstValue(String estValue) {
		this.estValue = estValue;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	

	
	

}



