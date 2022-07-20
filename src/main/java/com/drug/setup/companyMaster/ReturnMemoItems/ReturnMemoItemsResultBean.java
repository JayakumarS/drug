package com.drug.setup.companyMaster.ReturnMemoItems;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;

public class ReturnMemoItemsResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	
	private ReturnMemoItemsBean returnMemoItems;
	
	private List<ReturnMemoItemsBean> listReturnMemoItems;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public ReturnMemoItemsBean getReturnMemoItems() {
		return returnMemoItems;
	}

	public void setReturnMemoItems(ReturnMemoItemsBean returnMemoItems) {
		this.returnMemoItems = returnMemoItems;
	}

	public List<ReturnMemoItemsBean> getListReturnMemoItems() {
		return listReturnMemoItems;
	}

	public void setListReturnMemoItems(List<ReturnMemoItemsBean> listReturnMemoItems) {
		this.listReturnMemoItems = listReturnMemoItems;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
