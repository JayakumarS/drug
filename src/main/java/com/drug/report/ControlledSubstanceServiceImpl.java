package com.drug.report;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.core.util.DropDownList;
import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;


@Service
public class ControlledSubstanceServiceImpl implements ControlledSubstanceService{
	
	@Autowired
	ControlledSubsatanceDao controlledSubsatanceDao;

	


	

	
	@Override
	public SearchResultBean getSearchList(SearchBean bean) throws Exception {
		return controlledSubsatanceDao.getSearchList(bean);
	}
	
	
	@Override
	public ReturnableResultBean getReturnSearchList(ReturableSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getReturnSearchList(bean);
	}
	
	
	@Override
	public NonReturableSearchResultBean getNonReturnSearchList(NonReturnableSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getNonReturnSearchList(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getReportII(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getReportII(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getReportIII_V(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getReportIII_V(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getInventory(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getInventory(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getPackingSlip(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getPackingSlip(bean);
	}
	
	
	@Override
	public List<ManufacturerBean> getManufacturerAddress(String manufacturercode) {
		return controlledSubsatanceDao.getManufacturerAddress(manufacturercode);
	}
	
	@Override
	public List<CompanyBean> getCompanyAddress(String companyId) {
		return controlledSubsatanceDao.getCompanyAddress(companyId);
	}
}
