package com.drug.customerMaster;

import java.util.List;

public interface CustomerMasterDao {

	CustomerMasterResultBean save(CustomerMasterBean bean) throws Exception;

	List<CustomerMasterBean> getCustomerList() throws Exception;

	CustomerMasterResultBean edit(String bean) throws Exception;

	CustomerMasterResultBean delete(String bean) throws Exception;

	CustomerMasterResultBean update(CustomerMasterBean bean) throws Exception;

}
