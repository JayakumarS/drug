package com.drug.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;


@Service
public class ControlledSubstanceServiceImpl implements ControlledSubstanceService{
	
	@Autowired
	ControlledSubsatanceDao controlledSubsatanceDao;

	
	@Override
	public List<ControlledSubstanceResultBean> getCompanyNameList() throws Exception {
		return controlledSubsatanceDao.getCompanyNameList();
	}

	@Override
	public List<ControlledSubstanceResultBean> getReturnMemoNo() throws Exception {
		return controlledSubsatanceDao.getReturnMemoNo();
	}
	

	
	@Override
	public SearchResultBean getSearchList(SearchBean bean) throws Exception {
		return controlledSubsatanceDao.getSearchList(bean);
	}
	
//	@Override
//	public List<SearchBean> getSearchList() throws Exception {
//		return controlledSubsatanceDao.getSearchList();
//	}

}
