package com.drug.manufacturerMaster;

import java.util.List;

import com.drug.core.util.DropDownList;
import com.drug.setup.users.UsersMasterBean;

public class ManufacturerMasterResultBean {

private static final long serialVersionUID = 1L;
	
public boolean success;
private ManufacturerMasterBean manufacturerMasterBean;
private List<ManufacturerMasterBean> listmanufacturerMasterBean;

	public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public ManufacturerMasterBean getmanufacturerMasterBean() {
	return manufacturerMasterBean;
}
public void setmanufacturerMasterBean(ManufacturerMasterBean manufacturerMasterBean) {
	this.manufacturerMasterBean = manufacturerMasterBean;
}
public List<ManufacturerMasterBean> getListmanufacturerMasterBean() {
	return listmanufacturerMasterBean;
}
public void setListmanufacturerMasterBean(List<ManufacturerMasterBean> listmanufacturerMasterBean) {
	this.listmanufacturerMasterBean = listmanufacturerMasterBean;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	
	
}
