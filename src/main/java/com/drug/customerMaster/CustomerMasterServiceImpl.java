package com.drug.customerMaster;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerMasterServiceImpl implements CustomerMasterService {
	@Autowired
	CustomerMasterDao customerMasterDao;

	@Override
	public CustomerMasterResultBean save(CustomerMasterBean bean) throws Exception {
		return customerMasterDao.save(bean);
	}

	@Override
	public List<CustomerMasterBean> getCustomerList() throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.getCustomerList();
	}

	@Override
	public CustomerMasterResultBean delete(String bean) throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.delete(bean);
	}

	@Override
	public CustomerMasterResultBean update(CustomerMasterBean bean) throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.update(bean);
	}

	@Override
	public CustomerMasterResultBean edit(String bean) throws Exception {
		// TODO Auto-generated method stub
		return customerMasterDao.edit(bean);
	}

	


	
}
