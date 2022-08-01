package com.drug.report;

import java.util.List;

public class SearchBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<SearchBean> searchList;

	
	public List<SearchBean> getSearchList() {
		return searchList;
	}
	public void setSearchList(List<SearchBean> searchList) {
		this.searchList = searchList;
	}
	
	
	private String company;
	private String companyId;
	private String companyName;
	private String returnMemoNo;
	private String returnMemoDate;
	private String ndcupcCode;
	private String description;
	private String isreturnable;
	private String strength;
	private String dosage;
	private String lotNo;
	private String pakageSize;
	private String expDate;
	private String fullQuantity;
	private String partialQuantity;
	private String price;
	private String estValue;
	private String manufacturername;
	private String returnMemoName;
	
	

	private String exportPDF;
	
	
	
	public String getReturnMemoName() {
		return returnMemoName;
	}
	public void setReturnMemoName(String returnMemoName) {
		this.returnMemoName = returnMemoName;
	}

	public String getManufacturername() {
		return manufacturername;
	}
	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}


	
	public String getExportPDF() {
		return exportPDF;
	}
	public void setExportPDF(String exportPDF) {
		this.exportPDF = exportPDF;
	}


	//for search
	private String startDate;
	private String endDate;

	private String controlClass;

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
	
	public String getIsreturnable() {
		return isreturnable;
	}
	public void setIsreturnable(String isreturnable) {
		this.isreturnable = isreturnable;
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
	public String getControlClass() {
		return controlClass;
	}
	public void setControlClass(String controlClass) {
		this.controlClass = controlClass;
	}



	
	

	
	

}
