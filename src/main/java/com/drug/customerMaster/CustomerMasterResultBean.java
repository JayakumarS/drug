package com.drug.customerMaster;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;

public class CustomerMasterResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean Success;
	
	private CustomerMasterBean customerMasterBean;
	
	private List<CustomerMasterBean> customerMasterDetails;
	
	
	public final CustomerMasterBean getCustomerMasterBean() {
		return customerMasterBean;
	}

	public final void setCustomerMasterBean(CustomerMasterBean customerMasterBean) {
		this.customerMasterBean = customerMasterBean;
	}

	public boolean isSuccess() {
		return Success;
	}

	public void setSuccess(boolean success) {
		Success = success;
	}

	public List<CustomerMasterBean> getCustomerMasterDetails() {
		return customerMasterDetails;
	}

	public void setCustomerMasterDetails(List<CustomerMasterBean> customerMasterDetails) {
		this.customerMasterDetails = customerMasterDetails;
	}

	

	
	
}
