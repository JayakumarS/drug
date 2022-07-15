package com.drug.companyMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyMasterServiceImpl implements CompanyMasterService {
	@Autowired
	CompanyMasterDao companyMasterDao;

	@Override
	public CompanyMasterResultBean save(CompanyMasterBean bean) throws Exception {
		return companyMasterDao.save(bean);
	}

	@Override
	public List<CompanyMasterBean> getCompanyList() throws Exception {
		// TODO Auto-generated method stub
		return companyMasterDao.getCompanyList();
	}

	@Override
	public CompanyMasterResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return companyMasterDao.delete(bean);
	}

	@Override
	public CompanyMasterResultBean update(CompanyMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
		return companyMasterDao.update(bean);
	}

	@Override
	public CompanyMasterResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return companyMasterDao.edit(bean);
	}

	


	
}
