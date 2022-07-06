package com.drug.wholesaler;

import java.util.List;

import com.drug.core.util.DropDownList;
import com.drug.setup.users.UsersMasterBean;

public class WholesalerMasterResultBean {

private static final long serialVersionUID = 1L;
	
public boolean success;
private WholesalerMasterBean wholesalerMasterBean;
private List<WholesalerMasterBean> listWholesalerMasterBean;

	public boolean isSuccess() {
	return success;
}
public void setSuccess(boolean success) {
	this.success = success;
}
public WholesalerMasterBean getWholesalerMasterBean() {
	return wholesalerMasterBean;
}
public void setWholesalerMasterBean(WholesalerMasterBean wholesalerMasterBean) {
	this.wholesalerMasterBean = wholesalerMasterBean;
}
public List<WholesalerMasterBean> getListWholesalerMasterBean() {
	return listWholesalerMasterBean;
}
public void setListWholesalerMasterBean(List<WholesalerMasterBean> listWholesalerMasterBean) {
	this.listWholesalerMasterBean = listWholesalerMasterBean;
}
public static long getSerialversionuid() {
	return serialVersionUID;
}
	
	
}
