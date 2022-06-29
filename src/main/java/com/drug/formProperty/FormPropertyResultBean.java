package com.drug.formProperty;

import java.util.List;
import java.util.Map;

public class FormPropertyResultBean {
	
	private String message;
	
	private List<FormPropertyBean> moduleLevelList;
	
	public void setSuccess(boolean b) {
		// TODO Auto-generated method stub
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<FormPropertyBean> getModuleLevelList() {
		return moduleLevelList;
	}
	public void setModuleLevelList(List<FormPropertyBean> moduleLevelList) {
		this.moduleLevelList = moduleLevelList;
	}
	
}
