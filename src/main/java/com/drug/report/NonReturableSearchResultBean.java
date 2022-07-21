package com.drug.report;

import java.util.List;

public class NonReturableSearchResultBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean success;


	private List<NonReturnableSearchBean> nonListSearchBean;


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public List<NonReturnableSearchBean> getNonListSearchBean() {
		return nonListSearchBean;
	}


	public void setNonListSearchBean(List<NonReturnableSearchBean> nonListSearchBean) {
		this.nonListSearchBean = nonListSearchBean;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
