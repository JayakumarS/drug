package com.drug.report;

import java.util.List;

public class ReportSearchResultBean {
	
	
private static final long serialVersionUID = 1L;
	
	public boolean success;


	private List<ReportSearchBean> reportSearchList;


	public boolean isSuccess() {
		return success;
	}


	public void setSuccess(boolean success) {
		this.success = success;
	}


	public List<ReportSearchBean> get() {
		return reportSearchList;
	}


	public void setReportSearchList(List<ReportSearchBean> reportSearchBean) {
		this.reportSearchList = reportSearchList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
