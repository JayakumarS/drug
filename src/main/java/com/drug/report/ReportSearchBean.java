package com.drug.report;

import java.util.List;

public class ReportSearchBean {
	
	
private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private List<ReportSearchBean> reportSearchList;

	
	public List<ReportSearchBean> getReportList() {
		return reportSearchList;
	}
	public void setReportSearchList(List<ReportSearchBean> reportSearchList) {
		this.reportSearchList = reportSearchList;
	}

}
