package com.drug.report;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ControlledSubstanceServiceImpl implements ControlledSubstanceService{
	
	@Autowired
	ControlledSubsatanceDao controlledSubsatanceDao;

	
	@Override
	public List<ControlledSubstanceResultBean> getCompanyNameList() throws Exception {
		return controlledSubsatanceDao.getCompanyNameList();
	}

}
