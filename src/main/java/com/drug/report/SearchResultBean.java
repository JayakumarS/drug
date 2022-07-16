package com.drug.report;

import java.util.List;


public class SearchResultBean {
	

private static final long serialVersionUID = 1L;
	
public boolean success;


private List<SearchBean> listSearchBean;


public boolean isSuccess() {
	return success;
}


public void setSuccess(boolean success) {
	this.success = success;
}


public List<SearchBean> getListSearchBean() {
	return listSearchBean;
}


public void setListSearchBean(List<SearchBean> listSearchBean) {
	this.listSearchBean = listSearchBean;
}


public static long getSerialversionuid() {
	return serialVersionUID;
}


}
