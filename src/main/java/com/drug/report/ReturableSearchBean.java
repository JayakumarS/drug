package com.drug.report;

import java.util.List;

public class ReturableSearchBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<ReturableSearchBean> returnableList;

	
	public List<ReturableSearchBean> getReturnList() {
		return returnableList;
	}
	public void seReturnableList(List<ReturableSearchBean> returnableList) {
		this.returnableList = returnableList;
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

	//for search
	private String startDate;
	private String endDate;
	private String controlClass;

	private String exportPDF;

	
	
	
	public String getExportPDF() {
		return exportPDF;
	}
	public void setExportPDF(String exportPDF) {
		this.exportPDF = exportPDF;
	}
	public String getIsreturnable() {
		return isreturnable;
	}
	public void setIsreturnable(String isreturnable) {
		this.isreturnable = isreturnable;
	}
	public String getManufacturername() {
		return manufacturername;
	}
	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}
	public List<ReturableSearchBean> getReturnableList() {
		return returnableList;
	}
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public List<ReturableSearchBean> getReturnSearchList() {
		return returnableList;
	}
	public void setReturnableList(List<ReturableSearchBean> returnableList) {
		this.returnableList = returnableList;
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
