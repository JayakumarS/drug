package com.drug.report.returnMemo;

import java.util.List;

public class CompleteReturnMemoDetails {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<CompleteReturnMemoDetails> memoDetails;
	
	
	private String returnMemo;
	private String ndcupcCode;
	private String pakageUnit;
	private String quantity;
	
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
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
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
	private String price;	
	private String expDate;	
	private String reason;	 
	private String lotNo;	
	
	
	
	
	
	
	
	

}
