package com.drug.report;

import java.util.List;


public class ControlledSubstanceResultBean {

	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<ControlledSubstanceResultBean> companyNameList;
	
	
	private String id;
	private String text;
	
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


}
