package com.drug.setup.companyMaster.ReturnMemoItems;

import java.util.List;

import com.drug.core.util.DropDownList;

public interface ReturnMemoItemsService {

	ReturnMemoItemsResultBean save(ReturnMemoItemsBean bean) throws Exception;

	public List<ReturnMemoItemsBean> getDebitMemoList() throws Exception;

	ReturnMemoItemsResultBean edit(String code) throws Exception;

	ReturnMemoItemsResultBean delete(String code) throws Exception;
	
	ReturnMemoItemsResultBean update(ReturnMemoItemsBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoDropdownList();


}