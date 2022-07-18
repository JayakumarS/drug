package com.drug.setup.companyMaster.DebitMemo;

import java.util.List;

import com.drug.core.util.DropDownList;

public interface DebitMemoDao {

	DebitMemoResultBean save(DebitMemoBean bean) throws Exception;

	List<DebitMemoBean> getDebitMemoList(DebitMemoBean bean) throws Exception;

	DebitMemoResultBean edit(String bean) throws Exception;

	DebitMemoResultBean delete(String bean) throws Exception;

	DebitMemoResultBean update(DebitMemoBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoDropdownList();

}
