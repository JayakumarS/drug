package com.drug.report;

import java.util.List;

public class ManufacturerBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<ManufacturerBean> manufacturerList;

	private String manufacturername;
	private String department;
	private String street; 
	private String city;
	private String state;	
	private String zipcode;
	
	
	public boolean isSuccess() {
		return Success;
	}
	public void setSuccess(boolean success) {
		Success = success;
	}
	public List<ManufacturerBean> getManufacturerList() {
		return manufacturerList;
	}
	public void setManufacturerList(List<ManufacturerBean> manufacturerList) {
		this.manufacturerList = manufacturerList;
	}
	public String getManufacturername() {
		return manufacturername;
	}
	public void setManufacturername(String manufacturername) {
		this.manufacturername = manufacturername;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	

	
	
	
}
