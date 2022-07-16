package com.drug.report.returnMemo;

import java.util.List;

public class CompleteReturnMemoDetails {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<CompleteReturnMemoDetails> memoDetails;
	
	
	private String returnMemo;
	private String ndcupcCode;
	private String pakageUnit;
	private String quanTity;
	private String priceRs;
	private String expDate;
	private String reasoNo;
	private String lotNo;
	
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public List<CompleteReturnMemoDetails> getMemoDetails() {
		return memoDetails;
	}
	public void setMemoDetails(List<CompleteReturnMemoDetails> memoDetails) {
		this.memoDetails = memoDetails;
	}
	public String getReturnMemo() {
		return returnMemo;
	}
	public void setReturnMemo(String returnMemo) {
		this.returnMemo = returnMemo;
	}
	public String getNdcupcCode() {
		return ndcupcCode;
	}
	public void setNdcupcCode(String ndcupcCode) {
		this.ndcupcCode = ndcupcCode;
	}
	public String getPakageUnit() {
		return pakageUnit;
	}
	public void setPakageUnit(String pakageUnit) {
		this.pakageUnit = pakageUnit;
	}
	public String getQuanTity() {
		return quanTity;
	}
	public void setQuanTity(String quanTity) {
		this.quanTity = quanTity;
	}
	public String getPriceRs() {
		return priceRs;
	}
	public void setPriceRs(String priceRs) {
		this.priceRs = priceRs;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getReasoNo() {
		return reasoNo;
	}
	public void setReasoNo(String reasoNo) {
		this.reasoNo = reasoNo;
	}
	public String getLotNo() {
		return lotNo;
	}
	public void setLotNo(String lotNo) {
		this.lotNo = lotNo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
		
	
	
	
	
	
	
	

}
