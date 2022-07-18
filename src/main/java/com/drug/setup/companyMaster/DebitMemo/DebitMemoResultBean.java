package com.drug.setup.companyMaster.DebitMemo;

import java.io.Serializable;
import java.util.List;

import com.drug.core.util.BasicResultBean;

public class DebitMemoResultBean extends BasicResultBean implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public boolean success;
	
	private DebitMemoBean debitMemo;
	
	private List<DebitMemoBean> listDebitMemo;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	

	public DebitMemoBean getDebitMemo() {
		return debitMemo;
	}

	public void setDebitMemo(DebitMemoBean debitMemo) {
		this.debitMemo = debitMemo;
	}

	public List<DebitMemoBean> getListDebitMemo() {
		return listDebitMemo;
	}

	public void setListDebitMemo(List<DebitMemoBean> listDebitMemo) {
		this.listDebitMemo = listDebitMemo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	

	
}
