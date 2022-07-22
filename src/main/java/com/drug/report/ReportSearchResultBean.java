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


	public List<ReportSearchBean> getReportList() {
		return reportSearchList;
	}


	public void setreportSearchList(List<ReportSearchBean> reportSearchBean) {
		this.reportSearchList = reportSearchList;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


}
