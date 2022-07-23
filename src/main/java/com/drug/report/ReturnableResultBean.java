package com.drug.report;

import java.util.List;

public class ReturnableResultBean {
	
private static final long serialVersionUID = 1L;
	
	public boolean success;


	private List<ReturableSearchBean> returnableSearchBean;


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public List<ReturableSearchBean> getReturnableSearchBean() {
		return returnableSearchBean;
	}


	public void setReturnableSearchBean(List<ReturableSearchBean> returnableSearchBean) {
		this.returnableSearchBean = returnableSearchBean;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
