package com.drug.setup.companyMaster.ReturnMemoItems;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;

public class ReturnMemoItemsResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	
	private ReturnMemoItemsBean debitMemo;
	
	private List<ReturnMemoItemsBean> listDebitMemo;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	

	public ReturnMemoItemsBean getDebitMemo() {
		return debitMemo;
	}

	public void setDebitMemo(ReturnMemoItemsBean debitMemo) {
		this.debitMemo = debitMemo;
	}

	public List<ReturnMemoItemsBean> getListDebitMemo() {
		return listDebitMemo;
	}

	public void setListDebitMemo(List<ReturnMemoItemsBean> listDebitMemo) {
		this.listDebitMemo = listDebitMemo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	

	
}
