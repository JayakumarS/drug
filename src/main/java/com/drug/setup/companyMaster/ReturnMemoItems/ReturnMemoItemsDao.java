package com.drug.setup.companyMaster.ReturnMemoItems;

import java.util.List;

import com.drug.core.util.DropDownList;
import com.drug.core.util.ResultResponse;

public interface ReturnMemoItemsDao {

	ReturnMemoItemsResultBean save(ReturnMemoItemsBean bean) throws Exception;

	List<ReturnMemoItemsBean> getDebitMemoList(ReturnMemoItemsBean bean) throws Exception;

	ReturnMemoItemsResultBean edit(String bean) throws Exception;

	ReturnMemoItemsResultBean delete(String bean) throws Exception;

	ReturnMemoItemsResultBean update(ReturnMemoItemsBean bean) throws Exception;

	List<DropDownList> getCompanyMasterList();

	List<DropDownList> getDebitMemoDropdownList();

	ResultResponse fetchreturnMemoNamebyId(String bean);

	ResultResponse checkDrugIsReturnable(ReturnMemoItemsBean bean);

}
