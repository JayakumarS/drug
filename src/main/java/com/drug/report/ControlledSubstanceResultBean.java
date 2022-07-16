package com.drug.report;

import java.util.List;


public class ControlledSubstanceResultBean {

	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<ControlledSubstanceResultBean> companyNameList;
	private List<ControlledSubstanceResultBean> returnMemoNoList;

	
	private String id;
	private String text;
	private String no;
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public boolean isSuccess() {
		return Success;
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


	public void setSuccess(boolean success) {
		Success = success;
	}
	
	public List<ControlledSubstanceResultBean> getCompanyNameList() {
		return companyNameList;
	}

	public void setCompanyNameList(List<ControlledSubstanceResultBean> list) {
		this.companyNameList = list;
	}
	
	public List<ControlledSubstanceResultBean> getReturnMemoNo() {
		return returnMemoNoList;
	}

	public void setReturnMemoNo(List<ControlledSubstanceResultBean> list) {
		this.returnMemoNoList = list;
	}


}
