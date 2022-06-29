package com.drug.customerMaster;

import java.util.List;

public interface CustomerMasterService {

	CustomerMasterResultBean save(CustomerMasterBean bean) throws Exception;

	public List<CustomerMasterBean> getCustomerList() throws Exception;

	CustomerMasterResultBean edit(String code) throws Exception;

	CustomerMasterResultBean delete(String code) throws Exception;
	
	CustomerMasterResultBean update(CustomerMasterBean bean) throws Exception;

}