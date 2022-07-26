package com.drug.druginfoMaster;

import java.util.List;

import com.drug.core.util.DropDownList;
import com.drug.setup.users.UsersMasterBean;

public class DruginfoMasterResultBean {

private static final long serialVersionUID = 1L;
	
public boolean success;
private DruginfoMasterBean DrugInfoMasterBean;
private DruginfoReturnPolicyBean druginfoReturnPolicyBean;
private List<DruginfoMasterBean> listDrugInfoMasterBean;
private List<DropDownList> manufacturerList;

public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public DruginfoMasterBean getDrugInfoMasterBean() {
	return DrugInfoMasterBean;
}
public void setDrugInfoMasterBean(DruginfoMasterBean drugInfoMasterBean) {
	DrugInfoMasterBean = drugInfoMasterBean;
}
public List<DruginfoMasterBean> getListDrugInfoMasterBean() {
	return listDrugInfoMasterBean;
}
public void setListDrugInfoMasterBean(List<DruginfoMasterBean> listDrugInfoMasterBean) {
	this.listDrugInfoMasterBean = listDrugInfoMasterBean;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
public List<DropDownList> getManufacturerList() {
	return manufacturerList;
}
public void setManufacturerList(List<DropDownList> manufacturerList) {
	this.manufacturerList = manufacturerList;
}
public DruginfoReturnPolicyBean getDruginfoReturnPolicyBean() {
	return druginfoReturnPolicyBean;
}
public void setDruginfoReturnPolicyBean(DruginfoReturnPolicyBean druginfoReturnPolicyBean) {
	this.druginfoReturnPolicyBean = druginfoReturnPolicyBean;
}


	
}
