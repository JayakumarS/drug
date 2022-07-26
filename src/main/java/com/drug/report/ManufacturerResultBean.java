package com.drug.report;

import java.util.List;

public class ManufacturerResultBean {
	

private static final long serialVersionUID = 1L;
	
public boolean success;


private List<ManufacturerBean> manufacturerAddressList;


public boolean isSuccess() {
	return success;
}


public void setSuccess(boolean success) {
	this.success = success;
}


public List<ManufacturerBean> getManufacturerAddressList() {
	return manufacturerAddressList;
}


public void setManufacturerAddressList(List<ManufacturerBean> manufacturerAddressList) {
	this.manufacturerAddressList = manufacturerAddressList;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}



}
