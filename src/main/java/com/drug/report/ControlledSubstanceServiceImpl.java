package com.drug.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ControlledSubstanceServiceImpl implements ControlledSubstanceService{
	
	@Autowired
	ControlledSubsatanceDao controlledSubsatanceDao;

	
	@Override
	public SearchResultBean getSearchList(SearchBean bean) throws Exception {
		return controlledSubsatanceDao.getSearchList(bean);
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
