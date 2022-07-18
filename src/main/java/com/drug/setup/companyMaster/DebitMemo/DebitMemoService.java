package com.drug.setup.companyMaster.DebitMemo;

import java.util.List;

import com.drug.core.util.DropDownList;

public interface DebitMemoService {

	DebitMemoResultBean save(DebitMemoBean bean) throws Exception;

	public List<DebitMemoBean> getDebitMemoList() throws Exception;

	DebitMemoResultBean edit(String code) throws Exception;

	DebitMemoResultBean delete(String code) throws Exception;
	
	DebitMemoResultBean update(DebitMemoBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoDropdownList();


}